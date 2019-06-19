
package br.gov.rj.fazenda.arr.ws.impl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.handler.MessageContext;

import br.gov.rj.fazenda.arr.util.PropertiesHelper;

@WebServiceClient(name = "ImportacaoReceitaWSImplService", targetNamespace = "http://impl.ws.viewcontroller.siplag.logus/", wsdlLocation = "classpath:wsdl/importacaoreceita.wsdl")
public class ImportacaoReceitaWSImplService
    extends Service
{

    private static URL getWSDLLocation() throws MalformedURLException{
    	URL url = new URL(PropertiesHelper.getUrl());
        return url;
    }
    
    public ImportacaoReceitaWSImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ImportacaoReceitaWSImplService() throws MalformedURLException {
            super(getWSDLLocation(), new QName("http://impl.ws.viewcontroller.siplag.logus/", "ImportacaoReceitaWSImplService"));
    		
    }

    /**
     * 
     * @return
     *     returns ImportacaoReceitaWS
     */
    @WebEndpoint(name = "ImportacaoReceitaWSImplPort")
    public ImportacaoReceitaWS getImportacaoReceitaWSImplPort() {

        Map<String, List<String>> credentials = new HashMap<String,List<String>>();

        credentials.put("username", Collections.singletonList(PropertiesHelper.getUserSiafe()));
        credentials.put("password", Collections.singletonList(PropertiesHelper.getPassSiafe()));

        ImportacaoReceitaWS port = super.getPort(new QName("http://impl.ws.viewcontroller.siplag.logus/", "ImportacaoReceitaWSImplPort"), ImportacaoReceitaWS.class);
        
        ((BindingProvider)port).getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, credentials);	 
            	
    	
        return port;
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ImportacaoReceitaWS
     */
    @WebEndpoint(name = "ImportacaoReceitaWSImplPort")
    public ImportacaoReceitaWS getImportacaoReceitaWSImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://impl.ws.viewcontroller.siplag.logus/", "ImportacaoReceitaWSImplPort"), ImportacaoReceitaWS.class, features);
    }

}
