package linzhihanlijunjie_p2.model;

import linzhihanlijunjie_p2.vista.ExcepcioClub;

/**
 * class SociEstandard
 * @author Zhihan_Lin i Junjie_Li
 */
public class SociEstandard extends Soci { 
    private static final long serialVersionUID = 1L; 
    
    /**
     * @asseguranca atribut que conté la informació sobre assegrança
     */
    private Asseguranca asseguranca = new Asseguranca();
    
    /**
     * Constructor amb paràmetre
     * @param nom   nom de Soci
     * @param DNI   DNI de Soci
     * @param tipusAss tipus de l'assegurança contractada
     * @param preuAss   preu de l'assegurança contractada
     */
    public SociEstandard(String nom, String DNI, String tipusAss,float preuAss) {
        super(nom, DNI);
//        asseguranca = new Asseguranca();
        this.asseguranca.setTipu(tipusAss);
        this.asseguranca.setPreu(preuAss);
        try {
            comprova();
        } catch (ExcepcioClub e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Comprova si el tipus d'assegurança no és Bàsica ni Completa llençarà un excepció.
     * @throws ExcepcioClub llença un excepció "El tipus d'assegurança no és correcte".
     */
    private void comprova() throws ExcepcioClub{
        if(!this.asseguranca.getTipu().equals("BASICA")&&(!this.asseguranca.getTipu().equals("COMPLETA"))){
            throw new ExcepcioClub("El tipus d'assegurança no és correcte");
        }
    }
    
    //Getter
    /**
     * Obtenir assegurança
     * @return retorna l'assegurança
     */
    public Asseguranca getAsseguranca(){
        return asseguranca;
    }
    
    /**
     * Calcualar el preu de les excursions del soci
     * @param preuExcursioBase preu de les excursions del club.
     * @return float amb el preu de les excursions d'aquest soci.
     * @throws ExcepcioClub General d’excepcions produïdes per class linzhihanlijunjie_p2.vista.ExcepcioClub;
     */
    @Override
    public float calculaPreuExcursio(float preuExcursioBase) throws ExcepcioClub {
        return preuExcursioBase + asseguranca.getPreu();
    }
    
    /**
     * La informació sobre el soci estàndard
     * @return retorna un string amb tota la informació sobre el soci estàndard
     */
    @Override
    public String toString(){
        return super.toString() + asseguranca.toString();
    }
}
