package Admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * <br>
 * Servlet de login administrateur.</b>
 * <p>
 * Gestion des réponses aux appels GET et POST
 * </p>
 * 
 * 
 * @author Gabriel Etienne
 * @version 1.2
 */
@SuppressWarnings("serial")
public class AdminLog extends HttpServlet {

	/**
	 * Méthode de la servlet permettant la gestion de requête GET
	 * 
	 * Log in en temps qu'administrateur pour accéder aux pages protégées
	 * 
	 * Ajoute simplement un attribut de session
	 * 
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Récupération de la session depuis la requête */
		HttpSession session = request.getSession();
		
		//empêcher de faire deux fois le même questionnaire par session
		Boolean is_admin = (Boolean) session.getAttribute("admin");
			
		if( is_admin == null || is_admin == false ){
			
			//Pas encore admin
			session.setAttribute("admin", true);
			request.setAttribute("already_logged", false);
		}
		
		else{
			request.setAttribute("already_logged", true);
		}
		this.getServletContext().getRequestDispatcher("/admin/success.jsp").forward(request, response);
	}

	/**
	 * Méthode de la servlet permettant la gestion de requête POST
	 * 
	 * Méthode servant à la redirection vers la méthode doGet en cas de requête POST
	 * sur cette page
	 * 
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}