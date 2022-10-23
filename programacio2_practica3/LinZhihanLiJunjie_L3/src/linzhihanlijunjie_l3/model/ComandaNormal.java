/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linzhihanlijunjie_l3.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Zhihan_Lin i Junjie_Li
 */
public class ComandaNormal extends Comanda implements Serializable {
    private static final long serialVersionUID = 1L; 

    public static float PREU_ENV = 1;
    public static float TEMPS_FINS_RECEPCIO = 2;

    /**
     * Constructor
     * @param article   article que volem guarda en la comanda
     * @param client    client que vol compra aquest article
     * @param quantitatArticle quantitat d'article
     */
    public ComandaNormal(Article article, Client client, int quantitatArticle) {
        super(article, client, quantitatArticle);
    }

    /**
     * tipus de comanda
     * @return retorna el tipus de comanda normal
     */
    @Override
    public String tipusComanda() {
        return "Comanda Normal";
    }
    
    /**
     *la comanda està enviada o no
     * @return retorna si la comanda està enviada o no
     */
    @Override
    public boolean comandaEnviada() {
        long time;
        time = this.getDate().getTime() + (long)getArticle().getTempsFinsEnviament() * 60000;
        Date date = new Date();
        return date.getTime() >= time;
    }
    
    /**
     * la comanda està rebuda o no
     * @return retorna si la comanda està rebuda o no
     */
    @Override
    public boolean comandaRebuda() {
        long time;
        time = this.getDate().getTime() + (long)TEMPS_FINS_RECEPCIO * 24 * 60 * 60000;
        Date date = new Date();
        return date.getTime() >= time;
    }
    
    /**
     * el preu d'enviament de la comanda Normal
     * @return retorna el tipus d'enviament de la comanda normal
     */
    @Override
    public float preuEnviament() {
        return ComandaNormal.PREU_ENV;
    }
    
}
