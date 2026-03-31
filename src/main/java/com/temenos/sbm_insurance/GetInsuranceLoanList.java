
package com.temenos.sbm_insurance;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetInsuranceLoanList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetInsuranceLoanList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WebRequestCommon" type="{http://temenos.com/SBM-Insurance.Payment}webRequestCommon"/>
 *         &lt;element name="LOANSEGLISTType" type="{http://temenos.com/SBM-Insurance.Payment}enquiryInput"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetInsuranceLoanList", propOrder = {
    "webRequestCommon",
    "loanseglistType"
})
public class GetInsuranceLoanList {

    @XmlElement(name = "WebRequestCommon", required = true)
    protected WebRequestCommon webRequestCommon;
    @XmlElement(name = "LOANSEGLISTType", required = true)
    protected EnquiryInput loanseglistType;

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
     * Gets the value of the loanseglistType property.
     * 
     * @return
     *     possible object is
     *     {@link EnquiryInput }
     *     
     */
    public EnquiryInput getLOANSEGLISTType() {
        return loanseglistType;
    }

    /**
     * Sets the value of the loanseglistType property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnquiryInput }
     *     
     */
    public void setLOANSEGLISTType(EnquiryInput value) {
        this.loanseglistType = value;
    }

}
