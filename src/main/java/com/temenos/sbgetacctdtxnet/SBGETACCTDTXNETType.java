
package com.temenos.sbgetacctdtxnet;

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
 * <p>Java class for SBGETACCTDTXNETType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SBGETACCTDTXNETType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="gSBGETACCTDTXNETDetailType" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="mSBGETACCTDTXNETDetailType" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="AccountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="OrderNibb" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Iban" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Swift" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="CustomerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Address1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Address2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="CurrentBalance" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ClearedBalance" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="CCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="IsInactive" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="PostRestDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="PostRestCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="CUSTOMERID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ACCOUNTCATEGORYCODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ACCOUNTCATEGORY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="BRANCHCODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="BRANCH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="WORKINGBALANCE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="LOCKEDAMOUNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "SBGETACCTDTXNETType", propOrder = {
    "gsbgetacctdtxnetDetailType"
})
public class SBGETACCTDTXNETType {

    @XmlElement(name = "gSBGETACCTDTXNETDetailType")
    protected SBGETACCTDTXNETType.GSBGETACCTDTXNETDetailType gsbgetacctdtxnetDetailType;

    /**
     * Gets the value of the gsbgetacctdtxnetDetailType property.
     * 
     * @return
     *     possible object is
     *     {@link SBGETACCTDTXNETType.GSBGETACCTDTXNETDetailType }
     *     
     */
    public SBGETACCTDTXNETType.GSBGETACCTDTXNETDetailType getGSBGETACCTDTXNETDetailType() {
        return gsbgetacctdtxnetDetailType;
    }

    /**
     * Sets the value of the gsbgetacctdtxnetDetailType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SBGETACCTDTXNETType.GSBGETACCTDTXNETDetailType }
     *     
     */
    public void setGSBGETACCTDTXNETDetailType(SBGETACCTDTXNETType.GSBGETACCTDTXNETDetailType value) {
        this.gsbgetacctdtxnetDetailType = value;
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
     *         &lt;element name="mSBGETACCTDTXNETDetailType" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="AccountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="OrderNibb" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Iban" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Swift" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="CustomerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Address1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Address2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="CurrentBalance" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ClearedBalance" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="CCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="IsInactive" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="PostRestDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="PostRestCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="CUSTOMERID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ACCOUNTCATEGORYCODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ACCOUNTCATEGORY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="BRANCHCODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="BRANCH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="WORKINGBALANCE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="LOCKEDAMOUNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "msbgetacctdtxnetDetailType"
    })
    public static class GSBGETACCTDTXNETDetailType {

        @XmlElement(name = "mSBGETACCTDTXNETDetailType")
        protected List<SBGETACCTDTXNETType.GSBGETACCTDTXNETDetailType.MSBGETACCTDTXNETDetailType> msbgetacctdtxnetDetailType;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the msbgetacctdtxnetDetailType property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the msbgetacctdtxnetDetailType property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMSBGETACCTDTXNETDetailType().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SBGETACCTDTXNETType.GSBGETACCTDTXNETDetailType.MSBGETACCTDTXNETDetailType }
         * 
         * 
         */
        public List<SBGETACCTDTXNETType.GSBGETACCTDTXNETDetailType.MSBGETACCTDTXNETDetailType> getMSBGETACCTDTXNETDetailType() {
            if (msbgetacctdtxnetDetailType == null) {
                msbgetacctdtxnetDetailType = new ArrayList<SBGETACCTDTXNETType.GSBGETACCTDTXNETDetailType.MSBGETACCTDTXNETDetailType>();
            }
            return this.msbgetacctdtxnetDetailType;
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
         *         &lt;element name="AccountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="OrderNibb" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Iban" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Swift" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="CustomerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Address1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Address2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="CurrentBalance" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ClearedBalance" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="CCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="IsInactive" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="PostRestDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="PostRestCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="CUSTOMERID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ACCOUNTCATEGORYCODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ACCOUNTCATEGORY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="BRANCHCODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="BRANCH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="WORKINGBALANCE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="LOCKEDAMOUNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "accountNumber",
            "orderNibb",
            "iban",
            "swift",
            "customerName",
            "address1",
            "address2",
            "currentBalance",
            "clearedBalance",
            "ccy",
            "isInactive",
            "postRestDesc",
            "postRestCode",
            "customerid",
            "accountcategorycode",
            "accountcategory",
            "branchcode",
            "branch",
            "workingbalance",
            "lockedamount"
        })
        public static class MSBGETACCTDTXNETDetailType {

            @XmlElement(name = "AccountNumber")
            protected String accountNumber;
            @XmlElement(name = "OrderNibb")
            protected String orderNibb;
            @XmlElement(name = "Iban")
            protected String iban;
            @XmlElement(name = "Swift")
            protected String swift;
            @XmlElement(name = "CustomerName")
            protected String customerName;
            @XmlElement(name = "Address1")
            protected String address1;
            @XmlElement(name = "Address2")
            protected String address2;
            @XmlElement(name = "CurrentBalance")
            protected String currentBalance;
            @XmlElement(name = "ClearedBalance")
            protected String clearedBalance;
            @XmlElement(name = "CCY")
            protected String ccy;
            @XmlElement(name = "IsInactive")
            protected String isInactive;
            @XmlElement(name = "PostRestDesc")
            protected String postRestDesc;
            @XmlElement(name = "PostRestCode")
            protected String postRestCode;
            @XmlElement(name = "CUSTOMERID")
            protected String customerid;
            @XmlElement(name = "ACCOUNTCATEGORYCODE")
            protected String accountcategorycode;
            @XmlElement(name = "ACCOUNTCATEGORY")
            protected String accountcategory;
            @XmlElement(name = "BRANCHCODE")
            protected String branchcode;
            @XmlElement(name = "BRANCH")
            protected String branch;
            @XmlElement(name = "WORKINGBALANCE")
            protected String workingbalance;
            @XmlElement(name = "LOCKEDAMOUNT")
            protected String lockedamount;
            @XmlAttribute(name = "m")
            @XmlSchemaType(name = "positiveInteger")
            protected BigInteger m;

            /**
             * Gets the value of the accountNumber property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAccountNumber() {
                return accountNumber;
            }

            /**
             * Sets the value of the accountNumber property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAccountNumber(String value) {
                this.accountNumber = value;
            }

            /**
             * Gets the value of the orderNibb property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOrderNibb() {
                return orderNibb;
            }

            /**
             * Sets the value of the orderNibb property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOrderNibb(String value) {
                this.orderNibb = value;
            }

            /**
             * Gets the value of the iban property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIban() {
                return iban;
            }

            /**
             * Sets the value of the iban property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIban(String value) {
                this.iban = value;
            }

            /**
             * Gets the value of the swift property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSwift() {
                return swift;
            }

            /**
             * Sets the value of the swift property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSwift(String value) {
                this.swift = value;
            }

            /**
             * Gets the value of the customerName property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCustomerName() {
                return customerName;
            }

            /**
             * Sets the value of the customerName property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCustomerName(String value) {
                this.customerName = value;
            }

            /**
             * Gets the value of the address1 property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAddress1() {
                return address1;
            }

            /**
             * Sets the value of the address1 property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAddress1(String value) {
                this.address1 = value;
            }

            /**
             * Gets the value of the address2 property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAddress2() {
                return address2;
            }

            /**
             * Sets the value of the address2 property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAddress2(String value) {
                this.address2 = value;
            }

            /**
             * Gets the value of the currentBalance property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCurrentBalance() {
                return currentBalance;
            }

            /**
             * Sets the value of the currentBalance property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCurrentBalance(String value) {
                this.currentBalance = value;
            }

            /**
             * Gets the value of the clearedBalance property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getClearedBalance() {
                return clearedBalance;
            }

            /**
             * Sets the value of the clearedBalance property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setClearedBalance(String value) {
                this.clearedBalance = value;
            }

            /**
             * Gets the value of the ccy property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCCY() {
                return ccy;
            }

            /**
             * Sets the value of the ccy property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCCY(String value) {
                this.ccy = value;
            }

            /**
             * Gets the value of the isInactive property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIsInactive() {
                return isInactive;
            }

            /**
             * Sets the value of the isInactive property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIsInactive(String value) {
                this.isInactive = value;
            }

            /**
             * Gets the value of the postRestDesc property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPostRestDesc() {
                return postRestDesc;
            }

            /**
             * Sets the value of the postRestDesc property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPostRestDesc(String value) {
                this.postRestDesc = value;
            }

            /**
             * Gets the value of the postRestCode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPostRestCode() {
                return postRestCode;
            }

            /**
             * Sets the value of the postRestCode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPostRestCode(String value) {
                this.postRestCode = value;
            }

            /**
             * Gets the value of the customerid property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCUSTOMERID() {
                return customerid;
            }

            /**
             * Sets the value of the customerid property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCUSTOMERID(String value) {
                this.customerid = value;
            }

            /**
             * Gets the value of the accountcategorycode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getACCOUNTCATEGORYCODE() {
                return accountcategorycode;
            }

            /**
             * Sets the value of the accountcategorycode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setACCOUNTCATEGORYCODE(String value) {
                this.accountcategorycode = value;
            }

            /**
             * Gets the value of the accountcategory property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getACCOUNTCATEGORY() {
                return accountcategory;
            }

            /**
             * Sets the value of the accountcategory property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setACCOUNTCATEGORY(String value) {
                this.accountcategory = value;
            }

            /**
             * Gets the value of the branchcode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBRANCHCODE() {
                return branchcode;
            }

            /**
             * Sets the value of the branchcode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBRANCHCODE(String value) {
                this.branchcode = value;
            }

            /**
             * Gets the value of the branch property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBRANCH() {
                return branch;
            }

            /**
             * Sets the value of the branch property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBRANCH(String value) {
                this.branch = value;
            }

            /**
             * Gets the value of the workingbalance property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getWORKINGBALANCE() {
                return workingbalance;
            }

            /**
             * Sets the value of the workingbalance property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setWORKINGBALANCE(String value) {
                this.workingbalance = value;
            }

            /**
             * Gets the value of the lockedamount property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLOCKEDAMOUNT() {
                return lockedamount;
            }

            /**
             * Sets the value of the lockedamount property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLOCKEDAMOUNT(String value) {
                this.lockedamount = value;
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
