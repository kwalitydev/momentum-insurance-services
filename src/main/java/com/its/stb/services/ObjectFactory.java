
package com.its.stb.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.its.stb.services package. 
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

    private final static QName _SendNotificationResponse_QNAME = new QName("http://services.stb.its.com/", "sendNotificationResponse");
    private final static QName _ProcessPendingNotificationsResponse_QNAME = new QName("http://services.stb.its.com/", "processPendingNotificationsResponse");
    private final static QName _ObtainNotificationStatusResponse_QNAME = new QName("http://services.stb.its.com/", "obtainNotificationStatusResponse");
    private final static QName _FindTemplate_QNAME = new QName("http://services.stb.its.com/", "findTemplate");
    private final static QName _ProcessPendingNotifications_QNAME = new QName("http://services.stb.its.com/", "processPendingNotifications");
    private final static QName _SendNotificationWithTpl_QNAME = new QName("http://services.stb.its.com/", "sendNotificationWithTpl");
    private final static QName _SendNotification_QNAME = new QName("http://services.stb.its.com/", "sendNotification");
    private final static QName _ITSBusinessException_QNAME = new QName("http://services.stb.its.com/", "ITSBusinessException");
    private final static QName _ObtainNotificationStatus_QNAME = new QName("http://services.stb.its.com/", "obtainNotificationStatus");
    private final static QName _ITSInternalException_QNAME = new QName("http://services.stb.its.com/", "ITSInternalException");
    private final static QName _ITSBaseException_QNAME = new QName("http://services.stb.its.com/", "ITSBaseException");
    private final static QName _SendNotificationWithTplResponse_QNAME = new QName("http://services.stb.its.com/", "sendNotificationWithTplResponse");
    private final static QName _FindTemplateResponse_QNAME = new QName("http://services.stb.its.com/", "findTemplateResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.its.stb.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ProcessPendingNotificationsResponse }
     * 
     */
    public ProcessPendingNotificationsResponse createProcessPendingNotificationsResponse() {
        return new ProcessPendingNotificationsResponse();
    }

    /**
     * Create an instance of {@link SendNotificationResponse }
     * 
     */
    public SendNotificationResponse createSendNotificationResponse() {
        return new SendNotificationResponse();
    }

    /**
     * Create an instance of {@link ObtainNotificationStatusResponse }
     * 
     */
    public ObtainNotificationStatusResponse createObtainNotificationStatusResponse() {
        return new ObtainNotificationStatusResponse();
    }

    /**
     * Create an instance of {@link FindTemplate }
     * 
     */
    public FindTemplate createFindTemplate() {
        return new FindTemplate();
    }

    /**
     * Create an instance of {@link ProcessPendingNotifications }
     * 
     */
    public ProcessPendingNotifications createProcessPendingNotifications() {
        return new ProcessPendingNotifications();
    }

    /**
     * Create an instance of {@link SendNotificationWithTpl }
     * 
     */
    public SendNotificationWithTpl createSendNotificationWithTpl() {
        return new SendNotificationWithTpl();
    }

    /**
     * Create an instance of {@link SendNotification }
     * 
     */
    public SendNotification createSendNotification() {
        return new SendNotification();
    }

    /**
     * Create an instance of {@link ITSBusinessException }
     * 
     */
    public ITSBusinessException createITSBusinessException() {
        return new ITSBusinessException();
    }

    /**
     * Create an instance of {@link ITSInternalException }
     * 
     */
    public ITSInternalException createITSInternalException() {
        return new ITSInternalException();
    }

    /**
     * Create an instance of {@link ObtainNotificationStatus }
     * 
     */
    public ObtainNotificationStatus createObtainNotificationStatus() {
        return new ObtainNotificationStatus();
    }

    /**
     * Create an instance of {@link ITSBaseException }
     * 
     */
    public ITSBaseException createITSBaseException() {
        return new ITSBaseException();
    }

    /**
     * Create an instance of {@link FindTemplateResponse }
     * 
     */
    public FindTemplateResponse createFindTemplateResponse() {
        return new FindTemplateResponse();
    }

    /**
     * Create an instance of {@link SendNotificationWithTplResponse }
     * 
     */
    public SendNotificationWithTplResponse createSendNotificationWithTplResponse() {
        return new SendNotificationWithTplResponse();
    }

    /**
     * Create an instance of {@link FileAttach }
     * 
     */
    public FileAttach createFileAttach() {
        return new FileAttach();
    }

    /**
     * Create an instance of {@link ObtainNotificationStatusIn }
     * 
     */
    public ObtainNotificationStatusIn createObtainNotificationStatusIn() {
        return new ObtainNotificationStatusIn();
    }

    /**
     * Create an instance of {@link NotTemplatePK }
     * 
     */
    public NotTemplatePK createNotTemplatePK() {
        return new NotTemplatePK();
    }

    /**
     * Create an instance of {@link ItsRequestContext }
     * 
     */
    public ItsRequestContext createItsRequestContext() {
        return new ItsRequestContext();
    }

    /**
     * Create an instance of {@link NotTemplate }
     * 
     */
    public NotTemplate createNotTemplate() {
        return new NotTemplate();
    }

    /**
     * Create an instance of {@link SendNotificationOut }
     * 
     */
    public SendNotificationOut createSendNotificationOut() {
        return new SendNotificationOut();
    }

    /**
     * Create an instance of {@link SendNotificationIn }
     * 
     */
    public SendNotificationIn createSendNotificationIn() {
        return new SendNotificationIn();
    }

    /**
     * Create an instance of {@link KeyValuePair }
     * 
     */
    public KeyValuePair createKeyValuePair() {
        return new KeyValuePair();
    }

    /**
     * Create an instance of {@link ItsSessionContext }
     * 
     */
    public ItsSessionContext createItsSessionContext() {
        return new ItsSessionContext();
    }

    /**
     * Create an instance of {@link ProcessPendingNotificationsOut }
     * 
     */
    public ProcessPendingNotificationsOut createProcessPendingNotificationsOut() {
        return new ProcessPendingNotificationsOut();
    }

    /**
     * Create an instance of {@link SendNotificationWithTplOut }
     * 
     */
    public SendNotificationWithTplOut createSendNotificationWithTplOut() {
        return new SendNotificationWithTplOut();
    }

    /**
     * Create an instance of {@link ObtainNotificationStatusOut }
     * 
     */
    public ObtainNotificationStatusOut createObtainNotificationStatusOut() {
        return new ObtainNotificationStatusOut();
    }

    /**
     * Create an instance of {@link SendNotificationWithTplIn }
     * 
     */
    public SendNotificationWithTplIn createSendNotificationWithTplIn() {
        return new SendNotificationWithTplIn();
    }

    /**
     * Create an instance of {@link ProcessPendingNotificationsIn }
     * 
     */
    public ProcessPendingNotificationsIn createProcessPendingNotificationsIn() {
        return new ProcessPendingNotificationsIn();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendNotificationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.stb.its.com/", name = "sendNotificationResponse")
    public JAXBElement<SendNotificationResponse> createSendNotificationResponse(SendNotificationResponse value) {
        return new JAXBElement<SendNotificationResponse>(_SendNotificationResponse_QNAME, SendNotificationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcessPendingNotificationsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.stb.its.com/", name = "processPendingNotificationsResponse")
    public JAXBElement<ProcessPendingNotificationsResponse> createProcessPendingNotificationsResponse(ProcessPendingNotificationsResponse value) {
        return new JAXBElement<ProcessPendingNotificationsResponse>(_ProcessPendingNotificationsResponse_QNAME, ProcessPendingNotificationsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtainNotificationStatusResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.stb.its.com/", name = "obtainNotificationStatusResponse")
    public JAXBElement<ObtainNotificationStatusResponse> createObtainNotificationStatusResponse(ObtainNotificationStatusResponse value) {
        return new JAXBElement<ObtainNotificationStatusResponse>(_ObtainNotificationStatusResponse_QNAME, ObtainNotificationStatusResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindTemplate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.stb.its.com/", name = "findTemplate")
    public JAXBElement<FindTemplate> createFindTemplate(FindTemplate value) {
        return new JAXBElement<FindTemplate>(_FindTemplate_QNAME, FindTemplate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcessPendingNotifications }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.stb.its.com/", name = "processPendingNotifications")
    public JAXBElement<ProcessPendingNotifications> createProcessPendingNotifications(ProcessPendingNotifications value) {
        return new JAXBElement<ProcessPendingNotifications>(_ProcessPendingNotifications_QNAME, ProcessPendingNotifications.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendNotificationWithTpl }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.stb.its.com/", name = "sendNotificationWithTpl")
    public JAXBElement<SendNotificationWithTpl> createSendNotificationWithTpl(SendNotificationWithTpl value) {
        return new JAXBElement<SendNotificationWithTpl>(_SendNotificationWithTpl_QNAME, SendNotificationWithTpl.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendNotification }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.stb.its.com/", name = "sendNotification")
    public JAXBElement<SendNotification> createSendNotification(SendNotification value) {
        return new JAXBElement<SendNotification>(_SendNotification_QNAME, SendNotification.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ITSBusinessException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.stb.its.com/", name = "ITSBusinessException")
    public JAXBElement<ITSBusinessException> createITSBusinessException(ITSBusinessException value) {
        return new JAXBElement<ITSBusinessException>(_ITSBusinessException_QNAME, ITSBusinessException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtainNotificationStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.stb.its.com/", name = "obtainNotificationStatus")
    public JAXBElement<ObtainNotificationStatus> createObtainNotificationStatus(ObtainNotificationStatus value) {
        return new JAXBElement<ObtainNotificationStatus>(_ObtainNotificationStatus_QNAME, ObtainNotificationStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ITSInternalException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.stb.its.com/", name = "ITSInternalException")
    public JAXBElement<ITSInternalException> createITSInternalException(ITSInternalException value) {
        return new JAXBElement<ITSInternalException>(_ITSInternalException_QNAME, ITSInternalException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ITSBaseException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.stb.its.com/", name = "ITSBaseException")
    public JAXBElement<ITSBaseException> createITSBaseException(ITSBaseException value) {
        return new JAXBElement<ITSBaseException>(_ITSBaseException_QNAME, ITSBaseException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendNotificationWithTplResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.stb.its.com/", name = "sendNotificationWithTplResponse")
    public JAXBElement<SendNotificationWithTplResponse> createSendNotificationWithTplResponse(SendNotificationWithTplResponse value) {
        return new JAXBElement<SendNotificationWithTplResponse>(_SendNotificationWithTplResponse_QNAME, SendNotificationWithTplResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindTemplateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.stb.its.com/", name = "findTemplateResponse")
    public JAXBElement<FindTemplateResponse> createFindTemplateResponse(FindTemplateResponse value) {
        return new JAXBElement<FindTemplateResponse>(_FindTemplateResponse_QNAME, FindTemplateResponse.class, null, value);
    }

}
