
package com.temenos.sbm_realtimepayment;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.temenos.sbm_realtimepayment package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SBGetCustomerByAccountResponse_QNAME = new QName("http://temenos.com/SBM-RealTimePayment", "SBGetCustomerByAccountResponse");
    private final static QName _SBRealTimePaymentsResponse_QNAME = new QName("http://temenos.com/SBM-RealTimePayment", "SBRealTimePaymentsResponse");
    private final static QName _SBRealTimePaymentsValidate_QNAME = new QName("http://temenos.com/SBM-RealTimePayment", "SBRealTimePayments_Validate");
    private final static QName _SBGetCustomerByAccount_QNAME = new QName("http://temenos.com/SBM-RealTimePayment", "SBGetCustomerByAccount");
    private final static QName _SBGetAccountDetailsResponse_QNAME = new QName("http://temenos.com/SBM-RealTimePayment", "SBGetAccountDetailsResponse");
    private final static QName _SBRealTimePaymentsValidateResponse_QNAME = new QName("http://temenos.com/SBM-RealTimePayment", "SBRealTimePayments_ValidateResponse");
    private final static QName _SBGetAccountDetails_QNAME = new QName("http://temenos.com/SBM-RealTimePayment", "SBGetAccountDetails");
    private final static QName _SBRealTimePayments_QNAME = new QName("http://temenos.com/SBM-RealTimePayment", "SBRealTimePayments");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.temenos.sbm_realtimepayment
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SBGetCustomerByAccount }
     * 
     */
    public SBGetCustomerByAccount createSBGetCustomerByAccount() {
        return new SBGetCustomerByAccount();
    }

    /**
     * Create an instance of {@link SBGetAccountDetailsResponse }
     * 
     */
    public SBGetAccountDetailsResponse createSBGetAccountDetailsResponse() {
        return new SBGetAccountDetailsResponse();
    }

    /**
     * Create an instance of {@link SBRealTimePaymentsValidateResponse }
     * 
     */
    public SBRealTimePaymentsValidateResponse createSBRealTimePaymentsValidateResponse() {
        return new SBRealTimePaymentsValidateResponse();
    }

    /**
     * Create an instance of {@link SBGetAccountDetails }
     * 
     */
    public SBGetAccountDetails createSBGetAccountDetails() {
        return new SBGetAccountDetails();
    }

    /**
     * Create an instance of {@link SBRealTimePayments }
     * 
     */
    public SBRealTimePayments createSBRealTimePayments() {
        return new SBRealTimePayments();
    }

    /**
     * Create an instance of {@link SBGetCustomerByAccountResponse }
     * 
     */
    public SBGetCustomerByAccountResponse createSBGetCustomerByAccountResponse() {
        return new SBGetCustomerByAccountResponse();
    }

    /**
     * Create an instance of {@link SBRealTimePaymentsResponse }
     * 
     */
    public SBRealTimePaymentsResponse createSBRealTimePaymentsResponse() {
        return new SBRealTimePaymentsResponse();
    }

    /**
     * Create an instance of {@link SBRealTimePaymentsValidate }
     * 
     */
    public SBRealTimePaymentsValidate createSBRealTimePaymentsValidate() {
        return new SBRealTimePaymentsValidate();
    }

    /**
     * Create an instance of {@link OfsFunction }
     * 
     */
    public OfsFunction createOfsFunction() {
        return new OfsFunction();
    }

    /**
     * Create an instance of {@link Status }
     * 
     */
    public Status createStatus() {
        return new Status();
    }

    /**
     * Create an instance of {@link EnquiryInputCollection }
     * 
     */
    public EnquiryInputCollection createEnquiryInputCollection() {
        return new EnquiryInputCollection();
    }

    /**
     * Create an instance of {@link EnquiryInput }
     * 
     */
    public EnquiryInput createEnquiryInput() {
        return new EnquiryInput();
    }

    /**
     * Create an instance of {@link WebRequestCommon }
     * 
     */
    public WebRequestCommon createWebRequestCommon() {
        return new WebRequestCommon();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SBGetCustomerByAccountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://temenos.com/SBM-RealTimePayment", name = "SBGetCustomerByAccountResponse")
    public JAXBElement<SBGetCustomerByAccountResponse> createSBGetCustomerByAccountResponse(SBGetCustomerByAccountResponse value) {
        return new JAXBElement<SBGetCustomerByAccountResponse>(_SBGetCustomerByAccountResponse_QNAME, SBGetCustomerByAccountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SBRealTimePaymentsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://temenos.com/SBM-RealTimePayment", name = "SBRealTimePaymentsResponse")
    public JAXBElement<SBRealTimePaymentsResponse> createSBRealTimePaymentsResponse(SBRealTimePaymentsResponse value) {
        return new JAXBElement<SBRealTimePaymentsResponse>(_SBRealTimePaymentsResponse_QNAME, SBRealTimePaymentsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SBRealTimePaymentsValidate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://temenos.com/SBM-RealTimePayment", name = "SBRealTimePayments_Validate")
    public JAXBElement<SBRealTimePaymentsValidate> createSBRealTimePaymentsValidate(SBRealTimePaymentsValidate value) {
        return new JAXBElement<SBRealTimePaymentsValidate>(_SBRealTimePaymentsValidate_QNAME, SBRealTimePaymentsValidate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SBGetCustomerByAccount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://temenos.com/SBM-RealTimePayment", name = "SBGetCustomerByAccount")
    public JAXBElement<SBGetCustomerByAccount> createSBGetCustomerByAccount(SBGetCustomerByAccount value) {
        return new JAXBElement<SBGetCustomerByAccount>(_SBGetCustomerByAccount_QNAME, SBGetCustomerByAccount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SBGetAccountDetailsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://temenos.com/SBM-RealTimePayment", name = "SBGetAccountDetailsResponse")
    public JAXBElement<SBGetAccountDetailsResponse> createSBGetAccountDetailsResponse(SBGetAccountDetailsResponse value) {
        return new JAXBElement<SBGetAccountDetailsResponse>(_SBGetAccountDetailsResponse_QNAME, SBGetAccountDetailsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SBRealTimePaymentsValidateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://temenos.com/SBM-RealTimePayment", name = "SBRealTimePayments_ValidateResponse")
    public JAXBElement<SBRealTimePaymentsValidateResponse> createSBRealTimePaymentsValidateResponse(SBRealTimePaymentsValidateResponse value) {
        return new JAXBElement<SBRealTimePaymentsValidateResponse>(_SBRealTimePaymentsValidateResponse_QNAME, SBRealTimePaymentsValidateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SBGetAccountDetails }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://temenos.com/SBM-RealTimePayment", name = "SBGetAccountDetails")
    public JAXBElement<SBGetAccountDetails> createSBGetAccountDetails(SBGetAccountDetails value) {
        return new JAXBElement<SBGetAccountDetails>(_SBGetAccountDetails_QNAME, SBGetAccountDetails.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SBRealTimePayments }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://temenos.com/SBM-RealTimePayment", name = "SBRealTimePayments")
    public JAXBElement<SBRealTimePayments> createSBRealTimePayments(SBRealTimePayments value) {
        return new JAXBElement<SBRealTimePayments>(_SBRealTimePayments_QNAME, SBRealTimePayments.class, null, value);
    }

}
