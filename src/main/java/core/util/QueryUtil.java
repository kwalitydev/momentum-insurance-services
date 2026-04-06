package core.util;


import core.constants.Statuses;
import core.threads.PostLog;
import dao.BeanFactory;
import dao.entities.*;
import dao.interfaces.*;
import dao.repositories.PaymentLogRepository;
import dao.repositories.PaymentScheduleRepository;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.Callable;

import static core.constants.ProcessActions.CANCEL;
import static core.util.CoreUtil.*;
import static core.util.Util.*;

@ApplicationScoped
public class QueryUtil {

    @Inject
    private DocumentFileInterface documentFileInterface;
    @Resource(name = "java:comp/DefaultManagedExecutorService")
    private ManagedExecutorService executorService;
    @Inject
    private NotificationTypeInterface notificationTypeInterface;
    @Inject
    private PostLog postLog;
    @Inject
    private PaymentScheduleRepository paymentScheduleInterface;
    @Inject
    private PaymentLogRepository paymentLogInterface;
    @Inject
    private CollectionLogInterface collectionLogInterface;
    @Inject
    private TaskInterface taskInterface;
    @Inject
    private InsurancePolicyInterface insurancePolicyInterface;
    @Inject
    private ProductInterface productInterface;

    @Inject
    private NotificationInterface notificationInterface;
    @Inject
    private BeanFactory beanFactory;
    @Inject
    private BeneficiariesInterface beneficiariesInterface;
    @Inject
    private ErrorLogInterface errorLogInterface;
    @Inject
    private SubProductInterface subProductInterface;
    @Inject
    private CurrencyInterface currencyInterface;
    @Inject
    private PolicyHolderInterface policyHolderInterface;

    private static final Logger LOGGER = LogManager.getLogger(QueryUtil.class);


    public void saveLog(WebserviceRequest webserviceRequest){
        Callable<String> callable = () -> postLog.apply(webserviceRequest);
        executorService.submit(callable);

    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public DocumentFile saveDocumentFile(DocumentFile documentFile) {
       // return documentFileInterface.save(documentFile);
        return beanFactory.merge(documentFile);
    }

    @Transactional
    public int updateDocumentFile(String url,String objectId,String recordType) {
        return documentFileInterface.updateDocumentUrl(url,objectId,recordType);
    }

    public String getNotificationBody(String notificationType){
        Optional<NotificationType> nt = notificationTypeInterface.findById(notificationType);
        if(nt.isPresent()){
            if(nt.get().getEnabled()){

                return nt.get().getDefaultMessage();
            }
            else {
            LOGGER.info("{} is not enabled",notificationType);
                return "";
            }
        }
        else {
            LOGGER.info("{} is not set",notificationType);
            return "";
        }
    }


    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public PaymentSchedule postPaymentScheduleSave(PaymentSchedule paymentSchedule,String traceId){
        PaymentSchedule savedPaymentSchedule = paymentScheduleInterface.saveAndFlush(paymentSchedule);
        LOGGER.info("PaymentSchedule saved {}. traceId -> {}",paymentSchedule.getPaymentScheduleId(),traceId);
        return savedPaymentSchedule;
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public PaymentLog postPaymentLog(PaymentLog paymentLog){
        PaymentLog savePaymentLog = paymentLogInterface.saveAndFlush(paymentLog);
        LOGGER.info("PaymentLog saved {}",savePaymentLog.getPaymentLogId());
        return paymentLog;
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public int updatePayment(BigDecimal paidAmount, Status status,String chargeCode,String transactionId,Long paymentScheduleId,Boolean normal){
        return  paymentScheduleInterface.updatePayment(
                paidAmount,today(),
                status,chargeCode,transactionId,normal,paymentScheduleId);

    }
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void postCollectionLog(CollectionLog collectionLog,String logId){
        collectionLogInterface.save(collectionLog);
        LOGGER.info("CollectionLog saved. Id -> {}. traceId -> {}",collectionLog.getId(),logId);
    }



    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public int updateNextRunDate(String taskId,int poolInterval){
        return taskInterface.updateTaskNextRunDate(taskId,getDatePlus(today(),poolInterval, Calendar.SECOND));

    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public int cancelPolicy(String policy){
        return insurancePolicyInterface.cancelPolicy(today(),
                setStatus(Statuses.CANCELLED.toString()), getSystemUser().getUserId(), policy);

    }

    @Transactional
    public Notification postNotification(Notification notification){
        return notificationInterface.save(notification);

    }


    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public Claim postClaimSave(Claim claim){
        return beanFactory.merge(claim);

    }

    public boolean isTaskEnabled(String taskId) {
        Optional<TaskConfig> tasks = taskInterface.getTasks(taskId);
        return tasks.map(TaskConfig::isEnabled).orElse(false);
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public int updateBen(Long ben){
     return  beneficiariesInterface.updateBeneficiary(today(),
                getSystemUser().getUserId(),
                setStatus(Statuses.INACTIVE.toString()),
                ben);
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ErrorLog postErrorLog(ErrorLog errorLog){
        return beanFactory.merge(errorLog);

    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void postRemoveErrorLog(String errorLogId){
        errorLogInterface.removeErrorLog(errorLogId);
        LOGGER.info("ErrorLog removed {}",errorLogId);

    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void postSavePolicyHistory(InsurancePolicy ip,String comments,String user,String processNumber,String narrative,String departmentId,String traceId){

        InsurancePolicyHistory insurancePolicyHistory = new InsurancePolicyHistory();
        insurancePolicyHistory.setInsurancePolicy(ip);
        insurancePolicyHistory.setChangeDescription(comments);
        insurancePolicyHistory.setCreatedDate(today());
        insurancePolicyHistory.setUsers(setUser(user));
        insurancePolicyHistory.setProcessAction(setProcessAction(CANCEL.toString()));
        insurancePolicyHistory.setProcessId(processNumber);
        insurancePolicyHistory.setNarrative(narrative);

        Department department = new Department();
        if(departmentId!=null){
        department.setId(departmentId);
        insurancePolicyHistory.setDepartment(department);
        }

        InsurancePolicyHistory insurancePolicyHistorySaved = beanFactory.merge(insurancePolicyHistory);

        LOGGER.info("InsurancePolicyHistory saved {}. traceId -> {}", insurancePolicyHistorySaved.getIphId(),traceId);
    }


}
