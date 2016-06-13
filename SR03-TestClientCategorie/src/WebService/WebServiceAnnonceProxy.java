package WebService;

public class WebServiceAnnonceProxy implements WebService.WebServiceAnnonce {
  private String _endpoint = null;
  private WebService.WebServiceAnnonce webServiceAnnonce = null;
  
  public WebServiceAnnonceProxy() {
    _initWebServiceAnnonceProxy();
  }
  
  public WebServiceAnnonceProxy(String endpoint) {
    _endpoint = endpoint;
    _initWebServiceAnnonceProxy();
  }
  
  private void _initWebServiceAnnonceProxy() {
    try {
      webServiceAnnonce = (new WebService.WebServiceAnnonceServiceLocator()).getWebServiceAnnonce();
      if (webServiceAnnonce != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)webServiceAnnonce)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)webServiceAnnonce)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (webServiceAnnonce != null)
      ((javax.xml.rpc.Stub)webServiceAnnonce)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public WebService.WebServiceAnnonce getWebServiceAnnonce() {
    if (webServiceAnnonce == null)
      _initWebServiceAnnonceProxy();
    return webServiceAnnonce;
  }
  
  public java.lang.String getAnnonces() throws java.rmi.RemoteException{
    if (webServiceAnnonce == null)
      _initWebServiceAnnonceProxy();
    return webServiceAnnonce.getAnnonces();
  }
  
  public java.lang.String getAnnonceByID(int id) throws java.rmi.RemoteException{
    if (webServiceAnnonce == null)
      _initWebServiceAnnonceProxy();
    return webServiceAnnonce.getAnnonceByID(id);
  }
  
  public java.lang.String getAnnoncesCat(int categorie_id) throws java.rmi.RemoteException{
    if (webServiceAnnonce == null)
      _initWebServiceAnnonceProxy();
    return webServiceAnnonce.getAnnoncesCat(categorie_id);
  }
  
  public boolean modifyAnnonce(int annonce_id, java.lang.String nom, int category_id, int telephone, int numero_adresse, java.lang.String rue_adresse, int codePostal_adresse, java.lang.String ville_adresse) throws java.rmi.RemoteException{
    if (webServiceAnnonce == null)
      _initWebServiceAnnonceProxy();
    return webServiceAnnonce.modifyAnnonce(annonce_id, nom, category_id, telephone, numero_adresse, rue_adresse, codePostal_adresse, ville_adresse);
  }
  
  public boolean deleteAnnonce(int id) throws java.rmi.RemoteException{
    if (webServiceAnnonce == null)
      _initWebServiceAnnonceProxy();
    return webServiceAnnonce.deleteAnnonce(id);
  }
  
  public java.lang.String searchAnnonces(int categorie_id, java.lang.String ville, java.lang.String annonce_nom, int departement, boolean sont_recentes) throws java.rmi.RemoteException{
    if (webServiceAnnonce == null)
      _initWebServiceAnnonceProxy();
    return webServiceAnnonce.searchAnnonces(categorie_id, ville, annonce_nom, departement, sont_recentes);
  }
  
  public java.lang.String createAnnonce(java.lang.String nom, int category_id, int telephone, int numero_adresse, java.lang.String rue_adresse, int codePostal_adresse, java.lang.String ville_adresse) throws java.rmi.RemoteException{
    if (webServiceAnnonce == null)
      _initWebServiceAnnonceProxy();
    return webServiceAnnonce.createAnnonce(nom, category_id, telephone, numero_adresse, rue_adresse, codePostal_adresse, ville_adresse);
  }
  
  
}