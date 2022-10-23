package linzhihanlijunjie_l4.model;

import java.io.Serializable;

/**
 *
 * @author Zhihan_Lin i Junjie_Li
 */
public class ClientPremium extends Client implements Serializable {
    private static final long serialVersionUID = 1L; 
    
    /**
     * Constructor
     * @param correu correu del client
     * @param nom   nom del client
     * @param adreca adreça del client
     */
    public ClientPremium(String correu, String nom, String adreca) {
        super(correu, nom, adreca);
    }

    /**
     * Mètode que retorna el tipus de client
     * @return retorna el tipus de client premium
     */
    @Override
    public String tipusClient() {
        return "Client Premium";
    }

    /**
     * Mètode que retorna el preu mensual del client premium
     * @return retorna el preu mensual segons del client premium
     */
    @Override
    public float calcMensual() {
        return 4f;
    }

    /**
     * Mètode que retorna el tant per cent de descompte de l'enviament
     * @return retorna un 20% de descompte, perquè és un client premium
     */
    @Override
    public float descompteEnv() {
        return 20f;
    }
    
}
