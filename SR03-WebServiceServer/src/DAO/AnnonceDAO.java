package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Adresse;
import beans.Annonce;
import beans.Categorie;

public class AnnonceDAO extends DAO<Annonce> {

	public Annonce create(Annonce annonce, Long categorieId) {
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT MAX(id) AS id FROM Adresse");
			if (result.first()) {
				long id = result.getLong("id") + 1;

				// Création du niveau inférieur.
				AdresseDAO adresseDAO = (AdresseDAO) DAOFactory.getAdresseDAO();
				Adresse adresse_created = adresseDAO.create(annonce.getAdresse());

				PreparedStatement prepare = this.connect.prepareStatement(
						"INSERT INTO Annonce (id, nom, adresse, telephone, categorie_id) VALUES(?, ?, ?, ?, ?)");
				prepare.setLong(1, id);
				prepare.setString(2, annonce.getNom());
				prepare.setLong(3, adresse_created.getId());
				prepare.setLong(4, annonce.getTelephone());
				prepare.setLong(5, categorieId);

				if (prepare.executeUpdate() >= 1)
					System.out.println("creation ok");
				else
					System.out.println("creation ratée");

				annonce = this.find(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return annonce;
	}

	public Annonce find(long id) {
		Annonce annonce = new Annonce();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT * FROM Annonce WHERE id = " + id);
			if (result.first()) {
				// Récupération du niveau inférieur.
				AdresseDAO adresseDAO = (AdresseDAO) DAOFactory.getAdresseDAO();
				Adresse adresse = adresseDAO.find(result.getLong("adresse"));

				System.out.print("id du tableau de requete " + result.getLong("categorie_id"));
				CategorieDAO categorieDAO = (CategorieDAO) DAOFactory.getCategorieDAO();
				Categorie categorie = categorieDAO.find(result.getInt("categorie_id"));
				System.out.println("categorie_id " + categorie.getId());
				System.out.println("categorie_nom " + categorie.getNom());

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

	public ArrayList<Annonce> findAll() {
		ArrayList<Annonce> annonces = new ArrayList<Annonce>();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT * FROM Annonce ORDER BY id ASC");
			while (result.next()) {
				Annonce annonce = this.find(result.getLong("id"));
				annonces.add(annonce);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return annonces;
	}

	public Annonce findByAdress(long numero, String rue, String ville, long codePostal) {
		Annonce annonce = new Annonce();
		try {
			AdresseDAO adresseDAO = (AdresseDAO) DAOFactory.getAdresseDAO();
			Adresse adresse = adresseDAO.find(numero, rue, ville, codePostal);
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT * FROM Annonce WHERE adresse = " + adresse.getId());
			if (result.first()) {

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

	public ArrayList<Annonce> findAnnonceFromCategorieName(String name) {
		ArrayList<Annonce> annonces = new ArrayList<Annonce>();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT * FROM Categorie WHERE nom = " + name);
			while (result.next()) {
				return this.findAnnonceFromCategorie(result.getLong("id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return annonces;
	}

	public ArrayList<Annonce> findAnnonceFromCategorie(long idCategorie) {
		ArrayList<Annonce> annonces = new ArrayList<Annonce>();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT * FROM Annonce WHERE categorie_id = " + idCategorie);
			while (result.next()) {
				Annonce annonce = this.find(result.getLong("id"));
				annonces.add(annonce);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return annonces;
	}

	public Annonce update(Annonce annonce) {
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeUpdate("UPDATE Annonce SET nom = '" + annonce.getNom() + "'," + " categorie_id = '"
							+ annonce.getCategorie().getId() + "'," + " adresse = '" + annonce.getAdresse().getId()
							+ "'," + " telephone = '" + annonce.getTelephone() + "'" + " WHERE id = "
							+ annonce.getId());
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return annonce;
	}

	public boolean modifyAnnonce(Annonce annonce) {
		try {
			if (this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeUpdate("UPDATE Annonce SET nom = '" + annonce.getNom() + "'," + " categorie_id = '"
							+ annonce.getCategorie().getId() + "'," + " adresse = '" + annonce.getAdresse().getId()
							+ "'," + " telephone = '" + annonce.getTelephone() + "'" + " WHERE id = "
							+ annonce.getId()) >= 1)
				return true;
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return true;
		}
	}

	public void delete(Annonce annonce) {
		try {
			// Suppression niveau inférieur.
			AdresseDAO adresseDAO = (AdresseDAO) DAOFactory.getAdresseDAO();
			adresseDAO.delete(annonce.getAdresse());
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeUpdate("DELETE FROM Annonce" + " WHERE id = " + annonce.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean deleteAnnonce(Annonce annonce) {
		try {
			// Suppression niveau inférieur.
			AdresseDAO adresseDAO = (AdresseDAO) DAOFactory.getAdresseDAO();
			adresseDAO.delete(annonce.getAdresse());
			if (this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeUpdate("DELETE FROM Annonce" + " WHERE id = " + annonce.getId()) >= 1)
				return true;
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean removeAnnonce(long id) {
		try {

			if (this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeUpdate("DELETE FROM Annonce" + " WHERE id = " + id) >= 1)
				return true;
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public ArrayList<Annonce> findAnnonces(int categorie_id, String ville, String annonce_nom, int departement, boolean sont_recentes){
		
		int born_max = 0;
		int born_min  = 0;
		//Requête de base
		String request = "SELECT DISTINCT * FROM Annonce a, Adresse addr WHERE ";
		
		//Parsing de la chaine de caractère annonce_nom
		if(annonce_nom != null){
			String chaine_parsee = annonce_nom;
			String[] splited = chaine_parsee.split("\\s+");
			String chaine_rassemblee = "";
			
			for(int i = 0; i< (splited.length); i++)
				chaine_rassemblee = chaine_rassemblee+"%"+splited[i];
			
			annonce_nom = "'"+chaine_rassemblee+"%'";
			
		}
		
		//Parsing de la chaine de caractère ville
		if(ville != null){
			String chaine_parsee = ville;
			String[] splited = chaine_parsee.split("\\s+");
			String chaine_rassemblee = "";
					
			for(int i = 0; i< (splited.length); i++)
				chaine_rassemblee = chaine_rassemblee+"%"+splited[i];
					
			ville = "'"+chaine_rassemblee+"%'";
					
		}
		
		//Logique du departement
		if(departement != 0){
			born_max = (departement*1000)+999;
			born_max++;
			born_min = (departement*1000);
			born_min--;
		}
				
		//Gestion de la part variable issue de la categorie
		if(categorie_id != 0){
			request = request+" a.categorie_id = "+categorie_id;
			
			if (ville != null){
				request = request+" AND addr.ville LIKE "+ville;
				
				if(annonce_nom != null){
					request = request+" AND a.nom LIKE "+annonce_nom;
					
					if(departement != 0){
						//LE 1 et 2 et  3 et 4
						request = request+" AND addr.codePostal <  "+born_max+" AND addr.CodePostal > "+born_min+" AND addr.id = a.adresse";
						System.out.println("Requête : "+request);
					}
					else{
						//Le 1 et 2 et 3
						request = request+" AND addr.id = a.adresse";
						System.out.println("Requête : "+request);
					}
				}
				else{
					if(departement != 0){
						//Le 1 et 2 et 4
						request = request+" AND addr.codePostal <  "+born_max+" AND addr.CodePostal > "+born_min+" AND addr.id = a.adresse";
						System.out.println("Requête : "+request);
					}
					
					else{
						//Le 1 et 2
						request = request+" AND addr.id = a.adresse";
						System.out.println("Requête : "+request);
					}
				}
				
			}
			else{
				if(annonce_nom != null){
					request = request+" AND a.nom LIKE "+annonce_nom;
					
					if(departement != 0){
						// LE 1 et 3 et 4
						request = request+" AND addr.codePostal <  "+born_max+" AND addr.CodePostal > "+born_min+" AND addr.id = a.adresse";;
						System.out.println("Requête : "+request);
					}
					else{
						//Le 1 et 3
						request = request+" AND addr.id = a.adresse";
						System.out.println("Requête : "+request);
					}
				}
				else{
					if(departement != 0){
						//LE 1 et 4
						request = request+" AND addr.codePostal <  "+born_max+" AND addr.CodePostal > "+born_min+" AND addr.id = a.adresse";
						System.out.println("Requête : "+request);
					}
					
					else{
						//JUSTE LE 1
						request = request+" AND addr.id = a.adresse";
						System.out.println("Requête : "+request);
					}
				}
			}
					
		}
		
		else{
			if (ville != null){
				request = request+" addr.ville LIKE "+ville;
				
				{
					if(annonce_nom != null){
						request = request+" AND a.nom LIKE "+annonce_nom;
						
						if(departement != 0){
							//LE 2 et 3 et 4
							request = request+" AND addr.codePostal <  "+born_max+" AND addr.CodePostal > "+born_min+" AND addr.id = a.adresse"+" AND addr.id = a.adresse";;
							System.out.println("Requête : "+request);
						}
						
						else{
							//Le 2 et 3
							request = request+" AND addr.id = a.adresse";
							System.out.println("Requête : "+request);
						}
					}
					else{
						if(departement != 0){
							//LE 2 et 4
							request = request+" AND addr.codePostal <  "+born_max+" AND addr.CodePostal > "+born_min+" AND addr.id = a.adresse";
							System.out.println("Requête : "+request);
						}
						
						else{
							//Le 2
							request = request+" AND addr.id = a.adresse";
							System.out.println("Requête : "+request);
							}
					
						}
					}
				}
			else{
				if(annonce_nom != null){
					request = request+"  a.nom LIKE "+annonce_nom;
					
					if(departement != 0){
						//LE 3 et 4
						request = request+" AND addr.codePostal <  "+born_max+" AND addr.CodePostal > "+born_min+" AND addr.id = a.adresse";
						System.out.println("Requête : "+request);
					}
					
					else{
						//Le 3
						request = request+" AND addr.id = a.adresse";
						System.out.println("Requête : "+request);
					}
				}
				
				else{
					if(departement != 0){
						//LE 4
						request = request+" addr.codePostal <  "+born_max+" AND addr.CodePostal > "+born_min+" AND addr.id = a.adresse";
						System.out.println("Requête : "+request);
					}
					
					else{
						//AUCUN
						request = request+" AND addr.id = a.adresse";
						System.out.println("Requête : "+request);
					}
				}
			}
		}
		
		

		if(sont_recentes)
			request = request+" ORDER BY a.id DESC LIMIT 20";
		
		
		ArrayList<Annonce> annonces = new ArrayList<Annonce>();
		try {
            ResultSet result = this.connect
                                   .createStatement(
                                            	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                ResultSet.CONCUR_UPDATABLE
                                             ).executeQuery(
                                            		 request
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
}