package tira.algoritmi;

import tira.verkko.Solmu;
import tira.verkko.Verkko;

/**
 *
 * @author Riku
 */
public class Bellmanford implements Algoritmi {

    String virhe;
    
    /**
     * Metodi etsii lyhimmän reitin lähdöstä maaliin käyttämällä Bellman-Fordin
     * algoritmia.
     * @param verkko Verkko josta etsitään lyhintä polkua lähdöstä maaliin
     *
     * @return Maalisolmu, jota peruuttamalla muodostetaan lyhin reitti.
     */

    public Solmu etsiLyhin(Verkko verkko) {
        int solmujenmaara = verkko.annaVerkko().length * verkko.annaVerkko()[0].length;

        for (int i = 0; i < solmujenmaara - 1; i++) {
            for (int j = 0; j < verkko.annaVerkko().length; j++) {
                for (int k = 0; k < verkko.annaVerkko()[0].length; k++) {
                    Solmu solmu = verkko.annaSolmu(j, k);
                    
                    if (solmu.annaKuljettava() != false) {
                        
                        Solmu naapuri = verkko.annaSolmu(solmu.annaX() - 1, solmu.annaY());

                        if (naapuri != null && naapuri.annaKuljettava() != false) {
                            this.tarkistaOnkoNopeampi(solmu, naapuri);
                        }
                        naapuri = verkko.annaSolmu(solmu.annaX() + 1, solmu.annaY());
                        if (naapuri != null && naapuri.annaKuljettava() != false) {
                            this.tarkistaOnkoNopeampi(solmu, naapuri);
                        }
                        naapuri = verkko.annaSolmu(solmu.annaX(), solmu.annaY() - 1);
                        if (naapuri != null && naapuri.annaKuljettava() != false) {
                            this.tarkistaOnkoNopeampi(solmu, naapuri);
                        }
                        naapuri = verkko.annaSolmu(solmu.annaX(), solmu.annaY() + 1);
                        if (naapuri != null && naapuri.annaKuljettava() != false) {
                            this.tarkistaOnkoNopeampi(solmu, naapuri);
                        }
                        
                    }
                }
            }
        }
        if (negatiivinenSykli(verkko)) {
            return null;
        }

        return verkko.annaMaali();
    }
    
    /**
     * Metodi tarkastaa onko Solmun a kautta kulkeva etäisyys pienempi kuin
     * Solmuun b valmiiksi kuljettu etäisyys. Mikäli näin on muutetaan Solmun b
     * etäisyys a:n kautta kuljetuksi etäisyydeksi ja asetetaan nopein reitti
     * kulkemaan Solmun a kautta.
     *
     *
     * @param a Solmu josta saavuttiin Solmuun b.
     * @param b Solmu b johon saavuttiin Solmusta a.
     */

    public void tarkistaOnkoNopeampi(Solmu a, Solmu b) {
        if (a.annaEtaisyys() < b.annaEtaisyys()) {
            b.asetaEtaisyys(a.annaEtaisyys());
            b.asetaReitti(a);
        }
    }
    
    /**
     * Metodi tarkastaa löytyykö polusta negatiivista sykliä, eli onko reitti loputon.
     * Samalla tarkastaa että reitti on myös olemassa.
     *
     * @param verkko Verkko, jonka polku tarkastetaan.
     * 
     * @return äärettömän reitin olemassaolon totuusarvo.
     */

    public boolean negatiivinenSykli(Verkko verkko) {
        Solmu solmu = verkko.annaMaali();
        int sivu = verkko.annaVerkko().length;
        int kertaa = ((int)Math.ceil((double)sivu/2)* sivu) + sivu/2;
        for (int i = 0; i <= kertaa; i++) {
            if (solmu == verkko.annaLahto()) {
                return false;
            }
            if (solmu == null){
                this.virhe = "Reittiä ei löydetty!";
                return true;
            }
            solmu = solmu.annaReitti();
        }
        this.virhe = "Maastosta löytyi negatiivinen sykli.";
        return true;
    }
    
    /**
     * Metodi palauttaa virhe merkkijonon.
     * 
     * @return virhe merkkijono.
     */

    public String virhe() {
        return this.virhe;
    }
    
    /**
     * Metodi palauttaa algoritmin nimen.
     * 
     * @return nimi merkkijono.
     */

    public String annaNimi() {
        return "BellmanFord";
    }
}
