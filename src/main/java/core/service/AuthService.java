package core.service;


import core.beans.*;
import core.exception.BusinessException;
import core.mapper.MapperUtils;
import core.util.AES;
import core.util.CoreUtil;
import core.util.RequestUtil;
import core.util.Util;
import dao.entities.*;
import dao.enums.UserStatus;
import dao.interfaces.ApplicationInterface;
import dao.repositories.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static core.util.CoreUtil.buildException;

@ApplicationScoped
public class AuthService {
    private static final Logger logger = LogManager.getLogger(AuthService.class);

    @Inject
    private UserRepository usersRepository;

    @Inject
    private ITokenService tokenService;

    @Inject
    private InsurancePolicyRepository insurancePolicyRepository;

    @Inject
    private StatusRepository statusRepository;
    @Inject
    private UserDetailsRepository userDetailsRepository;
    @Inject
    private RoleMenuRepository roleMenuRepository;
    @Inject
    private SubMenuRepository subMenuRepository;

    @Inject
    private MenuRepository menuRepository;

    @Inject
    private BeneficiariesRepository beneficiariesRepository;
    @Inject
    private ApplicationInterface applicationInterface;



    public LoginResponseDTO authenticate(String username, String password) {

        Users user = usersRepository.findByUserByUserID(username)
                .orElseThrow(() -> buildException("Utilizador não encontrado.", 404));

        validateUser(password, user);

        UserDetails details = userDetailsRepository.findByUser(user).orElse(null);

        LoginResponseDTO.LoginResponseDTOBuilder builder = LoginResponseDTO.builder()
                .roleId(user.getIdRole())
                .menus(new ArrayList<>())
                .department(user.getDepartment().getDescription());

        if (details != null) {
            builder.fullName(details.getFullName())
                    .surname(details.getSurname());
        }

        if (!isDeactivated(user)) {

            List<RoleMenu> roleMenus = roleMenuRepository.findByUserId(user.getIdRole());

            List<Integer> menuIds = roleMenus.stream()
                    .map(RoleMenu::getIdMenu)
                    .distinct()
                    .collect(Collectors.toList());

            List<Submenu> allSubmenus = subMenuRepository.findSubMenus(menuIds);
            Map<Integer, List<SubMenuDTO>> submenusByMenu = allSubmenus.stream()
                    .collect(Collectors.groupingBy(
                            Submenu::getIdMenu,
                            Collectors.mapping(sub -> SubMenuDTO.builder()
                                            .id(sub.getId())
                                            .description(sub.getDescription())
                                            .defaultPage(sub.getDefaultPage())
                                            .build(),
                                    Collectors.toList())
                    ));

            Map<Integer, Menu> menuMap = menuRepository.findAllById(menuIds)
                    .stream()
                    .collect(Collectors.toMap(Menu::getId, m -> m));

            List<MenuDTO> menus = roleMenus.stream()
                    .map(rm -> {
                        Menu menu = menuMap.get(rm.getIdMenu());

                        return MenuDTO.builder()
                                .id(rm.getIdMenu())
                                .description(menu.getDescription())
                                .defaultPage(menu.getDefaultPage())
                                .order(menu.getMenuOrder())
                                .submenus(submenusByMenu.getOrDefault(rm.getIdMenu(), Collections.emptyList()))
                                .build();
                    })
                    .sorted(Comparator.comparing(MenuDTO::getOrder))
                    .collect(Collectors.toList());

            builder.menus(menus);
        }

        return builder.build();
    }

    @Transactional
    public ActivationResponseDTO activate(String username, String password) {

        Users user = usersRepository.findByUserByUserID(username)
                .orElseThrow(() -> buildException("User not found", 404));

        if (!AES.encrypt(password).equals(user.getUserKey())) {
            throw buildException("Invalid password", 401);
        }

        UserDetails details = userDetailsRepository.findByUser(user)
                .orElseThrow(() -> buildException("User details not found", 404));

        Status status = statusRepository
                .findByDescriptionAndStatusType("ACTIVO", "USER");

        if (status == null) {
            throw buildException("ACTIVE status not configured in DB", 500);
        }

        user.setStatus(status);
        user.setLastUpdated(CoreUtil.today());

        usersRepository.save(user);

        return ActivationResponseDTO.builder()
                .fullName(details.getFullName())
                .surname(details.getSurname())
                .mobile(details.getMobile())
                .roleId(user.getUserId())
                .department(user.getDepartment() != null
                        ? user.getDepartment().getDescription()
                        : null)
                .status(status.getDescription())
                .build();
    }

    @Transactional
    public ActivationResponseDTO updatePasswordAndActivate(String username, String newPassword) {

        Users user = usersRepository.findByUserByUserID(username)
                .orElseThrow(() -> buildException("User not found", 404));

        UserDetails details = userDetailsRepository.findByUser(user)
                .orElseThrow(() -> buildException("UserDetails missing in DB", 500));

        Status activeStatus = statusRepository
                .findByDescriptionAndStatusType("ACTIVO", "USER");

        if (activeStatus == null) {
            throw buildException("ACTIVE status missing in DB", 500);
        }

        String encryptedPassword = AES.encrypt(newPassword);

        user.setUserKey(encryptedPassword);
        user.setStatus(activeStatus);
        user.setLastUpdated(CoreUtil.today());

        usersRepository.save(user);

        return ActivationResponseDTO.builder()
                .fullName(details.getFullName())
                .surname(details.getSurname())
                .mobile(details.getMobile())
                .roleId(user.getIdRole())
                .department(user.getDepartment() != null
                        ? user.getDepartment().getDescription()
                        : null)
                .status(activeStatus.getDescription())
                .build();
    }

    public Long login(String policyNumber, String phoneNumber) {

        logger.info(" Attempt to login by policyNumber : {}, phoneNumber :{}", policyNumber, phoneNumber);
        String generated5DigitOtp = CoreUtil.generate5DigitOtp();

        InsurancePolicy insurancePolicy = this.insurancePolicyRepository
                .findByPolicyIdAndPolicyHolderMobileNumber(policyNumber, phoneNumber);

        if (insurancePolicy == null) {
            throw buildException("Policy not found", 404);
        }
        LocalDateTime plussedMinutes = LocalDateTime.now().plusMinutes(15);

        Token token = this.tokenService
                .findFirstByInsurancePolicyAndIsUsedFalseOrderByExpiryDateDesc(insurancePolicy)
                .orElse(null);

        if (token == null) {
            token = Token.builder()
                    .token(generated5DigitOtp)
                    .expiryDate(plussedMinutes)
                    .isUsed(false)
                    .insurancePolicy(insurancePolicy)
                    .lastUpdated(LocalDateTime.now())
                    .build();
        } else {
            token.setExpiryDate(plussedMinutes);
            token.setToken(generated5DigitOtp);

        }
        this.tokenService.saveToken(token);
// send sms
        return token.getId();
    }

    public PolicyDetailsDTO appAuthenticate(AuthAppRequest authAppRequest) {
        String method = "appAuthenticate";

        logger.info(" {} , Attempt to do OTP authentication requestBody: {}",method, CoreUtil.toJson(authAppRequest));

        Token token = this.tokenService.fetchByTokenId(authAppRequest.getTokenId())
                .orElseThrow(() -> buildException("Token not found", 404));

        if (token.getExpiryDate().isBefore(LocalDateTime.now())) {
            throw buildException("Expired token", 401);
        }
        if (!token.getToken().equalsIgnoreCase(authAppRequest.getOtpCode())) {
            throw buildException("Invalid Token", 401);
        }

        if (token.getIsUsed()) {
            throw buildException("Token already used", 401);
        }
        this.tokenService.markAsUsed(token.getId());
        logger.info(" OTP authentication successful for TokenId: {}", token.getId());

        InsurancePolicy insurancePolicy = token.getInsurancePolicy();

        List<Beneficiaries> beneficiariesList =
                beneficiariesRepository.findByInsurancePolicyId(insurancePolicy.getInsurancePolicyId());

        List<BeneficiaryDTO> beneficiaries = beneficiariesList.stream()
                .map(b -> BeneficiaryDTO.builder()
                        .name(b.getName())
                        .totalCharge(b.getTotalCharge())
                        .status(b.getStatus().getDescription())
                        .description(b.getRelationShip().getDescription())
                        .dateOfBirth(Util.formatDate(b.getDateOfBirth()))
                        .build()
                )
                .collect(Collectors.toList());


        PolicyDetailsDTO policyDetailsDTO;
        Optional<Application> application = applicationInterface.findByAppId(RequestUtil.APP_ID);
        if(application.isPresent()) {

            policyDetailsDTO = MapperUtils
                    .mapToPolicyDetailsDTO(insurancePolicy, beneficiaries,application.get().getCollectionDays());

            logger.info("{} - Successfully built PolicyDetailsDTO for policyId: {}",
                    method, insurancePolicy.getInsurancePolicyId());
        } else {
            logger.error("{} - Application with appId {} not found", method, RequestUtil.APP_ID);

            throw new BusinessException(
                    Response.Status.NOT_FOUND.getStatusCode(),
                    "Application not found for appId: " + RequestUtil.APP_ID
            );
        }

        logger.info("{} - Successfully built PolicyDetailsDTO for policyId: {}",
                method, insurancePolicy.getInsurancePolicyId());

        logger.info("{} - Successful retrieved: {}", method, policyDetailsDTO.toString());


        return policyDetailsDTO;
    }


    private boolean isDeactivated(Users user) {
        return user.getStatus() != null
               && UserStatus.DEACTIVATED.name()
                       .equalsIgnoreCase(user.getStatus().getId());
    }

    private static void validateUser(String password, Users user) {

        if (!user.getUserKey().equals(AES.encrypt(password))) {
            throw buildException("Senha incorreta!", 401);
        }

        if (UserStatus.DEACTIVATED.name()
                .equalsIgnoreCase(user.getStatus().getDescription())) {
            throw buildException("Utilizador inactivo.", 403);
        }

        if (UserStatus.LOCKED.name()
                .equalsIgnoreCase(user.getStatus().getDescription())) {
            throw buildException("Utilizador bloqueado.", 403);
        }
    }
}