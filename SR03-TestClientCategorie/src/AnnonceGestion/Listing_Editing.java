package AnnonceGestion;

import java.util.ArrayList;
import java.util.HashMap;

import WebService.WebServiceCategorieProxy;
import WebService.WebServiceAnnonceProxy;

import java.io.IOException;
import java.io.StringReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * <br>
 * Servlet d'affichage et d'ajout d'annonces.</b>
 * <p>
 * Gestion des réponses aux appels GET et POST
 * </p>
 * 
 * 
 * @author Gabriel Etienne
 * @version 1.2
 */
@SuppressWarnings("serial")
public class Listing_Editing extends HttpServlet {

	/**
	 * Méthode de la servlet permettant la gestion de requête GET
	 * 
	 * Récupération des annonces à afficher depuis le webservice grâce au proxy
	 * Récupération de la liste des annonces disponibles
	 * 
	 * Récupération de la liste des catégories disponibles pour le formulaire
	 * d'ajout d'annonce
	 * 
	 * Traitement du XML pour le renvoie des informations servant à l'affichage
	 * à la JSP
	 * 
	 * @see WebService.WebServiceAnnonceProxy
	 * @see WebService.WebServiceCategorieProxy
	 * 
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebServiceAnnonceProxy annonceProxy = new WebServiceAnnonceProxy();

		String annonce_id_string = (String) request.getParameter("annonce_id");

		// Si on arrive sur cette page après une demande de suppresion
		if (annonce_id_string != null)
			annonceProxy.deleteAnnonce((int) Long.valueOf(annonce_id_string).longValue());

		String annonces = annonceProxy.getAnnonces();
		System.out.println("string " + annonces);

		// Tableau à envoyer à la JSP : id x nom x n° adresse x telephonne x
		// numero categorie x nom categorie
		ArrayList<Integer> id_list = new ArrayList<Integer>();
		ArrayList<String> nom_list = new ArrayList<String>();
		ArrayList<Integer> tel_list = new ArrayList<Integer>();
		ArrayList<Integer> adresse_id_list = new ArrayList<Integer>();
		ArrayList<Integer> categorie_id_list = new ArrayList<Integer>();
		ArrayList<String> categorie_nom_list = new ArrayList<String>();

		// Traitement XML de toutes les "categorie"
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;

		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InputSource is = new InputSource();
		is.setCharacterStream(new StringReader(annonces));

		Document doc;
		try {
			doc = db.parse(is);
			System.out.println("teeest " + doc);

			// id des annonces
			NodeList nList_id = doc.getElementsByTagName("annonce_id");
			System.out.println("nombre d'id d'annonce :" + nList_id.getLength());

			for (int temp = 0; temp < nList_id.getLength(); temp++) {

				Node nNode = nList_id.item(temp);
				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					System.out.println("valeur de l'id : " + nNode.getTextContent());
					id_list.add((int) Long.valueOf(nNode.getTextContent()).longValue());

				}

			}
			// nom des annonces
			NodeList nList_nom = doc.getElementsByTagName("nom");
			System.out.println("nombre de name d'annonce :" + nList_nom.getLength());

			for (int temp = 0; temp < nList_nom.getLength(); temp++) {

				Node nNode = nList_nom.item(temp);
				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					System.out.println("valeur du nom : " + nNode.getTextContent());
					nom_list.add(nNode.getTextContent());

				}

			}

			// telephone des annonces
			NodeList nList_tel = doc.getElementsByTagName("telephone");
			System.out.println("nombre de telephone d'annonce :" + nList_tel.getLength());

			for (int temp = 0; temp < nList_tel.getLength(); temp++) {

				Node nNode = nList_tel.item(temp);
				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					System.out.println("valeur de telephone : " + nNode.getTextContent());
					tel_list.add((int) Long.valueOf(nNode.getTextContent()).longValue());

				}

			}

			// id des adresses
			NodeList nList_adresse_id = doc.getElementsByTagName("adresse_id");
			System.out.println("nombre d'id d'annonce :" + nList_adresse_id.getLength());

			for (int temp = 0; temp < nList_adresse_id.getLength(); temp++) {

				Node nNode = nList_adresse_id.item(temp);
				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					System.out.println("valeur de l'id de l'adresse: " + nNode.getTextContent());
					adresse_id_list.add((int) Long.valueOf(nNode.getTextContent()).longValue());

				}

			}

			// id et nom de la categorie des annonces
			NodeList nList_categorie_id = doc.getElementsByTagName("categorie");

			for (int temp = 0; temp < nList_categorie_id.getLength(); temp++) {

				Node nNode = nList_categorie_id.item(temp);

				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					System.out.println("Categorie id : " + eElement.getAttribute("id"));
					System.out.println("Categorie id : " + eElement.getAttribute("nom"));

					categorie_id_list.add(Integer.parseInt(eElement.getAttribute("id")));
					categorie_nom_list.add((eElement.getAttribute("nom")));

				}
			}
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Récupération des categories et de leurs id
		WebServiceCategorieProxy categorieProxy = new WebServiceCategorieProxy();

		String categories = categorieProxy.getCategories();
		System.out.println("string " + categories);

		// Tableau à envoyer à la JSP : id x nom
		HashMap<Integer, String> categories_array = new HashMap<Integer, String>();

		// Traitement XML de toutes les "categorie"
		DocumentBuilderFactory dbf_1 = DocumentBuilderFactory.newInstance();
		DocumentBuilder db_1 = null;

		try {
			db_1 = dbf_1.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InputSource is_1 = new InputSource();
		is_1.setCharacterStream(new StringReader(categories));

		Document doc_1;
		try {
			doc_1 = db_1.parse(is_1);
			System.out.println("teeest " + doc_1);
			NodeList nList = doc_1.getElementsByTagName("categorie");
			System.out.println(nList.getLength());

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					System.out.println("Categorie id : " + eElement.getAttribute("id"));
					System.out.println("Categorie id : " + eElement.getAttribute("nom"));
					categories_array.put(Integer.parseInt(eElement.getAttribute("id")), eElement.getAttribute("nom"));
				}
			}
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Envoie la hasMap à la JSP
		request.setAttribute("liste_categories", categories_array);

		System.out.println("out?");
		// Envoie la hasMap à la JSP
		request.setAttribute("liste_id", id_list);
		request.setAttribute("liste_noms", nom_list);
		request.setAttribute("liste_tels", tel_list);
		request.setAttribute("liste_adresse_id", adresse_id_list);
		request.setAttribute("liste_categorie_nom", categorie_nom_list);
		request.setAttribute("liste_categorie_id", categorie_id_list);

		System.out.println("out2?");
		this.getServletContext().getRequestDispatcher("/annonce/liste.jsp").forward(request, response);

	}

	/**
	 * Méthode de la servlet permettant la gestion de requête POST
	 * 
	 * Récupération de l'annonce à ajouter. Envoie des informations d'ajout
	 * d'annonce à l'annonce proxy qui va requêter le webservice.
	 * 
	 * @see WebService.WebServiceAnnonceProxy
	 * @see WebService.WebServiceCategorieProxy
	 * 
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupère les champs pour ajout
		String nouveau_nom = (String) request.getParameter("nom");
		String nouveau_categorie_id_string = (String) request.getParameter("categorie_id");
		String nouveau_telephone_string = (String) request.getParameter("telephone");
		String nouveau_numero_string = (String) request.getParameter("numero");
		String nouveau_rue = (String) request.getParameter("rue");
		String nouveau_code_postale_string = (String) request.getParameter("code_postale");
		String nouveau_ville = (String) request.getParameter("ville");

		// Transformation en int pour ceux doivent l'être
		int nouveau_categorie_id = Integer.parseInt(nouveau_categorie_id_string);
		int nouveau_telephone = Integer.parseInt(nouveau_telephone_string);
		int nouveau_numero = Integer.parseInt(nouveau_numero_string);
		int nouveau_code_postale = Integer.parseInt(nouveau_code_postale_string);

		// AJOUT
		WebServiceAnnonceProxy annonceProxy = new WebServiceAnnonceProxy();
		annonceProxy.createAnnonce(nouveau_nom, nouveau_categorie_id, nouveau_telephone, nouveau_numero, nouveau_rue,
				nouveau_code_postale, nouveau_ville);

		// Récupère toutes les annonces pour les afficher
		doGet(request, response);
	}
}