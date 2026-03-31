
package com.temenos.sbm_insurance;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.temenos.ebsbsegupdates.EBSBSEGUPDATESType;


/**
 * <p>Java class for SBInsuranceUpdateTableResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SBInsuranceUpdateTableResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Status" type="{http://temenos.com/SBM-Insurance.Payment}Status" minOccurs="0"/>
 *         &lt;element name="EBSBSEGUPDATESType" type="{http://temenos.com/EBSBSEGUPDATES}EBSBSEGUPDATESType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SBInsuranceUpdateTableResponse", propOrder = {
    "status",
    "ebsbsegupdatesType"
})
public class SBInsuranceUpdateTableResponse {

    @XmlElement(name = "Status")
    protected Status status;
    @XmlElement(name = "EBSBSEGUPDATESType")
    protected EBSBSEGUPDATESType ebsbsegupdatesType;

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link Status }
     *     
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link Status }
     *     
     */
    public void setStatus(Status value) {
        this.status = value;
    }

    /**
     * Gets the value of the ebsbsegupdatesType property.
     * 
     * @return
     *     possible object is
     *     {@link EBSBSEGUPDATESType }
     *     
     */
    public EBSBSEGUPDATESType getEBSBSEGUPDATESType() {
        return ebsbsegupdatesType;
    }

    /**
     * Sets the value of the ebsbsegupdatesType property.
     * 
     * @param value
     *     allowed object is
     *     {@link EBSBSEGUPDATESType }
     *     
     */
    public void setEBSBSEGUPDATESType(EBSBSEGUPDATESType value) {
        this.ebsbsegupdatesType = value;
    }

    @Override
    public String toString() {
        return "SBInsuranceUpdateTableResponse{" +
                "status=" + status +
                ", ebsbsegupdatesType=" + ebsbsegupdatesType +
                '}';
    }
}
