package tira.domain;

import javax.swing.SwingUtilities;
import tira.ui.Kayttoliittyma;

/**
 *
 * @author Riku
 */
public class Main {

    public static void main(String[] args) {
        
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
        SwingUtilities.invokeLater(kayttoliittyma);
        
        //Polunetsija p = new Polunetsija();
        //p.aloita();
    }

}
