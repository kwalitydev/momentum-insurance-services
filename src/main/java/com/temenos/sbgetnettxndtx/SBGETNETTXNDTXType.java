
package com.temenos.sbgetnettxndtx;

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
 * <p>Java class for SBGETNETTXNDTXType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SBGETNETTXNDTXType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="gSBGETNETTXNDTXDetailType" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="mSBGETNETTXNDTXDetailType" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="selFldNETTXNID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="FUNDSTRANSFERID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="DEBITACCTNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="DEBITCURRENCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="DEBITAMOUNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="CREDITACCTNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="CREDITCURRENCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="CREDITAMOUNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="PROCESSINGDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="RECORDSTATUS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="COCODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="DBACCTNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="CRACCTNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="DEBITCUSTOMER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="CREDITCUSTOMER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="TRANSACTIONTYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ENTIDADE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="REFERENCIA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="NETTXNID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="COMMISSIONCODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="COMMISSIONAMOUNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "SBGETNETTXNDTXType", propOrder = {
    "gsbgetnettxndtxDetailType"
})
public class SBGETNETTXNDTXType {

    @XmlElement(name = "gSBGETNETTXNDTXDetailType")
    protected SBGETNETTXNDTXType.GSBGETNETTXNDTXDetailType gsbgetnettxndtxDetailType;

    /**
     * Gets the value of the gsbgetnettxndtxDetailType property.
     * 
     * @return
     *     possible object is
     *     {@link SBGETNETTXNDTXType.GSBGETNETTXNDTXDetailType }
     *     
     */
    public SBGETNETTXNDTXType.GSBGETNETTXNDTXDetailType getGSBGETNETTXNDTXDetailType() {
        return gsbgetnettxndtxDetailType;
    }

    /**
     * Sets the value of the gsbgetnettxndtxDetailType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SBGETNETTXNDTXType.GSBGETNETTXNDTXDetailType }
     *     
     */
    public void setGSBGETNETTXNDTXDetailType(SBGETNETTXNDTXType.GSBGETNETTXNDTXDetailType value) {
        this.gsbgetnettxndtxDetailType = value;
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
     *         &lt;element name="mSBGETNETTXNDTXDetailType" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="selFldNETTXNID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="FUNDSTRANSFERID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="DEBITACCTNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="DEBITCURRENCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="DEBITAMOUNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="CREDITACCTNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="CREDITCURRENCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="CREDITAMOUNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="PROCESSINGDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="RECORDSTATUS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="COCODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="DBACCTNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="CRACCTNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="DEBITCUSTOMER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="CREDITCUSTOMER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="TRANSACTIONTYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ENTIDADE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="REFERENCIA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="NETTXNID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="COMMISSIONCODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="COMMISSIONAMOUNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "msbgetnettxndtxDetailType"
    })
    public static class GSBGETNETTXNDTXDetailType {

        @XmlElement(name = "mSBGETNETTXNDTXDetailType")
        protected List<SBGETNETTXNDTXType.GSBGETNETTXNDTXDetailType.MSBGETNETTXNDTXDetailType> msbgetnettxndtxDetailType;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the msbgetnettxndtxDetailType property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the msbgetnettxndtxDetailType property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMSBGETNETTXNDTXDetailType().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SBGETNETTXNDTXType.GSBGETNETTXNDTXDetailType.MSBGETNETTXNDTXDetailType }
         * 
         * 
         */
        public List<SBGETNETTXNDTXType.GSBGETNETTXNDTXDetailType.MSBGETNETTXNDTXDetailType> getMSBGETNETTXNDTXDetailType() {
            if (msbgetnettxndtxDetailType == null) {
                msbgetnettxndtxDetailType = new ArrayList<SBGETNETTXNDTXType.GSBGETNETTXNDTXDetailType.MSBGETNETTXNDTXDetailType>();
            }
            return this.msbgetnettxndtxDetailType;
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
         *         &lt;element name="selFldNETTXNID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="FUNDSTRANSFERID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="DEBITACCTNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="DEBITCURRENCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="DEBITAMOUNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="CREDITACCTNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="CREDITCURRENCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="CREDITAMOUNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="PROCESSINGDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="RECORDSTATUS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="COCODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="DBACCTNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="CRACCTNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="DEBITCUSTOMER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="CREDITCUSTOMER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="TRANSACTIONTYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ENTIDADE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="REFERENCIA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="NETTXNID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="COMMISSIONCODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="COMMISSIONAMOUNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "selFldNETTXNID",
            "fundstransferid",
            "debitacctno",
            "debitcurrency",
            "debitamount",
            "creditacctno",
            "creditcurrency",
            "creditamount",
            "processingdate",
            "recordstatus",
            "cocode",
            "dbacctname",
            "cracctname",
            "debitcustomer",
            "creditcustomer",
            "transactiontype",
            "entidade",
            "referencia",
            "nettxnid",
            "commissioncode",
            "commissionamount"
        })
        public static class MSBGETNETTXNDTXDetailType {

            protected String selFldNETTXNID;
            @XmlElement(name = "FUNDSTRANSFERID")
            protected String fundstransferid;
            @XmlElement(name = "DEBITACCTNO")
            protected String debitacctno;
            @XmlElement(name = "DEBITCURRENCY")
            protected String debitcurrency;
            @XmlElement(name = "DEBITAMOUNT")
            protected String debitamount;
            @XmlElement(name = "CREDITACCTNO")
            protected String creditacctno;
            @XmlElement(name = "CREDITCURRENCY")
            protected String creditcurrency;
            @XmlElement(name = "CREDITAMOUNT")
            protected String creditamount;
            @XmlElement(name = "PROCESSINGDATE")
            protected String processingdate;
            @XmlElement(name = "RECORDSTATUS")
            protected String recordstatus;
            @XmlElement(name = "COCODE")
            protected String cocode;
            @XmlElement(name = "DBACCTNAME")
            protected String dbacctname;
            @XmlElement(name = "CRACCTNAME")
            protected String cracctname;
            @XmlElement(name = "DEBITCUSTOMER")
            protected String debitcustomer;
            @XmlElement(name = "CREDITCUSTOMER")
            protected String creditcustomer;
            @XmlElement(name = "TRANSACTIONTYPE")
            protected String transactiontype;
            @XmlElement(name = "ENTIDADE")
            protected String entidade;
            @XmlElement(name = "REFERENCIA")
            protected String referencia;
            @XmlElement(name = "NETTXNID")
            protected String nettxnid;
            @XmlElement(name = "COMMISSIONCODE")
            protected String commissioncode;
            @XmlElement(name = "COMMISSIONAMOUNT")
            protected String commissionamount;
            @XmlAttribute(name = "m")
            @XmlSchemaType(name = "positiveInteger")
            protected BigInteger m;

            /**
             * Gets the value of the selFldNETTXNID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSelFldNETTXNID() {
                return selFldNETTXNID;
            }

            /**
             * Sets the value of the selFldNETTXNID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSelFldNETTXNID(String value) {
                this.selFldNETTXNID = value;
            }

            /**
             * Gets the value of the fundstransferid property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFUNDSTRANSFERID() {
                return fundstransferid;
            }

            /**
             * Sets the value of the fundstransferid property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFUNDSTRANSFERID(String value) {
                this.fundstransferid = value;
            }

            /**
             * Gets the value of the debitacctno property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDEBITACCTNO() {
                return debitacctno;
            }

            /**
             * Sets the value of the debitacctno property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDEBITACCTNO(String value) {
                this.debitacctno = value;
            }

            /**
             * Gets the value of the debitcurrency property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDEBITCURRENCY() {
                return debitcurrency;
            }

            /**
             * Sets the value of the debitcurrency property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDEBITCURRENCY(String value) {
                this.debitcurrency = value;
            }

            /**
             * Gets the value of the debitamount property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDEBITAMOUNT() {
                return debitamount;
            }

            /**
             * Sets the value of the debitamount property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDEBITAMOUNT(String value) {
                this.debitamount = value;
            }

            /**
             * Gets the value of the creditacctno property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCREDITACCTNO() {
                return creditacctno;
            }

            /**
             * Sets the value of the creditacctno property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCREDITACCTNO(String value) {
                this.creditacctno = value;
            }

            /**
             * Gets the value of the creditcurrency property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCREDITCURRENCY() {
                return creditcurrency;
            }

            /**
             * Sets the value of the creditcurrency property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCREDITCURRENCY(String value) {
                this.creditcurrency = value;
            }

            /**
             * Gets the value of the creditamount property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCREDITAMOUNT() {
                return creditamount;
            }

            /**
             * Sets the value of the creditamount property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCREDITAMOUNT(String value) {
                this.creditamount = value;
            }

            /**
             * Gets the value of the processingdate property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPROCESSINGDATE() {
                return processingdate;
            }

            /**
             * Sets the value of the processingdate property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPROCESSINGDATE(String value) {
                this.processingdate = value;
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
             * Gets the value of the dbacctname property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDBACCTNAME() {
                return dbacctname;
            }

            /**
             * Sets the value of the dbacctname property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDBACCTNAME(String value) {
                this.dbacctname = value;
            }

            /**
             * Gets the value of the cracctname property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCRACCTNAME() {
                return cracctname;
            }

            /**
             * Sets the value of the cracctname property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCRACCTNAME(String value) {
                this.cracctname = value;
            }

            /**
             * Gets the value of the debitcustomer property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDEBITCUSTOMER() {
                return debitcustomer;
            }

            /**
             * Sets the value of the debitcustomer property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDEBITCUSTOMER(String value) {
                this.debitcustomer = value;
            }

            /**
             * Gets the value of the creditcustomer property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCREDITCUSTOMER() {
                return creditcustomer;
            }

            /**
             * Sets the value of the creditcustomer property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCREDITCUSTOMER(String value) {
                this.creditcustomer = value;
            }

            /**
             * Gets the value of the transactiontype property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTRANSACTIONTYPE() {
                return transactiontype;
            }

            /**
             * Sets the value of the transactiontype property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTRANSACTIONTYPE(String value) {
                this.transactiontype = value;
            }

            /**
             * Gets the value of the entidade property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getENTIDADE() {
                return entidade;
            }

            /**
             * Sets the value of the entidade property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setENTIDADE(String value) {
                this.entidade = value;
            }

            /**
             * Gets the value of the referencia property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getREFERENCIA() {
                return referencia;
            }

            /**
             * Sets the value of the referencia property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setREFERENCIA(String value) {
                this.referencia = value;
            }

            /**
             * Gets the value of the nettxnid property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNETTXNID() {
                return nettxnid;
            }

            /**
             * Sets the value of the nettxnid property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNETTXNID(String value) {
                this.nettxnid = value;
            }

            /**
             * Gets the value of the commissioncode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCOMMISSIONCODE() {
                return commissioncode;
            }

            /**
             * Sets the value of the commissioncode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCOMMISSIONCODE(String value) {
                this.commissioncode = value;
            }

            /**
             * Gets the value of the commissionamount property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCOMMISSIONAMOUNT() {
                return commissionamount;
            }

            /**
             * Sets the value of the commissionamount property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCOMMISSIONAMOUNT(String value) {
                this.commissionamount = value;
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

        }

    }

}
