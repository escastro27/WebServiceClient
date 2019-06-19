
package br.gov.rj.fazenda.arr.ws.interfaces;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for importaRestituicaoResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="importaRestituicaoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="out" type="{http://interfaces.ws.viewcontroller.siplag.logus/}importaRestituicaoOut" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "importaRestituicaoResponse", propOrder = {
    "out"
})
public class ImportaRestituicaoResponse {

    protected ImportaRestituicaoOut out;

    /**
     * Gets the value of the out property.
     * 
     * @return
     *     possible object is
     *     {@link ImportaRestituicaoOut }
     *     
     */
    public ImportaRestituicaoOut getOut() {
        return out;
    }

    /**
     * Sets the value of the out property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImportaRestituicaoOut }
     *     
     */
    public void setOut(ImportaRestituicaoOut value) {
        this.out = value;
    }

}
