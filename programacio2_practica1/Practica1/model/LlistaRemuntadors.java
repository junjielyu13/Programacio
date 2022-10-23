/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LinZhihanLiJunjie_L1.model;
import java.util.ArrayList;

/**
*
* @author ZhiHan_Lin i Junjie_Li
* @date 22/2
* 
*/

/**  
 *  clasee ListaRemuntadors
 *  objectiu:
 *  guardar i gestionar un conjunt de remuntadors.
 */
public class LlistaRemuntadors {
 

    // remuntaddor : atribut privat de classe Remuntador;    
    private ArrayList<Remuntador> remuntador = new ArrayList<Remuntador>();

    /**
     * @param meteo objecte de la classe Meteo
     * actualitza estat de la llista de remuntador segon la condicio meteologiques del meteo
     */
    public void actualitzaEstat(Meteo meteo){
        for(int i = 0; i < remuntador.size(); i++){
            remuntador.get(i).actualitzaEstat(meteo);
        }
    }

    /** 
     * @param rm objecte Remuntador
     *  permet afegir un nou remuntador a la llista.  
     */ 
    public void afegirRemuntador (Remuntador rm){
        remuntador.add(rm);
    }

    /**
     * ens indica si tots els remuntadors de la llista estan Fora de Servei o no.
     * @return true :Estan tots Fora de Servei.
     * @return false  :NO estan tots Fora de Servei. 
     */
    public boolean totsForaDeServei(){
        
        for(int i = 0; i<remuntador.size(); i++){
            if(remuntador.get(i).getEstat().equals("En Servei")){
                return false;
            }
        }
        return true;
    }


    /**
     * ens haurà de retornar un String amb els detalls de tots els remuntadors que
     * estiguin en l’estat estat
     * 
     * @param estat   L’estat estat podrà ser “En Servei”, “Fora de Servei” o “Tots”
     * @return String amb descprició de ESTAT
     * 
     */
    public String llistarRemuntadors(String estat){
        
        String detall = "\n";
        for(int i = 0; i<remuntador.size(); i++){
            if(estat.equals("Tots")){
                detall += remuntador.get(i).toString() + " \n";
            }else{
                if(remuntador.get(i).getEstat().equals(estat)){
                    detall += remuntador.get(i).toString() + " \n" ;
                }
            }
        }

        if(detall.length()>2){
            return detall;
        }

        String str = "\nAquesta Llista no tenen cap remuntadors.";
        return str;
        
    }


    /**
     * @return String amb els noms de tots els remuntadors de la llista 
     */
    public String getNoms(){
        String noms = "";
        for(int i = 0; i<remuntador.size(); i++){
            noms += remuntador.get(i).getNom() + " ";
        }
        return noms;
    }


}
