
package com.temenos.sbm_insurance;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.temenos.ebsbseguros.EBSBSEGUROSType;


/**
 * <p>Java class for SBInsuranceTableResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SBInsuranceTableResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Status" type="{http://temenos.com/SBM-Insurance.Payment}Status" minOccurs="0"/>
 *         &lt;element name="EBSBSEGUROSType" type="{http://temenos.com/EBSBSEGUROS}EBSBSEGUROSType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SBInsuranceTableResponse", propOrder = {
    "status",
    "ebsbsegurosType"
})
public class SBInsuranceTableResponse {

    @XmlElement(name = "Status")
    protected Status status;
    @XmlElement(name = "EBSBSEGUROSType")
    protected EBSBSEGUROSType ebsbsegurosType;

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
     * Gets the value of the ebsbsegurosType property.
     * 
     * @return
     *     possible object is
     *     {@link EBSBSEGUROSType }
     *     
     */
    public EBSBSEGUROSType getEBSBSEGUROSType() {
        return ebsbsegurosType;
    }

    /**
     * Sets the value of the ebsbsegurosType property.
     * 
     * @param value
     *     allowed object is
     *     {@link EBSBSEGUROSType }
     *     
     */
    public void setEBSBSEGUROSType(EBSBSEGUROSType value) {
        this.ebsbsegurosType = value;
    }

    @Override
    public String toString() {
        return "SBInsuranceTableResponse{" +
                "status=" + status +
                ", ebsbsegurosType=" + ebsbsegurosType +
                '}';
    }
}
