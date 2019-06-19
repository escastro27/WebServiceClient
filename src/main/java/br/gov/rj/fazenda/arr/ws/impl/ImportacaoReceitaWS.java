
package br.gov.rj.fazenda.arr.ws.impl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import br.gov.rj.fazenda.arr.ws.interfaces.CancelaRestituicaoIn;
import br.gov.rj.fazenda.arr.ws.interfaces.CancelaRestituicaoOut;
import br.gov.rj.fazenda.arr.ws.interfaces.ImportaReceitaIn;
import br.gov.rj.fazenda.arr.ws.interfaces.ImportaReceitaOut;
import br.gov.rj.fazenda.arr.ws.interfaces.ImportaRestituicaoIn;
import br.gov.rj.fazenda.arr.ws.interfaces.ImportaRestituicaoOut;

@WebService(name = "ImportacaoReceitaWS", targetNamespace = "http://interfaces.ws.viewcontroller.siplag.logus/")

public interface ImportacaoReceitaWS {


    /**
     * 
     * @param in
     * @return
     *     returns br.gov.rj.fazenda.arr.ws.interfaces.ImportaReceitaOut
     */
    @WebMethod
    @WebResult(name = "out", targetNamespace = "")
    @RequestWrapper(localName = "importaReceita", targetNamespace = "http://interfaces.ws.viewcontroller.siplag.logus/", className = "br.gov.rj.fazenda.arr.ws.interfaces.ImportaReceita")
    @ResponseWrapper(localName = "importaReceitaResponse", targetNamespace = "http://interfaces.ws.viewcontroller.siplag.logus/", className = "br.gov.rj.fazenda.arr.ws.interfaces.ImportaReceitaResponse")
    public ImportaReceitaOut importaReceita(
        @WebParam(name = "in", targetNamespace = "")
        ImportaReceitaIn in);

    /**
     * 
     * @param in
     * @return
     *     returns br.gov.rj.fazenda.arr.ws.interfaces.CancelaRestituicaoOut
     */
    @WebMethod
    @WebResult(name = "out", targetNamespace = "")
    @RequestWrapper(localName = "cancelaRestituicao", targetNamespace = "http://interfaces.ws.viewcontroller.siplag.logus/", className = "br.gov.rj.fazenda.arr.ws.interfaces.CancelaRestituicao")
    @ResponseWrapper(localName = "cancelaRestituicaoResponse", targetNamespace = "http://interfaces.ws.viewcontroller.siplag.logus/", className = "br.gov.rj.fazenda.arr.ws.interfaces.CancelaRestituicaoResponse")
    public CancelaRestituicaoOut cancelaRestituicao(
        @WebParam(name = "in", targetNamespace = "")
        CancelaRestituicaoIn in);

    /**
     * 
     * @param in
     * @return
     *     returns br.gov.rj.fazenda.arr.ws.interfaces.ImportaRestituicaoOut
     */
    @WebMethod
    @WebResult(name = "out", targetNamespace = "")
    @RequestWrapper(localName = "importaRestituicao", targetNamespace = "http://interfaces.ws.viewcontroller.siplag.logus/", className = "br.gov.rj.fazenda.arr.ws.interfaces.ImportaRestituicao")
    @ResponseWrapper(localName = "importaRestituicaoResponse", targetNamespace = "http://interfaces.ws.viewcontroller.siplag.logus/", className = "br.gov.rj.fazenda.arr.ws.interfaces.ImportaRestituicaoResponse")
    public ImportaRestituicaoOut importaRestituicao(
        @WebParam(name = "in", targetNamespace = "")
        ImportaRestituicaoIn in);

}
