package dao.interfaces;


import core.beans.*;
import core.util.AES;
import core.util.CoreUtil;
import dao.entities.*;
import dao.enums.UserStatus;
import dao.repositories.*;
import javax.transaction.Transactional;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;

import java.util.*;
import java.util.stream.Collectors;

import static core.util.CoreUtil.buildException;

@ApplicationScoped
public class AuthService {

    @Inject
   private UserRepository usersRepository;

    @Inject
    private  StatusRepository statusRepository;
    @Inject
    private  UserDetailsRepository userDetailsRepository;
    @Inject
    private  RoleMenuRepository roleMenuRepository;
    @Inject
    private  SubMenuRepository subMenuRepository;

    @Inject
    private MenuRepository menuRepository;

    @Transactional
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