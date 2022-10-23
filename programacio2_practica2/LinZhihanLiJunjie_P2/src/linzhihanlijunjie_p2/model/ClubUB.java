package linzhihanlijunjie_p2.model;

import linzhihanlijunjie_p2.vista.ExcepcioClub;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * class ClubUB
 * @author Zhihan_Lin i Junjie_Li
 */

public class ClubUB implements Serializable { 
    private static final long serialVersionUID = 1L;
    
    /**
     * atribut de ClubUB
     * @PreuExcursio                      preu per excursió(20€).
     * @QuotaMensual                      preu per quoto mensual(25€).
     * @DescomptesPreuExcursioFederats    20% descompte del preu de l’excursió.
     * @DescomptesQuotaMensualFederats    30% descompte de la quota base mensual.
     * @llistaSoci                        Una llista de tipus ArrayList per guardar tots els socis.
     */
    private static final float PREU_EXCURSIO = 20;
    private static final float QUOTA_MENSUAL = 25;
    LlistaSocis llistaSocis = new LlistaSocis();
    



    /**
     * 1.1 Afegir soci federat: Demana les dades necessàries per un nou
     *     soci federat.
     * @param nom   nom de soci estandard
     * @param DNI   DNI de soci estandard
     * @param nomFederacio    nombre de federacio de soci estandard
     * @param preuFederacio   preu de federacio de soci estandard
     * @param descompteQuota    20% descompte del preu de l’excursió.
     * @param descompteExc 30% descompte de la quota base mensual.
     * @throws linzhihanlijunjie_p2.vista.ExcepcioClub
     */
    public void AfegirSociFederat(String nom, String DNI,String nomFederacio,float preuFederacio,float descompteQuota,float descompteExc)throws ExcepcioClub{
        Soci sociFederat = new SociFederat(nom,DNI,nomFederacio,preuFederacio,0.3f,0.2f);
        if(preuFederacio >= 100f){
            llistaSocis.addSoci(sociFederat);
        }
    }



    /**
     * 1.2. Afegir soci estàndard: Demana les dades necessàries per un
     *      nou soci estàndard.
     * @param nom   nom de soci estandard
     * @param DNI   DNI de soci estandard
     * @param tipusAss  tipu de assegurance de soci estandard
     * @param preuAss   preu de assegurance de soci estandard
     * @throws linzhihanlijunjie_p2.vista.ExcepcioClub
     */
    public void AfegirSociEstandard(String nom, String DNI, String tipusAss,float preuAss)throws ExcepcioClub{
        Soci sociEstandard = new SociEstandard(nom,DNI,tipusAss,preuAss);
        if((tipusAss.equals("BASICA"))||(tipusAss.equals("COMPLETA"))){
            llistaSocis.addSoci(sociEstandard);
        }
    }


    /**
     * 1.3. Afegir soci junior: Demana les dades necessàries per un nou
     *      soci junior.
     * @param nom   nom de soci junior
     * @param DNI   DNI de soci junior
     * @throws linzhihanlijunjie_p2.vista.ExcepcioClub
     */
    public void AfegirSociJunior(String nom, String DNI)throws ExcepcioClub{
        Soci sociJunior = new SociJunior(nom,DNI);
        llistaSocis.addSoci(sociJunior);
    }


    /**
     * 2. Mostrar llista de socis: Mostra el contingut de la llista de socis del ClubUB,
     *    mostrant davant de cada soci, el nombre de la seva posició a la llista
     *    començant per 1.
     * @return retorna la llista de Socis
     */
    public String MostrarLlistaSocis(){
        return llistaSocis.toString();
    }


    /**
     * 3. Eliminar soci: Elimina un soci de la llista indicant la seva posició a la llista.
     *  @param pos    Seleccioneu soci mitjançant posicio de Arraylist.
     * @throws linzhihanlijunjie_p2.vista.ExcepcioClub
     */
    public void EliminarSoci(int pos) throws ExcepcioClub{
       Soci soci = llistaSocis.getAt(pos);
       llistaSocis.removeSoci(soci);
    }


    /**
     * 4. Mostrar factura: Mostra el total que ha de pagar un soci determinat en la
     *    factura d’un mes, indicant el seu DNI i el número d’excursions que ha fet
     *    aquell mateix mes.
     *  @param DNI             Seleccioneu soci mitjançant DNI.
     *  @param numeroExcursio   numero d'excursions fets
     * @return retorna el preu total de la factura segons el tipus de soci
     * @throws linzhihanlijunjie_p2.vista.ExcepcioClub
     */
    public float CalcularFactura(String DNI, float numeroExcursio)throws ExcepcioClub{
        float preuTotal = 0;
        if(llistaSocis.getSoci(DNI) instanceof SociFederat){
                SociFederat sociFederat = (SociFederat)llistaSocis.getSoci(DNI);
                preuTotal = sociFederat.getFederacio().getPreu() + 
                        sociFederat.calculaPreuExcursio(PREU_EXCURSIO) * numeroExcursio + 
                        sociFederat.calculaQuota(QUOTA_MENSUAL);
        }else if(llistaSocis.getSoci(DNI) instanceof SociEstandard){
                SociEstandard sociEstandard = (SociEstandard)llistaSocis.getSoci(DNI);
                preuTotal = sociEstandard.calculaPreuExcursio(PREU_EXCURSIO)* numeroExcursio + 
                        sociEstandard.calculaQuota(QUOTA_MENSUAL);
        }else{
            SociJunior sociJunior = (SociJunior)llistaSocis.getSoci(DNI);
            preuTotal = sociJunior.calculaPreuExcursio(ClubUB.PREU_EXCURSIO)*numeroExcursio + 
                    sociJunior.calculaQuota(ClubUB.QUOTA_MENSUAL);
        }
        return preuTotal;
    }
    
    /**
     * 4.1
     * Mètode de suport que mostrar el nom i DNI concret del soci que vol mostrar la seva factura
     * En l'opció mostrar factura es mostra no només la Factura, sinó també el nom i el DNI d'aquell soci
     * @param DNI   DNI del soci que volem buscar
     * @return  retorna un string amb la informació bàsica del soci que volem saber la seva factura
     * @throws ExcepcioClub generarà una excepció si no existex el soci amb el DNI que passa per paràmetre
     */
    public String DadesSociFactura(String DNI) throws ExcepcioClub{
        return "Nom: " + llistaSocis.getSoci(DNI).getNom() + ", DNI: " + llistaSocis.getSoci(DNI).getDNI();
    }


     /**
     * 5. Modificar nom soci: Permet canviar el nom d’un soci per un altre.
     * @param DNI   Seleccioneu soci mitjançant DNI.
     * @param nom   nom de soci que voleu modificar.
     * @throws linzhihanlijunjie_p2.vista.ExcepcioClub
     */
    public void ModificarNomSoci(String DNI,String nom)throws ExcepcioClub{
            llistaSocis.getSoci(DNI).setNom(nom);
    }


    /**
     * 6. Modificar tipus assegurança soci: Permet canviar el tipus d’assegurança d’un
     *    soci indicant el seu DNI i el nou tipus d’assegurança (“Bàsica” o “Completa”).
     *  @param DNI                Seleccioneu soci mitjançant DNI.
     *  @param tipusAsseguranca   tipus de aseguranca que voleu modificar.
     *  @throws ExcepcioClub      General d’excepcions produïdes per class linzhihanlijunjie_p2.vista.ExcepcioClub;
     */
    public void ModificarTipusAssegurancaSoci(String DNI,String tipusAsseguranca) throws ExcepcioClub{
        if(llistaSocis.getSoci(DNI) instanceof SociEstandard){
            SociEstandard sociEstandard = (SociEstandard)llistaSocis.getSoci(DNI);
            sociEstandard.getAsseguranca().setTipu(tipusAsseguranca);
        }else{
            throw new ExcepcioClub("El soci que té el DNI " + DNI + " no és un soci Estàndard! ");
        } 
    }


    /**
     * 7. Guardar llista: Guarda el contingut de la llista en un fitxer.
     * @param fileName  Nom del fitxer per guardar les dades dels socis.
     * @param clubUb    objecte clubUb que té totes les informacions sobre els socis
     * @throws ExcepcioClub General d’excepcions produïdes per class linzhihanlijunjie_p2.vista.ExcepcioClub;
     * @throws IOException  General d’excepcions produïdes per operacions d’E/S interrompudes o fallides.
     * @guardarDades        Guarda les dades al fitxer de disc 
     */
    public void GuardarDades(String fileName) throws ExcepcioClub, IOException{
        File file = new File(fileName);
        FileOutputStream fout = null;
        ObjectOutputStream oos = null;
        try {
            fout = new FileOutputStream(file);
            oos = new ObjectOutputStream(fout);
            oos.writeObject(this);
        } catch (IOException e) {
            throw new ExcepcioClub("No s'ha guardat");
        } finally{
            fout.close();
            oos.close();
        }
    }

    
    /** 
     * 8.
     * @param fileName       Nom del fitxer per carregar les dades dels socis
     * @throws ExcepcioClub  General d’excepcions produïdes per class linzhihanlijunjie_p2.vista.ExcepcioClub;
     * @throws IOException   general d’excepcions produïdes per operacions d’E/S interrompudes o fallides.
     * @throws ClassNotFoundException   Llançat quan una aplicació intenta carregar en una classe mitjançant el nom incorrecta
     * @carregarDades        llegir les dades des de fitxer de disc
     * @return   Objecte que guardi tota la informació dels soci del fitxer de filename
     */
    public static ClubUB CarregarDades(String fileName) throws ExcepcioClub, IOException, ClassNotFoundException {

        File file = new File(fileName);
        ClubUB clubUb = null;
        FileInputStream fin = null;
        ObjectInputStream ois = null;
        try {
            fin  = new FileInputStream(file);
            ois = new ObjectInputStream(fin);
            clubUb = (ClubUB)ois.readObject();
        } catch (FileNotFoundException e) {
            throw new ExcepcioClub("Fitxer no trobat");
        } finally {
            if(fin!= null && ois != null){
                fin.close();
                ois.close();
            }
        }
        return clubUb;
    }
}