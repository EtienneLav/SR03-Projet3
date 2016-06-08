/**
 * WebServiceAnnonceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package WebService;

public class WebServiceAnnonceServiceLocator extends org.apache.axis.client.Service implements WebService.WebServiceAnnonceService {

    public WebServiceAnnonceServiceLocator() {
    }


    public WebServiceAnnonceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WebServiceAnnonceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WebServiceAnnonce
    private java.lang.String WebServiceAnnonce_address = "http://localhost:8080/SR03-WebServiceServer/services/WebServiceAnnonce";

    public java.lang.String getWebServiceAnnonceAddress() {
        return WebServiceAnnonce_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WebServiceAnnonceWSDDServiceName = "WebServiceAnnonce";

    public java.lang.String getWebServiceAnnonceWSDDServiceName() {
        return WebServiceAnnonceWSDDServiceName;
    }

    public void setWebServiceAnnonceWSDDServiceName(java.lang.String name) {
        WebServiceAnnonceWSDDServiceName = name;
    }

    public WebService.WebServiceAnnonce getWebServiceAnnonce() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WebServiceAnnonce_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWebServiceAnnonce(endpoint);
    }

    public WebService.WebServiceAnnonce getWebServiceAnnonce(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            WebService.WebServiceAnnonceSoapBindingStub _stub = new WebService.WebServiceAnnonceSoapBindingStub(portAddress, this);
            _stub.setPortName(getWebServiceAnnonceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWebServiceAnnonceEndpointAddress(java.lang.String address) {
        WebServiceAnnonce_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (WebService.WebServiceAnnonce.class.isAssignableFrom(serviceEndpointInterface)) {
                WebService.WebServiceAnnonceSoapBindingStub _stub = new WebService.WebServiceAnnonceSoapBindingStub(new java.net.URL(WebServiceAnnonce_address), this);
                _stub.setPortName(getWebServiceAnnonceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("WebServiceAnnonce".equals(inputPortName)) {
            return getWebServiceAnnonce();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://WebService", "WebServiceAnnonceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://WebService", "WebServiceAnnonce"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WebServiceAnnonce".equals(portName)) {
            setWebServiceAnnonceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
