package adapter;

import com.temenos.ebsbsegupdatesinp.EBSBSEGUPDATESINPType;
import com.temenos.ebsbsegurosinsmigration.EBSBSEGUROSINSMIGRATIONType;
import com.temenos.fundstransfersegtws.FUNDSTRANSFERSEGTWSType;
import com.temenos.sbm_insurance.*;
import core.util.RequestUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.Interval;

import javax.enterprise.context.ApplicationScoped;
import javax.xml.ws.BindingProvider;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static core.util.CoreUtil.*;
import static core.util.RequestUtil.*;
import static core.util.Util.getCoCode;

@ApplicationScoped
public class PaymentAdapter implements PaymentInterface{

    private static final Logger LOGGER = LogManager.getLogger(PaymentAdapter.class);
    private static final String DEFAULT_BRANCH = "MZ0010195";
    private final List<T24WebServicesImpl> t24WebServicesPool = new ArrayList<>();
    public static int NEXT_WEBSERVICE_INDEX = 0;
    private String[] endpoints;

    public void initialize(){

        try {
            Date d = today();
            LOGGER.info("Attempting to initialise T24 Webservices");
            endpoints = TWS_ENDPOINT.split(";");
            for (String endpoint:endpoints) {
                LOGGER.info("Looping in {}",endpoint);
                T24WebServicesImplService t24WebServicesImplService = new T24WebServicesImplService();
                T24WebServicesImpl t24WebServices = t24WebServicesImplService.getT24WebServicesImplPort();
                BindingProvider bindingProvider = (BindingProvider) t24WebServices;
                bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint);
                LOGGER.info("T24 Webservices successfully initialised in {} in {} ms", endpoint,getDelay(d));
                t24WebServicesPool.add(t24WebServices);
            }
        }
        catch (Exception e){
            LOGGER.error("Failed to initialise T24 Webservices");
            LOGGER.error(e);
        }

    }



    public SBInsurancePaymentsResponse postTransaction(String accountNumber,String debitCCY,String debitAmount,
                                                       String debitTheirRef,String creditTheirRef,String creditAccount,
                                                       String processingDate,String paymentDetails,String company,String logId,String taskProduct)  {

            OfsFunction ofsFunction = new OfsFunction();

            FUNDSTRANSFERSEGTWSType fundstransfersegtwsType = new FUNDSTRANSFERSEGTWSType();
            fundstransfersegtwsType.setDEBITCURRENCY(debitCCY);
            fundstransfersegtwsType.setDEBITACCTNO(accountNumber);
            fundstransfersegtwsType.setDEBITAMOUNT(debitAmount);
            fundstransfersegtwsType.setDEBITTHEIRREF(debitTheirRef);
            fundstransfersegtwsType.setCREDITTHEIRREF(creditTheirRef);
            fundstransfersegtwsType.setCREDITACCTNO(creditAccount);
            fundstransfersegtwsType.setCREDITCURRENCY(debitCCY);
            fundstransfersegtwsType.setNETTXNID(logId);

            FUNDSTRANSFERSEGTWSType.GPAYMENTDETAILS gPaymentDetails = new FUNDSTRANSFERSEGTWSType.GPAYMENTDETAILS();
            gPaymentDetails.getPAYMENTDETAILS().add(paymentDetails);
            fundstransfersegtwsType.setGPAYMENTDETAILS(gPaymentDetails);

            SBInsurancePayments sbInsurancePayments = new SBInsurancePayments();
            sbInsurancePayments.setWebRequestCommon(setWebRequestCommon(company));
            sbInsurancePayments.setFUNDSTRANSFERSEGTWSType(fundstransfersegtwsType);
            sbInsurancePayments.setOfsFunction(ofsFunction);

            LOGGER.info("{} : Sending payment to core. Core Payload {}. traceId -> {}",taskProduct, sbInsurancePayments,logId);

            SBInsurancePaymentsResponse sbInsurancePaymentsResponse = getWebServiceFromPool(logId).sbInsurancePayments(sbInsurancePayments);
            if(sbInsurancePaymentsResponse.getStatus()!=null){
                LOGGER.info("{} : T24 responded. Status -> {}, traceId -> {}",taskProduct,sbInsurancePaymentsResponse.getStatus(),logId);

            }

            return sbInsurancePaymentsResponse;

    }

    @Override
    public SBGetCustomerByAccountResponse getCustomerDetails(String accountId,String traceId)  {

        LOGGER.info("Attempt to query account {} to T24. traceId -> {}",accountId,traceId);
        SBGetCustomerByAccount sbGetCustomerByAccount = new SBGetCustomerByAccount();
        sbGetCustomerByAccount.setWebRequestCommon(setWebRequestCommon(getCoCode(accountId)));

        EnquiryInput enquiryInput = new EnquiryInput();
        EnquiryInputCollection enquiryInputCollection = new EnquiryInputCollection();
        enquiryInputCollection.setColumnName("ACCOUNT.NUMBER");
        enquiryInputCollection.setOperand("EQ");
        enquiryInputCollection.setCriteriaValue(accountId);
        enquiryInput.getEnquiryInputCollection().add(enquiryInputCollection);
        sbGetCustomerByAccount.setSBGETCUSTOMERBYACCOUNTType(enquiryInput);

        try{
            SBGetCustomerByAccountResponse accountResponse = getWebServiceFromPool(traceId).sbGetCustomerByAccount(sbGetCustomerByAccount);

            LOGGER.info("T24 response -> {}. traceId -> {}",accountResponse,traceId);

            return accountResponse;
        }
        catch (Exception e){
            LOGGER.error("Error while getting customer by account. traceId -> {}",traceId,e);
            return null;
        }

    }



    @Override
    public SBInsuranceTableResponse updatePolicyStatus(String accountNumber, String migrationStatus, String policyId, String migrationDate){


        OfsFunction ofsFunction = new OfsFunction();

        EBSBSEGUROSINSMIGRATIONType ebs = new EBSBSEGUROSINSMIGRATIONType();
        ebs.setId(policyId);
        ebs.setMIGRATIONSTATUS(migrationStatus);
        ebs.setMIGRATIONDATE(migrationDate);

        SBInsuranceTable sbInsurancetable = new SBInsuranceTable();
        sbInsurancetable.setWebRequestCommon(setWebRequestCommon(getCoCode(accountNumber)));
        sbInsurancetable.setEBSBSEGUROSINSMIGRATIONType(ebs);
        sbInsurancetable.setOfsFunction(ofsFunction);

        LOGGER.info("Core Payload -> {}",sbInsurancetable);

        SBInsuranceTableResponse sbInsurancePayments = getWebServiceFromPool(getLogId()).sbInsuranceTable(sbInsurancetable);
        if(sbInsurancePayments.getStatus()!=null){
            LOGGER.info("T24 responded. Status -> {}",sbInsurancePayments.getStatus());

        }

        return sbInsurancePayments;
    }


    @Override
    public SBGetSBSegUpdatesResponse getUpdatedPolicies(String status,String date)  {

        LOGGER.info("Attempt to query updated policies with TRANS.TYPE = {} to T24",status);
        SBGetSBSegUpdates sbGetSBSegUpdates = new SBGetSBSegUpdates();
        sbGetSBSegUpdates.setWebRequestCommon(setWebRequestCommon(null));

        EnquiryInput enquiryInput = new EnquiryInput();
        EnquiryInputCollection enquiryInputCollection = new EnquiryInputCollection();
        enquiryInputCollection.setColumnName("TRANS.TYPE");
        enquiryInputCollection.setOperand("EQ");
        enquiryInputCollection.setCriteriaValue(status);
        enquiryInput.getEnquiryInputCollection().add(enquiryInputCollection);

        sbGetSBSegUpdates.setSBGETSBSEGUPDATESType(enquiryInput);

        try{
            SBGetSBSegUpdatesResponse sbGetSBSegUpdatesResponse = getWebServiceFromPool(getLogId()).sbGetSBSegUpdates(sbGetSBSegUpdates);
            if(sbGetSBSegUpdatesResponse.getStatus()!=null){
                LOGGER.info("T24 responded. Status -> {}",sbGetSBSegUpdatesResponse.getStatus());
            }
            return sbGetSBSegUpdatesResponse;
        }
        catch (Exception e){
            LOGGER.error("Error while getting updated policies ",e);
            return null;
        }

    }


    @Override
    public SBInsuranceGetLoanListResponse getLoanDetails(String policyId)  {
        Date d = new Date();

        LOGGER.info("Attempt to get insurance details for {}",policyId);

        SBInsuranceGetLoanList sbInsuranceGetLoanList = new SBInsuranceGetLoanList();
        sbInsuranceGetLoanList.setWebRequestCommon(setWebRequestCommon(DEFAULT_BRANCH));

        EnquiryInput enquiryInput = new EnquiryInput();
        EnquiryInputCollection enquiryInputCollection = new EnquiryInputCollection();
        enquiryInputCollection.setColumnName("@ID");
        enquiryInputCollection.setOperand("EQ");
        enquiryInputCollection.setCriteriaValue(policyId);

        enquiryInput.getEnquiryInputCollection().add(enquiryInputCollection);
        sbInsuranceGetLoanList.setLOANSEGLISTSERVType(enquiryInput);


        try{
            SBInsuranceGetLoanListResponse loanList = getWebServiceFromPool(getLogId()).sbInsuranceGetLoanList(sbInsuranceGetLoanList);

            LOGGER.info("T24 response -> {}",loanList);
            LOGGER.info("Request took {} ms to process",getDelay(d));
            return loanList;
        }
        catch (Exception e){
            LOGGER.error("Error while getting insurance details",e);
            Interval interval = new Interval(d.getTime(), today().getTime());
            long delay = interval.toDurationMillis();
            LOGGER.error("Request took {} ms to process",delay);
            return null;
        }
    }


    @Override
    public SBInsuranceUpdateTableResponse updateMigrationStatus(String migrationStatus, String policyId,String transType){

        OfsFunction ofsFunction = new OfsFunction();

        EBSBSEGUPDATESINPType ebsbsegupdatesinpType = new EBSBSEGUPDATESINPType();
        ebsbsegupdatesinpType.setMIGRATIONSTATUS(migrationStatus);
        ebsbsegupdatesinpType.setId(policyId);
        ebsbsegupdatesinpType.setTRANSTYPE(transType);

        SBInsuranceUpdateTable sbInsuranceTable = new SBInsuranceUpdateTable();
        sbInsuranceTable.setWebRequestCommon(setWebRequestCommon(null));
        sbInsuranceTable.setEBSBSEGUPDATESINPType(ebsbsegupdatesinpType);
        sbInsuranceTable.setOfsFunction(ofsFunction);

        LOGGER.info("Core Payload -> {}",sbInsuranceTable.toString());

        SBInsuranceUpdateTableResponse sbInsuranceTableResponse = getWebServiceFromPool(getLogId()).sbInsuranceUpdateTable(sbInsuranceTable);
        if(sbInsuranceTableResponse.getStatus()!=null){
            LOGGER.info("T24 responded. Status -> {}",sbInsuranceTableResponse.getStatus());

        }

        return sbInsuranceTableResponse;
    }



    private WebRequestCommon setWebRequestCommon(String branch){
        WebRequestCommon webRequestCommon = new WebRequestCommon();
        if(branch!=null) {
            webRequestCommon.setCompany(branch);
        }
        webRequestCommon.setUserName(RequestUtil.TWS_USERNAME);
        webRequestCommon.setPassword(RequestUtil.TWS_PASSWORD);
        return webRequestCommon;
    }


    @Override
    public SBGetNetTxnDtxResponse  getFTDetails(String logId)  {

        LOGGER.info("Attempt to query transaction details for logId {} ",logId);
        SBGetNetTxnDtx sbGetNetTxnDtx = new SBGetNetTxnDtx();
        sbGetNetTxnDtx.setWebRequestCommon(setWebRequestCommon(DEFAULT_BRANCH));

        EnquiryInput enquiryInput = new EnquiryInput();
        EnquiryInputCollection enquiryInputCollection = new EnquiryInputCollection();
        enquiryInputCollection.setColumnName("NET.TXN.ID");
        enquiryInputCollection.setOperand("EQ");
        enquiryInputCollection.setCriteriaValue(logId);
        enquiryInput.getEnquiryInputCollection().add(enquiryInputCollection);

        sbGetNetTxnDtx.setSBGETNETTXNDTXType(enquiryInput);

        try{
            SBGetNetTxnDtxResponse sbGetNetTxnDtxResponse = getWebServiceFromPool(getLogId()).sbGetNetTxnDtx(sbGetNetTxnDtx);
            if(sbGetNetTxnDtxResponse.getStatus()!=null){
                LOGGER.info("T24 responded. Status -> {}",sbGetNetTxnDtxResponse.getStatus());
            }
            return sbGetNetTxnDtxResponse;
        }
        catch (Exception e){
            LOGGER.error("Error while getting transaction details for logId {}",logId,e);
            return null;
        }

    }

    private T24WebServicesImpl getWebServiceFromPool(String logId){
        T24WebServicesImpl t24WebServices = t24WebServicesPool.get(NEXT_WEBSERVICE_INDEX);
        LOGGER.info("Using {} from pool. logId -> {}",endpoints[NEXT_WEBSERVICE_INDEX],logId);
        NEXT_WEBSERVICE_INDEX = (NEXT_WEBSERVICE_INDEX + 1) % endpoints.length;
        return t24WebServices;

    }

}
