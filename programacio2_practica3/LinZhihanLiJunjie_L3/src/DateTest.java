/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Date;

/**
 *
 * @author dortiz
 */
public class DateTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Date d1 = new Date();
        System.out.println("Fecha de creación de d1: " + d1);
        // Usamos Thread.sleep para esperar 1000 milisegundos
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        Date d2 = new Date();
        System.out.println("Fecha de creación de d2: " + d2);
        System.out.println("Milisegundos transcurridos entre creación de d1 y d2: " + (d2.getTime() - d1.getTime()));
    }
    
}
