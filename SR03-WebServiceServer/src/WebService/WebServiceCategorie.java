package WebService;
import java.util.List;

import beans.Annonce;
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
	
	public WebServiceCategorie() { super(); }
	
	public String getCategorie(int categorie_id) throws JAXBException {
		
		Categorie categorie = categorieDAO.find(categorie_id);
		System.out.println("Categorie retournée : " + categorie.getId() + " // " + categorie.getNom());
		
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Categorie.class);
			java.io.StringWriter sw = new StringWriter();

		    Marshaller marshaller = jaxbContext.createMarshaller();
		    marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		    marshaller.marshal(categorie, sw);

		    System.out.println("string XML "+sw.toString());
		    return sw.toString();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	   return "false";
	    
	}
	
	public String getCategories() {
		List<Categorie> l_categories = categorieDAO.findAll();
		System.out.println("Un ensemble de : " + l_categories.size() + " categories");
		for (int i = 0; i < l_categories.size(); i++) {
			System.out.println("ID : "+l_categories.get(i).getId()+" Nom : "+l_categories.get(i).getNom());
		}
		
		Categories categories = new Categories();
		categories.setEmployees(l_categories);
		
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Categories.class);
			java.io.StringWriter sw2 = new StringWriter();

		    Marshaller marshaller = jaxbContext.createMarshaller();
		    marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		    marshaller.marshal(categories, sw2);

		    System.out.println("string XML "+sw2.toString());
		    return sw2.toString();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "false";
	}
	
	public String newCategorie(String nom) {
		System.out.println("Categorie ajoutée !");
		System.out.println("Categorie nom :"+nom);
		
		Categorie cat = new Categorie(0, nom);
		
		cat = categorieDAO.create(cat);
		
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Categorie.class);
			java.io.StringWriter sw3 = new StringWriter();

		    Marshaller marshaller = jaxbContext.createMarshaller();
		    marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		    marshaller.marshal(cat, sw3);

		    System.out.println("string XML "+sw3.toString());
		    return sw3.toString();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	   return "false";
		
		
	}
	
	public boolean delCategorie(int categorie_id) {
		System.out.println("Categorie  "+categorie_id+" supprimée !");
		return categorieDAO.remove(categorie_id);
	}
	
	public boolean modifyCategorie(int id, String nom) {
		Categorie categorie = new Categorie();
		categorie.setId(id);
		categorie.setNom(nom);
		System.out.println("Categorie  "+categorie.getId()+" modifée !");
		return categorieDAO.modify(categorie);
	}
	
}

