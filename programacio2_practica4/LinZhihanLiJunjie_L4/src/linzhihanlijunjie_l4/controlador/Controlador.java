package linzhihanlijunjie_l4.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import linzhihanlijunjie_l4.model.Dades;
import linzhihanlijunjie_l4.vista.MercatException;

/**
 * Classe Controlador
 * @author Zhihan_Lin i Junjie_Li
 */
public class Controlador {
    /**
     * Constructor
     */
    Dades dades;
    public Controlador(){
        dades = new Dades();
    }

    /**
     * 1 Gestió Artíc les: Dóna pas a un menú que permet gestionar la informació relacionada amb els articles.
     */
    /**
     * 1.1 Afegir Article: Afegeix un nou article al sistema. Entre
     *     altres dades, l'aplicació ha de sol·licitar que s'introdueixi el
     *     temps en minuts fins a l'enviament de l'article així com si
     *     aquest permet enviament urgent o no.
     * @param id    identificador de l'article
     * @param nom   nom de l'article
     * @param preu  preu d'article
     * @param tempsFinsEnviament    el temps que tarda fins que l'article sigui enviada
     * @param admetUrgent  l'article admet l'enviament urgent o no
     * @throws linzhihanlijunjie_l4.vista.MercatException
     */
    public void AfegirArticle(String id, String nom, float preu, int tempsFinsEnviament, boolean admetUrgent) throws MercatException{
        this.dades.afegirArticle(id, nom, preu, tempsFinsEnviament, admetUrgent);
    }

    /**
     * 1.2 Visualitzar Articles: Mostra tots els articles afegits.
     * @return retorna un string amb les informacions de les articles
     */
    public String VisualitzarArticles(){
        String str = "";
        List<String> llistaStringArticles = recuperaArticles();
        for(String strs : llistaStringArticles){
            str += strs;
        }
        return str;
    }
    
    /**
     * Recuperar les informacions dels articles i guardar en una altra llista
     * @return retorna una llista que conté les informacions dels articles
     */
    public List<String> recuperaArticles() {
        List<String> llistaStringArticles = dades.recuperaArticles();
        return llistaStringArticles;
    }
    
    
    /**
     * 2 Gestió Clients: Mostra un menú que permet gestionar els clients.
     */
    /**
     * 2.1 A fegir Client: Incorpora un nou client a l'aplicació.
     *     L'aplicació ha de preguntar si el client a afegir és estàndard
     *     o premium.
     * @param correu    correu electronic del client
     * @param nom   nom del client
     * @param adreca    adreça del client
     * @param esPremium si el client és de tipus premium o no
     * @throws linzhihanlijunjie_l4.vista.MercatException
     */
    public void AfegirClient(String correu, String nom, String adreca, boolean esPremium) throws MercatException{
        this.dades.afegirClient(correu, nom, adreca, esPremium);
    }
    
    /**
     * 2.2 Visualitzar Clients: Visualitza tots els clients afegits.
     * @return retorna un string amb les informacions dels clients
     */
    public String VisualitzarClient(){
        String str = "";
        List<String> llistaStringClients = new ArrayList<String>(this.dades.recuperaClients());
        for(String strs : llistaStringClients){
            str += strs;
        }

        return str;
    }
    
    /**
     * Recuperar les informacions dels clients i guardar en una altra llista
     * @return retorna una llista que conté les informacions dels clients
     */
    public List<String> recuperaClients() {
        List<String> llistaStringClients = dades.recuperaClients();
        return llistaStringClients;
    }

    /**
     * 3 Gestió Comandes: Visualitza un menú per gestionar les comandes.
     */
    /**
     * 3.1 A fegir Comanda: Crea una nova comanda. L'aplicació ha de
     *     sol·licitar la informació necessària per vincular un article amb
     *     un client, establir la quantitat d'unitats de l'article que es
     *     sol·liciten i determinar si la comanda és urgent o no.
     * @param articlePos    la posició en la llista dels articles
     * @param clientPos     la posició en la llista dels clients
     * @param quantitat     quantitat d'articles
     * @param esUrgent      es urgent o no
     * @throws linzhihanlijunjie_l4.vista.MercatException
     */
    public void AfegirComanda(int articlePos, int clientPos, int quantitat, boolean esUrgent) throws MercatException{
        this.dades.afegirComanda(articlePos, clientPos, quantitat, esUrgent);
    }

    /**
     * 3.2 Esborrar Comanda: Esborra una comanda determinada, sempre que no hagi estat enviada encara.
     * @param position  la posició en la llista de comandes
     * @throws linzhihanlijunjie_l4.vista.MercatException
     */
    public void EsborrarComanda(int position) throws MercatException{
        this.dades.esborrarComanda(position);
    }
    /**
     * 3.3 Visualitzar Comandes: Visualitza totes les comandes realitzades.
     * @return retorna un string amb les informacions de les comandes
     */
    public String VisualitzaComandes(){
        String str = "";
        List<String> llistaStringComandes = new ArrayList<String>(this.dades.recuperaComandes());
        for(String strs : llistaStringComandes){
            str += strs;
        }
        return str;  
    }
    /**
     * Recuperar les informacions dels comandes i guardar en una altra llista
     * @return retorna una llista que conté les informacions dels comandes
     */
    public List<String> recuperaComandes() {
        List<String> llistaStringComandes = dades.recuperaComandes();
        return llistaStringComandes;
    }

    /**
     * 3.4 Visualitzar Comandes Urgents: Visualitza únicament les comandes urgents.
     * @return retorna les informacions de les comandes urgents
     */
    public String VisualitzarComandesUrgents(){
        String str = "";
        List<String> llistaStringComandesUrgent = new ArrayList<String>(this.dades.recuperaComandesUrgents());
        for(String strs : llistaStringComandesUrgent){
            str += strs;
        }
        return str;  
    }
    /**
     * Recuperar les informacions dels comandes urgents i guardar en una altra llista
     * @return retorna una llista que conté les informacions dels comandes urgents
     */
    public List<String> recuperaComandesUrgents() {
        List<String> llistaStringComandesUrgents = dades.recuperaComandesUrgents();
        return llistaStringComandesUrgents;
    }

    /**
     * 4 Guardar Dades: Guarda les dades de l'aplicació.
     * @param fileName nom del fitxer que volem guarda les dates
     * @throws linzhihanlijunjie_l4.vista.MercatException
     * @throws IOException
     */
    public void GuardarDades(String fileName) throws MercatException, IOException{
        this.dades.guardaDades(fileName);
    }

    /**
     * 5 Carrega Dades: Carrega les dades de l'aplicació.
     * @param fileName  nom del fitxer que volem carregar les dades
     * @throws IOException
     * @throws MercatException
     * @throws ClassNotFoundException
     */
    public void CarregaDades(String fileName) throws ClassNotFoundException, MercatException, IOException{
        dades = Dades.carregaDades(fileName);
    }

}
