
package br.gov.rj.fazenda.arr.ws.interfaces;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cancelaRestituicaoResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cancelaRestituicaoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="out" type="{http://interfaces.ws.viewcontroller.siplag.logus/}cancelaRestituicaoOut" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cancelaRestituicaoResponse", propOrder = {
    "out"
})
public class CancelaRestituicaoResponse {

    protected CancelaRestituicaoOut out;

    /**
     * Gets the value of the out property.
     * 
     * @return
     *     possible object is
     *     {@link CancelaRestituicaoOut }
     *     
     */
    public CancelaRestituicaoOut getOut() {
        return out;
    }

    /**
     * Sets the value of the out property.
     * 
     * @param value
     *     allowed object is
     *     {@link CancelaRestituicaoOut }
     *     
     */
    public void setOut(CancelaRestituicaoOut value) {
        this.out = value;
    }

}
