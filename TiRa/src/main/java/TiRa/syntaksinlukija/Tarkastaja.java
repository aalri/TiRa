package tira.syntaksinlukija;

import java.util.Scanner;

/**
 *
 * @author Riku
 */
public class Tarkastaja {

    String virhe;

    /**
     * Metodi käy läpi kaikki syntaksin selvitykset ja palauttaa niiden yhteisen
     * tuloksen.
     *
     * @param teksti String josta tarkistetaan että on syntaksia vastaava
     *
     * @return totuusarvo syntaksin vastaavuudesta
     */
    public boolean Tarkista(String teksti) {
        if (!yhtaMontaRiviaKuinLeveyttaTeksti(teksti)) {
            this.virhe = "Merkkijonon pituuden pitää olla sama kuin rivien määrän, jollain sivut ovat yhtä pitkiä.\n"
                       + "Korvaa tyhjät '#' merkillä!";
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

    /**
     * Metodi selvittää onko tekstissä yhtä monta riviä kuin kirjainta rivillä
     *
     * @param teksti String josta tarkistetaan että kelpaako
     *
     * @return totuusarvo selvityksestä
     */
    public boolean yhtaMontaRiviaKuinLeveyttaTeksti(String teksti) {
        Scanner lukija = new Scanner(teksti);
        int pituus = lukija.nextLine().length();
        while (lukija.hasNext()) {
            if (lukija.nextLine().length() != pituus) {
                return false;
            }
        }
        return true;
    }

    /**
     * Metodi selvittää onko tekstissä vain yksi lähtö merkki
     *
     * @param teksti String josta tarkistetaan että kelpaako
     *
     * @return totuusarvo selvityksestä
     */
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

    /**
     * Metodi selvittää onko tekstissä vain yksi maali merkki
     *
     * @param teksti String josta tarkistetaan että kelpaako
     *
     * @return totuusarvo selvityksestä
     */
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

    /**
     * Metodi palauttaa virhetekstin
     *
     * @return virheteksti
     */
    public String annaVirhe() {
        return this.virhe;
    }

}
