
package linzhihanlijunjie_l4.model;
import linzhihanlijunjie_l4.vista.MercatException;

import java.io.Serializable;

/**
 *
 * @author Zhihan_Lin i Junjie_Li
 */
public class LlistaArticles extends Llista<Article> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * Constructor
     */
    public LlistaArticles() {
        super();
    }
    
    /**
     * Mètode auxiliar de afegir()
     * @param t l'article que volem determinar si existeix en la llista
     * @return retorna true si la llista conté l'article que té el mateix identificador
     */
    private boolean contains(Article t){

        boolean existeix = false;
        for(Article a: llista){
            if(a.getId().equals(t.getId())){
                existeix = true;
            }
        }
        return existeix;
    }

     /**
     * Afegir en la llista l'objecte t del tipus Article
     * @param t article que volem afegir
     * @throws MercatException 
     */
    @Override
    public void afegir(Article t) throws MercatException {
        if(contains(t)){
            throw new MercatException("No es podran afegir dos articles amb el mateix identificador."); 
        }else{
            super.afegir(t);
        }
    }

}
