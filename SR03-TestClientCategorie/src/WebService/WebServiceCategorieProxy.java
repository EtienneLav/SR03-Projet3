package WebService;

public class WebServiceCategorieProxy implements WebService.WebServiceCategorie {
  private String _endpoint = null;
  private WebService.WebServiceCategorie webServiceCategorie = null;
  
  public WebServiceCategorieProxy() {
    _initWebServiceCategorieProxy();
  }
  
  public WebServiceCategorieProxy(String endpoint) {
    _endpoint = endpoint;
    _initWebServiceCategorieProxy();
  }
  
  private void _initWebServiceCategorieProxy() {
    try {
      webServiceCategorie = (new WebService.WebServiceCategorieServiceLocator()).getWebServiceCategorie();
      if (webServiceCategorie != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)webServiceCategorie)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)webServiceCategorie)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (webServiceCategorie != null)
      ((javax.xml.rpc.Stub)webServiceCategorie)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public WebService.WebServiceCategorie getWebServiceCategorie() {
    if (webServiceCategorie == null)
      _initWebServiceCategorieProxy();
    return webServiceCategorie;
  }
  
  public java.lang.String getCategories() throws java.rmi.RemoteException{
    if (webServiceCategorie == null)
      _initWebServiceCategorieProxy();
    return webServiceCategorie.getCategories();
  }
  
  public boolean modifyCategorie(int id, java.lang.String nom) throws java.rmi.RemoteException{
    if (webServiceCategorie == null)
      _initWebServiceCategorieProxy();
    return webServiceCategorie.modifyCategorie(id, nom);
  }
  
  public java.lang.String getCategorie(int categorie_id) throws java.rmi.RemoteException{
    if (webServiceCategorie == null)
      _initWebServiceCategorieProxy();
    return webServiceCategorie.getCategorie(categorie_id);
  }
  
  public boolean delCategorie(int categorie_id) throws java.rmi.RemoteException{
    if (webServiceCategorie == null)
      _initWebServiceCategorieProxy();
    return webServiceCategorie.delCategorie(categorie_id);
  }
  
  public java.lang.String newCategorie(java.lang.String nom) throws java.rmi.RemoteException{
    if (webServiceCategorie == null)
      _initWebServiceCategorieProxy();
    return webServiceCategorie.newCategorie(nom);
  }
  
  
}