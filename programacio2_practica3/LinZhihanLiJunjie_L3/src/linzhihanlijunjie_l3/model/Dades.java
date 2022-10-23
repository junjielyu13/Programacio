package linzhihanlijunjie_l3.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import linzhihanlijunjie_l3.vista.MercatException;

/**
 *
 * @author Zhihan_Lin i Junjie_Li
 */
public class Dades implements InDades, Serializable {
    private static final long serialVersionUID = 1L;

    LlistaArticles llistaArticles;
    LlistaClients llistaClients;
    LlistaComandes llistaComandes;

    /**
     * Constructor
     */
    public Dades() {
        llistaArticles = new LlistaArticles();
        llistaClients = new LlistaClients();
        llistaComandes = new LlistaComandes();
    }

     /** Afegir Article: Afegeix un nou article al sistema.
     * @param id    identificador de l'article
     * @param nom   nom de l'article
     * @param preu  preu d'article
     * @param temps   el temps que tarda fins que l'article sigui enviada
     * @param admetUrgent  l'article admet l'enviament urgent o no
     * @throws linzhihanlijunjie_l3.vista.MercatException
     */
    @Override
    public void afegirArticle(String id, String nom, float preu, int temps, boolean admetUrgent) throws MercatException {
        Article article = new Article(id, nom, preu, temps, admetUrgent);
        llistaArticles.afegir(article);
        
    }
    /**
     * Recuperar les informacions dels articles i guardar en una altra llista
     * @return retorna una llista que conté les informacions dels articles
     */
    @Override
    public List<String> recuperaArticles() {
        List<String> llistaStringArticles = new ArrayList<String>();
        for(Article article : llistaArticles.getArrayList()){
            llistaStringArticles.add(article.toString());
        }
        return llistaStringArticles;
    }

     /** A fegir Client: Incorpora un nou client a l'aplicació.
     * @param email    correu electronic del client
     * @param nom   nom del client
     * @param adreca    adreça del client
     * @param esPremium si el client és de tipus premium o no
     * @throws linzhihanlijunjie_l3.vista.MercatException
     */
    @Override
    public void afegirClient(String email, String nom, String adreca, boolean esPremium) throws MercatException {
        if(esPremium){
            Client client = new ClientPremium(email, nom, adreca);
            llistaClients.afegir(client);
        }else{
            Client client = new ClientEstandard(email, nom, adreca);
            llistaClients.afegir(client);
        }
    }

    /**
     * Recuperar les informacions dels clients i guardar en una altra llista
     * @return retorna una llista que conté les informacions de clients
     */
    @Override
    public List<String> recuperaClients() {
        List<String> llistaStringClients = new ArrayList<String>();

        for(Client client : llistaClients.getArrayList()){
            llistaStringClients.add(client.toString());
        }

        return llistaStringClients;
    }
    
    /**
     * A fegir Comanda: Crea una nova comanda. 
     * @param articlePos    la posició en la llista dels articles
     * @param clientPos     la posició en la llista dels clients
     * @param quantitat     quantitat d'articles
     * @param esUrgent      es urgent o no
     * @throws linzhihanlijunjie_l3.vista.MercatException
     */
    @Override
    public void afegirComanda(int articlePos, int clientPos, int quantitat, boolean esUrgent) throws MercatException {
        if(esUrgent){
            Comanda comanda = new ComandaUrgent(llistaArticles.getAt(articlePos), llistaClients.getAt(clientPos), quantitat);
            llistaComandes.afegir(comanda);
        }else{
            Comanda comanda = new ComandaNormal(llistaArticles.getAt(articlePos),llistaClients.getAt(clientPos), quantitat);
            llistaComandes.afegir(comanda);
        }
        
    }

    /**
     * Esborrar Comanda: Esborra una comanda determinada, sempre que no hagi estat enviada encara.
     * @param position  la posició en la llista de comandes
     * @throws linzhihanlijunjie_l3.vista.MercatException
     */
    @Override
    public void esborrarComanda(int position) throws MercatException {
        Comanda comanda = llistaComandes.getAt(position);
        if(!comanda.comandaEnviada()){
            llistaComandes.esborrar(comanda);
        }else{
            throw new MercatException("No poden cancel·lar les comandes que hagin estat enviades.");
        }
    }

    /**
     * Recuperar les informacions de les comandes i guardar en una altra llista
     * @return retorna una llista que conté les informacions de les comandes
     */
    @Override
    public List<String> recuperaComandes() {
        List<String> llistaStringComandes = new ArrayList<String>();
        for(Comanda comanda : llistaComandes.getArrayList()){
            if (comanda instanceof ComandaNormal){
                ComandaNormal comandaNormal = (ComandaNormal)comanda;
                llistaStringComandes.add(comandaNormal.toString());
            }else{
                ComandaUrgent comandaUrgent = (ComandaUrgent)comanda;
                llistaStringComandes.add(comandaUrgent.toString());
            }
        }
        return llistaStringComandes;
    }

    /**
     * Recuperar les informacions de les comandes urgents i guardar en una altra llista
     * @return retorna una llista que conté les informacions de les comandes urgents
     */
    @Override
    public List<String> recuperaComandesUrgents() {
        List<String> llistaStringComandesUrgent = new ArrayList<String>();
        for(Comanda comanda : llistaComandes.getArrayList()){
            if (comanda instanceof ComandaUrgent){
                ComandaUrgent comandaUrgent = (ComandaUrgent)comanda;
                llistaStringComandesUrgent.add(comandaUrgent.toString());
            }
        }
        return llistaStringComandesUrgent;
    }

    /**
     * Guardar Dades: Guarda les dades de l'aplicació.
     * @param camiDesti nom del fitxer que volem guarda les dates
     * @throws linzhihanlijunjie_l3.vista.MercatException
     * @throws IOException
     */
    public void guardaDades(String camiDesti) throws MercatException, IOException{

        File file = new File(camiDesti);
        FileOutputStream fout = null;
        ObjectOutputStream oos = null;
        try {
            fout = new FileOutputStream(file);
            oos = new ObjectOutputStream(fout);
            oos.writeObject(this);
        } catch (IOException e) {
            throw new MercatException("No s'ha guardat.");
        } finally{
            fout.close();
            oos.close();
        }
    }
    
    /**
     * Carrega Dades: Carrega les dades de l'aplicació.
     * @param camiOrigen  nom del fitxer que volem carregar les dades
     * @return retorna les dades que guardava en el fitxer
     * @throws IOException
     * @throws MercatException
     * @throws ClassNotFoundException
     */
    public static Dades carregaDades(String camiOrigen) throws MercatException, IOException, ClassNotFoundException{

        File file = new File(camiOrigen);
        Dades dades = null;
        FileInputStream fin = null;
        ObjectInputStream ois = null;
        try {
            fin  = new FileInputStream(file);
            ois = new ObjectInputStream(fin);
            dades = (Dades)ois.readObject();
        } catch (FileNotFoundException e) {
            throw new MercatException ("Fitxer no trobat.");
        } finally {
            if(fin!= null && ois != null){
                fin.close();
                ois.close();
            }
        }
        return dades;
    }
    
}
