package tira.tietorakenteet;

import tira.verkko.Solmu;
import tira.verkko.Verkko;

/**
 * Luokka esittää Minimikeko tietorakennetta, joka vertaa Solmujen etäisyyksiä
 * toisiinsa.
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

    /**
     * Metodi lisää Solmun keon loppuun ja vaihdatuttaa keon sisällä olevien
     * solmujen paikkaa mikäli syötetyn solmun etäisyys on pienempi kuin sitä
     * vanhempien.
     *
     * @param s Solmu, joka ollaan syöttämässä kekoon.
     *
     *
     */
    public void syota(Solmu s) {
        this.kaytettykoko++;
        int nykyinenpaikka = this.kaytettykoko;
        while (nykyinenpaikka > 1 && s.annaEtaisyys() < this.palautaVanhemmanArvo(nykyinenpaikka)) {
            this.keko[nykyinenpaikka] = this.keko[this.vanhempi(nykyinenpaikka)];
            this.keko[this.vanhempi(nykyinenpaikka)].asetaPaikkaKeossa(nykyinenpaikka);
            nykyinenpaikka = this.vanhempi(nykyinenpaikka);

        }
        this.keko[nykyinenpaikka] = s;
        s.asetaPaikkaKeossa(nykyinenpaikka);
    }

    /**
     * Metodi lisää verkon kaikki solmut kekoon suorittamalla metodia syota.
     *
     * @param verkko Verkko, joka sisältää solmuja joita ollaan syöttämässä
     * kekoon.
     *
     *
     */
    public void syotaKaikki(Verkko verkko) {
        for (int i = 0; i < verkko.annaVerkko().length; i++) {
            for (int j = 0; j < verkko.annaVerkko()[0].length; j++) {
                if (verkko.annaSolmu(i, j).annaKuljettava()) {
                    this.syota(verkko.annaSolmu(i, j));
                }
            }
        }
    }

    /**
     * Metodi palauttaa Solmun, jolla on pienin etäisyys. Eli palauttaa keon
     * juuren.
     *
     *
     *
     * @return Solmu, joka on keon juuressa.
     */
    public Solmu annaPienin() {
        if (this.kaytettykoko > 0) {
            return this.keko[1];
        }
        return null;
    }

    /**
     * Metodi palauttaa kaikki keon Solmujen sisältämät etäisyydet merkkijonona.
     *
     *
     *
     * @return Merkkijono, joka sisältää kaikki keon etäisyydet.
     */
    public String tulostaKeko() {
        int i = 1;
        String tulos = "Keko: ";
        while (i <= this.kaytettykoko) {
            tulos = tulos + this.keko[i].annaEtaisyys() + ", ";
            i++;
        }
        return tulos;
    }

    /**
     * Metodi palauttaa kaikki keon sisältämät Solmujen indeksiarvot
     * merkkijonona.
     *
     *
     *
     * @return Merkkijono, joka sisältää kaikki keon indeksipaikat.
     */
    public String tulostaPaikat() {
        int i = 1;
        String tulos = "Paikat: ";
        while (i <= this.kaytettykoko) {
            tulos = tulos + this.keko[i].annaPaikkaKeossa();
            i++;
        }
        return tulos;
    }

    /**
     * Metodi palauttaa Solmun, jolla on pienin etäisyys. Eli palauttaa keon
     * juuren. Tämän jälkeen siirtää keon viimeisen indeksissä olevan Solmun
     * juureen, poistaa viimeisen indeksin ja ryhtyy valuttaamaan tätä uutta
     * juuressa olevaa Solmua paikalleen.
     *
     *
     *
     * @return Solmu, joka oli keon juuressa.
     */
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

    /**
     * Metodi palautaa lapsen vanhemman.
     *
     *
     * @param paikka indeksi joka on lapsen.
     *
     * @return indeksin, joka on lapsen vanhemman.
     */
    public int vanhempi(int paikka) {
        return (int) Math.floor(paikka / 2);
    }

    /**
     * Metodi palautaa lapsen vanhemman etaisyyden.
     *
     *
     * @param nykyinenpaikka indeksi joka on lapsen.
     *
     * @return Solmun etaisyyden, joka on lapsen vanhemman.
     */
    public int palautaVanhemmanArvo(int nykyinenpaikka) {
        int vanhemmanarvo = -1;
        if (this.keko[this.vanhempi(nykyinenpaikka)] != null) {
            vanhemmanarvo = this.keko[this.vanhempi(nykyinenpaikka)].annaEtaisyys();
        }
        return vanhemmanarvo;
    }

    /**
     * Metodi palauttaa vanhemman vasemman lapsen.
     *
     *
     * @param paikka indeksi joka on vanhemman.
     *
     * @return indeksin, joka on vanhemman vasemman lapsen.
     */
    public int vasen(int paikka) {
        return paikka * 2;
    }

    /**
     * Metodi palauttaa vanhemman oikean lapsen.
     *
     *
     * @param paikka indeksi joka on vanhemman.
     *
     * @return indeksin, joka on vanhemman oikean lapsen.
     */
    public int oikea(int paikka) {
        return paikka * 2 + 1;
    }

    /**
     * Metodi vaihtaa keossa olevien Solmujen paikkaa keskenään, ja antaa näille
     * vaihdetut indeksiarvot.
     *
     *
     * @param a indeksi joka on ensimmäisen Solmun.
     * @param b indeksi joka on toisen Solmun.
     *
     *
     */
    public void vaihda(int a, int b) {
        Solmu vaihdettava = this.keko[a];
        int i = this.keko[a].annaPaikkaKeossa();

        this.keko[a].asetaPaikkaKeossa(this.keko[b].annaPaikkaKeossa());
        this.keko[b].asetaPaikkaKeossa(i);

        this.keko[a] = this.keko[b];
        this.keko[b] = vaihdettava;
    }

    /**
     * Metodi katsoo onko jompikumpi lapsista etäisyydeltään pienempi kuin itse
     * indeksissä oleva solmu, ja vaihtaa näiden paikkaa tarvittaessa ja jatkaa
     * siitä eteenpäin.
     *
     * @param i indeksi jossa olevan Solmun etäisyyttä selvitetään lapsiinsa.
     *
     */
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

    /**
     * Metodi vähentää solmun etaisyys arvoa, mikäli uusi arvo on pienempi ja
     * tarvittaessa siirtää sitä keossa vanhempiensa paikalle.
     *
     * @param solmu Solmu jonka etäisyys arvoa ja paikkaa keossa ollaan
     * muuttamassa.
     * @param etaisyys uusi arvo Solmussa olevan etaisyys arvon tilalle.
     */
    public void vahennaSolmunEtaisyyttaKeossa(Solmu solmu, int etaisyys) {
        if (etaisyys + solmu.annaVaativuus() < solmu.annaEtaisyys()) {
            solmu.asetaEtaisyys(etaisyys);
            int paikka = solmu.annaPaikkaKeossa();
            while (paikka > 1 && etaisyys < this.keko[this.vanhempi(paikka)].annaEtaisyys()) {
                this.vaihda(paikka, this.vanhempi(paikka));
                paikka = this.vanhempi(paikka);
            }
        }
    }
}
