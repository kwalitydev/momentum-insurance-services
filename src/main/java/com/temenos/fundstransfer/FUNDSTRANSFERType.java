
package com.temenos.fundstransfer;

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
 * <p>Java class for FUNDSTRANSFERType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FUNDSTRANSFERType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TRANSACTIONTYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DEBITACCTNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="INDEBITACCTNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CURRENCYMKTDR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DEBITCURRENCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DEBITAMOUNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DEBITVALUEDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="INDEBITVDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DEBITTHEIRREF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CREDITTHEIRREF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CREDITACCTNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CURRENCYMKTCR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CREDITCURRENCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CREDITAMOUNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CREDITVALUEDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TREASURYRATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NEGDEALERREFNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PROCESSINGDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gORDERINGCUST" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ORDERINGCUST" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="gINORDERINGCUS" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="INORDERINGCUS" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="gORDERINGBANK" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ORDERINGBANK" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="gINORDERINGBK" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="INORDERINGBK" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="gACCTWITHBANK" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ACCTWITHBANK" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="gACCTWITHBK" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ACCTWITHBK" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="BENACCTNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="INBENACCTNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gBENCUSTOMER" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="BENCUSTOMER" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="gINBENCUSTOMER" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="INBENCUSTOMER" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="gBENBANK" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="BENBANK" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="gINBENBANK" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="INBENBANK" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CHEQUENUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gPAYMENTDETAILS" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="PAYMENTDETAILS" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="gINPAYDETAILS" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="INPAYDETAILS" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="BCBANKSORTCODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RECEIVERBANK" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gRECCORRBANK" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="RECCORRBANK" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="gINTERMEDBANK" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="INTERMEDBANK" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="gININTMEDBANK" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ININTMEDBANK" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="MAILING" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PAYMETHOD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BENOURCHARGES" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="INBENOURCHARGES" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CHARGESACCTNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CHARGECOMDISPLAY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COMMISSIONCODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gCOMMISSIONTYPE" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="mCOMMISSIONTYPE" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="COMMISSIONTYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="COMMISSIONAMT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="COMMISSIONFOR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
 *         &lt;element name="CHARGECODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gCHARGETYPE" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="mCHARGETYPE" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="CHARGETYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="CHARGEAMT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="CHARGEFOR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
 *         &lt;element name="CUSTOMERSPREAD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BASECURRENCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PROFITCENTRECUST" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PROFITCENTREDEPT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RETURNTODEPT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PRIORITYTXN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gBKTOBKINFO" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="BKTOBKINFO" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="gINBKTOBK" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="INBKTOBK" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="EXPOSUREDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FEDFUNDS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="POSITIONTYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NOOFBATCHITEMS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gFREETEXTMSGTO" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="FREETEXTMSGTO" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="gMESSAGE" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="MESSAGE" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="gTAXTYPE" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="mTAXTYPE" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="TAXTYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="TAXAMT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
 *         &lt;element name="AMOUNTDEBITED" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AMOUNTCREDITED" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TOTALCHARGEAMT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TOTALTAXAMOUNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CUSTOMERRATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gINRECCORRBK" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="INRECCORRBK" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="INWARDPAYTYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gINSENDCORRBK" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="INSENDCORRBK" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="TELEXFROMCUST" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DELIVERYINREF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gDELIVERYOUTREF" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="DELIVERYOUTREF" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CREDITCOMPCODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DEBITCOMPCODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="STATUS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DELIVERYMKR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ORDCUSTCODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACCTWITHBKACNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LOCAMTDEBITED" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LOCAMTCREDITED" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LOCTOTTAXAMT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LOCALCHARGEAMT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LOCPOSCHGSAMT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MKTGEXCHPROFIT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RATEINPUTMKR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CUSTGROUPLEVEL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DEBITCUSTOMER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CREDITCUSTOMER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SENDPAYMENTYN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DRADVICEREQDYN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CRADVICEREQDYN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DEALMARKET" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CHARGEDCUSTOMER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gINREASONOVE" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="INREASONOVE" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="DEALERDESK" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RECALCFWDRATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RETURNCHEQUE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DRAWNACCOUNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACCOUNTINGDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gINSTRCTNCODE" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="INSTRCTNCODE" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="COLLREMBK" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EXPECTEDRECSID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TOTRECCOMM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TOTRECCOMMLCL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TOTRECCHG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TOTRECCHGLCL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CHEQTYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gRELATEDMSG" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="mRELATEDMSG" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="RELATEDMSG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="sgTIMEIND" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="TIMEIND" maxOccurs="unbounded" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="TIMEIND" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                               &lt;/sequence>
 *                                               &lt;attribute name="s" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                     &lt;attribute name="sg" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
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
 *         &lt;element name="gINTIMEIND" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="INTIMEIND" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="gSENDTOPARTY" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="mSENDTOPARTY" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="SENDTOPARTY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="sgBKTOBKOUT" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="BKTOBKOUT" maxOccurs="unbounded" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="BKTOBKOUT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                               &lt;/sequence>
 *                                               &lt;attribute name="s" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                     &lt;attribute name="sg" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="MESSAGETYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
 *         &lt;element name="REVERSALMKR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RELATEDREF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gININSTRCODE" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ININSTRCODE" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="gINPROCESSERR" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="INPROCESSERR" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="gINSWIFTMSG" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="INSWIFTMSG" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ACCTWITHBANKACC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="INACCTBANKACC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RECCORRBANKACC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="INRECCORRACC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="INTERMEDBANKACC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ININTERMEDACC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="INSTRUCTEDAMT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gININTERMEDBK" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ININTERMEDBK" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="INEXCHRATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RATEFIXING" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COVERMETHOD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gIN3RDREIMBBK" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="IN3RDREIMBBK" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="IN3RDREIMBACC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MT103TYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EXTENDFORMAT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gEXTENDINFO" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="EXTENDINFO" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="RATEFIXINGIND" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="INWSENDBIC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gINSENDCHG" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="INSENDCHG" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="INRECCHG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACCHGREQID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TOTRECCHGCRCCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TOTSNDCHGCRCCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CHGADVICEMSG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EXPECTEDCOVERID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NETTINGSTATUS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AUTHDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BKOPERATIONCODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AMINFLOWRATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PARENTTXNID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ROUNDTYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BENEFICIARYID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gMSGTYPE" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="mMSGTYPE" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="MSGTYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="MSGDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
 *         &lt;element name="gSIGNATORY" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="SIGNATORY" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CARDNUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gCARDTXNDETAIL" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="CARDTXNDETAIL" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="gINCORDBK" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="INCORDBK" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="gINCINTMEDBK" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="INCINTMEDBK" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="gINCACCWITBK" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="INCACCWITBK" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="gINCBKTBKIN" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="INCBKTBKIN" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="TFSREFERENCE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CHEQUEDRAWN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ISSUECHEQUETYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="STOCKNUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PAYEENAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="STOCKREGISTER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SERIESID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ORDCUSTACCT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="INORDCUSTACCT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IBANDEBIT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IBANCREDIT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IBANBEN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IBANACCTWITHBANK" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IBANRECCORRBANK" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IBANINTERMEDBANK" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IBANORDCUSTACC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IBANCHARGESACCT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BICIBANBEN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gBICIBANBENNAME" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="BICIBANBENNAME" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="BICIBANBENCITY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gBENNAME" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="BENNAME" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="gBENADDRESS" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="BENADDRESS" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="BENCOUNTRY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gBENTOWN" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="BENTOWN" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="gINBENNAME" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="INBENNAME" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="gINBENADDRESS" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="INBENADDRESS" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="INBENCOUNTRY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gINBENTOWN" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="INBENTOWN" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="gREFDATAITEM" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="mREFDATAITEM" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="REFDATAITEM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="REFDATAVALUE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
 *         &lt;element name="gLOCEQUIVCHGS" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="LOCEQUIVCHGS" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="gFOREQUIVCHGS" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="FOREQUIVCHGS" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="REGCOMPLIANCE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CBCREDITACCOUNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CBCREDITCCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CBDEBITACCOUNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CBDEBITCCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TCSIMACCEPTED" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LASTSIMTIME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="INHDR3UETR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gSPLITEXPOSUREDATE" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="mSPLITEXPOSUREDATE" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="SPLITEXPOSUREDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="SPLITEXPOSUREAMT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
 *         &lt;element name="AUTHORISATIONID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EXEMPTFROMSCA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="STATUSREASONCODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RESERVED4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RESERVED3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RESERVED2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RESERVED1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gSTMTNOS" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="STMTNOS" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
 *         &lt;element name="FOREXCLASS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UNPAIDCHEQUE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SBBANKNUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CCVERSION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BALCOANAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gBENEFNAME" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="BENEFNAME" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="BENEFACCT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ForeignBanks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CountryTable" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="INPUTVERSION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COMMCHARGE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AUTHVERSION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="INTCAT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BoletimRegisto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FTNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="QtdDocEnv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BRANCHNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ActualBalance" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CLEAREDBALANCE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TRANSTYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gSENDEDDOCUMENT" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="SendedDocument" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CONTA2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SIBSCARDNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="POINTOFSERVCE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACQINSTITUTE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TERMINALTYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TERMINALID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PROCESSINGCODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DebitCategory" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CreditCategory" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CODAGE2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CARDNUMFULL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IDLOG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NRLOG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BANKCODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TIPOTRANSACCAO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BRANCHCODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BRANCHACCTNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IDPERLOCAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NUMREGLOC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NRIDRESP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NRIDRESPO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IDLOGO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NRLOGO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DHMSGO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TIPODOC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="INTERBANKZONE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CODINVCORRDR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CLEARINGPERIOD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BSTMBMCHQID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CUSTACCOUNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SERVICEACCOUNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FTUNPAIDNR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IBKPARTYPAY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FOREIGNCHQNR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NOMEDOCAIXA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NRCONTRIBUINTE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SEQUENCE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CODINVCORRCR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PRAZOPEND" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PRACAAPFISICA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="REFCUTEDB" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="REFCUTECR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FULLCONTRTNR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="INVOICENUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BRANCH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CONTRACTNUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SEQUENCENUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CHECKDIGIT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PRODTYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CIRCUITNR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="INVOICEDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IdCard" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DOCNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GIBID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DEFAUXILFEE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SPCAUXILFEE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SBCARDNUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Adress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EMAILADDRESS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LOCALIDADE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TELNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACCOUNT2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="QTDTITULOS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Surname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CODESTATDR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CODESTATCR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LINKID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TIPOPAGAMENTO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COCACOLAREL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SEQTRANS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NRCOMERCIANTE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ISOAUTHCD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DATATRANS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HORATRANS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NRCARTAO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PAISTRANS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PAISCARTAO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ISOACCNME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ISOCURRCD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ISOTRANAMT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ISOCONVRT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ISOCBAMTBIL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ISOCBAMTDEV" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ISOCBAMTACT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ISOSTLCURR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ISOSTLAMT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ISOSTLCONV" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ISOACTBAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ISOAVAILBAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ISOPRN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ISOSTAN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ISOTXNTYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ISOTERMTYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ISOTERMID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACQIMD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ISOCONTRYCODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CONTRIBUICOES" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MULTA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="JUROSMORA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ADICIONAIS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="INSSREL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LOCKEVENTID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DEPOSITOR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ORDERDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gBTBFOURHUNDRED" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="BTBFOURHUNDRED" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ORDERNIB" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FLAGNIB" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IBAN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BENEFNIB" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gWORDAMT" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="WORDAMT" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="BMCORRESPORIG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BMCORRESPDEST" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SBCLOSEDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SBOPENDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SBVATNUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SBASSETTYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SBTAXTYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NRNUIT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CONFIRMATION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BENEFNUIT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BENEFIBAN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DBACCTNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CRACCTNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MSGID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CRDIMD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CRDBRCODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CRDNUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="REFERENCE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NRCARREGAMENTO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="STICKETNUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="REFERENCIA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TRACENO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BATCHID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BATCHITEMID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ISENTOCOMISSAO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FONTEFINANCTO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="REPAYMENTACCT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NRSOLICITACAO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gSBTOWNCOUNTRY" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="SBTOWNCOUNTRY" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CODMSG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VERMSG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TIPOTERM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DHMSG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TIPOAUT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IDTERMINAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LOCTERM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PVV2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PVV3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IDACEITANTE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MONTIND" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IDPROP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RETREF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NATOPER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DTHORA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SEQMOV" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DATEXP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SEQPAN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CONTA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NOMECLI" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NSITCAR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MODINS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MCC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DISTCONC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MOTCAPT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SENHA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="REFDEP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SISTAG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CODPAIS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CODMOEDA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CAMBIO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IMPORTOP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VALTOTAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BANAPOIO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="REFPAG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DESCSE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TIPSER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NIBDEST" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SINAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IDCOMEMP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IDEST" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PRODFIN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ENTIDADE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NIBORD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CREDDEST" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CODTRNE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PINBLOCK" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EXPP2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COMPP2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PISTA2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DTINIAPLIC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CARTERM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CAPTERMACQ" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="APPCOUNTER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="APPPROFILE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TIPOCRIP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CRIPTOGRAMA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ISSAPDATA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TVR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NRSEQPAN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IDCOMREP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CRIPTINF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CVMRESULTS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DFNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="APLICN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EMVPADRAO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FIDELIZACAOID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="INDTIPPAG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CREPRESTCLI" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FIDPONTOSREB" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FIDPONTOSDIS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FIDVALORPONT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FIDVALORREM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COMPPAN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PAN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MNTE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MNTADI" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TOTOPERE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COMPDADOSV" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VERDADOSV" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CAPTERM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UNPNR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="APLICPDD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COMEMI1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COMEMI2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COMPROP1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COMPROP2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MONTANTE1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MONTANTE2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TAXACLI1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TAXACLI2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PGTOANTECIPADO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SALOPERATOR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SBTRRATEREF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SBCHANNEL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ORIGORDERACCT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WFINPUTTER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WFAUTHORISER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WFID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CALYPLOGREF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CALYPSOCUSNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DEBITACNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NBOLORDERREF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NBOLACTREF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NBOLPARENTTXN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DRBANKBIC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CRBANKBIC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DRBANKSCODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CRBANKSCODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DESTACCTNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TOTALCRCNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TOTLONUSDRAMT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TOTLOFUSDRAMT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ONUSCRCNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OFFUSCRCNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UNIQUEMSGID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PAYEXMSGID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CODDISTRICT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CODREVENUE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CODCONSMUNI" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gSBORDCUSADDR" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="SBORDCUSADDR" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="STOTALTAXAMT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TAXAMT2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NETTXNID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="REQUESTDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NETUSERNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IBKTXNID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IDTYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SBIDNUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CUSIDENTITY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CDMTRANSREF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ADCNUMBER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="INMSGREF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SBUETRID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ORIGINFUNDS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DESTINATION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="USDEQUIV" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="STARTDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DUEDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ENDDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ORIGINWAIVE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DOCSUPME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SBAV10EXCEP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BSTMCOUNTRY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SBTIPOINVEST" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SBPAISINVEST" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PERCENTACCOES" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VALORACCOES" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MGRAMGRAUP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MGRAMTXNR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACCCURRENCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DEALTCKBENEF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TREASURYRBENEF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CHGACCOUNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EXCHANGEVALUE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CONVCCYVALUE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SBDATEISSUE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CTYOFISSUE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SBEXPIRYDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AuthCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gSBCHARGECODE" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="mSBCHARGECODE" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="SBCHARGECODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="SBCHARGEAMT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
 *         &lt;element name="SBBUYRATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SBSELLRATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CROSSDEALRATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TTSPECCOND" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TTSPECCONDS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BSTMTRFREF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NOTASCODEOT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NOTUSED" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IdExpiryDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NRCLIENTE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PROVEDOR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SBLOCALAMT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MASSVALORDIFF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EMPLADDRESS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MOTIVOOP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SEXO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SEX" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ISSUECOUNTRY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DEPNATIONALITY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CONDUCTOR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PAYERNAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LSOURCETYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LBUSINESSIND" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CHANNELREF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="POSTINGTYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PRACAEMISSAO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BANCOAGENCIA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SBRECVERCORR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SWIFTFILENAME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SWIFTTXNID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MONTRANERR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SISTAFE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACHMESSAGEID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACHTXNID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "FUNDSTRANSFERType", propOrder = {
    "transactiontype",
    "debitacctno",
    "indebitacctno",
    "currencymktdr",
    "debitcurrency",
    "debitamount",
    "debitvaluedate",
    "indebitvdate",
    "debittheirref",
    "credittheirref",
    "creditacctno",
    "currencymktcr",
    "creditcurrency",
    "creditamount",
    "creditvaluedate",
    "treasuryrate",
    "negdealerrefno",
    "processingdate",
    "gorderingcust",
    "ginorderingcus",
    "gorderingbank",
    "ginorderingbk",
    "gacctwithbank",
    "gacctwithbk",
    "benacctno",
    "inbenacctno",
    "gbencustomer",
    "ginbencustomer",
    "gbenbank",
    "ginbenbank",
    "chequenumber",
    "gpaymentdetails",
    "ginpaydetails",
    "bcbanksortcode",
    "receiverbank",
    "greccorrbank",
    "gintermedbank",
    "ginintmedbank",
    "mailing",
    "paymethod",
    "benourcharges",
    "inbenourcharges",
    "chargesacctno",
    "chargecomdisplay",
    "commissioncode",
    "gcommissiontype",
    "chargecode",
    "gchargetype",
    "customerspread",
    "basecurrency",
    "profitcentrecust",
    "profitcentredept",
    "returntodept",
    "prioritytxn",
    "gbktobkinfo",
    "ginbktobk",
    "exposuredate",
    "fedfunds",
    "positiontype",
    "noofbatchitems",
    "gfreetextmsgto",
    "gmessage",
    "gtaxtype",
    "amountdebited",
    "amountcredited",
    "totalchargeamt",
    "totaltaxamount",
    "customerrate",
    "ginreccorrbk",
    "inwardpaytype",
    "ginsendcorrbk",
    "telexfromcust",
    "deliveryinref",
    "gdeliveryoutref",
    "creditcompcode",
    "debitcompcode",
    "status",
    "deliverymkr",
    "ordcustcode",
    "acctwithbkacno",
    "locamtdebited",
    "locamtcredited",
    "loctottaxamt",
    "localchargeamt",
    "locposchgsamt",
    "mktgexchprofit",
    "rateinputmkr",
    "custgrouplevel",
    "debitcustomer",
    "creditcustomer",
    "sendpaymentyn",
    "dradvicereqdyn",
    "cradvicereqdyn",
    "dealmarket",
    "chargedcustomer",
    "ginreasonove",
    "dealerdesk",
    "recalcfwdrate",
    "returncheque",
    "drawnaccount",
    "accountingdate",
    "ginstrctncode",
    "collrembk",
    "expectedrecsid",
    "totreccomm",
    "totreccommlcl",
    "totrecchg",
    "totrecchglcl",
    "cheqtype",
    "grelatedmsg",
    "gintimeind",
    "gsendtoparty",
    "reversalmkr",
    "relatedref",
    "gininstrcode",
    "ginprocesserr",
    "ginswiftmsg",
    "acctwithbankacc",
    "inacctbankacc",
    "reccorrbankacc",
    "inreccorracc",
    "intermedbankacc",
    "inintermedacc",
    "instructedamt",
    "ginintermedbk",
    "inexchrate",
    "ratefixing",
    "covermethod",
    "gin3RDREIMBBK",
    "in3RDREIMBACC",
    "mt103TYPE",
    "extendformat",
    "gextendinfo",
    "ratefixingind",
    "inwsendbic",
    "ginsendchg",
    "inrecchg",
    "acchgreqid",
    "totrecchgcrccy",
    "totsndchgcrccy",
    "chgadvicemsg",
    "expectedcoverid",
    "nettingstatus",
    "authdate",
    "bkoperationcode",
    "aminflowrate",
    "parenttxnid",
    "roundtype",
    "beneficiaryid",
    "gmsgtype",
    "gsignatory",
    "cardnumber",
    "gcardtxndetail",
    "gincordbk",
    "gincintmedbk",
    "gincaccwitbk",
    "gincbktbkin",
    "tfsreference",
    "chequedrawn",
    "issuechequetype",
    "stocknumber",
    "payeename",
    "stockregister",
    "seriesid",
    "ordcustacct",
    "inordcustacct",
    "ibandebit",
    "ibancredit",
    "ibanben",
    "ibanacctwithbank",
    "ibanreccorrbank",
    "ibanintermedbank",
    "ibanordcustacc",
    "ibanchargesacct",
    "bicibanben",
    "gbicibanbenname",
    "bicibanbencity",
    "gbenname",
    "gbenaddress",
    "bencountry",
    "gbentown",
    "ginbenname",
    "ginbenaddress",
    "inbencountry",
    "ginbentown",
    "grefdataitem",
    "glocequivchgs",
    "gforequivchgs",
    "regcompliance",
    "cbcreditaccount",
    "cbcreditccy",
    "cbdebitaccount",
    "cbdebitccy",
    "tcsimaccepted",
    "lastsimtime",
    "inhdr3UETR",
    "gsplitexposuredate",
    "authorisationid",
    "exemptfromsca",
    "statusreasoncode",
    "reserved4",
    "reserved3",
    "reserved2",
    "reserved1",
    "gstmtnos",
    "goverride",
    "recordstatus",
    "currno",
    "ginputter",
    "gdatetime",
    "authoriser",
    "cocode",
    "deptcode",
    "auditorcode",
    "auditdatetime",
    "forexclass",
    "unpaidcheque",
    "sbbanknumber",
    "ccversion",
    "balcoaname",
    "gbenefname",
    "benefacct",
    "foreignBanks",
    "countryTable",
    "inputversion",
    "commcharge",
    "authversion",
    "intcat",
    "boletimRegisto",
    "ftno",
    "qtdDocEnv",
    "branchname",
    "actualBalance",
    "clearedbalance",
    "transtype",
    "gsendeddocument",
    "conta2",
    "sibscardno",
    "pointofservce",
    "acqinstitute",
    "terminaltype",
    "terminalid",
    "processingcode",
    "debitCategory",
    "creditCategory",
    "codage2",
    "cardnumfull",
    "idlog",
    "nrlog",
    "bankcode",
    "tipotransaccao",
    "branchcode",
    "branchacctno",
    "idperlocal",
    "numregloc",
    "nridresp",
    "nridrespo",
    "idlogo",
    "nrlogo",
    "dhmsgo",
    "tipodoc",
    "interbankzone",
    "codinvcorrdr",
    "clearingperiod",
    "bstmbmchqid",
    "custaccount",
    "serviceaccount",
    "ftunpaidnr",
    "ibkpartypay",
    "foreignchqnr",
    "nomedocaixa",
    "nrcontribuinte",
    "sequence",
    "codinvcorrcr",
    "prazopend",
    "pracaapfisica",
    "refcutedb",
    "refcutecr",
    "fullcontrtnr",
    "invoicenumber",
    "branch",
    "contractnumber",
    "sequencenumber",
    "checkdigit",
    "prodtype",
    "circuitnr",
    "invoicedate",
    "idCard",
    "docNo",
    "gibid",
    "defauxilfee",
    "spcauxilfee",
    "name",
    "sbcardnumber",
    "adress",
    "emailaddress",
    "localidade",
    "telno",
    "account2",
    "qtdtitulos",
    "surname",
    "codestatdr",
    "codestatcr",
    "linkid",
    "tipopagamento",
    "cocacolarel",
    "seqtrans",
    "nrcomerciante",
    "isoauthcd",
    "datatrans",
    "horatrans",
    "nrcartao",
    "paistrans",
    "paiscartao",
    "isoaccnme",
    "isocurrcd",
    "isotranamt",
    "isoconvrt",
    "isocbamtbil",
    "isocbamtdev",
    "isocbamtact",
    "isostlcurr",
    "isostlamt",
    "isostlconv",
    "isoactbal",
    "isoavailbal",
    "isoprn",
    "isostan",
    "isotxntype",
    "isotermtype",
    "isotermid",
    "acqimd",
    "isocontrycode",
    "contribuicoes",
    "multa",
    "jurosmora",
    "adicionais",
    "inssrel",
    "lockeventid",
    "date",
    "depositor",
    "orderdate",
    "gbtbfourhundred",
    "ordernib",
    "flagnib",
    "iban",
    "benefnib",
    "gwordamt",
    "bmcorresporig",
    "bmcorrespdest",
    "sbclosedate",
    "sbopendate",
    "sbvatnumber",
    "sbassettype",
    "sbtaxtype",
    "nrnuit",
    "confirmation",
    "benefnuit",
    "benefiban",
    "dbacctname",
    "cracctname",
    "msgid",
    "crdimd",
    "crdbrcode",
    "crdnumber",
    "reference",
    "nrcarregamento",
    "sticketnumber",
    "referencia",
    "traceno",
    "batchid",
    "batchitemid",
    "isentocomissao",
    "fontefinancto",
    "repaymentacct",
    "nrsolicitacao",
    "gsbtowncountry",
    "codmsg",
    "vermsg",
    "tipoterm",
    "dhmsg",
    "tipoaut",
    "idterminal",
    "locterm",
    "pvv2",
    "pvv3",
    "idaceitante",
    "montind",
    "idprop",
    "retref",
    "natoper",
    "dthora",
    "seqmov",
    "datexp",
    "seqpan",
    "conta",
    "nomecli",
    "nsitcar",
    "modins",
    "mcc",
    "distconc",
    "motcapt",
    "senha",
    "refdep",
    "sistag",
    "codpais",
    "codmoeda",
    "cambio",
    "importop",
    "valtotal",
    "banapoio",
    "refpag",
    "descse",
    "tipser",
    "nibdest",
    "sinal",
    "idcomemp",
    "idest",
    "prodfin",
    "entidade",
    "nibord",
    "creddest",
    "codtrne",
    "pinblock",
    "expp2",
    "compp2",
    "pista2",
    "dtiniaplic",
    "carterm",
    "captermacq",
    "appcounter",
    "appprofile",
    "tipocrip",
    "criptograma",
    "issapdata",
    "tvr",
    "nrseqpan",
    "idcomrep",
    "criptinf",
    "cvmresults",
    "dfname",
    "aplicn",
    "emvpadrao",
    "fidelizacaoid",
    "indtippag",
    "creprestcli",
    "fidpontosreb",
    "fidpontosdis",
    "fidvalorpont",
    "fidvalorrem",
    "comppan",
    "pan",
    "mnte",
    "mntadi",
    "totopere",
    "compdadosv",
    "verdadosv",
    "capterm",
    "unpnr",
    "aplicpdd",
    "comemi1",
    "comemi2",
    "comprop1",
    "comprop2",
    "montante1",
    "montante2",
    "taxacli1",
    "taxacli2",
    "pgtoantecipado",
    "saloperator",
    "sbtrrateref",
    "sbchannel",
    "origorderacct",
    "wfinputter",
    "wfauthoriser",
    "wfid",
    "calyplogref",
    "calypsocusname",
    "debitacname",
    "nbolorderref",
    "nbolactref",
    "nbolparenttxn",
    "drbankbic",
    "crbankbic",
    "drbankscode",
    "crbankscode",
    "destacctno",
    "totalcrcnt",
    "totlonusdramt",
    "totlofusdramt",
    "onuscrcnt",
    "offuscrcnt",
    "uniquemsgid",
    "payexmsgid",
    "coddistrict",
    "codrevenue",
    "codconsmuni",
    "gsbordcusaddr",
    "stotaltaxamt",
    "taxamt2",
    "nettxnid",
    "requestdate",
    "netusername",
    "ibktxnid",
    "idtype",
    "sbidnumber",
    "cusidentity",
    "cdmtransref",
    "adcnumber",
    "inmsgref",
    "sbuetrid",
    "originfunds",
    "destination",
    "usdequiv",
    "startdate",
    "duedate",
    "enddate",
    "originwaive",
    "docsupme",
    "sbav10EXCEP",
    "bstmcountry",
    "sbtipoinvest",
    "sbpaisinvest",
    "percentaccoes",
    "valoraccoes",
    "mgramgraup",
    "mgramtxnr",
    "acccurrency",
    "dealtckbenef",
    "treasuryrbenef",
    "chgaccount",
    "exchangevalue",
    "convccyvalue",
    "sbdateissue",
    "ctyofissue",
    "sbexpirydate",
    "authCode",
    "gsbchargecode",
    "sbbuyrate",
    "sbsellrate",
    "crossdealrate",
    "ttspeccond",
    "ttspecconds",
    "bstmtrfref",
    "notascodeot",
    "notused",
    "idExpiryDate",
    "nrcliente",
    "provedor",
    "sblocalamt",
    "massvalordiff",
    "empladdress",
    "motivoop",
    "sexo",
    "sex",
    "issuecountry",
    "depnationality",
    "conductor",
    "payername",
    "lsourcetype",
    "lbusinessind",
    "channelref",
    "postingtype",
    "pracaemissao",
    "bancoagencia",
    "sbrecvercorr",
    "swiftfilename",
    "swifttxnid",
    "montranerr",
    "sistafe",
    "achmessageid",
    "achtxnid"
})
public class FUNDSTRANSFERType {

    @XmlElement(name = "TRANSACTIONTYPE")
    protected String transactiontype;
    @XmlElement(name = "DEBITACCTNO")
    protected String debitacctno;
    @XmlElement(name = "INDEBITACCTNO")
    protected String indebitacctno;
    @XmlElement(name = "CURRENCYMKTDR")
    protected String currencymktdr;
    @XmlElement(name = "DEBITCURRENCY")
    protected String debitcurrency;
    @XmlElement(name = "DEBITAMOUNT")
    protected String debitamount;
    @XmlElement(name = "DEBITVALUEDATE")
    protected String debitvaluedate;
    @XmlElement(name = "INDEBITVDATE")
    protected String indebitvdate;
    @XmlElement(name = "DEBITTHEIRREF")
    protected String debittheirref;
    @XmlElement(name = "CREDITTHEIRREF")
    protected String credittheirref;
    @XmlElement(name = "CREDITACCTNO")
    protected String creditacctno;
    @XmlElement(name = "CURRENCYMKTCR")
    protected String currencymktcr;
    @XmlElement(name = "CREDITCURRENCY")
    protected String creditcurrency;
    @XmlElement(name = "CREDITAMOUNT")
    protected String creditamount;
    @XmlElement(name = "CREDITVALUEDATE")
    protected String creditvaluedate;
    @XmlElement(name = "TREASURYRATE")
    protected String treasuryrate;
    @XmlElement(name = "NEGDEALERREFNO")
    protected String negdealerrefno;
    @XmlElement(name = "PROCESSINGDATE")
    protected String processingdate;
    @XmlElement(name = "gORDERINGCUST")
    protected FUNDSTRANSFERType.GORDERINGCUST gorderingcust;
    @XmlElement(name = "gINORDERINGCUS")
    protected FUNDSTRANSFERType.GINORDERINGCUS ginorderingcus;
    @XmlElement(name = "gORDERINGBANK")
    protected FUNDSTRANSFERType.GORDERINGBANK gorderingbank;
    @XmlElement(name = "gINORDERINGBK")
    protected FUNDSTRANSFERType.GINORDERINGBK ginorderingbk;
    @XmlElement(name = "gACCTWITHBANK")
    protected FUNDSTRANSFERType.GACCTWITHBANK gacctwithbank;
    @XmlElement(name = "gACCTWITHBK")
    protected FUNDSTRANSFERType.GACCTWITHBK gacctwithbk;
    @XmlElement(name = "BENACCTNO")
    protected String benacctno;
    @XmlElement(name = "INBENACCTNO")
    protected String inbenacctno;
    @XmlElement(name = "gBENCUSTOMER")
    protected FUNDSTRANSFERType.GBENCUSTOMER gbencustomer;
    @XmlElement(name = "gINBENCUSTOMER")
    protected FUNDSTRANSFERType.GINBENCUSTOMER ginbencustomer;
    @XmlElement(name = "gBENBANK")
    protected FUNDSTRANSFERType.GBENBANK gbenbank;
    @XmlElement(name = "gINBENBANK")
    protected FUNDSTRANSFERType.GINBENBANK ginbenbank;
    @XmlElement(name = "CHEQUENUMBER")
    protected String chequenumber;
    @XmlElement(name = "gPAYMENTDETAILS")
    protected FUNDSTRANSFERType.GPAYMENTDETAILS gpaymentdetails;
    @XmlElement(name = "gINPAYDETAILS")
    protected FUNDSTRANSFERType.GINPAYDETAILS ginpaydetails;
    @XmlElement(name = "BCBANKSORTCODE")
    protected String bcbanksortcode;
    @XmlElement(name = "RECEIVERBANK")
    protected String receiverbank;
    @XmlElement(name = "gRECCORRBANK")
    protected FUNDSTRANSFERType.GRECCORRBANK greccorrbank;
    @XmlElement(name = "gINTERMEDBANK")
    protected FUNDSTRANSFERType.GINTERMEDBANK gintermedbank;
    @XmlElement(name = "gININTMEDBANK")
    protected FUNDSTRANSFERType.GININTMEDBANK ginintmedbank;
    @XmlElement(name = "MAILING")
    protected String mailing;
    @XmlElement(name = "PAYMETHOD")
    protected String paymethod;
    @XmlElement(name = "BENOURCHARGES")
    protected String benourcharges;
    @XmlElement(name = "INBENOURCHARGES")
    protected String inbenourcharges;
    @XmlElement(name = "CHARGESACCTNO")
    protected String chargesacctno;
    @XmlElement(name = "CHARGECOMDISPLAY")
    protected String chargecomdisplay;
    @XmlElement(name = "COMMISSIONCODE")
    protected String commissioncode;
    @XmlElement(name = "gCOMMISSIONTYPE")
    protected FUNDSTRANSFERType.GCOMMISSIONTYPE gcommissiontype;
    @XmlElement(name = "CHARGECODE")
    protected String chargecode;
    @XmlElement(name = "gCHARGETYPE")
    protected FUNDSTRANSFERType.GCHARGETYPE gchargetype;
    @XmlElement(name = "CUSTOMERSPREAD")
    protected String customerspread;
    @XmlElement(name = "BASECURRENCY")
    protected String basecurrency;
    @XmlElement(name = "PROFITCENTRECUST")
    protected String profitcentrecust;
    @XmlElement(name = "PROFITCENTREDEPT")
    protected String profitcentredept;
    @XmlElement(name = "RETURNTODEPT")
    protected String returntodept;
    @XmlElement(name = "PRIORITYTXN")
    protected String prioritytxn;
    @XmlElement(name = "gBKTOBKINFO")
    protected FUNDSTRANSFERType.GBKTOBKINFO gbktobkinfo;
    @XmlElement(name = "gINBKTOBK")
    protected FUNDSTRANSFERType.GINBKTOBK ginbktobk;
    @XmlElement(name = "EXPOSUREDATE")
    protected String exposuredate;
    @XmlElement(name = "FEDFUNDS")
    protected String fedfunds;
    @XmlElement(name = "POSITIONTYPE")
    protected String positiontype;
    @XmlElement(name = "NOOFBATCHITEMS")
    protected String noofbatchitems;
    @XmlElement(name = "gFREETEXTMSGTO")
    protected FUNDSTRANSFERType.GFREETEXTMSGTO gfreetextmsgto;
    @XmlElement(name = "gMESSAGE")
    protected FUNDSTRANSFERType.GMESSAGE gmessage;
    @XmlElement(name = "gTAXTYPE")
    protected FUNDSTRANSFERType.GTAXTYPE gtaxtype;
    @XmlElement(name = "AMOUNTDEBITED")
    protected String amountdebited;
    @XmlElement(name = "AMOUNTCREDITED")
    protected String amountcredited;
    @XmlElement(name = "TOTALCHARGEAMT")
    protected String totalchargeamt;
    @XmlElement(name = "TOTALTAXAMOUNT")
    protected String totaltaxamount;
    @XmlElement(name = "CUSTOMERRATE")
    protected String customerrate;
    @XmlElement(name = "gINRECCORRBK")
    protected FUNDSTRANSFERType.GINRECCORRBK ginreccorrbk;
    @XmlElement(name = "INWARDPAYTYPE")
    protected String inwardpaytype;
    @XmlElement(name = "gINSENDCORRBK")
    protected FUNDSTRANSFERType.GINSENDCORRBK ginsendcorrbk;
    @XmlElement(name = "TELEXFROMCUST")
    protected String telexfromcust;
    @XmlElement(name = "DELIVERYINREF")
    protected String deliveryinref;
    @XmlElement(name = "gDELIVERYOUTREF")
    protected FUNDSTRANSFERType.GDELIVERYOUTREF gdeliveryoutref;
    @XmlElement(name = "CREDITCOMPCODE")
    protected String creditcompcode;
    @XmlElement(name = "DEBITCOMPCODE")
    protected String debitcompcode;
    @XmlElement(name = "STATUS")
    protected String status;
    @XmlElement(name = "DELIVERYMKR")
    protected String deliverymkr;
    @XmlElement(name = "ORDCUSTCODE")
    protected String ordcustcode;
    @XmlElement(name = "ACCTWITHBKACNO")
    protected String acctwithbkacno;
    @XmlElement(name = "LOCAMTDEBITED")
    protected String locamtdebited;
    @XmlElement(name = "LOCAMTCREDITED")
    protected String locamtcredited;
    @XmlElement(name = "LOCTOTTAXAMT")
    protected String loctottaxamt;
    @XmlElement(name = "LOCALCHARGEAMT")
    protected String localchargeamt;
    @XmlElement(name = "LOCPOSCHGSAMT")
    protected String locposchgsamt;
    @XmlElement(name = "MKTGEXCHPROFIT")
    protected String mktgexchprofit;
    @XmlElement(name = "RATEINPUTMKR")
    protected String rateinputmkr;
    @XmlElement(name = "CUSTGROUPLEVEL")
    protected String custgrouplevel;
    @XmlElement(name = "DEBITCUSTOMER")
    protected String debitcustomer;
    @XmlElement(name = "CREDITCUSTOMER")
    protected String creditcustomer;
    @XmlElement(name = "SENDPAYMENTYN")
    protected String sendpaymentyn;
    @XmlElement(name = "DRADVICEREQDYN")
    protected String dradvicereqdyn;
    @XmlElement(name = "CRADVICEREQDYN")
    protected String cradvicereqdyn;
    @XmlElement(name = "DEALMARKET")
    protected String dealmarket;
    @XmlElement(name = "CHARGEDCUSTOMER")
    protected String chargedcustomer;
    @XmlElement(name = "gINREASONOVE")
    protected FUNDSTRANSFERType.GINREASONOVE ginreasonove;
    @XmlElement(name = "DEALERDESK")
    protected String dealerdesk;
    @XmlElement(name = "RECALCFWDRATE")
    protected String recalcfwdrate;
    @XmlElement(name = "RETURNCHEQUE")
    protected String returncheque;
    @XmlElement(name = "DRAWNACCOUNT")
    protected String drawnaccount;
    @XmlElement(name = "ACCOUNTINGDATE")
    protected String accountingdate;
    @XmlElement(name = "gINSTRCTNCODE")
    protected FUNDSTRANSFERType.GINSTRCTNCODE ginstrctncode;
    @XmlElement(name = "COLLREMBK")
    protected String collrembk;
    @XmlElement(name = "EXPECTEDRECSID")
    protected String expectedrecsid;
    @XmlElement(name = "TOTRECCOMM")
    protected String totreccomm;
    @XmlElement(name = "TOTRECCOMMLCL")
    protected String totreccommlcl;
    @XmlElement(name = "TOTRECCHG")
    protected String totrecchg;
    @XmlElement(name = "TOTRECCHGLCL")
    protected String totrecchglcl;
    @XmlElement(name = "CHEQTYPE")
    protected String cheqtype;
    @XmlElement(name = "gRELATEDMSG")
    protected FUNDSTRANSFERType.GRELATEDMSG grelatedmsg;
    @XmlElement(name = "gINTIMEIND")
    protected FUNDSTRANSFERType.GINTIMEIND gintimeind;
    @XmlElement(name = "gSENDTOPARTY")
    protected FUNDSTRANSFERType.GSENDTOPARTY gsendtoparty;
    @XmlElement(name = "REVERSALMKR")
    protected String reversalmkr;
    @XmlElement(name = "RELATEDREF")
    protected String relatedref;
    @XmlElement(name = "gININSTRCODE")
    protected FUNDSTRANSFERType.GININSTRCODE gininstrcode;
    @XmlElement(name = "gINPROCESSERR")
    protected FUNDSTRANSFERType.GINPROCESSERR ginprocesserr;
    @XmlElement(name = "gINSWIFTMSG")
    protected FUNDSTRANSFERType.GINSWIFTMSG ginswiftmsg;
    @XmlElement(name = "ACCTWITHBANKACC")
    protected String acctwithbankacc;
    @XmlElement(name = "INACCTBANKACC")
    protected String inacctbankacc;
    @XmlElement(name = "RECCORRBANKACC")
    protected String reccorrbankacc;
    @XmlElement(name = "INRECCORRACC")
    protected String inreccorracc;
    @XmlElement(name = "INTERMEDBANKACC")
    protected String intermedbankacc;
    @XmlElement(name = "ININTERMEDACC")
    protected String inintermedacc;
    @XmlElement(name = "INSTRUCTEDAMT")
    protected String instructedamt;
    @XmlElement(name = "gININTERMEDBK")
    protected FUNDSTRANSFERType.GININTERMEDBK ginintermedbk;
    @XmlElement(name = "INEXCHRATE")
    protected String inexchrate;
    @XmlElement(name = "RATEFIXING")
    protected String ratefixing;
    @XmlElement(name = "COVERMETHOD")
    protected String covermethod;
    @XmlElement(name = "gIN3RDREIMBBK")
    protected FUNDSTRANSFERType.GIN3RDREIMBBK gin3RDREIMBBK;
    @XmlElement(name = "IN3RDREIMBACC")
    protected String in3RDREIMBACC;
    @XmlElement(name = "MT103TYPE")
    protected String mt103TYPE;
    @XmlElement(name = "EXTENDFORMAT")
    protected String extendformat;
    @XmlElement(name = "gEXTENDINFO")
    protected FUNDSTRANSFERType.GEXTENDINFO gextendinfo;
    @XmlElement(name = "RATEFIXINGIND")
    protected String ratefixingind;
    @XmlElement(name = "INWSENDBIC")
    protected String inwsendbic;
    @XmlElement(name = "gINSENDCHG")
    protected FUNDSTRANSFERType.GINSENDCHG ginsendchg;
    @XmlElement(name = "INRECCHG")
    protected String inrecchg;
    @XmlElement(name = "ACCHGREQID")
    protected String acchgreqid;
    @XmlElement(name = "TOTRECCHGCRCCY")
    protected String totrecchgcrccy;
    @XmlElement(name = "TOTSNDCHGCRCCY")
    protected String totsndchgcrccy;
    @XmlElement(name = "CHGADVICEMSG")
    protected String chgadvicemsg;
    @XmlElement(name = "EXPECTEDCOVERID")
    protected String expectedcoverid;
    @XmlElement(name = "NETTINGSTATUS")
    protected String nettingstatus;
    @XmlElement(name = "AUTHDATE")
    protected String authdate;
    @XmlElement(name = "BKOPERATIONCODE")
    protected String bkoperationcode;
    @XmlElement(name = "AMINFLOWRATE")
    protected String aminflowrate;
    @XmlElement(name = "PARENTTXNID")
    protected String parenttxnid;
    @XmlElement(name = "ROUNDTYPE")
    protected String roundtype;
    @XmlElement(name = "BENEFICIARYID")
    protected String beneficiaryid;
    @XmlElement(name = "gMSGTYPE")
    protected FUNDSTRANSFERType.GMSGTYPE gmsgtype;
    @XmlElement(name = "gSIGNATORY")
    protected FUNDSTRANSFERType.GSIGNATORY gsignatory;
    @XmlElement(name = "CARDNUMBER")
    protected String cardnumber;
    @XmlElement(name = "gCARDTXNDETAIL")
    protected FUNDSTRANSFERType.GCARDTXNDETAIL gcardtxndetail;
    @XmlElement(name = "gINCORDBK")
    protected FUNDSTRANSFERType.GINCORDBK gincordbk;
    @XmlElement(name = "gINCINTMEDBK")
    protected FUNDSTRANSFERType.GINCINTMEDBK gincintmedbk;
    @XmlElement(name = "gINCACCWITBK")
    protected FUNDSTRANSFERType.GINCACCWITBK gincaccwitbk;
    @XmlElement(name = "gINCBKTBKIN")
    protected FUNDSTRANSFERType.GINCBKTBKIN gincbktbkin;
    @XmlElement(name = "TFSREFERENCE")
    protected String tfsreference;
    @XmlElement(name = "CHEQUEDRAWN")
    protected String chequedrawn;
    @XmlElement(name = "ISSUECHEQUETYPE")
    protected String issuechequetype;
    @XmlElement(name = "STOCKNUMBER")
    protected String stocknumber;
    @XmlElement(name = "PAYEENAME")
    protected String payeename;
    @XmlElement(name = "STOCKREGISTER")
    protected String stockregister;
    @XmlElement(name = "SERIESID")
    protected String seriesid;
    @XmlElement(name = "ORDCUSTACCT")
    protected String ordcustacct;
    @XmlElement(name = "INORDCUSTACCT")
    protected String inordcustacct;
    @XmlElement(name = "IBANDEBIT")
    protected String ibandebit;
    @XmlElement(name = "IBANCREDIT")
    protected String ibancredit;
    @XmlElement(name = "IBANBEN")
    protected String ibanben;
    @XmlElement(name = "IBANACCTWITHBANK")
    protected String ibanacctwithbank;
    @XmlElement(name = "IBANRECCORRBANK")
    protected String ibanreccorrbank;
    @XmlElement(name = "IBANINTERMEDBANK")
    protected String ibanintermedbank;
    @XmlElement(name = "IBANORDCUSTACC")
    protected String ibanordcustacc;
    @XmlElement(name = "IBANCHARGESACCT")
    protected String ibanchargesacct;
    @XmlElement(name = "BICIBANBEN")
    protected String bicibanben;
    @XmlElement(name = "gBICIBANBENNAME")
    protected FUNDSTRANSFERType.GBICIBANBENNAME gbicibanbenname;
    @XmlElement(name = "BICIBANBENCITY")
    protected String bicibanbencity;
    @XmlElement(name = "gBENNAME")
    protected FUNDSTRANSFERType.GBENNAME gbenname;
    @XmlElement(name = "gBENADDRESS")
    protected FUNDSTRANSFERType.GBENADDRESS gbenaddress;
    @XmlElement(name = "BENCOUNTRY")
    protected String bencountry;
    @XmlElement(name = "gBENTOWN")
    protected FUNDSTRANSFERType.GBENTOWN gbentown;
    @XmlElement(name = "gINBENNAME")
    protected FUNDSTRANSFERType.GINBENNAME ginbenname;
    @XmlElement(name = "gINBENADDRESS")
    protected FUNDSTRANSFERType.GINBENADDRESS ginbenaddress;
    @XmlElement(name = "INBENCOUNTRY")
    protected String inbencountry;
    @XmlElement(name = "gINBENTOWN")
    protected FUNDSTRANSFERType.GINBENTOWN ginbentown;
    @XmlElement(name = "gREFDATAITEM")
    protected FUNDSTRANSFERType.GREFDATAITEM grefdataitem;
    @XmlElement(name = "gLOCEQUIVCHGS")
    protected FUNDSTRANSFERType.GLOCEQUIVCHGS glocequivchgs;
    @XmlElement(name = "gFOREQUIVCHGS")
    protected FUNDSTRANSFERType.GFOREQUIVCHGS gforequivchgs;
    @XmlElement(name = "REGCOMPLIANCE")
    protected String regcompliance;
    @XmlElement(name = "CBCREDITACCOUNT")
    protected String cbcreditaccount;
    @XmlElement(name = "CBCREDITCCY")
    protected String cbcreditccy;
    @XmlElement(name = "CBDEBITACCOUNT")
    protected String cbdebitaccount;
    @XmlElement(name = "CBDEBITCCY")
    protected String cbdebitccy;
    @XmlElement(name = "TCSIMACCEPTED")
    protected String tcsimaccepted;
    @XmlElement(name = "LASTSIMTIME")
    protected String lastsimtime;
    @XmlElement(name = "INHDR3UETR")
    protected String inhdr3UETR;
    @XmlElement(name = "gSPLITEXPOSUREDATE")
    protected FUNDSTRANSFERType.GSPLITEXPOSUREDATE gsplitexposuredate;
    @XmlElement(name = "AUTHORISATIONID")
    protected String authorisationid;
    @XmlElement(name = "EXEMPTFROMSCA")
    protected String exemptfromsca;
    @XmlElement(name = "STATUSREASONCODE")
    protected String statusreasoncode;
    @XmlElement(name = "RESERVED4")
    protected String reserved4;
    @XmlElement(name = "RESERVED3")
    protected String reserved3;
    @XmlElement(name = "RESERVED2")
    protected String reserved2;
    @XmlElement(name = "RESERVED1")
    protected String reserved1;
    @XmlElement(name = "gSTMTNOS")
    protected FUNDSTRANSFERType.GSTMTNOS gstmtnos;
    @XmlElement(name = "gOVERRIDE")
    protected FUNDSTRANSFERType.GOVERRIDE goverride;
    @XmlElement(name = "RECORDSTATUS")
    protected String recordstatus;
    @XmlElement(name = "CURRNO")
    protected String currno;
    @XmlElement(name = "gINPUTTER")
    protected FUNDSTRANSFERType.GINPUTTER ginputter;
    @XmlElement(name = "gDATETIME")
    protected FUNDSTRANSFERType.GDATETIME gdatetime;
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
    @XmlElement(name = "FOREXCLASS")
    protected String forexclass;
    @XmlElement(name = "UNPAIDCHEQUE")
    protected String unpaidcheque;
    @XmlElement(name = "SBBANKNUMBER")
    protected String sbbanknumber;
    @XmlElement(name = "CCVERSION")
    protected String ccversion;
    @XmlElement(name = "BALCOANAME")
    protected String balcoaname;
    @XmlElement(name = "gBENEFNAME")
    protected FUNDSTRANSFERType.GBENEFNAME gbenefname;
    @XmlElement(name = "BENEFACCT")
    protected String benefacct;
    @XmlElement(name = "ForeignBanks")
    protected String foreignBanks;
    @XmlElement(name = "CountryTable")
    protected String countryTable;
    @XmlElement(name = "INPUTVERSION")
    protected String inputversion;
    @XmlElement(name = "COMMCHARGE")
    protected String commcharge;
    @XmlElement(name = "AUTHVERSION")
    protected String authversion;
    @XmlElement(name = "INTCAT")
    protected String intcat;
    @XmlElement(name = "BoletimRegisto")
    protected String boletimRegisto;
    @XmlElement(name = "FTNO")
    protected String ftno;
    @XmlElement(name = "QtdDocEnv")
    protected String qtdDocEnv;
    @XmlElement(name = "BRANCHNAME")
    protected String branchname;
    @XmlElement(name = "ActualBalance")
    protected String actualBalance;
    @XmlElement(name = "CLEAREDBALANCE")
    protected String clearedbalance;
    @XmlElement(name = "TRANSTYPE")
    protected String transtype;
    @XmlElement(name = "gSENDEDDOCUMENT")
    protected FUNDSTRANSFERType.GSENDEDDOCUMENT gsendeddocument;
    @XmlElement(name = "CONTA2")
    protected String conta2;
    @XmlElement(name = "SIBSCARDNO")
    protected String sibscardno;
    @XmlElement(name = "POINTOFSERVCE")
    protected String pointofservce;
    @XmlElement(name = "ACQINSTITUTE")
    protected String acqinstitute;
    @XmlElement(name = "TERMINALTYPE")
    protected String terminaltype;
    @XmlElement(name = "TERMINALID")
    protected String terminalid;
    @XmlElement(name = "PROCESSINGCODE")
    protected String processingcode;
    @XmlElement(name = "DebitCategory")
    protected String debitCategory;
    @XmlElement(name = "CreditCategory")
    protected String creditCategory;
    @XmlElement(name = "CODAGE2")
    protected String codage2;
    @XmlElement(name = "CARDNUMFULL")
    protected String cardnumfull;
    @XmlElement(name = "IDLOG")
    protected String idlog;
    @XmlElement(name = "NRLOG")
    protected String nrlog;
    @XmlElement(name = "BANKCODE")
    protected String bankcode;
    @XmlElement(name = "TIPOTRANSACCAO")
    protected String tipotransaccao;
    @XmlElement(name = "BRANCHCODE")
    protected String branchcode;
    @XmlElement(name = "BRANCHACCTNO")
    protected String branchacctno;
    @XmlElement(name = "IDPERLOCAL")
    protected String idperlocal;
    @XmlElement(name = "NUMREGLOC")
    protected String numregloc;
    @XmlElement(name = "NRIDRESP")
    protected String nridresp;
    @XmlElement(name = "NRIDRESPO")
    protected String nridrespo;
    @XmlElement(name = "IDLOGO")
    protected String idlogo;
    @XmlElement(name = "NRLOGO")
    protected String nrlogo;
    @XmlElement(name = "DHMSGO")
    protected String dhmsgo;
    @XmlElement(name = "TIPODOC")
    protected String tipodoc;
    @XmlElement(name = "INTERBANKZONE")
    protected String interbankzone;
    @XmlElement(name = "CODINVCORRDR")
    protected String codinvcorrdr;
    @XmlElement(name = "CLEARINGPERIOD")
    protected String clearingperiod;
    @XmlElement(name = "BSTMBMCHQID")
    protected String bstmbmchqid;
    @XmlElement(name = "CUSTACCOUNT")
    protected String custaccount;
    @XmlElement(name = "SERVICEACCOUNT")
    protected String serviceaccount;
    @XmlElement(name = "FTUNPAIDNR")
    protected String ftunpaidnr;
    @XmlElement(name = "IBKPARTYPAY")
    protected String ibkpartypay;
    @XmlElement(name = "FOREIGNCHQNR")
    protected String foreignchqnr;
    @XmlElement(name = "NOMEDOCAIXA")
    protected String nomedocaixa;
    @XmlElement(name = "NRCONTRIBUINTE")
    protected String nrcontribuinte;
    @XmlElement(name = "SEQUENCE")
    protected String sequence;
    @XmlElement(name = "CODINVCORRCR")
    protected String codinvcorrcr;
    @XmlElement(name = "PRAZOPEND")
    protected String prazopend;
    @XmlElement(name = "PRACAAPFISICA")
    protected String pracaapfisica;
    @XmlElement(name = "REFCUTEDB")
    protected String refcutedb;
    @XmlElement(name = "REFCUTECR")
    protected String refcutecr;
    @XmlElement(name = "FULLCONTRTNR")
    protected String fullcontrtnr;
    @XmlElement(name = "INVOICENUMBER")
    protected String invoicenumber;
    @XmlElement(name = "BRANCH")
    protected String branch;
    @XmlElement(name = "CONTRACTNUMBER")
    protected String contractnumber;
    @XmlElement(name = "SEQUENCENUMBER")
    protected String sequencenumber;
    @XmlElement(name = "CHECKDIGIT")
    protected String checkdigit;
    @XmlElement(name = "PRODTYPE")
    protected String prodtype;
    @XmlElement(name = "CIRCUITNR")
    protected String circuitnr;
    @XmlElement(name = "INVOICEDATE")
    protected String invoicedate;
    @XmlElement(name = "IdCard")
    protected String idCard;
    @XmlElement(name = "DOCNo")
    protected String docNo;
    @XmlElement(name = "GIBID")
    protected String gibid;
    @XmlElement(name = "DEFAUXILFEE")
    protected String defauxilfee;
    @XmlElement(name = "SPCAUXILFEE")
    protected String spcauxilfee;
    @XmlElement(name = "NAME")
    protected String name;
    @XmlElement(name = "SBCARDNUMBER")
    protected String sbcardnumber;
    @XmlElement(name = "Adress")
    protected String adress;
    @XmlElement(name = "EMAILADDRESS")
    protected String emailaddress;
    @XmlElement(name = "LOCALIDADE")
    protected String localidade;
    @XmlElement(name = "TELNO")
    protected String telno;
    @XmlElement(name = "ACCOUNT2")
    protected String account2;
    @XmlElement(name = "QTDTITULOS")
    protected String qtdtitulos;
    @XmlElement(name = "Surname")
    protected String surname;
    @XmlElement(name = "CODESTATDR")
    protected String codestatdr;
    @XmlElement(name = "CODESTATCR")
    protected String codestatcr;
    @XmlElement(name = "LINKID")
    protected String linkid;
    @XmlElement(name = "TIPOPAGAMENTO")
    protected String tipopagamento;
    @XmlElement(name = "COCACOLAREL")
    protected String cocacolarel;
    @XmlElement(name = "SEQTRANS")
    protected String seqtrans;
    @XmlElement(name = "NRCOMERCIANTE")
    protected String nrcomerciante;
    @XmlElement(name = "ISOAUTHCD")
    protected String isoauthcd;
    @XmlElement(name = "DATATRANS")
    protected String datatrans;
    @XmlElement(name = "HORATRANS")
    protected String horatrans;
    @XmlElement(name = "NRCARTAO")
    protected String nrcartao;
    @XmlElement(name = "PAISTRANS")
    protected String paistrans;
    @XmlElement(name = "PAISCARTAO")
    protected String paiscartao;
    @XmlElement(name = "ISOACCNME")
    protected String isoaccnme;
    @XmlElement(name = "ISOCURRCD")
    protected String isocurrcd;
    @XmlElement(name = "ISOTRANAMT")
    protected String isotranamt;
    @XmlElement(name = "ISOCONVRT")
    protected String isoconvrt;
    @XmlElement(name = "ISOCBAMTBIL")
    protected String isocbamtbil;
    @XmlElement(name = "ISOCBAMTDEV")
    protected String isocbamtdev;
    @XmlElement(name = "ISOCBAMTACT")
    protected String isocbamtact;
    @XmlElement(name = "ISOSTLCURR")
    protected String isostlcurr;
    @XmlElement(name = "ISOSTLAMT")
    protected String isostlamt;
    @XmlElement(name = "ISOSTLCONV")
    protected String isostlconv;
    @XmlElement(name = "ISOACTBAL")
    protected String isoactbal;
    @XmlElement(name = "ISOAVAILBAL")
    protected String isoavailbal;
    @XmlElement(name = "ISOPRN")
    protected String isoprn;
    @XmlElement(name = "ISOSTAN")
    protected String isostan;
    @XmlElement(name = "ISOTXNTYPE")
    protected String isotxntype;
    @XmlElement(name = "ISOTERMTYPE")
    protected String isotermtype;
    @XmlElement(name = "ISOTERMID")
    protected String isotermid;
    @XmlElement(name = "ACQIMD")
    protected String acqimd;
    @XmlElement(name = "ISOCONTRYCODE")
    protected String isocontrycode;
    @XmlElement(name = "CONTRIBUICOES")
    protected String contribuicoes;
    @XmlElement(name = "MULTA")
    protected String multa;
    @XmlElement(name = "JUROSMORA")
    protected String jurosmora;
    @XmlElement(name = "ADICIONAIS")
    protected String adicionais;
    @XmlElement(name = "INSSREL")
    protected String inssrel;
    @XmlElement(name = "LOCKEVENTID")
    protected String lockeventid;
    @XmlElement(name = "DATE")
    protected String date;
    @XmlElement(name = "DEPOSITOR")
    protected String depositor;
    @XmlElement(name = "ORDERDATE")
    protected String orderdate;
    @XmlElement(name = "gBTBFOURHUNDRED")
    protected FUNDSTRANSFERType.GBTBFOURHUNDRED gbtbfourhundred;
    @XmlElement(name = "ORDERNIB")
    protected String ordernib;
    @XmlElement(name = "FLAGNIB")
    protected String flagnib;
    @XmlElement(name = "IBAN")
    protected String iban;
    @XmlElement(name = "BENEFNIB")
    protected String benefnib;
    @XmlElement(name = "gWORDAMT")
    protected FUNDSTRANSFERType.GWORDAMT gwordamt;
    @XmlElement(name = "BMCORRESPORIG")
    protected String bmcorresporig;
    @XmlElement(name = "BMCORRESPDEST")
    protected String bmcorrespdest;
    @XmlElement(name = "SBCLOSEDATE")
    protected String sbclosedate;
    @XmlElement(name = "SBOPENDATE")
    protected String sbopendate;
    @XmlElement(name = "SBVATNUMBER")
    protected String sbvatnumber;
    @XmlElement(name = "SBASSETTYPE")
    protected String sbassettype;
    @XmlElement(name = "SBTAXTYPE")
    protected String sbtaxtype;
    @XmlElement(name = "NRNUIT")
    protected String nrnuit;
    @XmlElement(name = "CONFIRMATION")
    protected String confirmation;
    @XmlElement(name = "BENEFNUIT")
    protected String benefnuit;
    @XmlElement(name = "BENEFIBAN")
    protected String benefiban;
    @XmlElement(name = "DBACCTNAME")
    protected String dbacctname;
    @XmlElement(name = "CRACCTNAME")
    protected String cracctname;
    @XmlElement(name = "MSGID")
    protected String msgid;
    @XmlElement(name = "CRDIMD")
    protected String crdimd;
    @XmlElement(name = "CRDBRCODE")
    protected String crdbrcode;
    @XmlElement(name = "CRDNUMBER")
    protected String crdnumber;
    @XmlElement(name = "REFERENCE")
    protected String reference;
    @XmlElement(name = "NRCARREGAMENTO")
    protected String nrcarregamento;
    @XmlElement(name = "STICKETNUMBER")
    protected String sticketnumber;
    @XmlElement(name = "REFERENCIA")
    protected String referencia;
    @XmlElement(name = "TRACENO")
    protected String traceno;
    @XmlElement(name = "BATCHID")
    protected String batchid;
    @XmlElement(name = "BATCHITEMID")
    protected String batchitemid;
    @XmlElement(name = "ISENTOCOMISSAO")
    protected String isentocomissao;
    @XmlElement(name = "FONTEFINANCTO")
    protected String fontefinancto;
    @XmlElement(name = "REPAYMENTACCT")
    protected String repaymentacct;
    @XmlElement(name = "NRSOLICITACAO")
    protected String nrsolicitacao;
    @XmlElement(name = "gSBTOWNCOUNTRY")
    protected FUNDSTRANSFERType.GSBTOWNCOUNTRY gsbtowncountry;
    @XmlElement(name = "CODMSG")
    protected String codmsg;
    @XmlElement(name = "VERMSG")
    protected String vermsg;
    @XmlElement(name = "TIPOTERM")
    protected String tipoterm;
    @XmlElement(name = "DHMSG")
    protected String dhmsg;
    @XmlElement(name = "TIPOAUT")
    protected String tipoaut;
    @XmlElement(name = "IDTERMINAL")
    protected String idterminal;
    @XmlElement(name = "LOCTERM")
    protected String locterm;
    @XmlElement(name = "PVV2")
    protected String pvv2;
    @XmlElement(name = "PVV3")
    protected String pvv3;
    @XmlElement(name = "IDACEITANTE")
    protected String idaceitante;
    @XmlElement(name = "MONTIND")
    protected String montind;
    @XmlElement(name = "IDPROP")
    protected String idprop;
    @XmlElement(name = "RETREF")
    protected String retref;
    @XmlElement(name = "NATOPER")
    protected String natoper;
    @XmlElement(name = "DTHORA")
    protected String dthora;
    @XmlElement(name = "SEQMOV")
    protected String seqmov;
    @XmlElement(name = "DATEXP")
    protected String datexp;
    @XmlElement(name = "SEQPAN")
    protected String seqpan;
    @XmlElement(name = "CONTA")
    protected String conta;
    @XmlElement(name = "NOMECLI")
    protected String nomecli;
    @XmlElement(name = "NSITCAR")
    protected String nsitcar;
    @XmlElement(name = "MODINS")
    protected String modins;
    @XmlElement(name = "MCC")
    protected String mcc;
    @XmlElement(name = "DISTCONC")
    protected String distconc;
    @XmlElement(name = "MOTCAPT")
    protected String motcapt;
    @XmlElement(name = "SENHA")
    protected String senha;
    @XmlElement(name = "REFDEP")
    protected String refdep;
    @XmlElement(name = "SISTAG")
    protected String sistag;
    @XmlElement(name = "CODPAIS")
    protected String codpais;
    @XmlElement(name = "CODMOEDA")
    protected String codmoeda;
    @XmlElement(name = "CAMBIO")
    protected String cambio;
    @XmlElement(name = "IMPORTOP")
    protected String importop;
    @XmlElement(name = "VALTOTAL")
    protected String valtotal;
    @XmlElement(name = "BANAPOIO")
    protected String banapoio;
    @XmlElement(name = "REFPAG")
    protected String refpag;
    @XmlElement(name = "DESCSE")
    protected String descse;
    @XmlElement(name = "TIPSER")
    protected String tipser;
    @XmlElement(name = "NIBDEST")
    protected String nibdest;
    @XmlElement(name = "SINAL")
    protected String sinal;
    @XmlElement(name = "IDCOMEMP")
    protected String idcomemp;
    @XmlElement(name = "IDEST")
    protected String idest;
    @XmlElement(name = "PRODFIN")
    protected String prodfin;
    @XmlElement(name = "ENTIDADE")
    protected String entidade;
    @XmlElement(name = "NIBORD")
    protected String nibord;
    @XmlElement(name = "CREDDEST")
    protected String creddest;
    @XmlElement(name = "CODTRNE")
    protected String codtrne;
    @XmlElement(name = "PINBLOCK")
    protected String pinblock;
    @XmlElement(name = "EXPP2")
    protected String expp2;
    @XmlElement(name = "COMPP2")
    protected String compp2;
    @XmlElement(name = "PISTA2")
    protected String pista2;
    @XmlElement(name = "DTINIAPLIC")
    protected String dtiniaplic;
    @XmlElement(name = "CARTERM")
    protected String carterm;
    @XmlElement(name = "CAPTERMACQ")
    protected String captermacq;
    @XmlElement(name = "APPCOUNTER")
    protected String appcounter;
    @XmlElement(name = "APPPROFILE")
    protected String appprofile;
    @XmlElement(name = "TIPOCRIP")
    protected String tipocrip;
    @XmlElement(name = "CRIPTOGRAMA")
    protected String criptograma;
    @XmlElement(name = "ISSAPDATA")
    protected String issapdata;
    @XmlElement(name = "TVR")
    protected String tvr;
    @XmlElement(name = "NRSEQPAN")
    protected String nrseqpan;
    @XmlElement(name = "IDCOMREP")
    protected String idcomrep;
    @XmlElement(name = "CRIPTINF")
    protected String criptinf;
    @XmlElement(name = "CVMRESULTS")
    protected String cvmresults;
    @XmlElement(name = "DFNAME")
    protected String dfname;
    @XmlElement(name = "APLICN")
    protected String aplicn;
    @XmlElement(name = "EMVPADRAO")
    protected String emvpadrao;
    @XmlElement(name = "FIDELIZACAOID")
    protected String fidelizacaoid;
    @XmlElement(name = "INDTIPPAG")
    protected String indtippag;
    @XmlElement(name = "CREPRESTCLI")
    protected String creprestcli;
    @XmlElement(name = "FIDPONTOSREB")
    protected String fidpontosreb;
    @XmlElement(name = "FIDPONTOSDIS")
    protected String fidpontosdis;
    @XmlElement(name = "FIDVALORPONT")
    protected String fidvalorpont;
    @XmlElement(name = "FIDVALORREM")
    protected String fidvalorrem;
    @XmlElement(name = "COMPPAN")
    protected String comppan;
    @XmlElement(name = "PAN")
    protected String pan;
    @XmlElement(name = "MNTE")
    protected String mnte;
    @XmlElement(name = "MNTADI")
    protected String mntadi;
    @XmlElement(name = "TOTOPERE")
    protected String totopere;
    @XmlElement(name = "COMPDADOSV")
    protected String compdadosv;
    @XmlElement(name = "VERDADOSV")
    protected String verdadosv;
    @XmlElement(name = "CAPTERM")
    protected String capterm;
    @XmlElement(name = "UNPNR")
    protected String unpnr;
    @XmlElement(name = "APLICPDD")
    protected String aplicpdd;
    @XmlElement(name = "COMEMI1")
    protected String comemi1;
    @XmlElement(name = "COMEMI2")
    protected String comemi2;
    @XmlElement(name = "COMPROP1")
    protected String comprop1;
    @XmlElement(name = "COMPROP2")
    protected String comprop2;
    @XmlElement(name = "MONTANTE1")
    protected String montante1;
    @XmlElement(name = "MONTANTE2")
    protected String montante2;
    @XmlElement(name = "TAXACLI1")
    protected String taxacli1;
    @XmlElement(name = "TAXACLI2")
    protected String taxacli2;
    @XmlElement(name = "PGTOANTECIPADO")
    protected String pgtoantecipado;
    @XmlElement(name = "SALOPERATOR")
    protected String saloperator;
    @XmlElement(name = "SBTRRATEREF")
    protected String sbtrrateref;
    @XmlElement(name = "SBCHANNEL")
    protected String sbchannel;
    @XmlElement(name = "ORIGORDERACCT")
    protected String origorderacct;
    @XmlElement(name = "WFINPUTTER")
    protected String wfinputter;
    @XmlElement(name = "WFAUTHORISER")
    protected String wfauthoriser;
    @XmlElement(name = "WFID")
    protected String wfid;
    @XmlElement(name = "CALYPLOGREF")
    protected String calyplogref;
    @XmlElement(name = "CALYPSOCUSNAME")
    protected String calypsocusname;
    @XmlElement(name = "DEBITACNAME")
    protected String debitacname;
    @XmlElement(name = "NBOLORDERREF")
    protected String nbolorderref;
    @XmlElement(name = "NBOLACTREF")
    protected String nbolactref;
    @XmlElement(name = "NBOLPARENTTXN")
    protected String nbolparenttxn;
    @XmlElement(name = "DRBANKBIC")
    protected String drbankbic;
    @XmlElement(name = "CRBANKBIC")
    protected String crbankbic;
    @XmlElement(name = "DRBANKSCODE")
    protected String drbankscode;
    @XmlElement(name = "CRBANKSCODE")
    protected String crbankscode;
    @XmlElement(name = "DESTACCTNO")
    protected String destacctno;
    @XmlElement(name = "TOTALCRCNT")
    protected String totalcrcnt;
    @XmlElement(name = "TOTLONUSDRAMT")
    protected String totlonusdramt;
    @XmlElement(name = "TOTLOFUSDRAMT")
    protected String totlofusdramt;
    @XmlElement(name = "ONUSCRCNT")
    protected String onuscrcnt;
    @XmlElement(name = "OFFUSCRCNT")
    protected String offuscrcnt;
    @XmlElement(name = "UNIQUEMSGID")
    protected String uniquemsgid;
    @XmlElement(name = "PAYEXMSGID")
    protected String payexmsgid;
    @XmlElement(name = "CODDISTRICT")
    protected String coddistrict;
    @XmlElement(name = "CODREVENUE")
    protected String codrevenue;
    @XmlElement(name = "CODCONSMUNI")
    protected String codconsmuni;
    @XmlElement(name = "gSBORDCUSADDR")
    protected FUNDSTRANSFERType.GSBORDCUSADDR gsbordcusaddr;
    @XmlElement(name = "STOTALTAXAMT")
    protected String stotaltaxamt;
    @XmlElement(name = "TAXAMT2")
    protected String taxamt2;
    @XmlElement(name = "NETTXNID")
    protected String nettxnid;
    @XmlElement(name = "REQUESTDATE")
    protected String requestdate;
    @XmlElement(name = "NETUSERNAME")
    protected String netusername;
    @XmlElement(name = "IBKTXNID")
    protected String ibktxnid;
    @XmlElement(name = "IDTYPE")
    protected String idtype;
    @XmlElement(name = "SBIDNUMBER")
    protected String sbidnumber;
    @XmlElement(name = "CUSIDENTITY")
    protected String cusidentity;
    @XmlElement(name = "CDMTRANSREF")
    protected String cdmtransref;
    @XmlElement(name = "ADCNUMBER")
    protected String adcnumber;
    @XmlElement(name = "INMSGREF")
    protected String inmsgref;
    @XmlElement(name = "SBUETRID")
    protected String sbuetrid;
    @XmlElement(name = "ORIGINFUNDS")
    protected String originfunds;
    @XmlElement(name = "DESTINATION")
    protected String destination;
    @XmlElement(name = "USDEQUIV")
    protected String usdequiv;
    @XmlElement(name = "STARTDATE")
    protected String startdate;
    @XmlElement(name = "DUEDATE")
    protected String duedate;
    @XmlElement(name = "ENDDATE")
    protected String enddate;
    @XmlElement(name = "ORIGINWAIVE")
    protected String originwaive;
    @XmlElement(name = "DOCSUPME")
    protected String docsupme;
    @XmlElement(name = "SBAV10EXCEP")
    protected String sbav10EXCEP;
    @XmlElement(name = "BSTMCOUNTRY")
    protected String bstmcountry;
    @XmlElement(name = "SBTIPOINVEST")
    protected String sbtipoinvest;
    @XmlElement(name = "SBPAISINVEST")
    protected String sbpaisinvest;
    @XmlElement(name = "PERCENTACCOES")
    protected String percentaccoes;
    @XmlElement(name = "VALORACCOES")
    protected String valoraccoes;
    @XmlElement(name = "MGRAMGRAUP")
    protected String mgramgraup;
    @XmlElement(name = "MGRAMTXNR")
    protected String mgramtxnr;
    @XmlElement(name = "ACCCURRENCY")
    protected String acccurrency;
    @XmlElement(name = "DEALTCKBENEF")
    protected String dealtckbenef;
    @XmlElement(name = "TREASURYRBENEF")
    protected String treasuryrbenef;
    @XmlElement(name = "CHGACCOUNT")
    protected String chgaccount;
    @XmlElement(name = "EXCHANGEVALUE")
    protected String exchangevalue;
    @XmlElement(name = "CONVCCYVALUE")
    protected String convccyvalue;
    @XmlElement(name = "SBDATEISSUE")
    protected String sbdateissue;
    @XmlElement(name = "CTYOFISSUE")
    protected String ctyofissue;
    @XmlElement(name = "SBEXPIRYDATE")
    protected String sbexpirydate;
    @XmlElement(name = "AuthCode")
    protected String authCode;
    @XmlElement(name = "gSBCHARGECODE")
    protected FUNDSTRANSFERType.GSBCHARGECODE gsbchargecode;
    @XmlElement(name = "SBBUYRATE")
    protected String sbbuyrate;
    @XmlElement(name = "SBSELLRATE")
    protected String sbsellrate;
    @XmlElement(name = "CROSSDEALRATE")
    protected String crossdealrate;
    @XmlElement(name = "TTSPECCOND")
    protected String ttspeccond;
    @XmlElement(name = "TTSPECCONDS")
    protected String ttspecconds;
    @XmlElement(name = "BSTMTRFREF")
    protected String bstmtrfref;
    @XmlElement(name = "NOTASCODEOT")
    protected String notascodeot;
    @XmlElement(name = "NOTUSED")
    protected String notused;
    @XmlElement(name = "IdExpiryDate")
    protected String idExpiryDate;
    @XmlElement(name = "NRCLIENTE")
    protected String nrcliente;
    @XmlElement(name = "PROVEDOR")
    protected String provedor;
    @XmlElement(name = "SBLOCALAMT")
    protected String sblocalamt;
    @XmlElement(name = "MASSVALORDIFF")
    protected String massvalordiff;
    @XmlElement(name = "EMPLADDRESS")
    protected String empladdress;
    @XmlElement(name = "MOTIVOOP")
    protected String motivoop;
    @XmlElement(name = "SEXO")
    protected String sexo;
    @XmlElement(name = "SEX")
    protected String sex;
    @XmlElement(name = "ISSUECOUNTRY")
    protected String issuecountry;
    @XmlElement(name = "DEPNATIONALITY")
    protected String depnationality;
    @XmlElement(name = "CONDUCTOR")
    protected String conductor;
    @XmlElement(name = "PAYERNAME")
    protected String payername;
    @XmlElement(name = "LSOURCETYPE")
    protected String lsourcetype;
    @XmlElement(name = "LBUSINESSIND")
    protected String lbusinessind;
    @XmlElement(name = "CHANNELREF")
    protected String channelref;
    @XmlElement(name = "POSTINGTYPE")
    protected String postingtype;
    @XmlElement(name = "PRACAEMISSAO")
    protected String pracaemissao;
    @XmlElement(name = "BANCOAGENCIA")
    protected String bancoagencia;
    @XmlElement(name = "SBRECVERCORR")
    protected String sbrecvercorr;
    @XmlElement(name = "SWIFTFILENAME")
    protected String swiftfilename;
    @XmlElement(name = "SWIFTTXNID")
    protected String swifttxnid;
    @XmlElement(name = "MONTRANERR")
    protected String montranerr;
    @XmlElement(name = "SISTAFE")
    protected String sistafe;
    @XmlElement(name = "ACHMESSAGEID")
    protected String achmessageid;
    @XmlElement(name = "ACHTXNID")
    protected String achtxnid;
    @XmlAttribute(name = "id")
    protected String id;

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
     * Gets the value of the indebitacctno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINDEBITACCTNO() {
        return indebitacctno;
    }

    /**
     * Sets the value of the indebitacctno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINDEBITACCTNO(String value) {
        this.indebitacctno = value;
    }

    /**
     * Gets the value of the currencymktdr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCURRENCYMKTDR() {
        return currencymktdr;
    }

    /**
     * Sets the value of the currencymktdr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCURRENCYMKTDR(String value) {
        this.currencymktdr = value;
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
     * Gets the value of the debitvaluedate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDEBITVALUEDATE() {
        return debitvaluedate;
    }

    /**
     * Sets the value of the debitvaluedate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDEBITVALUEDATE(String value) {
        this.debitvaluedate = value;
    }

    /**
     * Gets the value of the indebitvdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINDEBITVDATE() {
        return indebitvdate;
    }

    /**
     * Sets the value of the indebitvdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINDEBITVDATE(String value) {
        this.indebitvdate = value;
    }

    /**
     * Gets the value of the debittheirref property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDEBITTHEIRREF() {
        return debittheirref;
    }

    /**
     * Sets the value of the debittheirref property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDEBITTHEIRREF(String value) {
        this.debittheirref = value;
    }

    /**
     * Gets the value of the credittheirref property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCREDITTHEIRREF() {
        return credittheirref;
    }

    /**
     * Sets the value of the credittheirref property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCREDITTHEIRREF(String value) {
        this.credittheirref = value;
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
     * Gets the value of the currencymktcr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCURRENCYMKTCR() {
        return currencymktcr;
    }

    /**
     * Sets the value of the currencymktcr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCURRENCYMKTCR(String value) {
        this.currencymktcr = value;
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
     * Gets the value of the creditvaluedate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCREDITVALUEDATE() {
        return creditvaluedate;
    }

    /**
     * Sets the value of the creditvaluedate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCREDITVALUEDATE(String value) {
        this.creditvaluedate = value;
    }

    /**
     * Gets the value of the treasuryrate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTREASURYRATE() {
        return treasuryrate;
    }

    /**
     * Sets the value of the treasuryrate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTREASURYRATE(String value) {
        this.treasuryrate = value;
    }

    /**
     * Gets the value of the negdealerrefno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNEGDEALERREFNO() {
        return negdealerrefno;
    }

    /**
     * Sets the value of the negdealerrefno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNEGDEALERREFNO(String value) {
        this.negdealerrefno = value;
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
     * Gets the value of the gorderingcust property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GORDERINGCUST }
     *     
     */
    public FUNDSTRANSFERType.GORDERINGCUST getGORDERINGCUST() {
        return gorderingcust;
    }

    /**
     * Sets the value of the gorderingcust property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GORDERINGCUST }
     *     
     */
    public void setGORDERINGCUST(FUNDSTRANSFERType.GORDERINGCUST value) {
        this.gorderingcust = value;
    }

    /**
     * Gets the value of the ginorderingcus property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GINORDERINGCUS }
     *     
     */
    public FUNDSTRANSFERType.GINORDERINGCUS getGINORDERINGCUS() {
        return ginorderingcus;
    }

    /**
     * Sets the value of the ginorderingcus property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GINORDERINGCUS }
     *     
     */
    public void setGINORDERINGCUS(FUNDSTRANSFERType.GINORDERINGCUS value) {
        this.ginorderingcus = value;
    }

    /**
     * Gets the value of the gorderingbank property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GORDERINGBANK }
     *     
     */
    public FUNDSTRANSFERType.GORDERINGBANK getGORDERINGBANK() {
        return gorderingbank;
    }

    /**
     * Sets the value of the gorderingbank property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GORDERINGBANK }
     *     
     */
    public void setGORDERINGBANK(FUNDSTRANSFERType.GORDERINGBANK value) {
        this.gorderingbank = value;
    }

    /**
     * Gets the value of the ginorderingbk property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GINORDERINGBK }
     *     
     */
    public FUNDSTRANSFERType.GINORDERINGBK getGINORDERINGBK() {
        return ginorderingbk;
    }

    /**
     * Sets the value of the ginorderingbk property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GINORDERINGBK }
     *     
     */
    public void setGINORDERINGBK(FUNDSTRANSFERType.GINORDERINGBK value) {
        this.ginorderingbk = value;
    }

    /**
     * Gets the value of the gacctwithbank property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GACCTWITHBANK }
     *     
     */
    public FUNDSTRANSFERType.GACCTWITHBANK getGACCTWITHBANK() {
        return gacctwithbank;
    }

    /**
     * Sets the value of the gacctwithbank property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GACCTWITHBANK }
     *     
     */
    public void setGACCTWITHBANK(FUNDSTRANSFERType.GACCTWITHBANK value) {
        this.gacctwithbank = value;
    }

    /**
     * Gets the value of the gacctwithbk property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GACCTWITHBK }
     *     
     */
    public FUNDSTRANSFERType.GACCTWITHBK getGACCTWITHBK() {
        return gacctwithbk;
    }

    /**
     * Sets the value of the gacctwithbk property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GACCTWITHBK }
     *     
     */
    public void setGACCTWITHBK(FUNDSTRANSFERType.GACCTWITHBK value) {
        this.gacctwithbk = value;
    }

    /**
     * Gets the value of the benacctno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBENACCTNO() {
        return benacctno;
    }

    /**
     * Sets the value of the benacctno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBENACCTNO(String value) {
        this.benacctno = value;
    }

    /**
     * Gets the value of the inbenacctno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINBENACCTNO() {
        return inbenacctno;
    }

    /**
     * Sets the value of the inbenacctno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINBENACCTNO(String value) {
        this.inbenacctno = value;
    }

    /**
     * Gets the value of the gbencustomer property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GBENCUSTOMER }
     *     
     */
    public FUNDSTRANSFERType.GBENCUSTOMER getGBENCUSTOMER() {
        return gbencustomer;
    }

    /**
     * Sets the value of the gbencustomer property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GBENCUSTOMER }
     *     
     */
    public void setGBENCUSTOMER(FUNDSTRANSFERType.GBENCUSTOMER value) {
        this.gbencustomer = value;
    }

    /**
     * Gets the value of the ginbencustomer property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GINBENCUSTOMER }
     *     
     */
    public FUNDSTRANSFERType.GINBENCUSTOMER getGINBENCUSTOMER() {
        return ginbencustomer;
    }

    /**
     * Sets the value of the ginbencustomer property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GINBENCUSTOMER }
     *     
     */
    public void setGINBENCUSTOMER(FUNDSTRANSFERType.GINBENCUSTOMER value) {
        this.ginbencustomer = value;
    }

    /**
     * Gets the value of the gbenbank property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GBENBANK }
     *     
     */
    public FUNDSTRANSFERType.GBENBANK getGBENBANK() {
        return gbenbank;
    }

    /**
     * Sets the value of the gbenbank property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GBENBANK }
     *     
     */
    public void setGBENBANK(FUNDSTRANSFERType.GBENBANK value) {
        this.gbenbank = value;
    }

    /**
     * Gets the value of the ginbenbank property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GINBENBANK }
     *     
     */
    public FUNDSTRANSFERType.GINBENBANK getGINBENBANK() {
        return ginbenbank;
    }

    /**
     * Sets the value of the ginbenbank property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GINBENBANK }
     *     
     */
    public void setGINBENBANK(FUNDSTRANSFERType.GINBENBANK value) {
        this.ginbenbank = value;
    }

    /**
     * Gets the value of the chequenumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCHEQUENUMBER() {
        return chequenumber;
    }

    /**
     * Sets the value of the chequenumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCHEQUENUMBER(String value) {
        this.chequenumber = value;
    }

    /**
     * Gets the value of the gpaymentdetails property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GPAYMENTDETAILS }
     *     
     */
    public FUNDSTRANSFERType.GPAYMENTDETAILS getGPAYMENTDETAILS() {
        return gpaymentdetails;
    }

    /**
     * Sets the value of the gpaymentdetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GPAYMENTDETAILS }
     *     
     */
    public void setGPAYMENTDETAILS(FUNDSTRANSFERType.GPAYMENTDETAILS value) {
        this.gpaymentdetails = value;
    }

    /**
     * Gets the value of the ginpaydetails property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GINPAYDETAILS }
     *     
     */
    public FUNDSTRANSFERType.GINPAYDETAILS getGINPAYDETAILS() {
        return ginpaydetails;
    }

    /**
     * Sets the value of the ginpaydetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GINPAYDETAILS }
     *     
     */
    public void setGINPAYDETAILS(FUNDSTRANSFERType.GINPAYDETAILS value) {
        this.ginpaydetails = value;
    }

    /**
     * Gets the value of the bcbanksortcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBCBANKSORTCODE() {
        return bcbanksortcode;
    }

    /**
     * Sets the value of the bcbanksortcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBCBANKSORTCODE(String value) {
        this.bcbanksortcode = value;
    }

    /**
     * Gets the value of the receiverbank property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRECEIVERBANK() {
        return receiverbank;
    }

    /**
     * Sets the value of the receiverbank property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRECEIVERBANK(String value) {
        this.receiverbank = value;
    }

    /**
     * Gets the value of the greccorrbank property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GRECCORRBANK }
     *     
     */
    public FUNDSTRANSFERType.GRECCORRBANK getGRECCORRBANK() {
        return greccorrbank;
    }

    /**
     * Sets the value of the greccorrbank property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GRECCORRBANK }
     *     
     */
    public void setGRECCORRBANK(FUNDSTRANSFERType.GRECCORRBANK value) {
        this.greccorrbank = value;
    }

    /**
     * Gets the value of the gintermedbank property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GINTERMEDBANK }
     *     
     */
    public FUNDSTRANSFERType.GINTERMEDBANK getGINTERMEDBANK() {
        return gintermedbank;
    }

    /**
     * Sets the value of the gintermedbank property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GINTERMEDBANK }
     *     
     */
    public void setGINTERMEDBANK(FUNDSTRANSFERType.GINTERMEDBANK value) {
        this.gintermedbank = value;
    }

    /**
     * Gets the value of the ginintmedbank property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GININTMEDBANK }
     *     
     */
    public FUNDSTRANSFERType.GININTMEDBANK getGININTMEDBANK() {
        return ginintmedbank;
    }

    /**
     * Sets the value of the ginintmedbank property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GININTMEDBANK }
     *     
     */
    public void setGININTMEDBANK(FUNDSTRANSFERType.GININTMEDBANK value) {
        this.ginintmedbank = value;
    }

    /**
     * Gets the value of the mailing property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMAILING() {
        return mailing;
    }

    /**
     * Sets the value of the mailing property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMAILING(String value) {
        this.mailing = value;
    }

    /**
     * Gets the value of the paymethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAYMETHOD() {
        return paymethod;
    }

    /**
     * Sets the value of the paymethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAYMETHOD(String value) {
        this.paymethod = value;
    }

    /**
     * Gets the value of the benourcharges property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBENOURCHARGES() {
        return benourcharges;
    }

    /**
     * Sets the value of the benourcharges property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBENOURCHARGES(String value) {
        this.benourcharges = value;
    }

    /**
     * Gets the value of the inbenourcharges property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINBENOURCHARGES() {
        return inbenourcharges;
    }

    /**
     * Sets the value of the inbenourcharges property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINBENOURCHARGES(String value) {
        this.inbenourcharges = value;
    }

    /**
     * Gets the value of the chargesacctno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCHARGESACCTNO() {
        return chargesacctno;
    }

    /**
     * Sets the value of the chargesacctno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCHARGESACCTNO(String value) {
        this.chargesacctno = value;
    }

    /**
     * Gets the value of the chargecomdisplay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCHARGECOMDISPLAY() {
        return chargecomdisplay;
    }

    /**
     * Sets the value of the chargecomdisplay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCHARGECOMDISPLAY(String value) {
        this.chargecomdisplay = value;
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
     * Gets the value of the gcommissiontype property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GCOMMISSIONTYPE }
     *     
     */
    public FUNDSTRANSFERType.GCOMMISSIONTYPE getGCOMMISSIONTYPE() {
        return gcommissiontype;
    }

    /**
     * Sets the value of the gcommissiontype property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GCOMMISSIONTYPE }
     *     
     */
    public void setGCOMMISSIONTYPE(FUNDSTRANSFERType.GCOMMISSIONTYPE value) {
        this.gcommissiontype = value;
    }

    /**
     * Gets the value of the chargecode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCHARGECODE() {
        return chargecode;
    }

    /**
     * Sets the value of the chargecode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCHARGECODE(String value) {
        this.chargecode = value;
    }

    /**
     * Gets the value of the gchargetype property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GCHARGETYPE }
     *     
     */
    public FUNDSTRANSFERType.GCHARGETYPE getGCHARGETYPE() {
        return gchargetype;
    }

    /**
     * Sets the value of the gchargetype property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GCHARGETYPE }
     *     
     */
    public void setGCHARGETYPE(FUNDSTRANSFERType.GCHARGETYPE value) {
        this.gchargetype = value;
    }

    /**
     * Gets the value of the customerspread property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCUSTOMERSPREAD() {
        return customerspread;
    }

    /**
     * Sets the value of the customerspread property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCUSTOMERSPREAD(String value) {
        this.customerspread = value;
    }

    /**
     * Gets the value of the basecurrency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBASECURRENCY() {
        return basecurrency;
    }

    /**
     * Sets the value of the basecurrency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBASECURRENCY(String value) {
        this.basecurrency = value;
    }

    /**
     * Gets the value of the profitcentrecust property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPROFITCENTRECUST() {
        return profitcentrecust;
    }

    /**
     * Sets the value of the profitcentrecust property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPROFITCENTRECUST(String value) {
        this.profitcentrecust = value;
    }

    /**
     * Gets the value of the profitcentredept property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPROFITCENTREDEPT() {
        return profitcentredept;
    }

    /**
     * Sets the value of the profitcentredept property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPROFITCENTREDEPT(String value) {
        this.profitcentredept = value;
    }

    /**
     * Gets the value of the returntodept property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRETURNTODEPT() {
        return returntodept;
    }

    /**
     * Sets the value of the returntodept property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRETURNTODEPT(String value) {
        this.returntodept = value;
    }

    /**
     * Gets the value of the prioritytxn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRIORITYTXN() {
        return prioritytxn;
    }

    /**
     * Sets the value of the prioritytxn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRIORITYTXN(String value) {
        this.prioritytxn = value;
    }

    /**
     * Gets the value of the gbktobkinfo property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GBKTOBKINFO }
     *     
     */
    public FUNDSTRANSFERType.GBKTOBKINFO getGBKTOBKINFO() {
        return gbktobkinfo;
    }

    /**
     * Sets the value of the gbktobkinfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GBKTOBKINFO }
     *     
     */
    public void setGBKTOBKINFO(FUNDSTRANSFERType.GBKTOBKINFO value) {
        this.gbktobkinfo = value;
    }

    /**
     * Gets the value of the ginbktobk property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GINBKTOBK }
     *     
     */
    public FUNDSTRANSFERType.GINBKTOBK getGINBKTOBK() {
        return ginbktobk;
    }

    /**
     * Sets the value of the ginbktobk property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GINBKTOBK }
     *     
     */
    public void setGINBKTOBK(FUNDSTRANSFERType.GINBKTOBK value) {
        this.ginbktobk = value;
    }

    /**
     * Gets the value of the exposuredate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEXPOSUREDATE() {
        return exposuredate;
    }

    /**
     * Sets the value of the exposuredate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEXPOSUREDATE(String value) {
        this.exposuredate = value;
    }

    /**
     * Gets the value of the fedfunds property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFEDFUNDS() {
        return fedfunds;
    }

    /**
     * Sets the value of the fedfunds property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFEDFUNDS(String value) {
        this.fedfunds = value;
    }

    /**
     * Gets the value of the positiontype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPOSITIONTYPE() {
        return positiontype;
    }

    /**
     * Sets the value of the positiontype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPOSITIONTYPE(String value) {
        this.positiontype = value;
    }

    /**
     * Gets the value of the noofbatchitems property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNOOFBATCHITEMS() {
        return noofbatchitems;
    }

    /**
     * Sets the value of the noofbatchitems property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNOOFBATCHITEMS(String value) {
        this.noofbatchitems = value;
    }

    /**
     * Gets the value of the gfreetextmsgto property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GFREETEXTMSGTO }
     *     
     */
    public FUNDSTRANSFERType.GFREETEXTMSGTO getGFREETEXTMSGTO() {
        return gfreetextmsgto;
    }

    /**
     * Sets the value of the gfreetextmsgto property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GFREETEXTMSGTO }
     *     
     */
    public void setGFREETEXTMSGTO(FUNDSTRANSFERType.GFREETEXTMSGTO value) {
        this.gfreetextmsgto = value;
    }

    /**
     * Gets the value of the gmessage property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GMESSAGE }
     *     
     */
    public FUNDSTRANSFERType.GMESSAGE getGMESSAGE() {
        return gmessage;
    }

    /**
     * Sets the value of the gmessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GMESSAGE }
     *     
     */
    public void setGMESSAGE(FUNDSTRANSFERType.GMESSAGE value) {
        this.gmessage = value;
    }

    /**
     * Gets the value of the gtaxtype property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GTAXTYPE }
     *     
     */
    public FUNDSTRANSFERType.GTAXTYPE getGTAXTYPE() {
        return gtaxtype;
    }

    /**
     * Sets the value of the gtaxtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GTAXTYPE }
     *     
     */
    public void setGTAXTYPE(FUNDSTRANSFERType.GTAXTYPE value) {
        this.gtaxtype = value;
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
     * Gets the value of the totalchargeamt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTOTALCHARGEAMT() {
        return totalchargeamt;
    }

    /**
     * Sets the value of the totalchargeamt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTOTALCHARGEAMT(String value) {
        this.totalchargeamt = value;
    }

    /**
     * Gets the value of the totaltaxamount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTOTALTAXAMOUNT() {
        return totaltaxamount;
    }

    /**
     * Sets the value of the totaltaxamount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTOTALTAXAMOUNT(String value) {
        this.totaltaxamount = value;
    }

    /**
     * Gets the value of the customerrate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCUSTOMERRATE() {
        return customerrate;
    }

    /**
     * Sets the value of the customerrate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCUSTOMERRATE(String value) {
        this.customerrate = value;
    }

    /**
     * Gets the value of the ginreccorrbk property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GINRECCORRBK }
     *     
     */
    public FUNDSTRANSFERType.GINRECCORRBK getGINRECCORRBK() {
        return ginreccorrbk;
    }

    /**
     * Sets the value of the ginreccorrbk property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GINRECCORRBK }
     *     
     */
    public void setGINRECCORRBK(FUNDSTRANSFERType.GINRECCORRBK value) {
        this.ginreccorrbk = value;
    }

    /**
     * Gets the value of the inwardpaytype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINWARDPAYTYPE() {
        return inwardpaytype;
    }

    /**
     * Sets the value of the inwardpaytype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINWARDPAYTYPE(String value) {
        this.inwardpaytype = value;
    }

    /**
     * Gets the value of the ginsendcorrbk property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GINSENDCORRBK }
     *     
     */
    public FUNDSTRANSFERType.GINSENDCORRBK getGINSENDCORRBK() {
        return ginsendcorrbk;
    }

    /**
     * Sets the value of the ginsendcorrbk property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GINSENDCORRBK }
     *     
     */
    public void setGINSENDCORRBK(FUNDSTRANSFERType.GINSENDCORRBK value) {
        this.ginsendcorrbk = value;
    }

    /**
     * Gets the value of the telexfromcust property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTELEXFROMCUST() {
        return telexfromcust;
    }

    /**
     * Sets the value of the telexfromcust property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTELEXFROMCUST(String value) {
        this.telexfromcust = value;
    }

    /**
     * Gets the value of the deliveryinref property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDELIVERYINREF() {
        return deliveryinref;
    }

    /**
     * Sets the value of the deliveryinref property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDELIVERYINREF(String value) {
        this.deliveryinref = value;
    }

    /**
     * Gets the value of the gdeliveryoutref property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GDELIVERYOUTREF }
     *     
     */
    public FUNDSTRANSFERType.GDELIVERYOUTREF getGDELIVERYOUTREF() {
        return gdeliveryoutref;
    }

    /**
     * Sets the value of the gdeliveryoutref property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GDELIVERYOUTREF }
     *     
     */
    public void setGDELIVERYOUTREF(FUNDSTRANSFERType.GDELIVERYOUTREF value) {
        this.gdeliveryoutref = value;
    }

    /**
     * Gets the value of the creditcompcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCREDITCOMPCODE() {
        return creditcompcode;
    }

    /**
     * Sets the value of the creditcompcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCREDITCOMPCODE(String value) {
        this.creditcompcode = value;
    }

    /**
     * Gets the value of the debitcompcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDEBITCOMPCODE() {
        return debitcompcode;
    }

    /**
     * Sets the value of the debitcompcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDEBITCOMPCODE(String value) {
        this.debitcompcode = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTATUS() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTATUS(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the deliverymkr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDELIVERYMKR() {
        return deliverymkr;
    }

    /**
     * Sets the value of the deliverymkr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDELIVERYMKR(String value) {
        this.deliverymkr = value;
    }

    /**
     * Gets the value of the ordcustcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getORDCUSTCODE() {
        return ordcustcode;
    }

    /**
     * Sets the value of the ordcustcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setORDCUSTCODE(String value) {
        this.ordcustcode = value;
    }

    /**
     * Gets the value of the acctwithbkacno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACCTWITHBKACNO() {
        return acctwithbkacno;
    }

    /**
     * Sets the value of the acctwithbkacno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACCTWITHBKACNO(String value) {
        this.acctwithbkacno = value;
    }

    /**
     * Gets the value of the locamtdebited property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLOCAMTDEBITED() {
        return locamtdebited;
    }

    /**
     * Sets the value of the locamtdebited property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLOCAMTDEBITED(String value) {
        this.locamtdebited = value;
    }

    /**
     * Gets the value of the locamtcredited property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLOCAMTCREDITED() {
        return locamtcredited;
    }

    /**
     * Sets the value of the locamtcredited property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLOCAMTCREDITED(String value) {
        this.locamtcredited = value;
    }

    /**
     * Gets the value of the loctottaxamt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLOCTOTTAXAMT() {
        return loctottaxamt;
    }

    /**
     * Sets the value of the loctottaxamt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLOCTOTTAXAMT(String value) {
        this.loctottaxamt = value;
    }

    /**
     * Gets the value of the localchargeamt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLOCALCHARGEAMT() {
        return localchargeamt;
    }

    /**
     * Sets the value of the localchargeamt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLOCALCHARGEAMT(String value) {
        this.localchargeamt = value;
    }

    /**
     * Gets the value of the locposchgsamt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLOCPOSCHGSAMT() {
        return locposchgsamt;
    }

    /**
     * Sets the value of the locposchgsamt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLOCPOSCHGSAMT(String value) {
        this.locposchgsamt = value;
    }

    /**
     * Gets the value of the mktgexchprofit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMKTGEXCHPROFIT() {
        return mktgexchprofit;
    }

    /**
     * Sets the value of the mktgexchprofit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMKTGEXCHPROFIT(String value) {
        this.mktgexchprofit = value;
    }

    /**
     * Gets the value of the rateinputmkr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRATEINPUTMKR() {
        return rateinputmkr;
    }

    /**
     * Sets the value of the rateinputmkr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRATEINPUTMKR(String value) {
        this.rateinputmkr = value;
    }

    /**
     * Gets the value of the custgrouplevel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCUSTGROUPLEVEL() {
        return custgrouplevel;
    }

    /**
     * Sets the value of the custgrouplevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCUSTGROUPLEVEL(String value) {
        this.custgrouplevel = value;
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
     * Gets the value of the sendpaymentyn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSENDPAYMENTYN() {
        return sendpaymentyn;
    }

    /**
     * Sets the value of the sendpaymentyn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSENDPAYMENTYN(String value) {
        this.sendpaymentyn = value;
    }

    /**
     * Gets the value of the dradvicereqdyn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDRADVICEREQDYN() {
        return dradvicereqdyn;
    }

    /**
     * Sets the value of the dradvicereqdyn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDRADVICEREQDYN(String value) {
        this.dradvicereqdyn = value;
    }

    /**
     * Gets the value of the cradvicereqdyn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCRADVICEREQDYN() {
        return cradvicereqdyn;
    }

    /**
     * Sets the value of the cradvicereqdyn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCRADVICEREQDYN(String value) {
        this.cradvicereqdyn = value;
    }

    /**
     * Gets the value of the dealmarket property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDEALMARKET() {
        return dealmarket;
    }

    /**
     * Sets the value of the dealmarket property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDEALMARKET(String value) {
        this.dealmarket = value;
    }

    /**
     * Gets the value of the chargedcustomer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCHARGEDCUSTOMER() {
        return chargedcustomer;
    }

    /**
     * Sets the value of the chargedcustomer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCHARGEDCUSTOMER(String value) {
        this.chargedcustomer = value;
    }

    /**
     * Gets the value of the ginreasonove property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GINREASONOVE }
     *     
     */
    public FUNDSTRANSFERType.GINREASONOVE getGINREASONOVE() {
        return ginreasonove;
    }

    /**
     * Sets the value of the ginreasonove property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GINREASONOVE }
     *     
     */
    public void setGINREASONOVE(FUNDSTRANSFERType.GINREASONOVE value) {
        this.ginreasonove = value;
    }

    /**
     * Gets the value of the dealerdesk property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDEALERDESK() {
        return dealerdesk;
    }

    /**
     * Sets the value of the dealerdesk property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDEALERDESK(String value) {
        this.dealerdesk = value;
    }

    /**
     * Gets the value of the recalcfwdrate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRECALCFWDRATE() {
        return recalcfwdrate;
    }

    /**
     * Sets the value of the recalcfwdrate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRECALCFWDRATE(String value) {
        this.recalcfwdrate = value;
    }

    /**
     * Gets the value of the returncheque property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRETURNCHEQUE() {
        return returncheque;
    }

    /**
     * Sets the value of the returncheque property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRETURNCHEQUE(String value) {
        this.returncheque = value;
    }

    /**
     * Gets the value of the drawnaccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDRAWNACCOUNT() {
        return drawnaccount;
    }

    /**
     * Sets the value of the drawnaccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDRAWNACCOUNT(String value) {
        this.drawnaccount = value;
    }

    /**
     * Gets the value of the accountingdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACCOUNTINGDATE() {
        return accountingdate;
    }

    /**
     * Sets the value of the accountingdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACCOUNTINGDATE(String value) {
        this.accountingdate = value;
    }

    /**
     * Gets the value of the ginstrctncode property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GINSTRCTNCODE }
     *     
     */
    public FUNDSTRANSFERType.GINSTRCTNCODE getGINSTRCTNCODE() {
        return ginstrctncode;
    }

    /**
     * Sets the value of the ginstrctncode property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GINSTRCTNCODE }
     *     
     */
    public void setGINSTRCTNCODE(FUNDSTRANSFERType.GINSTRCTNCODE value) {
        this.ginstrctncode = value;
    }

    /**
     * Gets the value of the collrembk property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOLLREMBK() {
        return collrembk;
    }

    /**
     * Sets the value of the collrembk property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOLLREMBK(String value) {
        this.collrembk = value;
    }

    /**
     * Gets the value of the expectedrecsid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEXPECTEDRECSID() {
        return expectedrecsid;
    }

    /**
     * Sets the value of the expectedrecsid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEXPECTEDRECSID(String value) {
        this.expectedrecsid = value;
    }

    /**
     * Gets the value of the totreccomm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTOTRECCOMM() {
        return totreccomm;
    }

    /**
     * Sets the value of the totreccomm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTOTRECCOMM(String value) {
        this.totreccomm = value;
    }

    /**
     * Gets the value of the totreccommlcl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTOTRECCOMMLCL() {
        return totreccommlcl;
    }

    /**
     * Sets the value of the totreccommlcl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTOTRECCOMMLCL(String value) {
        this.totreccommlcl = value;
    }

    /**
     * Gets the value of the totrecchg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTOTRECCHG() {
        return totrecchg;
    }

    /**
     * Sets the value of the totrecchg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTOTRECCHG(String value) {
        this.totrecchg = value;
    }

    /**
     * Gets the value of the totrecchglcl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTOTRECCHGLCL() {
        return totrecchglcl;
    }

    /**
     * Sets the value of the totrecchglcl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTOTRECCHGLCL(String value) {
        this.totrecchglcl = value;
    }

    /**
     * Gets the value of the cheqtype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCHEQTYPE() {
        return cheqtype;
    }

    /**
     * Sets the value of the cheqtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCHEQTYPE(String value) {
        this.cheqtype = value;
    }

    /**
     * Gets the value of the grelatedmsg property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GRELATEDMSG }
     *     
     */
    public FUNDSTRANSFERType.GRELATEDMSG getGRELATEDMSG() {
        return grelatedmsg;
    }

    /**
     * Sets the value of the grelatedmsg property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GRELATEDMSG }
     *     
     */
    public void setGRELATEDMSG(FUNDSTRANSFERType.GRELATEDMSG value) {
        this.grelatedmsg = value;
    }

    /**
     * Gets the value of the gintimeind property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GINTIMEIND }
     *     
     */
    public FUNDSTRANSFERType.GINTIMEIND getGINTIMEIND() {
        return gintimeind;
    }

    /**
     * Sets the value of the gintimeind property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GINTIMEIND }
     *     
     */
    public void setGINTIMEIND(FUNDSTRANSFERType.GINTIMEIND value) {
        this.gintimeind = value;
    }

    /**
     * Gets the value of the gsendtoparty property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GSENDTOPARTY }
     *     
     */
    public FUNDSTRANSFERType.GSENDTOPARTY getGSENDTOPARTY() {
        return gsendtoparty;
    }

    /**
     * Sets the value of the gsendtoparty property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GSENDTOPARTY }
     *     
     */
    public void setGSENDTOPARTY(FUNDSTRANSFERType.GSENDTOPARTY value) {
        this.gsendtoparty = value;
    }

    /**
     * Gets the value of the reversalmkr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREVERSALMKR() {
        return reversalmkr;
    }

    /**
     * Sets the value of the reversalmkr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREVERSALMKR(String value) {
        this.reversalmkr = value;
    }

    /**
     * Gets the value of the relatedref property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRELATEDREF() {
        return relatedref;
    }

    /**
     * Sets the value of the relatedref property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRELATEDREF(String value) {
        this.relatedref = value;
    }

    /**
     * Gets the value of the gininstrcode property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GININSTRCODE }
     *     
     */
    public FUNDSTRANSFERType.GININSTRCODE getGININSTRCODE() {
        return gininstrcode;
    }

    /**
     * Sets the value of the gininstrcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GININSTRCODE }
     *     
     */
    public void setGININSTRCODE(FUNDSTRANSFERType.GININSTRCODE value) {
        this.gininstrcode = value;
    }

    /**
     * Gets the value of the ginprocesserr property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GINPROCESSERR }
     *     
     */
    public FUNDSTRANSFERType.GINPROCESSERR getGINPROCESSERR() {
        return ginprocesserr;
    }

    /**
     * Sets the value of the ginprocesserr property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GINPROCESSERR }
     *     
     */
    public void setGINPROCESSERR(FUNDSTRANSFERType.GINPROCESSERR value) {
        this.ginprocesserr = value;
    }

    /**
     * Gets the value of the ginswiftmsg property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GINSWIFTMSG }
     *     
     */
    public FUNDSTRANSFERType.GINSWIFTMSG getGINSWIFTMSG() {
        return ginswiftmsg;
    }

    /**
     * Sets the value of the ginswiftmsg property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GINSWIFTMSG }
     *     
     */
    public void setGINSWIFTMSG(FUNDSTRANSFERType.GINSWIFTMSG value) {
        this.ginswiftmsg = value;
    }

    /**
     * Gets the value of the acctwithbankacc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACCTWITHBANKACC() {
        return acctwithbankacc;
    }

    /**
     * Sets the value of the acctwithbankacc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACCTWITHBANKACC(String value) {
        this.acctwithbankacc = value;
    }

    /**
     * Gets the value of the inacctbankacc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINACCTBANKACC() {
        return inacctbankacc;
    }

    /**
     * Sets the value of the inacctbankacc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINACCTBANKACC(String value) {
        this.inacctbankacc = value;
    }

    /**
     * Gets the value of the reccorrbankacc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRECCORRBANKACC() {
        return reccorrbankacc;
    }

    /**
     * Sets the value of the reccorrbankacc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRECCORRBANKACC(String value) {
        this.reccorrbankacc = value;
    }

    /**
     * Gets the value of the inreccorracc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINRECCORRACC() {
        return inreccorracc;
    }

    /**
     * Sets the value of the inreccorracc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINRECCORRACC(String value) {
        this.inreccorracc = value;
    }

    /**
     * Gets the value of the intermedbankacc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINTERMEDBANKACC() {
        return intermedbankacc;
    }

    /**
     * Sets the value of the intermedbankacc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINTERMEDBANKACC(String value) {
        this.intermedbankacc = value;
    }

    /**
     * Gets the value of the inintermedacc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getININTERMEDACC() {
        return inintermedacc;
    }

    /**
     * Sets the value of the inintermedacc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setININTERMEDACC(String value) {
        this.inintermedacc = value;
    }

    /**
     * Gets the value of the instructedamt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINSTRUCTEDAMT() {
        return instructedamt;
    }

    /**
     * Sets the value of the instructedamt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINSTRUCTEDAMT(String value) {
        this.instructedamt = value;
    }

    /**
     * Gets the value of the ginintermedbk property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GININTERMEDBK }
     *     
     */
    public FUNDSTRANSFERType.GININTERMEDBK getGININTERMEDBK() {
        return ginintermedbk;
    }

    /**
     * Sets the value of the ginintermedbk property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GININTERMEDBK }
     *     
     */
    public void setGININTERMEDBK(FUNDSTRANSFERType.GININTERMEDBK value) {
        this.ginintermedbk = value;
    }

    /**
     * Gets the value of the inexchrate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINEXCHRATE() {
        return inexchrate;
    }

    /**
     * Sets the value of the inexchrate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINEXCHRATE(String value) {
        this.inexchrate = value;
    }

    /**
     * Gets the value of the ratefixing property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRATEFIXING() {
        return ratefixing;
    }

    /**
     * Sets the value of the ratefixing property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRATEFIXING(String value) {
        this.ratefixing = value;
    }

    /**
     * Gets the value of the covermethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOVERMETHOD() {
        return covermethod;
    }

    /**
     * Sets the value of the covermethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOVERMETHOD(String value) {
        this.covermethod = value;
    }

    /**
     * Gets the value of the gin3RDREIMBBK property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GIN3RDREIMBBK }
     *     
     */
    public FUNDSTRANSFERType.GIN3RDREIMBBK getGIN3RDREIMBBK() {
        return gin3RDREIMBBK;
    }

    /**
     * Sets the value of the gin3RDREIMBBK property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GIN3RDREIMBBK }
     *     
     */
    public void setGIN3RDREIMBBK(FUNDSTRANSFERType.GIN3RDREIMBBK value) {
        this.gin3RDREIMBBK = value;
    }

    /**
     * Gets the value of the in3RDREIMBACC property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIN3RDREIMBACC() {
        return in3RDREIMBACC;
    }

    /**
     * Sets the value of the in3RDREIMBACC property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIN3RDREIMBACC(String value) {
        this.in3RDREIMBACC = value;
    }

    /**
     * Gets the value of the mt103TYPE property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMT103TYPE() {
        return mt103TYPE;
    }

    /**
     * Sets the value of the mt103TYPE property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMT103TYPE(String value) {
        this.mt103TYPE = value;
    }

    /**
     * Gets the value of the extendformat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEXTENDFORMAT() {
        return extendformat;
    }

    /**
     * Sets the value of the extendformat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEXTENDFORMAT(String value) {
        this.extendformat = value;
    }

    /**
     * Gets the value of the gextendinfo property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GEXTENDINFO }
     *     
     */
    public FUNDSTRANSFERType.GEXTENDINFO getGEXTENDINFO() {
        return gextendinfo;
    }

    /**
     * Sets the value of the gextendinfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GEXTENDINFO }
     *     
     */
    public void setGEXTENDINFO(FUNDSTRANSFERType.GEXTENDINFO value) {
        this.gextendinfo = value;
    }

    /**
     * Gets the value of the ratefixingind property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRATEFIXINGIND() {
        return ratefixingind;
    }

    /**
     * Sets the value of the ratefixingind property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRATEFIXINGIND(String value) {
        this.ratefixingind = value;
    }

    /**
     * Gets the value of the inwsendbic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINWSENDBIC() {
        return inwsendbic;
    }

    /**
     * Sets the value of the inwsendbic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINWSENDBIC(String value) {
        this.inwsendbic = value;
    }

    /**
     * Gets the value of the ginsendchg property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GINSENDCHG }
     *     
     */
    public FUNDSTRANSFERType.GINSENDCHG getGINSENDCHG() {
        return ginsendchg;
    }

    /**
     * Sets the value of the ginsendchg property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GINSENDCHG }
     *     
     */
    public void setGINSENDCHG(FUNDSTRANSFERType.GINSENDCHG value) {
        this.ginsendchg = value;
    }

    /**
     * Gets the value of the inrecchg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINRECCHG() {
        return inrecchg;
    }

    /**
     * Sets the value of the inrecchg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINRECCHG(String value) {
        this.inrecchg = value;
    }

    /**
     * Gets the value of the acchgreqid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACCHGREQID() {
        return acchgreqid;
    }

    /**
     * Sets the value of the acchgreqid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACCHGREQID(String value) {
        this.acchgreqid = value;
    }

    /**
     * Gets the value of the totrecchgcrccy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTOTRECCHGCRCCY() {
        return totrecchgcrccy;
    }

    /**
     * Sets the value of the totrecchgcrccy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTOTRECCHGCRCCY(String value) {
        this.totrecchgcrccy = value;
    }

    /**
     * Gets the value of the totsndchgcrccy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTOTSNDCHGCRCCY() {
        return totsndchgcrccy;
    }

    /**
     * Sets the value of the totsndchgcrccy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTOTSNDCHGCRCCY(String value) {
        this.totsndchgcrccy = value;
    }

    /**
     * Gets the value of the chgadvicemsg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCHGADVICEMSG() {
        return chgadvicemsg;
    }

    /**
     * Sets the value of the chgadvicemsg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCHGADVICEMSG(String value) {
        this.chgadvicemsg = value;
    }

    /**
     * Gets the value of the expectedcoverid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEXPECTEDCOVERID() {
        return expectedcoverid;
    }

    /**
     * Sets the value of the expectedcoverid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEXPECTEDCOVERID(String value) {
        this.expectedcoverid = value;
    }

    /**
     * Gets the value of the nettingstatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNETTINGSTATUS() {
        return nettingstatus;
    }

    /**
     * Sets the value of the nettingstatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNETTINGSTATUS(String value) {
        this.nettingstatus = value;
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
     * Gets the value of the bkoperationcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBKOPERATIONCODE() {
        return bkoperationcode;
    }

    /**
     * Sets the value of the bkoperationcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBKOPERATIONCODE(String value) {
        this.bkoperationcode = value;
    }

    /**
     * Gets the value of the aminflowrate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAMINFLOWRATE() {
        return aminflowrate;
    }

    /**
     * Sets the value of the aminflowrate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAMINFLOWRATE(String value) {
        this.aminflowrate = value;
    }

    /**
     * Gets the value of the parenttxnid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPARENTTXNID() {
        return parenttxnid;
    }

    /**
     * Sets the value of the parenttxnid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPARENTTXNID(String value) {
        this.parenttxnid = value;
    }

    /**
     * Gets the value of the roundtype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getROUNDTYPE() {
        return roundtype;
    }

    /**
     * Sets the value of the roundtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setROUNDTYPE(String value) {
        this.roundtype = value;
    }

    /**
     * Gets the value of the beneficiaryid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBENEFICIARYID() {
        return beneficiaryid;
    }

    /**
     * Sets the value of the beneficiaryid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBENEFICIARYID(String value) {
        this.beneficiaryid = value;
    }

    /**
     * Gets the value of the gmsgtype property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GMSGTYPE }
     *     
     */
    public FUNDSTRANSFERType.GMSGTYPE getGMSGTYPE() {
        return gmsgtype;
    }

    /**
     * Sets the value of the gmsgtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GMSGTYPE }
     *     
     */
    public void setGMSGTYPE(FUNDSTRANSFERType.GMSGTYPE value) {
        this.gmsgtype = value;
    }

    /**
     * Gets the value of the gsignatory property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GSIGNATORY }
     *     
     */
    public FUNDSTRANSFERType.GSIGNATORY getGSIGNATORY() {
        return gsignatory;
    }

    /**
     * Sets the value of the gsignatory property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GSIGNATORY }
     *     
     */
    public void setGSIGNATORY(FUNDSTRANSFERType.GSIGNATORY value) {
        this.gsignatory = value;
    }

    /**
     * Gets the value of the cardnumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCARDNUMBER() {
        return cardnumber;
    }

    /**
     * Sets the value of the cardnumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCARDNUMBER(String value) {
        this.cardnumber = value;
    }

    /**
     * Gets the value of the gcardtxndetail property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GCARDTXNDETAIL }
     *     
     */
    public FUNDSTRANSFERType.GCARDTXNDETAIL getGCARDTXNDETAIL() {
        return gcardtxndetail;
    }

    /**
     * Sets the value of the gcardtxndetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GCARDTXNDETAIL }
     *     
     */
    public void setGCARDTXNDETAIL(FUNDSTRANSFERType.GCARDTXNDETAIL value) {
        this.gcardtxndetail = value;
    }

    /**
     * Gets the value of the gincordbk property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GINCORDBK }
     *     
     */
    public FUNDSTRANSFERType.GINCORDBK getGINCORDBK() {
        return gincordbk;
    }

    /**
     * Sets the value of the gincordbk property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GINCORDBK }
     *     
     */
    public void setGINCORDBK(FUNDSTRANSFERType.GINCORDBK value) {
        this.gincordbk = value;
    }

    /**
     * Gets the value of the gincintmedbk property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GINCINTMEDBK }
     *     
     */
    public FUNDSTRANSFERType.GINCINTMEDBK getGINCINTMEDBK() {
        return gincintmedbk;
    }

    /**
     * Sets the value of the gincintmedbk property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GINCINTMEDBK }
     *     
     */
    public void setGINCINTMEDBK(FUNDSTRANSFERType.GINCINTMEDBK value) {
        this.gincintmedbk = value;
    }

    /**
     * Gets the value of the gincaccwitbk property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GINCACCWITBK }
     *     
     */
    public FUNDSTRANSFERType.GINCACCWITBK getGINCACCWITBK() {
        return gincaccwitbk;
    }

    /**
     * Sets the value of the gincaccwitbk property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GINCACCWITBK }
     *     
     */
    public void setGINCACCWITBK(FUNDSTRANSFERType.GINCACCWITBK value) {
        this.gincaccwitbk = value;
    }

    /**
     * Gets the value of the gincbktbkin property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GINCBKTBKIN }
     *     
     */
    public FUNDSTRANSFERType.GINCBKTBKIN getGINCBKTBKIN() {
        return gincbktbkin;
    }

    /**
     * Sets the value of the gincbktbkin property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GINCBKTBKIN }
     *     
     */
    public void setGINCBKTBKIN(FUNDSTRANSFERType.GINCBKTBKIN value) {
        this.gincbktbkin = value;
    }

    /**
     * Gets the value of the tfsreference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTFSREFERENCE() {
        return tfsreference;
    }

    /**
     * Sets the value of the tfsreference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTFSREFERENCE(String value) {
        this.tfsreference = value;
    }

    /**
     * Gets the value of the chequedrawn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCHEQUEDRAWN() {
        return chequedrawn;
    }

    /**
     * Sets the value of the chequedrawn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCHEQUEDRAWN(String value) {
        this.chequedrawn = value;
    }

    /**
     * Gets the value of the issuechequetype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISSUECHEQUETYPE() {
        return issuechequetype;
    }

    /**
     * Sets the value of the issuechequetype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISSUECHEQUETYPE(String value) {
        this.issuechequetype = value;
    }

    /**
     * Gets the value of the stocknumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTOCKNUMBER() {
        return stocknumber;
    }

    /**
     * Sets the value of the stocknumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTOCKNUMBER(String value) {
        this.stocknumber = value;
    }

    /**
     * Gets the value of the payeename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAYEENAME() {
        return payeename;
    }

    /**
     * Sets the value of the payeename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAYEENAME(String value) {
        this.payeename = value;
    }

    /**
     * Gets the value of the stockregister property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTOCKREGISTER() {
        return stockregister;
    }

    /**
     * Sets the value of the stockregister property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTOCKREGISTER(String value) {
        this.stockregister = value;
    }

    /**
     * Gets the value of the seriesid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSERIESID() {
        return seriesid;
    }

    /**
     * Sets the value of the seriesid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSERIESID(String value) {
        this.seriesid = value;
    }

    /**
     * Gets the value of the ordcustacct property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getORDCUSTACCT() {
        return ordcustacct;
    }

    /**
     * Sets the value of the ordcustacct property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setORDCUSTACCT(String value) {
        this.ordcustacct = value;
    }

    /**
     * Gets the value of the inordcustacct property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINORDCUSTACCT() {
        return inordcustacct;
    }

    /**
     * Sets the value of the inordcustacct property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINORDCUSTACCT(String value) {
        this.inordcustacct = value;
    }

    /**
     * Gets the value of the ibandebit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIBANDEBIT() {
        return ibandebit;
    }

    /**
     * Sets the value of the ibandebit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIBANDEBIT(String value) {
        this.ibandebit = value;
    }

    /**
     * Gets the value of the ibancredit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIBANCREDIT() {
        return ibancredit;
    }

    /**
     * Sets the value of the ibancredit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIBANCREDIT(String value) {
        this.ibancredit = value;
    }

    /**
     * Gets the value of the ibanben property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIBANBEN() {
        return ibanben;
    }

    /**
     * Sets the value of the ibanben property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIBANBEN(String value) {
        this.ibanben = value;
    }

    /**
     * Gets the value of the ibanacctwithbank property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIBANACCTWITHBANK() {
        return ibanacctwithbank;
    }

    /**
     * Sets the value of the ibanacctwithbank property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIBANACCTWITHBANK(String value) {
        this.ibanacctwithbank = value;
    }

    /**
     * Gets the value of the ibanreccorrbank property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIBANRECCORRBANK() {
        return ibanreccorrbank;
    }

    /**
     * Sets the value of the ibanreccorrbank property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIBANRECCORRBANK(String value) {
        this.ibanreccorrbank = value;
    }

    /**
     * Gets the value of the ibanintermedbank property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIBANINTERMEDBANK() {
        return ibanintermedbank;
    }

    /**
     * Sets the value of the ibanintermedbank property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIBANINTERMEDBANK(String value) {
        this.ibanintermedbank = value;
    }

    /**
     * Gets the value of the ibanordcustacc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIBANORDCUSTACC() {
        return ibanordcustacc;
    }

    /**
     * Sets the value of the ibanordcustacc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIBANORDCUSTACC(String value) {
        this.ibanordcustacc = value;
    }

    /**
     * Gets the value of the ibanchargesacct property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIBANCHARGESACCT() {
        return ibanchargesacct;
    }

    /**
     * Sets the value of the ibanchargesacct property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIBANCHARGESACCT(String value) {
        this.ibanchargesacct = value;
    }

    /**
     * Gets the value of the bicibanben property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBICIBANBEN() {
        return bicibanben;
    }

    /**
     * Sets the value of the bicibanben property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBICIBANBEN(String value) {
        this.bicibanben = value;
    }

    /**
     * Gets the value of the gbicibanbenname property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GBICIBANBENNAME }
     *     
     */
    public FUNDSTRANSFERType.GBICIBANBENNAME getGBICIBANBENNAME() {
        return gbicibanbenname;
    }

    /**
     * Sets the value of the gbicibanbenname property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GBICIBANBENNAME }
     *     
     */
    public void setGBICIBANBENNAME(FUNDSTRANSFERType.GBICIBANBENNAME value) {
        this.gbicibanbenname = value;
    }

    /**
     * Gets the value of the bicibanbencity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBICIBANBENCITY() {
        return bicibanbencity;
    }

    /**
     * Sets the value of the bicibanbencity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBICIBANBENCITY(String value) {
        this.bicibanbencity = value;
    }

    /**
     * Gets the value of the gbenname property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GBENNAME }
     *     
     */
    public FUNDSTRANSFERType.GBENNAME getGBENNAME() {
        return gbenname;
    }

    /**
     * Sets the value of the gbenname property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GBENNAME }
     *     
     */
    public void setGBENNAME(FUNDSTRANSFERType.GBENNAME value) {
        this.gbenname = value;
    }

    /**
     * Gets the value of the gbenaddress property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GBENADDRESS }
     *     
     */
    public FUNDSTRANSFERType.GBENADDRESS getGBENADDRESS() {
        return gbenaddress;
    }

    /**
     * Sets the value of the gbenaddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GBENADDRESS }
     *     
     */
    public void setGBENADDRESS(FUNDSTRANSFERType.GBENADDRESS value) {
        this.gbenaddress = value;
    }

    /**
     * Gets the value of the bencountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBENCOUNTRY() {
        return bencountry;
    }

    /**
     * Sets the value of the bencountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBENCOUNTRY(String value) {
        this.bencountry = value;
    }

    /**
     * Gets the value of the gbentown property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GBENTOWN }
     *     
     */
    public FUNDSTRANSFERType.GBENTOWN getGBENTOWN() {
        return gbentown;
    }

    /**
     * Sets the value of the gbentown property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GBENTOWN }
     *     
     */
    public void setGBENTOWN(FUNDSTRANSFERType.GBENTOWN value) {
        this.gbentown = value;
    }

    /**
     * Gets the value of the ginbenname property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GINBENNAME }
     *     
     */
    public FUNDSTRANSFERType.GINBENNAME getGINBENNAME() {
        return ginbenname;
    }

    /**
     * Sets the value of the ginbenname property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GINBENNAME }
     *     
     */
    public void setGINBENNAME(FUNDSTRANSFERType.GINBENNAME value) {
        this.ginbenname = value;
    }

    /**
     * Gets the value of the ginbenaddress property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GINBENADDRESS }
     *     
     */
    public FUNDSTRANSFERType.GINBENADDRESS getGINBENADDRESS() {
        return ginbenaddress;
    }

    /**
     * Sets the value of the ginbenaddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GINBENADDRESS }
     *     
     */
    public void setGINBENADDRESS(FUNDSTRANSFERType.GINBENADDRESS value) {
        this.ginbenaddress = value;
    }

    /**
     * Gets the value of the inbencountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINBENCOUNTRY() {
        return inbencountry;
    }

    /**
     * Sets the value of the inbencountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINBENCOUNTRY(String value) {
        this.inbencountry = value;
    }

    /**
     * Gets the value of the ginbentown property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GINBENTOWN }
     *     
     */
    public FUNDSTRANSFERType.GINBENTOWN getGINBENTOWN() {
        return ginbentown;
    }

    /**
     * Sets the value of the ginbentown property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GINBENTOWN }
     *     
     */
    public void setGINBENTOWN(FUNDSTRANSFERType.GINBENTOWN value) {
        this.ginbentown = value;
    }

    /**
     * Gets the value of the grefdataitem property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GREFDATAITEM }
     *     
     */
    public FUNDSTRANSFERType.GREFDATAITEM getGREFDATAITEM() {
        return grefdataitem;
    }

    /**
     * Sets the value of the grefdataitem property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GREFDATAITEM }
     *     
     */
    public void setGREFDATAITEM(FUNDSTRANSFERType.GREFDATAITEM value) {
        this.grefdataitem = value;
    }

    /**
     * Gets the value of the glocequivchgs property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GLOCEQUIVCHGS }
     *     
     */
    public FUNDSTRANSFERType.GLOCEQUIVCHGS getGLOCEQUIVCHGS() {
        return glocequivchgs;
    }

    /**
     * Sets the value of the glocequivchgs property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GLOCEQUIVCHGS }
     *     
     */
    public void setGLOCEQUIVCHGS(FUNDSTRANSFERType.GLOCEQUIVCHGS value) {
        this.glocequivchgs = value;
    }

    /**
     * Gets the value of the gforequivchgs property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GFOREQUIVCHGS }
     *     
     */
    public FUNDSTRANSFERType.GFOREQUIVCHGS getGFOREQUIVCHGS() {
        return gforequivchgs;
    }

    /**
     * Sets the value of the gforequivchgs property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GFOREQUIVCHGS }
     *     
     */
    public void setGFOREQUIVCHGS(FUNDSTRANSFERType.GFOREQUIVCHGS value) {
        this.gforequivchgs = value;
    }

    /**
     * Gets the value of the regcompliance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREGCOMPLIANCE() {
        return regcompliance;
    }

    /**
     * Sets the value of the regcompliance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREGCOMPLIANCE(String value) {
        this.regcompliance = value;
    }

    /**
     * Gets the value of the cbcreditaccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCBCREDITACCOUNT() {
        return cbcreditaccount;
    }

    /**
     * Sets the value of the cbcreditaccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCBCREDITACCOUNT(String value) {
        this.cbcreditaccount = value;
    }

    /**
     * Gets the value of the cbcreditccy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCBCREDITCCY() {
        return cbcreditccy;
    }

    /**
     * Sets the value of the cbcreditccy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCBCREDITCCY(String value) {
        this.cbcreditccy = value;
    }

    /**
     * Gets the value of the cbdebitaccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCBDEBITACCOUNT() {
        return cbdebitaccount;
    }

    /**
     * Sets the value of the cbdebitaccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCBDEBITACCOUNT(String value) {
        this.cbdebitaccount = value;
    }

    /**
     * Gets the value of the cbdebitccy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCBDEBITCCY() {
        return cbdebitccy;
    }

    /**
     * Sets the value of the cbdebitccy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCBDEBITCCY(String value) {
        this.cbdebitccy = value;
    }

    /**
     * Gets the value of the tcsimaccepted property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTCSIMACCEPTED() {
        return tcsimaccepted;
    }

    /**
     * Sets the value of the tcsimaccepted property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTCSIMACCEPTED(String value) {
        this.tcsimaccepted = value;
    }

    /**
     * Gets the value of the lastsimtime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLASTSIMTIME() {
        return lastsimtime;
    }

    /**
     * Sets the value of the lastsimtime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLASTSIMTIME(String value) {
        this.lastsimtime = value;
    }

    /**
     * Gets the value of the inhdr3UETR property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINHDR3UETR() {
        return inhdr3UETR;
    }

    /**
     * Sets the value of the inhdr3UETR property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINHDR3UETR(String value) {
        this.inhdr3UETR = value;
    }

    /**
     * Gets the value of the gsplitexposuredate property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GSPLITEXPOSUREDATE }
     *     
     */
    public FUNDSTRANSFERType.GSPLITEXPOSUREDATE getGSPLITEXPOSUREDATE() {
        return gsplitexposuredate;
    }

    /**
     * Sets the value of the gsplitexposuredate property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GSPLITEXPOSUREDATE }
     *     
     */
    public void setGSPLITEXPOSUREDATE(FUNDSTRANSFERType.GSPLITEXPOSUREDATE value) {
        this.gsplitexposuredate = value;
    }

    /**
     * Gets the value of the authorisationid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAUTHORISATIONID() {
        return authorisationid;
    }

    /**
     * Sets the value of the authorisationid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAUTHORISATIONID(String value) {
        this.authorisationid = value;
    }

    /**
     * Gets the value of the exemptfromsca property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEXEMPTFROMSCA() {
        return exemptfromsca;
    }

    /**
     * Sets the value of the exemptfromsca property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEXEMPTFROMSCA(String value) {
        this.exemptfromsca = value;
    }

    /**
     * Gets the value of the statusreasoncode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTATUSREASONCODE() {
        return statusreasoncode;
    }

    /**
     * Sets the value of the statusreasoncode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTATUSREASONCODE(String value) {
        this.statusreasoncode = value;
    }

    /**
     * Gets the value of the reserved4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRESERVED4() {
        return reserved4;
    }

    /**
     * Sets the value of the reserved4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRESERVED4(String value) {
        this.reserved4 = value;
    }

    /**
     * Gets the value of the reserved3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRESERVED3() {
        return reserved3;
    }

    /**
     * Sets the value of the reserved3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRESERVED3(String value) {
        this.reserved3 = value;
    }

    /**
     * Gets the value of the reserved2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRESERVED2() {
        return reserved2;
    }

    /**
     * Sets the value of the reserved2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRESERVED2(String value) {
        this.reserved2 = value;
    }

    /**
     * Gets the value of the reserved1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRESERVED1() {
        return reserved1;
    }

    /**
     * Sets the value of the reserved1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRESERVED1(String value) {
        this.reserved1 = value;
    }

    /**
     * Gets the value of the gstmtnos property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GSTMTNOS }
     *     
     */
    public FUNDSTRANSFERType.GSTMTNOS getGSTMTNOS() {
        return gstmtnos;
    }

    /**
     * Sets the value of the gstmtnos property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GSTMTNOS }
     *     
     */
    public void setGSTMTNOS(FUNDSTRANSFERType.GSTMTNOS value) {
        this.gstmtnos = value;
    }

    /**
     * Gets the value of the goverride property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GOVERRIDE }
     *     
     */
    public FUNDSTRANSFERType.GOVERRIDE getGOVERRIDE() {
        return goverride;
    }

    /**
     * Sets the value of the goverride property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GOVERRIDE }
     *     
     */
    public void setGOVERRIDE(FUNDSTRANSFERType.GOVERRIDE value) {
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
     *     {@link FUNDSTRANSFERType.GINPUTTER }
     *     
     */
    public FUNDSTRANSFERType.GINPUTTER getGINPUTTER() {
        return ginputter;
    }

    /**
     * Sets the value of the ginputter property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GINPUTTER }
     *     
     */
    public void setGINPUTTER(FUNDSTRANSFERType.GINPUTTER value) {
        this.ginputter = value;
    }

    /**
     * Gets the value of the gdatetime property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GDATETIME }
     *     
     */
    public FUNDSTRANSFERType.GDATETIME getGDATETIME() {
        return gdatetime;
    }

    /**
     * Sets the value of the gdatetime property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GDATETIME }
     *     
     */
    public void setGDATETIME(FUNDSTRANSFERType.GDATETIME value) {
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
     * Gets the value of the forexclass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFOREXCLASS() {
        return forexclass;
    }

    /**
     * Sets the value of the forexclass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFOREXCLASS(String value) {
        this.forexclass = value;
    }

    /**
     * Gets the value of the unpaidcheque property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUNPAIDCHEQUE() {
        return unpaidcheque;
    }

    /**
     * Sets the value of the unpaidcheque property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUNPAIDCHEQUE(String value) {
        this.unpaidcheque = value;
    }

    /**
     * Gets the value of the sbbanknumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSBBANKNUMBER() {
        return sbbanknumber;
    }

    /**
     * Sets the value of the sbbanknumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSBBANKNUMBER(String value) {
        this.sbbanknumber = value;
    }

    /**
     * Gets the value of the ccversion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCCVERSION() {
        return ccversion;
    }

    /**
     * Sets the value of the ccversion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCCVERSION(String value) {
        this.ccversion = value;
    }

    /**
     * Gets the value of the balcoaname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBALCOANAME() {
        return balcoaname;
    }

    /**
     * Sets the value of the balcoaname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBALCOANAME(String value) {
        this.balcoaname = value;
    }

    /**
     * Gets the value of the gbenefname property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GBENEFNAME }
     *     
     */
    public FUNDSTRANSFERType.GBENEFNAME getGBENEFNAME() {
        return gbenefname;
    }

    /**
     * Sets the value of the gbenefname property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GBENEFNAME }
     *     
     */
    public void setGBENEFNAME(FUNDSTRANSFERType.GBENEFNAME value) {
        this.gbenefname = value;
    }

    /**
     * Gets the value of the benefacct property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBENEFACCT() {
        return benefacct;
    }

    /**
     * Sets the value of the benefacct property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBENEFACCT(String value) {
        this.benefacct = value;
    }

    /**
     * Gets the value of the foreignBanks property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getForeignBanks() {
        return foreignBanks;
    }

    /**
     * Sets the value of the foreignBanks property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setForeignBanks(String value) {
        this.foreignBanks = value;
    }

    /**
     * Gets the value of the countryTable property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountryTable() {
        return countryTable;
    }

    /**
     * Sets the value of the countryTable property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountryTable(String value) {
        this.countryTable = value;
    }

    /**
     * Gets the value of the inputversion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINPUTVERSION() {
        return inputversion;
    }

    /**
     * Sets the value of the inputversion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINPUTVERSION(String value) {
        this.inputversion = value;
    }

    /**
     * Gets the value of the commcharge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOMMCHARGE() {
        return commcharge;
    }

    /**
     * Sets the value of the commcharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOMMCHARGE(String value) {
        this.commcharge = value;
    }

    /**
     * Gets the value of the authversion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAUTHVERSION() {
        return authversion;
    }

    /**
     * Sets the value of the authversion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAUTHVERSION(String value) {
        this.authversion = value;
    }

    /**
     * Gets the value of the intcat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINTCAT() {
        return intcat;
    }

    /**
     * Sets the value of the intcat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINTCAT(String value) {
        this.intcat = value;
    }

    /**
     * Gets the value of the boletimRegisto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBoletimRegisto() {
        return boletimRegisto;
    }

    /**
     * Sets the value of the boletimRegisto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBoletimRegisto(String value) {
        this.boletimRegisto = value;
    }

    /**
     * Gets the value of the ftno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFTNO() {
        return ftno;
    }

    /**
     * Sets the value of the ftno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFTNO(String value) {
        this.ftno = value;
    }

    /**
     * Gets the value of the qtdDocEnv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQtdDocEnv() {
        return qtdDocEnv;
    }

    /**
     * Sets the value of the qtdDocEnv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQtdDocEnv(String value) {
        this.qtdDocEnv = value;
    }

    /**
     * Gets the value of the branchname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBRANCHNAME() {
        return branchname;
    }

    /**
     * Sets the value of the branchname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBRANCHNAME(String value) {
        this.branchname = value;
    }

    /**
     * Gets the value of the actualBalance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActualBalance() {
        return actualBalance;
    }

    /**
     * Sets the value of the actualBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActualBalance(String value) {
        this.actualBalance = value;
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
     * Gets the value of the gsendeddocument property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GSENDEDDOCUMENT }
     *     
     */
    public FUNDSTRANSFERType.GSENDEDDOCUMENT getGSENDEDDOCUMENT() {
        return gsendeddocument;
    }

    /**
     * Sets the value of the gsendeddocument property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GSENDEDDOCUMENT }
     *     
     */
    public void setGSENDEDDOCUMENT(FUNDSTRANSFERType.GSENDEDDOCUMENT value) {
        this.gsendeddocument = value;
    }

    /**
     * Gets the value of the conta2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCONTA2() {
        return conta2;
    }

    /**
     * Sets the value of the conta2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCONTA2(String value) {
        this.conta2 = value;
    }

    /**
     * Gets the value of the sibscardno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSIBSCARDNO() {
        return sibscardno;
    }

    /**
     * Sets the value of the sibscardno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSIBSCARDNO(String value) {
        this.sibscardno = value;
    }

    /**
     * Gets the value of the pointofservce property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPOINTOFSERVCE() {
        return pointofservce;
    }

    /**
     * Sets the value of the pointofservce property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPOINTOFSERVCE(String value) {
        this.pointofservce = value;
    }

    /**
     * Gets the value of the acqinstitute property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACQINSTITUTE() {
        return acqinstitute;
    }

    /**
     * Sets the value of the acqinstitute property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACQINSTITUTE(String value) {
        this.acqinstitute = value;
    }

    /**
     * Gets the value of the terminaltype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTERMINALTYPE() {
        return terminaltype;
    }

    /**
     * Sets the value of the terminaltype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTERMINALTYPE(String value) {
        this.terminaltype = value;
    }

    /**
     * Gets the value of the terminalid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTERMINALID() {
        return terminalid;
    }

    /**
     * Sets the value of the terminalid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTERMINALID(String value) {
        this.terminalid = value;
    }

    /**
     * Gets the value of the processingcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPROCESSINGCODE() {
        return processingcode;
    }

    /**
     * Sets the value of the processingcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPROCESSINGCODE(String value) {
        this.processingcode = value;
    }

    /**
     * Gets the value of the debitCategory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDebitCategory() {
        return debitCategory;
    }

    /**
     * Sets the value of the debitCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDebitCategory(String value) {
        this.debitCategory = value;
    }

    /**
     * Gets the value of the creditCategory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditCategory() {
        return creditCategory;
    }

    /**
     * Sets the value of the creditCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditCategory(String value) {
        this.creditCategory = value;
    }

    /**
     * Gets the value of the codage2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCODAGE2() {
        return codage2;
    }

    /**
     * Sets the value of the codage2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCODAGE2(String value) {
        this.codage2 = value;
    }

    /**
     * Gets the value of the cardnumfull property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCARDNUMFULL() {
        return cardnumfull;
    }

    /**
     * Sets the value of the cardnumfull property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCARDNUMFULL(String value) {
        this.cardnumfull = value;
    }

    /**
     * Gets the value of the idlog property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDLOG() {
        return idlog;
    }

    /**
     * Sets the value of the idlog property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDLOG(String value) {
        this.idlog = value;
    }

    /**
     * Gets the value of the nrlog property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNRLOG() {
        return nrlog;
    }

    /**
     * Sets the value of the nrlog property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNRLOG(String value) {
        this.nrlog = value;
    }

    /**
     * Gets the value of the bankcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBANKCODE() {
        return bankcode;
    }

    /**
     * Sets the value of the bankcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBANKCODE(String value) {
        this.bankcode = value;
    }

    /**
     * Gets the value of the tipotransaccao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTIPOTRANSACCAO() {
        return tipotransaccao;
    }

    /**
     * Sets the value of the tipotransaccao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTIPOTRANSACCAO(String value) {
        this.tipotransaccao = value;
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
     * Gets the value of the branchacctno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBRANCHACCTNO() {
        return branchacctno;
    }

    /**
     * Sets the value of the branchacctno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBRANCHACCTNO(String value) {
        this.branchacctno = value;
    }

    /**
     * Gets the value of the idperlocal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDPERLOCAL() {
        return idperlocal;
    }

    /**
     * Sets the value of the idperlocal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDPERLOCAL(String value) {
        this.idperlocal = value;
    }

    /**
     * Gets the value of the numregloc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNUMREGLOC() {
        return numregloc;
    }

    /**
     * Sets the value of the numregloc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNUMREGLOC(String value) {
        this.numregloc = value;
    }

    /**
     * Gets the value of the nridresp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNRIDRESP() {
        return nridresp;
    }

    /**
     * Sets the value of the nridresp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNRIDRESP(String value) {
        this.nridresp = value;
    }

    /**
     * Gets the value of the nridrespo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNRIDRESPO() {
        return nridrespo;
    }

    /**
     * Sets the value of the nridrespo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNRIDRESPO(String value) {
        this.nridrespo = value;
    }

    /**
     * Gets the value of the idlogo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDLOGO() {
        return idlogo;
    }

    /**
     * Sets the value of the idlogo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDLOGO(String value) {
        this.idlogo = value;
    }

    /**
     * Gets the value of the nrlogo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNRLOGO() {
        return nrlogo;
    }

    /**
     * Sets the value of the nrlogo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNRLOGO(String value) {
        this.nrlogo = value;
    }

    /**
     * Gets the value of the dhmsgo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDHMSGO() {
        return dhmsgo;
    }

    /**
     * Sets the value of the dhmsgo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDHMSGO(String value) {
        this.dhmsgo = value;
    }

    /**
     * Gets the value of the tipodoc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTIPODOC() {
        return tipodoc;
    }

    /**
     * Sets the value of the tipodoc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTIPODOC(String value) {
        this.tipodoc = value;
    }

    /**
     * Gets the value of the interbankzone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINTERBANKZONE() {
        return interbankzone;
    }

    /**
     * Sets the value of the interbankzone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINTERBANKZONE(String value) {
        this.interbankzone = value;
    }

    /**
     * Gets the value of the codinvcorrdr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCODINVCORRDR() {
        return codinvcorrdr;
    }

    /**
     * Sets the value of the codinvcorrdr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCODINVCORRDR(String value) {
        this.codinvcorrdr = value;
    }

    /**
     * Gets the value of the clearingperiod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCLEARINGPERIOD() {
        return clearingperiod;
    }

    /**
     * Sets the value of the clearingperiod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCLEARINGPERIOD(String value) {
        this.clearingperiod = value;
    }

    /**
     * Gets the value of the bstmbmchqid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBSTMBMCHQID() {
        return bstmbmchqid;
    }

    /**
     * Sets the value of the bstmbmchqid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBSTMBMCHQID(String value) {
        this.bstmbmchqid = value;
    }

    /**
     * Gets the value of the custaccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCUSTACCOUNT() {
        return custaccount;
    }

    /**
     * Sets the value of the custaccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCUSTACCOUNT(String value) {
        this.custaccount = value;
    }

    /**
     * Gets the value of the serviceaccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSERVICEACCOUNT() {
        return serviceaccount;
    }

    /**
     * Sets the value of the serviceaccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSERVICEACCOUNT(String value) {
        this.serviceaccount = value;
    }

    /**
     * Gets the value of the ftunpaidnr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFTUNPAIDNR() {
        return ftunpaidnr;
    }

    /**
     * Sets the value of the ftunpaidnr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFTUNPAIDNR(String value) {
        this.ftunpaidnr = value;
    }

    /**
     * Gets the value of the ibkpartypay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIBKPARTYPAY() {
        return ibkpartypay;
    }

    /**
     * Sets the value of the ibkpartypay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIBKPARTYPAY(String value) {
        this.ibkpartypay = value;
    }

    /**
     * Gets the value of the foreignchqnr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFOREIGNCHQNR() {
        return foreignchqnr;
    }

    /**
     * Sets the value of the foreignchqnr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFOREIGNCHQNR(String value) {
        this.foreignchqnr = value;
    }

    /**
     * Gets the value of the nomedocaixa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNOMEDOCAIXA() {
        return nomedocaixa;
    }

    /**
     * Sets the value of the nomedocaixa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNOMEDOCAIXA(String value) {
        this.nomedocaixa = value;
    }

    /**
     * Gets the value of the nrcontribuinte property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNRCONTRIBUINTE() {
        return nrcontribuinte;
    }

    /**
     * Sets the value of the nrcontribuinte property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNRCONTRIBUINTE(String value) {
        this.nrcontribuinte = value;
    }

    /**
     * Gets the value of the sequence property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSEQUENCE() {
        return sequence;
    }

    /**
     * Sets the value of the sequence property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSEQUENCE(String value) {
        this.sequence = value;
    }

    /**
     * Gets the value of the codinvcorrcr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCODINVCORRCR() {
        return codinvcorrcr;
    }

    /**
     * Sets the value of the codinvcorrcr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCODINVCORRCR(String value) {
        this.codinvcorrcr = value;
    }

    /**
     * Gets the value of the prazopend property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRAZOPEND() {
        return prazopend;
    }

    /**
     * Sets the value of the prazopend property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRAZOPEND(String value) {
        this.prazopend = value;
    }

    /**
     * Gets the value of the pracaapfisica property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRACAAPFISICA() {
        return pracaapfisica;
    }

    /**
     * Sets the value of the pracaapfisica property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRACAAPFISICA(String value) {
        this.pracaapfisica = value;
    }

    /**
     * Gets the value of the refcutedb property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREFCUTEDB() {
        return refcutedb;
    }

    /**
     * Sets the value of the refcutedb property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREFCUTEDB(String value) {
        this.refcutedb = value;
    }

    /**
     * Gets the value of the refcutecr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREFCUTECR() {
        return refcutecr;
    }

    /**
     * Sets the value of the refcutecr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREFCUTECR(String value) {
        this.refcutecr = value;
    }

    /**
     * Gets the value of the fullcontrtnr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFULLCONTRTNR() {
        return fullcontrtnr;
    }

    /**
     * Sets the value of the fullcontrtnr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFULLCONTRTNR(String value) {
        this.fullcontrtnr = value;
    }

    /**
     * Gets the value of the invoicenumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINVOICENUMBER() {
        return invoicenumber;
    }

    /**
     * Sets the value of the invoicenumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINVOICENUMBER(String value) {
        this.invoicenumber = value;
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
     * Gets the value of the contractnumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCONTRACTNUMBER() {
        return contractnumber;
    }

    /**
     * Sets the value of the contractnumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCONTRACTNUMBER(String value) {
        this.contractnumber = value;
    }

    /**
     * Gets the value of the sequencenumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSEQUENCENUMBER() {
        return sequencenumber;
    }

    /**
     * Sets the value of the sequencenumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSEQUENCENUMBER(String value) {
        this.sequencenumber = value;
    }

    /**
     * Gets the value of the checkdigit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCHECKDIGIT() {
        return checkdigit;
    }

    /**
     * Sets the value of the checkdigit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCHECKDIGIT(String value) {
        this.checkdigit = value;
    }

    /**
     * Gets the value of the prodtype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRODTYPE() {
        return prodtype;
    }

    /**
     * Sets the value of the prodtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRODTYPE(String value) {
        this.prodtype = value;
    }

    /**
     * Gets the value of the circuitnr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCIRCUITNR() {
        return circuitnr;
    }

    /**
     * Sets the value of the circuitnr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCIRCUITNR(String value) {
        this.circuitnr = value;
    }

    /**
     * Gets the value of the invoicedate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINVOICEDATE() {
        return invoicedate;
    }

    /**
     * Sets the value of the invoicedate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINVOICEDATE(String value) {
        this.invoicedate = value;
    }

    /**
     * Gets the value of the idCard property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * Sets the value of the idCard property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdCard(String value) {
        this.idCard = value;
    }

    /**
     * Gets the value of the docNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDOCNo() {
        return docNo;
    }

    /**
     * Sets the value of the docNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDOCNo(String value) {
        this.docNo = value;
    }

    /**
     * Gets the value of the gibid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGIBID() {
        return gibid;
    }

    /**
     * Sets the value of the gibid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGIBID(String value) {
        this.gibid = value;
    }

    /**
     * Gets the value of the defauxilfee property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDEFAUXILFEE() {
        return defauxilfee;
    }

    /**
     * Sets the value of the defauxilfee property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDEFAUXILFEE(String value) {
        this.defauxilfee = value;
    }

    /**
     * Gets the value of the spcauxilfee property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSPCAUXILFEE() {
        return spcauxilfee;
    }

    /**
     * Sets the value of the spcauxilfee property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSPCAUXILFEE(String value) {
        this.spcauxilfee = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNAME() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNAME(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the sbcardnumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSBCARDNUMBER() {
        return sbcardnumber;
    }

    /**
     * Sets the value of the sbcardnumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSBCARDNUMBER(String value) {
        this.sbcardnumber = value;
    }

    /**
     * Gets the value of the adress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdress() {
        return adress;
    }

    /**
     * Sets the value of the adress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdress(String value) {
        this.adress = value;
    }

    /**
     * Gets the value of the emailaddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEMAILADDRESS() {
        return emailaddress;
    }

    /**
     * Sets the value of the emailaddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEMAILADDRESS(String value) {
        this.emailaddress = value;
    }

    /**
     * Gets the value of the localidade property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLOCALIDADE() {
        return localidade;
    }

    /**
     * Sets the value of the localidade property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLOCALIDADE(String value) {
        this.localidade = value;
    }

    /**
     * Gets the value of the telno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTELNO() {
        return telno;
    }

    /**
     * Sets the value of the telno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTELNO(String value) {
        this.telno = value;
    }

    /**
     * Gets the value of the account2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACCOUNT2() {
        return account2;
    }

    /**
     * Sets the value of the account2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACCOUNT2(String value) {
        this.account2 = value;
    }

    /**
     * Gets the value of the qtdtitulos property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQTDTITULOS() {
        return qtdtitulos;
    }

    /**
     * Sets the value of the qtdtitulos property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQTDTITULOS(String value) {
        this.qtdtitulos = value;
    }

    /**
     * Gets the value of the surname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets the value of the surname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSurname(String value) {
        this.surname = value;
    }

    /**
     * Gets the value of the codestatdr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCODESTATDR() {
        return codestatdr;
    }

    /**
     * Sets the value of the codestatdr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCODESTATDR(String value) {
        this.codestatdr = value;
    }

    /**
     * Gets the value of the codestatcr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCODESTATCR() {
        return codestatcr;
    }

    /**
     * Sets the value of the codestatcr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCODESTATCR(String value) {
        this.codestatcr = value;
    }

    /**
     * Gets the value of the linkid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLINKID() {
        return linkid;
    }

    /**
     * Sets the value of the linkid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLINKID(String value) {
        this.linkid = value;
    }

    /**
     * Gets the value of the tipopagamento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTIPOPAGAMENTO() {
        return tipopagamento;
    }

    /**
     * Sets the value of the tipopagamento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTIPOPAGAMENTO(String value) {
        this.tipopagamento = value;
    }

    /**
     * Gets the value of the cocacolarel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOCACOLAREL() {
        return cocacolarel;
    }

    /**
     * Sets the value of the cocacolarel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOCACOLAREL(String value) {
        this.cocacolarel = value;
    }

    /**
     * Gets the value of the seqtrans property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSEQTRANS() {
        return seqtrans;
    }

    /**
     * Sets the value of the seqtrans property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSEQTRANS(String value) {
        this.seqtrans = value;
    }

    /**
     * Gets the value of the nrcomerciante property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNRCOMERCIANTE() {
        return nrcomerciante;
    }

    /**
     * Sets the value of the nrcomerciante property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNRCOMERCIANTE(String value) {
        this.nrcomerciante = value;
    }

    /**
     * Gets the value of the isoauthcd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISOAUTHCD() {
        return isoauthcd;
    }

    /**
     * Sets the value of the isoauthcd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISOAUTHCD(String value) {
        this.isoauthcd = value;
    }

    /**
     * Gets the value of the datatrans property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDATATRANS() {
        return datatrans;
    }

    /**
     * Sets the value of the datatrans property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDATATRANS(String value) {
        this.datatrans = value;
    }

    /**
     * Gets the value of the horatrans property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHORATRANS() {
        return horatrans;
    }

    /**
     * Sets the value of the horatrans property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHORATRANS(String value) {
        this.horatrans = value;
    }

    /**
     * Gets the value of the nrcartao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNRCARTAO() {
        return nrcartao;
    }

    /**
     * Sets the value of the nrcartao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNRCARTAO(String value) {
        this.nrcartao = value;
    }

    /**
     * Gets the value of the paistrans property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAISTRANS() {
        return paistrans;
    }

    /**
     * Sets the value of the paistrans property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAISTRANS(String value) {
        this.paistrans = value;
    }

    /**
     * Gets the value of the paiscartao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAISCARTAO() {
        return paiscartao;
    }

    /**
     * Sets the value of the paiscartao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAISCARTAO(String value) {
        this.paiscartao = value;
    }

    /**
     * Gets the value of the isoaccnme property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISOACCNME() {
        return isoaccnme;
    }

    /**
     * Sets the value of the isoaccnme property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISOACCNME(String value) {
        this.isoaccnme = value;
    }

    /**
     * Gets the value of the isocurrcd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISOCURRCD() {
        return isocurrcd;
    }

    /**
     * Sets the value of the isocurrcd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISOCURRCD(String value) {
        this.isocurrcd = value;
    }

    /**
     * Gets the value of the isotranamt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISOTRANAMT() {
        return isotranamt;
    }

    /**
     * Sets the value of the isotranamt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISOTRANAMT(String value) {
        this.isotranamt = value;
    }

    /**
     * Gets the value of the isoconvrt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISOCONVRT() {
        return isoconvrt;
    }

    /**
     * Sets the value of the isoconvrt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISOCONVRT(String value) {
        this.isoconvrt = value;
    }

    /**
     * Gets the value of the isocbamtbil property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISOCBAMTBIL() {
        return isocbamtbil;
    }

    /**
     * Sets the value of the isocbamtbil property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISOCBAMTBIL(String value) {
        this.isocbamtbil = value;
    }

    /**
     * Gets the value of the isocbamtdev property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISOCBAMTDEV() {
        return isocbamtdev;
    }

    /**
     * Sets the value of the isocbamtdev property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISOCBAMTDEV(String value) {
        this.isocbamtdev = value;
    }

    /**
     * Gets the value of the isocbamtact property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISOCBAMTACT() {
        return isocbamtact;
    }

    /**
     * Sets the value of the isocbamtact property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISOCBAMTACT(String value) {
        this.isocbamtact = value;
    }

    /**
     * Gets the value of the isostlcurr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISOSTLCURR() {
        return isostlcurr;
    }

    /**
     * Sets the value of the isostlcurr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISOSTLCURR(String value) {
        this.isostlcurr = value;
    }

    /**
     * Gets the value of the isostlamt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISOSTLAMT() {
        return isostlamt;
    }

    /**
     * Sets the value of the isostlamt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISOSTLAMT(String value) {
        this.isostlamt = value;
    }

    /**
     * Gets the value of the isostlconv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISOSTLCONV() {
        return isostlconv;
    }

    /**
     * Sets the value of the isostlconv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISOSTLCONV(String value) {
        this.isostlconv = value;
    }

    /**
     * Gets the value of the isoactbal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISOACTBAL() {
        return isoactbal;
    }

    /**
     * Sets the value of the isoactbal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISOACTBAL(String value) {
        this.isoactbal = value;
    }

    /**
     * Gets the value of the isoavailbal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISOAVAILBAL() {
        return isoavailbal;
    }

    /**
     * Sets the value of the isoavailbal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISOAVAILBAL(String value) {
        this.isoavailbal = value;
    }

    /**
     * Gets the value of the isoprn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISOPRN() {
        return isoprn;
    }

    /**
     * Sets the value of the isoprn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISOPRN(String value) {
        this.isoprn = value;
    }

    /**
     * Gets the value of the isostan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISOSTAN() {
        return isostan;
    }

    /**
     * Sets the value of the isostan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISOSTAN(String value) {
        this.isostan = value;
    }

    /**
     * Gets the value of the isotxntype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISOTXNTYPE() {
        return isotxntype;
    }

    /**
     * Sets the value of the isotxntype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISOTXNTYPE(String value) {
        this.isotxntype = value;
    }

    /**
     * Gets the value of the isotermtype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISOTERMTYPE() {
        return isotermtype;
    }

    /**
     * Sets the value of the isotermtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISOTERMTYPE(String value) {
        this.isotermtype = value;
    }

    /**
     * Gets the value of the isotermid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISOTERMID() {
        return isotermid;
    }

    /**
     * Sets the value of the isotermid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISOTERMID(String value) {
        this.isotermid = value;
    }

    /**
     * Gets the value of the acqimd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACQIMD() {
        return acqimd;
    }

    /**
     * Sets the value of the acqimd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACQIMD(String value) {
        this.acqimd = value;
    }

    /**
     * Gets the value of the isocontrycode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISOCONTRYCODE() {
        return isocontrycode;
    }

    /**
     * Sets the value of the isocontrycode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISOCONTRYCODE(String value) {
        this.isocontrycode = value;
    }

    /**
     * Gets the value of the contribuicoes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCONTRIBUICOES() {
        return contribuicoes;
    }

    /**
     * Sets the value of the contribuicoes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCONTRIBUICOES(String value) {
        this.contribuicoes = value;
    }

    /**
     * Gets the value of the multa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMULTA() {
        return multa;
    }

    /**
     * Sets the value of the multa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMULTA(String value) {
        this.multa = value;
    }

    /**
     * Gets the value of the jurosmora property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJUROSMORA() {
        return jurosmora;
    }

    /**
     * Sets the value of the jurosmora property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJUROSMORA(String value) {
        this.jurosmora = value;
    }

    /**
     * Gets the value of the adicionais property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getADICIONAIS() {
        return adicionais;
    }

    /**
     * Sets the value of the adicionais property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setADICIONAIS(String value) {
        this.adicionais = value;
    }

    /**
     * Gets the value of the inssrel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINSSREL() {
        return inssrel;
    }

    /**
     * Sets the value of the inssrel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINSSREL(String value) {
        this.inssrel = value;
    }

    /**
     * Gets the value of the lockeventid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLOCKEVENTID() {
        return lockeventid;
    }

    /**
     * Sets the value of the lockeventid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLOCKEVENTID(String value) {
        this.lockeventid = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDATE() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDATE(String value) {
        this.date = value;
    }

    /**
     * Gets the value of the depositor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDEPOSITOR() {
        return depositor;
    }

    /**
     * Sets the value of the depositor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDEPOSITOR(String value) {
        this.depositor = value;
    }

    /**
     * Gets the value of the orderdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getORDERDATE() {
        return orderdate;
    }

    /**
     * Sets the value of the orderdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setORDERDATE(String value) {
        this.orderdate = value;
    }

    /**
     * Gets the value of the gbtbfourhundred property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GBTBFOURHUNDRED }
     *     
     */
    public FUNDSTRANSFERType.GBTBFOURHUNDRED getGBTBFOURHUNDRED() {
        return gbtbfourhundred;
    }

    /**
     * Sets the value of the gbtbfourhundred property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GBTBFOURHUNDRED }
     *     
     */
    public void setGBTBFOURHUNDRED(FUNDSTRANSFERType.GBTBFOURHUNDRED value) {
        this.gbtbfourhundred = value;
    }

    /**
     * Gets the value of the ordernib property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getORDERNIB() {
        return ordernib;
    }

    /**
     * Sets the value of the ordernib property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setORDERNIB(String value) {
        this.ordernib = value;
    }

    /**
     * Gets the value of the flagnib property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFLAGNIB() {
        return flagnib;
    }

    /**
     * Sets the value of the flagnib property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFLAGNIB(String value) {
        this.flagnib = value;
    }

    /**
     * Gets the value of the iban property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIBAN() {
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
    public void setIBAN(String value) {
        this.iban = value;
    }

    /**
     * Gets the value of the benefnib property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBENEFNIB() {
        return benefnib;
    }

    /**
     * Sets the value of the benefnib property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBENEFNIB(String value) {
        this.benefnib = value;
    }

    /**
     * Gets the value of the gwordamt property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GWORDAMT }
     *     
     */
    public FUNDSTRANSFERType.GWORDAMT getGWORDAMT() {
        return gwordamt;
    }

    /**
     * Sets the value of the gwordamt property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GWORDAMT }
     *     
     */
    public void setGWORDAMT(FUNDSTRANSFERType.GWORDAMT value) {
        this.gwordamt = value;
    }

    /**
     * Gets the value of the bmcorresporig property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBMCORRESPORIG() {
        return bmcorresporig;
    }

    /**
     * Sets the value of the bmcorresporig property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBMCORRESPORIG(String value) {
        this.bmcorresporig = value;
    }

    /**
     * Gets the value of the bmcorrespdest property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBMCORRESPDEST() {
        return bmcorrespdest;
    }

    /**
     * Sets the value of the bmcorrespdest property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBMCORRESPDEST(String value) {
        this.bmcorrespdest = value;
    }

    /**
     * Gets the value of the sbclosedate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSBCLOSEDATE() {
        return sbclosedate;
    }

    /**
     * Sets the value of the sbclosedate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSBCLOSEDATE(String value) {
        this.sbclosedate = value;
    }

    /**
     * Gets the value of the sbopendate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSBOPENDATE() {
        return sbopendate;
    }

    /**
     * Sets the value of the sbopendate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSBOPENDATE(String value) {
        this.sbopendate = value;
    }

    /**
     * Gets the value of the sbvatnumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSBVATNUMBER() {
        return sbvatnumber;
    }

    /**
     * Sets the value of the sbvatnumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSBVATNUMBER(String value) {
        this.sbvatnumber = value;
    }

    /**
     * Gets the value of the sbassettype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSBASSETTYPE() {
        return sbassettype;
    }

    /**
     * Sets the value of the sbassettype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSBASSETTYPE(String value) {
        this.sbassettype = value;
    }

    /**
     * Gets the value of the sbtaxtype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSBTAXTYPE() {
        return sbtaxtype;
    }

    /**
     * Sets the value of the sbtaxtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSBTAXTYPE(String value) {
        this.sbtaxtype = value;
    }

    /**
     * Gets the value of the nrnuit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNRNUIT() {
        return nrnuit;
    }

    /**
     * Sets the value of the nrnuit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNRNUIT(String value) {
        this.nrnuit = value;
    }

    /**
     * Gets the value of the confirmation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCONFIRMATION() {
        return confirmation;
    }

    /**
     * Sets the value of the confirmation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCONFIRMATION(String value) {
        this.confirmation = value;
    }

    /**
     * Gets the value of the benefnuit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBENEFNUIT() {
        return benefnuit;
    }

    /**
     * Sets the value of the benefnuit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBENEFNUIT(String value) {
        this.benefnuit = value;
    }

    /**
     * Gets the value of the benefiban property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBENEFIBAN() {
        return benefiban;
    }

    /**
     * Sets the value of the benefiban property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBENEFIBAN(String value) {
        this.benefiban = value;
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
     * Gets the value of the msgid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMSGID() {
        return msgid;
    }

    /**
     * Sets the value of the msgid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMSGID(String value) {
        this.msgid = value;
    }

    /**
     * Gets the value of the crdimd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCRDIMD() {
        return crdimd;
    }

    /**
     * Sets the value of the crdimd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCRDIMD(String value) {
        this.crdimd = value;
    }

    /**
     * Gets the value of the crdbrcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCRDBRCODE() {
        return crdbrcode;
    }

    /**
     * Sets the value of the crdbrcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCRDBRCODE(String value) {
        this.crdbrcode = value;
    }

    /**
     * Gets the value of the crdnumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCRDNUMBER() {
        return crdnumber;
    }

    /**
     * Sets the value of the crdnumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCRDNUMBER(String value) {
        this.crdnumber = value;
    }

    /**
     * Gets the value of the reference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREFERENCE() {
        return reference;
    }

    /**
     * Sets the value of the reference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREFERENCE(String value) {
        this.reference = value;
    }

    /**
     * Gets the value of the nrcarregamento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNRCARREGAMENTO() {
        return nrcarregamento;
    }

    /**
     * Sets the value of the nrcarregamento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNRCARREGAMENTO(String value) {
        this.nrcarregamento = value;
    }

    /**
     * Gets the value of the sticketnumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTICKETNUMBER() {
        return sticketnumber;
    }

    /**
     * Sets the value of the sticketnumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTICKETNUMBER(String value) {
        this.sticketnumber = value;
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
     * Gets the value of the traceno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTRACENO() {
        return traceno;
    }

    /**
     * Sets the value of the traceno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTRACENO(String value) {
        this.traceno = value;
    }

    /**
     * Gets the value of the batchid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBATCHID() {
        return batchid;
    }

    /**
     * Sets the value of the batchid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBATCHID(String value) {
        this.batchid = value;
    }

    /**
     * Gets the value of the batchitemid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBATCHITEMID() {
        return batchitemid;
    }

    /**
     * Sets the value of the batchitemid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBATCHITEMID(String value) {
        this.batchitemid = value;
    }

    /**
     * Gets the value of the isentocomissao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISENTOCOMISSAO() {
        return isentocomissao;
    }

    /**
     * Sets the value of the isentocomissao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISENTOCOMISSAO(String value) {
        this.isentocomissao = value;
    }

    /**
     * Gets the value of the fontefinancto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFONTEFINANCTO() {
        return fontefinancto;
    }

    /**
     * Sets the value of the fontefinancto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFONTEFINANCTO(String value) {
        this.fontefinancto = value;
    }

    /**
     * Gets the value of the repaymentacct property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREPAYMENTACCT() {
        return repaymentacct;
    }

    /**
     * Sets the value of the repaymentacct property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREPAYMENTACCT(String value) {
        this.repaymentacct = value;
    }

    /**
     * Gets the value of the nrsolicitacao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNRSOLICITACAO() {
        return nrsolicitacao;
    }

    /**
     * Sets the value of the nrsolicitacao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNRSOLICITACAO(String value) {
        this.nrsolicitacao = value;
    }

    /**
     * Gets the value of the gsbtowncountry property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GSBTOWNCOUNTRY }
     *     
     */
    public FUNDSTRANSFERType.GSBTOWNCOUNTRY getGSBTOWNCOUNTRY() {
        return gsbtowncountry;
    }

    /**
     * Sets the value of the gsbtowncountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GSBTOWNCOUNTRY }
     *     
     */
    public void setGSBTOWNCOUNTRY(FUNDSTRANSFERType.GSBTOWNCOUNTRY value) {
        this.gsbtowncountry = value;
    }

    /**
     * Gets the value of the codmsg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCODMSG() {
        return codmsg;
    }

    /**
     * Sets the value of the codmsg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCODMSG(String value) {
        this.codmsg = value;
    }

    /**
     * Gets the value of the vermsg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVERMSG() {
        return vermsg;
    }

    /**
     * Sets the value of the vermsg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVERMSG(String value) {
        this.vermsg = value;
    }

    /**
     * Gets the value of the tipoterm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTIPOTERM() {
        return tipoterm;
    }

    /**
     * Sets the value of the tipoterm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTIPOTERM(String value) {
        this.tipoterm = value;
    }

    /**
     * Gets the value of the dhmsg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDHMSG() {
        return dhmsg;
    }

    /**
     * Sets the value of the dhmsg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDHMSG(String value) {
        this.dhmsg = value;
    }

    /**
     * Gets the value of the tipoaut property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTIPOAUT() {
        return tipoaut;
    }

    /**
     * Sets the value of the tipoaut property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTIPOAUT(String value) {
        this.tipoaut = value;
    }

    /**
     * Gets the value of the idterminal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDTERMINAL() {
        return idterminal;
    }

    /**
     * Sets the value of the idterminal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDTERMINAL(String value) {
        this.idterminal = value;
    }

    /**
     * Gets the value of the locterm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLOCTERM() {
        return locterm;
    }

    /**
     * Sets the value of the locterm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLOCTERM(String value) {
        this.locterm = value;
    }

    /**
     * Gets the value of the pvv2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPVV2() {
        return pvv2;
    }

    /**
     * Sets the value of the pvv2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPVV2(String value) {
        this.pvv2 = value;
    }

    /**
     * Gets the value of the pvv3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPVV3() {
        return pvv3;
    }

    /**
     * Sets the value of the pvv3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPVV3(String value) {
        this.pvv3 = value;
    }

    /**
     * Gets the value of the idaceitante property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDACEITANTE() {
        return idaceitante;
    }

    /**
     * Sets the value of the idaceitante property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDACEITANTE(String value) {
        this.idaceitante = value;
    }

    /**
     * Gets the value of the montind property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMONTIND() {
        return montind;
    }

    /**
     * Sets the value of the montind property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMONTIND(String value) {
        this.montind = value;
    }

    /**
     * Gets the value of the idprop property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDPROP() {
        return idprop;
    }

    /**
     * Sets the value of the idprop property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDPROP(String value) {
        this.idprop = value;
    }

    /**
     * Gets the value of the retref property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRETREF() {
        return retref;
    }

    /**
     * Sets the value of the retref property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRETREF(String value) {
        this.retref = value;
    }

    /**
     * Gets the value of the natoper property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNATOPER() {
        return natoper;
    }

    /**
     * Sets the value of the natoper property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNATOPER(String value) {
        this.natoper = value;
    }

    /**
     * Gets the value of the dthora property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDTHORA() {
        return dthora;
    }

    /**
     * Sets the value of the dthora property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDTHORA(String value) {
        this.dthora = value;
    }

    /**
     * Gets the value of the seqmov property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSEQMOV() {
        return seqmov;
    }

    /**
     * Sets the value of the seqmov property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSEQMOV(String value) {
        this.seqmov = value;
    }

    /**
     * Gets the value of the datexp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDATEXP() {
        return datexp;
    }

    /**
     * Sets the value of the datexp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDATEXP(String value) {
        this.datexp = value;
    }

    /**
     * Gets the value of the seqpan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSEQPAN() {
        return seqpan;
    }

    /**
     * Sets the value of the seqpan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSEQPAN(String value) {
        this.seqpan = value;
    }

    /**
     * Gets the value of the conta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCONTA() {
        return conta;
    }

    /**
     * Sets the value of the conta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCONTA(String value) {
        this.conta = value;
    }

    /**
     * Gets the value of the nomecli property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNOMECLI() {
        return nomecli;
    }

    /**
     * Sets the value of the nomecli property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNOMECLI(String value) {
        this.nomecli = value;
    }

    /**
     * Gets the value of the nsitcar property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNSITCAR() {
        return nsitcar;
    }

    /**
     * Sets the value of the nsitcar property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNSITCAR(String value) {
        this.nsitcar = value;
    }

    /**
     * Gets the value of the modins property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMODINS() {
        return modins;
    }

    /**
     * Sets the value of the modins property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMODINS(String value) {
        this.modins = value;
    }

    /**
     * Gets the value of the mcc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMCC() {
        return mcc;
    }

    /**
     * Sets the value of the mcc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMCC(String value) {
        this.mcc = value;
    }

    /**
     * Gets the value of the distconc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDISTCONC() {
        return distconc;
    }

    /**
     * Sets the value of the distconc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDISTCONC(String value) {
        this.distconc = value;
    }

    /**
     * Gets the value of the motcapt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMOTCAPT() {
        return motcapt;
    }

    /**
     * Sets the value of the motcapt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMOTCAPT(String value) {
        this.motcapt = value;
    }

    /**
     * Gets the value of the senha property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSENHA() {
        return senha;
    }

    /**
     * Sets the value of the senha property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSENHA(String value) {
        this.senha = value;
    }

    /**
     * Gets the value of the refdep property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREFDEP() {
        return refdep;
    }

    /**
     * Sets the value of the refdep property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREFDEP(String value) {
        this.refdep = value;
    }

    /**
     * Gets the value of the sistag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSISTAG() {
        return sistag;
    }

    /**
     * Sets the value of the sistag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSISTAG(String value) {
        this.sistag = value;
    }

    /**
     * Gets the value of the codpais property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCODPAIS() {
        return codpais;
    }

    /**
     * Sets the value of the codpais property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCODPAIS(String value) {
        this.codpais = value;
    }

    /**
     * Gets the value of the codmoeda property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCODMOEDA() {
        return codmoeda;
    }

    /**
     * Sets the value of the codmoeda property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCODMOEDA(String value) {
        this.codmoeda = value;
    }

    /**
     * Gets the value of the cambio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCAMBIO() {
        return cambio;
    }

    /**
     * Sets the value of the cambio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCAMBIO(String value) {
        this.cambio = value;
    }

    /**
     * Gets the value of the importop property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIMPORTOP() {
        return importop;
    }

    /**
     * Sets the value of the importop property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIMPORTOP(String value) {
        this.importop = value;
    }

    /**
     * Gets the value of the valtotal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVALTOTAL() {
        return valtotal;
    }

    /**
     * Sets the value of the valtotal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVALTOTAL(String value) {
        this.valtotal = value;
    }

    /**
     * Gets the value of the banapoio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBANAPOIO() {
        return banapoio;
    }

    /**
     * Sets the value of the banapoio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBANAPOIO(String value) {
        this.banapoio = value;
    }

    /**
     * Gets the value of the refpag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREFPAG() {
        return refpag;
    }

    /**
     * Sets the value of the refpag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREFPAG(String value) {
        this.refpag = value;
    }

    /**
     * Gets the value of the descse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDESCSE() {
        return descse;
    }

    /**
     * Sets the value of the descse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDESCSE(String value) {
        this.descse = value;
    }

    /**
     * Gets the value of the tipser property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTIPSER() {
        return tipser;
    }

    /**
     * Sets the value of the tipser property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTIPSER(String value) {
        this.tipser = value;
    }

    /**
     * Gets the value of the nibdest property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNIBDEST() {
        return nibdest;
    }

    /**
     * Sets the value of the nibdest property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNIBDEST(String value) {
        this.nibdest = value;
    }

    /**
     * Gets the value of the sinal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSINAL() {
        return sinal;
    }

    /**
     * Sets the value of the sinal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSINAL(String value) {
        this.sinal = value;
    }

    /**
     * Gets the value of the idcomemp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDCOMEMP() {
        return idcomemp;
    }

    /**
     * Sets the value of the idcomemp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDCOMEMP(String value) {
        this.idcomemp = value;
    }

    /**
     * Gets the value of the idest property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDEST() {
        return idest;
    }

    /**
     * Sets the value of the idest property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDEST(String value) {
        this.idest = value;
    }

    /**
     * Gets the value of the prodfin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRODFIN() {
        return prodfin;
    }

    /**
     * Sets the value of the prodfin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRODFIN(String value) {
        this.prodfin = value;
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
     * Gets the value of the nibord property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNIBORD() {
        return nibord;
    }

    /**
     * Sets the value of the nibord property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNIBORD(String value) {
        this.nibord = value;
    }

    /**
     * Gets the value of the creddest property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCREDDEST() {
        return creddest;
    }

    /**
     * Sets the value of the creddest property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCREDDEST(String value) {
        this.creddest = value;
    }

    /**
     * Gets the value of the codtrne property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCODTRNE() {
        return codtrne;
    }

    /**
     * Sets the value of the codtrne property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCODTRNE(String value) {
        this.codtrne = value;
    }

    /**
     * Gets the value of the pinblock property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPINBLOCK() {
        return pinblock;
    }

    /**
     * Sets the value of the pinblock property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPINBLOCK(String value) {
        this.pinblock = value;
    }

    /**
     * Gets the value of the expp2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEXPP2() {
        return expp2;
    }

    /**
     * Sets the value of the expp2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEXPP2(String value) {
        this.expp2 = value;
    }

    /**
     * Gets the value of the compp2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOMPP2() {
        return compp2;
    }

    /**
     * Sets the value of the compp2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOMPP2(String value) {
        this.compp2 = value;
    }

    /**
     * Gets the value of the pista2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPISTA2() {
        return pista2;
    }

    /**
     * Sets the value of the pista2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPISTA2(String value) {
        this.pista2 = value;
    }

    /**
     * Gets the value of the dtiniaplic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDTINIAPLIC() {
        return dtiniaplic;
    }

    /**
     * Sets the value of the dtiniaplic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDTINIAPLIC(String value) {
        this.dtiniaplic = value;
    }

    /**
     * Gets the value of the carterm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCARTERM() {
        return carterm;
    }

    /**
     * Sets the value of the carterm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCARTERM(String value) {
        this.carterm = value;
    }

    /**
     * Gets the value of the captermacq property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCAPTERMACQ() {
        return captermacq;
    }

    /**
     * Sets the value of the captermacq property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCAPTERMACQ(String value) {
        this.captermacq = value;
    }

    /**
     * Gets the value of the appcounter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAPPCOUNTER() {
        return appcounter;
    }

    /**
     * Sets the value of the appcounter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAPPCOUNTER(String value) {
        this.appcounter = value;
    }

    /**
     * Gets the value of the appprofile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAPPPROFILE() {
        return appprofile;
    }

    /**
     * Sets the value of the appprofile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAPPPROFILE(String value) {
        this.appprofile = value;
    }

    /**
     * Gets the value of the tipocrip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTIPOCRIP() {
        return tipocrip;
    }

    /**
     * Sets the value of the tipocrip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTIPOCRIP(String value) {
        this.tipocrip = value;
    }

    /**
     * Gets the value of the criptograma property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCRIPTOGRAMA() {
        return criptograma;
    }

    /**
     * Sets the value of the criptograma property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCRIPTOGRAMA(String value) {
        this.criptograma = value;
    }

    /**
     * Gets the value of the issapdata property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISSAPDATA() {
        return issapdata;
    }

    /**
     * Sets the value of the issapdata property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISSAPDATA(String value) {
        this.issapdata = value;
    }

    /**
     * Gets the value of the tvr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTVR() {
        return tvr;
    }

    /**
     * Sets the value of the tvr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTVR(String value) {
        this.tvr = value;
    }

    /**
     * Gets the value of the nrseqpan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNRSEQPAN() {
        return nrseqpan;
    }

    /**
     * Sets the value of the nrseqpan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNRSEQPAN(String value) {
        this.nrseqpan = value;
    }

    /**
     * Gets the value of the idcomrep property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDCOMREP() {
        return idcomrep;
    }

    /**
     * Sets the value of the idcomrep property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDCOMREP(String value) {
        this.idcomrep = value;
    }

    /**
     * Gets the value of the criptinf property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCRIPTINF() {
        return criptinf;
    }

    /**
     * Sets the value of the criptinf property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCRIPTINF(String value) {
        this.criptinf = value;
    }

    /**
     * Gets the value of the cvmresults property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCVMRESULTS() {
        return cvmresults;
    }

    /**
     * Sets the value of the cvmresults property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCVMRESULTS(String value) {
        this.cvmresults = value;
    }

    /**
     * Gets the value of the dfname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDFNAME() {
        return dfname;
    }

    /**
     * Sets the value of the dfname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDFNAME(String value) {
        this.dfname = value;
    }

    /**
     * Gets the value of the aplicn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAPLICN() {
        return aplicn;
    }

    /**
     * Sets the value of the aplicn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAPLICN(String value) {
        this.aplicn = value;
    }

    /**
     * Gets the value of the emvpadrao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEMVPADRAO() {
        return emvpadrao;
    }

    /**
     * Sets the value of the emvpadrao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEMVPADRAO(String value) {
        this.emvpadrao = value;
    }

    /**
     * Gets the value of the fidelizacaoid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFIDELIZACAOID() {
        return fidelizacaoid;
    }

    /**
     * Sets the value of the fidelizacaoid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFIDELIZACAOID(String value) {
        this.fidelizacaoid = value;
    }

    /**
     * Gets the value of the indtippag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINDTIPPAG() {
        return indtippag;
    }

    /**
     * Sets the value of the indtippag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINDTIPPAG(String value) {
        this.indtippag = value;
    }

    /**
     * Gets the value of the creprestcli property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCREPRESTCLI() {
        return creprestcli;
    }

    /**
     * Sets the value of the creprestcli property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCREPRESTCLI(String value) {
        this.creprestcli = value;
    }

    /**
     * Gets the value of the fidpontosreb property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFIDPONTOSREB() {
        return fidpontosreb;
    }

    /**
     * Sets the value of the fidpontosreb property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFIDPONTOSREB(String value) {
        this.fidpontosreb = value;
    }

    /**
     * Gets the value of the fidpontosdis property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFIDPONTOSDIS() {
        return fidpontosdis;
    }

    /**
     * Sets the value of the fidpontosdis property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFIDPONTOSDIS(String value) {
        this.fidpontosdis = value;
    }

    /**
     * Gets the value of the fidvalorpont property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFIDVALORPONT() {
        return fidvalorpont;
    }

    /**
     * Sets the value of the fidvalorpont property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFIDVALORPONT(String value) {
        this.fidvalorpont = value;
    }

    /**
     * Gets the value of the fidvalorrem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFIDVALORREM() {
        return fidvalorrem;
    }

    /**
     * Sets the value of the fidvalorrem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFIDVALORREM(String value) {
        this.fidvalorrem = value;
    }

    /**
     * Gets the value of the comppan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOMPPAN() {
        return comppan;
    }

    /**
     * Sets the value of the comppan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOMPPAN(String value) {
        this.comppan = value;
    }

    /**
     * Gets the value of the pan property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAN() {
        return pan;
    }

    /**
     * Sets the value of the pan property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAN(String value) {
        this.pan = value;
    }

    /**
     * Gets the value of the mnte property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMNTE() {
        return mnte;
    }

    /**
     * Sets the value of the mnte property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMNTE(String value) {
        this.mnte = value;
    }

    /**
     * Gets the value of the mntadi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMNTADI() {
        return mntadi;
    }

    /**
     * Sets the value of the mntadi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMNTADI(String value) {
        this.mntadi = value;
    }

    /**
     * Gets the value of the totopere property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTOTOPERE() {
        return totopere;
    }

    /**
     * Sets the value of the totopere property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTOTOPERE(String value) {
        this.totopere = value;
    }

    /**
     * Gets the value of the compdadosv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOMPDADOSV() {
        return compdadosv;
    }

    /**
     * Sets the value of the compdadosv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOMPDADOSV(String value) {
        this.compdadosv = value;
    }

    /**
     * Gets the value of the verdadosv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVERDADOSV() {
        return verdadosv;
    }

    /**
     * Sets the value of the verdadosv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVERDADOSV(String value) {
        this.verdadosv = value;
    }

    /**
     * Gets the value of the capterm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCAPTERM() {
        return capterm;
    }

    /**
     * Sets the value of the capterm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCAPTERM(String value) {
        this.capterm = value;
    }

    /**
     * Gets the value of the unpnr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUNPNR() {
        return unpnr;
    }

    /**
     * Sets the value of the unpnr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUNPNR(String value) {
        this.unpnr = value;
    }

    /**
     * Gets the value of the aplicpdd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAPLICPDD() {
        return aplicpdd;
    }

    /**
     * Sets the value of the aplicpdd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAPLICPDD(String value) {
        this.aplicpdd = value;
    }

    /**
     * Gets the value of the comemi1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOMEMI1() {
        return comemi1;
    }

    /**
     * Sets the value of the comemi1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOMEMI1(String value) {
        this.comemi1 = value;
    }

    /**
     * Gets the value of the comemi2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOMEMI2() {
        return comemi2;
    }

    /**
     * Sets the value of the comemi2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOMEMI2(String value) {
        this.comemi2 = value;
    }

    /**
     * Gets the value of the comprop1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOMPROP1() {
        return comprop1;
    }

    /**
     * Sets the value of the comprop1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOMPROP1(String value) {
        this.comprop1 = value;
    }

    /**
     * Gets the value of the comprop2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOMPROP2() {
        return comprop2;
    }

    /**
     * Sets the value of the comprop2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOMPROP2(String value) {
        this.comprop2 = value;
    }

    /**
     * Gets the value of the montante1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMONTANTE1() {
        return montante1;
    }

    /**
     * Sets the value of the montante1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMONTANTE1(String value) {
        this.montante1 = value;
    }

    /**
     * Gets the value of the montante2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMONTANTE2() {
        return montante2;
    }

    /**
     * Sets the value of the montante2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMONTANTE2(String value) {
        this.montante2 = value;
    }

    /**
     * Gets the value of the taxacli1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTAXACLI1() {
        return taxacli1;
    }

    /**
     * Sets the value of the taxacli1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTAXACLI1(String value) {
        this.taxacli1 = value;
    }

    /**
     * Gets the value of the taxacli2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTAXACLI2() {
        return taxacli2;
    }

    /**
     * Sets the value of the taxacli2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTAXACLI2(String value) {
        this.taxacli2 = value;
    }

    /**
     * Gets the value of the pgtoantecipado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPGTOANTECIPADO() {
        return pgtoantecipado;
    }

    /**
     * Sets the value of the pgtoantecipado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPGTOANTECIPADO(String value) {
        this.pgtoantecipado = value;
    }

    /**
     * Gets the value of the saloperator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSALOPERATOR() {
        return saloperator;
    }

    /**
     * Sets the value of the saloperator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSALOPERATOR(String value) {
        this.saloperator = value;
    }

    /**
     * Gets the value of the sbtrrateref property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSBTRRATEREF() {
        return sbtrrateref;
    }

    /**
     * Sets the value of the sbtrrateref property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSBTRRATEREF(String value) {
        this.sbtrrateref = value;
    }

    /**
     * Gets the value of the sbchannel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSBCHANNEL() {
        return sbchannel;
    }

    /**
     * Sets the value of the sbchannel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSBCHANNEL(String value) {
        this.sbchannel = value;
    }

    /**
     * Gets the value of the origorderacct property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getORIGORDERACCT() {
        return origorderacct;
    }

    /**
     * Sets the value of the origorderacct property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setORIGORDERACCT(String value) {
        this.origorderacct = value;
    }

    /**
     * Gets the value of the wfinputter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWFINPUTTER() {
        return wfinputter;
    }

    /**
     * Sets the value of the wfinputter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWFINPUTTER(String value) {
        this.wfinputter = value;
    }

    /**
     * Gets the value of the wfauthoriser property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWFAUTHORISER() {
        return wfauthoriser;
    }

    /**
     * Sets the value of the wfauthoriser property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWFAUTHORISER(String value) {
        this.wfauthoriser = value;
    }

    /**
     * Gets the value of the wfid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWFID() {
        return wfid;
    }

    /**
     * Sets the value of the wfid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWFID(String value) {
        this.wfid = value;
    }

    /**
     * Gets the value of the calyplogref property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCALYPLOGREF() {
        return calyplogref;
    }

    /**
     * Sets the value of the calyplogref property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCALYPLOGREF(String value) {
        this.calyplogref = value;
    }

    /**
     * Gets the value of the calypsocusname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCALYPSOCUSNAME() {
        return calypsocusname;
    }

    /**
     * Sets the value of the calypsocusname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCALYPSOCUSNAME(String value) {
        this.calypsocusname = value;
    }

    /**
     * Gets the value of the debitacname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDEBITACNAME() {
        return debitacname;
    }

    /**
     * Sets the value of the debitacname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDEBITACNAME(String value) {
        this.debitacname = value;
    }

    /**
     * Gets the value of the nbolorderref property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNBOLORDERREF() {
        return nbolorderref;
    }

    /**
     * Sets the value of the nbolorderref property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNBOLORDERREF(String value) {
        this.nbolorderref = value;
    }

    /**
     * Gets the value of the nbolactref property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNBOLACTREF() {
        return nbolactref;
    }

    /**
     * Sets the value of the nbolactref property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNBOLACTREF(String value) {
        this.nbolactref = value;
    }

    /**
     * Gets the value of the nbolparenttxn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNBOLPARENTTXN() {
        return nbolparenttxn;
    }

    /**
     * Sets the value of the nbolparenttxn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNBOLPARENTTXN(String value) {
        this.nbolparenttxn = value;
    }

    /**
     * Gets the value of the drbankbic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDRBANKBIC() {
        return drbankbic;
    }

    /**
     * Sets the value of the drbankbic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDRBANKBIC(String value) {
        this.drbankbic = value;
    }

    /**
     * Gets the value of the crbankbic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCRBANKBIC() {
        return crbankbic;
    }

    /**
     * Sets the value of the crbankbic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCRBANKBIC(String value) {
        this.crbankbic = value;
    }

    /**
     * Gets the value of the drbankscode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDRBANKSCODE() {
        return drbankscode;
    }

    /**
     * Sets the value of the drbankscode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDRBANKSCODE(String value) {
        this.drbankscode = value;
    }

    /**
     * Gets the value of the crbankscode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCRBANKSCODE() {
        return crbankscode;
    }

    /**
     * Sets the value of the crbankscode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCRBANKSCODE(String value) {
        this.crbankscode = value;
    }

    /**
     * Gets the value of the destacctno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDESTACCTNO() {
        return destacctno;
    }

    /**
     * Sets the value of the destacctno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDESTACCTNO(String value) {
        this.destacctno = value;
    }

    /**
     * Gets the value of the totalcrcnt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTOTALCRCNT() {
        return totalcrcnt;
    }

    /**
     * Sets the value of the totalcrcnt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTOTALCRCNT(String value) {
        this.totalcrcnt = value;
    }

    /**
     * Gets the value of the totlonusdramt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTOTLONUSDRAMT() {
        return totlonusdramt;
    }

    /**
     * Sets the value of the totlonusdramt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTOTLONUSDRAMT(String value) {
        this.totlonusdramt = value;
    }

    /**
     * Gets the value of the totlofusdramt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTOTLOFUSDRAMT() {
        return totlofusdramt;
    }

    /**
     * Sets the value of the totlofusdramt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTOTLOFUSDRAMT(String value) {
        this.totlofusdramt = value;
    }

    /**
     * Gets the value of the onuscrcnt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getONUSCRCNT() {
        return onuscrcnt;
    }

    /**
     * Sets the value of the onuscrcnt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setONUSCRCNT(String value) {
        this.onuscrcnt = value;
    }

    /**
     * Gets the value of the offuscrcnt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOFFUSCRCNT() {
        return offuscrcnt;
    }

    /**
     * Sets the value of the offuscrcnt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOFFUSCRCNT(String value) {
        this.offuscrcnt = value;
    }

    /**
     * Gets the value of the uniquemsgid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUNIQUEMSGID() {
        return uniquemsgid;
    }

    /**
     * Sets the value of the uniquemsgid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUNIQUEMSGID(String value) {
        this.uniquemsgid = value;
    }

    /**
     * Gets the value of the payexmsgid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAYEXMSGID() {
        return payexmsgid;
    }

    /**
     * Sets the value of the payexmsgid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAYEXMSGID(String value) {
        this.payexmsgid = value;
    }

    /**
     * Gets the value of the coddistrict property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCODDISTRICT() {
        return coddistrict;
    }

    /**
     * Sets the value of the coddistrict property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCODDISTRICT(String value) {
        this.coddistrict = value;
    }

    /**
     * Gets the value of the codrevenue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCODREVENUE() {
        return codrevenue;
    }

    /**
     * Sets the value of the codrevenue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCODREVENUE(String value) {
        this.codrevenue = value;
    }

    /**
     * Gets the value of the codconsmuni property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCODCONSMUNI() {
        return codconsmuni;
    }

    /**
     * Sets the value of the codconsmuni property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCODCONSMUNI(String value) {
        this.codconsmuni = value;
    }

    /**
     * Gets the value of the gsbordcusaddr property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GSBORDCUSADDR }
     *     
     */
    public FUNDSTRANSFERType.GSBORDCUSADDR getGSBORDCUSADDR() {
        return gsbordcusaddr;
    }

    /**
     * Sets the value of the gsbordcusaddr property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GSBORDCUSADDR }
     *     
     */
    public void setGSBORDCUSADDR(FUNDSTRANSFERType.GSBORDCUSADDR value) {
        this.gsbordcusaddr = value;
    }

    /**
     * Gets the value of the stotaltaxamt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTOTALTAXAMT() {
        return stotaltaxamt;
    }

    /**
     * Sets the value of the stotaltaxamt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTOTALTAXAMT(String value) {
        this.stotaltaxamt = value;
    }

    /**
     * Gets the value of the taxamt2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTAXAMT2() {
        return taxamt2;
    }

    /**
     * Sets the value of the taxamt2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTAXAMT2(String value) {
        this.taxamt2 = value;
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
     * Gets the value of the requestdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getREQUESTDATE() {
        return requestdate;
    }

    /**
     * Sets the value of the requestdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setREQUESTDATE(String value) {
        this.requestdate = value;
    }

    /**
     * Gets the value of the netusername property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNETUSERNAME() {
        return netusername;
    }

    /**
     * Sets the value of the netusername property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNETUSERNAME(String value) {
        this.netusername = value;
    }

    /**
     * Gets the value of the ibktxnid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIBKTXNID() {
        return ibktxnid;
    }

    /**
     * Sets the value of the ibktxnid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIBKTXNID(String value) {
        this.ibktxnid = value;
    }

    /**
     * Gets the value of the idtype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIDTYPE() {
        return idtype;
    }

    /**
     * Sets the value of the idtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIDTYPE(String value) {
        this.idtype = value;
    }

    /**
     * Gets the value of the sbidnumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSBIDNUMBER() {
        return sbidnumber;
    }

    /**
     * Sets the value of the sbidnumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSBIDNUMBER(String value) {
        this.sbidnumber = value;
    }

    /**
     * Gets the value of the cusidentity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCUSIDENTITY() {
        return cusidentity;
    }

    /**
     * Sets the value of the cusidentity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCUSIDENTITY(String value) {
        this.cusidentity = value;
    }

    /**
     * Gets the value of the cdmtransref property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCDMTRANSREF() {
        return cdmtransref;
    }

    /**
     * Sets the value of the cdmtransref property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCDMTRANSREF(String value) {
        this.cdmtransref = value;
    }

    /**
     * Gets the value of the adcnumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getADCNUMBER() {
        return adcnumber;
    }

    /**
     * Sets the value of the adcnumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setADCNUMBER(String value) {
        this.adcnumber = value;
    }

    /**
     * Gets the value of the inmsgref property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINMSGREF() {
        return inmsgref;
    }

    /**
     * Sets the value of the inmsgref property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINMSGREF(String value) {
        this.inmsgref = value;
    }

    /**
     * Gets the value of the sbuetrid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSBUETRID() {
        return sbuetrid;
    }

    /**
     * Sets the value of the sbuetrid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSBUETRID(String value) {
        this.sbuetrid = value;
    }

    /**
     * Gets the value of the originfunds property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getORIGINFUNDS() {
        return originfunds;
    }

    /**
     * Sets the value of the originfunds property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setORIGINFUNDS(String value) {
        this.originfunds = value;
    }

    /**
     * Gets the value of the destination property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDESTINATION() {
        return destination;
    }

    /**
     * Sets the value of the destination property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDESTINATION(String value) {
        this.destination = value;
    }

    /**
     * Gets the value of the usdequiv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUSDEQUIV() {
        return usdequiv;
    }

    /**
     * Sets the value of the usdequiv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUSDEQUIV(String value) {
        this.usdequiv = value;
    }

    /**
     * Gets the value of the startdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTARTDATE() {
        return startdate;
    }

    /**
     * Sets the value of the startdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTARTDATE(String value) {
        this.startdate = value;
    }

    /**
     * Gets the value of the duedate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDUEDATE() {
        return duedate;
    }

    /**
     * Sets the value of the duedate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDUEDATE(String value) {
        this.duedate = value;
    }

    /**
     * Gets the value of the enddate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getENDDATE() {
        return enddate;
    }

    /**
     * Sets the value of the enddate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setENDDATE(String value) {
        this.enddate = value;
    }

    /**
     * Gets the value of the originwaive property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getORIGINWAIVE() {
        return originwaive;
    }

    /**
     * Sets the value of the originwaive property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setORIGINWAIVE(String value) {
        this.originwaive = value;
    }

    /**
     * Gets the value of the docsupme property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDOCSUPME() {
        return docsupme;
    }

    /**
     * Sets the value of the docsupme property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDOCSUPME(String value) {
        this.docsupme = value;
    }

    /**
     * Gets the value of the sbav10EXCEP property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSBAV10EXCEP() {
        return sbav10EXCEP;
    }

    /**
     * Sets the value of the sbav10EXCEP property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSBAV10EXCEP(String value) {
        this.sbav10EXCEP = value;
    }

    /**
     * Gets the value of the bstmcountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBSTMCOUNTRY() {
        return bstmcountry;
    }

    /**
     * Sets the value of the bstmcountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBSTMCOUNTRY(String value) {
        this.bstmcountry = value;
    }

    /**
     * Gets the value of the sbtipoinvest property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSBTIPOINVEST() {
        return sbtipoinvest;
    }

    /**
     * Sets the value of the sbtipoinvest property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSBTIPOINVEST(String value) {
        this.sbtipoinvest = value;
    }

    /**
     * Gets the value of the sbpaisinvest property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSBPAISINVEST() {
        return sbpaisinvest;
    }

    /**
     * Sets the value of the sbpaisinvest property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSBPAISINVEST(String value) {
        this.sbpaisinvest = value;
    }

    /**
     * Gets the value of the percentaccoes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPERCENTACCOES() {
        return percentaccoes;
    }

    /**
     * Sets the value of the percentaccoes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPERCENTACCOES(String value) {
        this.percentaccoes = value;
    }

    /**
     * Gets the value of the valoraccoes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVALORACCOES() {
        return valoraccoes;
    }

    /**
     * Sets the value of the valoraccoes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVALORACCOES(String value) {
        this.valoraccoes = value;
    }

    /**
     * Gets the value of the mgramgraup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMGRAMGRAUP() {
        return mgramgraup;
    }

    /**
     * Sets the value of the mgramgraup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMGRAMGRAUP(String value) {
        this.mgramgraup = value;
    }

    /**
     * Gets the value of the mgramtxnr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMGRAMTXNR() {
        return mgramtxnr;
    }

    /**
     * Sets the value of the mgramtxnr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMGRAMTXNR(String value) {
        this.mgramtxnr = value;
    }

    /**
     * Gets the value of the acccurrency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACCCURRENCY() {
        return acccurrency;
    }

    /**
     * Sets the value of the acccurrency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACCCURRENCY(String value) {
        this.acccurrency = value;
    }

    /**
     * Gets the value of the dealtckbenef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDEALTCKBENEF() {
        return dealtckbenef;
    }

    /**
     * Sets the value of the dealtckbenef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDEALTCKBENEF(String value) {
        this.dealtckbenef = value;
    }

    /**
     * Gets the value of the treasuryrbenef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTREASURYRBENEF() {
        return treasuryrbenef;
    }

    /**
     * Sets the value of the treasuryrbenef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTREASURYRBENEF(String value) {
        this.treasuryrbenef = value;
    }

    /**
     * Gets the value of the chgaccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCHGACCOUNT() {
        return chgaccount;
    }

    /**
     * Sets the value of the chgaccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCHGACCOUNT(String value) {
        this.chgaccount = value;
    }

    /**
     * Gets the value of the exchangevalue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEXCHANGEVALUE() {
        return exchangevalue;
    }

    /**
     * Sets the value of the exchangevalue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEXCHANGEVALUE(String value) {
        this.exchangevalue = value;
    }

    /**
     * Gets the value of the convccyvalue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCONVCCYVALUE() {
        return convccyvalue;
    }

    /**
     * Sets the value of the convccyvalue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCONVCCYVALUE(String value) {
        this.convccyvalue = value;
    }

    /**
     * Gets the value of the sbdateissue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSBDATEISSUE() {
        return sbdateissue;
    }

    /**
     * Sets the value of the sbdateissue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSBDATEISSUE(String value) {
        this.sbdateissue = value;
    }

    /**
     * Gets the value of the ctyofissue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCTYOFISSUE() {
        return ctyofissue;
    }

    /**
     * Sets the value of the ctyofissue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCTYOFISSUE(String value) {
        this.ctyofissue = value;
    }

    /**
     * Gets the value of the sbexpirydate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSBEXPIRYDATE() {
        return sbexpirydate;
    }

    /**
     * Sets the value of the sbexpirydate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSBEXPIRYDATE(String value) {
        this.sbexpirydate = value;
    }

    /**
     * Gets the value of the authCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthCode() {
        return authCode;
    }

    /**
     * Sets the value of the authCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthCode(String value) {
        this.authCode = value;
    }

    /**
     * Gets the value of the gsbchargecode property.
     * 
     * @return
     *     possible object is
     *     {@link FUNDSTRANSFERType.GSBCHARGECODE }
     *     
     */
    public FUNDSTRANSFERType.GSBCHARGECODE getGSBCHARGECODE() {
        return gsbchargecode;
    }

    /**
     * Sets the value of the gsbchargecode property.
     * 
     * @param value
     *     allowed object is
     *     {@link FUNDSTRANSFERType.GSBCHARGECODE }
     *     
     */
    public void setGSBCHARGECODE(FUNDSTRANSFERType.GSBCHARGECODE value) {
        this.gsbchargecode = value;
    }

    /**
     * Gets the value of the sbbuyrate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSBBUYRATE() {
        return sbbuyrate;
    }

    /**
     * Sets the value of the sbbuyrate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSBBUYRATE(String value) {
        this.sbbuyrate = value;
    }

    /**
     * Gets the value of the sbsellrate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSBSELLRATE() {
        return sbsellrate;
    }

    /**
     * Sets the value of the sbsellrate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSBSELLRATE(String value) {
        this.sbsellrate = value;
    }

    /**
     * Gets the value of the crossdealrate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCROSSDEALRATE() {
        return crossdealrate;
    }

    /**
     * Sets the value of the crossdealrate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCROSSDEALRATE(String value) {
        this.crossdealrate = value;
    }

    /**
     * Gets the value of the ttspeccond property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTTSPECCOND() {
        return ttspeccond;
    }

    /**
     * Sets the value of the ttspeccond property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTTSPECCOND(String value) {
        this.ttspeccond = value;
    }

    /**
     * Gets the value of the ttspecconds property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTTSPECCONDS() {
        return ttspecconds;
    }

    /**
     * Sets the value of the ttspecconds property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTTSPECCONDS(String value) {
        this.ttspecconds = value;
    }

    /**
     * Gets the value of the bstmtrfref property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBSTMTRFREF() {
        return bstmtrfref;
    }

    /**
     * Sets the value of the bstmtrfref property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBSTMTRFREF(String value) {
        this.bstmtrfref = value;
    }

    /**
     * Gets the value of the notascodeot property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNOTASCODEOT() {
        return notascodeot;
    }

    /**
     * Sets the value of the notascodeot property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNOTASCODEOT(String value) {
        this.notascodeot = value;
    }

    /**
     * Gets the value of the notused property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNOTUSED() {
        return notused;
    }

    /**
     * Sets the value of the notused property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNOTUSED(String value) {
        this.notused = value;
    }

    /**
     * Gets the value of the idExpiryDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdExpiryDate() {
        return idExpiryDate;
    }

    /**
     * Sets the value of the idExpiryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdExpiryDate(String value) {
        this.idExpiryDate = value;
    }

    /**
     * Gets the value of the nrcliente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNRCLIENTE() {
        return nrcliente;
    }

    /**
     * Sets the value of the nrcliente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNRCLIENTE(String value) {
        this.nrcliente = value;
    }

    /**
     * Gets the value of the provedor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPROVEDOR() {
        return provedor;
    }

    /**
     * Sets the value of the provedor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPROVEDOR(String value) {
        this.provedor = value;
    }

    /**
     * Gets the value of the sblocalamt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSBLOCALAMT() {
        return sblocalamt;
    }

    /**
     * Sets the value of the sblocalamt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSBLOCALAMT(String value) {
        this.sblocalamt = value;
    }

    /**
     * Gets the value of the massvalordiff property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMASSVALORDIFF() {
        return massvalordiff;
    }

    /**
     * Sets the value of the massvalordiff property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMASSVALORDIFF(String value) {
        this.massvalordiff = value;
    }

    /**
     * Gets the value of the empladdress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEMPLADDRESS() {
        return empladdress;
    }

    /**
     * Sets the value of the empladdress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEMPLADDRESS(String value) {
        this.empladdress = value;
    }

    /**
     * Gets the value of the motivoop property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMOTIVOOP() {
        return motivoop;
    }

    /**
     * Sets the value of the motivoop property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMOTIVOOP(String value) {
        this.motivoop = value;
    }

    /**
     * Gets the value of the sexo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSEXO() {
        return sexo;
    }

    /**
     * Sets the value of the sexo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSEXO(String value) {
        this.sexo = value;
    }

    /**
     * Gets the value of the sex property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSEX() {
        return sex;
    }

    /**
     * Sets the value of the sex property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSEX(String value) {
        this.sex = value;
    }

    /**
     * Gets the value of the issuecountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISSUECOUNTRY() {
        return issuecountry;
    }

    /**
     * Sets the value of the issuecountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISSUECOUNTRY(String value) {
        this.issuecountry = value;
    }

    /**
     * Gets the value of the depnationality property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDEPNATIONALITY() {
        return depnationality;
    }

    /**
     * Sets the value of the depnationality property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDEPNATIONALITY(String value) {
        this.depnationality = value;
    }

    /**
     * Gets the value of the conductor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCONDUCTOR() {
        return conductor;
    }

    /**
     * Sets the value of the conductor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCONDUCTOR(String value) {
        this.conductor = value;
    }

    /**
     * Gets the value of the payername property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPAYERNAME() {
        return payername;
    }

    /**
     * Sets the value of the payername property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPAYERNAME(String value) {
        this.payername = value;
    }

    /**
     * Gets the value of the lsourcetype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLSOURCETYPE() {
        return lsourcetype;
    }

    /**
     * Sets the value of the lsourcetype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLSOURCETYPE(String value) {
        this.lsourcetype = value;
    }

    /**
     * Gets the value of the lbusinessind property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLBUSINESSIND() {
        return lbusinessind;
    }

    /**
     * Sets the value of the lbusinessind property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLBUSINESSIND(String value) {
        this.lbusinessind = value;
    }

    /**
     * Gets the value of the channelref property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCHANNELREF() {
        return channelref;
    }

    /**
     * Sets the value of the channelref property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCHANNELREF(String value) {
        this.channelref = value;
    }

    /**
     * Gets the value of the postingtype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPOSTINGTYPE() {
        return postingtype;
    }

    /**
     * Sets the value of the postingtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPOSTINGTYPE(String value) {
        this.postingtype = value;
    }

    /**
     * Gets the value of the pracaemissao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPRACAEMISSAO() {
        return pracaemissao;
    }

    /**
     * Sets the value of the pracaemissao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPRACAEMISSAO(String value) {
        this.pracaemissao = value;
    }

    /**
     * Gets the value of the bancoagencia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBANCOAGENCIA() {
        return bancoagencia;
    }

    /**
     * Sets the value of the bancoagencia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBANCOAGENCIA(String value) {
        this.bancoagencia = value;
    }

    /**
     * Gets the value of the sbrecvercorr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSBRECVERCORR() {
        return sbrecvercorr;
    }

    /**
     * Sets the value of the sbrecvercorr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSBRECVERCORR(String value) {
        this.sbrecvercorr = value;
    }

    /**
     * Gets the value of the swiftfilename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSWIFTFILENAME() {
        return swiftfilename;
    }

    /**
     * Sets the value of the swiftfilename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSWIFTFILENAME(String value) {
        this.swiftfilename = value;
    }

    /**
     * Gets the value of the swifttxnid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSWIFTTXNID() {
        return swifttxnid;
    }

    /**
     * Sets the value of the swifttxnid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSWIFTTXNID(String value) {
        this.swifttxnid = value;
    }

    /**
     * Gets the value of the montranerr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMONTRANERR() {
        return montranerr;
    }

    /**
     * Sets the value of the montranerr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMONTRANERR(String value) {
        this.montranerr = value;
    }

    /**
     * Gets the value of the sistafe property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSISTAFE() {
        return sistafe;
    }

    /**
     * Sets the value of the sistafe property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSISTAFE(String value) {
        this.sistafe = value;
    }

    /**
     * Gets the value of the achmessageid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACHMESSAGEID() {
        return achmessageid;
    }

    /**
     * Sets the value of the achmessageid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACHMESSAGEID(String value) {
        this.achmessageid = value;
    }

    /**
     * Gets the value of the achtxnid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACHTXNID() {
        return achtxnid;
    }

    /**
     * Sets the value of the achtxnid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACHTXNID(String value) {
        this.achtxnid = value;
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
     *         &lt;element name="ACCTWITHBANK" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "acctwithbank"
    })
    public static class GACCTWITHBANK {

        @XmlElement(name = "ACCTWITHBANK")
        protected List<String> acctwithbank;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the acctwithbank property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the acctwithbank property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getACCTWITHBANK().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getACCTWITHBANK() {
            if (acctwithbank == null) {
                acctwithbank = new ArrayList<String>();
            }
            return this.acctwithbank;
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
     *         &lt;element name="ACCTWITHBK" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "acctwithbk"
    })
    public static class GACCTWITHBK {

        @XmlElement(name = "ACCTWITHBK")
        protected List<String> acctwithbk;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the acctwithbk property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the acctwithbk property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getACCTWITHBK().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getACCTWITHBK() {
            if (acctwithbk == null) {
                acctwithbk = new ArrayList<String>();
            }
            return this.acctwithbk;
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
     *         &lt;element name="BENADDRESS" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "benaddress"
    })
    public static class GBENADDRESS {

        @XmlElement(name = "BENADDRESS")
        protected List<String> benaddress;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the benaddress property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the benaddress property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBENADDRESS().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getBENADDRESS() {
            if (benaddress == null) {
                benaddress = new ArrayList<String>();
            }
            return this.benaddress;
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
     *         &lt;element name="BENBANK" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "benbank"
    })
    public static class GBENBANK {

        @XmlElement(name = "BENBANK")
        protected List<String> benbank;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the benbank property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the benbank property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBENBANK().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getBENBANK() {
            if (benbank == null) {
                benbank = new ArrayList<String>();
            }
            return this.benbank;
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
     *         &lt;element name="BENCUSTOMER" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "bencustomer"
    })
    public static class GBENCUSTOMER {

        @XmlElement(name = "BENCUSTOMER")
        protected List<String> bencustomer;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the bencustomer property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the bencustomer property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBENCUSTOMER().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getBENCUSTOMER() {
            if (bencustomer == null) {
                bencustomer = new ArrayList<String>();
            }
            return this.bencustomer;
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
     *         &lt;element name="BENEFNAME" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "benefname"
    })
    public static class GBENEFNAME {

        @XmlElement(name = "BENEFNAME")
        protected List<String> benefname;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the benefname property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the benefname property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBENEFNAME().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getBENEFNAME() {
            if (benefname == null) {
                benefname = new ArrayList<String>();
            }
            return this.benefname;
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
     *         &lt;element name="BENNAME" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "benname"
    })
    public static class GBENNAME {

        @XmlElement(name = "BENNAME")
        protected List<String> benname;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the benname property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the benname property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBENNAME().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getBENNAME() {
            if (benname == null) {
                benname = new ArrayList<String>();
            }
            return this.benname;
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
     *         &lt;element name="BENTOWN" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "bentown"
    })
    public static class GBENTOWN {

        @XmlElement(name = "BENTOWN")
        protected List<String> bentown;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the bentown property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the bentown property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBENTOWN().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getBENTOWN() {
            if (bentown == null) {
                bentown = new ArrayList<String>();
            }
            return this.bentown;
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
     *         &lt;element name="BICIBANBENNAME" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "bicibanbenname"
    })
    public static class GBICIBANBENNAME {

        @XmlElement(name = "BICIBANBENNAME")
        protected List<String> bicibanbenname;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the bicibanbenname property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the bicibanbenname property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBICIBANBENNAME().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getBICIBANBENNAME() {
            if (bicibanbenname == null) {
                bicibanbenname = new ArrayList<String>();
            }
            return this.bicibanbenname;
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
     *         &lt;element name="BKTOBKINFO" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "bktobkinfo"
    })
    public static class GBKTOBKINFO {

        @XmlElement(name = "BKTOBKINFO")
        protected List<String> bktobkinfo;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the bktobkinfo property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the bktobkinfo property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBKTOBKINFO().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getBKTOBKINFO() {
            if (bktobkinfo == null) {
                bktobkinfo = new ArrayList<String>();
            }
            return this.bktobkinfo;
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
     *         &lt;element name="BTBFOURHUNDRED" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "btbfourhundred"
    })
    public static class GBTBFOURHUNDRED {

        @XmlElement(name = "BTBFOURHUNDRED")
        protected List<String> btbfourhundred;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the btbfourhundred property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the btbfourhundred property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBTBFOURHUNDRED().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getBTBFOURHUNDRED() {
            if (btbfourhundred == null) {
                btbfourhundred = new ArrayList<String>();
            }
            return this.btbfourhundred;
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
     *         &lt;element name="CARDTXNDETAIL" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "cardtxndetail"
    })
    public static class GCARDTXNDETAIL {

        @XmlElement(name = "CARDTXNDETAIL")
        protected List<String> cardtxndetail;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the cardtxndetail property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the cardtxndetail property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCARDTXNDETAIL().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getCARDTXNDETAIL() {
            if (cardtxndetail == null) {
                cardtxndetail = new ArrayList<String>();
            }
            return this.cardtxndetail;
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
     *         &lt;element name="mCHARGETYPE" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="CHARGETYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="CHARGEAMT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="CHARGEFOR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "mchargetype"
    })
    public static class GCHARGETYPE {

        @XmlElement(name = "mCHARGETYPE")
        protected List<FUNDSTRANSFERType.GCHARGETYPE.MCHARGETYPE> mchargetype;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the mchargetype property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the mchargetype property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMCHARGETYPE().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link FUNDSTRANSFERType.GCHARGETYPE.MCHARGETYPE }
         * 
         * 
         */
        public List<FUNDSTRANSFERType.GCHARGETYPE.MCHARGETYPE> getMCHARGETYPE() {
            if (mchargetype == null) {
                mchargetype = new ArrayList<FUNDSTRANSFERType.GCHARGETYPE.MCHARGETYPE>();
            }
            return this.mchargetype;
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
         *         &lt;element name="CHARGETYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="CHARGEAMT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="CHARGEFOR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "chargetype",
            "chargeamt",
            "chargefor"
        })
        public static class MCHARGETYPE {

            @XmlElement(name = "CHARGETYPE")
            protected String chargetype;
            @XmlElement(name = "CHARGEAMT")
            protected String chargeamt;
            @XmlElement(name = "CHARGEFOR")
            protected String chargefor;
            @XmlAttribute(name = "m")
            @XmlSchemaType(name = "positiveInteger")
            protected BigInteger m;

            /**
             * Gets the value of the chargetype property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCHARGETYPE() {
                return chargetype;
            }

            /**
             * Sets the value of the chargetype property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCHARGETYPE(String value) {
                this.chargetype = value;
            }

            /**
             * Gets the value of the chargeamt property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCHARGEAMT() {
                return chargeamt;
            }

            /**
             * Sets the value of the chargeamt property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCHARGEAMT(String value) {
                this.chargeamt = value;
            }

            /**
             * Gets the value of the chargefor property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCHARGEFOR() {
                return chargefor;
            }

            /**
             * Sets the value of the chargefor property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCHARGEFOR(String value) {
                this.chargefor = value;
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
     *         &lt;element name="mCOMMISSIONTYPE" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="COMMISSIONTYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="COMMISSIONAMT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="COMMISSIONFOR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "mcommissiontype"
    })
    public static class GCOMMISSIONTYPE {

        @XmlElement(name = "mCOMMISSIONTYPE")
        protected List<FUNDSTRANSFERType.GCOMMISSIONTYPE.MCOMMISSIONTYPE> mcommissiontype;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the mcommissiontype property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the mcommissiontype property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMCOMMISSIONTYPE().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link FUNDSTRANSFERType.GCOMMISSIONTYPE.MCOMMISSIONTYPE }
         * 
         * 
         */
        public List<FUNDSTRANSFERType.GCOMMISSIONTYPE.MCOMMISSIONTYPE> getMCOMMISSIONTYPE() {
            if (mcommissiontype == null) {
                mcommissiontype = new ArrayList<FUNDSTRANSFERType.GCOMMISSIONTYPE.MCOMMISSIONTYPE>();
            }
            return this.mcommissiontype;
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
         *         &lt;element name="COMMISSIONTYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="COMMISSIONAMT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="COMMISSIONFOR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "commissiontype",
            "commissionamt",
            "commissionfor"
        })
        public static class MCOMMISSIONTYPE {

            @XmlElement(name = "COMMISSIONTYPE")
            protected String commissiontype;
            @XmlElement(name = "COMMISSIONAMT")
            protected String commissionamt;
            @XmlElement(name = "COMMISSIONFOR")
            protected String commissionfor;
            @XmlAttribute(name = "m")
            @XmlSchemaType(name = "positiveInteger")
            protected BigInteger m;

            /**
             * Gets the value of the commissiontype property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCOMMISSIONTYPE() {
                return commissiontype;
            }

            /**
             * Sets the value of the commissiontype property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCOMMISSIONTYPE(String value) {
                this.commissiontype = value;
            }

            /**
             * Gets the value of the commissionamt property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCOMMISSIONAMT() {
                return commissionamt;
            }

            /**
             * Sets the value of the commissionamt property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCOMMISSIONAMT(String value) {
                this.commissionamt = value;
            }

            /**
             * Gets the value of the commissionfor property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCOMMISSIONFOR() {
                return commissionfor;
            }

            /**
             * Sets the value of the commissionfor property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCOMMISSIONFOR(String value) {
                this.commissionfor = value;
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
     *         &lt;element name="DELIVERYOUTREF" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "deliveryoutref"
    })
    public static class GDELIVERYOUTREF {

        @XmlElement(name = "DELIVERYOUTREF")
        protected List<String> deliveryoutref;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the deliveryoutref property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the deliveryoutref property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDELIVERYOUTREF().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getDELIVERYOUTREF() {
            if (deliveryoutref == null) {
                deliveryoutref = new ArrayList<String>();
            }
            return this.deliveryoutref;
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
     *         &lt;element name="EXTENDINFO" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "extendinfo"
    })
    public static class GEXTENDINFO {

        @XmlElement(name = "EXTENDINFO")
        protected List<String> extendinfo;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the extendinfo property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the extendinfo property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEXTENDINFO().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getEXTENDINFO() {
            if (extendinfo == null) {
                extendinfo = new ArrayList<String>();
            }
            return this.extendinfo;
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
     *         &lt;element name="FOREQUIVCHGS" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "forequivchgs"
    })
    public static class GFOREQUIVCHGS {

        @XmlElement(name = "FOREQUIVCHGS")
        protected List<String> forequivchgs;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the forequivchgs property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the forequivchgs property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getFOREQUIVCHGS().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getFOREQUIVCHGS() {
            if (forequivchgs == null) {
                forequivchgs = new ArrayList<String>();
            }
            return this.forequivchgs;
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
     *         &lt;element name="FREETEXTMSGTO" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "freetextmsgto"
    })
    public static class GFREETEXTMSGTO {

        @XmlElement(name = "FREETEXTMSGTO")
        protected List<String> freetextmsgto;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the freetextmsgto property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the freetextmsgto property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getFREETEXTMSGTO().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getFREETEXTMSGTO() {
            if (freetextmsgto == null) {
                freetextmsgto = new ArrayList<String>();
            }
            return this.freetextmsgto;
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
     *         &lt;element name="IN3RDREIMBBK" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "in3RDREIMBBK"
    })
    public static class GIN3RDREIMBBK {

        @XmlElement(name = "IN3RDREIMBBK")
        protected List<String> in3RDREIMBBK;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the in3RDREIMBBK property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the in3RDREIMBBK property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getIN3RDREIMBBK().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getIN3RDREIMBBK() {
            if (in3RDREIMBBK == null) {
                in3RDREIMBBK = new ArrayList<String>();
            }
            return this.in3RDREIMBBK;
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
     *         &lt;element name="INBENADDRESS" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "inbenaddress"
    })
    public static class GINBENADDRESS {

        @XmlElement(name = "INBENADDRESS")
        protected List<String> inbenaddress;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the inbenaddress property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the inbenaddress property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getINBENADDRESS().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getINBENADDRESS() {
            if (inbenaddress == null) {
                inbenaddress = new ArrayList<String>();
            }
            return this.inbenaddress;
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
     *         &lt;element name="INBENBANK" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "inbenbank"
    })
    public static class GINBENBANK {

        @XmlElement(name = "INBENBANK")
        protected List<String> inbenbank;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the inbenbank property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the inbenbank property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getINBENBANK().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getINBENBANK() {
            if (inbenbank == null) {
                inbenbank = new ArrayList<String>();
            }
            return this.inbenbank;
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
     *         &lt;element name="INBENCUSTOMER" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "inbencustomer"
    })
    public static class GINBENCUSTOMER {

        @XmlElement(name = "INBENCUSTOMER")
        protected List<String> inbencustomer;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the inbencustomer property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the inbencustomer property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getINBENCUSTOMER().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getINBENCUSTOMER() {
            if (inbencustomer == null) {
                inbencustomer = new ArrayList<String>();
            }
            return this.inbencustomer;
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
     *         &lt;element name="INBENNAME" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "inbenname"
    })
    public static class GINBENNAME {

        @XmlElement(name = "INBENNAME")
        protected List<String> inbenname;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the inbenname property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the inbenname property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getINBENNAME().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getINBENNAME() {
            if (inbenname == null) {
                inbenname = new ArrayList<String>();
            }
            return this.inbenname;
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
     *         &lt;element name="INBENTOWN" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "inbentown"
    })
    public static class GINBENTOWN {

        @XmlElement(name = "INBENTOWN")
        protected List<String> inbentown;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the inbentown property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the inbentown property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getINBENTOWN().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getINBENTOWN() {
            if (inbentown == null) {
                inbentown = new ArrayList<String>();
            }
            return this.inbentown;
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
     *         &lt;element name="INBKTOBK" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "inbktobk"
    })
    public static class GINBKTOBK {

        @XmlElement(name = "INBKTOBK")
        protected List<String> inbktobk;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the inbktobk property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the inbktobk property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getINBKTOBK().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getINBKTOBK() {
            if (inbktobk == null) {
                inbktobk = new ArrayList<String>();
            }
            return this.inbktobk;
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
     *         &lt;element name="INCACCWITBK" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "incaccwitbk"
    })
    public static class GINCACCWITBK {

        @XmlElement(name = "INCACCWITBK")
        protected List<String> incaccwitbk;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the incaccwitbk property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the incaccwitbk property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getINCACCWITBK().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getINCACCWITBK() {
            if (incaccwitbk == null) {
                incaccwitbk = new ArrayList<String>();
            }
            return this.incaccwitbk;
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
     *         &lt;element name="INCBKTBKIN" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "incbktbkin"
    })
    public static class GINCBKTBKIN {

        @XmlElement(name = "INCBKTBKIN")
        protected List<String> incbktbkin;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the incbktbkin property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the incbktbkin property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getINCBKTBKIN().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getINCBKTBKIN() {
            if (incbktbkin == null) {
                incbktbkin = new ArrayList<String>();
            }
            return this.incbktbkin;
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
     *         &lt;element name="INCINTMEDBK" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "incintmedbk"
    })
    public static class GINCINTMEDBK {

        @XmlElement(name = "INCINTMEDBK")
        protected List<String> incintmedbk;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the incintmedbk property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the incintmedbk property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getINCINTMEDBK().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getINCINTMEDBK() {
            if (incintmedbk == null) {
                incintmedbk = new ArrayList<String>();
            }
            return this.incintmedbk;
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
     *         &lt;element name="INCORDBK" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "incordbk"
    })
    public static class GINCORDBK {

        @XmlElement(name = "INCORDBK")
        protected List<String> incordbk;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the incordbk property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the incordbk property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getINCORDBK().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getINCORDBK() {
            if (incordbk == null) {
                incordbk = new ArrayList<String>();
            }
            return this.incordbk;
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
     *         &lt;element name="ININSTRCODE" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "ininstrcode"
    })
    public static class GININSTRCODE {

        @XmlElement(name = "ININSTRCODE")
        protected List<String> ininstrcode;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the ininstrcode property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the ininstrcode property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getININSTRCODE().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getININSTRCODE() {
            if (ininstrcode == null) {
                ininstrcode = new ArrayList<String>();
            }
            return this.ininstrcode;
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
     *         &lt;element name="ININTERMEDBK" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "inintermedbk"
    })
    public static class GININTERMEDBK {

        @XmlElement(name = "ININTERMEDBK")
        protected List<String> inintermedbk;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the inintermedbk property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the inintermedbk property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getININTERMEDBK().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getININTERMEDBK() {
            if (inintermedbk == null) {
                inintermedbk = new ArrayList<String>();
            }
            return this.inintermedbk;
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
     *         &lt;element name="ININTMEDBANK" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "inintmedbank"
    })
    public static class GININTMEDBANK {

        @XmlElement(name = "ININTMEDBANK")
        protected List<String> inintmedbank;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the inintmedbank property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the inintmedbank property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getININTMEDBANK().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getININTMEDBANK() {
            if (inintmedbank == null) {
                inintmedbank = new ArrayList<String>();
            }
            return this.inintmedbank;
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
     *         &lt;element name="INORDERINGBK" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "inorderingbk"
    })
    public static class GINORDERINGBK {

        @XmlElement(name = "INORDERINGBK")
        protected List<String> inorderingbk;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the inorderingbk property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the inorderingbk property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getINORDERINGBK().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getINORDERINGBK() {
            if (inorderingbk == null) {
                inorderingbk = new ArrayList<String>();
            }
            return this.inorderingbk;
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
     *         &lt;element name="INORDERINGCUS" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "inorderingcus"
    })
    public static class GINORDERINGCUS {

        @XmlElement(name = "INORDERINGCUS")
        protected List<String> inorderingcus;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the inorderingcus property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the inorderingcus property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getINORDERINGCUS().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getINORDERINGCUS() {
            if (inorderingcus == null) {
                inorderingcus = new ArrayList<String>();
            }
            return this.inorderingcus;
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
     *         &lt;element name="INPAYDETAILS" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "inpaydetails"
    })
    public static class GINPAYDETAILS {

        @XmlElement(name = "INPAYDETAILS")
        protected List<String> inpaydetails;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the inpaydetails property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the inpaydetails property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getINPAYDETAILS().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getINPAYDETAILS() {
            if (inpaydetails == null) {
                inpaydetails = new ArrayList<String>();
            }
            return this.inpaydetails;
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
     *         &lt;element name="INPROCESSERR" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "inprocesserr"
    })
    public static class GINPROCESSERR {

        @XmlElement(name = "INPROCESSERR")
        protected List<String> inprocesserr;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the inprocesserr property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the inprocesserr property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getINPROCESSERR().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getINPROCESSERR() {
            if (inprocesserr == null) {
                inprocesserr = new ArrayList<String>();
            }
            return this.inprocesserr;
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
     *         &lt;element name="INREASONOVE" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "inreasonove"
    })
    public static class GINREASONOVE {

        @XmlElement(name = "INREASONOVE")
        protected List<String> inreasonove;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the inreasonove property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the inreasonove property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getINREASONOVE().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getINREASONOVE() {
            if (inreasonove == null) {
                inreasonove = new ArrayList<String>();
            }
            return this.inreasonove;
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
     *         &lt;element name="INRECCORRBK" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "inreccorrbk"
    })
    public static class GINRECCORRBK {

        @XmlElement(name = "INRECCORRBK")
        protected List<String> inreccorrbk;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the inreccorrbk property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the inreccorrbk property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getINRECCORRBK().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getINRECCORRBK() {
            if (inreccorrbk == null) {
                inreccorrbk = new ArrayList<String>();
            }
            return this.inreccorrbk;
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
     *         &lt;element name="INSENDCHG" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "insendchg"
    })
    public static class GINSENDCHG {

        @XmlElement(name = "INSENDCHG")
        protected List<String> insendchg;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the insendchg property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the insendchg property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getINSENDCHG().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getINSENDCHG() {
            if (insendchg == null) {
                insendchg = new ArrayList<String>();
            }
            return this.insendchg;
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
     *         &lt;element name="INSENDCORRBK" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "insendcorrbk"
    })
    public static class GINSENDCORRBK {

        @XmlElement(name = "INSENDCORRBK")
        protected List<String> insendcorrbk;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the insendcorrbk property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the insendcorrbk property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getINSENDCORRBK().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getINSENDCORRBK() {
            if (insendcorrbk == null) {
                insendcorrbk = new ArrayList<String>();
            }
            return this.insendcorrbk;
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
     *         &lt;element name="INSTRCTNCODE" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "instrctncode"
    })
    public static class GINSTRCTNCODE {

        @XmlElement(name = "INSTRCTNCODE")
        protected List<String> instrctncode;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the instrctncode property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the instrctncode property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getINSTRCTNCODE().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getINSTRCTNCODE() {
            if (instrctncode == null) {
                instrctncode = new ArrayList<String>();
            }
            return this.instrctncode;
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
     *         &lt;element name="INSWIFTMSG" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "inswiftmsg"
    })
    public static class GINSWIFTMSG {

        @XmlElement(name = "INSWIFTMSG")
        protected List<String> inswiftmsg;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the inswiftmsg property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the inswiftmsg property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getINSWIFTMSG().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getINSWIFTMSG() {
            if (inswiftmsg == null) {
                inswiftmsg = new ArrayList<String>();
            }
            return this.inswiftmsg;
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
     *         &lt;element name="INTERMEDBANK" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "intermedbank"
    })
    public static class GINTERMEDBANK {

        @XmlElement(name = "INTERMEDBANK")
        protected List<String> intermedbank;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the intermedbank property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the intermedbank property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getINTERMEDBANK().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getINTERMEDBANK() {
            if (intermedbank == null) {
                intermedbank = new ArrayList<String>();
            }
            return this.intermedbank;
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
     *         &lt;element name="INTIMEIND" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "intimeind"
    })
    public static class GINTIMEIND {

        @XmlElement(name = "INTIMEIND")
        protected List<String> intimeind;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the intimeind property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the intimeind property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getINTIMEIND().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getINTIMEIND() {
            if (intimeind == null) {
                intimeind = new ArrayList<String>();
            }
            return this.intimeind;
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
     *         &lt;element name="LOCEQUIVCHGS" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "locequivchgs"
    })
    public static class GLOCEQUIVCHGS {

        @XmlElement(name = "LOCEQUIVCHGS")
        protected List<String> locequivchgs;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the locequivchgs property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the locequivchgs property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLOCEQUIVCHGS().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getLOCEQUIVCHGS() {
            if (locequivchgs == null) {
                locequivchgs = new ArrayList<String>();
            }
            return this.locequivchgs;
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
     *         &lt;element name="MESSAGE" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "message"
    })
    public static class GMESSAGE {

        @XmlElement(name = "MESSAGE")
        protected List<String> message;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the message property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the message property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMESSAGE().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getMESSAGE() {
            if (message == null) {
                message = new ArrayList<String>();
            }
            return this.message;
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
     *         &lt;element name="mMSGTYPE" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="MSGTYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="MSGDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "mmsgtype"
    })
    public static class GMSGTYPE {

        @XmlElement(name = "mMSGTYPE")
        protected List<FUNDSTRANSFERType.GMSGTYPE.MMSGTYPE> mmsgtype;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the mmsgtype property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the mmsgtype property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMMSGTYPE().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link FUNDSTRANSFERType.GMSGTYPE.MMSGTYPE }
         * 
         * 
         */
        public List<FUNDSTRANSFERType.GMSGTYPE.MMSGTYPE> getMMSGTYPE() {
            if (mmsgtype == null) {
                mmsgtype = new ArrayList<FUNDSTRANSFERType.GMSGTYPE.MMSGTYPE>();
            }
            return this.mmsgtype;
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
         *         &lt;element name="MSGTYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="MSGDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "msgtype",
            "msgdate"
        })
        public static class MMSGTYPE {

            @XmlElement(name = "MSGTYPE")
            protected String msgtype;
            @XmlElement(name = "MSGDATE")
            protected String msgdate;
            @XmlAttribute(name = "m")
            @XmlSchemaType(name = "positiveInteger")
            protected BigInteger m;

            /**
             * Gets the value of the msgtype property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMSGTYPE() {
                return msgtype;
            }

            /**
             * Sets the value of the msgtype property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMSGTYPE(String value) {
                this.msgtype = value;
            }

            /**
             * Gets the value of the msgdate property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMSGDATE() {
                return msgdate;
            }

            /**
             * Sets the value of the msgdate property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMSGDATE(String value) {
                this.msgdate = value;
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
     *         &lt;element name="ORDERINGBANK" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "orderingbank"
    })
    public static class GORDERINGBANK {

        @XmlElement(name = "ORDERINGBANK")
        protected List<String> orderingbank;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the orderingbank property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the orderingbank property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getORDERINGBANK().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getORDERINGBANK() {
            if (orderingbank == null) {
                orderingbank = new ArrayList<String>();
            }
            return this.orderingbank;
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
     *         &lt;element name="ORDERINGCUST" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "orderingcust"
    })
    public static class GORDERINGCUST {

        @XmlElement(name = "ORDERINGCUST")
        protected List<String> orderingcust;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the orderingcust property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the orderingcust property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getORDERINGCUST().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getORDERINGCUST() {
            if (orderingcust == null) {
                orderingcust = new ArrayList<String>();
            }
            return this.orderingcust;
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
     *         &lt;element name="PAYMENTDETAILS" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "paymentdetails"
    })
    public static class GPAYMENTDETAILS {

        @XmlElement(name = "PAYMENTDETAILS")
        protected List<String> paymentdetails;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the paymentdetails property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the paymentdetails property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPAYMENTDETAILS().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getPAYMENTDETAILS() {
            if (paymentdetails == null) {
                paymentdetails = new ArrayList<String>();
            }
            return this.paymentdetails;
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
     *         &lt;element name="RECCORRBANK" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "reccorrbank"
    })
    public static class GRECCORRBANK {

        @XmlElement(name = "RECCORRBANK")
        protected List<String> reccorrbank;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the reccorrbank property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the reccorrbank property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRECCORRBANK().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getRECCORRBANK() {
            if (reccorrbank == null) {
                reccorrbank = new ArrayList<String>();
            }
            return this.reccorrbank;
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
     *         &lt;element name="mREFDATAITEM" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="REFDATAITEM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="REFDATAVALUE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "mrefdataitem"
    })
    public static class GREFDATAITEM {

        @XmlElement(name = "mREFDATAITEM")
        protected List<FUNDSTRANSFERType.GREFDATAITEM.MREFDATAITEM> mrefdataitem;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the mrefdataitem property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the mrefdataitem property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMREFDATAITEM().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link FUNDSTRANSFERType.GREFDATAITEM.MREFDATAITEM }
         * 
         * 
         */
        public List<FUNDSTRANSFERType.GREFDATAITEM.MREFDATAITEM> getMREFDATAITEM() {
            if (mrefdataitem == null) {
                mrefdataitem = new ArrayList<FUNDSTRANSFERType.GREFDATAITEM.MREFDATAITEM>();
            }
            return this.mrefdataitem;
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
         *         &lt;element name="REFDATAITEM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="REFDATAVALUE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "refdataitem",
            "refdatavalue"
        })
        public static class MREFDATAITEM {

            @XmlElement(name = "REFDATAITEM")
            protected String refdataitem;
            @XmlElement(name = "REFDATAVALUE")
            protected String refdatavalue;
            @XmlAttribute(name = "m")
            @XmlSchemaType(name = "positiveInteger")
            protected BigInteger m;

            /**
             * Gets the value of the refdataitem property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getREFDATAITEM() {
                return refdataitem;
            }

            /**
             * Sets the value of the refdataitem property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setREFDATAITEM(String value) {
                this.refdataitem = value;
            }

            /**
             * Gets the value of the refdatavalue property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getREFDATAVALUE() {
                return refdatavalue;
            }

            /**
             * Sets the value of the refdatavalue property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setREFDATAVALUE(String value) {
                this.refdatavalue = value;
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
     *         &lt;element name="mRELATEDMSG" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="RELATEDMSG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="sgTIMEIND" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="TIMEIND" maxOccurs="unbounded" minOccurs="0">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="TIMEIND" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                     &lt;/sequence>
     *                                     &lt;attribute name="s" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                           &lt;attribute name="sg" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
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
        "mrelatedmsg"
    })
    public static class GRELATEDMSG {

        @XmlElement(name = "mRELATEDMSG")
        protected List<FUNDSTRANSFERType.GRELATEDMSG.MRELATEDMSG> mrelatedmsg;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the mrelatedmsg property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the mrelatedmsg property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMRELATEDMSG().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link FUNDSTRANSFERType.GRELATEDMSG.MRELATEDMSG }
         * 
         * 
         */
        public List<FUNDSTRANSFERType.GRELATEDMSG.MRELATEDMSG> getMRELATEDMSG() {
            if (mrelatedmsg == null) {
                mrelatedmsg = new ArrayList<FUNDSTRANSFERType.GRELATEDMSG.MRELATEDMSG>();
            }
            return this.mrelatedmsg;
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
         *         &lt;element name="RELATEDMSG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="sgTIMEIND" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="TIMEIND" maxOccurs="unbounded" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="TIMEIND" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                           &lt;/sequence>
         *                           &lt;attribute name="s" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *                 &lt;attribute name="sg" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
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
            "relatedmsg",
            "sgTIMEIND"
        })
        public static class MRELATEDMSG {

            @XmlElement(name = "RELATEDMSG")
            protected String relatedmsg;
            protected FUNDSTRANSFERType.GRELATEDMSG.MRELATEDMSG.SgTIMEIND sgTIMEIND;
            @XmlAttribute(name = "m")
            @XmlSchemaType(name = "positiveInteger")
            protected BigInteger m;

            /**
             * Gets the value of the relatedmsg property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRELATEDMSG() {
                return relatedmsg;
            }

            /**
             * Sets the value of the relatedmsg property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRELATEDMSG(String value) {
                this.relatedmsg = value;
            }

            /**
             * Gets the value of the sgTIMEIND property.
             * 
             * @return
             *     possible object is
             *     {@link FUNDSTRANSFERType.GRELATEDMSG.MRELATEDMSG.SgTIMEIND }
             *     
             */
            public FUNDSTRANSFERType.GRELATEDMSG.MRELATEDMSG.SgTIMEIND getSgTIMEIND() {
                return sgTIMEIND;
            }

            /**
             * Sets the value of the sgTIMEIND property.
             * 
             * @param value
             *     allowed object is
             *     {@link FUNDSTRANSFERType.GRELATEDMSG.MRELATEDMSG.SgTIMEIND }
             *     
             */
            public void setSgTIMEIND(FUNDSTRANSFERType.GRELATEDMSG.MRELATEDMSG.SgTIMEIND value) {
                this.sgTIMEIND = value;
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
             *         &lt;element name="TIMEIND" maxOccurs="unbounded" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="TIMEIND" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                 &lt;/sequence>
             *                 &lt;attribute name="s" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *       &lt;/sequence>
             *       &lt;attribute name="sg" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "timeind"
            })
            public static class SgTIMEIND {

                @XmlElement(name = "TIMEIND")
                protected List<FUNDSTRANSFERType.GRELATEDMSG.MRELATEDMSG.SgTIMEIND.TIMEIND> timeind;
                @XmlAttribute(name = "sg")
                @XmlSchemaType(name = "positiveInteger")
                protected BigInteger sg;

                /**
                 * Gets the value of the timeind property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the timeind property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getTIMEIND().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link FUNDSTRANSFERType.GRELATEDMSG.MRELATEDMSG.SgTIMEIND.TIMEIND }
                 * 
                 * 
                 */
                public List<FUNDSTRANSFERType.GRELATEDMSG.MRELATEDMSG.SgTIMEIND.TIMEIND> getTIMEIND() {
                    if (timeind == null) {
                        timeind = new ArrayList<FUNDSTRANSFERType.GRELATEDMSG.MRELATEDMSG.SgTIMEIND.TIMEIND>();
                    }
                    return this.timeind;
                }

                /**
                 * Gets the value of the sg property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getSg() {
                    return sg;
                }

                /**
                 * Sets the value of the sg property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setSg(BigInteger value) {
                    this.sg = value;
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
                 *         &lt;element name="TIMEIND" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *       &lt;/sequence>
                 *       &lt;attribute name="s" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "timeind"
                })
                public static class TIMEIND {

                    @XmlElement(name = "TIMEIND")
                    protected String timeind;
                    @XmlAttribute(name = "s")
                    @XmlSchemaType(name = "positiveInteger")
                    protected BigInteger s;

                    /**
                     * Gets the value of the timeind property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getTIMEIND() {
                        return timeind;
                    }

                    /**
                     * Sets the value of the timeind property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setTIMEIND(String value) {
                        this.timeind = value;
                    }

                    /**
                     * Gets the value of the s property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getS() {
                        return s;
                    }

                    /**
                     * Sets the value of the s property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setS(BigInteger value) {
                        this.s = value;
                    }

                }

            }

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
     *         &lt;element name="mSBCHARGECODE" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="SBCHARGECODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="SBCHARGEAMT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "msbchargecode"
    })
    public static class GSBCHARGECODE {

        @XmlElement(name = "mSBCHARGECODE")
        protected List<FUNDSTRANSFERType.GSBCHARGECODE.MSBCHARGECODE> msbchargecode;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the msbchargecode property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the msbchargecode property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMSBCHARGECODE().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link FUNDSTRANSFERType.GSBCHARGECODE.MSBCHARGECODE }
         * 
         * 
         */
        public List<FUNDSTRANSFERType.GSBCHARGECODE.MSBCHARGECODE> getMSBCHARGECODE() {
            if (msbchargecode == null) {
                msbchargecode = new ArrayList<FUNDSTRANSFERType.GSBCHARGECODE.MSBCHARGECODE>();
            }
            return this.msbchargecode;
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
         *         &lt;element name="SBCHARGECODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="SBCHARGEAMT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "sbchargecode",
            "sbchargeamt"
        })
        public static class MSBCHARGECODE {

            @XmlElement(name = "SBCHARGECODE")
            protected String sbchargecode;
            @XmlElement(name = "SBCHARGEAMT")
            protected String sbchargeamt;
            @XmlAttribute(name = "m")
            @XmlSchemaType(name = "positiveInteger")
            protected BigInteger m;

            /**
             * Gets the value of the sbchargecode property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSBCHARGECODE() {
                return sbchargecode;
            }

            /**
             * Sets the value of the sbchargecode property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSBCHARGECODE(String value) {
                this.sbchargecode = value;
            }

            /**
             * Gets the value of the sbchargeamt property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSBCHARGEAMT() {
                return sbchargeamt;
            }

            /**
             * Sets the value of the sbchargeamt property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSBCHARGEAMT(String value) {
                this.sbchargeamt = value;
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
     *         &lt;element name="SBORDCUSADDR" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "sbordcusaddr"
    })
    public static class GSBORDCUSADDR {

        @XmlElement(name = "SBORDCUSADDR")
        protected List<String> sbordcusaddr;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the sbordcusaddr property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the sbordcusaddr property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSBORDCUSADDR().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getSBORDCUSADDR() {
            if (sbordcusaddr == null) {
                sbordcusaddr = new ArrayList<String>();
            }
            return this.sbordcusaddr;
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
     *         &lt;element name="SBTOWNCOUNTRY" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "sbtowncountry"
    })
    public static class GSBTOWNCOUNTRY {

        @XmlElement(name = "SBTOWNCOUNTRY")
        protected List<String> sbtowncountry;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the sbtowncountry property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the sbtowncountry property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSBTOWNCOUNTRY().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getSBTOWNCOUNTRY() {
            if (sbtowncountry == null) {
                sbtowncountry = new ArrayList<String>();
            }
            return this.sbtowncountry;
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
     *         &lt;element name="SendedDocument" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "sendedDocument"
    })
    public static class GSENDEDDOCUMENT {

        @XmlElement(name = "SendedDocument")
        protected List<String> sendedDocument;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the sendedDocument property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the sendedDocument property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSendedDocument().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getSendedDocument() {
            if (sendedDocument == null) {
                sendedDocument = new ArrayList<String>();
            }
            return this.sendedDocument;
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
     *         &lt;element name="mSENDTOPARTY" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="SENDTOPARTY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="sgBKTOBKOUT" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="BKTOBKOUT" maxOccurs="unbounded" minOccurs="0">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="BKTOBKOUT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                                     &lt;/sequence>
     *                                     &lt;attribute name="s" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                           &lt;attribute name="sg" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="MESSAGETYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "msendtoparty"
    })
    public static class GSENDTOPARTY {

        @XmlElement(name = "mSENDTOPARTY")
        protected List<FUNDSTRANSFERType.GSENDTOPARTY.MSENDTOPARTY> msendtoparty;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the msendtoparty property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the msendtoparty property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMSENDTOPARTY().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link FUNDSTRANSFERType.GSENDTOPARTY.MSENDTOPARTY }
         * 
         * 
         */
        public List<FUNDSTRANSFERType.GSENDTOPARTY.MSENDTOPARTY> getMSENDTOPARTY() {
            if (msendtoparty == null) {
                msendtoparty = new ArrayList<FUNDSTRANSFERType.GSENDTOPARTY.MSENDTOPARTY>();
            }
            return this.msendtoparty;
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
         *         &lt;element name="SENDTOPARTY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="sgBKTOBKOUT" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="BKTOBKOUT" maxOccurs="unbounded" minOccurs="0">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="BKTOBKOUT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                           &lt;/sequence>
         *                           &lt;attribute name="s" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *                 &lt;attribute name="sg" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="MESSAGETYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "sendtoparty",
            "sgBKTOBKOUT",
            "messagetype"
        })
        public static class MSENDTOPARTY {

            @XmlElement(name = "SENDTOPARTY")
            protected String sendtoparty;
            protected FUNDSTRANSFERType.GSENDTOPARTY.MSENDTOPARTY.SgBKTOBKOUT sgBKTOBKOUT;
            @XmlElement(name = "MESSAGETYPE")
            protected String messagetype;
            @XmlAttribute(name = "m")
            @XmlSchemaType(name = "positiveInteger")
            protected BigInteger m;

            /**
             * Gets the value of the sendtoparty property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSENDTOPARTY() {
                return sendtoparty;
            }

            /**
             * Sets the value of the sendtoparty property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSENDTOPARTY(String value) {
                this.sendtoparty = value;
            }

            /**
             * Gets the value of the sgBKTOBKOUT property.
             * 
             * @return
             *     possible object is
             *     {@link FUNDSTRANSFERType.GSENDTOPARTY.MSENDTOPARTY.SgBKTOBKOUT }
             *     
             */
            public FUNDSTRANSFERType.GSENDTOPARTY.MSENDTOPARTY.SgBKTOBKOUT getSgBKTOBKOUT() {
                return sgBKTOBKOUT;
            }

            /**
             * Sets the value of the sgBKTOBKOUT property.
             * 
             * @param value
             *     allowed object is
             *     {@link FUNDSTRANSFERType.GSENDTOPARTY.MSENDTOPARTY.SgBKTOBKOUT }
             *     
             */
            public void setSgBKTOBKOUT(FUNDSTRANSFERType.GSENDTOPARTY.MSENDTOPARTY.SgBKTOBKOUT value) {
                this.sgBKTOBKOUT = value;
            }

            /**
             * Gets the value of the messagetype property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMESSAGETYPE() {
                return messagetype;
            }

            /**
             * Sets the value of the messagetype property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMESSAGETYPE(String value) {
                this.messagetype = value;
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
             *         &lt;element name="BKTOBKOUT" maxOccurs="unbounded" minOccurs="0">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="BKTOBKOUT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *                 &lt;/sequence>
             *                 &lt;attribute name="s" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *       &lt;/sequence>
             *       &lt;attribute name="sg" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "bktobkout"
            })
            public static class SgBKTOBKOUT {

                @XmlElement(name = "BKTOBKOUT")
                protected List<FUNDSTRANSFERType.GSENDTOPARTY.MSENDTOPARTY.SgBKTOBKOUT.BKTOBKOUT> bktobkout;
                @XmlAttribute(name = "sg")
                @XmlSchemaType(name = "positiveInteger")
                protected BigInteger sg;

                /**
                 * Gets the value of the bktobkout property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the bktobkout property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getBKTOBKOUT().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link FUNDSTRANSFERType.GSENDTOPARTY.MSENDTOPARTY.SgBKTOBKOUT.BKTOBKOUT }
                 * 
                 * 
                 */
                public List<FUNDSTRANSFERType.GSENDTOPARTY.MSENDTOPARTY.SgBKTOBKOUT.BKTOBKOUT> getBKTOBKOUT() {
                    if (bktobkout == null) {
                        bktobkout = new ArrayList<FUNDSTRANSFERType.GSENDTOPARTY.MSENDTOPARTY.SgBKTOBKOUT.BKTOBKOUT>();
                    }
                    return this.bktobkout;
                }

                /**
                 * Gets the value of the sg property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                public BigInteger getSg() {
                    return sg;
                }

                /**
                 * Sets the value of the sg property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                public void setSg(BigInteger value) {
                    this.sg = value;
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
                 *         &lt;element name="BKTOBKOUT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
                 *       &lt;/sequence>
                 *       &lt;attribute name="s" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = {
                    "bktobkout"
                })
                public static class BKTOBKOUT {

                    @XmlElement(name = "BKTOBKOUT")
                    protected String bktobkout;
                    @XmlAttribute(name = "s")
                    @XmlSchemaType(name = "positiveInteger")
                    protected BigInteger s;

                    /**
                     * Gets the value of the bktobkout property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getBKTOBKOUT() {
                        return bktobkout;
                    }

                    /**
                     * Sets the value of the bktobkout property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setBKTOBKOUT(String value) {
                        this.bktobkout = value;
                    }

                    /**
                     * Gets the value of the s property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    public BigInteger getS() {
                        return s;
                    }

                    /**
                     * Sets the value of the s property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    public void setS(BigInteger value) {
                        this.s = value;
                    }

                }

            }

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
     *         &lt;element name="SIGNATORY" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "signatory"
    })
    public static class GSIGNATORY {

        @XmlElement(name = "SIGNATORY")
        protected List<String> signatory;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the signatory property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the signatory property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSIGNATORY().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getSIGNATORY() {
            if (signatory == null) {
                signatory = new ArrayList<String>();
            }
            return this.signatory;
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
     *         &lt;element name="mSPLITEXPOSUREDATE" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="SPLITEXPOSUREDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="SPLITEXPOSUREAMT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "msplitexposuredate"
    })
    public static class GSPLITEXPOSUREDATE {

        @XmlElement(name = "mSPLITEXPOSUREDATE")
        protected List<FUNDSTRANSFERType.GSPLITEXPOSUREDATE.MSPLITEXPOSUREDATE> msplitexposuredate;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the msplitexposuredate property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the msplitexposuredate property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMSPLITEXPOSUREDATE().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link FUNDSTRANSFERType.GSPLITEXPOSUREDATE.MSPLITEXPOSUREDATE }
         * 
         * 
         */
        public List<FUNDSTRANSFERType.GSPLITEXPOSUREDATE.MSPLITEXPOSUREDATE> getMSPLITEXPOSUREDATE() {
            if (msplitexposuredate == null) {
                msplitexposuredate = new ArrayList<FUNDSTRANSFERType.GSPLITEXPOSUREDATE.MSPLITEXPOSUREDATE>();
            }
            return this.msplitexposuredate;
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
         *         &lt;element name="SPLITEXPOSUREDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="SPLITEXPOSUREAMT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "splitexposuredate",
            "splitexposureamt"
        })
        public static class MSPLITEXPOSUREDATE {

            @XmlElement(name = "SPLITEXPOSUREDATE")
            protected String splitexposuredate;
            @XmlElement(name = "SPLITEXPOSUREAMT")
            protected String splitexposureamt;
            @XmlAttribute(name = "m")
            @XmlSchemaType(name = "positiveInteger")
            protected BigInteger m;

            /**
             * Gets the value of the splitexposuredate property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSPLITEXPOSUREDATE() {
                return splitexposuredate;
            }

            /**
             * Sets the value of the splitexposuredate property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSPLITEXPOSUREDATE(String value) {
                this.splitexposuredate = value;
            }

            /**
             * Gets the value of the splitexposureamt property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSPLITEXPOSUREAMT() {
                return splitexposureamt;
            }

            /**
             * Sets the value of the splitexposureamt property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSPLITEXPOSUREAMT(String value) {
                this.splitexposureamt = value;
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
     *         &lt;element name="STMTNOS" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "stmtnos"
    })
    public static class GSTMTNOS {

        @XmlElement(name = "STMTNOS")
        protected List<String> stmtnos;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the stmtnos property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the stmtnos property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSTMTNOS().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getSTMTNOS() {
            if (stmtnos == null) {
                stmtnos = new ArrayList<String>();
            }
            return this.stmtnos;
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
     *         &lt;element name="mTAXTYPE" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="TAXTYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="TAXAMT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "mtaxtype"
    })
    public static class GTAXTYPE {

        @XmlElement(name = "mTAXTYPE")
        protected List<FUNDSTRANSFERType.GTAXTYPE.MTAXTYPE> mtaxtype;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the mtaxtype property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the mtaxtype property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMTAXTYPE().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link FUNDSTRANSFERType.GTAXTYPE.MTAXTYPE }
         * 
         * 
         */
        public List<FUNDSTRANSFERType.GTAXTYPE.MTAXTYPE> getMTAXTYPE() {
            if (mtaxtype == null) {
                mtaxtype = new ArrayList<FUNDSTRANSFERType.GTAXTYPE.MTAXTYPE>();
            }
            return this.mtaxtype;
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
         *         &lt;element name="TAXTYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="TAXAMT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "taxtype",
            "taxamt"
        })
        public static class MTAXTYPE {

            @XmlElement(name = "TAXTYPE")
            protected String taxtype;
            @XmlElement(name = "TAXAMT")
            protected String taxamt;
            @XmlAttribute(name = "m")
            @XmlSchemaType(name = "positiveInteger")
            protected BigInteger m;

            /**
             * Gets the value of the taxtype property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTAXTYPE() {
                return taxtype;
            }

            /**
             * Sets the value of the taxtype property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTAXTYPE(String value) {
                this.taxtype = value;
            }

            /**
             * Gets the value of the taxamt property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTAXAMT() {
                return taxamt;
            }

            /**
             * Sets the value of the taxamt property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTAXAMT(String value) {
                this.taxamt = value;
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
     *         &lt;element name="WORDAMT" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "wordamt"
    })
    public static class GWORDAMT {

        @XmlElement(name = "WORDAMT")
        protected List<String> wordamt;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the wordamt property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the wordamt property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getWORDAMT().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getWORDAMT() {
            if (wordamt == null) {
                wordamt = new ArrayList<String>();
            }
            return this.wordamt;
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
