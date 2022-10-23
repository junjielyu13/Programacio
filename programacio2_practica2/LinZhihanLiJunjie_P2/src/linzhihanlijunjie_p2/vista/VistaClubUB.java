package linzhihanlijunjie_p2.vista;

import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;
import linzhihanlijunjie_p2.model.ClubUB;

/**
 *class VistaClubUB
 * @author Zhihan_Lin i Junjie_Li
 */
public class VistaClubUB implements Serializable { 
    private static final long serialVersionUID = 1L;
    
    public void gestioClubUB(){
        // Creación de un objeto para leer el input desde el teclado
        Scanner sc = new Scanner(System.in);
        // Llamar a la funcion que gestiona el menu
        gestioMenu(sc);
    }
    
    /* ******************************************** */
    /* Gestion, Opciones y Descripcion del Menu (M) */
    /* ******************************************** */
    private static enum OpcionesMenu {
        M_Opcion_1_NouSoci,
        M_Opcion_2_ListarSocis,
        M_Opcion_3_EliminarSocis,
        M_Opcion_4_MostrarFactura,
        M_Opcion_5_ModificarNomSoci,
        M_Opcion_6_ModificarTipusAssegurancaSoci,
        M_Opcion_7_GuardarLlista,
        M_Opcion_8_RecuperarLlista,
        M_Opcion_9_Sortir
    };
    
    /* Gestion, Opciones y Descripcion del Menu secundària de opcio 1 */
    private static enum OpcionesSubMenu {
        M_Opcion_1_1_AfegirSociFederat,
        M_Opcion_1_2_AfegirSociEstàndard,
        M_Opcion_1_3_AfegirSociJunior,
        M_Opcion_1_4_MenuAnterior,
    };
    
    
    // Descripcion de las opciones del menu principal
    private static final String[] descMenu = {
        "Donar d’alta un nou soci",         // Opcion 1
        "Mostrar llista de socis",          // Opcion 2
        "Eliminar soci",                    // Opcion 3
        "Mostrar factura",                  // Opcion 4
        "Modificar nom soci",               // Opcion 5
        "Modificar tipus assegurança soci", // Opcion 6
        "Guardar llista",                   // Opcion 7
        "Recuperar llista",                 // Opcion 8
        "Sortir",                           // Opcion 9
    };
    
    private static final String[] descsubMenu = {
        "Afegir Soci Federat",      //Opcion 1.1
        "Afegir Soci Estàndard",    //Opcion 1.2
        "Afegir Soci Junior",       //Opcion 1.3
        "Menu Anterior",            //Opcion 1.4
    };

    /**
     *  Atribut de llistaSocis iclubUB
     */
    ClubUB clubUb = new ClubUB();

    /**
     * MENU
     */

    
    /*
     *  1. Donar d’alta un nou soci: Mostra un menú per tal d’afegir un soci a la llista
     *    de socis.
     */
    /**
     * 1.1 Afegir soci federat: Demana les dades necessàries per un nou
     *     soci federat.
     */
    private void AfegirSociFederat(){

        Scanner sc = new Scanner(System.in);
        System.out.print("Nom de soci Federat: ");
        String nom = sc.nextLine();

        System.out.print("DNI de soci Federat: ");
        String DNI = sc.nextLine();
        
        System.out.print("Nom de la federació: ");
        String nomFederacio = sc.next().toUpperCase();
        
        System.out.print("Preu de la federació: ");
        float preu = sc.nextFloat();
        while(preu<0){
            System.out.println("Preu de la federacio no pot mes petit que 0, tornar posar-lo");
            preu = sc.nextFloat();
        }
        
        String str = "Nom: "+nom+", DNI: "+DNI+". Nom Federació: "+nomFederacio+", Preu: "+preu+" €.";
        System.out.print("\n"+str + " ---> Esteu segur que voleu afegir (Y/N)? ");
        String option = sc.next().toUpperCase();
        while(!option.equals("Y")&&!option.equals("N")){
            System.err.print("La opció seleccionada no és correcta. Selecciona una opció entre (Y/N): ");
            option = sc.next().toUpperCase();
        }
        try{
            if(option.equals("Y")){
                clubUb.AfegirSociFederat(nom, DNI, nomFederacio,preu,0.3f,0.2f);
                if(preu >= 100){
                System.out.println("Soci Federat s'ha afegit correctament!");
                }
            }else{
                System.out.println("Soci Federat no s'ha afegit correctament!");
            }
            System.out.println();
        } catch (ExcepcioClub e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 1.2. Afegir soci estàndard: Demana les dades necessàries per un
     *      nou soci estàndard.
     */
    private void AfegirSociEstandard(){

        Scanner sc = new Scanner(System.in);
        System.out.print("Nom de soci Estàndard: ");
        String nom = sc.nextLine();

        System.out.print("DNI de soci Estàndard: ");
        String DNI = sc.nextLine();

        System.out.print("El tipus de l'assegurança contractada per les excursions (Basica/Completa): ");
        String tipusAsseguranca = sc.next().toUpperCase();
        
        System.out.print("Preu de l'assegurança contractada: ");
        float preuAsseguranca = sc.nextFloat();
        while(preuAsseguranca < 0){
            System.out.print("Preu de l'assegurança no pot mes petit que 0, tornar intentar-lo");
            preuAsseguranca = sc.nextFloat();
        }
        
        String str = "Nom: "+nom+", DNI: "+DNI+". Tipus Assegurança: "+tipusAsseguranca+", Preu: "+preuAsseguranca+" €.";
        System.out.print("\n"+str + " ---> Esteu segur que voleu afegir (Y/N)? ");
        String option = sc.next().toUpperCase();
        while(!option.equals("Y")&&!option.equals("N")){
            System.err.print("La opció seleccionada no és correcta. Selecciona una opció entre (Y/N): ");
            option = sc.next().toUpperCase();
        }
        try{
            if(option.equals("Y")){
                clubUb.AfegirSociEstandard(nom, DNI, tipusAsseguranca,preuAsseguranca);
                if((tipusAsseguranca.equals("BASICA"))||(tipusAsseguranca.equals("COMPLETA"))){
                    System.out.println("Soci Estandard s'ha afegit correctament!");
                }
            }else{
                System.out.println("Soci Estandard no s'ha afegit correctament");
            }
            System.out.println();
        } catch (ExcepcioClub e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 1.3. Afegir soci junior: Demana les dades necessàries per un nou
     *      soci junior.
     */
    private void AfegirSociJunior(){

        Scanner sc = new Scanner(System.in);
        System.out.print("Nom de soci Junior: ");
        String nom = sc.nextLine();

        System.out.print("DNI de soci Junior: ");
        String DNI = sc.nextLine();
        
        String str = "Nom: "+nom+", DNI: "+DNI+".";
        System.out.print("\n"+str + " ---> Esteu segur que voleu afegir (Y/N)? ");
        String option = sc.next().toUpperCase();
        while(!option.equals("Y")&&!option.equals("N")){
            System.err.print("La opció seleccionada no és correcta. Selecciona una opció entre (Y/N): ");
            option = sc.next().toUpperCase();
        }
        try{
            if(option.equals("Y")){
                clubUb.AfegirSociJunior(nom, DNI);
                System.out.println("Soci Junir s'ha afegit correctament");
            }else{
                System.out.println("Soci Junir no s'ha afegit correctament");
            }
            System.out.println();
        } catch (ExcepcioClub e) {
            System.out.println(e.getMessage());
        }
    }

    
    /**
     * 1.4. Menú anterior: Torna al menú anterior.
     */
    private void TornaMenuAnterior(){
    }

    /**
     * 2. Mostrar llista de socis: Mostra el contingut de la llista de socis del ClubUB,
     *    mostrant davant de cada soci, el nombre de la seva posició a la llista
     *    començant per 1.
     */
    private void MostrarLlistaSocis(){
        System.out.println(clubUb.MostrarLlistaSocis());
    }

    /**
     * 3. Eliminar soci: Elimina un soci de la llista indicant la seva posició a la llista.
     */
    private void EliminarSoci(){

        Scanner sc = new Scanner(System.in);
        System.out.print("Introdueix la posició del soci de la llista que vols eliminar: ");
        int posició = sc.nextInt();

       
        System.out.print("El soci de la posició [" + posició+ "] ---> Esteu segur que voleu eliminar (Y/N)? ");
        String option = sc.next().toUpperCase();
        while(!option.equals("Y")&&!option.equals("N")){
            System.err.print("La opció seleccionada no és correcta. Selecciona una opció entre (Y/N): ");
            option = sc.next().toUpperCase();
        }
        if(option.equals("Y")){
            try {
                clubUb.EliminarSoci(posició);
                System.out.println("El soci de la posició [" + posició + "] està eliminat!");
            } catch (ExcepcioClub e) {
               System.out.println(e.getMessage());
            }
        }else{
            System.out.println("Eliminació cancel·lada!");
        }

        System.out.println();
    }

    /**
     * 4. Mostrar factura: Mostra el total que ha de pagar un soci determinat en la
     *    factura d’un mes, indicant el seu DNI i el número d’excursions que ha fet
     *    aquell mateix mes.
     */
    private void MostrarFactura(){
        
        Scanner sc = new Scanner(System.in);
        System.out.print("DNI de soci que vols buscar: ");
        String DNI = sc.nextLine();

        System.out.print("Número d'excursions: ");
        float numeroExcursio = sc.nextFloat();
        float preuTotal;
        try {
            preuTotal = clubUb.CalcularFactura(DNI, numeroExcursio);
            System.out.println(clubUb.DadesSociFactura(DNI) + ", preu de la factura mensual: " + preuTotal +"€");
        } catch (ExcepcioClub e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
    }

    /**
     * 5. Modificar nom soci: Permet canviar el nom d’un soci per un altre.
     */
    private void ModificarNomSoci(){

        Scanner sc = new Scanner(System.in);
        System.out.print("DNI de soci que vols buscar: ");
        String DNI = sc.nextLine();

        System.out.print("Introdueix el nom que vols modificar: ");
        String nom = sc.nextLine();

        System.out.print(nom +" ---> Esteu segur que voleu modificar (Y/N)? ");
        String option = sc.next().toUpperCase();
        while(!option.equals("Y")&&!option.equals("N")){
            System.err.print("La opció seleccionada no és correcta. Selecciona una opció entre (Y/N) ");
            option = sc.next().toUpperCase();
        }
        try{
            if(option.equals("Y")){
                clubUb.ModificarNomSoci(DNI, nom);
                System.out.println("Modificació correcte!");
            }else{
                System.out.println("Modificació cancel·lada!");
            }
            System.out.println();
        } catch (ExcepcioClub e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 6. Modificar tipus assegurança soci: Permet canviar el tipus d’assegurança d’un
     *    soci indicant el seu DNI i el nou tipus d’assegurança (“Bàsica” o “Completa”).
     */
    private void ModificarTipusAssegurancaSoci(){

        Scanner sc = new Scanner(System.in);
        System.out.print("DNI de soci que vols buscar: ");
        String DNI = sc.nextLine();

        System.out.print("Introdueix el nou tipus d'assegurança que vols modificar(BASICA/COMPLETA): ");
        String tipusAsseguranca = sc.next().toUpperCase();
        while(!tipusAsseguranca.equals("BASICA")&&(!tipusAsseguranca.equals("COMPLETA"))){
            System.out.print("La opció seleccionada no és correcta. Selecciona una opció entre (Basica/Completa): ");
            tipusAsseguranca = sc.next().toUpperCase();
        }

        System.out.print( tipusAsseguranca +"---->Esteu segur que voleu modificar (Y/N)? ");
        String option = sc.next().toUpperCase();
        while(!option.equals("Y")&&!option.equals("N")){
            System.err.print("La opció seleccionada no és correcta. Selecciona una opció entre (Y/N): ");
            option = sc.next().toUpperCase();
        }
        try {
            if(option.equals("Y")){
                clubUb.ModificarTipusAssegurancaSoci(DNI, tipusAsseguranca);
                System.out.println("Modificació correcta!");
            }else{
               System.out.println("Modificació cancel·lada!");
            }
        } catch (ExcepcioClub e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
    }

    /**
     * 7. Guardar llista: Guarda el contingut de la llista en un fitxer.
     */
    private void GuadarLlista(){

        Scanner sc = new Scanner(System.in);
        System.out.print("nom de fitxer per guardar: ");
        String fileName = sc.nextLine();

        try {
            clubUb.GuardarDades(fileName);
            System.out.println("S'ha guardat correctament!");
        } catch (Exception e) {
            System.out.println("Error guardant les dades: " + e.getMessage());
        }
        
    }

    /**
     * 8. Recuperar llista: Carrega una llista prèviament guardada d’un fitxer.
     */
    private void RecuperarLlista(){

        Scanner sc = new Scanner(System.in);
        System.out.print("nom de fitxer per recuperar: ");
        String fileName = sc.nextLine();

        try {
            clubUb = ClubUB.CarregarDades(fileName);
            System.out.println("S'ha càrregat correctament!");
        } catch (ExcepcioClub | IOException | ClassNotFoundException e) {
            System.out.println("Error carregant les dades: " + e.getMessage());
        }
    }


    // Funcion que gestiona el menu principal de la aplicacion
    // Tiene 3 pasos principales:
    //   1. Crear el objeto que representa (contiene) el menu
    //   2. Asignar las descripciones del menu
    //   3. Bucle donde se trata la opcion seleccionada por el usuario
    public void gestioMenu(Scanner sc) {

        // Creación del objeto que representa el menu. El primer argumento del contructor es el nombre del menu
        Menu<OpcionesMenu> menuClubUB = new Menu<>("\t\t\tMenu Club UB " , OpcionesMenu.values());
        Menu<OpcionesSubMenu> submenuClubUB = new Menu<>("\t\tAfegir socis ", OpcionesSubMenu.values());

        // Assignar una descripción a cada una de las opciones
        //  - OPCIONAL - Por defecto enseña el nombre de la opción
        menuClubUB.setDescripcions(descMenu);
        submenuClubUB.setDescripcions(descsubMenu);
        // Variable (de tipo enumerado igual a las opciones del menu) que contiene la opcion escogida
        OpcionesMenu opcionMenu;
        OpcionesSubMenu  opcionSubMenu; 
        // Lançar el bucle principal de la aplicación
        do {
            menuClubUB.mostrarMenu();
            opcionMenu = menuClubUB.getOpcio(sc);
            
            switch(opcionMenu) {
                case M_Opcion_1_NouSoci:
                     submenuClubUB.mostrarMenu();
                    opcionSubMenu = submenuClubUB.getOpcio(sc);
                    switch(opcionSubMenu){
                        case M_Opcion_1_1_AfegirSociFederat:
                            AfegirSociFederat();
                            break;
                        case M_Opcion_1_2_AfegirSociEstàndard:
                            AfegirSociEstandard();
                            break;
                        case M_Opcion_1_3_AfegirSociJunior:
                            AfegirSociJunior();
                            break;
                        case M_Opcion_1_4_MenuAnterior:
                            TornaMenuAnterior();
                            break;
                        }
                    break;
                case M_Opcion_2_ListarSocis:
                        MostrarLlistaSocis();
                    break;
                case M_Opcion_3_EliminarSocis:
                        EliminarSoci();
                    break;
                case M_Opcion_4_MostrarFactura:
                        MostrarFactura();
                    break;
                case M_Opcion_5_ModificarNomSoci:
                        ModificarNomSoci();
                    break;
                case M_Opcion_6_ModificarTipusAssegurancaSoci:
                        ModificarTipusAssegurancaSoci();
                    break;
                case M_Opcion_7_GuardarLlista:
                        GuadarLlista(); 
                    break;
                case M_Opcion_8_RecuperarLlista:
                        RecuperarLlista();
                    break;
            }

        } while(opcionMenu != OpcionesMenu.M_Opcion_9_Sortir);

        System.out.println("Fi del programa, Adéu.");
    }

}