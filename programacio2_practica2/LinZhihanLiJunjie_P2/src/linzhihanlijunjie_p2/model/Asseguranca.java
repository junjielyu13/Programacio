package linzhihanlijunjie_p2.model;

import java.io.Serializable;

/**
 * class Asseguranca
 * @author Zhihan_Lin_i_Junjie_Li
 */
public class Asseguranca implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * Atribut de class Federacio
     * @tipu  tipu de Asseguranca
     * @preu  preu de Asseguranca
     */
    private String tipu = "";
    private float preu = 0;
    /**
     * construtor
     */
    public Asseguranca(){
        this.tipu ="";
        this.preu =0;
    }

    //getters
    public String getTipu(){
        return tipu;
    }

    public float getPreu(){
        return preu;
    }

    //setters
    public void setTipu(String tipu){
        this.tipu=tipu;
    }

    public void setPreu(float preu){
        this.preu = preu;
    }

    /**
     * La informació de la assegurança
     * @return retorna un string amb la informació de la assegurança dels socis.
     */
    @Override
    public String toString() {
        return "Tipus Assegurança: " + getTipu() + ", Preu: " + getPreu()+ " €.";

    }
}
