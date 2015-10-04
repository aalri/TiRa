package tira.verkko;

/**
 *
 * @author Riku
 */
public class Verkkotoiminnot {

    /**
     * Metodi luo verkon maastosta tekemällä solmun, mikä vastaa jokaista
     * merkkiä.
     *
     * @param maasto merkeistä tehty taulukko, mikä kuvastaa maaston muotoja.
     *
     * @return Verkko joka sisältää kaikki maaston merkeistä tehdyt solmut,
     * lähtösolmun ja maalisolmun.
     */
    public static Verkko luoVerkko(char[][] maasto) {
        Verkko uusiverkko = new Verkko();
        Solmu[][] solmutaulu = new Solmu[maasto.length][maasto[0].length];

        for (int i = 0; i < maasto.length; i++) {
            for (int j = 0; j < maasto[i].length; j++) {
                Solmu uusi = new Solmu(i, j);
                if (Character.isDigit(maasto[i][j])&& maasto[i][j] != 0) {
                    uusi.asetaVaativuus(Integer.parseInt(String.valueOf(maasto[i][j])));

                } else {

                    switch (maasto[i][j]) {
                        case '.':
                            uusi.asetaVaativuus(1);
                            break;
                        case 'A':
                            uusi.asetaVaativuus(5);
                            break;
                        case 'T':
                            uusi.asetaVaativuus(3);
                            break;
                        case '~':
                            uusi.asetaVaativuus(4);
                            break;
                        case '-':
                            uusi.asetaVaativuus(-1);
                            break;
                        case 'X':
                            uusi.teeMaaliksi();
                            uusiverkko.asetaMaali(uusi);
                            uusi.asetaVaativuus(1);
                            break;
                        case 'L':
                            uusiverkko.asetaLahto(uusi);
                            uusi.asetaVaativuus(1);
                            break;
                        case '#':
                            uusi.asetaEiKuljettavaksi();
                    }
                }

                solmutaulu[i][j] = uusi;
            }
            uusiverkko.asetaVerkko(solmutaulu);
        }

        return uusiverkko;
    }
    
    /**
     * Metodi asettaa verkon jokaiselle solmulle etäisyydet maalista.
     *
     * @param verkko joka sisältää kaikki maaston merkeistä tehdyt solmut,
     * lähtösolmun ja maalisolmun.
     *
     */

    public static void teeEtaisyydetMaalista(Verkko verkko) {
        Solmu maali = verkko.annaMaali();
        for (int i = 0; i < verkko.annaVerkko().length; i++) {
            for (int j = 0; j < verkko.annaVerkko()[0].length; j++) {
                Solmu s = verkko.annaSolmu(i, j);
                if (s != null) {
                    s.asetaEtaisyysMaalista(Math.abs(s.annaX() - maali.annaX()) + Math.abs(s.annaY() - maali.annaY()));
                }
            }
        }

    }

}
