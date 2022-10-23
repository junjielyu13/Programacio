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

 /**
  *La classe Meteo conté la informació meteorològica actual
  */
public class Meteo {
    
    // Atributs que conté la Meteo
    private String  visibilitat;
    private float velocitat;
    
    public Meteo(){
    };
    
    // Constructor
    // atributs d'inicialització
    public Meteo(String visibilitat, float velocitat) {
        this.visibilitat = visibilitat;
        this.velocitat = velocitat;
    }

    // setters
    // Els mètodes setters pren un paràmetre (newName) i l’assigna a la variable name. 
    // this paraula clau s'utilitza per referir-se a l'objecte actual.
    public void setVisibilitat(String visibilitat) {
        this.visibilitat = visibilitat;
    }

    public void setVelocitat(float velocitat) {
        this.velocitat = velocitat;
    }

    //getters
    //Els mètodes getters retornen els valors dels noms de les variables.
    public float getVelocitat() {
        return velocitat;
    }

    public String getVisibilitat() {
        return visibilitat;
    }


    /** 
     *  @return La informació de la informació meteorològica actual
     */
    @Override
    public String toString() {
        String str = "\nLa velocitat és " + getVelocitat()+"km/h i la visibilitat és " + getVisibilitat()+"\n";
        return str;
    }
}
