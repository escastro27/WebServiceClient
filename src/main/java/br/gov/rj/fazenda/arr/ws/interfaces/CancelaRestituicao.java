
package br.gov.rj.fazenda.arr.ws.interfaces;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cancelaRestituicao complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cancelaRestituicao">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="in" type="{http://interfaces.ws.viewcontroller.siplag.logus/}cancelaRestituicaoIn" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cancelaRestituicao", propOrder = {
    "in"
})
public class CancelaRestituicao {

    protected CancelaRestituicaoIn in;

    /**
     * Gets the value of the in property.
     * 
     * @return
     *     possible object is
     *     {@link CancelaRestituicaoIn }
     *     
     */
    public CancelaRestituicaoIn getIn() {
        return in;
    }

    /**
     * Sets the value of the in property.
     * 
     * @param value
     *     allowed object is
     *     {@link CancelaRestituicaoIn }
     *     
     */
    public void setIn(CancelaRestituicaoIn value) {
        this.in = value;
    }

}
