
package com.its.stb.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sendNotification complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sendNotification">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://services.stb.its.com/}itsRequestContext" minOccurs="0"/>
 *         &lt;element name="arg1" type="{http://services.stb.its.com/}sendNotificationIn" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sendNotification", propOrder = {
    "arg0",
    "arg1"
})
public class SendNotification {

    protected ItsRequestContext arg0;
    protected SendNotificationIn arg1;

    /**
     * Gets the value of the arg0 property.
     * 
     * @return
     *     possible object is
     *     {@link ItsRequestContext }
     *     
     */
    public ItsRequestContext getArg0() {
        return arg0;
    }

    /**
     * Sets the value of the arg0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItsRequestContext }
     *     
     */
    public void setArg0(ItsRequestContext value) {
        this.arg0 = value;
    }

    /**
     * Gets the value of the arg1 property.
     * 
     * @return
     *     possible object is
     *     {@link SendNotificationIn }
     *     
     */
    public SendNotificationIn getArg1() {
        return arg1;
    }

    /**
     * Sets the value of the arg1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link SendNotificationIn }
     *     
     */
    public void setArg1(SendNotificationIn value) {
        this.arg1 = value;
    }

}
