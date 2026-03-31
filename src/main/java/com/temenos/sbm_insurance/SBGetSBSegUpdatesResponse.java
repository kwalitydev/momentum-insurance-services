
package com.temenos.sbm_insurance;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.temenos.sbgetsbsegupdates.SBGETSBSEGUPDATESType;


/**
 * <p>Java class for SBGetSBSegUpdatesResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SBGetSBSegUpdatesResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Status" type="{http://temenos.com/SBM-Insurance.Payment}Status" minOccurs="0"/>
 *         &lt;element name="SBGETSBSEGUPDATESType" type="{http://temenos.com/SBGETSBSEGUPDATES}SBGETSBSEGUPDATESType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SBGetSBSegUpdatesResponse", propOrder = {
    "status",
    "sbgetsbsegupdatesType"
})
public class SBGetSBSegUpdatesResponse {

    @XmlElement(name = "Status")
    protected Status status;
    @XmlElement(name = "SBGETSBSEGUPDATESType")
    protected List<SBGETSBSEGUPDATESType> sbgetsbsegupdatesType;

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
     * Gets the value of the sbgetsbsegupdatesType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sbgetsbsegupdatesType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSBGETSBSEGUPDATESType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SBGETSBSEGUPDATESType }
     * 
     * 
     */
    public List<SBGETSBSEGUPDATESType> getSBGETSBSEGUPDATESType() {
        if (sbgetsbsegupdatesType == null) {
            sbgetsbsegupdatesType = new ArrayList<SBGETSBSEGUPDATESType>();
        }
        return this.sbgetsbsegupdatesType;
    }

}
