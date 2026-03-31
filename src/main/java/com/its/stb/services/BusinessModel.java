
package com.its.stb.services;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for businessModel.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="businessModel">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PERSONAL"/>
 *     &lt;enumeration value="BUSINESS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "businessModel")
@XmlEnum
public enum BusinessModel {

    PERSONAL,
    BUSINESS;

    public String value() {
        return name();
    }

    public static BusinessModel fromValue(String v) {
        return valueOf(v);
    }

}
