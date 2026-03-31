
package com.temenos.sbm_realtimepayment;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.temenos.sbgetacctdtxnet.SBGETACCTDTXNETType;


/**
 * <p>Java class for SBGetAccountDetailsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SBGetAccountDetailsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Status" type="{http://temenos.com/SBM-RealTimePayment}Status" minOccurs="0"/>
 *         &lt;element name="SBGETACCTDTXNETType" type="{http://temenos.com/SBGETACCTDTXNET}SBGETACCTDTXNETType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SBGetAccountDetailsResponse", propOrder = {
    "status",
    "sbgetacctdtxnetType"
})
public class SBGetAccountDetailsResponse {

    @XmlElement(name = "Status")
    protected Status status;
    @XmlElement(name = "SBGETACCTDTXNETType")
    protected List<SBGETACCTDTXNETType> sbgetacctdtxnetType;

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
     * Gets the value of the sbgetacctdtxnetType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sbgetacctdtxnetType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSBGETACCTDTXNETType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SBGETACCTDTXNETType }
     * 
     * 
     */
    public List<SBGETACCTDTXNETType> getSBGETACCTDTXNETType() {
        if (sbgetacctdtxnetType == null) {
            sbgetacctdtxnetType = new ArrayList<SBGETACCTDTXNETType>();
        }
        return this.sbgetacctdtxnetType;
    }

}
