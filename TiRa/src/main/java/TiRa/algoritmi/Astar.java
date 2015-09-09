package tira.algoritmi;

import tira.tietorakenteet.Minimikeko;
import tira.verkko.Solmu;
import tira.verkko.Verkko;

/**
 *
 * @author Riku
 */
public class Astar {

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


    public void tarkistaOnkoNopeampi(Solmu a, Solmu b, Minimikeko keko) {
        if (a.annaEtaisyys() < b.annaEtaisyys()) {
            keko.vahennaSolmunEtaisyyttaKeossa(b, a.annaEtaisyys());
            b.asetaReitti(a);
        }
    }
}
