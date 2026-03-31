
package com.temenos.ebsbsegupdates;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EBSBSEGUPDATESType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EBSBSEGUPDATESType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TRANSTYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PROCESSDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CURRENCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TRANSAMOUNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TRANSID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PAYMENTSTATUS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PAYMENTDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MIGRATIONSTATUS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gOVERRIDE" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="OVERRIDE" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="RECORDSTATUS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CURRNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gINPUTTER" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="INPUTTER" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="gDATETIME" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="DATETIME" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="AUTHORISER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COCODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DEPTCODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AUDITORCODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AUDITDATETIME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EBSBSEGUPDATESType", propOrder = {
    "transtype",
    "processdate",
    "currency",
    "transamount",
    "transid",
    "paymentstatus",
    "paymentdate",
    "migrationstatus",
    "goverride",
    "recordstatus",
    "currno",
    "ginputter",
    "gdatetime",
    "authoriser",
    "cocode",
    "deptcode",
    "auditorcode",
    "auditdatetime"
})
public class EBSBSEGUPDATESType {

    @XmlElement(name = "TRANSTYPE")
    protected String transtype;
    @XmlElement(name = "PROCESSDATE")
    protected String processdate;
    @XmlElement(name = "CURRENCY")
    protected String currency;
    @XmlElement(name = "TRANSAMOUNT")
    protected String transamount;
    @XmlElement(name = "TRANSID")
    protected String transid;
    @XmlElement(name = "PAYMENTSTATUS")
    protected String paymentstatus;
    @XmlElement(name = "PAYMENTDATE")
    protected String paymentdate;
    @XmlElement(name = "MIGRATIONSTATUS")
    protected String migrationstatus;
    @XmlElement(name = "gOVERRIDE")
    protected EBSBSEGUPDATESType.GOVERRIDE goverride;
    @XmlElement(name = "RECORDSTATUS")
    protected String recordstatus;
    @XmlElement(name = "CURRNO")
    protected String currno;
    @XmlElement(name = "gINPUTTER")
    protected EBSBSEGUPDATESType.GINPUTTER ginputter;
    @XmlElement(name = "gDATETIME")
    protected EBSBSEGUPDATESType.GDATETIME gdatetime;
    @XmlElement(name = "AUTHORISER")
    protected String authoriser;
    @XmlElement(name = "COCODE")
    protected String cocode;
    @XmlElement(name = "DEPTCODE")
    protected String deptcode;
    @XmlElement(name = "AUDITORCODE")
    protected String auditorcode;
    @XmlElement(name = "AUDITDATETIME")
    protected String auditdatetime;
    @XmlAttribute(name = "id")
    protected String id;

    /**
     * Gets the value of the transtype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTRANSTYPE() {
        return transtype;
    }

    /**
     * Sets the value of the transtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTRANSTYPE(String value) {
        this.transtype = value;
    }

    /**
     * Gets the value of the processdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPROCESSDATE() {
        return processdate;
    }

    /**
     * Sets the value of the processdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPROCESSDATE(String value) {
        this.processdate = value;
    }

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCURRENCY() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCURRENCY(String value) {
        this.currency = value;
    }

    /**
     * Gets the value of the transamount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTRANSAMOUNT() {
        return transamount;
    }

    /**
     * Sets the value of the transamount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTRANSAMOUNT(String value) {
        this.transamount = value;
    }

    /**
     * Gets the value of the transid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTRANSID() {
        return transid;
    }

    /**
     * Sets the value of the transid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTRANSID(String value) {
        this.transid = value;
    }

    /**
     * Gets the value of the paymentstatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAYMENTSTATUS() {
        return paymentstatus;
    }

    /**
     * Sets the value of the paymentstatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAYMENTSTATUS(String value) {
        this.paymentstatus = value;
    }

    /**
     * Gets the value of the paymentdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAYMENTDATE() {
        return paymentdate;
    }

    /**
     * Sets the value of the paymentdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAYMENTDATE(String value) {
        this.paymentdate = value;
    }

    /**
     * Gets the value of the migrationstatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMIGRATIONSTATUS() {
        return migrationstatus;
    }

    /**
     * Sets the value of the migrationstatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMIGRATIONSTATUS(String value) {
        this.migrationstatus = value;
    }

    /**
     * Gets the value of the goverride property.
     * 
     * @return
     *     possible object is
     *     {@link EBSBSEGUPDATESType.GOVERRIDE }
     *     
     */
    public EBSBSEGUPDATESType.GOVERRIDE getGOVERRIDE() {
        return goverride;
    }

    /**
     * Sets the value of the goverride property.
     * 
     * @param value
     *     allowed object is
     *     {@link EBSBSEGUPDATESType.GOVERRIDE }
     *     
     */
    public void setGOVERRIDE(EBSBSEGUPDATESType.GOVERRIDE value) {
        this.goverride = value;
    }

    /**
     * Gets the value of the recordstatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRECORDSTATUS() {
        return recordstatus;
    }

    /**
     * Sets the value of the recordstatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRECORDSTATUS(String value) {
        this.recordstatus = value;
    }

    /**
     * Gets the value of the currno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCURRNO() {
        return currno;
    }

    /**
     * Sets the value of the currno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCURRNO(String value) {
        this.currno = value;
    }

    /**
     * Gets the value of the ginputter property.
     * 
     * @return
     *     possible object is
     *     {@link EBSBSEGUPDATESType.GINPUTTER }
     *     
     */
    public EBSBSEGUPDATESType.GINPUTTER getGINPUTTER() {
        return ginputter;
    }

    /**
     * Sets the value of the ginputter property.
     * 
     * @param value
     *     allowed object is
     *     {@link EBSBSEGUPDATESType.GINPUTTER }
     *     
     */
    public void setGINPUTTER(EBSBSEGUPDATESType.GINPUTTER value) {
        this.ginputter = value;
    }

    /**
     * Gets the value of the gdatetime property.
     * 
     * @return
     *     possible object is
     *     {@link EBSBSEGUPDATESType.GDATETIME }
     *     
     */
    public EBSBSEGUPDATESType.GDATETIME getGDATETIME() {
        return gdatetime;
    }

    /**
     * Sets the value of the gdatetime property.
     * 
     * @param value
     *     allowed object is
     *     {@link EBSBSEGUPDATESType.GDATETIME }
     *     
     */
    public void setGDATETIME(EBSBSEGUPDATESType.GDATETIME value) {
        this.gdatetime = value;
    }

    /**
     * Gets the value of the authoriser property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAUTHORISER() {
        return authoriser;
    }

    /**
     * Sets the value of the authoriser property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAUTHORISER(String value) {
        this.authoriser = value;
    }

    /**
     * Gets the value of the cocode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOCODE() {
        return cocode;
    }

    /**
     * Sets the value of the cocode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOCODE(String value) {
        this.cocode = value;
    }

    /**
     * Gets the value of the deptcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDEPTCODE() {
        return deptcode;
    }

    /**
     * Sets the value of the deptcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDEPTCODE(String value) {
        this.deptcode = value;
    }

    /**
     * Gets the value of the auditorcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAUDITORCODE() {
        return auditorcode;
    }

    /**
     * Sets the value of the auditorcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAUDITORCODE(String value) {
        this.auditorcode = value;
    }

    /**
     * Gets the value of the auditdatetime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAUDITDATETIME() {
        return auditdatetime;
    }

    /**
     * Sets the value of the auditdatetime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAUDITDATETIME(String value) {
        this.auditdatetime = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="DATETIME" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "datetime"
    })
    public static class GDATETIME {

        @XmlElement(name = "DATETIME")
        protected List<String> datetime;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the datetime property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the datetime property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDATETIME().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getDATETIME() {
            if (datetime == null) {
                datetime = new ArrayList<String>();
            }
            return this.datetime;
        }

        /**
         * Gets the value of the g property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getG() {
            return g;
        }

        /**
         * Sets the value of the g property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setG(BigInteger value) {
            this.g = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="INPUTTER" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "inputter"
    })
    public static class GINPUTTER {

        @XmlElement(name = "INPUTTER")
        protected List<String> inputter;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the inputter property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the inputter property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getINPUTTER().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getINPUTTER() {
            if (inputter == null) {
                inputter = new ArrayList<String>();
            }
            return this.inputter;
        }

        /**
         * Gets the value of the g property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getG() {
            return g;
        }

        /**
         * Sets the value of the g property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setG(BigInteger value) {
            this.g = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="OVERRIDE" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "override"
    })
    public static class GOVERRIDE {

        @XmlElement(name = "OVERRIDE")
        protected List<String> override;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the override property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the override property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getOVERRIDE().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getOVERRIDE() {
            if (override == null) {
                override = new ArrayList<String>();
            }
            return this.override;
        }

        /**
         * Gets the value of the g property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getG() {
            return g;
        }

        /**
         * Sets the value of the g property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setG(BigInteger value) {
            this.g = value;
        }

    }

    @Override
    public String toString() {
        return "EBSBSEGUPDATESType{" +
                "transtype='" + transtype + '\'' +
                ", processdate='" + processdate + '\'' +
                ", currency='" + currency + '\'' +
                ", transamount='" + transamount + '\'' +
                ", transid='" + transid + '\'' +
                ", paymentstatus='" + paymentstatus + '\'' +
                ", paymentdate='" + paymentdate + '\'' +
                ", migrationstatus='" + migrationstatus + '\'' +
                ", goverride=" + goverride +
                ", recordstatus='" + recordstatus + '\'' +
                ", currno='" + currno + '\'' +
                ", ginputter=" + ginputter +
                ", gdatetime=" + gdatetime +
                ", authoriser='" + authoriser + '\'' +
                ", cocode='" + cocode + '\'' +
                ", deptcode='" + deptcode + '\'' +
                ", auditorcode='" + auditorcode + '\'' +
                ", auditdatetime='" + auditdatetime + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
