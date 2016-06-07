package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Adresse;
import beans.Annonce;
import beans.Categorie;

public class AnnonceDAO extends DAO<Annonce> {
	
	public  Annonce create(Annonce annonce, Long categorieId){
		try {
		      ResultSet result = this.connect
                .createStatement(
                		ResultSet.TYPE_SCROLL_INSENSITIVE, 
                		ResultSet.CONCUR_UPDATABLE
                ).executeQuery(
                		"SELECT MAX(id) AS id FROM Adresse"
                );
		      if(result.first()){
		        long id = result.getLong("id") + 1;
		        
				PreparedStatement prepare = this.connect.prepareStatement("INSERT INTO Annonce (id, categorie_id, nom, adresse, telephone) VALUES(?, ?, ?, ?, ?)");
				prepare.setLong(1, id);
				prepare.setLong(2, categorieId);
				prepare.setString(3, annonce.getNom());
				prepare.setLong(4, annonce.getAdresse().getId());
				prepare.setLong(5, annonce.getTelephone());
				prepare.executeUpdate();
				
				// Création du niveau inférieur.
		    	AdresseDAO adresseDAO = (AdresseDAO) DAOFactory.getAdresseDAO();
		    	adresseDAO.create(annonce.getAdresse());
		    	
				annonce = this.find(id);	
			}	
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
		
		return annonce;	}
	
	public Annonce find(long id){
		Annonce annonce = new Annonce();
		try {
		    ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
		    		.executeQuery("SELECT * FROM Annonce WHERE id = " + id);
		    if(result.first()) {
		    	// Récupération du niveau inférieur.
		    	AdresseDAO adresseDAO = (AdresseDAO) DAOFactory.getAdresseDAO();
		    	Adresse adresse = adresseDAO.find(result.getLong("adresse"));
		    	
		    	CategorieDAO categorieDAO = (CategorieDAO) DAOFactory.getCategorieDAO();
		    	Categorie categorie = categorieDAO.find(result.getLong("categorie_id"));
		    	
		    	annonce = new Annonce();
		    	annonce.setId(id);
		    	annonce.setCategorie(categorie);
		    	annonce.setNom(result.getString("nom"));
		    	annonce.setAdresse(adresse);
		    	annonce.setTelephone(result.getLong("telephone"));
	
		    }
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
		
		return annonce;
	}
	
	public Annonce findByAdress(long numero, String rue, String ville, long codePostal){
		Annonce annonce = new Annonce();
		try {
	    	AdresseDAO adresseDAO = (AdresseDAO) DAOFactory.getAdresseDAO();
	    	Adresse adresse = adresseDAO.find(numero, rue, ville, codePostal);
		    ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
		    		.executeQuery("SELECT * FROM Annonce WHERE adresse = " + adresse.getId());
		    if(result.first()) {
		    	
		    	// Récupération du niveau inférieur.
		    	
		    	CategorieDAO categorieDAO = (CategorieDAO) DAOFactory.getCategorieDAO();
		    	Categorie categorie = categorieDAO.find(result.getLong("categorie_id"));
		    	
		    	annonce = new Annonce();
		    	annonce.setId(result.getLong("id"));
		    	annonce.setCategorie(categorie);
		    	annonce.setNom(result.getString("nom"));
		    	annonce.setAdresse(adresse);
		    	annonce.setTelephone(result.getLong("telephone"));
		    	
		    }
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
		
		return annonce;
	}
	
	public ArrayList<Annonce> findAnnonceFromCategorieName(String name){
		ArrayList<Annonce> annonces = new ArrayList<Annonce>();
		try {
            ResultSet result = this.connect
                                   .createStatement(
                                            	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                ResultSet.CONCUR_UPDATABLE
                                             ).executeQuery(
                                                "SELECT * FROM Categorie WHERE nom = " + name
                                             );
            while(result.next()){
            	return this.findAnnonceFromCategorie(result.getLong("id"));
            }
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
		
		return annonces;
	}
	
	public ArrayList<Annonce> findAnnonceFromCategorie(long idCategorie){
		ArrayList<Annonce> annonces = new ArrayList<Annonce>();
		try {
            ResultSet result = this.connect
                                   .createStatement(
                                            	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                ResultSet.CONCUR_UPDATABLE
                                             ).executeQuery(
                                                "SELECT * FROM Annonce WHERE categorie_id = " + idCategorie
                                             );
            while(result.next()){
            	Annonce annonce = this.find(result.getLong("id"));
            	annonces.add(annonce);	
            }
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
		
		return annonces;
	}

	public  Annonce update(Annonce annonce){
		try {		
            this .connect	
                 .createStatement(
                	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE
                 ).executeUpdate(
                     	"UPDATE Annonce SET nom = '" + annonce.getNom() + "',"+
                     			" categorie_id = '" + annonce.getCategorie().getId() + "',"+
                            	" adresse = '" + annonce.getAdresse().getId() + "',"+
                            	" telephone = '" + annonce.getTelephone() + "'"+
                            	" WHERE id = " + annonce.getId()
                            	);
	    } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	    }
	    
	    return annonce;		
    }
	
	
	
	public  boolean modifyAnnonce(Annonce annonce){
		try {		
           if( this .connect	
                 .createStatement(
                	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE
                 ).executeUpdate(
                     	"UPDATE Annonce SET nom = '" + annonce.getNom() + "',"+
                     			" categorie_id = '" + annonce.getCategorie().getId() + "',"+
                            	" adresse = '" + annonce.getAdresse().getId() + "',"+
                            	" telephone = '" + annonce.getTelephone() + "'"+
                            	" WHERE id = " + annonce.getId()
                            	) >=1)
        	   return true;
           else 
        	   return false;
	    } catch (SQLException e) {
	            e.printStackTrace();
	            return true;
	    }		
    }
	
	
	public void delete(Annonce annonce){
		try {
			// Suppression niveau inférieur.
	    	AdresseDAO adresseDAO = (AdresseDAO) DAOFactory.getAdresseDAO();
	    	adresseDAO.delete(annonce.getAdresse());
            this    .connect
                	.createStatement(
                         ResultSet.TYPE_SCROLL_INSENSITIVE, 
                         ResultSet.CONCUR_UPDATABLE
                    ).executeUpdate(
                    	"DELETE FROM Annonce"+
                                	" WHERE id = " + annonce.getId()                        		
                    );
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
	}
	
	public boolean deleteAnnonce(Annonce annonce){
		try {
			// Suppression niveau inférieur.
	    	AdresseDAO adresseDAO = (AdresseDAO) DAOFactory.getAdresseDAO();
	    	adresseDAO.delete(annonce.getAdresse());
            if (this    .connect
                	.createStatement(
                         ResultSet.TYPE_SCROLL_INSENSITIVE, 
                         ResultSet.CONCUR_UPDATABLE
                    ).executeUpdate(
                    	"DELETE FROM Annonce"+
                                	" WHERE id = " + annonce.getId()                        		
                    ) >=1)
            	return true;
            else 
            	return false;
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
		return true;
	}
}