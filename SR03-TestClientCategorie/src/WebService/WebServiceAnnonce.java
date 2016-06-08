/**
 * WebServiceAnnonce.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package WebService;

public interface WebServiceAnnonce extends java.rmi.Remote {
    public java.lang.String createAnnonce(java.lang.String nom, int category_id, int telephone, int numero_adresse, java.lang.String rue_adresse, int codePostal_adresse, java.lang.String ville_adresse) throws java.rmi.RemoteException;
    public boolean deleteAnnonce(int id) throws java.rmi.RemoteException;
    public java.lang.String getAnnoncesCat(int categorie_id) throws java.rmi.RemoteException;
    public java.lang.String getAnnonceByID(int id) throws java.rmi.RemoteException;
    public java.lang.String getAnnonces() throws java.rmi.RemoteException;
    public boolean modifyAnnonce(int annonce_id, java.lang.String nom, int category_id, int telephone, int numero_adresse, java.lang.String rue_adresse, int codePostal_adresse, java.lang.String ville_adresse) throws java.rmi.RemoteException;
}
