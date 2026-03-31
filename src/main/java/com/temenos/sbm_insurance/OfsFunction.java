
package com.temenos.sbm_insurance;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ofsFunction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ofsFunction">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="activityName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="assignReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dueDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="extProcess" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="extProcessID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gtsControl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="messageId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="noOfAuth" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="owner" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="replace" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="user" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ofsFunction", propOrder = {
    "activityName",
    "assignReason",
    "dueDate",
    "extProcess",
    "extProcessID",
    "gtsControl",
    "messageId",
    "noOfAuth",
    "owner",
    "replace",
    "startDate",
    "user"
})
public class OfsFunction {

    protected String activityName;
    protected String assignReason;
    protected String dueDate;
    protected String extProcess;
    protected String extProcessID;
    protected String gtsControl;
    protected String messageId;
    protected String noOfAuth;
    protected String owner;
    protected String replace;
    protected String startDate;
    protected String user;

    /**
     * Gets the value of the activityName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActivityName() {
        return activityName;
    }

    /**
     * Sets the value of the activityName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActivityName(String value) {
        this.activityName = value;
    }

    /**
     * Gets the value of the assignReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssignReason() {
        return assignReason;
    }

    /**
     * Sets the value of the assignReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssignReason(String value) {
        this.assignReason = value;
    }

    /**
     * Gets the value of the dueDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDueDate() {
        return dueDate;
    }

    /**
     * Sets the value of the dueDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDueDate(String value) {
        this.dueDate = value;
    }

    /**
     * Gets the value of the extProcess property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtProcess() {
        return extProcess;
    }

    /**
     * Sets the value of the extProcess property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtProcess(String value) {
        this.extProcess = value;
    }

    /**
     * Gets the value of the extProcessID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtProcessID() {
        return extProcessID;
    }

    /**
     * Sets the value of the extProcessID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtProcessID(String value) {
        this.extProcessID = value;
    }

    /**
     * Gets the value of the gtsControl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGtsControl() {
        return gtsControl;
    }

    /**
     * Sets the value of the gtsControl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGtsControl(String value) {
        this.gtsControl = value;
    }

    /**
     * Gets the value of the messageId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * Sets the value of the messageId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageId(String value) {
        this.messageId = value;
    }

    /**
     * Gets the value of the noOfAuth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoOfAuth() {
        return noOfAuth;
    }

    /**
     * Sets the value of the noOfAuth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoOfAuth(String value) {
        this.noOfAuth = value;
    }

    /**
     * Gets the value of the owner property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Sets the value of the owner property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwner(String value) {
        this.owner = value;
    }

    /**
     * Gets the value of the replace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReplace() {
        return replace;
    }

    /**
     * Sets the value of the replace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReplace(String value) {
        this.replace = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartDate(String value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the user property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUser(String value) {
        this.user = value;
    }


    @Override
    public String toString() {
        return "OfsFunction{" +
                "activityName='" + activityName + '\'' +
                ", assignReason='" + assignReason + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", extProcess='" + extProcess + '\'' +
                ", extProcessID='" + extProcessID + '\'' +
                ", gtsControl='" + gtsControl + '\'' +
                ", messageId='" + messageId + '\'' +
                ", noOfAuth='" + noOfAuth + '\'' +
                ", owner='" + owner + '\'' +
                ", replace='" + replace + '\'' +
                ", startDate='" + startDate + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}
