/**
 * WebServiceCategorie.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package WebService;

public interface WebServiceCategorie extends java.rmi.Remote {
    public java.lang.String getCategories() throws java.rmi.RemoteException;
    public java.lang.String getCategorie(int categorie_id) throws java.rmi.RemoteException;
    public boolean delCategorie(int categorie_id) throws java.rmi.RemoteException;
    public java.lang.String newCategorie(java.lang.String nom) throws java.rmi.RemoteException;
    public boolean modifyCategorie(int id, java.lang.String nom) throws java.rmi.RemoteException;
}
