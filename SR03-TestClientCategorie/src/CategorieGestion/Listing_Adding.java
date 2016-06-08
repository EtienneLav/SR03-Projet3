package CategorieGestion;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import beans.*;
import WebService.WebServiceCategorieProxy;

import java.io.IOException;
import java.io.StringReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Listing_Adding extends HttpServlet {
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		WebServiceCategorieProxy categorieProxy = new WebServiceCategorieProxy();
		
		String categorie_id_string = (String) request.getParameter("categorie_id");
		
		//Si on arrive sur cette page après une demande de suppresion
		if(categorie_id_string != null)
			categorieProxy.delCategorie((int) Long.valueOf(categorie_id_string).longValue());
		
		String categories = categorieProxy.getCategories();
		System.out.println("string "+categories);
		
		//Tableau à envoyer à la JSP : id x nom
		HashMap<Integer,String> categories_array = new HashMap<Integer,String>();

		//Traitement XML de toutes les "categorie"
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;

		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InputSource is = new InputSource();
		is.setCharacterStream(new StringReader(categories));

		
		Document doc;
		try {
			doc = db.parse(is);
			System.out.println("teeest "+doc);
			NodeList nList = doc.getElementsByTagName("categorie");
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
		
		
        //Envoie la hasMap à la JSP
        request.setAttribute("liste_categories", categories_array);
        this.getServletContext().getRequestDispatcher( "/categorie/liste.jsp" ).forward( request, response );
    }
	
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		//Récupère les champs pouvant avoir été modifiés
		String updated_nom = (String) request.getParameter("name");
		WebServiceCategorieProxy categorieProxy = new WebServiceCategorieProxy();
        
		//Requete le webservice pour ajouter une catégorie
		categorieProxy.newCategorie(updated_nom);
      
		//Récupère toutes les catégories pour les afficher
		String categories = categorieProxy.getCategories();
		System.out.println("string "+categories);
		
		//Tableau à envoyer à la JSP : id x nom
		HashMap<Integer,String> categories_array = new HashMap<Integer,String>();

		//Traitement XML de toutes les "categorie"
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;

		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InputSource is = new InputSource();
		is.setCharacterStream(new StringReader(categories));

		
		Document doc;
		try {
			doc = db.parse(is);
			System.out.println("teeest "+doc);
			NodeList nList = doc.getElementsByTagName("categorie");
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
		
		
        //Envoie la hasMap à la JSP
        request.setAttribute("liste_categories", categories_array);
		this.getServletContext().getRequestDispatcher( "/categorie/liste.jsp" ).forward( request, response );
    }
}