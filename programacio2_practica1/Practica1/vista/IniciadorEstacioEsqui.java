package LinZhihanLiJunjie_L1.vista;

/**
 *
 * @author ZhiHan_Lin i Junjie_Li
 * @date   22/2
 * 
 */

//main
public class IniciadorEstacioEsqui {

    public static void main(String[] args) {

        // Definim el nom i les condicions meteorologiques inicials a l'estació
        String nomEstacio       = "Vall2000";
        float velocitatVent     = 10;
        String visibilitat      = "Dolenta";

        // Creem un objecte de la vista i li passem el nom i condicions meteorologiques inicials a l'estació
        VistaEstacioEsqui vistaEstacioVall2000 = new VistaEstacioEsqui(nomEstacio, velocitatVent, visibilitat);

        // Inicialitzem l'execució de la vista
        vistaEstacioVall2000.gestioEstacio();

        //Fi del programa
        System.out.println("Fi del programa, Adéu.");

    }
}
