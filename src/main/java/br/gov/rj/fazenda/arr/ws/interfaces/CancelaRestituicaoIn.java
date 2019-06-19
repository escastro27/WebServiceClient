
package br.gov.rj.fazenda.arr.ws.interfaces;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cancelaRestituicaoIn complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cancelaRestituicaoIn">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sequencial" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="codSistema" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idRestituicao" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="codCampoFinanceiro" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cancelaRestituicaoIn", propOrder = {
    "sequencial",
    "codSistema",
    "idRestituicao",
    "codCampoFinanceiro"
})
public class CancelaRestituicaoIn {

    @XmlElement(required = true, type = Integer.class, defaultValue = "-2147483648", nillable = true)
    protected Integer sequencial;
    @XmlElement(required = true, type = Integer.class, defaultValue = "-2147483648", nillable = true)
    protected Integer codSistema;
    @XmlElement(required = true, type = Long.class, defaultValue = "-9223372036854775808", nillable = true)
    protected Long idRestituicao;
    @XmlElement(required = true, type = Integer.class, defaultValue = "-2147483648", nillable = true)
    protected Integer codCampoFinanceiro;

    /**
     * Gets the value of the sequencial property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSequencial() {
        return sequencial;
    }

    /**
     * Sets the value of the sequencial property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSequencial(Integer value) {
        this.sequencial = value;
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

}
