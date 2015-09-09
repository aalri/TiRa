package tira.tietorakenteet;

import tira.verkko.Solmu;
import tira.verkko.Verkko;

/**
 *
 * @author Riku
 */
public class Minimikeko {

    Solmu[] keko;
    int koko;
    int kaytettykoko;

    public Minimikeko() {
        this.keko = new Solmu[254];
        this.koko = 0;
        this.kaytettykoko = 0;
    }

    public void syota(Solmu i) {
        this.kaytettykoko++;
        int nykyinenpaikka = this.kaytettykoko;
        while (nykyinenpaikka > 1 && i.annaEtaisyys() < this.palautaVanhemmanArvo(nykyinenpaikka)) {
            this.keko[nykyinenpaikka] = this.keko[this.vanhempi(nykyinenpaikka)];
            this.keko[this.vanhempi(nykyinenpaikka)].asetaPaikkaKeossa(nykyinenpaikka);
            nykyinenpaikka = this.vanhempi(nykyinenpaikka);            

        }
        this.keko[nykyinenpaikka] = i;
        i.asetaPaikkaKeossa(nykyinenpaikka);
    }
    
    public void syotaKaikki(Verkko verkko){
        for (int i = 0; i < verkko.annaVerkko().length; i++) {
            for (int j = 0; j < verkko.annaVerkko()[0].length; j++) {
                if (verkko.annaSolmu(i, j).annaKuljettava()) {
                    this.syota(verkko.annaSolmu(i, j));
                }
            }
        }
    }

    public Solmu annaPienin() {
        if (this.kaytettykoko > 0) {
            return this.keko[1];
        }
        return null;
    }

    public String tulostaKeko() {
        int i = 1;
        String tulos = "Keko: ";
        while (i <= this.kaytettykoko) {
            tulos = tulos + this.keko[i].annaEtaisyys() + ", ";
            i++;
        }
        return tulos;
    }
    
    public String tulostaPaikat() {
        int i = 1;
        String tulos = "Paikat: ";
        while (i <= this.kaytettykoko) {
            tulos = tulos + this.keko[i].annaPaikkaKeossa();
            i++;
        }
        return tulos;
    }

    public Solmu poistaJaAnnaPienin() {
        if (this.kaytettykoko > 0) {
            Solmu pienin = this.keko[1];
            this.keko[this.kaytettykoko].asetaPaikkaKeossa(1);
            this.keko[1] = this.keko[this.kaytettykoko];
            this.kaytettykoko--;
            this.keota(1);
            return pienin;
        }
        return null;
    }

    public int vanhempi(int paikka) {
        return (int) Math.floor(paikka / 2);
    }

    public int palautaVanhemmanArvo(int nykyinenpaikka) {
        int vanhemmanarvo = -1;
        if (this.keko[this.vanhempi(nykyinenpaikka)] != null) {
            vanhemmanarvo = this.keko[this.vanhempi(nykyinenpaikka)].annaEtaisyys();
        }
        return vanhemmanarvo;
    }

    public int vasen(int paikka) {
        return paikka * 2;
    }

    public int oikea(int paikka) {
        return paikka * 2 + 1;
    }

    public void vaihda(int a, int b) {
        Solmu vaihdettava = this.keko[a];
        int i = this.keko[a].annaPaikkaKeossa();

        this.keko[a].asetaPaikkaKeossa(this.keko[b].annaPaikkaKeossa());
        this.keko[b].asetaPaikkaKeossa(i);

        this.keko[a] = this.keko[b];
        this.keko[b] = vaihdettava;
    }

    public void keota(int i) {
        int v = vasen(i);
        int o = oikea(i);
        int pienin;

        if (o <= this.kaytettykoko) {
            if (this.keko[v].annaEtaisyys() < this.keko[o].annaEtaisyys()) {
                pienin = v;
            } else {
                pienin = o;
            }
            if (this.keko[i].annaEtaisyys() > this.keko[pienin].annaEtaisyys()) {
                this.vaihda(i, pienin);
                this.keota(pienin);
            }
        } else if (v == this.kaytettykoko && this.keko[i].annaEtaisyys() > this.keko[v].annaEtaisyys()) {
            this.vaihda(i, v);
        }

    }
    
    public void vahennaSolmunEtaisyyttaKeossa(Solmu solmu, int etaisyys){
       if (etaisyys + solmu.annaVaativuus() < solmu.annaEtaisyys()){
           solmu.asetaEtaisyys(etaisyys);
           int paikka = solmu.annaPaikkaKeossa();
           while(paikka > 1 && etaisyys < this.keko[this.vanhempi(paikka)].annaEtaisyys()){
               this.vaihda(paikka, this.vanhempi(paikka));
               paikka = this.vanhempi(paikka);
           }
       }
    }
}
