
package br.gov.rj.fazenda.arr.ws.interfaces;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for importaReceitaIn complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="importaReceitaIn">
 *   &lt;complexContent>
 *     &lt;extension base="{http://interfaces.ws.viewcontroller.siplag.logus/}abstractImportaReceitaIn">
 *       &lt;sequence>
 *         &lt;element name="apostilamento" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="dataApostilamento" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="codDepositante" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nomeDepositante" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "importaReceitaIn", propOrder = {
    "apostilamento",
    "dataApostilamento",
    "codDepositante",
    "nomeDepositante"
})
public class ImportaReceitaIn
    extends AbstractImportaReceitaIn
{

    protected boolean apostilamento;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataApostilamento;
    protected String codDepositante;
    protected String nomeDepositante;

    /**
     * Gets the value of the apostilamento property.
     * 
     */
    public boolean isApostilamento() {
        return apostilamento;
    }

    /**
     * Sets the value of the apostilamento property.
     * 
     */
    public void setApostilamento(boolean value) {
        this.apostilamento = value;
    }

    /**
     * Gets the value of the dataApostilamento property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataApostilamento() {
        return dataApostilamento;
    }

    /**
     * Sets the value of the dataApostilamento property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataApostilamento(XMLGregorianCalendar value) {
        this.dataApostilamento = value;
    }

    /**
     * Gets the value of the codDepositante property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodDepositante() {
        return codDepositante;
    }

    /**
     * Sets the value of the codDepositante property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodDepositante(String value) {
        this.codDepositante = value;
    }

    /**
     * Gets the value of the nomeDepositante property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeDepositante() {
        return nomeDepositante;
    }

    /**
     * Sets the value of the nomeDepositante property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeDepositante(String value) {
        this.nomeDepositante = value;
    }

}
