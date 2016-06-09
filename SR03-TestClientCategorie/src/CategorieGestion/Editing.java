package CategorieGestion;

import WebService.WebServiceCategorieProxy;

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
 * Servlet d'édition des catégories.</b>
 * <p>
 * Gestion des réponses aux appels GET et POST
 * </p>
 * 
 * 
 * @author Gabriel Etienne
 * @version 1.2
 */
@SuppressWarnings("serial")
public class Editing extends HttpServlet {

	/**
	 * Méthode de la servlet permettant la gestion de requête GET
	 * 
	 * Récupération de la catégorie à éditer depuis le webservice grâce au proxy
	 * 
	 * Traitement du XML pour le renvoie des informations servant à l'affichage
	 * à la JSP
	 * 
	 * @see WebService.WebServiceCategorieProxy
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebServiceCategorieProxy categorieProxy = new WebServiceCategorieProxy();

		String categorie_id_string = (String) request.getParameter("categorie_id");
		int categorie_id = (int) Long.valueOf(categorie_id_string).longValue();

		// Récupère la categorie à modifier
		String categorie_XML = categorieProxy.getCategorie(categorie_id);
		System.out.println("String XML à afficher : " + categorie_XML);

		// Deux paramètre à renvoyer à la JSP :
		String category_name = null;
		int category_id = 0;
		// Traitement XML de la chaine reçu (une categorie)
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;

		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InputSource is = new InputSource();
		is.setCharacterStream(new StringReader(categorie_XML));

		Document doc;
		try {
			doc = db.parse(is);
			System.out.println("teeest " + doc);
			NodeList nList = doc.getElementsByTagName("categorie");
			System.out.println(nList.getLength());

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					System.out.println("Categorie id : " + eElement.getAttribute("id"));
					System.out.println("Categorie id : " + eElement.getAttribute("nom"));
					category_id = Integer.parseInt(eElement.getAttribute("id"));
					category_name = eElement.getAttribute("nom");

				}
			}
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("JSP name : " + category_name);
		System.out.println("JSP id : " + category_id);

		// Envoie le nom et l'id à la JSP à la JSP
		request.setAttribute("id_categorie", category_id);
		request.setAttribute("nom_categorie", category_name);
		this.getServletContext().getRequestDispatcher("/categorie/details.jsp").forward(request, response);
	}

	/**
	 * Méthode de la servlet permettant la gestion de requête POST
	 * 
	 * Récupération de la catégorie à modifier. Envoie des informations de
	 * modifications de catégorie au proxy qui va requêter le webservice.
	 * 
	 * Traitement du XML pour le renvoie des informations servant à l'affichage
	 * à la JSP
	 * 
	 * @see WebService.WebServiceCategorieProxy
	 * 
	 */

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupère le nouveau nom de la catégorie
		String updated_nom = (String) request.getParameter("name");
		System.out.println("nom ; changer : "+updated_nom);

		// Récupère l'id de la catégorie à modifier
		String categorie_id_string = (String) request.getParameter("id");

		WebServiceCategorieProxy categorieProxy = new WebServiceCategorieProxy();

		// Requete le webservice pour modifier une catégorie
		categorieProxy.modifyCategorie((int) Long.valueOf(categorie_id_string).longValue(), updated_nom);

		// Récupère la categorie à modifier
		String categorie_XML = categorieProxy.getCategorie((int) Long.valueOf(categorie_id_string).longValue());
		System.out.println("String XML à afficher : " + categorie_XML);

		// Deux paramètre à renvoyer à la JSP :
		String category_name = null;
		int category_id = 0;

		// Traitement XML de la chaine reçu (une categorie)
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;

		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InputSource is = new InputSource();
		is.setCharacterStream(new StringReader(categorie_XML));

		Document doc;
		try {
			doc = db.parse(is);
			System.out.println("teeest " + doc);
			NodeList nList = doc.getElementsByTagName("categorie");
			System.out.println(nList.getLength());

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					System.out.println("Categorie id : " + eElement.getAttribute("id"));
					System.out.println("Categorie id : " + eElement.getAttribute("nom"));
					category_id = Integer.parseInt(eElement.getAttribute("id"));
					category_name = eElement.getAttribute("nom");

				}
			}
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("JSP name : " + category_name);
		System.out.println("JSP id : " + category_id);

		// Envoie le nom et l'id à la JSP à la JSP
		request.setAttribute("id_categorie", category_id);
		request.setAttribute("nom_categorie", category_name);
		this.getServletContext().getRequestDispatcher("/categorie/details.jsp").forward(request, response);
	}
}