
package com.its.stb.services;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for traceLevels.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="traceLevels">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DEBUG"/>
 *     &lt;enumeration value="INFO"/>
 *     &lt;enumeration value="ERROR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "traceLevels")
@XmlEnum
public enum TraceLevels {

    DEBUG,
    INFO,
    ERROR;

    public String value() {
        return name();
    }

    public static TraceLevels fromValue(String v) {
        return valueOf(v);
    }

}
