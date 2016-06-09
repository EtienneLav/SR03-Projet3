/**
 * WebServiceAnnonceSoapBindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package WebService;

public class WebServiceAnnonceSoapBindingSkeleton implements WebService.WebServiceAnnonce, org.apache.axis.wsdl.Skeleton {
    private WebService.WebServiceAnnonce impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://WebService", "nom"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://WebService", "category_id"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://WebService", "telephone"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://WebService", "numero_adresse"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://WebService", "rue_adresse"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://WebService", "codePostal_adresse"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://WebService", "ville_adresse"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("createAnnonce", _params, new javax.xml.namespace.QName("http://WebService", "createAnnonceReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://WebService", "createAnnonce"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("createAnnonce") == null) {
            _myOperations.put("createAnnonce", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("createAnnonce")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://WebService", "id"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("deleteAnnonce", _params, new javax.xml.namespace.QName("http://WebService", "deleteAnnonceReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://WebService", "deleteAnnonce"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("deleteAnnonce") == null) {
            _myOperations.put("deleteAnnonce", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("deleteAnnonce")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://WebService", "categorie_id"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getAnnoncesCat", _params, new javax.xml.namespace.QName("http://WebService", "getAnnoncesCatReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://WebService", "getAnnoncesCat"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getAnnoncesCat") == null) {
            _myOperations.put("getAnnoncesCat", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getAnnoncesCat")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://WebService", "id"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getAnnonceByID", _params, new javax.xml.namespace.QName("http://WebService", "getAnnonceByIDReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://WebService", "getAnnonceByID"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getAnnonceByID") == null) {
            _myOperations.put("getAnnonceByID", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getAnnonceByID")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
        };
        _oper = new org.apache.axis.description.OperationDesc("getAnnonces", _params, new javax.xml.namespace.QName("http://WebService", "getAnnoncesReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://WebService", "getAnnonces"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getAnnonces") == null) {
            _myOperations.put("getAnnonces", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getAnnonces")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://WebService", "annonce_id"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://WebService", "nom"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://WebService", "category_id"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://WebService", "telephone"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://WebService", "numero_adresse"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://WebService", "rue_adresse"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://WebService", "codePostal_adresse"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://WebService", "ville_adresse"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("modifyAnnonce", _params, new javax.xml.namespace.QName("http://WebService", "modifyAnnonceReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://WebService", "modifyAnnonce"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("modifyAnnonce") == null) {
            _myOperations.put("modifyAnnonce", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("modifyAnnonce")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://WebService", "categorie_id"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://WebService", "ville"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://WebService", "annonce_nom"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://WebService", "departement"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://WebService", "sont_recentes"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"), boolean.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("searchAnnonces", _params, new javax.xml.namespace.QName("http://WebService", "searchAnnoncesReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://WebService", "searchAnnonces"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("searchAnnonces") == null) {
            _myOperations.put("searchAnnonces", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("searchAnnonces")).add(_oper);
    }

    public WebServiceAnnonceSoapBindingSkeleton() {
        this.impl = new WebService.WebServiceAnnonceSoapBindingImpl();
    }

    public WebServiceAnnonceSoapBindingSkeleton(WebService.WebServiceAnnonce impl) {
        this.impl = impl;
    }
    public java.lang.String createAnnonce(java.lang.String nom, int category_id, int telephone, int numero_adresse, java.lang.String rue_adresse, int codePostal_adresse, java.lang.String ville_adresse) throws java.rmi.RemoteException
    {
        java.lang.String ret = impl.createAnnonce(nom, category_id, telephone, numero_adresse, rue_adresse, codePostal_adresse, ville_adresse);
        return ret;
    }

    public boolean deleteAnnonce(int id) throws java.rmi.RemoteException
    {
        boolean ret = impl.deleteAnnonce(id);
        return ret;
    }

    public java.lang.String getAnnoncesCat(int categorie_id) throws java.rmi.RemoteException
    {
        java.lang.String ret = impl.getAnnoncesCat(categorie_id);
        return ret;
    }

    public java.lang.String getAnnonceByID(int id) throws java.rmi.RemoteException
    {
        java.lang.String ret = impl.getAnnonceByID(id);
        return ret;
    }

    public java.lang.String getAnnonces() throws java.rmi.RemoteException
    {
        java.lang.String ret = impl.getAnnonces();
        return ret;
    }

    public boolean modifyAnnonce(int annonce_id, java.lang.String nom, int category_id, int telephone, int numero_adresse, java.lang.String rue_adresse, int codePostal_adresse, java.lang.String ville_adresse) throws java.rmi.RemoteException
    {
        boolean ret = impl.modifyAnnonce(annonce_id, nom, category_id, telephone, numero_adresse, rue_adresse, codePostal_adresse, ville_adresse);
        return ret;
    }

    public java.lang.String searchAnnonces(int categorie_id, java.lang.String ville, java.lang.String annonce_nom, int departement, boolean sont_recentes) throws java.rmi.RemoteException
    {
        java.lang.String ret = impl.searchAnnonces(categorie_id, ville, annonce_nom, departement, sont_recentes);
        return ret;
    }

}
