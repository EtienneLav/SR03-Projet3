package WebService;

import java.io.StringWriter;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import DAO.AdresseDAO;
import DAO.AnnonceDAO;
import DAO.CategorieDAO;
import DAO.DAOFactory;
import beans.*;

/**
 * <br>
 * WebServiceAnnonce est la classe servant à implémenter notre server.</b>
 * <p>
 * Ici ne sont présentes que les méthodes de gestion des annonces.
 * </p>
 * 
 * <p>
 * </p>
 * 
 * @author Gabriel Etienne
 * @version 1.2
 */
public class WebServiceAnnonce {

	AnnonceDAO annonceDAO = (AnnonceDAO) DAOFactory.getAnnonceDAO();
	CategorieDAO categorieDAO = (CategorieDAO) DAOFactory.getCategorieDAO();
	AdresseDAO adresseDAO = (AdresseDAO) DAOFactory.getAdresseDAO();

	public WebServiceAnnonce() {
		super();
	}

	/**
	 * Méthode du WebService permettant la création d'une annonce.
	 * 
	 * @param nom
	 *            Le nom de l'annonce
	 * @param category_id
	 *            La catégorie de la nouvelle annonce à créer
	 * @param telephone
	 *            Le numéro de téléphone associé à la nouvelle annonce à créer.
	 * @param numero_adresse
	 *            Le numéro de l'adresse lié à l'Annonce à créer.
	 * @param rue_adresse
	 *            La rue de l'adresse lié à l'Annonce à créer.
	 * @param codePostal_adresse
	 *            Le code postal de l'adresse lié à l'Annonce à créer.
	 * @param ville_adresse
	 *            La ville de l'adresse lié à l'Annonce à créer.
	 * 
	 * @return la chaine XML correspondant à l'annonce nouvellement créée.
	 * 
	 * @see beans.Annonce
	 * @see DAO.AnnonceDAO#create(Annonce, Long)
	 * 
	 */
	// TODO DONE
	public String createAnnonce(String nom, int category_id, int telephone, int numero_adresse, String rue_adresse,
			int codePostal_adresse, String ville_adresse) {

		// Création d'un beans avant l'envoie à la DAO pour ajout BDD
		Annonce new_annonce = new Annonce();
		new_annonce.setNom(nom);
		new_annonce.setTelephone(telephone);
		new_annonce.setCategorie(categorieDAO.find(category_id));

		Adresse new_adresse = new Adresse();
		new_adresse.setId(0);
		new_adresse.setNumero(numero_adresse);
		new_adresse.setVille(ville_adresse);
		new_adresse.setRue(rue_adresse);
		new_adresse.setCodePostal(codePostal_adresse);

		new_annonce.setAdresse(new_adresse);

		// Ajout à la BDD
		long category_id_long = Long.parseLong(String.valueOf(category_id));
		Annonce annonce_adeed = annonceDAO.create(new_annonce, category_id_long);

		// Contruction de la chaine XML de retour contenant l'annonce céée
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Annonce.class);
			java.io.StringWriter sw = new StringWriter();

			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			marshaller.marshal(annonce_adeed, sw);

			System.out.println("string XML added " + sw.toString());
			return sw.toString();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "false";

	}

	/**
	 * Méthode du WebService permettant la récupération de toutes les annonces.
	 * 
	 * 
	 * @return la chaine XML correspondant aux annonces présentes en BDD.
	 * 
	 * @see beans.Annonces
	 * @see DAO.AnnonceDAO#findAll()
	 */
	// TODO DONE
	public String getAnnonces() {
		List<Annonce> l_annonces = annonceDAO.findAll();

		Annonces annonces = new Annonces();
		annonces.setAnnonces(l_annonces);

		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Annonces.class);
			java.io.StringWriter sw2 = new StringWriter();

			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			marshaller.marshal(annonces, sw2);

			System.out.println("string XML annonce " + sw2.toString());
			return sw2.toString();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "false";
	}

	/**
	 * Méthode du WebService permettant la récupération d'une annonce par son id
	 * 
	 * @param id
	 *            L'identificateur de l'Annonceà récupérer
	 * @return la chaine XML correspondant à l'annonce voulue
	 * 
	 * @see beans.Annonce
	 * @see DAO.AnnonceDAO#find(long)
	 */
	// TODO DONE
	public String getAnnonceByID(int id) {
		Annonce annonce = annonceDAO.find(id);

		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Annonce.class);
			java.io.StringWriter sw = new StringWriter();

			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			marshaller.marshal(annonce, sw);

			System.out.println("string XML " + sw.toString());
			return sw.toString();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "false";

	}

	/**
	 * Méthode du WebService permettant la récupération de toutes les annonces
	 * d'une catégorie.
	 * 
	 * @param id
	 *            L'identificateur de la catégorie dont on veut récupérer les
	 *            Annonces
	 * @return la chaine XML correspondant aux annonces de la catégorie
	 *         présentes en BDD.
	 * 
	 * @see beans.Annonces
	 * @see DAO.AnnonceDAO#findAnnonceFromCategorie(long)
	 */
	// TODO DONE
	public String getAnnoncesCat(int categorie_id) {
		List<Annonce> l_annonces_by_cat = annonceDAO.findAnnonceFromCategorie(categorie_id);

		Annonces annonces_by_cat = new Annonces();
		annonces_by_cat.setAnnonces(l_annonces_by_cat);

		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Annonces.class);
			java.io.StringWriter sw2 = new StringWriter();

			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			marshaller.marshal(annonces_by_cat, sw2);

			System.out.println("string XML annonce by cat " + sw2.toString());
			return sw2.toString();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "false";
	}

	/**
	 * Méthode du WebService permettant la modification d'une Annonce
	 * 
	 * @param annonce_id
	 *            L'identificateur de l'annonce à modifier
	 * @param nom
	 *            Le nouveau nom de l'annonce à modifier
	 * @param category_id
	 *            La nouvelle catégorie de l'annonce à modifier
	 * @param telephone
	 *            Le nouveau telephone de l'annonce à modifier
	 * @param numero_adresse
	 *            Le nouveau numero de l'Adresse associée à l'Annonce
	 * @param rue_adresse
	 *            Lanouvelle rue de l'Adresse associée à l'Annonce
	 * @param codePostal_adresse
	 *            Le nouveau code postal de l'Adresse associée à l'Annonce
	 * @param ville_adresse
	 *            La nouvelle ville de l'Adresse associée à l'Annonce
	 * 
	 * @return boolean traduisant de l'état de la modification (succès ou échec)
	 * 
	 * @see beans.Annonce
	 * @see DAO.AdresseDAO#find(long, String, String, long)
	 * @see DAO.AnnonceDAO#modifyAnnonce(Annonce)
	 */
	// TODO DONE
	public boolean modifyAnnonce(int annonce_id, String nom, int category_id, int telephone, int numero_adresse,
			String rue_adresse, int codePostal_adresse, String ville_adresse) {

		System.out.println("le nom : " + nom);
		// Création d'un beans avant l'envoie à la DAO pour ajout BDD
		Annonce updated_annonce = new Annonce();
		updated_annonce.setId(annonce_id);
		updated_annonce.setNom(nom);
		updated_annonce.setTelephone(telephone);
		updated_annonce.setCategorie(categorieDAO.find(category_id));

		// Gestion nouvelle adresse ou pas
		Adresse updated_adresse = new Adresse();
		updated_adresse.setId(0);
		updated_adresse.setNumero(numero_adresse);
		updated_adresse.setVille(ville_adresse);
		updated_adresse.setRue(rue_adresse);
		updated_adresse.setCodePostal(codePostal_adresse);

		Adresse is_new_adresse = adresseDAO.find(numero_adresse, rue_adresse, ville_adresse, codePostal_adresse);

		// Adresse n'existe pas..A créer
		if (is_new_adresse == null) {
			Adresse to_create = updated_adresse;
			Adresse new_adresse = adresseDAO.create(to_create);
			updated_annonce.setAdresse(new_adresse);
		}

		else {
			updated_annonce.setAdresse(is_new_adresse);
		}

		// Modif de l'adresse dans la BDD
		boolean success = annonceDAO.modifyAnnonce(updated_annonce);

		return success;

	}

	/**
	 * Méthode du WebService permettant la suppresion d'une Annonce par son id
	 * 
	 * @param id
	 *            L'identificateur de l'annonce à supprimer
	 * 
	 * @return boolean traduisant de l'état de la suppresion (succès ou échec)
	 * 
	 * @see DAO.AnnonceDAO#removeAnnonce(long)
	 */
	// TODO DONE
	public boolean deleteAnnonce(int id) {
		return annonceDAO.removeAnnonce(id);
	}

	/**
	 * Méthode du WebService permettant la recherche d'Annonces
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
	 * @return la chaine XML d'Annonces correspondant à la recherche
	 * 
	 * @see beans.Annonces
	 * @see DAO.AnnonceDAO#findAnnonces(int, String, String, int, boolean)
	 * 
	 * 
	 */
	// TODO DONE
	public String searchAnnonces(int categorie_id, String ville, String annonce_nom, int departement,
			boolean sont_recentes) {
		{

			List<Annonce> l_annonces_searched = annonceDAO.findAnnonces(categorie_id, ville, annonce_nom, departement,
					sont_recentes);

			Annonces annonces_searched = new Annonces();
			annonces_searched.setAnnonces(l_annonces_searched);

			JAXBContext jaxbContext;
			try {
				jaxbContext = JAXBContext.newInstance(Annonces.class);
				java.io.StringWriter sw2 = new StringWriter();

				Marshaller marshaller = jaxbContext.createMarshaller();
				marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
				marshaller.marshal(annonces_searched, sw2);

				System.out.println("string XML annonce by cat " + sw2.toString());
				return sw2.toString();
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return "false";
		}
	}

}
