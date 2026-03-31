
package com.temenos.sbm_insurance;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SBGetNetTxnDtx complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SBGetNetTxnDtx">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WebRequestCommon" type="{http://temenos.com/SBM-Insurance.Payment}webRequestCommon"/>
 *         &lt;element name="SBGETNETTXNDTXType" type="{http://temenos.com/SBM-Insurance.Payment}enquiryInput"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SBGetNetTxnDtx", propOrder = {
    "webRequestCommon",
    "sbgetnettxndtxType"
})
public class SBGetNetTxnDtx {

    @XmlElement(name = "WebRequestCommon", required = true)
    protected WebRequestCommon webRequestCommon;
    @XmlElement(name = "SBGETNETTXNDTXType", required = true)
    protected EnquiryInput sbgetnettxndtxType;

    /**
     * Gets the value of the webRequestCommon property.
     * 
     * @return
     *     possible object is
     *     {@link WebRequestCommon }
     *     
     */
    public WebRequestCommon getWebRequestCommon() {
        return webRequestCommon;
    }

    /**
     * Sets the value of the webRequestCommon property.
     * 
     * @param value
     *     allowed object is
     *     {@link WebRequestCommon }
     *     
     */
    public void setWebRequestCommon(WebRequestCommon value) {
        this.webRequestCommon = value;
    }

    /**
     * Gets the value of the sbgetnettxndtxType property.
     * 
     * @return
     *     possible object is
     *     {@link EnquiryInput }
     *     
     */
    public EnquiryInput getSBGETNETTXNDTXType() {
        return sbgetnettxndtxType;
    }

    /**
     * Sets the value of the sbgetnettxndtxType property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnquiryInput }
     *     
     */
    public void setSBGETNETTXNDTXType(EnquiryInput value) {
        this.sbgetnettxndtxType = value;
    }

}
