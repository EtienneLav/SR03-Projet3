/**
 * WebServiceCategorieServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package WebService;

public class WebServiceCategorieServiceLocator extends org.apache.axis.client.Service implements WebService.WebServiceCategorieService {

    public WebServiceCategorieServiceLocator() {
    }


    public WebServiceCategorieServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WebServiceCategorieServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WebServiceCategorie
    private java.lang.String WebServiceCategorie_address = "http://localhost:8080/SR03-WebServiceServer/services/WebServiceCategorie";

    public java.lang.String getWebServiceCategorieAddress() {
        return WebServiceCategorie_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WebServiceCategorieWSDDServiceName = "WebServiceCategorie";

    public java.lang.String getWebServiceCategorieWSDDServiceName() {
        return WebServiceCategorieWSDDServiceName;
    }

    public void setWebServiceCategorieWSDDServiceName(java.lang.String name) {
        WebServiceCategorieWSDDServiceName = name;
    }

    public WebService.WebServiceCategorie getWebServiceCategorie() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WebServiceCategorie_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWebServiceCategorie(endpoint);
    }

    public WebService.WebServiceCategorie getWebServiceCategorie(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            WebService.WebServiceCategorieSoapBindingStub _stub = new WebService.WebServiceCategorieSoapBindingStub(portAddress, this);
            _stub.setPortName(getWebServiceCategorieWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWebServiceCategorieEndpointAddress(java.lang.String address) {
        WebServiceCategorie_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (WebService.WebServiceCategorie.class.isAssignableFrom(serviceEndpointInterface)) {
                WebService.WebServiceCategorieSoapBindingStub _stub = new WebService.WebServiceCategorieSoapBindingStub(new java.net.URL(WebServiceCategorie_address), this);
                _stub.setPortName(getWebServiceCategorieWSDDServiceName());
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
        if ("WebServiceCategorie".equals(inputPortName)) {
            return getWebServiceCategorie();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://WebService", "WebServiceCategorieService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://WebService", "WebServiceCategorie"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WebServiceCategorie".equals(portName)) {
            setWebServiceCategorieEndpointAddress(address);
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
