/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linzhihanlijunjie_l3.model;
import linzhihanlijunjie_l3.vista.MercatException;

import java.io.Serializable;


/**
 * @author Zhihan_Lin i Junjie_Li
 */
public class LlistaComandes extends Llista<Comanda> implements Serializable {
    private static final long serialVersionUID = 1L;
    
    /**
     * constructor
     */
    public LlistaComandes() {
        super();
    }

      /**
     * Afegir en la llista l'objecte t del tipus Comanda
     * @param t comanda que volem afegir
     * @throws MercatException 
     */
    @Override
    public void afegir(Comanda t) throws MercatException {
        
        if((t instanceof ComandaUrgent) && (!t.getArticle().getAdmetUrgent())){
            throw new MercatException(" l'article que ha d'enviar-se no admet enviament urgent."); 
        }else{
            super.afegir(t);
        }
    }
    
}
