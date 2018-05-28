//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1-b171012.0423 
//         See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
//         Any modifications to this file will be lost upon recompilation of the source schema. 
//         Generated on: 2018.05.24 at 10:06:54 PM ECT 
//


package com.ec.virtualcoin.buy.payment.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ResponseCode" type="{http://www.w3.org/2001/XMLSchema}byte"/&gt;
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Reference" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="TransactionID" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="ProcessingTime" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *         &lt;element name="StatusCode" type="{http://www.w3.org/2001/XMLSchema}byte"/&gt;
 *         &lt;element name="StatusDescription" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="AuthCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ScrubResult" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="AVSResult" type="{http://www.w3.org/2001/XMLSchema}byte"/&gt;
 *         &lt;element name="CVVResult" type="{http://www.w3.org/2001/XMLSchema}byte"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "responseCode",
    "description",
    "reference",
    "transactionID",
    "processingTime",
    "statusCode",
    "statusDescription",
    "authCode",
    "scrubResult",
    "avsResult",
    "cvvResult"
})
@XmlRootElement(name = "Response")
public class Response {

    @XmlElement(name = "ResponseCode")
    protected byte responseCode;
    @XmlElement(name = "Description", required = true)
    protected String description;
    @XmlElement(name = "Reference", required = true)
    protected String reference;
    @XmlElement(name = "TransactionID")
    protected long transactionID;
    @XmlElement(name = "ProcessingTime")
    protected float processingTime;
    @XmlElement(name = "StatusCode")
    protected byte statusCode;
    @XmlElement(name = "StatusDescription", required = true)
    protected String statusDescription;
    @XmlElement(name = "AuthCode", required = true)
    protected String authCode;
    @XmlElement(name = "ScrubResult", required = true)
    protected String scrubResult;
    @XmlElement(name = "AVSResult")
    protected byte avsResult;
    @XmlElement(name = "CVVResult")
    protected byte cvvResult;
    @XmlAttribute(name = "type")
    protected String type;

    /**
     * Gets the value of the responseCode property.
     * 
     */
    public byte getResponseCode() {
        return responseCode;
    }

    /**
     * Sets the value of the responseCode property.
     * 
     */
    public void setResponseCode(byte value) {
        this.responseCode = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the reference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReference() {
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
    public void setReference(String value) {
        this.reference = value;
    }

    /**
     * Gets the value of the transactionID property.
     * 
     */
    public long getTransactionID() {
        return transactionID;
    }

    /**
     * Sets the value of the transactionID property.
     * 
     */
    public void setTransactionID(long value) {
        this.transactionID = value;
    }

    /**
     * Gets the value of the processingTime property.
     * 
     */
    public float getProcessingTime() {
        return processingTime;
    }

    /**
     * Sets the value of the processingTime property.
     * 
     */
    public void setProcessingTime(float value) {
        this.processingTime = value;
    }

    /**
     * Gets the value of the statusCode property.
     * 
     */
    public byte getStatusCode() {
        return statusCode;
    }

    /**
     * Sets the value of the statusCode property.
     * 
     */
    public void setStatusCode(byte value) {
        this.statusCode = value;
    }

    /**
     * Gets the value of the statusDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusDescription() {
        return statusDescription;
    }

    /**
     * Sets the value of the statusDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusDescription(String value) {
        this.statusDescription = value;
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
     * Gets the value of the scrubResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScrubResult() {
        return scrubResult;
    }

    /**
     * Sets the value of the scrubResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScrubResult(String value) {
        this.scrubResult = value;
    }

    /**
     * Gets the value of the avsResult property.
     * 
     */
    public byte getAVSResult() {
        return avsResult;
    }

    /**
     * Sets the value of the avsResult property.
     * 
     */
    public void setAVSResult(byte value) {
        this.avsResult = value;
    }

    /**
     * Gets the value of the cvvResult property.
     * 
     */
    public byte getCVVResult() {
        return cvvResult;
    }

    /**
     * Sets the value of the cvvResult property.
     * 
     */
    public void setCVVResult(byte value) {
        this.cvvResult = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

}
