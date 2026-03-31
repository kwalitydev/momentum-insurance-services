package api;

import com.google.gson.Gson;
import core.beans.CollectionProgress;
import core.beans.CollectionRate;
import core.beans.DateRange;
import core.util.RequestUtil;
import dao.entities.*;
import dao.interfaces.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static core.util.CoreUtil.*;
import static core.util.Util.*;

@Path("/metrics")
public class MetricAPI {
    private static final Logger LOGGER = LogManager.getLogger(ReportAPI.class);
    @Inject
    private ApplicationInterface applicationInterface;
    @Inject
    private PaymentScheduleInterface paymentScheduleInterface;

    @Inject
    private TaskInterface taskInterface;

    @Inject
    private CollectionLogInterface collectionLogInterface;

    @Inject
    private NotificationInterface notificationInterface;


    @GET
    @Path("/monthly-collection")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response monthlyCollection(@Context HttpServletRequest headers) {

        String reqRes = getLogId();
        String methodName = "monthlyCollectionMetrics";
        LOGGER.info("{} is being called with no parameter. logId -> {}, ipAddress -> {} ",
                methodName, reqRes,headers.getRemoteAddr());

        Response response = Response.status(Response.Status.NO_CONTENT).build();

        try {

            DateRange range = calculateDateRange();

            if (range != null) {
                String startDate_ = range.getStartDate();
                String endDate_   = range.getEndDate();

                LOGGER.info("Getting collected premium for period: {} to {}",startDate_,endDate_);

                Gson gson = new Gson();
                String convertedResponse = gson.toJson(paymentScheduleInterface.getCollectedPremium(startDate_,endDate_));

                response = Response.status(Response.Status.OK).entity(convertedResponse).build();
            }
            else {
                LOGGER.info("Invalid date interval or misconfiguration");
            }






        } catch (Exception e) {
           LOGGER.error(e);
            LOGGER.error(e.getMessage());
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

        return response;

    }


    @GET
    @Path("/tasks-status")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response taskStatus(@Context HttpServletRequest headers) {

        String reqRes = getLogId();
        String methodName = "taskStatus";
        LOGGER.info("{} is being called with no parameter. logId -> {}, ipAddress -> {} ",
                methodName, reqRes,headers.getRemoteAddr());


        try {

        return Response.status(Response.Status.OK).entity(taskInterface.findAllByOrderByTaskId()).build();



        } catch (Exception e) {
            LOGGER.error(e);
            LOGGER.error(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }


    }


    @GET
    @Path("/collection-progress")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response monthlyCollectionProgress(@Context HttpServletRequest headers) {

        String reqRes = getLogId();
        String methodName = "monthlyCollectionProgress";
        LOGGER.info("{} is being called with no parameter. logId -> {}, ipAddress -> {} ",
                methodName, reqRes,headers.getRemoteAddr());

        Response response = Response.status(Response.Status.NO_CONTENT).build();

        try {
            DateRange range = calculateDateRange();

            if (range != null) {
                String startDate_ = range.getStartDate();
                String endDate_   = range.getEndDate();

                LOGGER.info("Getting collection progress for period: {} to {}",startDate_,endDate_);

                List<Object[]> rows = paymentScheduleInterface.getCollectedProgress(startDate_, endDate_);

                response = Response.status(Response.Status.OK).entity(mapToCollectionProgress(rows)).build();
            }
            else {
                LOGGER.info("Invalid date interval or misconfiguration");
            }


        } catch (Exception e) {
            LOGGER.error(e);
            LOGGER.error(e.getMessage());
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

        return response;

    }

    @GET
    @Path("/collection-status")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response monthlyCollectionStatus(@Context HttpServletRequest headers) {

        String reqRes = getLogId();
        String methodName = "monthlyCollectionStatus";
        LOGGER.info("{} is being called with no parameter. logId -> {}, ipAddress -> {} ",
                methodName, reqRes,headers.getRemoteAddr());

        Response response = Response.status(Response.Status.NO_CONTENT).build();

        try {
            DateRange range = calculateDateRange();

            if (range != null) {
                String startDate_ = range.getStartDate();
                String endDate_   = range.getEndDate();

                LOGGER.info("Getting collection status for period: {} to {}",startDate_,endDate_);

                List<Object[]> paymentSchedules = paymentScheduleInterface.getCollectionStatus(startDate_, endDate_);
                List<CollectionRate> mappedPaymentSchedules = mapToCollectionRate(paymentSchedules);

                response = Response.status(Response.Status.OK).entity(mappedPaymentSchedules).build();
            }
            else {
                LOGGER.info("Invalid date interval or misconfiguration");
            }


        } catch (Exception e) {
            LOGGER.error(e);
            LOGGER.error(e.getMessage());
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

        return response;

    }


    @GET
    @Path("/collection-attempts")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response collectionAttempts(@Context HttpServletRequest headers) {

        String reqRes = getLogId();
        String methodName = "collectionAttempts";
        LOGGER.info("{} is being called with no parameter. logId -> {}, ipAddress -> {} ",
                methodName, reqRes,headers.getRemoteAddr());

        Response response = Response.status(Response.Status.NO_CONTENT).build();

        try {
            DateRange range = calculateDateRange();

            if (range != null) {
                String startDate_ = range.getStartDate();
                String endDate_   = range.getEndDate();


                LOGGER.info("Getting collection attempts for period: {} to {}",startDate_,endDate_);

                Gson gson = new Gson();
                String convertedResponse = gson.toJson(collectionLogInterface.getCollectionAttempts(startDate_,endDate_));

                response = Response.status(Response.Status.OK).entity(convertedResponse).build();
            }
            else {
                LOGGER.info("Invalid date interval or misconfiguration");
            }


        } catch (Exception e) {
            LOGGER.error(e);
            LOGGER.error(e.getMessage());
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

        return response;

    }



    @GET
    @Path("/service-status")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response serviceStatus(@Context HttpServletRequest headers) {

        String reqRes = getLogId();
        String methodName = "serviceStatus";
        LOGGER.info("{} is being called with no parameter. logId -> {}, ipAddress -> {} ",
                methodName, reqRes,headers.getRemoteAddr());


        try {

            List<Object[]> collectionLog = collectionLogInterface.getLastRows();

            if(!collectionLog.isEmpty()) {

                return Response.status(Response.Status.OK).entity("Collection is up and running").build();
            }
            else {
                return Response.status(Response.Status.OK).entity("Collection is not running for a while").build();
            }



        } catch (Exception e) {
            LOGGER.error(e);
            LOGGER.error(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }


    }


    @GET
    @Path("/notification-status")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response notificationStatus(@Context HttpServletRequest headers) {

        String reqRes = getLogId();
        String methodName = "notificationStatus";
        LOGGER.info("{} is being called with no parameter. logId -> {}, ipAddress -> {} ",
                methodName, reqRes,headers.getRemoteAddr());


        try {
            LocalDate today = LocalDate.now();
            YearMonth ym = YearMonth.from(today);

            LocalDate firstDay = ym.atDay(1);
            LocalDate lastDay  = ym.atEndOfMonth();

            DateTimeFormatter fmt = DateTimeFormatter.ofPattern(SIMPLE_DATE_PATTERN);
            String startDateStr = firstDay.format(fmt);
            String endDateStr   = lastDay.format(fmt);


                return Response.status(Response.Status.OK).entity(notificationInterface.getNotificationByStatus(stringToDate(startDateStr),stringToDate(endDateStr))).build();


        } catch (Exception e) {
            LOGGER.error(e);
            LOGGER.error(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }


    }

    public List<CollectionProgress> mapToCollectionProgress(List<Object[]> rows) {
        List<CollectionProgress> list = new ArrayList<>();

        for (Object[] row : rows) {
            CollectionProgress cp = new CollectionProgress();

            cp.setProduct(row[0] != null ? row[0].toString() : null);
            cp.setToBeCollected(row[1] != null ? ((Number) row[1]).intValue() : 0);
            cp.setCollected(row[2] != null ? ((Number) row[2]).intValue() : 0);
            cp.setCollectedPercentage(row[3] != null ? ((Number) row[3]).doubleValue() : 0.0);

            list.add(cp);
        }

        return list;
    }

    public List<CollectionRate> mapToCollectionRate(List<Object[]> results) {

        List<CollectionRate> list = new ArrayList<>();

        for (Object[] row : results) {

            CollectionRate cr = new CollectionRate();

            cr.setProduct(row[0] != null ? row[0].toString() : null);
            cr.setTotalAttempts(row[1] != null ? ((Number) row[1]).intValue() : 0);
            cr.setTotalPaid(row[2] != null ? ((Number) row[2]).intValue() : 0);
            cr.setTotalUnpaid(row[3] != null ? ((Number) row[3]).intValue() : 0);
            cr.setPaymentRate(row[4] != null ? ((Number) row[4]).doubleValue() : 0.0);
            cr.setUnpaidRate(row[5] != null ? ((Number) row[5]).doubleValue() : 0.0);

            list.add(cr);
        }

        return list;
    }

    public DateRange calculateDateRange() {

        Optional<Application> application = applicationInterface.findByAppId(RequestUtil.APP_ID);

        if (application.isPresent()) {

            String startDay = application.get().getCollectionDays().split(";")[0];

            LocalDate today = LocalDate.now();
            YearMonth currentYearMonth = YearMonth.of(today.getYear(), today.getMonth());

            LocalDate startDate = currentYearMonth.atDay(Integer.parseInt(startDay));
            LocalDate endDate   = currentYearMonth.atEndOfMonth();

            String startDate_ = formatDate(localDateToDate(startDate), DATABASE_DATE_PATTERN);
            String endDate_   = formatDate(localDateToDate(endDate), DATABASE_DATE_PATTERN);


            if (LocalDate.now().isBefore(startDate)) {

                LOGGER.info("Querying for non collection period");
                LocalDate firstDayOfMonth = startDate.withDayOfMonth(1);
                LocalDate dayBeforeStart  = startDate.minusDays(1);

                startDate_ = formatDate(localDateToDate(firstDayOfMonth), DATABASE_DATE_PATTERN);
                endDate_   = formatDate(localDateToDate(dayBeforeStart), DATABASE_DATE_PATTERN);
            }

            return new DateRange(startDate_, endDate_);
        }

        return null;
    }


}
