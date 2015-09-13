package tira.algoritmi;

import tira.tietorakenteet.Minimikeko;
import tira.verkko.Solmu;
import tira.verkko.Verkko;

/**
 * Luokka tekee Astar algoritmin operaatiot
 * 
 * @author Riku
 */
public class Astar {
    
/**
 * Metodi etsii lyhimmän reitin lähdöstä maaliin käyttämällä Dijkstran algoritmia ja Minimikekoa.
 * Huom! Ei vielä Astar osuutta. Tulee pian!
 *
 * @param   verkko  Verkko josta etsitään lyhintä polkua lähdöstä maaliin
 * 
 * @return Maalisolmu, jota peruuttamalla muodostetaan lyhin reitti.
 */

    public Solmu etsiLyhin(Verkko verkko) {
        Solmu solmu;
        Solmu naapuri;
        Minimikeko keko = new Minimikeko();     
        keko.syotaKaikki(verkko);
        while (keko.annaPienin() != null) {
            solmu = keko.poistaJaAnnaPienin();
            if (solmu.onMaali()) {
                return solmu;
            }
            naapuri = verkko.annaSolmu(solmu.annaX() - 1, solmu.annaY());
            if (naapuri != null) {                
                this.tarkistaOnkoNopeampi(solmu, naapuri, keko);
            }
            naapuri = verkko.annaSolmu(solmu.annaX() + 1, solmu.annaY());
            if (naapuri != null) {
                this.tarkistaOnkoNopeampi(solmu, naapuri, keko);
            }
            naapuri = verkko.annaSolmu(solmu.annaX(), solmu.annaY() - 1);
            if (naapuri != null) {
                this.tarkistaOnkoNopeampi(solmu, naapuri, keko);
            }
            naapuri = verkko.annaSolmu(solmu.annaX(), solmu.annaY() + 1);
            if (naapuri != null) {
                this.tarkistaOnkoNopeampi(solmu, naapuri, keko);
            }
        }
        return null;
    }
    
 /**
 * Metodi tarkastaa onko Solmun a kautta kulkeva etäisyys pienempi kuin Solmuun b
 * valmiiksi kuljettu etäisyys. Mikäli näin on muutetaan Solmun b etäisyys a:n kautta kuljetuksi etäisyydeksi
 * ja asetetaan nopein reitti kulkemaan Solmun a kautta. Muutokset tehään myös kekoon.
 * 
 *
 * @param   a   Solmu josta saavuttiin Solmuun b.
 * @param   b   Solmu b johon saavuttiin Solmusta a.
 * @param   keko Minimikeko, missä molemmat solmut sijaitsevat.
 */


    public void tarkistaOnkoNopeampi(Solmu a, Solmu b, Minimikeko keko) {
        if (a.annaEtaisyys() < b.annaEtaisyys()) {
            keko.vahennaSolmunEtaisyyttaKeossa(b, a.annaEtaisyys());
            b.asetaReitti(a);
        }
    }
}
