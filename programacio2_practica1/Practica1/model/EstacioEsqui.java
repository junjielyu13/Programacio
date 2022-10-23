/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LinZhihanLiJunjie_L1.model;

import java.util.*;

/**
 *
 * @author ZhiHan_Lin i Junjie_Li
 * @date   28/2
 * 
 */

/**
 * conté tota la informació sobre l’estació
 */
public class EstacioEsqui {

    // inicialitza les dades de l’estació amb la informació de les Taules 1 i 2.
    private LlistaRemuntadors llistaRemuntadors = new LlistaRemuntadors();
    private LlistaPistes llistaPistes = new LlistaPistes();
    private Meteo meteo;

    public void inicialitzaDadesVall2000(float velocitatVent, String visibilitat){

        /* Remuntadors */
        Telecadira RM1 = new Telecadira("RM1", "Nord", "En Servei", 35, false);   
        llistaRemuntadors.afegirRemuntador(RM1);
        Teleesqui  RM2 = new Teleesqui ("RM2", "Nord", "En Servei", 35, false);      
        llistaRemuntadors.afegirRemuntador(RM2);
        Telecadira RM3 = new Telecadira("RM3", "Nord", "En Servei", 35, false);      
        llistaRemuntadors.afegirRemuntador(RM3);
        Teleesqui  RM4 = new Teleesqui ("RM4", "Nord", "En Servei", 60, false);      
        llistaRemuntadors.afegirRemuntador(RM4);
        Telecabina RM5 = new Telecabina("RM5", "Nord", "En Servei", 60, false);      
        llistaRemuntadors.afegirRemuntador(RM5);
        CintaTransportadora RM6 = new CintaTransportadora("RM6", "Nord", "En Servei", 60, false); 
        llistaRemuntadors.afegirRemuntador(RM6);
        Teleesqui  RM7 = new Teleesqui ("RM7", "Sud", "En Servei", 60, false);       
        llistaRemuntadors.afegirRemuntador(RM7);
        Telecadira RM8 = new Telecadira("RM8", "Sud", "En Servei", 60, false);       
        llistaRemuntadors.afegirRemuntador(RM8);
        Telecabina RM9 = new Telecabina("RM9", "Sud", "Fora de Servei", 60, true);   
        llistaRemuntadors.afegirRemuntador(RM9);
        Teleferic RM10 = new Teleferic ("RM10", "Inter-Sector", "En Servei", 60, false); 
        llistaRemuntadors.afegirRemuntador(RM10);
        
        /* Pistes */
        Pista P1  = new Pista("P1",  "Nord", "Negra",    0.8f, "Dura",      "Oberta"); 
        llistaPistes.afegirPista(P1);
        Pista P2  = new Pista("P2",  "Nord", "Vermella", 1.1f, "Dura",      "Oberta");  
        llistaPistes.afegirPista(P2);
        Pista P3  = new Pista("P3",  "Nord", "Blava",    1.8f, "Pols",      "Oberta");  
        llistaPistes.afegirPista(P3);
        Pista P4  = new Pista("P4",  "Nord", "Vermella", 1.2f, "Dura",      "Oberta"); 
        llistaPistes.afegirPista(P4);
        Pista P5  = new Pista("P5",  "Nord", "Blava",    2.1f, "Primavera", "Oberta");  
        llistaPistes.afegirPista(P5);
        Pista P6  = new Pista("P6",  "Nord", "Blava",    2.9f, "Pols",      "Oberta");  
        llistaPistes.afegirPista(P6);
        Pista P7  = new Pista("P7",  "Nord", "Verda",    1.2f, "Primavera", "Oberta");  
        llistaPistes.afegirPista(P7);
        Pista P8  = new Pista("P8",  "Nord", "Verda",    0.9f, "Pols",      "Oberta");  
        llistaPistes.afegirPista(P8);
        Pista P9  = new Pista("P9",  "Sud",  "Vermella", 2.1f, "Dura",      "Tancada");  
        llistaPistes.afegirPista(P9);
        Pista P10 = new Pista("P10", "Sud",  "Negra",    0.6f, "Primavera", "Tancada");  
        llistaPistes.afegirPista(P10);
        Pista P11 = new Pista("P11", "Sud",  "Vermella", 1.3f, "Primavera", "Oberta");  
        llistaPistes.afegirPista(P11);
        Pista P12 = new Pista("P12", "Sud",  "Blava",    1.9f, "Pols",      "Oberta");  
        llistaPistes.afegirPista(P12);
        
        
        /* Dependencies */
        P1.afegirDependencia(RM1);
        P2.afegirDependencia(RM2); P2.afegirDependencia(RM3);
        P3.afegirDependencia(RM5);
        P4.afegirDependencia(RM5);
        P5.afegirDependencia(RM5);
        P6.afegirDependencia(RM4);
        P7.afegirDependencia(RM5);
        P8.afegirDependencia(RM5); P8.afegirDependencia(RM6);
        P9.afegirDependencia(RM9);
        P10.afegirDependencia(RM9);
        P11.afegirDependencia(RM7); P11.afegirDependencia(RM9);
        P12.afegirDependencia(RM8);

        meteo = new Meteo(visibilitat,velocitatVent);
    }


    /**
     * 1. Llistar la informació de totes les pistes
     */
    public void LlistarInformacioPista(){
        System.out.println(llistaPistes.llistarPistes("Tots"));
    }
    
    /**
     * 2. Llistar la informació de les pistes obertes
     */
    public void LlistarInformacioPistaOberta(){
        System.out.println(llistaPistes.llistarPistes("Oberta"));
    }

    /**
     * 3. Llistar la informació de les pistes tancades
     */
    public void LlistarInformacioPistaTancada(){
        System.out.println(llistaPistes.llistarPistes("Tancada"));
    }
    
    /**
     * 4. Llistar la informació de tots els remuntadors mecànics
     */
    public void LlistaInforRemuntadorsMecanics(){
        System.out.println(llistaRemuntadors.llistarRemuntadors("Tots"));
    }

    /**
     * 5. Llistar la informació dels remuntadors en servei
     */
    public void LlistarInforRemuntadorsServei(){
        System.out.println(llistaRemuntadors.llistarRemuntadors("En Servei"));        
    }

    /** 
     *  6. Llistar la informació dels remuntadors fora de servei
     */
    public void LlistarInforRemuntadorsForaServei(){
        System.out.println(llistaRemuntadors.llistarRemuntadors("Fora de Servei"));   
    }   

     /**
     * 7. Modificar l’estat de la neu en una pista
     *  • L’aplicació haurà de demanar a l’usuari que doni el nom de la pista, l’estat de la
     *    qual es vol modificar. Posteriorment, l’aplicació haurà de demanar també el
     *    nou estat de la neu. S’haurà de verificar que l’input donat per l’usuari és vàlid.
     */
    public void ModificarEstatNeu(){    
        
        System.out.println("\nModificar l’estat de la neu en una pista");

        // demanar a l’usuari que doni el nom de la pista.
        Scanner sc = new Scanner(System.in);
        System.out.print("Nom de la pista que vols modificar l'estat de la neu (Exemple:PX) :  ");
        String nom = sc.nextLine();

        /**
         *  Introduïu el bucle while si l'usuari introdueix un nom de la pista que no és correct
         */
        String Listnom[] = {"P1","P2","P3","P4","P5","P6","P7","P8","P9","P10","P11","P12"};
        // lista de nom de les pistes 
        boolean NomCorrect = true;
        while(NomCorrect){
            for(int i=0; i<Listnom.length; i++){
                if(nom.equals(Listnom[i])){
                    NomCorrect = false;
                    break;
                }
            }
            if(NomCorrect == false){
                break;
            }
            System.out.print("No tenen aquest nom de la pista, tornar intentar-lo (Exemple:PX): ");
            nom = sc.nextLine();
        }

        // l’estat de la qual es vol modificar.
        System.out.print("L'estat de neu que vols modificar(Pols/Primavera/Dura):  ");
        String EstatNeu = sc.nextLine(); 

        // l’aplicació haurà de demanar també el nou estat de la neu.
        // S’haurà de verificar que l’input donat per l’usuari és vàlid.
        while( (!(EstatNeu.equals("Pols")))  && (!(EstatNeu.equals("Primavera"))) && (!(EstatNeu.equals("Dura"))) ){
            System.out.print("No tenen aquest estat de neu, tornar intenta-lo(Pols/Primavera/Dura): ");
            EstatNeu = sc.nextLine();
        }
        
        Pista pista = new Pista();
        pista = llistaPistes.getPista(nom);
        String OldEstatNeu = pista.getEstatNeu(); 
        String NewEstatNeu = EstatNeu;

        //Esperar afirmar per l'usuari
        System.out.print("Pista: " + nom + " : Vols canviar " + OldEstatNeu + " -------------> " + NewEstatNeu + "? (Y/N) : ");
        String opcio = sc.next().toUpperCase();
        
        while( (!(opcio.equals("Y"))) && (!(opcio.equals("N"))) ){
            System.out.print("no tenen aquest opcio, tornar intenta-lo (Y/N) : ");
            opcio = sc.next().toUpperCase();
        }

        if(opcio.equals("Y")){
            pista.setEstatNeu(EstatNeu);
            System.out.println("Modificació correcta!\n");
        }else{
            System.out.println("Cancel modificació!\n");
        }
           
    }
    
    /*
    *  8. Calcular i mostrar el total de kilòmetres de pistes, i de pistes obertes
    *    • És a dir, el total de kilòmetres que fan les pistes de l’estació Vall2000, així com
    *      el total de kilòmetres esquiables en aquest moment a la Vall2000 (tenint en
    *      compte només les pistes obertes).
    */
    public void CalcularMostrarKilometresPistes(){

        //Calcular i mostrar el total de kilòmetres de pistes.
        float totalKMpistes = llistaPistes.calculaKmsPistes("Tots");
        System.out.println("\nTotal de kilometres de pistes : " + totalKMpistes + " km");

        //Calcular i mostrar el total de kilòmetres de pistes obertes.
        float totalKMpistesObertes = llistaPistes.calculaKmsPistes("Oberta");
        System.out.println("Total de kilometres de pistes obertes : " + totalKMpistesObertes + " km \n");
    } 
    
    /*
    *  9. Modificar la velocitat del vent
    *    • És a dir, modificar les condicions relatives al vent que es fa sentir a l’estació
    *      Vall2000. Recorda que la velocitat del vent té un impacte directe en l’estat dels
    *      remuntadors mecànics i de les pistes, que s’haurà de tenir en compte de forma
    *      automàtica.
    */
    public void ModificarVelocitatVent(){

        Scanner sc = new Scanner(System.in);
        float velocitat;
        System.out.print("\nIntroduix la velocitat del vent que vols modificar: ");
        velocitat = sc.nextFloat();

        while(velocitat < 0){
            System.out.println("La velocitat del vent ha de ser positiu, torna a introduir un altre cop: ");
            velocitat = sc.nextFloat();
        }

        //Esperar afirmar per l'usuari
        float oldVelocitat = meteo.getVelocitat();
        System.out.print("Vols canviar velocitat de vent " +  oldVelocitat + " ---------> " + velocitat + "km/h ? (Y/N) ");
        String opcio = sc.next().toUpperCase();
                 
        while( (!(opcio.equals("Y"))) && (!(opcio.equals("N"))) ){
            System.out.print("no tenen aquest opcio, tornar intenta-lo (Y/N) : ");
            opcio = sc.next().toUpperCase();
        }

        if(opcio.equals("Y")){
            meteo.setVelocitat(velocitat);
            llistaRemuntadors.actualitzaEstat(meteo);
            llistaPistes.actualitzaEstat();
            System.out.println("Modificació correcta!\n");
        }else{
            System.out.println("Cancel modificació!\n");
        }
        
    }

    /**
    *  10. Modificar la visibilitat
    *    • És a dir, modificar les condicions de visibilitat a l’estació Vall2000. Recorda que
    *      les condicions de visibilitat tenen un impacte directe en l’estat dels
    *      remuntadors mecànics i de les pistes, que s’haurà de modificar de forma
    *      automàtica.
    */
    public void ModificarVisiblitat(){

        Scanner sc = new Scanner(System.in);
        String visibilitat;
        System.out.print("\nIntroduix la visibilitat que vols modificar (\"Bona\"/ \"Dolenta\"): ");
        visibilitat = sc.nextLine();

        while( (!(visibilitat.equals("Bona"))) && (!(visibilitat.equals("Dolenta"))) ){  
            System.out.print("No tenen aquest opcio de visibilitat, tornar intenta-lo (\"Bona\"/ \"Dolenta\"): ");
            visibilitat = sc.nextLine();
        }

        //Esperar afirmar per l'usuari
        String oldVisibilitat = meteo.getVisibilitat();
        System.out.print("Vols canviar estat de visibilitat " + oldVisibilitat + "  ---------> " + visibilitat + " ? (Y/N) ");
        String opcio = sc.next().toUpperCase();
            
        if(opcio.equals("Y")){
            meteo.setVisibilitat(visibilitat);
            llistaRemuntadors.actualitzaEstat(meteo);
            llistaPistes.actualitzaEstat();
            System.out.println("Modificació correcta!\n");
        }else{
            System.out.println("Cancel modificació!\n");
        }
    }

    /*
     *   11. Mostrar les condicions meteorològiques actuals
     */
    public void MostrarMeterologiques(){
        System.out.println(meteo.toString());
    }
}
