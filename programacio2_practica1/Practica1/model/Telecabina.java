package LinZhihanLiJunjie_L1.model;

/**
 *
 * @author ZhiHan_Lin i Junjie_Li
 * @date   22/2
 * 
 */
// Classe filla de classe pare Remuntador
public class Telecabina extends Remuntador{

    /**
     * Construdor Teleferic
     * @param nom  : Atribut heretat de la classe Remuntador
     * @param sector  : Atribut heretat de la classe Remuntador
     * @param estat  :  Atribut heretat de la classe Remuntador
     * @param limitVent  : Atribut heretat de la classe Remuntador
     * @param afectatPerVisibilitat  : Atribut heretat de la classe Remuntador
     */
    public Telecabina(String nom, String sector, String estat, int limitVent, boolean afectatPerVisibilitat) {
        super(nom, sector, estat, limitVent, afectatPerVisibilitat);
    }
    
    /**
     * @Override tipus();
     * @return retorna tipus de remuntador amb String
     */
    @Override
    public String tipus(){ 
        String tipus = "Telecabina";
        return tipus;
    }
}
