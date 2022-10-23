/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LinZhihanLiJunjie_L1.model;


/**
 *
 * @author ZhiHan_Lin i Junjie_Li
 * @date   28/2
 * 
 */

 //Class Pista
public class Pista {       
    
    // Atributs que conté la pista
    private String nom,sector,color,estatNeu,estatPista; 
    private float longitud;

    // un atribut de classe LlistaRemuntadors a la classe Pista (anomenat dependencies).
    private  LlistaRemuntadors dependencies = new LlistaRemuntadors();

 
    public Pista(){
    }

    // Constructor
    // atributs d'inicialització
    public Pista(String nom, String sector, String color, float longitud, String estatNeu, String estatPista) { 
        this.nom = nom;
        this.sector = sector;
        this.color = color;
        this.longitud = longitud;
        this.estatNeu = estatNeu;
        this.estatPista = estatPista;
    }
    
    // setters
    // Els mètodes setters pren un paràmetre (newName) i l’assigna a la variable name. 
    // this paraula clau s'utilitza per referir-se a l'objecte actual.
    public void setNom(String nom) {    
        this.nom = nom;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }
    
    public void setEstatNeu(String estatNeu) {
        this.estatNeu = estatNeu;
    }

    public void setEstatPista(String estatPista){
        this.estatPista = estatPista;
    }

    //getters
    //Els mètodes getters retornen els valors dels noms de les variables.
    public String getNom() {
        return nom;
    }
    
    public String getSector() {
        return sector;
    }

    public String getColor() {
        return color;
    }
    
    public float getLongitud() {
        return longitud;
    }
    
    public String getEstatNeu() {
        return estatNeu;
    }

    public String getEstatPista() {
        return estatPista;
    }
    

    /**
     *  actualitzaEstat
     * 
     * actualitzaEstat() actualitza l'atribut l'estatPista
     * Si els remuntadors d'una pista estan tots fora de servei, doncs la
     * pista es quedarà tancada, si no, el contrari (Oberta)
     * 
     * Implementar el mètode amb dependencies en aquesta classe perquè segons
     * la pràctica, l'atribut dependencies es crea en aquesta classe
     * I en la classe LlistaPistes cridem cadascuna de les Pistes de la llista aquesta mètode. 
     */
    public void actualitzaEstat(){

        if(dependencies.totsForaDeServei()){
            setEstatPista("Tancada");
        }else{
            setEstatPista("Oberta");
        }
    }
    
    /**
     *  @param rm object de remuntaodr
     */
    public void afegirDependencia(Remuntador rm){

        this.dependencies.afegirRemuntador(rm); 

        /* dependencies és un objecte de la classe LlistaRemuntadors, i a través de les objectes
            de la classe Pistes (P1,P2,P3... ) que creavem a la classe EstacioEsqui, es criden a
            aquest mètode i dependencies serà la llista que guarda els remuntadors que pertany a 
            aquella Pista.
            Per exemple, en Pista P1, P1 es crida aquest mètode des de la classe EstaioEsqui: 
            P1.afegirDependencia(RM1); Per tant, dependencies serà un objecte de la classe 
            LlistaRemuntadors que pot cridar el mètode afegirRemuntador(rm) per guardar els remuntadors
            en una llista. Així que, Pista P1 hi haurà una llista de remuntador que només pertany a P1.
            El mateix passarà a P2, P3 ... en què cada Pista hi haurà la seva propia llista de remuntadors.
        */
    }
    
            
    /**
     *  @return La informació de la pista.
     */
    @Override
    public String toString(){
        String pista;
        pista = "Pista: " + getNom() + ",   Sector: " + getSector()+ ",   Color: " + getColor()
                + ",   Longitud: " + getLongitud() + "km,   Estat de la Neu: " + getEstatNeu()
                + ",   Estat de la Pista: " + getEstatPista()+ ",   Dependències: " + dependencies.getNoms();  
        return pista;

    }   
}
