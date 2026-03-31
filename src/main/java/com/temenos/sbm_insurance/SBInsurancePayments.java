
package com.temenos.sbm_insurance;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.temenos.fundstransfersegtws.FUNDSTRANSFERSEGTWSType;


/**
 * <p>Java class for SBInsurancePayments complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SBInsurancePayments">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WebRequestCommon" type="{http://temenos.com/SBM-Insurance.Payment}webRequestCommon"/>
 *         &lt;element name="OfsFunction" type="{http://temenos.com/SBM-Insurance.Payment}ofsFunction"/>
 *         &lt;element name="FUNDSTRANSFERSEGTWSType" type="{http://temenos.com/FUNDSTRANSFERSEGTWS}FUNDSTRANSFERSEGTWSType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SBInsurancePayments", propOrder = {
    "webRequestCommon",
    "ofsFunction",
    "fundstransfersegtwsType"
})
public class SBInsurancePayments {

    @XmlElement(name = "WebRequestCommon", required = true)
    protected WebRequestCommon webRequestCommon;
    @XmlElement(name = "OfsFunction", required = true)
    protected OfsFunction ofsFunction;
    @XmlElement(name = "FUNDSTRANSFERSEGTWSType", required = true)
    protected FUNDSTRANSFERSEGTWSType fundstransfersegtwsType;

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
     * Gets the value of the fundstransfersegtwsType property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERSEGTWSType }
     *     
     */
    public FUNDSTRANSFERSEGTWSType getFUNDSTRANSFERSEGTWSType() {
        return fundstransfersegtwsType;
    }

    /**
     * Sets the value of the fundstransfersegtwsType property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERSEGTWSType }
     *     
     */
    public void setFUNDSTRANSFERSEGTWSType(FUNDSTRANSFERSEGTWSType value) {
        this.fundstransfersegtwsType = value;
    }

    public FUNDSTRANSFERSEGTWSType getFundstransfersegtwsType() {
        return fundstransfersegtwsType;
    }

    public void setFundstransfersegtwsType(FUNDSTRANSFERSEGTWSType fundstransfersegtwsType) {
        this.fundstransfersegtwsType = fundstransfersegtwsType;
    }

    @Override
    public String toString() {
        return "SBInsurancePayments{" +
                "webRequestCommon=" + webRequestCommon +
                ", ofsFunction=" + ofsFunction +
                ", fundstransfersegtwsType=" + fundstransfersegtwsType +
                '}';
    }
}
