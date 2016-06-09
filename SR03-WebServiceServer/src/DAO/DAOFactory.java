package DAO;

import beans.Adresse;
import beans.Annonce;
import beans.Categorie;

/**
 * <br>
 * Classe DAOFactory permettant l'accès facile à nos DAO</b>
 * <p>
 * Une DAO est composée n'a pas d'attribut :
 * <ul>
 * </ul>
 * </p>
 * 
 *
 * @author Gabriel Etienne
 * @version 2.1
 */
public class DAOFactory {

	/**
	 * Permet récupérer la DAO de l'Adresse
	 * 
	 * @param La
	 *            DAO paramétrée avec le beans Adresse DAO<Adresse>
	 */
	public static DAO<Adresse> getAdresseDAO() {
		return new AdresseDAO();
	}

	/**
	 * Permet récupérer la DAO de l'Annonce
	 * 
	 * @param La
	 *            DAO paramétrée avec le beans Annonce DAO<Annonce>
	 */
	public static DAO<Annonce> getAnnonceDAO() {
		return new AnnonceDAO();
	}

	/**
	 * Permet récupérer la DAO de la Categorie
	 * 
	 * @param La
	 *            DAO paramétrée avec le beans Categorie DAO<Categorie>
	 */
	public static DAO<Categorie> getCategorieDAO() {
		return new CategorieDAO();
	}

}