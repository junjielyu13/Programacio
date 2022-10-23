package linzhihanlijunjie_l3.vista;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

import linzhihanlijunjie_l3.controlador.Controlador;

/**
 * 
 * @author Zhihan_Lin i Junjie_Li
 */
public class MercatUB implements Serializable{
    private static final long serialVersionUID = 1L;

    public void gestioMercatUB(){
        // Creación de un objeto para leer el input desde el teclado
        Scanner sc = new Scanner(System.in);
        // Llamar a la funcion que gestiona el menu
        gestioMenu(sc);
    }

    /* ******************************************** */
    /* Gestion, Opciones y Descripcion del Menu (M) */
    /* ******************************************** */
    private static enum OpcionesMenu {
        M_Opcion_1_GestioArticles,
        M_Opcion_2_GestioClients,
        M_Opcion_3_GestioComandes,
        M_Opcion_4_GuardarDades,
        M_Opcion_5_CarregaDades,
        M_Opcion_6_Sortir,
    };
    
    /* Gestion, Opciones y Descripcion del Menu secundària de opcio 1 */
    private static enum OpcionesSubMenu_1 {
        M_Opcion_1_1_AfegirArticle,
        M_Opcion_1_2_VisualitzarArticles,
        M_Opcion_1_3_Sortir,
    };


    /* Gestion, Opciones y Descripcion del Menu secundària de opcio 2 */
    private static enum OpcionesSubMenu_2 {
        M_Opcion_2_1_AfegirClient,
        M_Opcion_2_2_VisualitzarClients,
        M_Opcion_2_3_Sortir,
    };

    /* Gestion, Opciones y Descripcion del Menu secundària de opcio 3 */
    private static enum OpcionesSubMenu_3 {
        M_Opcion_3_1_AfegirComanda,
        M_Opcion_3_2_EsborrarComanda,
        M_Opcion_3_3_VisualitzarComandes,
        M_Opcion_3_4_VisualitzarComandesUrgents,
        M_Opcion_3_5_Sortir,
    };
    
    
    // Descripcion de las opciones del menu principal
    private static final String[] descMenu = {
        "Gestió Articles",         // Opcion 1
        "Gestió Clients",          // Opcion 2
        "Gestió Comandes",         // Opcion 3
        "Guardar Dades",           // Opcion 4
        "Carrega Dades",           // Opcion 5
        "Sortir",                  // Opcion 6
    };
    
    // Descripcion de las opciones del menu secundària  de opcio 1
    private static final String[] descsubMenu_1 = {
        "Afegir Article",          //Opcion 1.1
        "Visualitzar Articles",    //Opcion 1.2
        "Sortir",                  //Opcion 1.3
    };

    // Descripcion de las opciones del menu secundària  de opcio 1
    private static final String[] descsubMenu_2 = {
        "Afegir Client",          //Opcion 2.1
        "Visualitzar Clients",    //Opcion 2.2
        "Sortir",                 //Opcion 2.3
    };

    // Descripcion de las opciones del menu secundària  de opcio 1
    private static final String[] descsubMenu_3 = {
        "Afegir Comanda",              //Opcion 3.1
        "Esborrar Comanda",             //Opcion 3.2
        "Visualitzar Comandes",         //Opcion 3.3
        "Visualitzar Comandes Urgents", //Opcion 3.4
        "Sortir",                       //Opcion 3.5
    };


    /**
     * metode::
     */
    Controlador controlador = new Controlador();
    /**
     * 1 Gestió Artíc les: Dóna pas a un menú que permet gestionar la informació relacionada amb els articles.
     */
    /**
     * 1.1 Afegir Article: Afegeix un nou article al sistema. Entre
     *     altres dades, l'aplicació ha de sol·licitar que s'introdueixi el
     *     temps en minuts fins a l'enviament de l'article així com si
     *     aquest permet enviament urgent o no.
     */
    private void AfegirArticle(){

        Scanner sc = new Scanner(System.in);
        System.out.print("Indentificador de l'article: ");
        String id = sc.next();
        System.out.print("Nom de l'article: ");
        String space = sc.nextLine();
        String nom = sc.nextLine();
        System.out.print("Preu de l'article: ");
        float preu = sc.nextFloat();
        System.out.print("temps fins a de l'enviament: ");
        int temps = sc.nextInt();
        System.out.print("Enviament urgent? (Y/N): ");
        boolean EsUrgent = false;
        String yn = sc.next().toUpperCase();
        while(!yn.equals("Y") && !yn.equals("N")){
            System.out.print("La opció no és correcta. Selecciona una opció entre (Y/N): ");
            yn = sc.next().toUpperCase();
        }
        if(yn.equals("Y")){
            EsUrgent = true;
        }
        try {
            this.controlador.AfegirArticle(id, nom, preu, temps, EsUrgent);
            System.out.println("L'article s'ha afegit correctament");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 1.2 Visualitzar Articles: Mostra tots els articles afegits.
     */
    private void VisualitzarArticles(){
        System.out.println("-------Tots Articles Afegits-----------");
        System.out.println(this.controlador.VisualitzarArticles());
    }

    /**
     * 2 Gestió Clients: Mostra un menú que permet gestionar els clients.
     */
    /**
     * 2.1 A fegir Client: Incorpora un nou client a l'aplicació.
     *     L'aplicació ha de preguntar si el client a afegir és estàndard
     *     o premium.
     */
    private void AfegirClient(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Adreça de correu eletrònic: ");
        String correu = sc.next();
        System.out.print("Nom de client: ");
        String space = sc.nextLine();
        String nom = sc.nextLine();
        System.out.print("Adreça de correu postal: ");
        String adreca = sc.nextLine();
        System.out.print("Client preminum o estandard? (premium/estandard): ");
        boolean esPremium = false;
        String yn = sc.next().toUpperCase();
        while(!yn.equals("PREMIUM") && !yn.equals("ESTANDARD")){
            System.out.print("La opció no és correcta. Selecciona una opció entre (premium/estandard): ");
            yn = sc.next().toUpperCase();
        }
        if(yn.equals("PREMIUM")){
            esPremium = true;
        }
        try {
            this.controlador.AfegirClient(correu, nom, adreca, esPremium);
            System.out.println("El client s'ha afegit correctament");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * 2.2 Visualitzar Clients: Visualitza tots els clients afegits.
     */
    private void VisualitzarClient(){
        System.out.println("-------Tots Clients Afegits-----------");
        System.out.println(this.controlador.VisualitzarClient());
    }

    /**
     * 3 Gestió Comandes: Visualitza un menú per gestionar les comandes.
     */
    /**
     * 3.1 A fegir Comanda: Crea una nova comanda. L'aplicació ha de
     *     sol·licitar la informació necessària per vincular un article amb
     *     un client, establir la quantitat d'unitats de l'article que es
     *     sol·liciten i determinar si la comanda és urgent o no.
     */
    private void AfegirComanda(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Introdueix la posició de l'article que vols de la llista: ");
        int articlePos = sc.nextInt();
        System.out.print("Introdueix la posició del client que vols de la llista: ");
        int clientPos = sc.nextInt();
        System.out.print("Introdueix la quantitat d'aquest article que vols comprar: ");
        int quantitat = sc.nextInt();
        System.out.print("La comanda és urgent?(Y/N): ");
        String yn = sc.next().toUpperCase();
        boolean esUrgent = false;
        while(!yn.equals("Y") && !yn.equals("N")){
            System.out.print("La opció no és correcta. Selecciona una opció entre (Y/N): ");
            yn = sc.next().toUpperCase();
        }
        if(yn.equals("Y")){
            esUrgent = true;
        }
        try{
            this.controlador.AfegirComanda(articlePos,clientPos,quantitat,esUrgent);
            System.out.println("La comanda s'ha afegit correctament.");
        }catch(MercatException e){
            System.out.println(e.getMessage());
        }catch(IndexOutOfBoundsException e){
            System.out.println("La posició de l'article/client no és correcta.");
        }

    }

    /**
     * 3.2 Esborrar Comanda: Esborra una comanda determinada, sempre que no hagi estat enviada encara.
     */
    private void EsborrarComanda(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Introdueix la posició de la comanda que vols de la llista: ");
        int comandaPos = sc.nextInt();
        try{
            this.controlador.EsborrarComanda(comandaPos);
            System.out.println("La comanda s'ha esborrat correctament.");
        }catch(MercatException e){
            System.out.println(e.getMessage());
        }catch(IndexOutOfBoundsException e){
            System.out.println("La posició de la comanda no és correcta. ");
        }
    }

    /**
     * 3.3 Visualitzar Comandes: Visualitza totes les comandes realitzades.
     */
    private void VisualitzaComandes(){
        System.out.println("-------Totes Comandes Realitzades-----------");
        System.out.println(this.controlador.VisualitzaComandes());
    }

    /**
     * 3.4 Visualitzar Comandes Urgents: Visualitza únicament les comandes urgents.
     */
    private void VisualitzarComandesUrgents(){
        System.out.println("-------Comandes Urgents Realitzades-----------");
        System.out.println(this.controlador.VisualitzarComandesUrgents());
    }

    /**
     * 4 Guardar Dades: Guarda les dades de l'aplicació.
     */
    private void GuardarDades(){
        Scanner sc = new Scanner(System.in);
        System.out.print("nom de fitxer per guardar: ");
        String fileName = sc.nextLine();

        try {
            this.controlador.GuardarDades(fileName);
            System.out.println("S'ha guardat correctament!");
        } catch ( MercatException e) {
            System.out.println("Error guardant les dades: " + e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 5 Carrega Dades: Carrega les dades de l'aplicació.
     */
    private void CarregaDades(){
        Scanner sc = new Scanner(System.in);
        System.out.print("nom de fitxer per carregar: ");
        String fileName = sc.nextLine();

        try {
            this.controlador.CarregaDades(fileName);
            System.out.println("S'ha càrregat correctament!");
        } catch (MercatException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }



    // Funcion que gestiona el menu principal de la aplicacion
    // Tiene 3 pasos principales:
    //   1. Crear el objeto que representa (contiene) el menu
    //   2. Asignar las descripciones del menu
    //   3. Bucle donde se trata la opcion seleccionada por el usuario
    public void gestioMenu(Scanner sc) {

        // Creación del objeto que representa el menu. El primer argumento del contructor es el nombre del menu
        Menu<OpcionesMenu> menuClubUB = new Menu<>("\tMenu Mercat UB " , OpcionesMenu.values());
        Menu<OpcionesSubMenu_1> submenu_1ClubUB = new Menu<>("\t\tGestió Artícles ", OpcionesSubMenu_1.values());
        Menu<OpcionesSubMenu_2> submenu_2ClubUB = new Menu<>("\t\tGestió Clients ", OpcionesSubMenu_2.values());
        Menu<OpcionesSubMenu_3> submenu_3ClubUB = new Menu<>("\t\tGestió Comandes ", OpcionesSubMenu_3.values());

        // Assignar una descripción a cada una de las opciones
        //  - OPCIONAL - Por defecto enseña el nombre de la opción
        menuClubUB.setDescripcions(descMenu);
        submenu_1ClubUB.setDescripcions(descsubMenu_1);
        submenu_2ClubUB.setDescripcions(descsubMenu_2);
        submenu_3ClubUB.setDescripcions(descsubMenu_3);

        // Variable (de tipo enumerado igual a las opciones del menu) que contiene la opcion escogida
        OpcionesMenu opcionMenu;
        OpcionesSubMenu_1  opcionSubMenu_1; 
        OpcionesSubMenu_2  opcionSubMenu_2; 
        OpcionesSubMenu_3  opcionSubMenu_3; 

        // Lançar el bucle principal de la aplicación
        do {
            menuClubUB.mostrarMenu();
            opcionMenu = menuClubUB.getOpcio(sc);

            switch(opcionMenu) {
                case M_Opcion_1_GestioArticles:
                    submenu_1ClubUB.mostrarMenu();
                    opcionSubMenu_1 = submenu_1ClubUB.getOpcio(sc);
                    switch(opcionSubMenu_1){

                        case M_Opcion_1_1_AfegirArticle:
                            AfegirArticle();
                            break;
                        case M_Opcion_1_2_VisualitzarArticles:
                            VisualitzarArticles();
                            break;
                        case M_Opcion_1_3_Sortir:
                            break;
                        }
                    break;
                case M_Opcion_2_GestioClients:
                    submenu_2ClubUB.mostrarMenu();
                    opcionSubMenu_2 = submenu_2ClubUB.getOpcio(sc);
                    switch(opcionSubMenu_2){
                        case M_Opcion_2_1_AfegirClient:
                            AfegirClient();
                            break;
                        case M_Opcion_2_2_VisualitzarClients:
                            VisualitzarClient();
                            break;
                        case M_Opcion_2_3_Sortir:
                            break;
                        }
                    break;
                case M_Opcion_3_GestioComandes:
                    submenu_3ClubUB.mostrarMenu();
                    opcionSubMenu_3 = submenu_3ClubUB.getOpcio(sc);
                    switch(opcionSubMenu_3){
                        case M_Opcion_3_1_AfegirComanda:
                            AfegirComanda();
                            break;
                        case M_Opcion_3_2_EsborrarComanda:
                            EsborrarComanda();
                            break;
                        case M_Opcion_3_3_VisualitzarComandes:
                            VisualitzaComandes();
                            break;
                        case M_Opcion_3_4_VisualitzarComandesUrgents:
                            VisualitzarComandesUrgents();
                            break;
                        case M_Opcion_3_5_Sortir:
                        break;
                        }
                    break;
                case M_Opcion_4_GuardarDades:
                        GuardarDades();
                    break;
                case M_Opcion_5_CarregaDades:
                        CarregaDades();
                    break;
                }


        } while (opcionMenu != OpcionesMenu.M_Opcion_6_Sortir);

        System.out.println("Fi del programa, Adéu.");
        
    }
}