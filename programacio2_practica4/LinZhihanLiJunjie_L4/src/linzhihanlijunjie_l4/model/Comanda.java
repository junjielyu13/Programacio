/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linzhihanlijunjie_l4.model;

import java.io.Serializable;
/**
 *
 * @author Zhihan_Lin i Junjie_Li
 */
import java.util.Date;

public abstract class Comanda implements Serializable {
    private static final long serialVersionUID = 1L; 
    private Article article;
    private Client client;
    private Date date;
    private int quantitatArticle;

    /**
     * constructor
     * @param article article que volem guardar en la comanda
     * @param client  el client que compra aquest article
     * @param quantitatArticle la quantitat d'article que vol comprar
     */
    public Comanda(Article article, Client client, int quantitatArticle) {
        this.article = article;
        this.client = client;
        this.date = new Date();
        this.quantitatArticle = quantitatArticle;
    }

    /**
     * Getters i setters
     * 
     */
    public Article getArticle() {
        return article;
    }
    public void setArticle(Article article) {
        this.article = article;
    }

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public int getQuantitatArticle() {
        return quantitatArticle;
    }
    public void setQuantitatArticle(int quantitatArticle) {
        this.quantitatArticle = quantitatArticle;
    }
    
    /**
     * Calcular el preu de l'article sense incluir el preu de l'enviament
     * @return retorna el total de preu de d'un mateix tipus d'article
     */
    public float calcPreu(){
        return article.getPreu() * getQuantitatArticle();
    }
    
    /**
     * Mètode abstracte que retorna tipus de comanda
     * @return retorna el tipus de comanda
     */
    public abstract String tipusComanda();

    /**
     * Mètode abstracte que retorna si la comanda està enviada o no
     * @return retorna si la comanda està enviada o no
     */
    public abstract boolean comandaEnviada();

    /**
     * Mètode abstracte que retorna si la comanda està rebuda o no
     * @return retorna si la comanda està rebuda o no
     */
    public abstract boolean comandaRebuda();

    /**
     * Mètode abstracte que retorna el preu d'enviament segons el tipus de comanda
     * @return retorna el tipus d'enviament segons el tipus de comanda
     */
    public abstract float preuEnviament();

    /**
     * la informació de la comanda
     * @return retorna la informació de la comanda
     */
    @Override
    public String toString(){
        return "Tipus = " + tipusComanda() + ", Article = " + getArticle().getNom()
                + ", Client = " + getClient().getNom() + ", Quantitat = " + getQuantitatArticle()
                + ", Data de creacio = " + getDate() + ", Enviat = " + comandaEnviada() 
                + ", Rebuda = " + comandaRebuda() + ", Preu Articles = " + calcPreu() 
                + "€, Preu Enviament =" + preuEnviament()+ " minuts\n";
    }
    
}
