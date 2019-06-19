
package br.gov.rj.fazenda.arr.ws.interfaces;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for abstractImportaReceitaIn complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="abstractImportaReceitaIn">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sequencial" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="dataArrecadacao" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dataRepasse" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="valor" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="codCampoFinanceiro" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="codSistema" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="codUnidadeGestora" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codTipoDocumento" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="codigoReceita" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codMunicipio" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "abstractImportaReceitaIn", propOrder = {
    "sequencial",
    "dataArrecadacao",
    "dataRepasse",
    "valor",
    "codCampoFinanceiro",
    "codSistema",
    "codUnidadeGestora",
    "codTipoDocumento",
    "codigoReceita",
    "codMunicipio"
})
@XmlSeeAlso({
    ImportaRestituicaoIn.class,
    ImportaReceitaIn.class
})
public class AbstractImportaReceitaIn {

    @XmlElement(defaultValue = "-2147483648")
    protected int sequencial;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataArrecadacao;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataRepasse;
    @XmlElement(required = true, type = Double.class, defaultValue = "-999999999999999999.0", nillable = true)
    protected Double valor;
    @XmlElement(required = true, type = Integer.class, defaultValue = "-2147483648", nillable = true)
    protected Integer codCampoFinanceiro;
    @XmlElement(required = true, type = Integer.class, defaultValue = "-2147483648", nillable = true)
    protected Integer codSistema;
    @XmlElement(required = true)
    protected String codUnidadeGestora;
    @XmlElement(required = true, type = Integer.class, defaultValue = "-2147483648", nillable = true)
    protected Integer codTipoDocumento;
    @XmlElement(required = true)
    protected String codigoReceita;
    @XmlElementRef(name = "codMunicipio", type = JAXBElement.class)
    protected JAXBElement<Integer> codMunicipio;

    /**
     * Gets the value of the sequencial property.
     * 
     */
    public int getSequencial() {
        return sequencial;
    }

    /**
     * Sets the value of the sequencial property.
     * 
     */
    public void setSequencial(int value) {
        this.sequencial = value;
    }

    /**
     * Gets the value of the dataArrecadacao property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataArrecadacao() {
        return dataArrecadacao;
    }

    /**
     * Sets the value of the dataArrecadacao property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataArrecadacao(XMLGregorianCalendar value) {
        this.dataArrecadacao = value;
    }

    /**
     * Gets the value of the dataRepasse property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataRepasse() {
        return dataRepasse;
    }

    /**
     * Sets the value of the dataRepasse property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataRepasse(XMLGregorianCalendar value) {
        this.dataRepasse = value;
    }

    /**
     * Gets the value of the valor property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getValor() {
        return valor;
    }

    /**
     * Sets the value of the valor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setValor(Double value) {
        this.valor = value;
    }

    /**
     * Gets the value of the codCampoFinanceiro property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodCampoFinanceiro() {
        return codCampoFinanceiro;
    }

    /**
     * Sets the value of the codCampoFinanceiro property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodCampoFinanceiro(Integer value) {
        this.codCampoFinanceiro = value;
    }

    /**
     * Gets the value of the codSistema property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodSistema() {
        return codSistema;
    }

    /**
     * Sets the value of the codSistema property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodSistema(Integer value) {
        this.codSistema = value;
    }

    /**
     * Gets the value of the codUnidadeGestora property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodUnidadeGestora() {
        return codUnidadeGestora;
    }

    /**
     * Sets the value of the codUnidadeGestora property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodUnidadeGestora(String value) {
        this.codUnidadeGestora = value;
    }

    /**
     * Gets the value of the codTipoDocumento property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodTipoDocumento() {
        return codTipoDocumento;
    }

    /**
     * Sets the value of the codTipoDocumento property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodTipoDocumento(Integer value) {
        this.codTipoDocumento = value;
    }

    /**
     * Gets the value of the codigoReceita property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoReceita() {
        return codigoReceita;
    }

    /**
     * Sets the value of the codigoReceita property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoReceita(String value) {
        this.codigoReceita = value;
    }

    /**
     * Gets the value of the codMunicipio property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getCodMunicipio() {
        return codMunicipio;
    }

    /**
     * Sets the value of the codMunicipio property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setCodMunicipio(JAXBElement<Integer> value) {
        this.codMunicipio = ((JAXBElement<Integer> ) value);
    }

}
