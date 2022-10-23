package linzhihanlijunjie_p2.model;

import java.io.Serializable;

/**
 * class Federacio
 * @author Zhihan_Lin i Junjie_Li
 */
public class Federacio implements Serializable{ 
    private static final long serialVersionUID = 1L;
    
    /**
     * Atribut de class Federacio
     * @nom   nombre de federacio
     * @preu  preu de federacio
     */
    private String nom = "";
    private float preu = 0;

    public Federacio(){
        this.nom="";
        this.preu=0;
    }

    //getters
    public String getNom(){
        return nom;
    }

    public float getPreu(){
        return preu;
    }

    //setters
    public void setNom(String nom){
        this.nom=nom;
    }

    public void setPreu(float preu){
        this.preu = preu;
    }

    /**
     * La informació de la federació
     * @return retorna un string amb la informació sobre la federació del soci federat
     */
    @Override
    public String toString() {
        return "Nom Federació: " + getNom() + ", Preu: " + getPreu()+ " €.";
    }
}
