package DAO;

import beans.Adresse;
import beans.Annonce;
import beans.Categorie;

public class DAOFactory {
	
	public static DAO<Adresse> getAdresseDAO(){
		return new AdresseDAO();
	}
	
	public static DAO<Annonce> getAnnonceDAO(){
		return new AnnonceDAO();
	}
	
	public static DAO<Categorie> getCategorieDAO(){
		return new CategorieDAO();
	}
	
}