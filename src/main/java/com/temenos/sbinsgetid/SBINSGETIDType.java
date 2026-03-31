
package com.temenos.sbinsgetid;

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
 * <p>Java class for SBINSGETIDType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SBINSGETIDType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="gSBINSGETIDDetailType" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="mSBINSGETIDDetailType" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="selFldNETTXNID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="FTID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="RECORDSTATUS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="AUTHORISER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="AUTHDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="AMOUNTDEBITED" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="AMOUNTCREDITED" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "SBINSGETIDType", propOrder = {
    "gsbinsgetidDetailType"
})
public class SBINSGETIDType {

    @XmlElement(name = "gSBINSGETIDDetailType")
    protected SBINSGETIDType.GSBINSGETIDDetailType gsbinsgetidDetailType;

    /**
     * Gets the value of the gsbinsgetidDetailType property.
     * 
     * @return
     *     possible object is
     *     {@link SBINSGETIDType.GSBINSGETIDDetailType }
     *     
     */
    public SBINSGETIDType.GSBINSGETIDDetailType getGSBINSGETIDDetailType() {
        return gsbinsgetidDetailType;
    }

    /**
     * Sets the value of the gsbinsgetidDetailType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SBINSGETIDType.GSBINSGETIDDetailType }
     *     
     */
    public void setGSBINSGETIDDetailType(SBINSGETIDType.GSBINSGETIDDetailType value) {
        this.gsbinsgetidDetailType = value;
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
     *         &lt;element name="mSBINSGETIDDetailType" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="selFldNETTXNID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="FTID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="RECORDSTATUS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="AUTHORISER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="AUTHDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="AMOUNTDEBITED" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="AMOUNTCREDITED" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "msbinsgetidDetailType"
    })
    public static class GSBINSGETIDDetailType {

        @XmlElement(name = "mSBINSGETIDDetailType")
        protected List<SBINSGETIDType.GSBINSGETIDDetailType.MSBINSGETIDDetailType> msbinsgetidDetailType;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the msbinsgetidDetailType property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the msbinsgetidDetailType property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMSBINSGETIDDetailType().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SBINSGETIDType.GSBINSGETIDDetailType.MSBINSGETIDDetailType }
         * 
         * 
         */
        public List<SBINSGETIDType.GSBINSGETIDDetailType.MSBINSGETIDDetailType> getMSBINSGETIDDetailType() {
            if (msbinsgetidDetailType == null) {
                msbinsgetidDetailType = new ArrayList<SBINSGETIDType.GSBINSGETIDDetailType.MSBINSGETIDDetailType>();
            }
            return this.msbinsgetidDetailType;
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
         *         &lt;element name="FTID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="RECORDSTATUS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="AUTHORISER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="AUTHDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="AMOUNTDEBITED" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="AMOUNTCREDITED" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "ftid",
            "recordstatus",
            "authoriser",
            "authdate",
            "amountdebited",
            "amountcredited"
        })
        public static class MSBINSGETIDDetailType {

            protected String selFldNETTXNID;
            @XmlElement(name = "FTID")
            protected String ftid;
            @XmlElement(name = "RECORDSTATUS")
            protected String recordstatus;
            @XmlElement(name = "AUTHORISER")
            protected String authoriser;
            @XmlElement(name = "AUTHDATE")
            protected String authdate;
            @XmlElement(name = "AMOUNTDEBITED")
            protected String amountdebited;
            @XmlElement(name = "AMOUNTCREDITED")
            protected String amountcredited;
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
             * Gets the value of the ftid property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFTID() {
                return ftid;
            }

            /**
             * Sets the value of the ftid property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFTID(String value) {
                this.ftid = value;
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
             * Gets the value of the authdate property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAUTHDATE() {
                return authdate;
            }

            /**
             * Sets the value of the authdate property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAUTHDATE(String value) {
                this.authdate = value;
            }

            /**
             * Gets the value of the amountdebited property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAMOUNTDEBITED() {
                return amountdebited;
            }

            /**
             * Sets the value of the amountdebited property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAMOUNTDEBITED(String value) {
                this.amountdebited = value;
            }

            /**
             * Gets the value of the amountcredited property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAMOUNTCREDITED() {
                return amountcredited;
            }

            /**
             * Sets the value of the amountcredited property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAMOUNTCREDITED(String value) {
                this.amountcredited = value;
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
