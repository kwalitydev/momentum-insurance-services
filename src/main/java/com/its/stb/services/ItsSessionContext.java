
package com.its.stb.services;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for itsSessionContext complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="itsSessionContext">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="authenticated" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="businessModel" type="{http://services.stb.its.com/}businessModel" minOccurs="0"/>
 *         &lt;element name="clientToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prfMenuList" type="{http://www.w3.org/2001/XMLSchema}anyType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "itsSessionContext", propOrder = {
    "authenticated",
    "businessModel",
    "clientToken",
    "prfMenuList",
    "username"
})
public class ItsSessionContext {

    protected boolean authenticated;
    @XmlSchemaType(name = "string")
    protected BusinessModel businessModel;
    protected String clientToken;
    @XmlElement(nillable = true)
    protected List<Object> prfMenuList;
    protected String username;

    /**
     * Gets the value of the authenticated property.
     * 
     */
    public boolean isAuthenticated() {
        return authenticated;
    }

    /**
     * Sets the value of the authenticated property.
     * 
     */
    public void setAuthenticated(boolean value) {
        this.authenticated = value;
    }

    /**
     * Gets the value of the businessModel property.
     * 
     * @return
     *     possible object is
     *     {@link BusinessModel }
     *     
     */
    public BusinessModel getBusinessModel() {
        return businessModel;
    }

    /**
     * Sets the value of the businessModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link BusinessModel }
     *     
     */
    public void setBusinessModel(BusinessModel value) {
        this.businessModel = value;
    }

    /**
     * Gets the value of the clientToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientToken() {
        return clientToken;
    }

    /**
     * Sets the value of the clientToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientToken(String value) {
        this.clientToken = value;
    }

    /**
     * Gets the value of the prfMenuList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the prfMenuList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrfMenuList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getPrfMenuList() {
        if (prfMenuList == null) {
            prfMenuList = new ArrayList<Object>();
        }
        return this.prfMenuList;
    }

    /**
     * Gets the value of the username property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the value of the username property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername(String value) {
        this.username = value;
    }

}
