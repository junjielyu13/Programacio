package LinZhihanLiJunjie_L1.vista;

import LinZhihanLiJunjie_L1.model.EstacioEsqui;
import java.util.Scanner;

/**
 *
 * @author ZhiHan_Lin i Junjie_Li
 * @date   22/2
 */
public class VistaEstacioEsqui {
    
    /* Atributs */
    String nomEstacio;
    float velocitatVent;
    String visibilitat;
    EstacioEsqui estacioEsqui = new EstacioEsqui();

    /**
     *   Constructor de la Vista
     * @param nomEstacio : nom inicials a l'estació
     * @param velocitatVent : la condicio meteorologica velocitat inicials a l'estació
     * @param visibilitat : la condicio meteorologica visibilitat inicials a l'estació
     */
    public VistaEstacioEsqui(String nomEstacio, float velocitatVent, String visibilitat) {
        this.nomEstacio = nomEstacio;
        this.velocitatVent = velocitatVent;
        this.visibilitat = visibilitat;

        // inicialitza les dades de l’estació amb la informació de les Taules 1 i 2.
        estacioEsqui.inicialitzaDadesVall2000(velocitatVent,visibilitat);
    }
     
    /* Métodes
     *  MENU
     */    

    /*
     * 1. Llistar la informació de totes les pistes
     */
    public void MenuLlistarInformacioPista(){
        estacioEsqui.LlistarInformacioPista();
    }
    
    /*
     *2. Llistar la informació de les pistes obertes
     */
    public void MenuLlistarInformacioPistaOberta(){
        estacioEsqui.LlistarInformacioPistaOberta();
    }

    /*
     *   3. Llistar la informació de les pistes tancades
     */
    public void MenuLlistarInformacioPistaTancada(){
        estacioEsqui.LlistarInformacioPistaTancada();
    }

    /*
     *   4. Llistar la informació de tots els remuntadors mecànics
     */
    public void MenuLlistaInforRemuntadorsMecanics(){
        estacioEsqui.LlistaInforRemuntadorsMecanics();
    }

    /*
     *    5. Llistar la informació dels remuntadors en servei
     */
    public void MenuLlistarInforRemuntadorsServei(){
        estacioEsqui.LlistarInforRemuntadorsServei();
    }

    /*
     *    6. Llistar la informació dels remuntadors fora de servei
     */
    public void MenuLlistarInforRemuntadorsForaServei(){
        estacioEsqui.LlistarInforRemuntadorsForaServei();
    }  

    /**
     * 7. Modificar l’estat de la neu en una pista
     *  • L’aplicació haurà de demanar a l’usuari que doni el nom de la pista, l’estat de la
     *    qual es vol modificar. Posteriorment, l’aplicació haurà de demanar també el
     *    nou estat de la neu. S’haurà de verificar que l’input donat per l’usuari és vàlid.
    */
    public void MenuModificarEstatNeu(){
        estacioEsqui.ModificarEstatNeu();
    }
    
    /*
    *  8. Calcular i mostrar el total de kilòmetres de pistes, i de pistes obertes
    *    • És a dir, el total de kilòmetres que fan les pistes de l’estació Vall2000, així com
    *      el total de kilòmetres esquiables en aquest moment a la Vall2000 (tenint en
    *      compte només les pistes obertes).
    */
    public void MenuCalcularMostrarKilometresPistes(){
        estacioEsqui.CalcularMostrarKilometresPistes();
    } 
    
    /*
    *  9. Modificar la velocitat del vent
    *    • És a dir, modificar les condicions relatives al vent que es fa sentir a l’estació
    *      Vall2000. Recorda que la velocitat del vent té un impacte directe en l’estat dels
    *      remuntadors mecànics i de les pistes, que s’haurà de tenir en compte de forma
    *      automàtica.
    */
    public void MenuModificarVelocitatVent(){
        estacioEsqui.ModificarVelocitatVent();
    }

    /**
    *  10. Modificar la visibilitat
    *    • És a dir, modificar les condicions de visibilitat a l’estació Vall2000. Recorda que
    *      les condicions de visibilitat tenen un impacte directe en l’estat dels
    *      remuntadors mecànics i de les pistes, que s’haurà de modificar de forma
    *      automàtica.
    */
    public void MenuModificarVisiblitat(){
        estacioEsqui.ModificarVisiblitat();
    }

    /*
     *   11. Mostrar les condicions meteorològiques actuals
    */
    public void MenuMostrarMeterologiques(){
        estacioEsqui.MostrarMeterologiques();
    }


    //gestion Estacio
    public void gestioEstacio(){
        // Creación de un objeto para leer el input desde el teclado
        Scanner sc = new Scanner(System.in);
        // Llamar a la funcion que gestiona el menu
        gestioMenu(sc);
    }


    
    /* ******************************************** */
    /* Gestion, Opciones y Descripcion del Menu (M) */
    /* ******************************************** */
    private static enum OpcionesMenu {
        M_Opcion_1_ListarPistas,
        M_Opcion_2_ListarPistasAbiertas,
        M_Opcion_3_ListarPistasCerradas,
        M_Opcion_4_ListarRemontadores,
        M_Opcion_5_ListarRemontadoresEnServicio,
        M_Opcion_6_ListarRemontadoresFueraServicio,
        M_Opcion_7_ModificarEstadoNieve,
        M_Opcion_8_CalcularTotalKms,
        M_Opcion_9_Modificar_Vent,
        M_Opcion_10_Modificar_Visibilitat,
        M_Opcion_11_Report_Meteo,
        M_Opcion_12_Salir
    };
    

    // Descripcion de las opciones del menu principal
    private static final String[] descMenu = {
        "Llistar la informació de totes les pistes", // Opcion 1
        "Llistar la informació de les pistes obertes",  // Opcion 2
        "Llistar la informació de les pistes tancades",  // Opcion 3
        "Llistar la informació de tots els remuntadors mecànics",  // Opcion 4
        "Llistar la informació dels remuntadors en servei",  // Opcion 5
        "Llistar la informació dels remuntadors fora de servei",  // Opcion 6
        "Modificar l'estat de la neu d'una pista",  // Opcion 7
        "Calcular i mostrar el total de kilometres de pistes i de pistes obertes",  // Opcion 8
        "Modificar la velocitat del vent",  // Opcion 9
        "Modificar la visibilitat",  // Opcion 10
        "Mostrar les condicions meteorologiques actuals",  // Opcion 11
        "Sortir del gestor de l'estació"  // Opcion 12
    };
    

    // Funcion que gestiona el menu principal de la aplicacion
    // Tiene 3 pasos principales:
    //   1. Crear el objeto que representa (contiene) el menu
    //   2. Asignar las descripciones del menu
    //   3. Bucle donde se trata la opcion seleccionada por el usuario
    public void gestioMenu(Scanner sc) {

        // Creación del objeto que representa el menu. El primer argumento del contructor es el nombre del menu
        Menu<OpcionesMenu> menuEstacio = new Menu<>("\t\t\tMenu  Vall2000 " , OpcionesMenu.values());
        // + "NO IMPLEMENTAT ---> estacio.getNomEstacio()"
        //Menu<OpcionesMenu> menuEstacio = new Menu<>("Menu " + estacio.getNomEstacio(), OpcionesMenu.values());
        
        // Assignar una descripción a cada una de las opciones
        //  - OPCIONAL - Por defecto enseña el nombre de la opción
        menuEstacio.setDescripcions(descMenu);
        
        // Variable (de tipo enumerado igual a las opciones del menu) que contiene la opcion escogida
        OpcionesMenu opcionMenu;
        
        // Lançar el bucle principal de la aplicación
        do {
            menuEstacio.mostrarMenu();
            opcionMenu = menuEstacio.getOpcio(sc);
            
            switch(opcionMenu) {
                case M_Opcion_1_ListarPistas:
                    MenuLlistarInformacioPista();
                    break;
                case M_Opcion_2_ListarPistasAbiertas:
                    MenuLlistarInformacioPistaOberta();
                    break;
                case M_Opcion_3_ListarPistasCerradas:
                    MenuLlistarInformacioPistaTancada();
                    break;
                case M_Opcion_4_ListarRemontadores:
                    MenuLlistaInforRemuntadorsMecanics();
                    break;
                case M_Opcion_5_ListarRemontadoresEnServicio:
                    MenuLlistarInforRemuntadorsServei();
                    break;
                case M_Opcion_6_ListarRemontadoresFueraServicio:
                    MenuLlistarInforRemuntadorsForaServei();
                    break;
                case M_Opcion_7_ModificarEstadoNieve:
                    MenuModificarEstatNeu();
                    break;
                case M_Opcion_8_CalcularTotalKms:
                    MenuCalcularMostrarKilometresPistes();
                    break;
                case M_Opcion_9_Modificar_Vent:
                    MenuModificarVelocitatVent();
                    break;
               case M_Opcion_10_Modificar_Visibilitat:
                    MenuModificarVisiblitat();
                    break;
                case M_Opcion_11_Report_Meteo:
                    MenuMostrarMeterologiques();
                    break;
            }
            
        } while(opcionMenu != OpcionesMenu.M_Opcion_12_Salir);
    }

}

