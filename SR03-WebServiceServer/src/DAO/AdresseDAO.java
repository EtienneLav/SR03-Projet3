package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Adresse;

/**
 * <br>
 * Laclasse AdresseDAO représente la DAO affectée à notre table Adresse</b>
 * <p>
 * Cette DAO ne contient aucun attribut
 * </p>
 * 
 * <p>
 * Ici sont concentrées les requêtes à la table Adresse
 * </p>
 * <p>
 * Elle permet de facilement requêter notre BDD Mysql
 * 
 * </p>
 * 
 * @author Gabriel Etienne
 * @version 2.1
 */
public class AdresseDAO extends DAO<Adresse> {

	/**
	 * Méthode creation d'une Adresse dans la BDD
	 * 
	 * @param adresse
	 *            L'objet Adresse à insérer en BDD
	 * 
	 * @return l'objet Adresse créé
	 * 
	 * 
	 */
	public Adresse create(Adresse adresse) {
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT MAX(id) AS id FROM Adresse");
			if (result.first()) {
				long id = result.getLong("id") + 1;

				PreparedStatement prepare = this.connect.prepareStatement(
						"INSERT INTO Adresse (id, numero, rue, ville, codePostal) VALUES(?, ?, ?, ?, ?)");
				prepare.setLong(1, id);
				prepare.setLong(2, adresse.getNumero());
				prepare.setString(3, adresse.getRue());
				prepare.setString(4, adresse.getVille());
				prepare.setLong(5, adresse.getCodePostal());
				prepare.executeUpdate();

				adresse = this.find(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return adresse;
	}

	/**
	 * Méthode de récupération d'une Adresse dans la BDD par son id
	 * 
	 * @param id
	 *            L'id de l'Adresse que l'on souhaite récupérer
	 * 
	 * @return l'objet Adresse correspondant
	 * 
	 * 
	 */
	public Adresse find(long id) {
		Adresse adresse = new Adresse();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT * FROM Adresse WHERE id = " + id);
			if (result.first())
				adresse = new Adresse();
			adresse.setId(id);
			adresse.setNumero(result.getInt("numero"));
			adresse.setRue(result.getString("rue"));
			adresse.setVille(result.getString("ville"));
			adresse.setCodePostal(result.getInt("codePostal"));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return adresse;
	}

	/**
	 * Méthode de récupération d'une Adresse dans la BDD à partir de ses
	 * caractéristiques
	 * 
	 * @param numero
	 *            Le numéro de l'Adresse que l'on souhaite récupérer
	 * @param rue
	 *            La rue de l'Adresse que l'on souhaite récupérer
	 * @param ville
	 *            La ville de l'Adresse que l'on souhaite récupérer
	 * @param codePostal
	 *            Le code Postal de l'Adresse que l'on souhaite récupérer
	 * 
	 * @return l'objet Adresse correspondant ou null si aucun résultat
	 * 
	 * 
	 */
	public Adresse find(long numero, String rue, String ville, long codePostal) {
		Adresse adresse = new Adresse();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT * FROM Adresse WHERE numero = " + numero + " AND rue= '" + rue
							+ "' AND ville='" + ville + "' AND codePostal = " + codePostal);
			if (result.next()) {

				adresse = new Adresse();
				adresse.setId(result.getInt("id"));
				adresse.setNumero(result.getInt("numero"));
				adresse.setRue(result.getString("rue"));
				adresse.setVille(result.getString("ville"));
				adresse.setCodePostal(result.getInt("codePostal"));
				return adresse;
			} else
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * Méthode de MAJ d'une Adresse dans la BDD
	 * 
	 * @param adresse
	 *            L'objet Adresse à mettre à jour
	 * 
	 * @return l'objet Adresse mis à jour
	 * 
	 * 
	 */
	public Adresse update(Adresse adresse) {
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeUpdate("UPDATE Adresse SET numero = '" + adresse.getNumero() + "'," + " rue = '"
							+ adresse.getRue() + "'," + " ville = '" + adresse.getVille() + "'," + " codePostal = '"
							+ adresse.getCodePostal() + "'" + " WHERE id = " + adresse.getId());
			adresse = this.find(adresse.getId());
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return adresse;
	}

	/**
	 * Méthode de suppresion d'une Adresse dans la BDD
	 * 
	 * @param adresse
	 *            L'objet Adresse à supprimer
	 * 
	 * 
	 * 
	 */
	public void delete(Adresse adresse) {
		try {
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeUpdate("DELETE FROM Adresse" + " WHERE id = " + adresse.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}