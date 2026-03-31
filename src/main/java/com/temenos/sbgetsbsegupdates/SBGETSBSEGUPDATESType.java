
package com.temenos.sbgetsbsegupdates;

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
 * <p>Java class for SBGETSBSEGUPDATESType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SBGETSBSEGUPDATESType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="gSBGETSBSEGUPDATESDetailType" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="mSBGETSBSEGUPDATESDetailType" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="SEGID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="TRANSTYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="PROCESSDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="CURRENCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="TRANSAMOUNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="MIGRATIONSTATUS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="TRANSID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="PAYMENTSTATUS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="PAYMENTDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                           &lt;/sequence>
 *                           &lt;attribute name="m" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SBGETSBSEGUPDATESType", propOrder = {
    "gsbgetsbsegupdatesDetailType"
})
public class SBGETSBSEGUPDATESType {

    @XmlElement(name = "gSBGETSBSEGUPDATESDetailType")
    protected SBGETSBSEGUPDATESType.GSBGETSBSEGUPDATESDetailType gsbgetsbsegupdatesDetailType;

    /**
     * Gets the value of the gsbgetsbsegupdatesDetailType property.
     * 
     * @return
     *     possible object is
     *     {@link SBGETSBSEGUPDATESType.GSBGETSBSEGUPDATESDetailType }
     *     
     */
    public SBGETSBSEGUPDATESType.GSBGETSBSEGUPDATESDetailType getGSBGETSBSEGUPDATESDetailType() {
        return gsbgetsbsegupdatesDetailType;
    }

    /**
     * Sets the value of the gsbgetsbsegupdatesDetailType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SBGETSBSEGUPDATESType.GSBGETSBSEGUPDATESDetailType }
     *     
     */
    public void setGSBGETSBSEGUPDATESDetailType(SBGETSBSEGUPDATESType.GSBGETSBSEGUPDATESDetailType value) {
        this.gsbgetsbsegupdatesDetailType = value;
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
     *         &lt;element name="mSBGETSBSEGUPDATESDetailType" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="SEGID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="TRANSTYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="PROCESSDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="CURRENCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="TRANSAMOUNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="MIGRATIONSTATUS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="TRANSID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="PAYMENTSTATUS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="PAYMENTDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                 &lt;/sequence>
     *                 &lt;attribute name="m" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "msbgetsbsegupdatesDetailType"
    })
    public static class GSBGETSBSEGUPDATESDetailType {

        @XmlElement(name = "mSBGETSBSEGUPDATESDetailType")
        protected List<SBGETSBSEGUPDATESType.GSBGETSBSEGUPDATESDetailType.MSBGETSBSEGUPDATESDetailType> msbgetsbsegupdatesDetailType;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the msbgetsbsegupdatesDetailType property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the msbgetsbsegupdatesDetailType property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMSBGETSBSEGUPDATESDetailType().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SBGETSBSEGUPDATESType.GSBGETSBSEGUPDATESDetailType.MSBGETSBSEGUPDATESDetailType }
         * 
         * 
         */
        public List<SBGETSBSEGUPDATESType.GSBGETSBSEGUPDATESDetailType.MSBGETSBSEGUPDATESDetailType> getMSBGETSBSEGUPDATESDetailType() {
            if (msbgetsbsegupdatesDetailType == null) {
                msbgetsbsegupdatesDetailType = new ArrayList<SBGETSBSEGUPDATESType.GSBGETSBSEGUPDATESDetailType.MSBGETSBSEGUPDATESDetailType>();
            }
            return this.msbgetsbsegupdatesDetailType;
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
         *         &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="SEGID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="TRANSTYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="PROCESSDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="CURRENCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="TRANSAMOUNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="MIGRATIONSTATUS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="TRANSID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="PAYMENTSTATUS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="PAYMENTDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *       &lt;/sequence>
         *       &lt;attribute name="m" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "id",
            "segid",
            "transtype",
            "processdate",
            "currency",
            "transamount",
            "migrationstatus",
            "transid",
            "paymentstatus",
            "paymentdate"
        })
        public static class MSBGETSBSEGUPDATESDetailType {

            @XmlElement(name = "ID")
            protected String id;
            @XmlElement(name = "SEGID")
            protected String segid;
            @XmlElement(name = "TRANSTYPE")
            protected String transtype;
            @XmlElement(name = "PROCESSDATE")
            protected String processdate;
            @XmlElement(name = "CURRENCY")
            protected String currency;
            @XmlElement(name = "TRANSAMOUNT")
            protected String transamount;
            @XmlElement(name = "MIGRATIONSTATUS")
            protected String migrationstatus;
            @XmlElement(name = "TRANSID")
            protected String transid;
            @XmlElement(name = "PAYMENTSTATUS")
            protected String paymentstatus;
            @XmlElement(name = "PAYMENTDATE")
            protected String paymentdate;
            @XmlAttribute(name = "m")
            @XmlSchemaType(name = "positiveInteger")
            protected BigInteger m;

            /**
             * Gets the value of the id property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getID() {
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
            public void setID(String value) {
                this.id = value;
            }

            /**
             * Gets the value of the segid property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSEGID() {
                return segid;
            }

            /**
             * Sets the value of the segid property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSEGID(String value) {
                this.segid = value;
            }

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
             * Gets the value of the m property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getM() {
                return m;
            }

            /**
             * Sets the value of the m property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setM(BigInteger value) {
                this.m = value;
            }

            @Override
            public String toString() {
                return "MSBGETSBSEGUPDATESDetailType{" +
                        "id='" + id + '\'' +
                        ", segid='" + segid + '\'' +
                        ", transtype='" + transtype + '\'' +
                        ", processdate='" + processdate + '\'' +
                        ", currency='" + currency + '\'' +
                        ", transamount='" + transamount + '\'' +
                        ", migrationstatus='" + migrationstatus + '\'' +
                        ", transid='" + transid + '\'' +
                        ", paymentstatus='" + paymentstatus + '\'' +
                        ", paymentdate='" + paymentdate + '\'' +
                        ", m=" + m +
                        '}';
            }
        }

    }

}
