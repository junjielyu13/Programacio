package linzhihanlijunjie_l4.model;

import java.io.Serializable;

/**
 *
 * @author Zhihan_Lin i Junjie_Li
 */
public abstract class Client implements Serializable {
    private static final long serialVersionUID = 1L; 
    private String correu,nom,adreca;

    /**
     * Constructor
     * @param correu    correu electronic del client
     * @param nom       nom del client
     * @param adreca    adreça del client
     */
    public Client(String correu, String nom, String adreca) {
        this.correu = correu;
        this.nom = nom;
        this.adreca = adreca;
    }
     
    /**
     * 
     * Getters i setters
     */
    public String getCorreu() {
        return correu;
    }

    public void setCorreu(String correu) {
        this.correu = correu;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdreca() {
        return adreca;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }
    
    /**
     * Mètode abstracte que implementarà en la classe filla
     * @return retorna el tipus de client
     */
    public abstract String tipusClient();
    
    /**
     * Mètode abstracte que implementarà en la classe filla
     * @return retorna el preu mensual segons el tipus de client
     */
    public abstract float calcMensual();
    
    /**
     * Mètode abstracte que implementarà en la classe filla
     * @return retorna el tant per cent de descompte en l'enviament
     */
    public abstract float descompteEnv();
    
    /**
     * Mètode que retorna la informació del client
     * @return retorna un string amb la informació d'un client
     */
    @Override
    public String toString(){
        return "Tipus = " + tipusClient() + ", Email = " + getCorreu()
                + ", Nom = " + getNom() + ", Adreça = " + getAdreca()
                + ", Descompte Enviament = " + descompteEnv() + "%, Mensualitat = " + calcMensual() + "€\n";
    }
}
