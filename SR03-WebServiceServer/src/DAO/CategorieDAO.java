package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Categorie;

public class CategorieDAO extends DAO<Categorie> {
	
	public  Categorie create(Categorie categorie){
		try {
		      ResultSet result = this.connect
                .createStatement(
                		ResultSet.TYPE_SCROLL_INSENSITIVE, 
                		ResultSet.CONCUR_UPDATABLE
                ).executeQuery(
                		"SELECT MAX(id) AS id FROM Categorie"
                );
		      if(result.first()){
		        long id = result.getLong("id") + 1;
		        categorie.setId(id);
		        
				PreparedStatement prepare = this.connect.prepareStatement("INSERT INTO Categorie (id, nom) VALUES(?, ?)");
				prepare.setLong(1, id);
				prepare.setString(2, categorie.getNom());
				prepare.executeUpdate();
				
				
			}	
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
		
		return categorie;
	}
	
	
	
	public Categorie find(long id){
		Categorie categorie = new Categorie();
		try {
		    ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
		    		.executeQuery("SELECT * FROM Categorie WHERE id = " + id);
		    if(result.first()) {
		    	
		    	categorie = new Categorie(id, result.getString("nom"));
		    }		    
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return categorie;
	}
	
	public ArrayList<Categorie> findAll() {
		ArrayList<Categorie> categories = new ArrayList<Categorie>();
		try {
            ResultSet result = this.connect
                                   .createStatement(
                                            	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                                                ResultSet.CONCUR_UPDATABLE
                                             ).executeQuery("SELECT * FROM Categorie ORDER BY id asc");
            while(result.next()){
            	Categorie categorie = this.find(result.getLong("id"));
            	categories.add(categorie);	
            }
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
		
		return categories;
	}

	public  Categorie update(Categorie categorie){
		try {		
            this .connect	
                 .createStatement(
                	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE
                 ).executeUpdate(
                     	"UPDATE Categorie SET nom = '" + categorie.getNom() + "'"+
                            	" WHERE id = " + categorie.getId()
                            	);
            
            categorie = this.find(categorie.getId());
	    } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	    }
	    
	    return categorie;	
	}
	
	public  boolean modify(Categorie categorie){
		try {		
           if( this .connect	
                 .createStatement(
                	ResultSet.TYPE_SCROLL_INSENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE
                 ).executeUpdate(
                     	"UPDATE Categorie SET nom = '" + categorie.getNom() + "'"+
                            	" WHERE id = " + categorie.getId()
                            	) >=1)
        	   return true;
           else
        	   return false;
	    } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	    }
	    
	}
	
	public void delete(Categorie categorie){
		try {
     
            this    .connect
                	.createStatement(
                         ResultSet.TYPE_SCROLL_INSENSITIVE, 
                         ResultSet.CONCUR_UPDATABLE
                    ).executeUpdate(
                    	"DELETE FROM Categorie"+
                                	" WHERE id = " + categorie.getId()                        		
                    );
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
	}
	
	public boolean remove(int categorie_id){
		try {
     
            if(this    .connect
                	.createStatement(
                         ResultSet.TYPE_SCROLL_INSENSITIVE, 
                         ResultSet.CONCUR_UPDATABLE
                    ).executeUpdate(
                    	"DELETE FROM Categorie"+
                                	" WHERE id = " + categorie_id                        		
                    ) >=1 )
            	return true;
            else return false;
            
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
		return false;	
	}
}