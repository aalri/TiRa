
package tira.verkko;

/**
 *
 * @author Riku
 */
public class Verkkotoiminnot {
    
    public static Verkko luoVerkko(char[][] maasto) {
        Verkko uusiverkko = new Verkko();        
        Solmu[][] solmutaulu = new Solmu[maasto.length][maasto[0].length];

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
        return uusiverkko;
    }
}
