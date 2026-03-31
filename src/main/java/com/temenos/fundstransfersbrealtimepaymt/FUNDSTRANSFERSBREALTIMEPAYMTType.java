
package com.temenos.fundstransfersbrealtimepaymt;

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
 * <p>Java class for FUNDSTRANSFERSBREALTIMEPAYMTType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FUNDSTRANSFERSBREALTIMEPAYMTType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ContaDebita" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MoedadeDebito" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MontanteaDebitar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DataValordoDebito" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReferenciadoDebito" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ReferenciadoComerciante" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ContadoComerciante" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MoedadeCredito" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MontantedoCredito" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DataValordoCredito" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gPAYMENTDETAILS" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="DetalhesPagamento" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
@XmlType(name = "FUNDSTRANSFERSBREALTIMEPAYMTType", propOrder = {
    "contaDebita",
    "moedadeDebito",
    "montanteaDebitar",
    "dataValordoDebito",
    "referenciadoDebito",
    "referenciadoComerciante",
    "contadoComerciante",
    "moedadeCredito",
    "montantedoCredito",
    "dataValordoCredito",
    "gpaymentdetails"
})
public class FUNDSTRANSFERSBREALTIMEPAYMTType {

    @XmlElement(name = "ContaDebita")
    protected String contaDebita;
    @XmlElement(name = "MoedadeDebito")
    protected String moedadeDebito;
    @XmlElement(name = "MontanteaDebitar")
    protected String montanteaDebitar;
    @XmlElement(name = "DataValordoDebito")
    protected String dataValordoDebito;
    @XmlElement(name = "ReferenciadoDebito")
    protected String referenciadoDebito;
    @XmlElement(name = "ReferenciadoComerciante")
    protected String referenciadoComerciante;
    @XmlElement(name = "ContadoComerciante")
    protected String contadoComerciante;
    @XmlElement(name = "MoedadeCredito")
    protected String moedadeCredito;
    @XmlElement(name = "MontantedoCredito")
    protected String montantedoCredito;
    @XmlElement(name = "DataValordoCredito")
    protected String dataValordoCredito;
    @XmlElement(name = "gPAYMENTDETAILS")
    protected FUNDSTRANSFERSBREALTIMEPAYMTType.GPAYMENTDETAILS gpaymentdetails;
    @XmlAttribute(name = "id")
    protected String id;

    /**
     * Gets the value of the contaDebita property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContaDebita() {
        return contaDebita;
    }

    /**
     * Sets the value of the contaDebita property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContaDebita(String value) {
        this.contaDebita = value;
    }

    /**
     * Gets the value of the moedadeDebito property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMoedadeDebito() {
        return moedadeDebito;
    }

    /**
     * Sets the value of the moedadeDebito property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMoedadeDebito(String value) {
        this.moedadeDebito = value;
    }

    /**
     * Gets the value of the montanteaDebitar property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMontanteaDebitar() {
        return montanteaDebitar;
    }

    /**
     * Sets the value of the montanteaDebitar property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMontanteaDebitar(String value) {
        this.montanteaDebitar = value;
    }

    /**
     * Gets the value of the dataValordoDebito property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataValordoDebito() {
        return dataValordoDebito;
    }

    /**
     * Sets the value of the dataValordoDebito property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataValordoDebito(String value) {
        this.dataValordoDebito = value;
    }

    /**
     * Gets the value of the referenciadoDebito property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenciadoDebito() {
        return referenciadoDebito;
    }

    /**
     * Sets the value of the referenciadoDebito property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenciadoDebito(String value) {
        this.referenciadoDebito = value;
    }

    /**
     * Gets the value of the referenciadoComerciante property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenciadoComerciante() {
        return referenciadoComerciante;
    }

    /**
     * Sets the value of the referenciadoComerciante property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenciadoComerciante(String value) {
        this.referenciadoComerciante = value;
    }

    /**
     * Gets the value of the contadoComerciante property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContadoComerciante() {
        return contadoComerciante;
    }

    /**
     * Sets the value of the contadoComerciante property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContadoComerciante(String value) {
        this.contadoComerciante = value;
    }

    /**
     * Gets the value of the moedadeCredito property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMoedadeCredito() {
        return moedadeCredito;
    }

    /**
     * Sets the value of the moedadeCredito property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMoedadeCredito(String value) {
        this.moedadeCredito = value;
    }

    /**
     * Gets the value of the montantedoCredito property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMontantedoCredito() {
        return montantedoCredito;
    }

    /**
     * Sets the value of the montantedoCredito property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMontantedoCredito(String value) {
        this.montantedoCredito = value;
    }

    /**
     * Gets the value of the dataValordoCredito property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataValordoCredito() {
        return dataValordoCredito;
    }

    /**
     * Sets the value of the dataValordoCredito property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataValordoCredito(String value) {
        this.dataValordoCredito = value;
    }

    /**
     * Gets the value of the gpaymentdetails property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERSBREALTIMEPAYMTType.GPAYMENTDETAILS }
     *     
     */
    public FUNDSTRANSFERSBREALTIMEPAYMTType.GPAYMENTDETAILS getGPAYMENTDETAILS() {
        return gpaymentdetails;
    }

    /**
     * Sets the value of the gpaymentdetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERSBREALTIMEPAYMTType.GPAYMENTDETAILS }
     *     
     */
    public void setGPAYMENTDETAILS(FUNDSTRANSFERSBREALTIMEPAYMTType.GPAYMENTDETAILS value) {
        this.gpaymentdetails = value;
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
     *         &lt;element name="DetalhesPagamento" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "detalhesPagamento"
    })
    public static class GPAYMENTDETAILS {

        @XmlElement(name = "DetalhesPagamento")
        protected List<String> detalhesPagamento;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the detalhesPagamento property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the detalhesPagamento property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDetalhesPagamento().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getDetalhesPagamento() {
            if (detalhesPagamento == null) {
                detalhesPagamento = new ArrayList<String>();
            }
            return this.detalhesPagamento;
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

}
