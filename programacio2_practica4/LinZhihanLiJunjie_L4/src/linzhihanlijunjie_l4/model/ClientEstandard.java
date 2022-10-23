package linzhihanlijunjie_l4.model;

import java.io.Serializable;

/**
 *
 * @author Zhihan_Lin i Junjie_Li
 */
public class ClientEstandard extends Client implements Serializable {
    private static final long serialVersionUID = 1L; 

    /**
     * Constructor
     * @param correu correu del client
     * @param nom   nom del client
     * @param adreca adreça del client
     */
    public ClientEstandard(String correu, String nom, String adreca) {
        super(correu, nom, adreca);
    }
    
    /**
     * Mètode que retorna el tipus de client
     * @return retorna el tipus de client estandard
     */
    @Override
    public String tipusClient() {
        return "Client Estandard";
    }
    
    /**
     * Mètode que retorna el preu mensual del client estandard
     * @return retorna el preu mensual segons del client estandard
     */
    @Override
    public float calcMensual() {
       return 0f;
    }
    
    /**
     * Mètode que retorna el tant per cent de descompte de l'enviament
     * @return retorna un 0% de descompte, perquè és un client estandard
     */
    @Override
    public float descompteEnv() {
       return 0f;
    }
    
}
