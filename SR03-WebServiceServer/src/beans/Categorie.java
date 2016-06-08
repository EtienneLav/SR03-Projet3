package beans;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
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
	
	@XmlAttribute
	public Categorie setId(long id) {
        this.id = id;
        return this;
    }	
	
	public String getNom() {
        return nom;
    }
	
	@XmlAttribute
	public Categorie setNom(String nom) {
        this.nom = nom;
        return this;
    }	
}
