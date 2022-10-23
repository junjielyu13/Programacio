package LinZhihanLiJunjie_L1.model;

import java.util.ArrayList;

/**
 *
 * @author ZhiHan_Lin i Junjie_Li
 * @date   22/2
 *       
 */

 /**  
 *  clasee LlistaPistes
 *  objectiu:
 *  guardar i gestionar un conjunt de pistes.
 */
public class LlistaPistes {

    
    //pista : atribut privat de classe Remuntador;    
    private ArrayList<Pista> pista = new ArrayList<Pista>();

    public LlistaPistes(){
    }
    
    /**
     * actualitza estat de la llista de remuntador segon la pista
     */
    public void actualitzaEstat(){
        for(int i = 0; i < pista.size(); i++){
            pista.get(i).actualitzaEstat();  
        }
    }

    /** 
     * @param p object Pista
     *  permet afegir un nou pista a la pista.  
     */ 
    public void afegirPista (Pista p){
        pista.add(p);
    }

    /**
     * @param nom ens permet trobar una pista pel seu nom
     * @return un object de pista que volem buscar pel aquest nom
     */
    public Pista getPista (String nom){

        Pista p = null;
        for(int i=0; i<pista.size();i++){
            if(pista.get(i).getNom().equals(nom)){
                p = pista.get(i);
            }
        }
        return p;
    }

    /**
     * @param estat ens permet trobar una llistar pistar pel seu estat
     * @return retorna un String amb les pistes en l’estat estat
     */
    public String llistarPistes(String estat){

        String detall = "\n";
        for(int i = 0; i<pista.size(); i++){
            if(estat.equals("Tots")){
                detall += pista.get(i).toString() + " \n";
            }else{
                if(pista.get(i).getEstatPista().equals(estat)){
                    detall += pista.get(i).toString()+ " \n";
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
     * @param estat ens permet trobar una Kms Pistes pel seu estat
     * @return el total de kms de pistes en l'estat estat
     */
    public float calculaKmsPistes(String estat){
        
        float kms = 0;
        for(int i = 0; i<pista.size(); i++){
            if(estat.equals("Tots")){
                kms += pista.get(i).getLongitud();
            }else{
                if(pista.get(i).getEstatPista().equals(estat)){
                    kms += pista.get(i).getLongitud();
                }
            }
        }
        return kms;
    }

}
