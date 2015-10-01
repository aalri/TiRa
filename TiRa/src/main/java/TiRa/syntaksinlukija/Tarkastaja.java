package tira.syntaksinlukija;

import java.util.Scanner;
import tira.algoritmi.Algoritmi;
import tira.algoritmi.Astar;

/**
 *
 * @author Riku
 */
public class Tarkastaja {

    String virhe;

    /**
     * Metodi käy läpi kaikki algoritmikohtaiset syntaksin selvitykset ja
     * palauttaa niiden yhteisen tuloksen.
     *
     * @param teksti String josta tarkistetaan että on syntaksia vastaava
     *
     * @return totuusarvo syntaksin vastaavuudesta
     */
    public boolean Tarkista(String teksti, Algoritmi algoritmi) {
        if (teksti == null){
            this.virhe = "Tekstitiedostoa ei löytynyt. Tarkista oikeinkirjoitus";
            return false;
        }
        
        if (!vainSyntaksinMerkkeja(teksti)){
            this.virhe = "Merkeistä löytyi sinne kuulumattomia merkkejä! Korvaa tyhjät '#' merkillä!";
            return false;
        }
        
        if (!yhtaMontaRiviaKuinLeveyttaTeksti(teksti)) {
            this.virhe = "Merkkijonon pituuden pitää olla sama kuin rivien määrän, jolloin sivut ovat yhtä pitkiä.";
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

        if (algoritmi.annaNimi().contentEquals("Astar") && !eiNegatiivisiaVaatimuksia(teksti)) {
            this.virhe = "Astar algoritmia ei voida käyttää maastossa missä on negatiivisia vaativuuksia!";
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
        int korkeus = 1;
        while (lukija.hasNext()) {
            korkeus++;
            if (lukija.nextLine().length() != pituus) {
                return false;
            }
        }
        if (korkeus != pituus) {
            return false;
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
     * Metodi selvittää onko tekstissä pelkästään syntaksin hyväksymiä merkkejä.
     *
     * @param teksti String josta tarkistetaan että kelpaako
     *
     * @return totuusarvo selvityksestä
     */

    public boolean vainSyntaksinMerkkeja(String teksti) {

        Scanner lukija = new Scanner(teksti);
        String rivi;
        char[] merkit = {'.', 'A', 'T', '~', '-', 'X', 'L', '#', '0', '1',
                         '2', '3', '4', '5', '6', '7','8', '9'};
        while (lukija.hasNextLine()) {
            rivi = lukija.nextLine();
            for (int i = 0; i < rivi.length(); i++) {
                boolean onmerkki = false;
                for (int j = 0; j < merkit.length; j++) {                     
                    if (rivi.charAt(i) == merkit[j]) {
                        onmerkki = true;
                        break;
                    }
                }
                if (!onmerkki) {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Metodi selvittää onko tekstissä '-' merkkejä. Palauttaa false mikäli on.
     *
     * @param teksti String josta tarkistetaan että kelpaako
     *
     * @return totuusarvo selvityksestä
     */

    public boolean eiNegatiivisiaVaatimuksia(String teksti) {

        Scanner lukija = new Scanner(teksti);
        String rivi;
        while (lukija.hasNext()) {
            rivi = lukija.next();
            for (int i = 0; i < rivi.length(); i++) {
                if (rivi.charAt(i) == '-') {
                    return false;
                }
            }
        }
        return true;
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
