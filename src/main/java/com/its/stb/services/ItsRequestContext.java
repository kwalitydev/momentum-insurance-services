
package com.its.stb.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for itsRequestContext complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="itsRequestContext">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="appVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="channel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="commMean" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="deviceSOVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="location" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="requestId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sessionContext" type="{http://services.stb.its.com/}itsSessionContext" minOccurs="0"/>
 *         &lt;element name="traceLevel" type="{http://services.stb.its.com/}traceLevels" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "itsRequestContext", propOrder = {
    "appVersion",
    "channel",
    "commMean",
    "deviceSOVersion",
    "lang",
    "location",
    "requestId",
    "sessionContext",
    "traceLevel"
})
public class ItsRequestContext {

    protected String appVersion;
    protected String channel;
    protected String commMean;
    protected String deviceSOVersion;
    protected String lang;
    protected String location;
    protected String requestId;
    protected ItsSessionContext sessionContext;
    @XmlSchemaType(name = "string")
    protected TraceLevels traceLevel;

    /**
     * Gets the value of the appVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAppVersion() {
        return appVersion;
    }

    /**
     * Sets the value of the appVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAppVersion(String value) {
        this.appVersion = value;
    }

    /**
     * Gets the value of the channel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChannel() {
        return channel;
    }

    /**
     * Sets the value of the channel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChannel(String value) {
        this.channel = value;
    }

    /**
     * Gets the value of the commMean property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommMean() {
        return commMean;
    }

    /**
     * Sets the value of the commMean property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommMean(String value) {
        this.commMean = value;
    }

    /**
     * Gets the value of the deviceSOVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceSOVersion() {
        return deviceSOVersion;
    }

    /**
     * Sets the value of the deviceSOVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceSOVersion(String value) {
        this.deviceSOVersion = value;
    }

    /**
     * Gets the value of the lang property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLang() {
        return lang;
    }

    /**
     * Sets the value of the lang property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLang(String value) {
        this.lang = value;
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocation(String value) {
        this.location = value;
    }

    /**
     * Gets the value of the requestId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * Sets the value of the requestId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestId(String value) {
        this.requestId = value;
    }

    /**
     * Gets the value of the sessionContext property.
     * 
     * @return
     *     possible object is
     *     {@link ItsSessionContext }
     *     
     */
    public ItsSessionContext getSessionContext() {
        return sessionContext;
    }

    /**
     * Sets the value of the sessionContext property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItsSessionContext }
     *     
     */
    public void setSessionContext(ItsSessionContext value) {
        this.sessionContext = value;
    }

    /**
     * Gets the value of the traceLevel property.
     * 
     * @return
     *     possible object is
     *     {@link TraceLevels }
     *     
     */
    public TraceLevels getTraceLevel() {
        return traceLevel;
    }

    /**
     * Sets the value of the traceLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link TraceLevels }
     *     
     */
    public void setTraceLevel(TraceLevels value) {
        this.traceLevel = value;
    }

}
