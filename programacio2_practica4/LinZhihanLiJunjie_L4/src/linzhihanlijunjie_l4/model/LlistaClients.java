package linzhihanlijunjie_l4.model;

import java.io.Serializable;

import linzhihanlijunjie_l4.vista.MercatException;

/**
 *
 * @author Zhihan_Lin i Junjie_Li
 */
public class LlistaClients extends Llista<Client> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * constructor
     */
    public LlistaClients() {
        super();
    }
    
    /**
     * Mètode auxiliar d'afegir()
     * @param t el client que volem determinar si existeix en la llista
     * @return retorna true si la llista conté el client que té el mateix correu electrònic
     */
    private boolean contains(Client c){
        boolean existeix = false;
        for(Client a: llista){
            if(a.getCorreu().equals(c.getCorreu())){
                existeix = true;
            }
        }
        return existeix;
    }

     /**
     * Afegir en la llista l'objecte t del tipus Client
     * @param c client que volem afegir
     * @throws MercatException 
     */
    @Override
    public void afegir(Client c) throws MercatException {
        if(contains(c)){
            throw new MercatException("no es podran afegir dos articles amb el mateix electrònic."); 
        }else{
            super.afegir(c);
        }
    }

    
}
