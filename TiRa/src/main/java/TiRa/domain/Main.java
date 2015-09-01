package totgen.domain;

/**
 * Hello world!
 *
 */
import javax.swing.SwingUtilities;
import totgen.ui.Kayttoliittyma;

public class Main {

    public static void main(String[] args) {
        
        //PaattelynTarkistaja tautologia = new PaattelynTarkistaja("(Nuori imp Ulkona) and (Pekka imp Nuori)", "Pekka imp Ulkona");
        //System.out.println(tautologia.voidaanPaatella());

        Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
        SwingUtilities.invokeLater(kayttoliittyma);

        //Totuustaulu totuustaulu = new Totuustaulu("((Nuori imp Ulkona) and (Pekka imp Nuori)) imp (Pekka imp Ulkona)");
        //totuustaulu.luoLause();
        //totuustaulu.luoTotuustaulu();
        //Generaattori generaattori = new Generaattori();
        //Lause lause = generaattori.generoi("not not ( A and B )");  
        //int[] totuusarvot = new int[] {0, 0, 0, 0, 0, 1 ,0};
        //System.out.println(lause.muodostaTotuusrivi(totuusarvot));
    }
}
