/**
 * Adresse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package beans;

public class Adresse  implements java.io.Serializable {
    private int codePostal;

    private long id;

    private long numero;

    private java.lang.String rue;

    private java.lang.String ville;

    public Adresse() {
    }

    public Adresse(
           int codePostal,
           long id,
           long numero,
           java.lang.String rue,
           java.lang.String ville) {
           this.codePostal = codePostal;
           this.id = id;
           this.numero = numero;
           this.rue = rue;
           this.ville = ville;
    }


    /**
     * Gets the codePostal value for this Adresse.
     * 
     * @return codePostal
     */
    public int getCodePostal() {
        return codePostal;
    }


    /**
     * Sets the codePostal value for this Adresse.
     * 
     * @param codePostal
     */
    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }


    /**
     * Gets the id value for this Adresse.
     * 
     * @return id
     */
    public long getId() {
        return id;
    }


    /**
     * Sets the id value for this Adresse.
     * 
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }


    /**
     * Gets the numero value for this Adresse.
     * 
     * @return numero
     */
    public long getNumero() {
        return numero;
    }


    /**
     * Sets the numero value for this Adresse.
     * 
     * @param numero
     */
    public void setNumero(long numero) {
        this.numero = numero;
    }


    /**
     * Gets the rue value for this Adresse.
     * 
     * @return rue
     */
    public java.lang.String getRue() {
        return rue;
    }


    /**
     * Sets the rue value for this Adresse.
     * 
     * @param rue
     */
    public void setRue(java.lang.String rue) {
        this.rue = rue;
    }


    /**
     * Gets the ville value for this Adresse.
     * 
     * @return ville
     */
    public java.lang.String getVille() {
        return ville;
    }


    /**
     * Sets the ville value for this Adresse.
     * 
     * @param ville
     */
    public void setVille(java.lang.String ville) {
        this.ville = ville;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Adresse)) return false;
        Adresse other = (Adresse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.codePostal == other.getCodePostal() &&
            this.id == other.getId() &&
            this.numero == other.getNumero() &&
            ((this.rue==null && other.getRue()==null) || 
             (this.rue!=null &&
              this.rue.equals(other.getRue()))) &&
            ((this.ville==null && other.getVille()==null) || 
             (this.ville!=null &&
              this.ville.equals(other.getVille())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getCodePostal();
        _hashCode += new Long(getId()).hashCode();
        _hashCode += new Long(getNumero()).hashCode();
        if (getRue() != null) {
            _hashCode += getRue().hashCode();
        }
        if (getVille() != null) {
            _hashCode += getVille().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Adresse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://beans", "Adresse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codePostal");
        elemField.setXmlName(new javax.xml.namespace.QName("http://beans", "codePostal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://beans", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numero");
        elemField.setXmlName(new javax.xml.namespace.QName("http://beans", "numero"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://beans", "rue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ville");
        elemField.setXmlName(new javax.xml.namespace.QName("http://beans", "ville"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
