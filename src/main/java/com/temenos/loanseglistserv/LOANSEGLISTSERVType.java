
package com.temenos.loanseglistserv;

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
 * <p>Java class for LOANSEGLISTSERVType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LOANSEGLISTSERVType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="gLOANSEGLISTSERVDetailType" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="mLOANSEGLISTSERVDetailType" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="CusID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="CustomerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="CURRENCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Pack" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Premium" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="IssueDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="DebitAcct" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="PaymentDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="AmountPaid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="PolicyStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="POLICYEXPDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Branch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="LOANCONTRACTID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="REPAYMENTFREQ" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="NEXTPAYMENTDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="LASTDATEPAID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="MIGRATIONSTATUS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="MIGRATIONDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="SUMINSURRED" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "LOANSEGLISTSERVType", propOrder = {
    "gloanseglistservDetailType"
})
public class LOANSEGLISTSERVType {

    @XmlElement(name = "gLOANSEGLISTSERVDetailType")
    protected LOANSEGLISTSERVType.GLOANSEGLISTSERVDetailType gloanseglistservDetailType;

    /**
     * Gets the value of the gloanseglistservDetailType property.
     * 
     * @return
     *     possible object is
     *     {@link LOANSEGLISTSERVType.GLOANSEGLISTSERVDetailType }
     *     
     */
    public LOANSEGLISTSERVType.GLOANSEGLISTSERVDetailType getGLOANSEGLISTSERVDetailType() {
        return gloanseglistservDetailType;
    }

    /**
     * Sets the value of the gloanseglistservDetailType property.
     * 
     * @param value
     *     allowed object is
     *     {@link LOANSEGLISTSERVType.GLOANSEGLISTSERVDetailType }
     *     
     */
    public void setGLOANSEGLISTSERVDetailType(LOANSEGLISTSERVType.GLOANSEGLISTSERVDetailType value) {
        this.gloanseglistservDetailType = value;
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
     *         &lt;element name="mLOANSEGLISTSERVDetailType" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="CusID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="CustomerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="CURRENCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Pack" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Premium" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="IssueDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="DebitAcct" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="PaymentDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="AmountPaid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="PolicyStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="POLICYEXPDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Branch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="LOANCONTRACTID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="REPAYMENTFREQ" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="NEXTPAYMENTDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="LASTDATEPAID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="MIGRATIONSTATUS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="MIGRATIONDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="SUMINSURRED" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "mloanseglistservDetailType"
    })
    public static class GLOANSEGLISTSERVDetailType {

        @XmlElement(name = "mLOANSEGLISTSERVDetailType")
        protected List<LOANSEGLISTSERVType.GLOANSEGLISTSERVDetailType.MLOANSEGLISTSERVDetailType> mloanseglistservDetailType;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the mloanseglistservDetailType property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the mloanseglistservDetailType property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMLOANSEGLISTSERVDetailType().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link LOANSEGLISTSERVType.GLOANSEGLISTSERVDetailType.MLOANSEGLISTSERVDetailType }
         * 
         * 
         */
        public List<LOANSEGLISTSERVType.GLOANSEGLISTSERVDetailType.MLOANSEGLISTSERVDetailType> getMLOANSEGLISTSERVDetailType() {
            if (mloanseglistservDetailType == null) {
                mloanseglistservDetailType = new ArrayList<LOANSEGLISTSERVType.GLOANSEGLISTSERVDetailType.MLOANSEGLISTSERVDetailType>();
            }
            return this.mloanseglistservDetailType;
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

        @Override
        public String toString() {
            return "GLOANSEGLISTSERVDetailType{" +
                    "mloanseglistservDetailType=" + mloanseglistservDetailType +
                    ", g=" + g +
                    '}';
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
         *         &lt;element name="CusID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="CustomerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="CURRENCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Pack" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Premium" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="IssueDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="DebitAcct" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="PaymentDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="AmountPaid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="PolicyStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="POLICYEXPDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Branch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="LOANCONTRACTID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="REPAYMENTFREQ" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="NEXTPAYMENTDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="LASTDATEPAID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="MIGRATIONSTATUS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="MIGRATIONDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="SUMINSURRED" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "cusID",
            "customerName",
            "currency",
            "pack",
            "premium",
            "issueDate",
            "debitAcct",
            "paymentDate",
            "amountPaid",
            "policyStatus",
            "policyexpdate",
            "branch",
            "loancontractid",
            "repaymentfreq",
            "nextpaymentdate",
            "lastdatepaid",
            "migrationstatus",
            "migrationdate",
            "suminsurred"
        })
        public static class MLOANSEGLISTSERVDetailType {

            @XmlElement(name = "ID")
            protected String id;
            @XmlElement(name = "CusID")
            protected String cusID;
            @XmlElement(name = "CustomerName")
            protected String customerName;
            @XmlElement(name = "CURRENCY")
            protected String currency;
            @XmlElement(name = "Pack")
            protected String pack;
            @XmlElement(name = "Premium")
            protected String premium;
            @XmlElement(name = "IssueDate")
            protected String issueDate;
            @XmlElement(name = "DebitAcct")
            protected String debitAcct;
            @XmlElement(name = "PaymentDate")
            protected String paymentDate;
            @XmlElement(name = "AmountPaid")
            protected String amountPaid;
            @XmlElement(name = "PolicyStatus")
            protected String policyStatus;
            @XmlElement(name = "POLICYEXPDATE")
            protected String policyexpdate;
            @XmlElement(name = "Branch")
            protected String branch;
            @XmlElement(name = "LOANCONTRACTID")
            protected String loancontractid;
            @XmlElement(name = "REPAYMENTFREQ")
            protected String repaymentfreq;
            @XmlElement(name = "NEXTPAYMENTDATE")
            protected String nextpaymentdate;
            @XmlElement(name = "LASTDATEPAID")
            protected String lastdatepaid;
            @XmlElement(name = "MIGRATIONSTATUS")
            protected String migrationstatus;
            @XmlElement(name = "MIGRATIONDATE")
            protected String migrationdate;
            @XmlElement(name = "SUMINSURRED")
            protected String suminsurred;
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
             * Gets the value of the cusID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCusID() {
                return cusID;
            }

            /**
             * Sets the value of the cusID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCusID(String value) {
                this.cusID = value;
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
             * Gets the value of the pack property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPack() {
                return pack;
            }

            /**
             * Sets the value of the pack property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPack(String value) {
                this.pack = value;
            }

            /**
             * Gets the value of the premium property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPremium() {
                return premium;
            }

            /**
             * Sets the value of the premium property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPremium(String value) {
                this.premium = value;
            }

            /**
             * Gets the value of the issueDate property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIssueDate() {
                return issueDate;
            }

            /**
             * Sets the value of the issueDate property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIssueDate(String value) {
                this.issueDate = value;
            }

            /**
             * Gets the value of the debitAcct property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDebitAcct() {
                return debitAcct;
            }

            /**
             * Sets the value of the debitAcct property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDebitAcct(String value) {
                this.debitAcct = value;
            }

            /**
             * Gets the value of the paymentDate property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPaymentDate() {
                return paymentDate;
            }

            /**
             * Sets the value of the paymentDate property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPaymentDate(String value) {
                this.paymentDate = value;
            }

            /**
             * Gets the value of the amountPaid property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAmountPaid() {
                return amountPaid;
            }

            /**
             * Sets the value of the amountPaid property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAmountPaid(String value) {
                this.amountPaid = value;
            }

            /**
             * Gets the value of the policyStatus property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPolicyStatus() {
                return policyStatus;
            }

            /**
             * Sets the value of the policyStatus property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPolicyStatus(String value) {
                this.policyStatus = value;
            }

            /**
             * Gets the value of the policyexpdate property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPOLICYEXPDATE() {
                return policyexpdate;
            }

            /**
             * Sets the value of the policyexpdate property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPOLICYEXPDATE(String value) {
                this.policyexpdate = value;
            }

            /**
             * Gets the value of the branch property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBranch() {
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
            public void setBranch(String value) {
                this.branch = value;
            }

            /**
             * Gets the value of the loancontractid property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLOANCONTRACTID() {
                return loancontractid;
            }

            /**
             * Sets the value of the loancontractid property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLOANCONTRACTID(String value) {
                this.loancontractid = value;
            }

            /**
             * Gets the value of the repaymentfreq property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getREPAYMENTFREQ() {
                return repaymentfreq;
            }

            /**
             * Sets the value of the repaymentfreq property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setREPAYMENTFREQ(String value) {
                this.repaymentfreq = value;
            }

            /**
             * Gets the value of the nextpaymentdate property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNEXTPAYMENTDATE() {
                return nextpaymentdate;
            }

            /**
             * Sets the value of the nextpaymentdate property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNEXTPAYMENTDATE(String value) {
                this.nextpaymentdate = value;
            }

            /**
             * Gets the value of the lastdatepaid property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLASTDATEPAID() {
                return lastdatepaid;
            }

            /**
             * Sets the value of the lastdatepaid property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLASTDATEPAID(String value) {
                this.lastdatepaid = value;
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
             * Gets the value of the migrationdate property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMIGRATIONDATE() {
                return migrationdate;
            }

            /**
             * Sets the value of the migrationdate property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMIGRATIONDATE(String value) {
                this.migrationdate = value;
            }

            /**
             * Gets the value of the suminsurred property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSUMINSURRED() {
                return suminsurred;
            }

            /**
             * Sets the value of the suminsurred property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSUMINSURRED(String value) {
                this.suminsurred = value;
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
                return "MLOANSEGLISTSERVDetailType{" +
                        "id='" + id + '\'' +
                        ", cusID='" + cusID + '\'' +
                        ", customerName='" + customerName + '\'' +
                        ", currency='" + currency + '\'' +
                        ", pack='" + pack + '\'' +
                        ", premium='" + premium + '\'' +
                        ", issueDate='" + issueDate + '\'' +
                        ", debitAcct='" + debitAcct + '\'' +
                        ", paymentDate='" + paymentDate + '\'' +
                        ", amountPaid='" + amountPaid + '\'' +
                        ", policyStatus='" + policyStatus + '\'' +
                        ", policyexpdate='" + policyexpdate + '\'' +
                        ", branch='" + branch + '\'' +
                        ", loancontractid='" + loancontractid + '\'' +
                        ", repaymentfreq='" + repaymentfreq + '\'' +
                        ", nextpaymentdate='" + nextpaymentdate + '\'' +
                        ", lastdatepaid='" + lastdatepaid + '\'' +
                        ", migrationstatus='" + migrationstatus + '\'' +
                        ", migrationdate='" + migrationdate + '\'' +
                        ", suminsurred='" + suminsurred + '\'' +
                        ", m=" + m +
                        '}';
            }
        }

    }

}
