
package com.temenos.sbm_realtimepayment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.temenos.fundstransfersbrealtimepaymt.FUNDSTRANSFERSBREALTIMEPAYMTType;


/**
 * <p>Java class for SBRealTimePayments complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SBRealTimePayments">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WebRequestCommon" type="{http://temenos.com/SBM-RealTimePayment}webRequestCommon"/>
 *         &lt;element name="OfsFunction" type="{http://temenos.com/SBM-RealTimePayment}ofsFunction"/>
 *         &lt;element name="FUNDSTRANSFERSBREALTIMEPAYMTType" type="{http://temenos.com/FUNDSTRANSFERSBREALTIMEPAYMT}FUNDSTRANSFERSBREALTIMEPAYMTType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SBRealTimePayments", propOrder = {
    "webRequestCommon",
    "ofsFunction",
    "fundstransfersbrealtimepaymtType"
})
public class SBRealTimePayments {

    @XmlElement(name = "WebRequestCommon", required = true)
    protected WebRequestCommon webRequestCommon;
    @XmlElement(name = "OfsFunction", required = true)
    protected OfsFunction ofsFunction;
    @XmlElement(name = "FUNDSTRANSFERSBREALTIMEPAYMTType", required = true)
    protected FUNDSTRANSFERSBREALTIMEPAYMTType fundstransfersbrealtimepaymtType;

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
     * Gets the value of the ofsFunction property.
     * 
     * @return
     *     possible object is
     *     {@link OfsFunction }
     *     
     */
    public OfsFunction getOfsFunction() {
        return ofsFunction;
    }

    /**
     * Sets the value of the ofsFunction property.
     * 
     * @param value
     *     allowed object is
     *     {@link OfsFunction }
     *     
     */
    public void setOfsFunction(OfsFunction value) {
        this.ofsFunction = value;
    }

    /**
     * Gets the value of the fundstransfersbrealtimepaymtType property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERSBREALTIMEPAYMTType }
     *     
     */
    public FUNDSTRANSFERSBREALTIMEPAYMTType getFUNDSTRANSFERSBREALTIMEPAYMTType() {
        return fundstransfersbrealtimepaymtType;
    }

    /**
     * Sets the value of the fundstransfersbrealtimepaymtType property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERSBREALTIMEPAYMTType }
     *     
     */
    public void setFUNDSTRANSFERSBREALTIMEPAYMTType(FUNDSTRANSFERSBREALTIMEPAYMTType value) {
        this.fundstransfersbrealtimepaymtType = value;
    }

}
