package connexion;

import java.sql.DriverManager;
import java.sql.SQLException;


public class SqlConnexion{

	/**
	 * URL de connection
	 */
	private static String url = "jdbc:mysql://tuxa.sme.utc:3306/sr03p016";
	/**
	 * Nom du user
	 */
	private static String user = "sr03p016";
	/**
	 * Mot de passe du user
	 */
	private static String passwd = "GBtR5g6y";
	/**
	 * Objet Connection
	 */
	private static java.sql.Connection connect;
	
	/**
	 * Singleton
	 */
	public static java.sql.Connection getInstance(){		
		if(connect == null){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connect = DriverManager.getConnection(url, user, passwd);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
			//e.printStackTrace();
			}
		}		
		return connect;	
	}	
}