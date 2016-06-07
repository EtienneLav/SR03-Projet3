package beans;
import java.util.ArrayList;

public class Categorie {
	private long id;
	private String nom;
	
	public Categorie() {}
	
	public Categorie(long id, String nom) {
		this.id = id;
		this.nom = nom;
	}
	
	public long getId() {
        return id;
    }
	
	public Categorie setId(long id) {
        this.id = id;
        return this;
    }	
	
	public String getNom() {
        return nom;
    }
	
	public Categorie setNom(String nom) {
        this.nom = nom;
        return this;
    }	
}
