package beans;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <br>
 * Beans Annonces representant une liste d'Annonce dans notre schéma</b>
 * <p>
 * Une liste d'Annonce est composée d'un attribut :
 * <ul>
 * <li>Un List d'objet Annonce</li>
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
@XmlRootElement(name = "annonces")
@XmlAccessorType(XmlAccessType.FIELD)
public class Annonces {

	/**
	 * La liste d'Annonces.
	 * 
	 * @see Annonces#getAnnonces()
	 * @see Annonces#setAnnonces(List)
	 */
	@XmlElement(name = "annonce")
	private List<Annonce> annonces = null;

	/**
	 * Retourne la liste des Annonce
	 * 
	 * @return Une liste d'Annonce
	 * 
	 * @see Annonces#annonces
	 * 
	 */
	public List<Annonce> getAnnonces() {
		return annonces;
	}

	/**
	 * Met à jour la liste d'Annonces
	 * 
	 * @param _annonces
	 *            La liste d'Annonce
	 * 
	 */
	public void setAnnonces(List<Annonce> _annonces) {
		this.annonces = _annonces;
	}
}
