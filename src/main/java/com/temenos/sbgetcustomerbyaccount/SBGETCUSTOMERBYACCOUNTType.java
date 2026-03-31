
package com.temenos.sbgetcustomerbyaccount;

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
 * <p>Java class for SBGETCUSTOMERBYACCOUNTType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SBGETCUSTOMERBYACCOUNTType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="gSBGETCUSTOMERBYACCOUNTDetailType" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="mSBGETCUSTOMERBYACCOUNTDetailType" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="selFldACCOUNTNUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="CUSTOMERID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ADDRESS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="BIRTHINCORPDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="CUSTOMERSINCE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="FATHERSNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="JOBTITLE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="LEGALEXPDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="LEGALHOLDERNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="LEGALID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="LEGALISSDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="LEGALSTATUS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="MARITALSTATUS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="MOTHERSNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="NAME1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="PLACEBIRTH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="SALARY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="SHORTNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="TARGET" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="TAXID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="PHONE1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="EMAIL1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="SALARYNET" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="SMS1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ACCOUNTCATEGORY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="CURRENCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ONLINEACTUALBAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="LOCKEDAMOUNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="WORKINGBALANCE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="CLEAREDBALANCE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="UNCLEAREDBALANCE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "SBGETCUSTOMERBYACCOUNTType", propOrder = {
    "gsbgetcustomerbyaccountDetailType"
})
public class SBGETCUSTOMERBYACCOUNTType {

    @XmlElement(name = "gSBGETCUSTOMERBYACCOUNTDetailType")
    protected SBGETCUSTOMERBYACCOUNTType.GSBGETCUSTOMERBYACCOUNTDetailType gsbgetcustomerbyaccountDetailType;

    /**
     * Gets the value of the gsbgetcustomerbyaccountDetailType property.
     * 
     * @return
     *     possible object is
     *     {@link SBGETCUSTOMERBYACCOUNTType.GSBGETCUSTOMERBYACCOUNTDetailType }
     *     
     */
    public SBGETCUSTOMERBYACCOUNTType.GSBGETCUSTOMERBYACCOUNTDetailType getGSBGETCUSTOMERBYACCOUNTDetailType() {
        return gsbgetcustomerbyaccountDetailType;
    }

    /**
     * Sets the value of the gsbgetcustomerbyaccountDetailType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SBGETCUSTOMERBYACCOUNTType.GSBGETCUSTOMERBYACCOUNTDetailType }
     *     
     */
    public void setGSBGETCUSTOMERBYACCOUNTDetailType(SBGETCUSTOMERBYACCOUNTType.GSBGETCUSTOMERBYACCOUNTDetailType value) {
        this.gsbgetcustomerbyaccountDetailType = value;
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
     *         &lt;element name="mSBGETCUSTOMERBYACCOUNTDetailType" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="selFldACCOUNTNUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="CUSTOMERID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ADDRESS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="BIRTHINCORPDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="CUSTOMERSINCE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="FATHERSNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="JOBTITLE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="LEGALEXPDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="LEGALHOLDERNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="LEGALID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="LEGALISSDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="LEGALSTATUS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="MARITALSTATUS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="MOTHERSNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="NAME1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="PLACEBIRTH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="SALARY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="SHORTNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="TARGET" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="TAXID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="PHONE1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="EMAIL1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="SALARYNET" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="SMS1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ACCOUNTCATEGORY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="CURRENCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ONLINEACTUALBAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="LOCKEDAMOUNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="WORKINGBALANCE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="CLEAREDBALANCE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="UNCLEAREDBALANCE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "msbgetcustomerbyaccountDetailType"
    })
    public static class GSBGETCUSTOMERBYACCOUNTDetailType {

        @XmlElement(name = "mSBGETCUSTOMERBYACCOUNTDetailType")
        protected List<SBGETCUSTOMERBYACCOUNTType.GSBGETCUSTOMERBYACCOUNTDetailType.MSBGETCUSTOMERBYACCOUNTDetailType> msbgetcustomerbyaccountDetailType;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the msbgetcustomerbyaccountDetailType property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the msbgetcustomerbyaccountDetailType property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMSBGETCUSTOMERBYACCOUNTDetailType().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SBGETCUSTOMERBYACCOUNTType.GSBGETCUSTOMERBYACCOUNTDetailType.MSBGETCUSTOMERBYACCOUNTDetailType }
         * 
         * 
         */
        public List<SBGETCUSTOMERBYACCOUNTType.GSBGETCUSTOMERBYACCOUNTDetailType.MSBGETCUSTOMERBYACCOUNTDetailType> getMSBGETCUSTOMERBYACCOUNTDetailType() {
            if (msbgetcustomerbyaccountDetailType == null) {
                msbgetcustomerbyaccountDetailType = new ArrayList<SBGETCUSTOMERBYACCOUNTType.GSBGETCUSTOMERBYACCOUNTDetailType.MSBGETCUSTOMERBYACCOUNTDetailType>();
            }
            return this.msbgetcustomerbyaccountDetailType;
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
            return "GSBGETCUSTOMERBYACCOUNTDetailType{" +
                    "msbgetcustomerbyaccountDetailType=" + msbgetcustomerbyaccountDetailType +
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
         *         &lt;element name="selFldACCOUNTNUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="CUSTOMERID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ADDRESS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="BIRTHINCORPDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="CUSTOMERSINCE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="FATHERSNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="JOBTITLE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="LEGALEXPDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="LEGALHOLDERNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="LEGALID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="LEGALISSDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="LEGALSTATUS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="MARITALSTATUS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="MOTHERSNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="NAME1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="PLACEBIRTH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="SALARY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="SHORTNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="TARGET" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="TAXID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="PHONE1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="EMAIL1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="SALARYNET" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="SMS1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ACCOUNTCATEGORY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="CURRENCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ONLINEACTUALBAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="LOCKEDAMOUNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="WORKINGBALANCE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="CLEAREDBALANCE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="UNCLEAREDBALANCE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "selFldACCOUNTNUMBER",
            "customerid",
            "address",
            "birthincorpdate",
            "customersince",
            "fathersname",
            "jobtitle",
            "legalexpdate",
            "legalholdername",
            "legalid",
            "legalissdate",
            "legalstatus",
            "maritalstatus",
            "mothersname",
            "name1",
            "placebirth",
            "salary",
            "shortname",
            "target",
            "taxid",
            "phone1",
            "email1",
            "salarynet",
            "sms1",
            "accountcategory",
            "currency",
            "onlineactualbal",
            "lockedamount",
            "workingbalance",
            "clearedbalance",
            "unclearedbalance"
        })
        public static class MSBGETCUSTOMERBYACCOUNTDetailType {

            protected String selFldACCOUNTNUMBER;
            @XmlElement(name = "CUSTOMERID")
            protected String customerid;
            @XmlElement(name = "ADDRESS")
            protected String address;
            @XmlElement(name = "BIRTHINCORPDATE")
            protected String birthincorpdate;
            @XmlElement(name = "CUSTOMERSINCE")
            protected String customersince;
            @XmlElement(name = "FATHERSNAME")
            protected String fathersname;
            @XmlElement(name = "JOBTITLE")
            protected String jobtitle;
            @XmlElement(name = "LEGALEXPDATE")
            protected String legalexpdate;
            @XmlElement(name = "LEGALHOLDERNAME")
            protected String legalholdername;
            @XmlElement(name = "LEGALID")
            protected String legalid;
            @XmlElement(name = "LEGALISSDATE")
            protected String legalissdate;
            @XmlElement(name = "LEGALSTATUS")
            protected String legalstatus;
            @XmlElement(name = "MARITALSTATUS")
            protected String maritalstatus;
            @XmlElement(name = "MOTHERSNAME")
            protected String mothersname;
            @XmlElement(name = "NAME1")
            protected String name1;
            @XmlElement(name = "PLACEBIRTH")
            protected String placebirth;
            @XmlElement(name = "SALARY")
            protected String salary;
            @XmlElement(name = "SHORTNAME")
            protected String shortname;
            @XmlElement(name = "TARGET")
            protected String target;
            @XmlElement(name = "TAXID")
            protected String taxid;
            @XmlElement(name = "PHONE1")
            protected String phone1;
            @XmlElement(name = "EMAIL1")
            protected String email1;
            @XmlElement(name = "SALARYNET")
            protected String salarynet;
            @XmlElement(name = "SMS1")
            protected String sms1;
            @XmlElement(name = "ACCOUNTCATEGORY")
            protected String accountcategory;
            @XmlElement(name = "CURRENCY")
            protected String currency;
            @XmlElement(name = "ONLINEACTUALBAL")
            protected String onlineactualbal;
            @XmlElement(name = "LOCKEDAMOUNT")
            protected String lockedamount;
            @XmlElement(name = "WORKINGBALANCE")
            protected String workingbalance;
            @XmlElement(name = "CLEAREDBALANCE")
            protected String clearedbalance;
            @XmlElement(name = "UNCLEAREDBALANCE")
            protected String unclearedbalance;
            @XmlAttribute(name = "m")
            @XmlSchemaType(name = "positiveInteger")
            protected BigInteger m;


            @Override
            public String toString() {
                return "MSBGETCUSTOMERBYACCOUNTDetailType{" +
                        "selFldACCOUNTNUMBER='" + selFldACCOUNTNUMBER + '\'' +
                        ", customerid='" + customerid + '\'' +
                        ", address='" + address + '\'' +
                        ", birthincorpdate='" + birthincorpdate + '\'' +
                        ", customersince='" + customersince + '\'' +
                        ", fathersname='" + fathersname + '\'' +
                        ", jobtitle='" + jobtitle + '\'' +
                        ", legalexpdate='" + legalexpdate + '\'' +
                        ", legalholdername='" + legalholdername + '\'' +
                        ", legalid='" + legalid + '\'' +
                        ", legalissdate='" + legalissdate + '\'' +
                        ", legalstatus='" + legalstatus + '\'' +
                        ", maritalstatus='" + maritalstatus + '\'' +
                        ", mothersname='" + mothersname + '\'' +
                        ", name1='" + name1 + '\'' +
                        ", placebirth='" + placebirth + '\'' +
                        ", salary='" + salary + '\'' +
                        ", shortname='" + shortname + '\'' +
                        ", target='" + target + '\'' +
                        ", taxid='" + taxid + '\'' +
                        ", phone1='" + phone1 + '\'' +
                        ", email1='" + email1 + '\'' +
                        ", salarynet='" + salarynet + '\'' +
                        ", sms1='" + sms1 + '\'' +
                        ", accountcategory='" + accountcategory + '\'' +
                        ", currency='" + currency + '\'' +
                        ", onlineactualbal='" + onlineactualbal + '\'' +
                        ", lockedamount='" + lockedamount + '\'' +
                        ", workingbalance='" + workingbalance + '\'' +
                        ", clearedbalance='" + clearedbalance + '\'' +
                        ", unclearedbalance='" + unclearedbalance + '\'' +
                        ", m=" + m +
                        '}';
            }

            /**
             * Gets the value of the selFldACCOUNTNUMBER property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSelFldACCOUNTNUMBER() {
                return selFldACCOUNTNUMBER;
            }

            /**
             * Sets the value of the selFldACCOUNTNUMBER property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSelFldACCOUNTNUMBER(String value) {
                this.selFldACCOUNTNUMBER = value;
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
             * Gets the value of the address property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getADDRESS() {
                return address;
            }

            /**
             * Sets the value of the address property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setADDRESS(String value) {
                this.address = value;
            }

            /**
             * Gets the value of the birthincorpdate property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBIRTHINCORPDATE() {
                return birthincorpdate;
            }

            /**
             * Sets the value of the birthincorpdate property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBIRTHINCORPDATE(String value) {
                this.birthincorpdate = value;
            }

            /**
             * Gets the value of the customersince property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCUSTOMERSINCE() {
                return customersince;
            }

            /**
             * Sets the value of the customersince property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCUSTOMERSINCE(String value) {
                this.customersince = value;
            }

            /**
             * Gets the value of the fathersname property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFATHERSNAME() {
                return fathersname;
            }

            /**
             * Sets the value of the fathersname property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFATHERSNAME(String value) {
                this.fathersname = value;
            }

            /**
             * Gets the value of the jobtitle property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getJOBTITLE() {
                return jobtitle;
            }

            /**
             * Sets the value of the jobtitle property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setJOBTITLE(String value) {
                this.jobtitle = value;
            }

            /**
             * Gets the value of the legalexpdate property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLEGALEXPDATE() {
                return legalexpdate;
            }

            /**
             * Sets the value of the legalexpdate property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLEGALEXPDATE(String value) {
                this.legalexpdate = value;
            }

            /**
             * Gets the value of the legalholdername property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLEGALHOLDERNAME() {
                return legalholdername;
            }

            /**
             * Sets the value of the legalholdername property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLEGALHOLDERNAME(String value) {
                this.legalholdername = value;
            }

            /**
             * Gets the value of the legalid property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLEGALID() {
                return legalid;
            }

            /**
             * Sets the value of the legalid property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLEGALID(String value) {
                this.legalid = value;
            }

            /**
             * Gets the value of the legalissdate property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLEGALISSDATE() {
                return legalissdate;
            }

            /**
             * Sets the value of the legalissdate property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLEGALISSDATE(String value) {
                this.legalissdate = value;
            }

            /**
             * Gets the value of the legalstatus property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLEGALSTATUS() {
                return legalstatus;
            }

            /**
             * Sets the value of the legalstatus property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLEGALSTATUS(String value) {
                this.legalstatus = value;
            }

            /**
             * Gets the value of the maritalstatus property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMARITALSTATUS() {
                return maritalstatus;
            }

            /**
             * Sets the value of the maritalstatus property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMARITALSTATUS(String value) {
                this.maritalstatus = value;
            }

            /**
             * Gets the value of the mothersname property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMOTHERSNAME() {
                return mothersname;
            }

            /**
             * Sets the value of the mothersname property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMOTHERSNAME(String value) {
                this.mothersname = value;
            }

            /**
             * Gets the value of the name1 property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNAME1() {
                return name1;
            }

            /**
             * Sets the value of the name1 property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNAME1(String value) {
                this.name1 = value;
            }

            /**
             * Gets the value of the placebirth property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPLACEBIRTH() {
                return placebirth;
            }

            /**
             * Sets the value of the placebirth property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPLACEBIRTH(String value) {
                this.placebirth = value;
            }

            /**
             * Gets the value of the salary property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSALARY() {
                return salary;
            }

            /**
             * Sets the value of the salary property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSALARY(String value) {
                this.salary = value;
            }

            /**
             * Gets the value of the shortname property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSHORTNAME() {
                return shortname;
            }

            /**
             * Sets the value of the shortname property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSHORTNAME(String value) {
                this.shortname = value;
            }

            /**
             * Gets the value of the target property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTARGET() {
                return target;
            }

            /**
             * Sets the value of the target property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTARGET(String value) {
                this.target = value;
            }

            /**
             * Gets the value of the taxid property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTAXID() {
                return taxid;
            }

            /**
             * Sets the value of the taxid property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTAXID(String value) {
                this.taxid = value;
            }

            /**
             * Gets the value of the phone1 property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPHONE1() {
                return phone1;
            }

            /**
             * Sets the value of the phone1 property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPHONE1(String value) {
                this.phone1 = value;
            }

            /**
             * Gets the value of the email1 property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEMAIL1() {
                return email1;
            }

            /**
             * Sets the value of the email1 property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEMAIL1(String value) {
                this.email1 = value;
            }

            /**
             * Gets the value of the salarynet property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSALARYNET() {
                return salarynet;
            }

            /**
             * Sets the value of the salarynet property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSALARYNET(String value) {
                this.salarynet = value;
            }

            /**
             * Gets the value of the sms1 property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSMS1() {
                return sms1;
            }

            /**
             * Sets the value of the sms1 property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSMS1(String value) {
                this.sms1 = value;
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
             * Gets the value of the onlineactualbal property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getONLINEACTUALBAL() {
                return onlineactualbal;
            }

            /**
             * Sets the value of the onlineactualbal property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setONLINEACTUALBAL(String value) {
                this.onlineactualbal = value;
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
             * Gets the value of the clearedbalance property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCLEAREDBALANCE() {
                return clearedbalance;
            }

            /**
             * Sets the value of the clearedbalance property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCLEAREDBALANCE(String value) {
                this.clearedbalance = value;
            }

            /**
             * Gets the value of the unclearedbalance property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUNCLEAREDBALANCE() {
                return unclearedbalance;
            }

            /**
             * Sets the value of the unclearedbalance property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUNCLEAREDBALANCE(String value) {
                this.unclearedbalance = value;
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
