package beans;

public class Annonce {
	private long id;
	private Categorie categorie;
	private String nom;
	private Adresse adresse;
	private long telephone;
	
	public Annonce() {}
	
	public Annonce(long id, Categorie categorie, String nom, Adresse adresse, long telephone) {
		this.id = id;
		this.setCategorie(categorie);
		this.nom = nom;
		this.adresse = adresse;
		this. telephone = telephone;
	}	
	
	public long getId() {
        return id;
    }
	
	public Annonce setId(long id) {
        this.id = id;
        return this;
    }
	
	public String getNom() {
        return nom;
    }
	
	public Annonce setNom(String nom) {
        this.nom = nom;
        return this;
    }
	
	public Adresse getAdresse() {
        return adresse;
    }
	
	public Annonce setAdresse(Adresse adresse) {
        this.adresse = adresse;
        return this;
    }
	
	public long getTelephone() {
        return telephone;
    }
	
	public Annonce setTelephone(long telephone) {
        this.telephone = telephone;
        return this;
    }

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
}
