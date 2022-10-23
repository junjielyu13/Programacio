/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linzhihanlijunjie_l3.model;

import java.io.Serializable;

/**
 * Classe 
 * @author Zhihan_Lin i Junjie_Li
 */
public class Article implements Serializable {
    private static final long serialVersionUID = 1L; 
    
    private String id,nom;
    private float preu;
    private int tempsFinsEnviament;
    private boolean AdmetUrgent;
    
    /**
     * Constructor
     * @param id    identificador de l'article
     * @param nom   nom de l'article
     * @param preu  preu de l'article
     * @param tempsFinsEnviament    temps fins enviament
     * @param AdmetUrgent           si l'article admet enviament urgent o no
     */
    public Article(String id, String nom, float preu, int tempsFinsEnviament, boolean AdmetUrgent) {
        this.id = id;
        this.nom = nom;
        this.preu = preu;
        this.tempsFinsEnviament = tempsFinsEnviament;
        this.AdmetUrgent = AdmetUrgent;
    }

    /**
     * Getters i setters
     * 
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPreu() {
        return preu;
    }

    public void setPreu(float preu) {
        this.preu = preu;
    }

    public float getTempsFinsEnviament() {
        return tempsFinsEnviament;
    }

    public void setTempsEnviament(int tempsEnviament) {
        this.tempsFinsEnviament = tempsEnviament;
    }

    public boolean getAdmetUrgent() {
        return AdmetUrgent;
    }

    public void setAdmetUrgent(boolean AdmetUrgent) {
        this.AdmetUrgent = AdmetUrgent;
    }
    
    /**
     * Mètode que retorna la informació d'un article
     * @return retorna un string amb les informacions d'article
     */
    @Override
    public String toString(){
        return "Id = " + getId() + ", Nom = " + getNom() + ", Preu = " + getPreu() 
                + "€, Temps fins enviament = " + getTempsFinsEnviament() + "minuts, Enviament Urgent = " + getAdmetUrgent() + "\n";
    }
    
}
