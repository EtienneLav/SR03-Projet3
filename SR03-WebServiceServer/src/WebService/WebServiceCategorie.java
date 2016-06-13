package WebService;

import java.util.List;

import beans.Categorie;
import beans.Categories;
import DAO.CategorieDAO;
import DAO.DAOFactory;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class WebServiceCategorie {

	CategorieDAO categorieDAO = (CategorieDAO) DAOFactory.getCategorieDAO();

	public WebServiceCategorie() {
		super();
	}

	/**
	 * Méthode du WebService permettant la récupération d'une Categorie par son
	 * id
	 * 
	 * @param categorie_id
	 *            La Categorie à récupérer
	 * 
	 * @return la chaine XML correspondant à la Categorie voulue
	 * 
	 * @see beans.Categorie
	 * @see DAO.CategorieDAO#find(long)
	 * 
	 */
	public String getCategorie(int categorie_id) throws JAXBException {

		Categorie categorie = categorieDAO.find(categorie_id);

		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Categorie.class);
			java.io.StringWriter sw = new StringWriter();

			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			marshaller.marshal(categorie, sw);

			System.out.println("string XML " + sw.toString());
			return sw.toString();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "false";

	}

	/**
	 * Méthode du WebService permettant la récupération de toutes les Categorie
	 * 
	 *
	 * @return la chaine XML correspondant à toutes lesCategorie présentes en
	 *         BDD
	 * 
	 * @see beans.Categories
	 * @see DAO.CategorieDAO#findAll()
	 * 
	 */
	public String getCategories() {
		List<Categorie> l_categories = categorieDAO.findAll();

		Categories categories = new Categories();
		categories.setCategories(l_categories);

		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Categories.class);
			java.io.StringWriter sw2 = new StringWriter();

			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			marshaller.marshal(categories, sw2);

			System.out.println("string XML " + sw2.toString());
			return sw2.toString();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "false";
	}

	/**
	 * Méthode du WebService permettant la création d'une Categorie
	 * 
	 * @param nom
	 *            Le nom de la Categorie à créer
	 * 
	 * @return la chaine XML correspondant à la Categorie ajoutée
	 * 
	 * @see beans.Categorie
	 * @see DAO.CategorieDAO#create(Categorie)
	 * 
	 */
	public String newCategorie(String nom) {

		Categorie cat = new Categorie(0, nom);

		cat = categorieDAO.create(cat);

		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Categorie.class);
			java.io.StringWriter sw3 = new StringWriter();

			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			marshaller.marshal(cat, sw3);

			System.out.println("string XML " + sw3.toString());
			return sw3.toString();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "false";

	}

	/**
	 * Méthode du WebService permettant la suppresion d'une Categorie
	 * 
	 * @param categorie_id
	 *            Le numéro de la catégorie à supprimer
	 * 
	 * @return une boolean traduisant de l'état de la suppresion (succès ou
	 *         échec)
	 * 
	 * @see beans.Categorie
	 * @see DAO.CategorieDAO#remove(int)
	 * 
	 */

	public boolean delCategorie(int categorie_id) {
		System.out.println("Categorie  " + categorie_id + " supprimée !");
		return categorieDAO.remove(categorie_id);
	}

	/**
	 * Méthode du WebService permettant la MAJ d'une Categorie
	 * 
	 * @param id
	 *            Le numéro de la catégorie à mettre à jour
	 * @param nom
	 *            Le nouveau nom de la catégorie
	 * 
	 * @return une boolean traduisant de l'état de la MAJ (succès ou échec)
	 * 
	 * @see beans.Categorie
	 * @see DAO.CategorieDAO#modify(Categorie)
	 * 
	 */

	public boolean modifyCategorie(int id, String nom) {
		Categorie categorie = new Categorie();
		categorie.setId(id);
		categorie.setNom(nom);
		System.out.println("Categorie  " + categorie.getId() + " modifée !");
		return categorieDAO.modify(categorie);
	}

}
