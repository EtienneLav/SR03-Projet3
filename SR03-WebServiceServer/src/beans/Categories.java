package beans;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <br>
 * Beans Categories representant une liste de Categorie dans notre schéma</b>
 * <p>
 * Une liste de Categorie est composée d'un attribut :
 * <ul>
 * <li>Un List d'objet Categorie</li>
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

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class Categories {
	/**
	 * La liste de Categories.
	 * 
	 * @see Categories#getCategories()
	 * @see Categories#setCategories(List)
	 */
	@XmlElement(name = "categorie")
	private List<Categorie> categories = null;

	/**
	 * Retourne la liste des Categories
	 * 
	 * @return Une liste de Categorie
	 * 
	 * @see Categories#categories
	 * 
	 */
	public List<Categorie> getCategories() {
		return categories;
	}

	/**
	 * Met à jour la liste de Categories
	 * 
	 * @param _categories
	 *            La liste de Categorie
	 * 
	 */
	public void setCategories(List<Categorie> _categories) {
		this.categories = _categories;
	}
}
