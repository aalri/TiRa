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
        verkko.annaLahto().asetaEtaisyys(0);
        Solmu naapuri;
        Minimikeko keko = new Minimikeko();
        for (int i = 0; i < verkko.annaVerkko().length; i++) {
            for (int j = 0; j < verkko.annaVerkko()[0].length; j++) {
                if (verkko.annaSolmu(i, j)!= null){
                    keko.syota(verkko.annaSolmu(i, j));
                }                
            }
        }       
        
        while (keko.annaPienin() != null) {
            solmu = keko.poistaJaAnnaPienin();
            if (solmu.onMaali()){
                solmu = verkko.annaLahto();
                while (!solmu.onMaali()){                    
                    solmu = solmu.annaReitti();
                }
            }
            naapuri = verkko.annaSolmu(solmu.annaX() - 1, solmu.annaY());
            if (naapuri != null) {
                this.tarkistaOnkoNopeampi(solmu, naapuri);              
            }
            naapuri = verkko.annaSolmu(solmu.annaX() + 1, solmu.annaY());
            if (naapuri != null) {
                this.tarkistaOnkoNopeampi(solmu, naapuri);           
            }
            naapuri = verkko.annaSolmu(solmu.annaX(), solmu.annaY() - 1);
            if (naapuri != null) {
                this.tarkistaOnkoNopeampi(solmu, naapuri);              
            }
            naapuri = verkko.annaSolmu(solmu.annaX(), solmu.annaY() + 1);
            if (naapuri != null) {
                this.tarkistaOnkoNopeampi(solmu, naapuri);            
            }
        }
        return null;
    }
    
    public Verkko luoVerkko(char[][] maasto) {
        Verkko uusiverkko = new Verkko();
        Solmu[][] solmutaulu = new Solmu[maasto.length][maasto[0].length];
        
        for (int i = 0; i < maasto.length; i++) {
            for (int j = 0; j < maasto[i].length; j++) {
                Solmu uusi = new Solmu(0, 0);
                if (Character.isDigit(maasto[i][j])) {
                    uusi.asetaVaativuus((int) maasto[i][j]);
                    
                } else {
                    
                    switch (maasto[i][j]) {
                        case '.':
                            uusi.asetaVaativuus(1);
                            break;
                        case 'A':
                            uusi.asetaVaativuus(5);
                            break;
                        case 'T':
                            uusi.asetaVaativuus(4);
                            break;
                        case '~':
                            uusi.asetaVaativuus(4);
                            break;
                        case 'X':                            
                            uusi.asetaVaativuus(0);
                            uusi.teeMaaliksi();
                            break;
                        case 'L':
                            uusi.asetaVaativuus(0);                            
                            uusiverkko.asetaLahto(uusi);
                    }
                }
                
                solmutaulu[i][j] = uusi;
            }
            uusiverkko.asetaVerkko(solmutaulu);
        }
        return uusiverkko;
    }
    
    public Solmu[][] luoReittikartta(int[][] maasto) {
        Solmu[][] reittikartta = new Solmu[maasto.length][maasto[0].length];
        for (int i = 0; i < maasto.length; i++) {
            for (int j = 0; j < maasto[i].length; j++) {
                reittikartta[i][j] = new Solmu(i, j);
                
            }
        }
        return reittikartta;
    }
    
    public void tarkistaOnkoNopeampi(Solmu a, Solmu b) {
        if (a.annaEtaisyys() > b.annaEtaisyys()) {
            a.asetaEtaisyys(b.annaEtaisyys());
            a.asetaReitti(b);
        }
    }
}
