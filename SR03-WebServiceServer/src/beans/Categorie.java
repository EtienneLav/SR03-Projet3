package beans;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <br>
 * Beans Categorie representant une Categorie dans notre schéma</b>
 * <p>
 * Une Categorie est composée des attributs suivants :
 * <ul>
 * <li>Un identificateur</li>
 * <li>Le nom de la catégorie</li>
 * </ul>
 * </p>
 * 
 * <p>
 * Des annotations pour indiquer le parsing XML automatique de cette classe ont
 * été ajoutés
 * </p>
 * 
 * @author Gabriel Etienne
 * @version 2.1
 */

@XmlRootElement

public class Categorie {

	/**
	 * L'ID de la Categorie. Cet ID n'est pas modifiable.
	 * 
	 * @see Categorie#Categorie(long, String)
	 * @see Categorie#getId()
	 * @see Adresse#setId(long)
	 */
	private long id;

	/**
	 * Le nom de la Categorie.
	 * 
	 * @see Categorie#Categorie(long, String)
	 * @see Categorie#getNom()
	 * @see Categorie#setNom(String)
	 */
	private String nom;

	/**
	 * Constructeur de Categorie.
	 * <p>
	 * Constructeur vide du beans Categorie.
	 * </p>
	 *
	 */
	public Categorie() {
	}

	/**
	 * Constructeur Categorie.
	 * <p>
	 * A la construction d'un objet Categorie, on fixe l'identificateur de la
	 * Categorie, et le nom de celle-ci.
	 * </p>
	 * 
	 * @param _id
	 *            L'identifiant unique de la Categorie.
	 * @param _nom
	 *            Le nom de la Categorie
	 * 
	 * 
	 * @see Categorie#id
	 * @see Categorie#nom
	 */
	public Categorie(long _id, String _nom) {
		this.id = _id;
		this.nom = _nom;
	}

	/**
	 * Retourne l'id de la Categorie.
	 * 
	 * @return Un integer représentant l'identificateur de la Categorie
	 * 
	 * @see Categorie#id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Met à jour l'identificateur de la Categorie.
	 * 
	 * @param _id
	 *            L'id de l'Annonce
	 * 
	 */
	@XmlAttribute
	public Categorie setId(long _id) {
		this.id = _id;
		return this;
	}

	/**
	 * Retourne le nom de la Categorie.
	 * 
	 * @return Une string représentant le nom de la Categorie
	 * 
	 * @see Categorie#nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Met à jour le nom de la Categorie.
	 * 
	 * @param _nom
	 *            Le nom de l'Annonce
	 * 
	 */
	@XmlAttribute
	public Categorie setNom(String _nom) {
		this.nom = _nom;
		return this;
	}
}
