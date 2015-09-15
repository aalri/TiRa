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
     * @return Verkko joka sisältää kaikki maaston merkeistä tehdyt solmut, ja
     * lähtösolmun.
     */
    public static Verkko luoVerkko(char[][] maasto) {
        Verkko uusiverkko = new Verkko();
        Solmu[][] solmutaulu = new Solmu[maasto.length][maasto[0].length];
        Solmu maali = null;

        for (int i = 0; i < maasto.length; i++) {
            for (int j = 0; j < maasto[i].length; j++) {
                Solmu uusi = new Solmu(i, j);
                if (Character.isDigit(maasto[i][j])) {
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
                            uusi.asetaVaativuus(4);
                            break;
                        case '~':
                            uusi.asetaVaativuus(4);
                            break;
                        case 'X':
                            uusi.teeMaaliksi();
                            maali = uusi;
                            break;
                        case 'L':
                            uusiverkko.asetaLahto(uusi);
                            break;
                        case '#':
                            uusi.asetaEiKuljettavaksi();
                    }
                }

                solmutaulu[i][j] = uusi;
            }
            uusiverkko.asetaVerkko(solmutaulu);
        }

        for (int i = 0; i < maasto.length; i++) {
            for (int j = 0; j < maasto[0].length; j++) {
                Solmu s = uusiverkko.annaSolmu(i, j);
                if (s != null && maali != null){
                s.asetaEtaisyysMaalista(Math.abs(s.annaX() - maali.annaX()) + Math.abs(s.annaY() - maali.annaY()));
                }
            }
        }
        
        
        return uusiverkko;
    }
        
}
