
package com.temenos.ebsbsegurosinsmigration;

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
 * <p>Java class for EBSBSEGUROSINSMIGRATIONType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EBSBSEGUROSINSMIGRATIONType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CUSTOMER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CURRENCY" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PACKAGE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BASEAMOUNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ADDITIONALCHARGE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TOTALPREMIUM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ISSUEDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DEBITACCOUNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gCUSTOMERNAME" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="CUSTOMERNAME" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="REPAYMENTFREQ" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NEXTPAYMENTDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LASTDATEPAID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ASSETVALUE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DESTINATION" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gBENNOME" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="mBENNOME" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="BENNOME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="RELATIONSHIP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="BENDOB" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="BENTIPODOC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="BENNUMDOC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ISSTUDENT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="BENPERCENTAGE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="RESERVED7" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
 *         &lt;element name="POLICYEXPDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DATECANCELLED" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DATERENEWED" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="POLICYSTATUS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LOANCONTRACTID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LOANBRANCHID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gPAYMENTDATE" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="mPAYMENTDATE" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="PAYMENTDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="PAYMENTAMOUNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="TRANSACTIONID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="TRANSBRANCH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
 *         &lt;element name="gNARRATIVE" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="NARRATIVE" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="HOLLARDID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VENDEDOR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HOLDERDOB" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gBENDETAILS" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="BENDETAILS" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="gVOYAGE" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="VOYAGE" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="gRISKLOCATION" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="RISKLOCATION" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="EMAIL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PHONENO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gNEXTOFKIN" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="mNEXTOFKIN" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="NEXTOFKIN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="NEXTOFKINDOB" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
 *         &lt;element name="gCANCELREASON" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="CANCELREASON" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="gOTHERDESTN" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="OTHERDESTN" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="gSECURITYTYPE" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="SECURITYTYPE" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="TRANSPORTTYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PACKAGINGTYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ASSETCONSTRYEAR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ASSETCONSTRTYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gDESTFINAL" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="DESTFINAL" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CARGOTYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SUMINSURRED" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gADDRESS" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ADDRESS" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="FURNITURE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ACTIVITYMERCH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ELECTRONICEQUIP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OTHEREQUIP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="THIRDPARTYGOODS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TOTAL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GUARANTEETYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gASSESSOR" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ASSESSOR" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="gTRANSPORTDET" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="TRANSPORTDET" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="g" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="COVERAGETYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PREMIUMINCREASE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ANNUALPAYROLLAMT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="INDUSTRYTYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COMCONTRACTDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CONTRACTTYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WFINPUTTER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WFAUTHORISER" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gSEGRATE" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="mSEGRATE" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="SEGRATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="BIZSUREDESCR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="BZISUREAMOUNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
 *         &lt;element name="SBPAYROLLRATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LOANPROPERTYVALUE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DATESUSPENDED" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EDUPOLTERM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EUDPOLHOLDERAGE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MIGRATIONSTATUS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MIGRATIONDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LASTAMTPAID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LASTTRANSREF" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RESERVED20" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "EBSBSEGUROSINSMIGRATIONType", propOrder = {
    "customer",
    "currency",
    "_package",
    "baseamount",
    "additionalcharge",
    "totalpremium",
    "issuedate",
    "debitaccount",
    "gcustomername",
    "repaymentfreq",
    "nextpaymentdate",
    "lastdatepaid",
    "assetvalue",
    "destination",
    "gbennome",
    "policyexpdate",
    "datecancelled",
    "daterenewed",
    "policystatus",
    "loancontractid",
    "loanbranchid",
    "gpaymentdate",
    "gnarrative",
    "hollardid",
    "vendedor",
    "holderdob",
    "gbendetails",
    "gvoyage",
    "grisklocation",
    "email",
    "phoneno",
    "gnextofkin",
    "gcancelreason",
    "gotherdestn",
    "gsecuritytype",
    "transporttype",
    "packagingtype",
    "assetconstryear",
    "assetconstrtype",
    "gdestfinal",
    "cargotype",
    "suminsurred",
    "gaddress",
    "furniture",
    "activitymerch",
    "electronicequip",
    "otherequip",
    "thirdpartygoods",
    "total",
    "guaranteetype",
    "gassessor",
    "gtransportdet",
    "coveragetype",
    "premiumincrease",
    "annualpayrollamt",
    "industrytype",
    "comcontractdate",
    "contracttype",
    "wfinputter",
    "wfauthoriser",
    "gsegrate",
    "sbpayrollrate",
    "loanpropertyvalue",
    "datesuspended",
    "edupolterm",
    "eudpolholderage",
    "migrationstatus",
    "migrationdate",
    "lastamtpaid",
    "lasttransref",
    "reserved20",
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
public class EBSBSEGUROSINSMIGRATIONType {

    @XmlElement(name = "CUSTOMER")
    protected String customer;
    @XmlElement(name = "CURRENCY")
    protected String currency;
    @XmlElement(name = "PACKAGE")
    protected String _package;
    @XmlElement(name = "BASEAMOUNT")
    protected String baseamount;
    @XmlElement(name = "ADDITIONALCHARGE")
    protected String additionalcharge;
    @XmlElement(name = "TOTALPREMIUM")
    protected String totalpremium;
    @XmlElement(name = "ISSUEDATE")
    protected String issuedate;
    @XmlElement(name = "DEBITACCOUNT")
    protected String debitaccount;
    @XmlElement(name = "gCUSTOMERNAME")
    protected EBSBSEGUROSINSMIGRATIONType.GCUSTOMERNAME gcustomername;
    @XmlElement(name = "REPAYMENTFREQ")
    protected String repaymentfreq;
    @XmlElement(name = "NEXTPAYMENTDATE")
    protected String nextpaymentdate;
    @XmlElement(name = "LASTDATEPAID")
    protected String lastdatepaid;
    @XmlElement(name = "ASSETVALUE")
    protected String assetvalue;
    @XmlElement(name = "DESTINATION")
    protected String destination;
    @XmlElement(name = "gBENNOME")
    protected EBSBSEGUROSINSMIGRATIONType.GBENNOME gbennome;
    @XmlElement(name = "POLICYEXPDATE")
    protected String policyexpdate;
    @XmlElement(name = "DATECANCELLED")
    protected String datecancelled;
    @XmlElement(name = "DATERENEWED")
    protected String daterenewed;
    @XmlElement(name = "POLICYSTATUS")
    protected String policystatus;
    @XmlElement(name = "LOANCONTRACTID")
    protected String loancontractid;
    @XmlElement(name = "LOANBRANCHID")
    protected String loanbranchid;
    @XmlElement(name = "gPAYMENTDATE")
    protected EBSBSEGUROSINSMIGRATIONType.GPAYMENTDATE gpaymentdate;
    @XmlElement(name = "gNARRATIVE")
    protected EBSBSEGUROSINSMIGRATIONType.GNARRATIVE gnarrative;
    @XmlElement(name = "HOLLARDID")
    protected String hollardid;
    @XmlElement(name = "VENDEDOR")
    protected String vendedor;
    @XmlElement(name = "HOLDERDOB")
    protected String holderdob;
    @XmlElement(name = "gBENDETAILS")
    protected EBSBSEGUROSINSMIGRATIONType.GBENDETAILS gbendetails;
    @XmlElement(name = "gVOYAGE")
    protected EBSBSEGUROSINSMIGRATIONType.GVOYAGE gvoyage;
    @XmlElement(name = "gRISKLOCATION")
    protected EBSBSEGUROSINSMIGRATIONType.GRISKLOCATION grisklocation;
    @XmlElement(name = "EMAIL")
    protected String email;
    @XmlElement(name = "PHONENO")
    protected String phoneno;
    @XmlElement(name = "gNEXTOFKIN")
    protected EBSBSEGUROSINSMIGRATIONType.GNEXTOFKIN gnextofkin;
    @XmlElement(name = "gCANCELREASON")
    protected EBSBSEGUROSINSMIGRATIONType.GCANCELREASON gcancelreason;
    @XmlElement(name = "gOTHERDESTN")
    protected EBSBSEGUROSINSMIGRATIONType.GOTHERDESTN gotherdestn;
    @XmlElement(name = "gSECURITYTYPE")
    protected EBSBSEGUROSINSMIGRATIONType.GSECURITYTYPE gsecuritytype;
    @XmlElement(name = "TRANSPORTTYPE")
    protected String transporttype;
    @XmlElement(name = "PACKAGINGTYPE")
    protected String packagingtype;
    @XmlElement(name = "ASSETCONSTRYEAR")
    protected String assetconstryear;
    @XmlElement(name = "ASSETCONSTRTYPE")
    protected String assetconstrtype;
    @XmlElement(name = "gDESTFINAL")
    protected EBSBSEGUROSINSMIGRATIONType.GDESTFINAL gdestfinal;
    @XmlElement(name = "CARGOTYPE")
    protected String cargotype;
    @XmlElement(name = "SUMINSURRED")
    protected String suminsurred;
    @XmlElement(name = "gADDRESS")
    protected EBSBSEGUROSINSMIGRATIONType.GADDRESS gaddress;
    @XmlElement(name = "FURNITURE")
    protected String furniture;
    @XmlElement(name = "ACTIVITYMERCH")
    protected String activitymerch;
    @XmlElement(name = "ELECTRONICEQUIP")
    protected String electronicequip;
    @XmlElement(name = "OTHEREQUIP")
    protected String otherequip;
    @XmlElement(name = "THIRDPARTYGOODS")
    protected String thirdpartygoods;
    @XmlElement(name = "TOTAL")
    protected String total;
    @XmlElement(name = "GUARANTEETYPE")
    protected String guaranteetype;
    @XmlElement(name = "gASSESSOR")
    protected EBSBSEGUROSINSMIGRATIONType.GASSESSOR gassessor;
    @XmlElement(name = "gTRANSPORTDET")
    protected EBSBSEGUROSINSMIGRATIONType.GTRANSPORTDET gtransportdet;
    @XmlElement(name = "COVERAGETYPE")
    protected String coveragetype;
    @XmlElement(name = "PREMIUMINCREASE")
    protected String premiumincrease;
    @XmlElement(name = "ANNUALPAYROLLAMT")
    protected String annualpayrollamt;
    @XmlElement(name = "INDUSTRYTYPE")
    protected String industrytype;
    @XmlElement(name = "COMCONTRACTDATE")
    protected String comcontractdate;
    @XmlElement(name = "CONTRACTTYPE")
    protected String contracttype;
    @XmlElement(name = "WFINPUTTER")
    protected String wfinputter;
    @XmlElement(name = "WFAUTHORISER")
    protected String wfauthoriser;
    @XmlElement(name = "gSEGRATE")
    protected EBSBSEGUROSINSMIGRATIONType.GSEGRATE gsegrate;
    @XmlElement(name = "SBPAYROLLRATE")
    protected String sbpayrollrate;
    @XmlElement(name = "LOANPROPERTYVALUE")
    protected String loanpropertyvalue;
    @XmlElement(name = "DATESUSPENDED")
    protected String datesuspended;
    @XmlElement(name = "EDUPOLTERM")
    protected String edupolterm;
    @XmlElement(name = "EUDPOLHOLDERAGE")
    protected String eudpolholderage;
    @XmlElement(name = "MIGRATIONSTATUS")
    protected String migrationstatus;
    @XmlElement(name = "MIGRATIONDATE")
    protected String migrationdate;
    @XmlElement(name = "LASTAMTPAID")
    protected String lastamtpaid;
    @XmlElement(name = "LASTTRANSREF")
    protected String lasttransref;
    @XmlElement(name = "RESERVED20")
    protected String reserved20;
    @XmlElement(name = "gOVERRIDE")
    protected EBSBSEGUROSINSMIGRATIONType.GOVERRIDE goverride;
    @XmlElement(name = "RECORDSTATUS")
    protected String recordstatus;
    @XmlElement(name = "CURRNO")
    protected String currno;
    @XmlElement(name = "gINPUTTER")
    protected EBSBSEGUROSINSMIGRATIONType.GINPUTTER ginputter;
    @XmlElement(name = "gDATETIME")
    protected EBSBSEGUROSINSMIGRATIONType.GDATETIME gdatetime;
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
     * Gets the value of the customer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCUSTOMER() {
        return customer;
    }

    /**
     * Sets the value of the customer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCUSTOMER(String value) {
        this.customer = value;
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
     * Gets the value of the package property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPACKAGE() {
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
    public void setPACKAGE(String value) {
        this._package = value;
    }

    /**
     * Gets the value of the baseamount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBASEAMOUNT() {
        return baseamount;
    }

    /**
     * Sets the value of the baseamount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBASEAMOUNT(String value) {
        this.baseamount = value;
    }

    /**
     * Gets the value of the additionalcharge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getADDITIONALCHARGE() {
        return additionalcharge;
    }

    /**
     * Sets the value of the additionalcharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setADDITIONALCHARGE(String value) {
        this.additionalcharge = value;
    }

    /**
     * Gets the value of the totalpremium property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTOTALPREMIUM() {
        return totalpremium;
    }

    /**
     * Sets the value of the totalpremium property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTOTALPREMIUM(String value) {
        this.totalpremium = value;
    }

    /**
     * Gets the value of the issuedate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISSUEDATE() {
        return issuedate;
    }

    /**
     * Sets the value of the issuedate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISSUEDATE(String value) {
        this.issuedate = value;
    }

    /**
     * Gets the value of the debitaccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDEBITACCOUNT() {
        return debitaccount;
    }

    /**
     * Sets the value of the debitaccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDEBITACCOUNT(String value) {
        this.debitaccount = value;
    }

    /**
     * Gets the value of the gcustomername property.
     * 
     * @return
     *     possible object is
     *     {@link EBSBSEGUROSINSMIGRATIONType.GCUSTOMERNAME }
     *     
     */
    public EBSBSEGUROSINSMIGRATIONType.GCUSTOMERNAME getGCUSTOMERNAME() {
        return gcustomername;
    }

    /**
     * Sets the value of the gcustomername property.
     * 
     * @param value
     *     allowed object is
     *     {@link EBSBSEGUROSINSMIGRATIONType.GCUSTOMERNAME }
     *     
     */
    public void setGCUSTOMERNAME(EBSBSEGUROSINSMIGRATIONType.GCUSTOMERNAME value) {
        this.gcustomername = value;
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
     * Gets the value of the assetvalue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getASSETVALUE() {
        return assetvalue;
    }

    /**
     * Sets the value of the assetvalue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setASSETVALUE(String value) {
        this.assetvalue = value;
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
     * Gets the value of the gbennome property.
     * 
     * @return
     *     possible object is
     *     {@link EBSBSEGUROSINSMIGRATIONType.GBENNOME }
     *     
     */
    public EBSBSEGUROSINSMIGRATIONType.GBENNOME getGBENNOME() {
        return gbennome;
    }

    /**
     * Sets the value of the gbennome property.
     * 
     * @param value
     *     allowed object is
     *     {@link EBSBSEGUROSINSMIGRATIONType.GBENNOME }
     *     
     */
    public void setGBENNOME(EBSBSEGUROSINSMIGRATIONType.GBENNOME value) {
        this.gbennome = value;
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
     * Gets the value of the datecancelled property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDATECANCELLED() {
        return datecancelled;
    }

    /**
     * Sets the value of the datecancelled property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDATECANCELLED(String value) {
        this.datecancelled = value;
    }

    /**
     * Gets the value of the daterenewed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDATERENEWED() {
        return daterenewed;
    }

    /**
     * Sets the value of the daterenewed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDATERENEWED(String value) {
        this.daterenewed = value;
    }

    /**
     * Gets the value of the policystatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPOLICYSTATUS() {
        return policystatus;
    }

    /**
     * Sets the value of the policystatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPOLICYSTATUS(String value) {
        this.policystatus = value;
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
     * Gets the value of the loanbranchid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLOANBRANCHID() {
        return loanbranchid;
    }

    /**
     * Sets the value of the loanbranchid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLOANBRANCHID(String value) {
        this.loanbranchid = value;
    }

    /**
     * Gets the value of the gpaymentdate property.
     * 
     * @return
     *     possible object is
     *     {@link EBSBSEGUROSINSMIGRATIONType.GPAYMENTDATE }
     *     
     */
    public EBSBSEGUROSINSMIGRATIONType.GPAYMENTDATE getGPAYMENTDATE() {
        return gpaymentdate;
    }

    /**
     * Sets the value of the gpaymentdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link EBSBSEGUROSINSMIGRATIONType.GPAYMENTDATE }
     *     
     */
    public void setGPAYMENTDATE(EBSBSEGUROSINSMIGRATIONType.GPAYMENTDATE value) {
        this.gpaymentdate = value;
    }

    /**
     * Gets the value of the gnarrative property.
     * 
     * @return
     *     possible object is
     *     {@link EBSBSEGUROSINSMIGRATIONType.GNARRATIVE }
     *     
     */
    public EBSBSEGUROSINSMIGRATIONType.GNARRATIVE getGNARRATIVE() {
        return gnarrative;
    }

    /**
     * Sets the value of the gnarrative property.
     * 
     * @param value
     *     allowed object is
     *     {@link EBSBSEGUROSINSMIGRATIONType.GNARRATIVE }
     *     
     */
    public void setGNARRATIVE(EBSBSEGUROSINSMIGRATIONType.GNARRATIVE value) {
        this.gnarrative = value;
    }

    /**
     * Gets the value of the hollardid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHOLLARDID() {
        return hollardid;
    }

    /**
     * Sets the value of the hollardid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHOLLARDID(String value) {
        this.hollardid = value;
    }

    /**
     * Gets the value of the vendedor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVENDEDOR() {
        return vendedor;
    }

    /**
     * Sets the value of the vendedor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVENDEDOR(String value) {
        this.vendedor = value;
    }

    /**
     * Gets the value of the holderdob property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHOLDERDOB() {
        return holderdob;
    }

    /**
     * Sets the value of the holderdob property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHOLDERDOB(String value) {
        this.holderdob = value;
    }

    /**
     * Gets the value of the gbendetails property.
     * 
     * @return
     *     possible object is
     *     {@link EBSBSEGUROSINSMIGRATIONType.GBENDETAILS }
     *     
     */
    public EBSBSEGUROSINSMIGRATIONType.GBENDETAILS getGBENDETAILS() {
        return gbendetails;
    }

    /**
     * Sets the value of the gbendetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link EBSBSEGUROSINSMIGRATIONType.GBENDETAILS }
     *     
     */
    public void setGBENDETAILS(EBSBSEGUROSINSMIGRATIONType.GBENDETAILS value) {
        this.gbendetails = value;
    }

    /**
     * Gets the value of the gvoyage property.
     * 
     * @return
     *     possible object is
     *     {@link EBSBSEGUROSINSMIGRATIONType.GVOYAGE }
     *     
     */
    public EBSBSEGUROSINSMIGRATIONType.GVOYAGE getGVOYAGE() {
        return gvoyage;
    }

    /**
     * Sets the value of the gvoyage property.
     * 
     * @param value
     *     allowed object is
     *     {@link EBSBSEGUROSINSMIGRATIONType.GVOYAGE }
     *     
     */
    public void setGVOYAGE(EBSBSEGUROSINSMIGRATIONType.GVOYAGE value) {
        this.gvoyage = value;
    }

    /**
     * Gets the value of the grisklocation property.
     * 
     * @return
     *     possible object is
     *     {@link EBSBSEGUROSINSMIGRATIONType.GRISKLOCATION }
     *     
     */
    public EBSBSEGUROSINSMIGRATIONType.GRISKLOCATION getGRISKLOCATION() {
        return grisklocation;
    }

    /**
     * Sets the value of the grisklocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link EBSBSEGUROSINSMIGRATIONType.GRISKLOCATION }
     *     
     */
    public void setGRISKLOCATION(EBSBSEGUROSINSMIGRATIONType.GRISKLOCATION value) {
        this.grisklocation = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEMAIL() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEMAIL(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the phoneno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPHONENO() {
        return phoneno;
    }

    /**
     * Sets the value of the phoneno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPHONENO(String value) {
        this.phoneno = value;
    }

    /**
     * Gets the value of the gnextofkin property.
     * 
     * @return
     *     possible object is
     *     {@link EBSBSEGUROSINSMIGRATIONType.GNEXTOFKIN }
     *     
     */
    public EBSBSEGUROSINSMIGRATIONType.GNEXTOFKIN getGNEXTOFKIN() {
        return gnextofkin;
    }

    /**
     * Sets the value of the gnextofkin property.
     * 
     * @param value
     *     allowed object is
     *     {@link EBSBSEGUROSINSMIGRATIONType.GNEXTOFKIN }
     *     
     */
    public void setGNEXTOFKIN(EBSBSEGUROSINSMIGRATIONType.GNEXTOFKIN value) {
        this.gnextofkin = value;
    }

    /**
     * Gets the value of the gcancelreason property.
     * 
     * @return
     *     possible object is
     *     {@link EBSBSEGUROSINSMIGRATIONType.GCANCELREASON }
     *     
     */
    public EBSBSEGUROSINSMIGRATIONType.GCANCELREASON getGCANCELREASON() {
        return gcancelreason;
    }

    /**
     * Sets the value of the gcancelreason property.
     * 
     * @param value
     *     allowed object is
     *     {@link EBSBSEGUROSINSMIGRATIONType.GCANCELREASON }
     *     
     */
    public void setGCANCELREASON(EBSBSEGUROSINSMIGRATIONType.GCANCELREASON value) {
        this.gcancelreason = value;
    }

    /**
     * Gets the value of the gotherdestn property.
     * 
     * @return
     *     possible object is
     *     {@link EBSBSEGUROSINSMIGRATIONType.GOTHERDESTN }
     *     
     */
    public EBSBSEGUROSINSMIGRATIONType.GOTHERDESTN getGOTHERDESTN() {
        return gotherdestn;
    }

    /**
     * Sets the value of the gotherdestn property.
     * 
     * @param value
     *     allowed object is
     *     {@link EBSBSEGUROSINSMIGRATIONType.GOTHERDESTN }
     *     
     */
    public void setGOTHERDESTN(EBSBSEGUROSINSMIGRATIONType.GOTHERDESTN value) {
        this.gotherdestn = value;
    }

    /**
     * Gets the value of the gsecuritytype property.
     * 
     * @return
     *     possible object is
     *     {@link EBSBSEGUROSINSMIGRATIONType.GSECURITYTYPE }
     *     
     */
    public EBSBSEGUROSINSMIGRATIONType.GSECURITYTYPE getGSECURITYTYPE() {
        return gsecuritytype;
    }

    /**
     * Sets the value of the gsecuritytype property.
     * 
     * @param value
     *     allowed object is
     *     {@link EBSBSEGUROSINSMIGRATIONType.GSECURITYTYPE }
     *     
     */
    public void setGSECURITYTYPE(EBSBSEGUROSINSMIGRATIONType.GSECURITYTYPE value) {
        this.gsecuritytype = value;
    }

    /**
     * Gets the value of the transporttype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTRANSPORTTYPE() {
        return transporttype;
    }

    /**
     * Sets the value of the transporttype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTRANSPORTTYPE(String value) {
        this.transporttype = value;
    }

    /**
     * Gets the value of the packagingtype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPACKAGINGTYPE() {
        return packagingtype;
    }

    /**
     * Sets the value of the packagingtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPACKAGINGTYPE(String value) {
        this.packagingtype = value;
    }

    /**
     * Gets the value of the assetconstryear property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getASSETCONSTRYEAR() {
        return assetconstryear;
    }

    /**
     * Sets the value of the assetconstryear property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setASSETCONSTRYEAR(String value) {
        this.assetconstryear = value;
    }

    /**
     * Gets the value of the assetconstrtype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getASSETCONSTRTYPE() {
        return assetconstrtype;
    }

    /**
     * Sets the value of the assetconstrtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setASSETCONSTRTYPE(String value) {
        this.assetconstrtype = value;
    }

    /**
     * Gets the value of the gdestfinal property.
     * 
     * @return
     *     possible object is
     *     {@link EBSBSEGUROSINSMIGRATIONType.GDESTFINAL }
     *     
     */
    public EBSBSEGUROSINSMIGRATIONType.GDESTFINAL getGDESTFINAL() {
        return gdestfinal;
    }

    /**
     * Sets the value of the gdestfinal property.
     * 
     * @param value
     *     allowed object is
     *     {@link EBSBSEGUROSINSMIGRATIONType.GDESTFINAL }
     *     
     */
    public void setGDESTFINAL(EBSBSEGUROSINSMIGRATIONType.GDESTFINAL value) {
        this.gdestfinal = value;
    }

    /**
     * Gets the value of the cargotype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCARGOTYPE() {
        return cargotype;
    }

    /**
     * Sets the value of the cargotype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCARGOTYPE(String value) {
        this.cargotype = value;
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
     * Gets the value of the gaddress property.
     * 
     * @return
     *     possible object is
     *     {@link EBSBSEGUROSINSMIGRATIONType.GADDRESS }
     *     
     */
    public EBSBSEGUROSINSMIGRATIONType.GADDRESS getGADDRESS() {
        return gaddress;
    }

    /**
     * Sets the value of the gaddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link EBSBSEGUROSINSMIGRATIONType.GADDRESS }
     *     
     */
    public void setGADDRESS(EBSBSEGUROSINSMIGRATIONType.GADDRESS value) {
        this.gaddress = value;
    }

    /**
     * Gets the value of the furniture property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFURNITURE() {
        return furniture;
    }

    /**
     * Sets the value of the furniture property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFURNITURE(String value) {
        this.furniture = value;
    }

    /**
     * Gets the value of the activitymerch property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getACTIVITYMERCH() {
        return activitymerch;
    }

    /**
     * Sets the value of the activitymerch property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setACTIVITYMERCH(String value) {
        this.activitymerch = value;
    }

    /**
     * Gets the value of the electronicequip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getELECTRONICEQUIP() {
        return electronicequip;
    }

    /**
     * Sets the value of the electronicequip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setELECTRONICEQUIP(String value) {
        this.electronicequip = value;
    }

    /**
     * Gets the value of the otherequip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOTHEREQUIP() {
        return otherequip;
    }

    /**
     * Sets the value of the otherequip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOTHEREQUIP(String value) {
        this.otherequip = value;
    }

    /**
     * Gets the value of the thirdpartygoods property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTHIRDPARTYGOODS() {
        return thirdpartygoods;
    }

    /**
     * Sets the value of the thirdpartygoods property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTHIRDPARTYGOODS(String value) {
        this.thirdpartygoods = value;
    }

    /**
     * Gets the value of the total property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTOTAL() {
        return total;
    }

    /**
     * Sets the value of the total property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTOTAL(String value) {
        this.total = value;
    }

    /**
     * Gets the value of the guaranteetype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGUARANTEETYPE() {
        return guaranteetype;
    }

    /**
     * Sets the value of the guaranteetype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGUARANTEETYPE(String value) {
        this.guaranteetype = value;
    }

    /**
     * Gets the value of the gassessor property.
     * 
     * @return
     *     possible object is
     *     {@link EBSBSEGUROSINSMIGRATIONType.GASSESSOR }
     *     
     */
    public EBSBSEGUROSINSMIGRATIONType.GASSESSOR getGASSESSOR() {
        return gassessor;
    }

    /**
     * Sets the value of the gassessor property.
     * 
     * @param value
     *     allowed object is
     *     {@link EBSBSEGUROSINSMIGRATIONType.GASSESSOR }
     *     
     */
    public void setGASSESSOR(EBSBSEGUROSINSMIGRATIONType.GASSESSOR value) {
        this.gassessor = value;
    }

    /**
     * Gets the value of the gtransportdet property.
     * 
     * @return
     *     possible object is
     *     {@link EBSBSEGUROSINSMIGRATIONType.GTRANSPORTDET }
     *     
     */
    public EBSBSEGUROSINSMIGRATIONType.GTRANSPORTDET getGTRANSPORTDET() {
        return gtransportdet;
    }

    /**
     * Sets the value of the gtransportdet property.
     * 
     * @param value
     *     allowed object is
     *     {@link EBSBSEGUROSINSMIGRATIONType.GTRANSPORTDET }
     *     
     */
    public void setGTRANSPORTDET(EBSBSEGUROSINSMIGRATIONType.GTRANSPORTDET value) {
        this.gtransportdet = value;
    }

    /**
     * Gets the value of the coveragetype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOVERAGETYPE() {
        return coveragetype;
    }

    /**
     * Sets the value of the coveragetype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOVERAGETYPE(String value) {
        this.coveragetype = value;
    }

    /**
     * Gets the value of the premiumincrease property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPREMIUMINCREASE() {
        return premiumincrease;
    }

    /**
     * Sets the value of the premiumincrease property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPREMIUMINCREASE(String value) {
        this.premiumincrease = value;
    }

    /**
     * Gets the value of the annualpayrollamt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getANNUALPAYROLLAMT() {
        return annualpayrollamt;
    }

    /**
     * Sets the value of the annualpayrollamt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setANNUALPAYROLLAMT(String value) {
        this.annualpayrollamt = value;
    }

    /**
     * Gets the value of the industrytype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINDUSTRYTYPE() {
        return industrytype;
    }

    /**
     * Sets the value of the industrytype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINDUSTRYTYPE(String value) {
        this.industrytype = value;
    }

    /**
     * Gets the value of the comcontractdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOMCONTRACTDATE() {
        return comcontractdate;
    }

    /**
     * Sets the value of the comcontractdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOMCONTRACTDATE(String value) {
        this.comcontractdate = value;
    }

    /**
     * Gets the value of the contracttype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCONTRACTTYPE() {
        return contracttype;
    }

    /**
     * Sets the value of the contracttype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCONTRACTTYPE(String value) {
        this.contracttype = value;
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
     * Gets the value of the gsegrate property.
     * 
     * @return
     *     possible object is
     *     {@link EBSBSEGUROSINSMIGRATIONType.GSEGRATE }
     *     
     */
    public EBSBSEGUROSINSMIGRATIONType.GSEGRATE getGSEGRATE() {
        return gsegrate;
    }

    /**
     * Sets the value of the gsegrate property.
     * 
     * @param value
     *     allowed object is
     *     {@link EBSBSEGUROSINSMIGRATIONType.GSEGRATE }
     *     
     */
    public void setGSEGRATE(EBSBSEGUROSINSMIGRATIONType.GSEGRATE value) {
        this.gsegrate = value;
    }

    /**
     * Gets the value of the sbpayrollrate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSBPAYROLLRATE() {
        return sbpayrollrate;
    }

    /**
     * Sets the value of the sbpayrollrate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSBPAYROLLRATE(String value) {
        this.sbpayrollrate = value;
    }

    /**
     * Gets the value of the loanpropertyvalue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLOANPROPERTYVALUE() {
        return loanpropertyvalue;
    }

    /**
     * Sets the value of the loanpropertyvalue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLOANPROPERTYVALUE(String value) {
        this.loanpropertyvalue = value;
    }

    /**
     * Gets the value of the datesuspended property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDATESUSPENDED() {
        return datesuspended;
    }

    /**
     * Sets the value of the datesuspended property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDATESUSPENDED(String value) {
        this.datesuspended = value;
    }

    /**
     * Gets the value of the edupolterm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEDUPOLTERM() {
        return edupolterm;
    }

    /**
     * Sets the value of the edupolterm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEDUPOLTERM(String value) {
        this.edupolterm = value;
    }

    /**
     * Gets the value of the eudpolholderage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEUDPOLHOLDERAGE() {
        return eudpolholderage;
    }

    /**
     * Sets the value of the eudpolholderage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEUDPOLHOLDERAGE(String value) {
        this.eudpolholderage = value;
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
     * Gets the value of the lastamtpaid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLASTAMTPAID() {
        return lastamtpaid;
    }

    /**
     * Sets the value of the lastamtpaid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLASTAMTPAID(String value) {
        this.lastamtpaid = value;
    }

    /**
     * Gets the value of the lasttransref property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLASTTRANSREF() {
        return lasttransref;
    }

    /**
     * Sets the value of the lasttransref property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLASTTRANSREF(String value) {
        this.lasttransref = value;
    }

    /**
     * Gets the value of the reserved20 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRESERVED20() {
        return reserved20;
    }

    /**
     * Sets the value of the reserved20 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRESERVED20(String value) {
        this.reserved20 = value;
    }

    /**
     * Gets the value of the goverride property.
     * 
     * @return
     *     possible object is
     *     {@link EBSBSEGUROSINSMIGRATIONType.GOVERRIDE }
     *     
     */
    public EBSBSEGUROSINSMIGRATIONType.GOVERRIDE getGOVERRIDE() {
        return goverride;
    }

    /**
     * Sets the value of the goverride property.
     * 
     * @param value
     *     allowed object is
     *     {@link EBSBSEGUROSINSMIGRATIONType.GOVERRIDE }
     *     
     */
    public void setGOVERRIDE(EBSBSEGUROSINSMIGRATIONType.GOVERRIDE value) {
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
     *     {@link EBSBSEGUROSINSMIGRATIONType.GINPUTTER }
     *     
     */
    public EBSBSEGUROSINSMIGRATIONType.GINPUTTER getGINPUTTER() {
        return ginputter;
    }

    /**
     * Sets the value of the ginputter property.
     * 
     * @param value
     *     allowed object is
     *     {@link EBSBSEGUROSINSMIGRATIONType.GINPUTTER }
     *     
     */
    public void setGINPUTTER(EBSBSEGUROSINSMIGRATIONType.GINPUTTER value) {
        this.ginputter = value;
    }

    /**
     * Gets the value of the gdatetime property.
     * 
     * @return
     *     possible object is
     *     {@link EBSBSEGUROSINSMIGRATIONType.GDATETIME }
     *     
     */
    public EBSBSEGUROSINSMIGRATIONType.GDATETIME getGDATETIME() {
        return gdatetime;
    }

    /**
     * Sets the value of the gdatetime property.
     * 
     * @param value
     *     allowed object is
     *     {@link EBSBSEGUROSINSMIGRATIONType.GDATETIME }
     *     
     */
    public void setGDATETIME(EBSBSEGUROSINSMIGRATIONType.GDATETIME value) {
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
     *         &lt;element name="ADDRESS" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "address"
    })
    public static class GADDRESS {

        @XmlElement(name = "ADDRESS")
        protected List<String> address;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the address property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the address property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getADDRESS().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getADDRESS() {
            if (address == null) {
                address = new ArrayList<String>();
            }
            return this.address;
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
     *         &lt;element name="ASSESSOR" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "assessor"
    })
    public static class GASSESSOR {

        @XmlElement(name = "ASSESSOR")
        protected List<String> assessor;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the assessor property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the assessor property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getASSESSOR().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getASSESSOR() {
            if (assessor == null) {
                assessor = new ArrayList<String>();
            }
            return this.assessor;
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
     *         &lt;element name="BENDETAILS" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "bendetails"
    })
    public static class GBENDETAILS {

        @XmlElement(name = "BENDETAILS")
        protected List<String> bendetails;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the bendetails property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the bendetails property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBENDETAILS().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getBENDETAILS() {
            if (bendetails == null) {
                bendetails = new ArrayList<String>();
            }
            return this.bendetails;
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
     *         &lt;element name="mBENNOME" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="BENNOME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="RELATIONSHIP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="BENDOB" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="BENTIPODOC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="BENNUMDOC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ISSTUDENT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="BENPERCENTAGE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="RESERVED7" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "mbennome"
    })
    public static class GBENNOME {

        @XmlElement(name = "mBENNOME")
        protected List<EBSBSEGUROSINSMIGRATIONType.GBENNOME.MBENNOME> mbennome;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the mbennome property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the mbennome property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMBENNOME().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link EBSBSEGUROSINSMIGRATIONType.GBENNOME.MBENNOME }
         * 
         * 
         */
        public List<EBSBSEGUROSINSMIGRATIONType.GBENNOME.MBENNOME> getMBENNOME() {
            if (mbennome == null) {
                mbennome = new ArrayList<EBSBSEGUROSINSMIGRATIONType.GBENNOME.MBENNOME>();
            }
            return this.mbennome;
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
         *         &lt;element name="BENNOME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="RELATIONSHIP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="BENDOB" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="BENTIPODOC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="BENNUMDOC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ISSTUDENT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="BENPERCENTAGE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="RESERVED7" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "bennome",
            "relationship",
            "bendob",
            "bentipodoc",
            "bennumdoc",
            "isstudent",
            "benpercentage",
            "reserved7"
        })
        public static class MBENNOME {

            @XmlElement(name = "BENNOME")
            protected String bennome;
            @XmlElement(name = "RELATIONSHIP")
            protected String relationship;
            @XmlElement(name = "BENDOB")
            protected String bendob;
            @XmlElement(name = "BENTIPODOC")
            protected String bentipodoc;
            @XmlElement(name = "BENNUMDOC")
            protected String bennumdoc;
            @XmlElement(name = "ISSTUDENT")
            protected String isstudent;
            @XmlElement(name = "BENPERCENTAGE")
            protected String benpercentage;
            @XmlElement(name = "RESERVED7")
            protected String reserved7;
            @XmlAttribute(name = "m")
            @XmlSchemaType(name = "positiveInteger")
            protected BigInteger m;

            /**
             * Gets the value of the bennome property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBENNOME() {
                return bennome;
            }

            /**
             * Sets the value of the bennome property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBENNOME(String value) {
                this.bennome = value;
            }

            /**
             * Gets the value of the relationship property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRELATIONSHIP() {
                return relationship;
            }

            /**
             * Sets the value of the relationship property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRELATIONSHIP(String value) {
                this.relationship = value;
            }

            /**
             * Gets the value of the bendob property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBENDOB() {
                return bendob;
            }

            /**
             * Sets the value of the bendob property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBENDOB(String value) {
                this.bendob = value;
            }

            /**
             * Gets the value of the bentipodoc property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBENTIPODOC() {
                return bentipodoc;
            }

            /**
             * Sets the value of the bentipodoc property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBENTIPODOC(String value) {
                this.bentipodoc = value;
            }

            /**
             * Gets the value of the bennumdoc property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBENNUMDOC() {
                return bennumdoc;
            }

            /**
             * Sets the value of the bennumdoc property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBENNUMDOC(String value) {
                this.bennumdoc = value;
            }

            /**
             * Gets the value of the isstudent property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getISSTUDENT() {
                return isstudent;
            }

            /**
             * Sets the value of the isstudent property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setISSTUDENT(String value) {
                this.isstudent = value;
            }

            /**
             * Gets the value of the benpercentage property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBENPERCENTAGE() {
                return benpercentage;
            }

            /**
             * Sets the value of the benpercentage property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBENPERCENTAGE(String value) {
                this.benpercentage = value;
            }

            /**
             * Gets the value of the reserved7 property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRESERVED7() {
                return reserved7;
            }

            /**
             * Sets the value of the reserved7 property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRESERVED7(String value) {
                this.reserved7 = value;
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
     *         &lt;element name="CANCELREASON" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "cancelreason"
    })
    public static class GCANCELREASON {

        @XmlElement(name = "CANCELREASON")
        protected List<String> cancelreason;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the cancelreason property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the cancelreason property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCANCELREASON().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getCANCELREASON() {
            if (cancelreason == null) {
                cancelreason = new ArrayList<String>();
            }
            return this.cancelreason;
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
     *         &lt;element name="CUSTOMERNAME" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "customername"
    })
    public static class GCUSTOMERNAME {

        @XmlElement(name = "CUSTOMERNAME")
        protected List<String> customername;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the customername property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the customername property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCUSTOMERNAME().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getCUSTOMERNAME() {
            if (customername == null) {
                customername = new ArrayList<String>();
            }
            return this.customername;
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
     *         &lt;element name="DESTFINAL" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "destfinal"
    })
    public static class GDESTFINAL {

        @XmlElement(name = "DESTFINAL")
        protected List<String> destfinal;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the destfinal property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the destfinal property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDESTFINAL().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getDESTFINAL() {
            if (destfinal == null) {
                destfinal = new ArrayList<String>();
            }
            return this.destfinal;
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
     *         &lt;element name="NARRATIVE" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "narrative"
    })
    public static class GNARRATIVE {

        @XmlElement(name = "NARRATIVE")
        protected List<String> narrative;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the narrative property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the narrative property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getNARRATIVE().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getNARRATIVE() {
            if (narrative == null) {
                narrative = new ArrayList<String>();
            }
            return this.narrative;
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
     *         &lt;element name="mNEXTOFKIN" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="NEXTOFKIN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="NEXTOFKINDOB" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "mnextofkin"
    })
    public static class GNEXTOFKIN {

        @XmlElement(name = "mNEXTOFKIN")
        protected List<EBSBSEGUROSINSMIGRATIONType.GNEXTOFKIN.MNEXTOFKIN> mnextofkin;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the mnextofkin property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the mnextofkin property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMNEXTOFKIN().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link EBSBSEGUROSINSMIGRATIONType.GNEXTOFKIN.MNEXTOFKIN }
         * 
         * 
         */
        public List<EBSBSEGUROSINSMIGRATIONType.GNEXTOFKIN.MNEXTOFKIN> getMNEXTOFKIN() {
            if (mnextofkin == null) {
                mnextofkin = new ArrayList<EBSBSEGUROSINSMIGRATIONType.GNEXTOFKIN.MNEXTOFKIN>();
            }
            return this.mnextofkin;
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
         *         &lt;element name="NEXTOFKIN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="NEXTOFKINDOB" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "nextofkin",
            "nextofkindob"
        })
        public static class MNEXTOFKIN {

            @XmlElement(name = "NEXTOFKIN")
            protected String nextofkin;
            @XmlElement(name = "NEXTOFKINDOB")
            protected String nextofkindob;
            @XmlAttribute(name = "m")
            @XmlSchemaType(name = "positiveInteger")
            protected BigInteger m;

            /**
             * Gets the value of the nextofkin property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNEXTOFKIN() {
                return nextofkin;
            }

            /**
             * Sets the value of the nextofkin property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNEXTOFKIN(String value) {
                this.nextofkin = value;
            }

            /**
             * Gets the value of the nextofkindob property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNEXTOFKINDOB() {
                return nextofkindob;
            }

            /**
             * Sets the value of the nextofkindob property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNEXTOFKINDOB(String value) {
                this.nextofkindob = value;
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
     *         &lt;element name="OTHERDESTN" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "otherdestn"
    })
    public static class GOTHERDESTN {

        @XmlElement(name = "OTHERDESTN")
        protected List<String> otherdestn;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the otherdestn property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the otherdestn property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getOTHERDESTN().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getOTHERDESTN() {
            if (otherdestn == null) {
                otherdestn = new ArrayList<String>();
            }
            return this.otherdestn;
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
     *         &lt;element name="mPAYMENTDATE" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="PAYMENTDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="PAYMENTAMOUNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="TRANSACTIONID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="TRANSBRANCH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "mpaymentdate"
    })
    public static class GPAYMENTDATE {

        @XmlElement(name = "mPAYMENTDATE")
        protected List<EBSBSEGUROSINSMIGRATIONType.GPAYMENTDATE.MPAYMENTDATE> mpaymentdate;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the mpaymentdate property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the mpaymentdate property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMPAYMENTDATE().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link EBSBSEGUROSINSMIGRATIONType.GPAYMENTDATE.MPAYMENTDATE }
         * 
         * 
         */
        public List<EBSBSEGUROSINSMIGRATIONType.GPAYMENTDATE.MPAYMENTDATE> getMPAYMENTDATE() {
            if (mpaymentdate == null) {
                mpaymentdate = new ArrayList<EBSBSEGUROSINSMIGRATIONType.GPAYMENTDATE.MPAYMENTDATE>();
            }
            return this.mpaymentdate;
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
         *         &lt;element name="PAYMENTDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="PAYMENTAMOUNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="TRANSACTIONID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="TRANSBRANCH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "paymentdate",
            "paymentamount",
            "transactionid",
            "transbranch"
        })
        public static class MPAYMENTDATE {

            @XmlElement(name = "PAYMENTDATE")
            protected String paymentdate;
            @XmlElement(name = "PAYMENTAMOUNT")
            protected String paymentamount;
            @XmlElement(name = "TRANSACTIONID")
            protected String transactionid;
            @XmlElement(name = "TRANSBRANCH")
            protected String transbranch;
            @XmlAttribute(name = "m")
            @XmlSchemaType(name = "positiveInteger")
            protected BigInteger m;

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
             * Gets the value of the paymentamount property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPAYMENTAMOUNT() {
                return paymentamount;
            }

            /**
             * Sets the value of the paymentamount property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPAYMENTAMOUNT(String value) {
                this.paymentamount = value;
            }

            /**
             * Gets the value of the transactionid property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTRANSACTIONID() {
                return transactionid;
            }

            /**
             * Sets the value of the transactionid property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTRANSACTIONID(String value) {
                this.transactionid = value;
            }

            /**
             * Gets the value of the transbranch property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTRANSBRANCH() {
                return transbranch;
            }

            /**
             * Sets the value of the transbranch property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTRANSBRANCH(String value) {
                this.transbranch = value;
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
     *         &lt;element name="RISKLOCATION" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "risklocation"
    })
    public static class GRISKLOCATION {

        @XmlElement(name = "RISKLOCATION")
        protected List<String> risklocation;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the risklocation property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the risklocation property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRISKLOCATION().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getRISKLOCATION() {
            if (risklocation == null) {
                risklocation = new ArrayList<String>();
            }
            return this.risklocation;
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
     *         &lt;element name="SECURITYTYPE" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "securitytype"
    })
    public static class GSECURITYTYPE {

        @XmlElement(name = "SECURITYTYPE")
        protected List<String> securitytype;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the securitytype property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the securitytype property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSECURITYTYPE().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getSECURITYTYPE() {
            if (securitytype == null) {
                securitytype = new ArrayList<String>();
            }
            return this.securitytype;
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
     *         &lt;element name="mSEGRATE" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="SEGRATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="BIZSUREDESCR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="BZISUREAMOUNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "msegrate"
    })
    public static class GSEGRATE {

        @XmlElement(name = "mSEGRATE")
        protected List<EBSBSEGUROSINSMIGRATIONType.GSEGRATE.MSEGRATE> msegrate;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the msegrate property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the msegrate property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMSEGRATE().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link EBSBSEGUROSINSMIGRATIONType.GSEGRATE.MSEGRATE }
         * 
         * 
         */
        public List<EBSBSEGUROSINSMIGRATIONType.GSEGRATE.MSEGRATE> getMSEGRATE() {
            if (msegrate == null) {
                msegrate = new ArrayList<EBSBSEGUROSINSMIGRATIONType.GSEGRATE.MSEGRATE>();
            }
            return this.msegrate;
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
         *         &lt;element name="SEGRATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="BIZSUREDESCR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="BZISUREAMOUNT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "segrate",
            "bizsuredescr",
            "bzisureamount"
        })
        public static class MSEGRATE {

            @XmlElement(name = "SEGRATE")
            protected String segrate;
            @XmlElement(name = "BIZSUREDESCR")
            protected String bizsuredescr;
            @XmlElement(name = "BZISUREAMOUNT")
            protected String bzisureamount;
            @XmlAttribute(name = "m")
            @XmlSchemaType(name = "positiveInteger")
            protected BigInteger m;

            /**
             * Gets the value of the segrate property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSEGRATE() {
                return segrate;
            }

            /**
             * Sets the value of the segrate property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSEGRATE(String value) {
                this.segrate = value;
            }

            /**
             * Gets the value of the bizsuredescr property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBIZSUREDESCR() {
                return bizsuredescr;
            }

            /**
             * Sets the value of the bizsuredescr property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBIZSUREDESCR(String value) {
                this.bizsuredescr = value;
            }

            /**
             * Gets the value of the bzisureamount property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBZISUREAMOUNT() {
                return bzisureamount;
            }

            /**
             * Sets the value of the bzisureamount property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBZISUREAMOUNT(String value) {
                this.bzisureamount = value;
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
     *         &lt;element name="TRANSPORTDET" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "transportdet"
    })
    public static class GTRANSPORTDET {

        @XmlElement(name = "TRANSPORTDET")
        protected List<String> transportdet;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the transportdet property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the transportdet property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTRANSPORTDET().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getTRANSPORTDET() {
            if (transportdet == null) {
                transportdet = new ArrayList<String>();
            }
            return this.transportdet;
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
     *         &lt;element name="VOYAGE" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "voyage"
    })
    public static class GVOYAGE {

        @XmlElement(name = "VOYAGE")
        protected List<String> voyage;
        @XmlAttribute(name = "g")
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger g;

        /**
         * Gets the value of the voyage property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the voyage property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getVOYAGE().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getVOYAGE() {
            if (voyage == null) {
                voyage = new ArrayList<String>();
            }
            return this.voyage;
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
