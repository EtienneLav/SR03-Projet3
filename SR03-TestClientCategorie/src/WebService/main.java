package WebService;
import WebService.WebServiceCategorieProxy;
import beans.Categorie;

import java.rmi.RemoteException;


public class main {

	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		WebServiceCategorieProxy web = new WebServiceCategorieProxy();
		
		
		Categorie[] cat_array =web.getCategories();
		
		for (int i = 0; i < cat_array.length; i++) {
			System.out.println("ID : "+cat_array[i].getId()+" Nom : "+cat_array[i].getNom());
		}
		
		//WebServiceCategorie.WebServiceCategorieProxy proxy = new WebServiceCategorie.WebServiceCategorieProxy();
	}

}
