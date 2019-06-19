package br.gov.rj.fazenda.arr.util;



import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.util.Collections;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.apache.log4j.Logger;
import org.w3c.dom.Node;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.InputSource;

import br.gov.rj.fazenda.arr.main.JobEnvioSiafe;

public class LogMessageHandler
  implements SOAPHandler<SOAPMessageContext>
{
  private Logger logger;
  
  public LogMessageHandler()
  {
    this.logger = Logger.getLogger(JobEnvioSiafe.class);
  }
  
  @SuppressWarnings("rawtypes")
  public LogMessageHandler(Class clazz)
  {
    this.logger = Logger.getLogger(clazz);
  }
  
  @SuppressWarnings("unchecked")
  public Set<QName> getHeaders()
  {
    return Collections.EMPTY_SET;
  }
  
  public boolean handleMessage(SOAPMessageContext context)
  {
    SOAPMessage msg = context.getMessage();
    try
    {
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      msg.writeTo(baos);
      
      this.logger.info(format(baos.toString()));
    }
    catch (Exception ex)
    {
      System.out.println(LogMessageHandler.class.getName());
    }
    return true;
  }
  
  public String format(String xml)
  {
    try
    {
      InputSource src = new InputSource(new StringReader(xml));
      Node document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(src).getDocumentElement();
      Boolean keepDeclaration = Boolean.valueOf(xml.startsWith("<?xml"));
      
      DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
      DOMImplementationLS impl = (DOMImplementationLS)registry.getDOMImplementation("LS");
      LSSerializer writer = impl.createLSSerializer();
      
      writer.getDomConfig().setParameter("format-pretty-print", Boolean.TRUE);
      writer.getDomConfig().setParameter("xml-declaration", keepDeclaration);
      
      return writer.writeToString(document);
    }
    catch (Exception e)
    {
      throw new RuntimeException(e);
    }
  }
  
  public boolean handleFault(SOAPMessageContext context)
  {
    return true;
  }
  
  public void close(MessageContext context) {}
}
