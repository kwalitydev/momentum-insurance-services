package core.beans;

import dao.entities.InsurancePolicy;
import dao.entities.PaymentSchedule;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class CollectContext {
    private InsurancePolicy insurancePolicy;
    private List<String> coreErrors;
    private PaymentSchedule ps;
    private boolean notifyUnpaid;
    private boolean normalPayment;
    private boolean isNew;
    private Long paymentScheduleId;
    private String logId;
    private String endTime;
    private boolean updatePaymentDate;
    private Date nextPaymentDate;
    private String errorLogId;
    private String accountNumber;
    private String mobileNumber;
    private String suspenseAccount;
    private String defaultBranch;
    private String[] chargePeriodArray;
    private String taskProduct;


    public InsurancePolicy getInsurancePolicy() {
        return insurancePolicy;
    }

    public void setInsurancePolicy(InsurancePolicy insurancePolicy) {
        this.insurancePolicy = insurancePolicy;
    }

    public List<String> getCoreErrors() {
        return coreErrors;
    }

    public void setCoreErrors(List<String> coreErrors) {
        this.coreErrors = coreErrors;
    }

    public PaymentSchedule getPs() {
        return ps;
    }

    public void setPs(PaymentSchedule ps) {
        this.ps = ps;
    }

    public boolean isNotifyUnpaid() {
        return notifyUnpaid;
    }

    public void setNotifyUnpaid(boolean notifyUnpaid) {
        this.notifyUnpaid = notifyUnpaid;
    }

    public boolean isNormalPayment() {
        return normalPayment;
    }

    public void setNormalPayment(boolean normalPayment) {
        this.normalPayment = normalPayment;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public Long getPaymentScheduleId() {
        return paymentScheduleId;
    }

    public void setPaymentScheduleId(Long paymentScheduleId) {
        this.paymentScheduleId = paymentScheduleId;
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public boolean isUpdatePaymentDate() {
        return updatePaymentDate;
    }

    public void setUpdatePaymentDate(boolean updatePaymentDate) {
        this.updatePaymentDate = updatePaymentDate;
    }

    public Date getNextPaymentDate() {
        return nextPaymentDate;
    }

    public void setNextPaymentDate(Date nextPaymentDate) {
        this.nextPaymentDate = nextPaymentDate;
    }

    public String getErrorLogId() {
        return errorLogId;
    }

    public void setErrorLogId(String errorLogId) {
        this.errorLogId = errorLogId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getSuspenseAccount() {
        return suspenseAccount;
    }

    public void setSuspenseAccount(String suspenseAccount) {
        this.suspenseAccount = suspenseAccount;
    }

    public String getDefaultBranch() {
        return defaultBranch;
    }

    public void setDefaultBranch(String defaultBranch) {
        this.defaultBranch = defaultBranch;
    }

    public String[] getChargePeriodArray() {
        return chargePeriodArray;
    }

    public void setChargePeriodArray(String[] chargePeriodArray) {
        this.chargePeriodArray = chargePeriodArray;
    }

    public String getTaskProduct() {
        return taskProduct;
    }

    public void setTaskProduct(String taskProduct) {
        this.taskProduct = taskProduct;
    }

    @Override
    public String toString() {
        return "CollectContext{" +
                "insurancePolicy=" + insurancePolicy +
                ", coreErrors=" + coreErrors +
                ", ps=" + ps +
                ", notifyUnpaid=" + notifyUnpaid +
                ", normalPayment=" + normalPayment +
                ", isNew=" + isNew +
                ", paymentScheduleId=" + paymentScheduleId +
                ", logId='" + logId + '\'' +
                ", endTime='" + endTime + '\'' +
                ", updatePaymentDate=" + updatePaymentDate +
                ", nextPaymentDate=" + nextPaymentDate +
                ", errorLogId='" + errorLogId + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", suspenseAccount='" + suspenseAccount + '\'' +
                ", defaultBranch='" + defaultBranch + '\'' +
                ", chargePeriodArray=" + Arrays.toString(chargePeriodArray) +
                ", taskProduct='" + taskProduct + '\'' +
                '}';
    }
}
