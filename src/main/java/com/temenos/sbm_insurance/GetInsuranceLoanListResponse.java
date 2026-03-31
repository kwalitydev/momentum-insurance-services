
package com.temenos.sbm_insurance;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.temenos.loanseglist.LOANSEGLISTType;


/**
 * <p>Java class for GetInsuranceLoanListResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetInsuranceLoanListResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Status" type="{http://temenos.com/SBM-Insurance.Payment}Status" minOccurs="0"/>
 *         &lt;element name="LOANSEGLISTType" type="{http://temenos.com/LOANSEGLIST}LOANSEGLISTType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetInsuranceLoanListResponse", propOrder = {
    "status",
    "loanseglistType"
})
public class GetInsuranceLoanListResponse {

    @XmlElement(name = "Status")
    protected Status status;
    @XmlElement(name = "LOANSEGLISTType")
    protected List<LOANSEGLISTType> loanseglistType;

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
     * Gets the value of the loanseglistType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the loanseglistType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLOANSEGLISTType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LOANSEGLISTType }
     * 
     * 
     */
    public List<LOANSEGLISTType> getLOANSEGLISTType() {
        if (loanseglistType == null) {
            loanseglistType = new ArrayList<LOANSEGLISTType>();
        }
        return this.loanseglistType;
    }

}
