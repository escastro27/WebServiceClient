
package br.gov.rj.fazenda.arr.ws.interfaces;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for importaReceita complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="importaReceita">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="in" type="{http://interfaces.ws.viewcontroller.siplag.logus/}importaReceitaIn" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "importaReceita", propOrder = {
    "in"
})
public class ImportaReceita {

    protected ImportaReceitaIn in;

    /**
     * Gets the value of the in property.
     * 
     * @return
     *     possible object is
     *     {@link ImportaReceitaIn }
     *     
     */
    public ImportaReceitaIn getIn() {
        return in;
    }

    /**
     * Sets the value of the in property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImportaReceitaIn }
     *     
     */
    public void setIn(ImportaReceitaIn value) {
        this.in = value;
    }

}
