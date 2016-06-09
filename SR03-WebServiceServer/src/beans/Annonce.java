package beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <br>
 * Beans Annonce representant une annonce dans notre schéma</b>
 * <p>
 * Une annonce est constituée des attributs suivants :
 * <ul>
 * <li>Un identifiant unique</li>
 * <li>Un objet categorie auquel elle appartient</li>
 * <li>Un nom</li>
 * <li>Un objet Adresse qu'elle comporte</li>
 * <li>Un numéro de téléphone</li>
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
public class Annonce {

	/**
	 * L'ID de l'Annonce. Cet ID n'est pas modifiable.
	 * 
	 * @see Annonce#Annonce(long, Categorie, String, Adresse, long)
	 * @see Annonce#getId()
	 * @see Annonce#setId(long)
	 */
	private long id;

	/**
	 * La Catégorie de l'Annonce
	 * 
	 * @see Annonce#Annonce(long, Categorie, String, Adresse, long)
	 * @see Annonce#getCategorie()
	 * @see Annonce#setCategorie(Categorie)
	 */
	private Categorie categorie;

	/**
	 * Le nom de l'Annonce.
	 * 
	 * @see Annonce#Annonce(long, Categorie, String, Adresse, long)
	 * @see Annonce#getNom()
	 * @see Annonce#setNom(String)
	 */
	private String nom;

	/**
	 * l'Adresse de l'Annonce.
	 * 
	 * @see Annonce#Annonce(long, Categorie, String, Adresse, long)
	 * @see Annonce#getAdresse()
	 * @see Annonce#setAdresse(Adresse)
	 */
	private Adresse adresse;

	/**
	 * Le numéro de téléphone de l'Annonce.
	 * 
	 * @see Annonce#Annonce(long, Categorie, String, Adresse, long)
	 * @see Annonce#getTelephone()
	 * @see Annonce#setTelephone(long)
	 */
	private long telephone;

	/**
	 * Constructeur d'Annonce.
	 * <p>
	 * Constructeur vide du beans Annonce
	 * </p>
	 *
	 */
	public Annonce() {
	}

	/**
	 * Constructeur Adresse.
	 * <p>
	 * A la construction d'un objet Annonce, on fixe l'identificateur de
	 * Annonce, l'objet Categorie auquel elle appartient, le nom de l'annonce,
	 * l'objet Adresse qu'elle contient et le numéro de téléphone de l'annonce
	 * </p>
	 * 
	 * @param _id
	 *            L'identifiant unique de l'Annonce.
	 * @param _categorie
	 *            La Categorie de l'Annonce
	 * 
	 * @param _nom
	 *            Le nom de l'Annonce
	 * 
	 * @param _adresse
	 *            L'Adresse de l'Annonce
	 * 
	 * @param _telephone
	 *            Le numéro de téléphone associé à l'Annonce
	 * 
	 * @see Annonce#id
	 * @see Annonce#categorie
	 * @see Annonce#nom
	 * @see Annonce#adresse
	 * @see Annonce#telephone
	 */
	public Annonce(long _id, Categorie _categorie, String _nom, Adresse _adresse, long _telephone) {
		this.id = _id;
		this.categorie = _categorie;
		this.nom = _nom;
		this.adresse = _adresse;
		this.telephone = _telephone;
	}

	/**
	 * <b> Affichage d'une Adresse </b>
	 * <p>
	 * Méthode d'affichage automatique des caractéristiques d'une Annonce
	 * </p>
	 * 
	 * @see Annonce#getId()
	 * @see Annonce#getCategorie()
	 * @see Annonce#getNom()
	 * @see Annonce#getAdresse()
	 * @see Annonce#getTelephone()
	 */
	public void print() {
		System.out.println("id : " + id);
		System.out.println("categorie_id : " + categorie.getId());
		System.out.println("categorie_nom : " + categorie.getNom());
		System.out.println("nom : " + nom);
		System.out.println("adresse_id : " + adresse.getId());
		System.out.println("telephone : " + telephone);
	}

	/**
	 * Retourne l'id de l'Annonce
	 * 
	 * @return Un integer représentant l'identificateur de l'Annonce
	 * 
	 * @see Annonce#id
	 */
	@XmlElement(name = "annonce_id")
	public long getId() {
		return id;
	}

	/**
	 * Met à jour l'identificateur de l'Annonce.
	 * 
	 * @param _id
	 *            L'id de l'Annonce
	 * 
	 */
	public Annonce setId(long _id) {
		this.id = _id;
		return this;
	}

	/**
	 * Retourne le nom de l'Annonce
	 * 
	 * @return Une chaine de caractère représentant nom de l'Annonce
	 * 
	 * @see Annonce#nom
	 * 
	 */
	@XmlElement(name = "nom")
	public String getNom() {
		return nom;
	}

	/**
	 * Met à jour le nom de l'Annonce.
	 * 
	 * @param _nom
	 *            Le nom de l'Annonce
	 * 
	 */
	public Annonce setNom(String _nom) {
		this.nom = _nom;
		return this;
	}

	/**
	 * Retourne l'objet Adresse de l'Annonce
	 * 
	 * @return Un objet Adresse contenu dans l'Annonce
	 * 
	 * @see Annonce#adresse
	 * 
	 */
	@XmlElement(name = "adresse")
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * Met à jour l'Adresse de téléphone de l'Annonce.
	 * 
	 * @param _adresse
	 *            L'Adresse de l'Annonce
	 * 
	 */
	public Annonce setAdresse(Adresse _adresse) {
		this.adresse = _adresse;
		return this;
	}

	/**
	 * Retourne le numéro de téléphone de l'Annonce
	 * 
	 * @return Un integer représentant le numéro de téléphone de l'Annonce
	 * 
	 * @see Annonce#telephone
	 * 
	 */
	@XmlElement(name = "telephone")
	public long getTelephone() {
		return telephone;
	}

	/**
	 * Met à jour le numéro de téléphone de l'Annonce.
	 * 
	 * @param _telephone
	 *            Le numéro de téléphone de l'Annonce
	 * 
	 */
	public Annonce setTelephone(long _telephone) {
		this.telephone = _telephone;
		return this;
	}

	/**
	 * Retourne l'objet Categorie de l'Annonce
	 * 
	 * @return Un objet Categorie contenu dans l'annonce l'Annonce
	 * 
	 * @see Annonce#categorie
	 * 
	 */
	@XmlElement(name = "categorie")
	public Categorie getCategorie() {
		return categorie;
	}

	/**
	 * Met à jour la ville de l'Annonce.
	 * 
	 * @param _categorie
	 *            La Categorie de l'Annonce
	 * 
	 */
	public void setCategorie(Categorie _categorie) {
		this.categorie = _categorie;
	}
}
