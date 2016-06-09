package connexion;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * <br>
 * Classe SqlConnexion permettant la connexion à notre BDD de notre compte SR03
 * UTC</b>
 * <p>
 * Une connexion SQL est composée d'un attribut :
 * <ul>
 * <li>L'URL de connexion</li>
 * <li>L'user pour la connexion</li>
 * <li>Le mdp de connexion</li>
 * <li>L'objet représentant la connexion et son état</li>
 * </ul>
 * </p>
 *
 * @author Gabriel Etienne
 * @version 2.1
 */
public class SqlConnexion {

	/**
	 * L'URL servant à la connexion.
	 * 
	 */
	private static String url = "jdbc:mysql://tuxa.sme.utc:3306/sr03p016";
	/**
	 * Le nom d'utilisateur servant à la connexion.
	 * 
	 */
	private static String user = "sr03p016";
	/**
	 * Le mdp servant à la connexion.
	 * 
	 */
	private static String passwd = "GBtR5g6y";
	/**
	 * L'objet connexion représentant l'état de la connexion.
	 * 
	 */
	private static java.sql.Connection connect;

	/**
	 * Retourne une instance de connexion
	 * 
	 * @return l'objet de type java.sql.Connection
	 * 
	 * @see SqlConnexion#connect
	 * 
	 */
	public static java.sql.Connection getInstance() {
		if (connect == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connect = DriverManager.getConnection(url, user, passwd);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// e.printStackTrace();
			}
		}
		return connect;
	}
}