
package com.temenos.loanseglist;

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
 * <p>Java class for LOANSEGLISTType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LOANSEGLISTType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="gLOANSEGLISTDetailType" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="mLOANSEGLISTDetailType" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="CusID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="CustomerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Package" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Premium" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="IssueDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="DebitAcct" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="PaymentDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="AmountPaid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="PolicyStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Branch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "LOANSEGLISTType", propOrder = {
    "gloanseglistDetailType"
})
public class LOANSEGLISTType {

    @XmlElement(name = "gLOANSEGLISTDetailType")
    protected LOANSEGLISTType.GLOANSEGLISTDetailType gloanseglistDetailType;

    /**
     * Gets the value of the gloanseglistDetailType property.
     * 
     * @return
     *     possible object is
     *     {@link LOANSEGLISTType.GLOANSEGLISTDetailType }
     *     
     */
    public LOANSEGLISTType.GLOANSEGLISTDetailType getGLOANSEGLISTDetailType() {
        return gloanseglistDetailType;
    }

    /**
     * Sets the value of the gloanseglistDetailType property.
     * 
     * @param value
     *     allowed object is
     *     {@link LOANSEGLISTType.GLOANSEGLISTDetailType }
     *     
     */
    public void setGLOANSEGLISTDetailType(LOANSEGLISTType.GLOANSEGLISTDetailType value) {
        this.gloanseglistDetailType = value;
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
     *         &lt;element name="mLOANSEGLISTDetailType" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="CusID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="CustomerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Package" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Premium" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="IssueDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="DebitAcct" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="PaymentDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="AmountPaid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="PolicyStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Branch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "mloanseglistDetailType"
    })
    public static class GLOANSEGLISTDetailType {

        @XmlElement(name = "mLOANSEGLISTDetailType")
        protected List<LOANSEGLISTType.GLOANSEGLISTDetailType.MLOANSEGLISTDetailType> mloanseglistDetailType;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the mloanseglistDetailType property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the mloanseglistDetailType property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMLOANSEGLISTDetailType().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link LOANSEGLISTType.GLOANSEGLISTDetailType.MLOANSEGLISTDetailType }
         * 
         * 
         */
        public List<LOANSEGLISTType.GLOANSEGLISTDetailType.MLOANSEGLISTDetailType> getMLOANSEGLISTDetailType() {
            if (mloanseglistDetailType == null) {
                mloanseglistDetailType = new ArrayList<LOANSEGLISTType.GLOANSEGLISTDetailType.MLOANSEGLISTDetailType>();
            }
            return this.mloanseglistDetailType;
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
         *         &lt;element name="CusID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="CustomerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Package" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Premium" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="IssueDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="DebitAcct" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="PaymentDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="AmountPaid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="PolicyStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Branch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "_package",
            "premium",
            "issueDate",
            "debitAcct",
            "paymentDate",
            "amountPaid",
            "policyStatus",
            "branch"
        })
        public static class MLOANSEGLISTDetailType {

            @XmlElement(name = "ID")
            protected String id;
            @XmlElement(name = "CusID")
            protected String cusID;
            @XmlElement(name = "CustomerName")
            protected String customerName;
            @XmlElement(name = "Package")
            protected String _package;
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
            @XmlElement(name = "Branch")
            protected String branch;
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
             * Gets the value of the package property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPackage() {
                return _package;
            }

            /**
             * Sets the value of the package property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPackage(String value) {
                this._package = value;
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
