package linzhihanlijunjie_p2.model;

import linzhihanlijunjie_p2.vista.ExcepcioClub;

/**
 * class SociFederat
 * @author Zhihan_Lin i Junjie_Li
 */
public class SociFederat extends Soci { 
    private static final long serialVersionUID = 1L; 
    
    /**
     * @federacio atribut que conté la informació de la federació
     * @descompteQuota el % de descompte que s'aplica en la quota mensual
     * @descompteExcursio   el % de descompte que s'aplica en el preu de cada excursió
     */
    private Federacio federacio = new Federacio();
    private float descompteQuota,descompteExcursio;
    /**
     * 
     * @param nom   nom de Soci
     * @param DNI   DNI de Soci
     * @param nomFederació  nom de la federació
     * @param preuFederació preu de la federació
     * @param descompteQuota    el % de descompte de la quota mensual
     * @param descompteExc  el % de descompte de cada excursió
     */
    public SociFederat(String nom, String DNI,String nomFederació,float preuFederació,float descompteQuota,float descompteExc){
        super(nom, DNI);
        this.federacio.setNom(nomFederació);
        this.federacio.setPreu(preuFederació); 
        this.descompteQuota = descompteQuota;
        this.descompteExcursio = descompteExc;
        try {
            comprova();
        } catch (ExcepcioClub e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * comprova()   comprova si el preu de la federació és menor que 100 euros es llençarà un excepció.
     * @throws ExcepcioClub llença un excepció "El preu de la federació no és correcte".
     */
    private void comprova() throws ExcepcioClub{
        if(this.federacio.getPreu() < 100f){
            throw new ExcepcioClub("El preu de la federació no és correcte");
        }
    }
    
    //Getter
    /**
     * Obtenir la federacio
     * @return federacio
     */
    public Federacio getFederacio() {
        return federacio;
    }

     
    /**
     * Calcular la quota mensual del soci
     * @param quotaBase quota mensual base del club.
     * @return float amb la quota mensual d'aquest soci.
     * @throws ExcepcioClub 
     */
    @Override
    public float calculaQuota(float quotaBase) throws ExcepcioClub{
        return super.calculaQuota(quotaBase) *(1 - descompteQuota);
    }
    
    /**
     * Calcualar el preu de les excursions del soci
     * @param preuExcursioBase preu de les excursions del club.
     * @return float amb el preu de les excursions d'aquest soci.
     * @throws ExcepcioClub 
     */
    @Override
    public float calculaPreuExcursio(float preuExcursioBase) throws ExcepcioClub{
        return preuExcursioBase *(1 - descompteExcursio);
    }
    
    /**
     * La informació sobre el soci federat
     * @return retorna un string amb tota la informació sobre el soci federat
     */
    @Override
    public String toString(){
        return super.toString() + federacio.toString();
    }
 
}
