package linzhihanlijunjie_p2.model;

import linzhihanlijunjie_p2.vista.ExcepcioClub;

/**
 * class SociJunior
 * @author Zhihan_Lin i Junjie_Li
 */

public class SociJunior extends Soci { 
    private static final long serialVersionUID = 1L; 
    
    /**
     * Constructor amb paràmetre
     * @param nom   nom del Soci
     * @param DNI   DNI del soci
     */
    public SociJunior(String nom, String DNI) {
        super(nom, DNI);
    }
    
    /**
     * Calcualar el preu de les excursions del soci
     * @param preuExcursioBase preu de les excursions del club.
     * @return float amb el preu de les excursions d'aquest soci.
     * @throws ExcepcioClub  General d’excepcions produïdes per class linzhihanlijunjie_p2.vista.ExcepcioClub.
     */
    @Override
    public float calculaPreuExcursio(float preuExcursioBase) throws ExcepcioClub{
        return 0;
    }
    
    /**
     * La informació sobre el soci federat
     * @return retorna un string amb tota la informació sobre el soci junior
     */
    @Override
    public String toString(){
        return super.toString();
    }
}
