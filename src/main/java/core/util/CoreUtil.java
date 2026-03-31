package core.util;

import core.constants.RecordTypes;
import dao.entities.*;
import org.apache.logging.log4j.Logger;
import org.joda.time.Interval;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

import static core.util.RequestUtil.OVERRIDE_LIST;
import static core.util.Util.*;


public class CoreUtil {

    private static final AtomicLong LAST_TIME_MS = new AtomicLong();

    public static String getLogId(){
        return UUID.randomUUID().toString().toUpperCase();
    }

    public static Date today(){
        return new Date();
    }


    public static Date stringToDateTime(String dateString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(DATETIME_PATTERN);
        return formatter.parse(dateString);
    }

    public static Date stringToDate(String dateString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(SIMPLE_DATE_PATTERN);
        return formatter.parse(dateString);
    }

    public static Date stringToDate(String dateString,String dateFormat) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        return formatter.parse(dateString);
    }

    public static Date getDatePlus(Date date, int difference, int period) {

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(period, difference);
        date = c.getTime();
        return date;
    }

    public static String formatDate(Date date,String pattern){

        try {
            return new SimpleDateFormat(pattern).format(date);
        }
        catch (Exception e){
            return null;
        }
    }

    public static Users setUser(String userId){
        Users users = new Users();
        users.setUserId(userId);
        return users;
    }


    public static NotificationType setNotificationType(String notificationType){
       NotificationType nt = new NotificationType();
       nt.setId(notificationType);
        return nt;
    }


    public static Users getSystemUser(){
        return setUser("system");
    }



    public static WebserviceRequest setWebserviceLog(String requestId, Date requestTime, String userId, String methodName,
                                                     int responseStatus, boolean queryExecuted, String requestMethod,
                                                     String errorCause, String sessionId,String ipAddress){

        return setWebserviceLogParams(requestId, requestTime, userId, methodName, responseStatus, queryExecuted, requestMethod, errorCause, sessionId, ipAddress);

    }

    public static WebserviceRequest setWebserviceLog(String requestId, Date requestTime, String userId, String methodName,
                                                     int responseStatus, boolean queryExecuted, String requestMethod,
                                                     String errorCause, String sessionId,String ipAddress,boolean internal,
                                                     String friendlyName,String payload){
        WebserviceRequest webserviceRequest = setWebserviceLogParams(requestId, requestTime, userId, methodName, responseStatus, queryExecuted, requestMethod, errorCause, sessionId, ipAddress);

        webserviceRequest.setInternal(internal);
        webserviceRequest.setFriendlyName(friendlyName);
        webserviceRequest.setPayloadDetails(payload);

        return webserviceRequest;

    }

    private static WebserviceRequest setWebserviceLogParams(String requestId, Date requestTime, String userId, String methodName, int responseStatus, boolean queryExecuted, String requestMethod, String errorCause, String sessionId, String ipAddress) {
        WebserviceRequest webserviceRequest = new WebserviceRequest();
        webserviceRequest.setRequestId(requestId);
        Interval interval = new Interval(requestTime.getTime(), today().getTime());
        long delay = interval.toDurationMillis();

        webserviceRequest.setRequestId(requestId);
        webserviceRequest.setUserRequested(CoreUtil.setUser(userId));
        webserviceRequest.setMethodName(methodName);
        webserviceRequest.setRequestTime(requestTime);
        webserviceRequest.setResponseTime(today());
        webserviceRequest.setDelay(delay);
        webserviceRequest.setResponseStatus(String.valueOf(responseStatus));
        webserviceRequest.setQueryExecuted(queryExecuted);
        webserviceRequest.setRequestMethod(requestMethod);
        webserviceRequest.setErrorCause(errorCause);
        webserviceRequest.setSessionId(sessionId);
        webserviceRequest.setIpAddress(ipAddress);
        return webserviceRequest;
    }

    public static String formatT24Date(String t24Date){
        if(t24Date!=null)
            return t24Date.substring(0,4)+"-"+t24Date.substring(4,6)+"-"+t24Date.substring(6,8);
        return "";
    }

    public static long getAtomicTransactionID() {
        long now = System.currentTimeMillis();
        while (true) {
            long lastTime = LAST_TIME_MS.get();
            if (lastTime >= now)
                now = lastTime + 1;
            if (LAST_TIME_MS.compareAndSet(lastTime, now))
                return now;
        }
    }

    public static String getTransactionId() {
        return String.valueOf(getAtomicTransactionID()).substring(4);
    }

    public static String formatDateTime(Date date) {
        String formattedDate = null;
        try {
            if (date != null) {
                formattedDate = formatDate(date, DATETIME_PATTERN);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return formattedDate;
    }

    public static String getCurrentMonth(){
        return formatDate(today(),"MM");
    }

    public static String getCurrentYear(){
        return formatDate(today(),"yyyy");
    }



    public static String getCurrentMonth(Date date){
        return formatDate(date,"MM");
    }

    public static String getCurrentDay(Date date){
        return formatDate(date,"dd");
    }
    public static String getCurrentDay(){
        Calendar cal = Calendar.getInstance();
        return String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
    }

    public static int getAge(
            Date birthDate,
            Date currentDate) {
        // validate inputs ...
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        int d1 = Integer.parseInt(formatter.format(birthDate));
        int d2 = Integer.parseInt(formatter.format(currentDate));
        return (d2 - d1) / 10000;
    }

    public static String getPTMonth(int index){
        String[] months = {"Janeiro","Fevereiro","Marco","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};
        return months[index];
    }
    public static int getMonthIndex(String month){
        List<String> months = new ArrayList<>();
        months.add("01");
        months.add("02");
        months.add("03");
        months.add("04");
        months.add("05");
        months.add("06");
        months.add("07");
        months.add("08");
        months.add("09");
        months.add("10");
        months.add("11");
        months.add("12");

        return months.indexOf(month);
    }

    public static String getMonthName(String month){
        return getPTMonth(getMonthIndex(month));
    }
    public static int toMs(int minutes) {
        return minutes * 1000;
    }

    public static long getStartDelay(Date nextRunningDate){

            ZonedDateTime now = ZonedDateTime.now(ZoneId.systemDefault());
            ZonedDateTime nextRun = ZonedDateTime.ofInstant(nextRunningDate.toInstant(),
                    ZoneId.systemDefault());

            if (now.compareTo(nextRun) > 0)
                nextRun = nextRun.plusDays(1);

            Duration duration = Duration.between(now, nextRun);
            return duration.getSeconds();

        }


    public static boolean hasOverride(List<String> override){

        for (String o:override ) {
          if(OVERRIDE_LIST.stream().anyMatch(o::contains))
              return true;
        }
        return false;
    }

    public static String genPolicyId(String prefix){

        return prefix +formatDate(today(), LAST_YEAR_DATE_PATTERN) + getTransactionId();
    }
    public static long getDelay(Date date){
        Interval interval = new Interval(date.getTime(), today().getTime());
        return interval.toDurationMillis();
    }

    public static PaymentSchedule setPaymentSchedule(InsurancePolicy insurancePolicy,BigDecimal repaymentAmount){
        PaymentSchedule paymentSchedule = new PaymentSchedule();

        paymentSchedule.setCreatedDate(today());
        paymentSchedule.setInsurancePolicy(insurancePolicy);
        paymentSchedule.setLastAttempt(today());
        paymentSchedule.setRepaymentAmount(repaymentAmount);
        paymentSchedule.setRepaymentMonth(getCurrentMonth());
        paymentSchedule.setRepaymentYear(getCurrentYear());
        paymentSchedule.setNormalPayment(true);

        return paymentSchedule;
    }

    public static void defaultSuccess(Logger logger,String traceId){
        logger.info("Response send back to the client, traceId -> {}",traceId);
    }

    public static void defaultNoParamRequest(Logger logger,String traceId,String sessionId,String username,String methodName,String ip){
        logger.info("{} is being called with parameter. username -> {}, sessionId -> {}, ipAddress -> {}, traceId -> {} ",
                methodName, username, sessionId,ip,traceId);
    }

    public static void defaultObjectRequest(Logger logger,String traceId,String request,String methodName,String ip){
        logger.info("{} is being called with parameters. request -> {}, traceId -> {}, ipAddress -> {} ",
                methodName, request, traceId, ip);
    }

    public static boolean isNumber(String text){
        try{
            Integer.parseInt(text);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }

    public static Date localDateToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

}
