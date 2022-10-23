package linzhihanlijunjie_p2.model;

import linzhihanlijunjie_p2.vista.ExcepcioClub;
import java.io.Serializable;

/**
 * class Soci
 * @author Zhihan_Lin i Junjie_Li
 */
public abstract class Soci implements InSoci, Serializable{ 
    private static final long serialVersionUID = 1L;
    
    /**
     * @nom nom del soci
     * @DNI dni del soci
     */
    private String nom;
    private String DNI;
    
    /**
     * constructor
     */
    public Soci() {
    }

    /**
     * constructor amb parametre
     * @param nom  el nom del soci
     * @param DNI  el DNI del soci
     */
    public Soci(String nom, String DNI) {
        this.nom = nom;
        this.DNI = DNI;
    }
    
    //Getters
    /**
     * Obtenir DNI del soci
     * @return retorna DNI del Soci
     */
    @Override
    public String getDNI(){
        return DNI;
    }
    /**
     * Obtenir el nom del soci
     * @return retorna nom del Soci
     */
    @Override
    public String getNom(){
        return nom;
    }
    
    
    //Setters
    /**
     * assginar DNI
     * @param dni El dni del Soci que volem guardar en l'atribut
     */
    @Override
    public void setDNI(String dni){
        this.DNI = dni;
    }
    /**
     * Assinar DNI
     * @param nom El nom de Soci que volem guardar en l'atribut
     */
    @Override
    public void setNom(String nom){
        this.nom = nom;
    }
    
    /**
     * Calcular la quota mensual del soci
     * @param quotaBase quota mensual base del club.
     * @return float amb la quota mensual d'aquest soci.
     * @throws ExcepcioClub General d’excepcions produïdes per class linzhihanlijunjie_p2.vista.ExcepcioClub.
     */
    @Override
    public float calculaQuota(float quotaBase) throws ExcepcioClub{ 
        return quotaBase;
    }
    
    /**
     * Calcualar el preu de les excursions del soci
     * @param preuExcursioBase preu de les excursions del club.
     * @return float amb el preu de les excursions d'aquest soci.
     * @throws ExcepcioClub General d’excepcions produïdes per class linzhihanlijunjie_p2.vista.ExcepcioClub.
     */
    @Override
    public abstract float calculaPreuExcursio(float preuExcursioBase) throws ExcepcioClub;
    
    /**
     * La informació del soci
     * @return retorna un string amg la informació del soci
     */
    @Override
    public String toString(){
        return "Nom: " + getNom() + ", DNI: " + getDNI() + ". ";
    }
}
