
package br.gov.rj.fazenda.arr.ws.interfaces;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for importaRestituicaoIn complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="importaRestituicaoIn">
 *   &lt;complexContent>
 *     &lt;extension base="{http://interfaces.ws.viewcontroller.siplag.logus/}abstractImportaReceitaIn">
 *       &lt;sequence>
 *         &lt;element name="idRestituicao" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="dataPagamento" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="dataBaseCorrecao" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="dataSinalizacao" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="dataRestituicao" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="codRestituido" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nomeRestituido" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="codBanco" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codAgencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codConta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codFormaRestituicao" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="codFato" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "importaRestituicaoIn", propOrder = {
    "idRestituicao",
    "dataPagamento",
    "dataBaseCorrecao",
    "dataSinalizacao",
    "dataRestituicao",
    "codRestituido",
    "nomeRestituido",
    "codBanco",
    "codAgencia",
    "codConta",
    "codFormaRestituicao",
    "codFato"
})
public class ImportaRestituicaoIn
    extends AbstractImportaReceitaIn
{

    @XmlElement(required = true, type = Long.class, defaultValue = "-9223372036854775808", nillable = true)
    protected Long idRestituicao;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataPagamento;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataBaseCorrecao;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataSinalizacao;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataRestituicao;
    @XmlElement(required = true)
    protected String codRestituido;
    @XmlElement(required = true)
    protected String nomeRestituido;
    protected String codBanco;
    protected String codAgencia;
    protected String codConta;
    @XmlElement(required = true, type = Integer.class, defaultValue = "-2147483648", nillable = true)
    protected Integer codFormaRestituicao;
    @XmlElement(required = true, type = Integer.class, defaultValue = "-2147483648", nillable = true)
    protected Integer codFato;

    /**
     * Gets the value of the idRestituicao property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdRestituicao() {
        return idRestituicao;
    }

    /**
     * Sets the value of the idRestituicao property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdRestituicao(Long value) {
        this.idRestituicao = value;
    }

    /**
     * Gets the value of the dataPagamento property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataPagamento() {
        return dataPagamento;
    }

    /**
     * Sets the value of the dataPagamento property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataPagamento(XMLGregorianCalendar value) {
        this.dataPagamento = value;
    }

    /**
     * Gets the value of the dataBaseCorrecao property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataBaseCorrecao() {
        return dataBaseCorrecao;
    }

    /**
     * Sets the value of the dataBaseCorrecao property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataBaseCorrecao(XMLGregorianCalendar value) {
        this.dataBaseCorrecao = value;
    }

    /**
     * Gets the value of the dataSinalizacao property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataSinalizacao() {
        return dataSinalizacao;
    }

    /**
     * Sets the value of the dataSinalizacao property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataSinalizacao(XMLGregorianCalendar value) {
        this.dataSinalizacao = value;
    }

    /**
     * Gets the value of the dataRestituicao property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataRestituicao() {
        return dataRestituicao;
    }

    /**
     * Sets the value of the dataRestituicao property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataRestituicao(XMLGregorianCalendar value) {
        this.dataRestituicao = value;
    }

    /**
     * Gets the value of the codRestituido property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodRestituido() {
        return codRestituido;
    }

    /**
     * Sets the value of the codRestituido property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodRestituido(String value) {
        this.codRestituido = value;
    }

    /**
     * Gets the value of the nomeRestituido property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeRestituido() {
        return nomeRestituido;
    }

    /**
     * Sets the value of the nomeRestituido property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeRestituido(String value) {
        this.nomeRestituido = value;
    }

    /**
     * Gets the value of the codBanco property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodBanco() {
        return codBanco;
    }

    /**
     * Sets the value of the codBanco property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodBanco(String value) {
        this.codBanco = value;
    }

    /**
     * Gets the value of the codAgencia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodAgencia() {
        return codAgencia;
    }

    /**
     * Sets the value of the codAgencia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodAgencia(String value) {
        this.codAgencia = value;
    }

    /**
     * Gets the value of the codConta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodConta() {
        return codConta;
    }

    /**
     * Sets the value of the codConta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodConta(String value) {
        this.codConta = value;
    }

    /**
     * Gets the value of the codFormaRestituicao property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodFormaRestituicao() {
        return codFormaRestituicao;
    }

    /**
     * Sets the value of the codFormaRestituicao property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodFormaRestituicao(Integer value) {
        this.codFormaRestituicao = value;
    }

    /**
     * Gets the value of the codFato property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodFato() {
        return codFato;
    }

    /**
     * Sets the value of the codFato property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodFato(Integer value) {
        this.codFato = value;
    }

}
