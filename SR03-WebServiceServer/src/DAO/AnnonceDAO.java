package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Adresse;
import beans.Annonce;
import beans.Categorie;

/**
 * <br>
 * Laclasse AnnonceDAO représente la DAO affectée à notre table Annonce</b>
 * <p>
 * Cette DAO ne contient aucun attribut
 * </p>
 * 
 * <p>
 * Ici sont concentrées les requêtes à la table Annonce
 * </p>
 * <p>
 * Elle permet de facilement requêter notre BDD Mysql
 * 
 * </p>
 * 
 * @author Gabriel Etienne
 * @version 2.1
 */
public class AnnonceDAO extends DAO<Annonce> {

	/**
	 * Méthode creation d'une Annonce dans la BDD
	 * 
	 * @param annonce
	 *            L'objet Annonce à insérer en BDD
	 * 
	 * @param categorieId
	 *            L'identificateur de la catégorie à affecter à notre annonce
	 * 
	 * @return l'objet Annonce créé
	 * 
	 * 
	 */
	public Annonce create(Annonce annonce, Long categorieId) {
		try {
			
				// Création du niveau inférieur.
				AdresseDAO adresseDAO = (AdresseDAO) DAOFactory.getAdresseDAO();
				Adresse adresse_created = adresseDAO.create(annonce.getAdresse());
		
				ResultSet result_annonce = this.connect
						.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
						.executeQuery("SELECT MAX(id) AS id FROM Annonce");
				
				if (result_annonce.first()) {
					long annonce_id = result_annonce.getLong("id") + 1;
					
					PreparedStatement prepare = this.connect.prepareStatement(
							"INSERT INTO Annonce (id, nom, adresse, telephone, categorie_id) VALUES(?, ?, ?, ?, ?)");
					prepare.setLong(1, annonce_id);
					prepare.setString(2, annonce.getNom());
					prepare.setLong(3, adresse_created.getId());
					prepare.setLong(4, annonce.getTelephone());
					prepare.setLong(5, categorieId);
					prepare.executeUpdate();
					
					annonce = this.find(annonce_id);
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
			}

		return annonce;
	}

	/**
	 * Méthode de récupération d'une Annonce dans la BDD par son id
	 * 
	 * @param id
	 *            L'id de l'Annonce que l'on souhaite récupérer
	 * 
	 * @return l'objet Annonce correspondant
	 * 
	 * 
	 */
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

				CategorieDAO categorieDAO = (CategorieDAO) DAOFactory.getCategorieDAO();
				Categorie categorie = categorieDAO.find(result.getInt("categorie_id"));

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

	/**
	 * Méthode de récupération de toutes les Adresse dans la BDD
	 * 
	 * 
	 * @return liste d'objet Annonce
	 * 
	 * 
	 */
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

	/**
	 * Méthode de récupération de toutes les Adresse dans la BDD par catégorie
	 * 
	 * 
	 * @return liste d'objet Annonce correspondante
	 * 
	 * 
	 */
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

	/**
	 * Méthode de MAJ d'une Annonce dans la BDD
	 * 
	 * @param annonce
	 *            L'objet Annonce à mettre à jour
	 * 
	 * @return l'objet Annonce mis à jour
	 * 
	 * 
	 */
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

	/**
	 * Méthode de MAJ d'une Annonce dans la BDD
	 * 
	 * @param annonce
	 *            L'objet Annonce à mettre à jour
	 * 
	 * @return boolean remontant l'état de la MAJ
	 * 
	 * 
	 */
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

	/**
	 * Méthode de suppresion d'une Annonce dans la BDD
	 * 
	 * @param annonce
	 *            L'objet Annonce à supprimer
	 * 
	 * 
	 * 
	 */
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

	/**
	 * Méthode de suppresion d'une Annonce dans la BDD
	 * 
	 * @param annonce
	 *            L'objet Annonce à supprimer
	 * 
	 * @return boolean traduisant de l'état de notre suppression
	 * 
	 * 
	 * 
	 */
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

	/**
	 * Méthode de suppresion d'une Annonce dans la BDD par id
	 * 
	 * @param id
	 *            L'id de l'annonce à supprimer
	 * 
	 * @return boolean traduisant de l'état de notre suppression
	 * 
	 */
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

	/**
	 * Méthode de récupération d'une liste d'Annonce dans la BDD à partir de
	 * caractéristiques de recherche
	 * 
	 * @param categorie_id
	 *            L'identificateur de la catégorie dans laquelle chercher les
	 *            annonces
	 * @param ville
	 *            La ville pour laquelle on doit chercher les annonces
	 * @param annonce_nom
	 *            La chaine de caractères à chercher dans le nom des annonces
	 * @param departement
	 *            Le département dans lequel chercher des annonces
	 * @param sont_recentes
	 *            Un boolean indiquant si on souhaite restreindre la recherche
	 *            aux 20 dernières annonces ajoutées en BDD
	 * 
	 * @return la liste d'objets Annonce correspondant à la recherche
	 * 
	 * 
	 */
	public ArrayList<Annonce> findAnnonces(int categorie_id, String ville, String annonce_nom, int departement,
			boolean sont_recentes) {

		int born_max = 0;
		int born_min = 0;
		// Requête de base
		String request = "SELECT DISTINCT * FROM Annonce a, Adresse addr WHERE ";

		// Parsing de la chaine de caractère annonce_nom
		if (annonce_nom != null) {

			String chaine_parsee = annonce_nom;
			String[] splited = chaine_parsee.split("\\s+");
			String chaine_rassemblee = "";

			for (int i = 0; i < (splited.length); i++)
				chaine_rassemblee = chaine_rassemblee + "%" + splited[i];

			annonce_nom = "'" + chaine_rassemblee + "%'";

		}

		// Parsing de la chaine de caractère ville
		if (ville != null) {
			String chaine_parsee = ville;
			String[] splited = chaine_parsee.split("\\s+");
			String chaine_rassemblee = "";

			for (int i = 0; i < (splited.length); i++)
				chaine_rassemblee = chaine_rassemblee + "%" + splited[i];

			ville = "'" + chaine_rassemblee + "%'";

		}

		// Logique du departement
		if (departement != 0) {
			born_max = (departement * 1000) + 999;
			born_max++;
			born_min = (departement * 1000);
			born_min--;
		}

		// Gestion de la part variable issue de la categorie
		if (categorie_id != 0) {
			request = request + " a.categorie_id = " + categorie_id;

			if (ville != null) {
				request = request + " AND addr.ville LIKE " + ville;

				if (annonce_nom != null) {
					request = request + " AND a.nom LIKE " + annonce_nom;

					if (departement != 0) {
						// LE 1 et 2 et 3 et 4
						request = request + " AND addr.codePostal <  " + born_max + " AND addr.CodePostal > " + born_min
								+ " AND addr.id = a.adresse";
						System.out.println("Requête : " + request);
					} else {
						// Le 1 et 2 et 3
						request = request + " AND addr.id = a.adresse";
						System.out.println("Requête : " + request);
					}
				} else {
					if (departement != 0) {
						// Le 1 et 2 et 4
						request = request + " AND addr.codePostal <  " + born_max + " AND addr.CodePostal > " + born_min
								+ " AND addr.id = a.adresse";
						System.out.println("Requête : " + request);
					}

					else {
						// Le 1 et 2
						request = request + " AND addr.id = a.adresse";
						System.out.println("Requête : " + request);
					}
				}

			} else {
				if (annonce_nom != null) {
					request = request + " AND a.nom LIKE " + annonce_nom;

					if (departement != 0) {
						// LE 1 et 3 et 4
						request = request + " AND addr.codePostal <  " + born_max + " AND addr.CodePostal > " + born_min
								+ " AND addr.id = a.adresse";
						;
						System.out.println("Requête : " + request);
					} else {
						// Le 1 et 3
						request = request + " AND addr.id = a.adresse";
						System.out.println("Requête : " + request);
					}
				} else {
					if (departement != 0) {
						// LE 1 et 4
						request = request + " AND addr.codePostal <  " + born_max + " AND addr.CodePostal > " + born_min
								+ " AND addr.id = a.adresse";
						System.out.println("Requête : " + request);
					}

					else {
						// JUSTE LE 1
						request = request + " AND addr.id = a.adresse";
						System.out.println("Requête : " + request);
					}
				}
			}

		}

		else {
			if (ville != null) {
				request = request + " addr.ville LIKE " + ville;

				{
					if (annonce_nom != null) {
						request = request + " AND a.nom LIKE " + annonce_nom;

						if (departement != 0) {
							// LE 2 et 3 et 4
							request = request + " AND addr.codePostal <  " + born_max + " AND addr.CodePostal > "
									+ born_min + " AND addr.id = a.adresse" + " AND addr.id = a.adresse";
							;
							System.out.println("Requête : " + request);
						}

						else {
							// Le 2 et 3
							request = request + " AND addr.id = a.adresse";
							System.out.println("Requête : " + request);
						}
					} else {
						if (departement != 0) {
							// LE 2 et 4
							request = request + " AND addr.codePostal <  " + born_max + " AND addr.CodePostal > "
									+ born_min + " AND addr.id = a.adresse";
							System.out.println("Requête : " + request);
						}

						else {
							// Le 2
							request = request + " AND addr.id = a.adresse";
							System.out.println("Requête : " + request);
						}

					}
				}
			} else {
				if (annonce_nom != null) {
					request = request + "  a.nom LIKE " + annonce_nom;

					if (departement != 0) {
						// LE 3 et 4
						request = request + " AND addr.codePostal <  " + born_max + " AND addr.CodePostal > " + born_min
								+ " AND addr.id = a.adresse";
						System.out.println("Requête : " + request);
					}

					else {
						// Le 3
						request = request + " AND addr.id = a.adresse";
						System.out.println("Requête : " + request);
					}
				}

				else {
					if (departement != 0) {
						// LE 4
						request = request + " addr.codePostal <  " + born_max + " AND addr.CodePostal > " + born_min
								+ " AND addr.id = a.adresse";
						System.out.println("Requête : " + request);
					}

					else {
						// AUCUN
						request = request + " AND addr.id = a.adresse";
						System.out.println("Requête : " + request);
					}
				}
			}
		}

		if (sont_recentes)
			request = request + " ORDER BY a.id DESC LIMIT 20";

		ArrayList<Annonce> annonces = new ArrayList<Annonce>();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeQuery(request);
			while (result.next()) {
				Annonce annonce = this.find(result.getLong("id"));
				annonces.add(annonce);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return annonces;
	}
}