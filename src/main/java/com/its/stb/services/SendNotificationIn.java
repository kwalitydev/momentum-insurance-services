
package com.its.stb.services;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sendNotificationIn complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sendNotificationIn">
 *   &lt;complexContent>
 *     &lt;extension base="{http://services.stb.its.com/}genericServiceIn">
 *       &lt;sequence>
 *         &lt;element name="attachments" type="{http://services.stb.its.com/}fileAttach" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="body" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="daytime" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="dest" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="encryptMessageBody" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="expirationTimeSeconds" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="lang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subject" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="type" type="{http://services.stb.its.com/}notificationTypes" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sendNotificationIn", propOrder = {
    "attachments",
    "body",
    "daytime",
    "dest",
    "encryptMessageBody",
    "expirationTimeSeconds",
    "lang",
    "subject",
    "type"
})
public class SendNotificationIn
    extends GenericServiceIn
{

    @XmlElement(nillable = true)
    protected List<FileAttach> attachments;
    protected String body;
    protected boolean daytime;
    @XmlElement(nillable = true)
    protected List<String> dest;
    protected boolean encryptMessageBody;
    protected int expirationTimeSeconds;
    protected String lang;
    protected String subject;
    @XmlSchemaType(name = "string")
    protected NotificationTypes type;

    /**
     * Gets the value of the attachments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attachments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttachments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FileAttach }
     * 
     * 
     */
    public List<FileAttach> getAttachments() {
        if (attachments == null) {
            attachments = new ArrayList<FileAttach>();
        }
        return this.attachments;
    }

    /**
     * Gets the value of the body property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBody() {
        return body;
    }

    /**
     * Sets the value of the body property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBody(String value) {
        this.body = value;
    }

    /**
     * Gets the value of the daytime property.
     * 
     */
    public boolean isDaytime() {
        return daytime;
    }

    /**
     * Sets the value of the daytime property.
     * 
     */
    public void setDaytime(boolean value) {
        this.daytime = value;
    }

    /**
     * Gets the value of the dest property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dest property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDest().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getDest() {
        if (dest == null) {
            dest = new ArrayList<String>();
        }
        return this.dest;
    }

    /**
     * Gets the value of the encryptMessageBody property.
     * 
     */
    public boolean isEncryptMessageBody() {
        return encryptMessageBody;
    }

    /**
     * Sets the value of the encryptMessageBody property.
     * 
     */
    public void setEncryptMessageBody(boolean value) {
        this.encryptMessageBody = value;
    }

    /**
     * Gets the value of the expirationTimeSeconds property.
     * 
     */
    public int getExpirationTimeSeconds() {
        return expirationTimeSeconds;
    }

    /**
     * Sets the value of the expirationTimeSeconds property.
     * 
     */
    public void setExpirationTimeSeconds(int value) {
        this.expirationTimeSeconds = value;
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
     * Gets the value of the subject property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets the value of the subject property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubject(String value) {
        this.subject = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link NotificationTypes }
     *     
     */
    public NotificationTypes getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link NotificationTypes }
     *     
     */
    public void setType(NotificationTypes value) {
        this.type = value;
    }

    public void setDest(List<String> dest) {
        this.dest = dest;
    }

    @Override
    public String toString() {
        return "SendNotificationIn{" +
                "attachments=" + attachments +
                ", body='" + body + '\'' +
                ", daytime=" + daytime +
                ", dest=" + dest +
                ", encryptMessageBody=" + encryptMessageBody +
                ", expirationTimeSeconds=" + expirationTimeSeconds +
                ", lang='" + lang + '\'' +
                ", subject='" + subject + '\'' +
                ", type=" + type +
                '}';
    }
}
