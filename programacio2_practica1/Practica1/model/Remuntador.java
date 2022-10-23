package LinZhihanLiJunjie_L1.model;

/**
 *
 * @author ZhiHan_Lin i Junjie_Li
 * @date 22/2
 * 
 */

// Class abtract Remuntador
public abstract class Remuntador {     

    // Atributs que conté el remuntadors
    private String nom, sector, estat;
    private float limitVent;
    private boolean afectatPerVisibilitat;

    public Remuntador(){
    }
    
    // Constructor
    // atributs d'inicialització
    public Remuntador(String nom, String sector, String estat, float limitVent, boolean afectatPerVisibilitat){
        this.nom = nom;
        this.sector = sector;
        this.estat = estat;
        this.limitVent = limitVent;
        this.afectatPerVisibilitat = afectatPerVisibilitat;
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

    public void setEstat(String estat) {
        this.estat = estat;
    }

    public void setLimitVent(float limitVent) {
        this.limitVent = limitVent;
    }

    public void setAfectatPerVisibilitat(boolean afectatPerVisibilitat) {
        this.afectatPerVisibilitat = afectatPerVisibilitat;
    }
    
    //getters
    //Els mètodes getters retornen els valors dels noms de les variables.
    public String getNom() {
        return nom;
    }

    public String getSector() {
        return sector;
    }

    public String getEstat(){
        return estat;
    }

    public float getLimitVent() {
        return limitVent;
    }

    public boolean getAfectatPerVisibilitat() {
        return afectatPerVisibilitat;
    }
    

    /**
    *    mètode tipus() abstracte que implementarà 
    *    en cadascú de les 5 classes filles anomenades 
    *    Telecabina, Telecadira, Teleesqui, Teleferic i CintaTransportadora.
    */
    public abstract String tipus();     
    

    /** 
     *  @param meteo object Meteo
     * 
     *  @param velocitat:  Els remuntadors de la part alta del sector Nord, és a
     *   dir, l’RM1, RM2 i RM3, queden fora de servei quan hi ha vents de més de 35 Km/h. 
     *   tot els remuntadors queden fora de servei es cas que el vent sigui de més de 60 Km/h.
     * 
     *  @param visibilitat: si la visibilitat a l’estació és Dolenta en lloc de Bona, el sector Sud es veu
     *   afectat, i el remuntador RM9 es queda fora de servei.
     */
    public void actualitzaEstat(Meteo meteo){   


        float velocitat = meteo.getVelocitat();
        String visibilitat = meteo.getVisibilitat();
        
        if(velocitat >= limitVent){  
            setEstat("Fora de Servei");
        }else if(velocitat < limitVent){
            setEstat("En Servei");
        }
        
        if(visibilitat.equals("Dolenta")&&(getSector().equals("Sud"))){
            setEstat("Fora de Servei");
        }else if(visibilitat.equals("Bona")&&(getSector().equals("Sud"))){
            if(velocitat >= limitVent){ 
                setEstat("Fora de Servei");
            }else if(velocitat < limitVent){
                setEstat("En Servei");
            }
        }
        
    }
    
    /**
     *  @return un String que conté el nom, el nom, el tipus, el sector i l'estat del remuntador.
     */
    public String toString() {
        String remuntador;
        remuntador = "Remuntador: " + getNom() + ", Tipus: " + tipus() + ", Sector: " + getSector() + ", Estat: " + getEstat();
        return remuntador;
    }  
}  
