package linzhihanlijunjie_p2.vista;

/**
 * class ExcepcioClub
 * @author Zhihan_Lin i Junjie_Li
 */
public class ExcepcioClub extends Exception{
    private static final long serialVersionUID = 1L; 
    
    /**
     * Constructor per defecte
     */
    public ExcepcioClub() {
        super();
    }
    
    /**
     * Constructor amb paràmetre
     * @param s el missatge de l'excepció
     */
    public ExcepcioClub(String s) {
        super(s);
    }
    
}
