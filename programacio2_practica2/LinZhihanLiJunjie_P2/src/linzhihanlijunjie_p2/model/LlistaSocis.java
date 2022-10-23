package linzhihanlijunjie_p2.model;

import linzhihanlijunjie_p2.vista.ExcepcioClub;

import java.util.ArrayList;
import java.io.Serializable;

/**
 * class LlistaSocis
 * @author Zhihan_Lin i Junjie_Li
 */

public class LlistaSocis implements InSociList, Serializable{
    private static final long serialVersionUID = 1L; 

    /** 
     * @midaMaxima indica la midaMàxima del ArrayList
     * @size indica el nombre d'elements que hi ha a la llista.
     * @llistaSoci Una llista de tipus ArrayList per guardar tots els socis.
     */
    private int midaMaxima;
    private int size;
    private ArrayList <Soci> llistaSoci = new ArrayList<Soci>(midaMaxima);
    
    
    /**
     * Constructor
     */
    public LlistaSocis(){
        this.midaMaxima = 100;
        this.size = 0;
    }

    /**
     * Constructor que passa una mida màxima per paràmetre
     * @param midaMaxima canviar la midaMaxima de la llista.
     */
    public LlistaSocis(int midaMaxima){
        this.midaMaxima = midaMaxima;
        this.size = 0;
    }
    
    
    /**
     * Donar el número d'elemnts que hi ha actualment emmagatzemants a la llista.
     * @return int amb el número d'elements de la llista.
     */
    @Override
    public int getSize() {
        return this.size;
    }
    
    
    /**
     * Afegir un nou soci
     * @param soci objecte soci per afegir a la llista.
     * @throws linzhihanlijunjie_p2.vista.ExcepcioClub
     */
    @Override
    public void addSoci(Soci soci) throws ExcepcioClub{
        if(this.isFull()){
            throw new ExcepcioClub("La llista està plena ");
        }

        boolean existeix = false;
        for(int i=0; i<getSize(); i++){
            if(llistaSoci.get(i).getDNI().equals(soci.getDNI())){
                existeix = true;
            }
        }

        if(existeix){
            throw new ExcepcioClub("aquest soci ja existeix");
        }else{
            llistaSoci.add(soci);
            this.size++;  
        }

    }
    
    
    /**
     * Eliminar un objecte de la llista
     * @param soci objecte per eliminar.
     * @throws linzhihanlijunjie_p2.vista.ExcepcioClub
     */
    @Override
    public void removeSoci(Soci soci) throws ExcepcioClub{

        if(this.isEmpty()){
            throw new ExcepcioClub("Excepció: La llista està buida ");
        }else{
            llistaSoci.remove(soci);
            this.size--;
        }
    }
    

    /**
     * Obtenir el soci guardat a una certa posició donada.
     * @param position posició a la llista de socis.
     * @return objecte soci a la posició donada o null si no existeix.
     * @throws ExcepcioClub General d’excepcions produïdes per class linzhihanlijunjie_p2.vista.ExcepcioClub.
     */
    @Override
    public Soci getAt(int position) throws ExcepcioClub{

        if(position <= 0 || position > this.getSize()){
            throw new ExcepcioClub("Excepció: fora de rang!");
        }else{
            return llistaSoci.get(position-1);
        }
    }

    
    /**
     * Obtenir el soci donat el seu DNI 
     * @param dni DNI del soci al que volem accedir.
     * @return Objecte soci amb el dni donat o null si no existeix.
     * @throws ExcepcioClub General d’excepcions produïdes per class linzhihanlijunjie_p2.vista.ExcepcioClub.
     */
    @Override
    public Soci getSoci(String dni) throws ExcepcioClub{

        for(int i = 0; i < size; i++){
            if(llistaSoci.get(i).getDNI().equals(dni)){
                return llistaSoci.get(i);
            }
        }
        throw new ExcepcioClub("no existeix aquest soci.");
    }
    

    /**
     * Eliminar tots els elements de la llista
     */
    @Override
    public void clear(){
        llistaSoci.clear();
    }
    

    /**
     * Comprovar si la llista està a la seva capacitat màxima o no.
     * @return True si la llista està plena (no hi ha lloc per més elements) o false sinó.
     */
    @Override
    public boolean isFull(){
        return getSize() == this.midaMaxima;
    }
    

    /**
     * Comprovar si la llista està buida o no.
     * @return True si la llista està buida (no hi ha cap elements) o false sinó.
     */
    @Override
    public boolean isEmpty(){
        return getSize() < 1;
    }
    
    
    /**
     * La informació dels socis
     * @return retorna un string amb la informació de tots els socis de la llista.
     */
    @Override
    public String toString(){
        String llista= "\nLlista de Socis: \n"+ "==============\n";

        if(this.isEmpty()){
            llista += "\nLa llista està buida \n";
        }

        for(int i = 0; i < llistaSoci.size(); i++){
            llista += "["+ (i+1) + "] " + llistaSoci.get(i).toString()+ " \n";
        }
        return llista;
    }
}
