package beans;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Adresse {
	
	private long id;
	
	private int numero;
	private String rue;
	private String ville;
	private Integer codePostal;
	
	public Adresse() {}
	
	public Adresse(long id, int numero,String rue, String ville, int codePostal) {
		this.id = id;
		this.numero = numero;
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
	}
	@XmlElement(name="adresse_id")
	public long getId() {
        return id;
    }
	
	public Adresse setId(long id) {
        this.id = id;
        return this;
    }	
	@XmlElement(name="numero")
	public long getNumero() {
        return numero;
    }
	
	public Adresse setNumero(int numero) {
        this.numero = numero;
        return this;
    }
	@XmlElement(name="rue")
	public String getRue() {
        return rue;
    }
	
	public Adresse setRue(String rue) {
        this.rue = rue;
        return this;
    }
	@XmlElement(name="ville")
	public String getVille() {
        return ville;
    }
	
	public Adresse setVille(String ville) {
        this.ville = ville;
        return this;
    }
	@XmlElement(name="codePostal")
	public int getCodePostal() {
        return codePostal;
    }
	
	public Adresse setCodePostal(int codePostal) {
        this.codePostal = codePostal;
        return this;
    }
}
