package tira.syntaksinlukija;

import java.util.Scanner;

/**
 *
 * @author Riku
 */
public class Tarkastaja {

    String virhe;

    public boolean Tarkista(String teksti) {
        if (!symmetrinenTeksti(teksti)) {
            this.virhe = "Merkkejä ei olla muodostettu tekstitiedostoon neliöllisesti!";
            return false;
        }
        if (!loytyyVainYksiLahto(teksti)) {
            this.virhe = "Merkeistä pitää löytyä tasan yksi lähtö ('L')!";
            return false;
        }
        if (!loytyyVainYksiMaali(teksti)) {
            this.virhe = "Merkeistä pitää löytyä tasan yksi maali ('X')!";
            return false;
        }

        return true;
    }

    public boolean symmetrinenTeksti(String teksti) {
        Scanner lukija = new Scanner(teksti);
        int pituus = lukija.nextLine().length();
        while (lukija.hasNext()) {
            if (lukija.nextLine().length() != pituus) {
                return false;
            }
        }
        return true;
    }

    public boolean loytyyVainYksiLahto(String teksti) {
        boolean tulos = false;
        Scanner lukija = new Scanner(teksti);
        String rivi;
        while (lukija.hasNext()) {
            rivi = lukija.next();
            for (int i = 0; i < rivi.length(); i++) {
                if (rivi.charAt(i) == 'L') {
                    if (tulos == false) {
                        tulos = true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return tulos;
    }

    public boolean loytyyVainYksiMaali(String teksti) {
        boolean tulos = false;
        Scanner lukija = new Scanner(teksti);
        String rivi;
        while (lukija.hasNext()) {
            rivi = lukija.next();
            for (int i = 0; i < rivi.length(); i++) {
                if (rivi.charAt(i) == 'X') {
                    if (tulos == false) {
                        tulos = true;
                    } else {
                        return false;
                    }
                }
            }            
        }
    return tulos;
    }
    

    

    public String annaVirhe() {
        return this.virhe;
    }

}
