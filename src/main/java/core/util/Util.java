package core.util;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import core.constants.Statuses;
import dao.entities.*;
import dao.entities.Currency;
import org.apache.logging.log4j.Logger;
import org.joda.time.Interval;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static core.util.CoreUtil.today;

public class Util {
    public static final String AES_SECRET = "05C02B85-685F-4282-BEDD-13C9D4C9AA9F";
    public static final String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String SIMPLE_DATE_PATTERN = "yyyy-MM-dd";
    public static final String DATABASE_DATE_PATTERN = "dd/MM/yyyy";
    public static final String T24_DATE_PATTERN = "yyyyMMdd";
    public static final String LAST_YEAR_DATE_PATTERN = "yy";
    public static final String TIMESTAMP_PATTERN = "yyyyMMddHHmmss";

    //Webservices
    public static final String STATUS_APP_ENDPOINT = "/status";
    public static final String ROLE_ENDPOINT = "/role";
    public static final String AUTH_ENDPOINT = "/auth";
    public static final String USER_INFO_ENDPOINT = "/info";
    public static final String DEPARTMENT_ENDPOINT = "/departments";
    public static final String USER_LOGOUT_ENDPOINT = "/logout";
    public static final String USER_ENDPOINT = "/list";
    public static final String USER_STATUS_ENDPOINT = "/status/update";
    public static final String USER_EDIT_ENDPOINT = "/edit";
    public static final String USER_CREATE_ENDPOINT = "/create";

    //Messages
    public static final String REPORT_DIR = "reports";
    public static final String QUOTATION_DIR = "quotations";
    public static final String TEMPLATE_DIR = "templates";
    public static final String EXPORT_DIR = "export";
    public static final String DOCUMENT_DIR = "documents";
    public static final String DEFAULT_CURRENCY = "MZN";
    public static final String DASHBOARD = "/dashboard";
    public static final String APP = "/app/v1";

    public static final String SUCCESS = "SUCCESS";
    public static final String FAILED = "FAILED";


    public static String getCoCode(String accountNumber){
        return "MZ0010"+accountNumber.substring(0,3);
    }



    public static String formatDouble(double numberToFormat){
        return String.format("%,.2f", numberToFormat);
    }




    public static String getSaltString(int len) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }


    public static Status setActive(){
        Status status = new Status();
        status.setId(Statuses.ACTIVE.toString());
        return status;
    }

    public static Status setPending(){
        Status status = new Status();
        status.setId(Statuses.PENDING.toString());
        return status;
    }
    public static SubProduct setSubProduct(Long subProductId){
        SubProduct subProduct = new SubProduct();
        subProduct.setSubProductId(subProductId);
        return subProduct;
    }

    public static BenefitCycle setBenefitCycle(Long benefitCycleId){
        BenefitCycle benefitCycle = new BenefitCycle();
        benefitCycle.setId(benefitCycleId);
        return benefitCycle;
    }
    public static Product setProduct(String productId){
        Product product = new Product();
        product.setProductId(productId);
        return product;
    }
    public static Frequency setFrequency(String f){
        Frequency frequency = new Frequency();
        frequency.setFrequencyId(f);
        return frequency;
    }

    public static IDType setIDType(String id){
        IDType idType = new IDType();
        idType.setIdType(id);
        return idType;
    }

    public static DocumentType setDocumentType(Long id){
        DocumentType documentType = new DocumentType();
        documentType.setId(id);
        return documentType;
    }

    public static Currency setCurrency(String id){
        Currency currency = new Currency();
        currency.setCurrencyId(id);
        return currency;
    }
    public static RelationShip setRelationShip(Long relationShipId){
        RelationShip relationShip = new RelationShip();
        relationShip.setRelationShipId(relationShipId);
        return relationShip;
    }

    public static Status setStatus(String statusId){
        Status status = new Status();
        status.setId(statusId);
        return status;
    }


    public static Industry setIndustry(String industryId){
        Industry industry = new Industry();
        industry.setIndustryId(industryId);
        return industry;
    }

    public static ProcessAction setProcessAction(String processActionId){
        ProcessAction processAction = new ProcessAction();
        processAction.setProcessActionId(processActionId);
        return processAction;
    }

    public static ProcessState setProcessState(String processStateId){
        ProcessState processState = new ProcessState();
        processState.setProcessStateId(processStateId);
        return processState;
    }
    public static ProductConfig setProductConfig(Long productConfigId){
        ProductConfig productConfig = new ProductConfig();
        productConfig.setProductConfigId(productConfigId);
        return productConfig;
    }

    public static InsurancePolicy setInsurancePolicy(String policyId){
        InsurancePolicy ip = new InsurancePolicy();
        ip.setPolicyId(policyId);
        return ip;
    }

    public static PolicyHolder setPolicyHolder(Long holderId){
        PolicyHolder ph = new PolicyHolder();
        ph.setId(holderId);
        return ph;
    }

    public static JobTitle setJobTitle(Long jobTitleId){
        JobTitle jt = new JobTitle();
        jt.setJobTitleId(jobTitleId);
        return jt;
    }

    public static Term setTerm(Long termId){
        Term term = new Term();
        term.setTermId(termId);
        return term;
    }
    public static String isNull(String s){
        try{
            if(s.equalsIgnoreCase("null"))
                return "";
            return s;
        }
        catch (Exception e){
            return "";
        }


    }

    public static boolean isPhoneNumberValid(String phone)
    {
        PhoneNumberUtil phoneUtil
                = PhoneNumberUtil.getInstance();
                 Phonenumber.PhoneNumber phoneNumber;

        try {
            phoneNumber = phoneUtil.parse(phone, "MZ");
        }
        catch (NumberParseException e) {
            return false;
        }

        return phoneUtil.isValidNumber(phoneNumber);
    }



    public static int getLastDayOfTheMonth(String date){

        LocalDate convertedDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(SIMPLE_DATE_PATTERN));
        convertedDate = convertedDate.withDayOfMonth(
                convertedDate.getMonth().length(convertedDate.isLeapYear()));
        return convertedDate.getDayOfMonth();
    }

    public static int getFirstDayOfTheMonth(String date){
        LocalDate convertedDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(SIMPLE_DATE_PATTERN));

        return convertedDate.with(TemporalAdjusters.firstDayOfMonth()).getDayOfMonth();
    }

    public static long getDateDiffInHours(Date d1, Date d2){
        long diff = d2.getTime() - d1.getTime();//as given

        return TimeUnit.MILLISECONDS.toHours(diff);
    }
    public static long getDateDiffDays(Date d1, Date d2){
        long diff = d2.getTime() - d1.getTime();//as given

        return TimeUnit.MILLISECONDS.toDays(diff);
    }

    public static String formatHours(long hours){
        if(hours>72){
            return formatDouble ((double) hours/24)+" dias";
        }
        else {
            return formatDouble((double)  hours)+" h";
        }

    }


    public static boolean isSameDate(Date today,Date futureDate){
       return today.equals(futureDate);
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static void getDelay(Logger logger,Date startDate,String logId){
        Interval interval = new Interval(startDate.getTime(), today().getTime());
        long delay = interval.toDurationMillis();
        if(delay>60000){
            logger.info("Request took {} m to process. traceId-> {}", round((double) delay/60000,2),logId);
        }
        else if(delay>1000) {
            logger.info("Request took {} s to process. traceId-> {}", round((double )delay/1000,2),logId);
        }
        else{
            logger.info("Request took {} ms to process. traceId-> {}", delay,logId);
        }

    }

    public static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }


    public static String getCurrentMonthInterval(String collectionDays) {

        if (collectionDays == null || collectionDays.trim().isEmpty()) {
            throw new IllegalArgumentException("Collection days cannot be empty");
        }

        int firstDay = Arrays.stream(collectionDays.split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .min()
                .getAsInt();

        LocalDate now = LocalDate.now();

        int lastDay = now.lengthOfMonth();
        int month = now.getMonthValue();
        int year = now.getYear();

        return String.format("%d - %02d/%02d/%d", firstDay, lastDay, month, year);
    }


    public static String getNextMonthInterval(String collectionDays) {

        if (collectionDays == null || collectionDays.trim().isEmpty()) {
            throw new IllegalArgumentException("Collection days cannot be empty");
        }

        int firstDay = Arrays.stream(collectionDays.split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .min()
                .getAsInt();

        LocalDate nextMonth = LocalDate.now().plusMonths(1);

        int lastDay = nextMonth.lengthOfMonth();
        int month = nextMonth.getMonthValue();
        int year = nextMonth.getYear();

        return String.format("%d - %02d/%02d/%d", firstDay, lastDay, month, year);
    }

    public static boolean isTodayCollectionDay(String collectionDays) {

        if (collectionDays == null || collectionDays.trim().isEmpty()) {
            return false;
        }

        int today = LocalDate.now().getDayOfMonth();

        return Arrays.stream(collectionDays.split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .anyMatch(day -> day == today);
    }

    public static boolean isEffectiveDateAfterCollectionPeriod(Date effectiveDate, List<Integer> collectionDays) {
        if (effectiveDate == null || collectionDays == null || collectionDays.isEmpty()) {
            throw new IllegalArgumentException("Invalid input");
        }
        int startDay = Collections.min(collectionDays);

        Calendar startDate = Calendar.getInstance();
        startDate.set(Calendar.DAY_OF_MONTH, startDay);
        resetTime(startDate);

        Calendar endDate = Calendar.getInstance();
        endDate.set(Calendar.DAY_OF_MONTH, endDate.getActualMaximum(Calendar.DAY_OF_MONTH));
        resetTime(endDate);

        Calendar effective = Calendar.getInstance();
        effective.setTime(effectiveDate);
        resetTime(effective);

        return effective.after(endDate);
    }

    private static void resetTime(Calendar cal) {
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
    }

    public static List<Integer> parseCollectionDays(String collectionDays) {
        if (collectionDays == null || collectionDays.trim().isEmpty()) {
            return Collections.emptyList();
        }

        return Arrays.stream(collectionDays.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static boolean isAfterCollectionPeriod(String collectionDays,Date date) {

        if (collectionDays == null || collectionDays.trim().isEmpty()) {
            throw new IllegalArgumentException("Collection days cannot be empty");
        }

        int firstCollectionDay = Arrays.stream(collectionDays.split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .min()
                .getAsInt();

        int today = date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate()
                .getDayOfMonth();

        return today >= firstCollectionDay;
    }

    public static boolean isAfterCollectionPeriod(String collectionDays) {

        if (collectionDays == null || collectionDays.trim().isEmpty()) {
            throw new IllegalArgumentException("Collection days cannot be empty");
        }

        int firstCollectionDay = Arrays.stream(collectionDays.split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .min()
                .getAsInt();

        int today = LocalDate.now().getDayOfMonth();

        return today >= firstCollectionDay;
    }


    public static String formatDate(Date date) {
        if (date == null) return null;

        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public static Date convertToDate(LocalDate localDate) {
        if (localDate == null) return null;

        return Date.from(
                localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()
        );
    }
}
