package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Categorie;

/**
 * <br>
 * Laclasse CategorieDAO représente la DAO affectée à notre table Categorie</b>
 * <p>
 * Cette DAO ne contient aucun attribut
 * </p>
 * 
 * <p>
 * Ici sont concentrées les requêtes à la table Categorie
 * </p>
 * <p>
 * Elle permet de facilement requêter notre BDD Mysql
 * 
 * </p>
 * 
 * @author Gabriel Etienne
 * @version 2.1
 */
public class CategorieDAO extends DAO<Categorie> {

	/**
	 * Méthode creation d'une categorie dans la BDD
	 * 
	 * @param categorie
	 *            L'objet Categorie à insérer en BDD
	 * 
	 * 
	 * @return l'objet Categorie créé
	 * 
	 * 
	 */
	public Categorie create(Categorie categorie) {
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT MAX(id) AS id FROM Categorie");
			if (result.first()) {
				long id = result.getLong("id") + 1;
				categorie.setId(id);

				PreparedStatement prepare = this.connect
						.prepareStatement("INSERT INTO Categorie (id, nom) VALUES(?, ?)");
				prepare.setLong(1, id);
				prepare.setString(2, categorie.getNom());
				prepare.executeUpdate();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return categorie;
	}

	/**
	 * Méthode de récupération d'une Categorie dans la BDD par son id
	 * 
	 * @param id
	 *            L'id de la Categorie que l'on souhaite récupérer
	 * 
	 * @return l'objet Categorie correspondant
	 * 
	 * 
	 */
	public Categorie find(long id) {
		Categorie categorie = new Categorie();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT * FROM Categorie WHERE id = " + id);
			if (result.first()) {

				categorie = new Categorie(id, result.getString("nom"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return categorie;
	}

	/**
	 * Méthode de récupération de toutes les Categorie dans la BDD
	 * 
	 * 
	 * @return liste d'objet Categorie
	 * 
	 * 
	 */
	public ArrayList<Categorie> findAll() {
		ArrayList<Categorie> categories = new ArrayList<Categorie>();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT * FROM Categorie ORDER BY id asc");
			while (result.next()) {
				Categorie categorie = this.find(result.getLong("id"));
				categories.add(categorie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return categories;
	}

	/**
	 * Méthode de MAJ d'une Categorie dans la BDD
	 * 
	 * @param categorie
	 *            L'objet Categorie à mettre à jour
	 * 
	 * @return l'objet Categorie mis à jour
	 * 
	 * 
	 */
	public Categorie update(Categorie categorie) {
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE).executeUpdate(
					"UPDATE Categorie SET nom = '" + categorie.getNom() + "'" + " WHERE id = " + categorie.getId());

			categorie = this.find(categorie.getId());
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return categorie;
	}

	/**
	 * Méthode de MAJ d'une Categorie dans la BDD
	 * 
	 * @param categorie
	 *            L'objet Categorie à mettre à jour
	 * 
	 * @return boolean traduisant de l'état de la modification
	 * 
	 * 
	 */
	public boolean modify(Categorie categorie) {
		try {
			if (this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeUpdate("UPDATE Categorie SET nom = '" + categorie.getNom() + "'" + " WHERE id = "
							+ categorie.getId()) >= 1)
				return true;
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * Méthode de suppresion d'une Categorie dans la BDD
	 * 
	 * @param categorie
	 *            L'objet Categorie à supprimer
	 * 
	 * 
	 * 
	 */
	public void delete(Categorie categorie) {
		try {

			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeUpdate("DELETE FROM Categorie" + " WHERE id = " + categorie.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Méthode de suppresion d'une Categorie dans la BDD
	 * 
	 * @param categorie
	 *            L'objet Categorie à supprimer
	 * 
	 * @return boolean traduisant de l'état de la suppresion
	 * 
	 * 
	 */
	public boolean remove(int categorie_id) {
		try {

			if (this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeUpdate("DELETE FROM Categorie" + " WHERE id = " + categorie_id) >= 1)
				return true;
			else
				return false;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}