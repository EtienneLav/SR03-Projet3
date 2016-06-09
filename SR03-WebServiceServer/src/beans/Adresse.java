package beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <br>
 * Beans Adresse representant une adresse dans notre schéma</b>
 * <p>
 * Une Adresse est constituée des attributs suivants :
 * <ul>
 * <li>Un identifiant unique</li>
 * <li>Un numero de rue</li>
 * <li>Une rue</li>
 * <li>Une ville</li>
 * <li>Un code postal</li>
 * </ul>
 * </p>
 * 
 * <p>
 * Des annotations pour indiquer le parsing XML automatique de cette classe ont
 * été ajoutés
 * </p>
 * 
 * @author Gabriel Etienne
 * @version 1.2
 */

@XmlRootElement
public class Adresse {

	/**
	 * L'ID de l'Adresse. Cet ID n'est pas modifiable.
	 * 
	 * @see Adresse#Adresse(int, int, String, int)
	 * @see Adresse#getId()
	 * @see Adresse#setId(long)
	 */
	private long id;

	/**
	 * Le numéro de l'Adresse.
	 * 
	 * @see Adresse#Adresse(int, int, String, int)
	 * @see Adresse#getNumero()
	 * @see Adresse#setNumero(int)
	 */
	private int numero;

	/**
	 * La rue de l'Adresse.
	 * 
	 * @see Adresse#Adresse(int, int, String, int)
	 * @see Adresse#getRue()
	 * @see Adresse#setRue(String)
	 */
	private String rue;

	/**
	 * Le code postal de l'Adresse.
	 * 
	 * @see Adresse#Adresse(int, int, String, int)
	 * @see Adresse#getCodePostal()
	 * @see Adresse#setCodePostal(int)
	 */
	private Integer codePostal;

	/**
	 * La ville de l'Adresse.
	 * 
	 * @see Adresse#Adresse(int, int, String, int)
	 * @see Adresse#getVille()
	 * @see Adresse#setVille(String)
	 */
	private String ville;

	/**
	 * Constructeur d'Adresse.
	 * <p>
	 * Constructeur vide du beans Adresse
	 * </p>
	 *
	 */
	public Adresse() {
	}

	/**
	 * Constructeur Adresse.
	 * <p>
	 * A la construction d'un objet Adresse, on fixe l'identificateur de
	 * l'Adresse, le numéro de la rue, la rue, le code postal et la ville
	 * </p>
	 * 
	 * @param id
	 *            L'identifiant unique de l'Adresse.
	 * @param numero
	 *            Le numéro de la rue de l'Adresse
	 * 
	 * @param rue
	 *            La rue de l'Adresse
	 * 
	 * @param codePostal
	 *            Le code postal de la ville de l'Adresse
	 * 
	 * @param ville
	 *            La ville de l'Adresse
	 * 
	 * @see Adresse#id
	 * @see Adresse#numero
	 * @see Adresse#rue
	 * @see Adresse#codePostal
	 * @see Adresse#ville
	 */
	public Adresse(long _id, int _numero, String _rue, int _codePostal, String _ville) {
		this.id = _id;
		this.numero = _numero;
		this.rue = _rue;
		this.ville = _ville;
		this.codePostal = _codePostal;
	}

	/**
	 * Retourne l'id de l'Adresse
	 * 
	 * @return Un integer représentant l'identificateur de l'Adresse
	 * 
	 */
	@XmlElement(name = "adresse_id")
	public long getId() {
		return id;
	}

	/**
	 * Met à jour l'id de l'Adresse
	 * 
	 * @param _id
	 *            Le nouvel id de l'Adresse
	 * 
	 */
	public Adresse setId(long _id) {
		this.id = _id;
		return this;
	}

	/**
	 * Retourne le numéro de l'Adresse
	 * 
	 * @return Un integer représentant le numéro de l'Adresse
	 * 
	 */
	@XmlElement(name = "numero")
	public long getNumero() {
		return numero;
	}

	/**
	 * Met à jour la numéro dans la rue de l'Adresse.
	 * 
	 * @param _numero
	 *            Le nouveau numéro de l'Adresse
	 * 
	 */
	public Adresse setNumero(int _numero) {
		this.numero = _numero;
		return this;
	}

	/**
	 * Retourne la rue de l'Adresse
	 * 
	 * @return Une string représentant le nom de la rue de l'Adresse
	 * 
	 */
	@XmlElement(name = "rue")
	public String getRue() {
		return rue;
	}

	/**
	 * Met à jour la rue de l'Adresse.
	 * 
	 * @param _rue
	 *            La nouvelle rue de l'Adresse
	 * 
	 */
	public Adresse setRue(String _rue) {
		this.rue = _rue;
		return this;
	}

	/**
	 * Retourne le code postal de l'Adresse
	 * 
	 * @return Un integer représentant le code postal de l'Adresse
	 * 
	 */
	@XmlElement(name = "codePostal")
	public int getCodePostal() {
		return codePostal;
	}

	/**
	 * Met à jour le code postal de l'Adresse.
	 * 
	 * @param _codePostal
	 *            Le nouveau code postal de l'Adresse
	 * 
	 */
	public Adresse setCodePostal(int _codePostal) {
		this.codePostal = _codePostal;
		return this;
	}

	/**
	 * Retourne la ville de l'Adresse
	 * 
	 * @return Une string représentant le nom de la ville de l'Adresse
	 * 
	 */
	@XmlElement(name = "ville")
	public String getVille() {
		return ville;
	}

	/**
	 * Met à jour la ville de l'Adresse.
	 * 
	 * @param _ville
	 *            La nouvelle ville de l'Adresse
	 * 
	 */
	public Adresse setVille(String _ville) {
		this.ville = _ville;
		return this;
	}

}
