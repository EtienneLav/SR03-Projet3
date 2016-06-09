package DAO;

import java.sql.Connection;
import connexion.SqlConnexion;

/**
 * <br>
 * Classe DAO permettant de normaliser nos DAO sur le même modèle.</b>
 * <p>
 * Une DAO est composée d'un attribut :
 * <ul>
 * <li>L'objet connect représentant la connexion actuelle</li>
 * </ul>
 * </p>
 *
 * @author Gabriel Etienne
 * @version 2.1
 */
public abstract class DAO<T> {

	/**
	 * L'état actuel de la connexion.
	 * 
	 */
	public Connection connect = SqlConnexion.getInstance();

	/**
	 * Permet de récupérer un objet via son ID
	 * 
	 * @param id
	 * @return
	 */
	public abstract T find(long id);

	/**
	 * Permet de mettre à jour les données d'une entrée dans la base
	 * 
	 * @param obj
	 */
	public abstract T update(T obj);

	/**
	 * Permet la suppression d'une entrée de la base
	 * 
	 * @param obj
	 */
	public abstract void delete(T obj);

}
