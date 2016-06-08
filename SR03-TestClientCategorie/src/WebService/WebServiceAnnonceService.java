/**
 * WebServiceAnnonceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package WebService;

public interface WebServiceAnnonceService extends javax.xml.rpc.Service {
    public java.lang.String getWebServiceAnnonceAddress();

    public WebService.WebServiceAnnonce getWebServiceAnnonce() throws javax.xml.rpc.ServiceException;

    public WebService.WebServiceAnnonce getWebServiceAnnonce(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
