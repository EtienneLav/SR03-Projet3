package beans;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Annonce {
	private long id;
	private Categorie categorie;
	private String nom;
	private Adresse adresse;
	private long telephone;
	
	public Annonce() {}
	
	public Annonce(long id, Categorie categorie, String nom, Adresse adresse, long telephone) {
		this.id = id;
		this.categorie= categorie;
		this.nom = nom;
		this.adresse = adresse;
		this. telephone = telephone;
	}
	
	public void print(){
		System.out.println("id : "+id);
		System.out.println("categorie_id : "+categorie.getId());
		System.out.println("categorie_nom : "+categorie.getNom());
		System.out.println("nom : "+nom);
		System.out.println("adresse_id : "+adresse.getId());
		System.out.println("telephone : "+telephone);
	}
	@XmlElement(name="annonce_id")
	public long getId() {
        return id;
    }
	
	public Annonce setId(long id) {
        this.id = id;
        return this;
    }
	@XmlElement(name="nom")
	public String getNom() {
        return nom;
    }
	
	public Annonce setNom(String nom) {
        this.nom = nom;
        return this;
    }
	@XmlElement(name="adresse")
	public Adresse getAdresse() {
        return adresse;
    }
	
	public Annonce setAdresse(Adresse adresse) {
        this.adresse = adresse;
        return this;
    }
	@XmlElement(name="telephone")
	public long getTelephone() {
        return telephone;
    }
	
	public Annonce setTelephone(long telephone) {
        this.telephone = telephone;
        return this;
    }
	@XmlElement(name="categorie")
	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
}
