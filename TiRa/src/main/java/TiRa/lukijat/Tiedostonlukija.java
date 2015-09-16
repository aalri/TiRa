package tira.lukijat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Riku
 */
public class Tiedostonlukija {

    BufferedReader lukija;

    /**
     * Metodi hakee tiedoston nimeä vastaavan tiedoston ja muuttaa sen Stringiksi.
     * Muuten palauttaa null.
     *
     * @param  tiedostonnimi tiedoston nimi
     * 
     * @return tiedoston sisältö
     */
    public String lueTiedosto(String tiedostonnimi) {
        String sisalto = "";
        try {
            this.lukija = new BufferedReader(new FileReader(tiedostonnimi));
            String rivi = this.lukija.readLine();
            while (rivi != null) {
                sisalto = sisalto + rivi + "\n";
                rivi = this.lukija.readLine();
            }
        } catch (IOException e) {
            return null;
        }
        return sisalto;
    }
}
