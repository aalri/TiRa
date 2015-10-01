package tira.lukijat;

import java.util.Scanner;
import tira.algoritmi.Algoritmi;
import tira.algoritmi.Astar;
import tira.algoritmi.Bellmanford;

/**
 *
 * @author Riku
 */
public class Syotteenlukija {

    Scanner lukija;

    /**
     * Metodi muuttaa annetun tekstin char[][] taulukoksi.
     *
     * @param teksti taulukoksi muutettava teksti.
     * 
     * @return taulukko
     */
    public char[][] muutaMaastoksi(String teksti) {
        lukija = new Scanner(teksti);
        String rivi = lukija.nextLine();
        char[][] maasto = new char[rivi.length()][rivi.length()];
        int i = 0;
        int j = 0;
        while (lukija.hasNextLine()) {
            if (i != 0) {
                rivi = lukija.nextLine();
            }
            while (!rivi.isEmpty()) {
                maasto[i][j] = rivi.charAt(0);
                rivi = rivi.substring(1);
                j++;
            }
            j = 0;
            i++;
        }
        return maasto;
    }
    
    /**
     * Metodi pyytää käyttäjältä syötteenä antaako hän tiedostoa.
     *
     *
     * @return totuusarvo käyttäjältä.
     */

    public boolean annetaanTiedosto() {
        System.out.print("Annat tiedoston? (y/n): ");
        this.lukija = new Scanner(System.in);
        if (this.lukija.nextLine().equals("y")) {
            return true;
        }
        return false;
    }

    /**
     * Metodi pyytää käyttäjältä syötteenä käsiteltävän .txt Tiedoston
     * sijainnin.
     *
     *
     * @return käyttäjän antama syöte jonka perässä on .txt
     */
    public String annaTiedostonPaikka() {
        System.out.print("Anna paikka (*.txt): ");
        this.lukija = new Scanner(System.in);
        String paikka = this.lukija.nextLine();
        while (!paikka.endsWith(".txt")) {
            System.out.println("Ei Kelpaa!");
            System.out.println("Anna paikka (*.txt): ");
            paikka = this.lukija.nextLine();
        }

        return paikka;
    }
    
    /**
     * Metodi pyytää käyttäjältä syötteenä polunetsinnassa käytettävän algoritmin.
     *
     *
     * @return algoritmi, jota käytetään polunetsinnässä.
     */
    
    public Algoritmi annetaanAlgoritmi() {
        System.out.print("Valitse algoritmi\n"
                         + "1 = Bellmanford\n"
                         + "2 = Astar\n"
                         + ": ");
        this.lukija = new Scanner(System.in);
        switch(this.lukija.nextLine()){
            
            case "1":
                return new Bellmanford();
            case "2":
                return new Astar();
                
        }
        return null;
    }
    
    /**
     * Metodi palauttaa algoritmin, joka vastaa int arvoa.
     *
     *
     * @return algoritmi, jota käytetään polunetsinnässä.
     */
    
    public Algoritmi annaUIAlgoritmi(int arvo) {
        switch(arvo){
            
            case 0:
                return new Astar();
            case 1:
                return new Bellmanford();           
                
        }
        return null;
    }

}
