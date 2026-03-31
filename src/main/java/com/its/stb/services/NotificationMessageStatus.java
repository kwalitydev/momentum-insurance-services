
package com.its.stb.services;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for notificationMessageStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="notificationMessageStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PENDING"/>
 *     &lt;enumeration value="SENT"/>
 *     &lt;enumeration value="FAILED_EXPIRED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "notificationMessageStatus")
@XmlEnum
public enum NotificationMessageStatus {

    PENDING,
    SENT,
    FAILED_EXPIRED;

    public String value() {
        return name();
    }

    public static NotificationMessageStatus fromValue(String v) {
        return valueOf(v);
    }

}
