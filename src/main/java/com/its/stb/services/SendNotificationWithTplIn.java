
package com.its.stb.services;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sendNotificationWithTplIn complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sendNotificationWithTplIn">
 *   &lt;complexContent>
 *     &lt;extension base="{http://services.stb.its.com/}genericServiceIn">
 *       &lt;sequence>
 *         &lt;element name="attachments" type="{http://services.stb.its.com/}fileAttach" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="codTemplate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="daytime" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="dest" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="expirationTimeSeconds" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="fields" type="{http://services.stb.its.com/}keyValuePair" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="lang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "sendNotificationWithTplIn", propOrder = {
    "attachments",
    "codTemplate",
    "daytime",
    "dest",
    "expirationTimeSeconds",
    "fields",
    "lang",
    "type"
})
public class SendNotificationWithTplIn
    extends GenericServiceIn
{

    @XmlElement(nillable = true)
    protected List<FileAttach> attachments;
    protected String codTemplate;
    protected boolean daytime;
    @XmlElement(nillable = true)
    protected List<String> dest;
    protected int expirationTimeSeconds;
    @XmlElement(nillable = true)
    protected List<KeyValuePair> fields;
    protected String lang;
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
     * Gets the value of the codTemplate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTemplate() {
        return codTemplate;
    }

    /**
     * Sets the value of the codTemplate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTemplate(String value) {
        this.codTemplate = value;
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
     * Gets the value of the fields property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fields property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFields().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KeyValuePair }
     * 
     * 
     */
    public List<KeyValuePair> getFields() {
        if (fields == null) {
            fields = new ArrayList<KeyValuePair>();
        }
        return this.fields;
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

}
