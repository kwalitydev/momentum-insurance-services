
package com.its.stb.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for processPendingNotificationsOut complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="processPendingNotificationsOut">
 *   &lt;complexContent>
 *     &lt;extension base="{http://services.stb.its.com/}genericServiceOut">
 *       &lt;sequence>
 *         &lt;element name="processedCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "processPendingNotificationsOut", propOrder = {
    "processedCount"
})
public class ProcessPendingNotificationsOut
    extends GenericServiceOut
{

    protected int processedCount;

    /**
     * Gets the value of the processedCount property.
     * 
     */
    public int getProcessedCount() {
        return processedCount;
    }

    /**
     * Sets the value of the processedCount property.
     * 
     */
    public void setProcessedCount(int value) {
        this.processedCount = value;
    }

}
