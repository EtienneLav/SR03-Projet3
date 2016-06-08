package WebService;
import WebService.WebServiceCategorieProxy;
import beans.Adresse;
import beans.Annonce;
import beans.Categorie;

import java.rmi.RemoteException;


public class main {

	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		WebServiceAnnonceProxy web = new WebServiceAnnonceProxy();
		
		Annonce annonce = new Annonce();
		annonce.setId(1);
		annonce.setNom("Oui");
		annonce.setTelephone(060606);
		
		
		
		
		Adresse adresse = new Adresse();
		long adresse_id = 1;
		adresse.setId(adresse_id);
		annonce.setAdresse(adresse);
		int categorie_id = 5;
		
		Categorie cate = new Categorie();
		cate.setId(categorie_id);
		
		annonce.setCategorie(cate);
		
		//Annonce cat =web.createAnnonce(annonce, categorie_id, adresse);
		
		//System.out.println("nom : "+cat.getNom());
		
		//WebServiceCategorie.WebServiceCategorieProxy proxy = new WebServiceCategorie.WebServiceCategorieProxy();
	}

}
