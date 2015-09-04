package tira.tietorakenteet;

import tira.verkko.Solmu;

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
        int vanhempi = 0;
        if (this.keko[this.vanhempi(nykyinenpaikka)] != null){
            vanhempi = this.keko[this.vanhempi(nykyinenpaikka)].annaEtaisyys();
        }
        while (nykyinenpaikka > 1 && i.annaEtaisyys() < vanhempi) {
            this.keko[nykyinenpaikka] = this.keko[this.vanhempi(nykyinenpaikka)];
            nykyinenpaikka = this.vanhempi(nykyinenpaikka);            
        }
        this.keko[nykyinenpaikka] = i;
    }

    public Solmu annaPienin() {
        if (this.kaytettykoko > 0){
        return this.keko[1];
        }
        return null;
    }

    public String tulostaKeko() {
        int i = 1;
        String tulos = "";
        while (i <= this.kaytettykoko) {
            tulos = tulos + this.keko[i].annaEtaisyys();
            i++;
        }
        return tulos;
    }

    public int poistaJaAnnaPienin() {
        if (this.kaytettykoko > 0){
        int pienin = this.keko[1].annaEtaisyys();
        this.keko[1] = this.keko[this.kaytettykoko];
        this.kaytettykoko--;
        this.keota(1);
        return pienin;
        }
        return 0;
    }

    public int vanhempi(int paikka) {
        return (int) Math.floor(paikka / 2);
    }

    public int vasen(int paikka) {
        return paikka * 2;
    }

    public int oikea(int paikka) {
        return paikka * 2 + 1;
    }

    public void vaihda(int a, int b) {
        Solmu vaihdettava = this.keko[a];
        this.keko[a] = this.keko[b];
        this.keko[b] = vaihdettava;
    }

    public void keota(int i) {
        int v = vasen(i);
        int o = oikea(i);
        int pienin;

        if (o <= this.kaytettykoko) {
            if (this.keko[i].annaEtaisyys() < this.keko[o].annaEtaisyys()) {
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
}
