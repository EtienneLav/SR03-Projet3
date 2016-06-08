package beans;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name = "annonces")
@XmlAccessorType (XmlAccessType.FIELD)
public class Annonces 
{
    @XmlElement(name = "annonce")
    private List<Annonce> annonces = null;
 
    public List<Annonce> getAnnonces() {
        return annonces;
    }
 
    public void setAnnonces(List<Annonce> annonces) {
        this.annonces = annonces;
    }
}
