package linzhihanlijunjie_l3.model;
import linzhihanlijunjie_l3.vista.MercatException;

import java.io.Serializable;
import java.util.ArrayList;

public class Llista<T> implements Serializable {
    private static final long serialVersionUID = 1L; 

    protected ArrayList<T> llista;

    /**
     * constructor
     */
    public Llista() {        
        llista = new ArrayList<>();
    }

    /**
     * El nombre d'elements que hi ha en la llista
     * @return retorna el nombre d'elements de la llista
     */
    public int getSize(){
        return llista.size();
    }

    /**
     * Afegir en la llista l'objecte t del tipus T
     * @param t pot ser article, client o comanda segons la classe que s'hereta
     * @throws MercatException 
     */
    public void afegir(T t)throws MercatException {
        llista.add(t);
    }

    /**
     * Esborrar de la llista l'objecte t del tipus T
     * @param t pot ser article, client o comanda segons la classe que s'hereta
     * @throws MercatException 
     */
    public void esborrar(T t)throws MercatException{
        if(this.isEmpty()){
            throw new MercatException("La llista ésta buida, no pot esborrar");
        }else{
            llista.remove(t);
        }
    }
    
/**
 * Obtenir l'element de la llista
 * @param position posició de l'element en la llista
 * @return  retorna l'element que està en la posició indicada de la llista
 * @throws MercatException 
 */    
    public T getAt(int position)throws MercatException {

        if (position<0 && position >this.getSize()){
            int size = this.getSize();
            throw new MercatException("La posició seleccionada no és correcta. Selecciona una posició entre 1 i " + size );
        } else {
            return llista.get(position-1);
        }
    }

    /**
     * Eliminar tots els elements de la llista
     */
    public void clear(){
        llista.clear();
    }
    
    /**
     * Determina si la llista està buida o no
     * @return retorna true si la llista està buida i false en cas contrari
     */
    public boolean isEmpty(){
        return llista.isEmpty();
    }

    /**
     * Obtenir la llista
     * @return retorna la llista
     */
    public ArrayList<T> getArrayList() {
        ArrayList<T> arrlist = new ArrayList<>(llista);
        return arrlist;
    }
}