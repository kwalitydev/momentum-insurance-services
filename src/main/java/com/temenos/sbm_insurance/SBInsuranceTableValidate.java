
package com.temenos.sbm_insurance;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.temenos.ebsbsegurosinsmigration.EBSBSEGUROSINSMIGRATIONType;


/**
 * <p>Java class for SBInsuranceTable_Validate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SBInsuranceTable_Validate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WebRequestCommon" type="{http://temenos.com/SBM-Insurance.Payment}webRequestCommon"/>
 *         &lt;element name="OfsFunction" type="{http://temenos.com/SBM-Insurance.Payment}ofsFunction"/>
 *         &lt;element name="EBSBSEGUROSINSMIGRATIONType" type="{http://temenos.com/EBSBSEGUROSINSMIGRATION}EBSBSEGUROSINSMIGRATIONType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SBInsuranceTable_Validate", propOrder = {
    "webRequestCommon",
    "ofsFunction",
    "ebsbsegurosinsmigrationType"
})
public class SBInsuranceTableValidate {

    @XmlElement(name = "WebRequestCommon", required = true)
    protected WebRequestCommon webRequestCommon;
    @XmlElement(name = "OfsFunction", required = true)
    protected OfsFunction ofsFunction;
    @XmlElement(name = "EBSBSEGUROSINSMIGRATIONType", required = true)
    protected EBSBSEGUROSINSMIGRATIONType ebsbsegurosinsmigrationType;

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
     * Gets the value of the ebsbsegurosinsmigrationType property.
     * 
     * @return
     *     possible object is
     *     {@link EBSBSEGUROSINSMIGRATIONType }
     *     
     */
    public EBSBSEGUROSINSMIGRATIONType getEBSBSEGUROSINSMIGRATIONType() {
        return ebsbsegurosinsmigrationType;
    }

    /**
     * Sets the value of the ebsbsegurosinsmigrationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link EBSBSEGUROSINSMIGRATIONType }
     *     
     */
    public void setEBSBSEGUROSINSMIGRATIONType(EBSBSEGUROSINSMIGRATIONType value) {
        this.ebsbsegurosinsmigrationType = value;
    }

}
