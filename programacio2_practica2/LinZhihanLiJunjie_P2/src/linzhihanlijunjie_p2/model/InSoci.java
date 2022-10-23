/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linzhihanlijunjie_p2.model;

import linzhihanlijunjie_p2.vista.ExcepcioClub;

/**
 * Interfície InSoci
 * @author Zhihan_Lin i Junjie_Li
 */
public interface InSoci {
    
    public void setNom(String nom);
    public String getNom();
    public void setDNI(String dni);
    public String getDNI();
    
    /**
     * Calcular la quota mensual del soci
     * @param quotaBase quota mensual base del club.
     * @return float amb la quota mensual d'aquest soci.
     * @throws ExcepcioClub llança una excepció
     */
    public float calculaQuota(float quotaBase) throws ExcepcioClub;

    /**
     * Calcualar el preu de les excursions del soci
     * @param preuExcursioBase preu de les excursions del club.
     * @return float amb el preu de les excursions d'aquest soci.
     * @throws ExcepcioClub llança una excepció
     */
    public abstract float calculaPreuExcursio(float preuExcursioBase) throws ExcepcioClub;
}
