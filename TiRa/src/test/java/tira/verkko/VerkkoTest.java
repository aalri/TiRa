package tira.verkko;

import junit.framework.TestCase;

/**
 *
 * @author Riku
 */
public class VerkkoTest extends TestCase {

    Verkko verkko = new Verkko();

    public void testVerkkoVerkko() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Solmu[][] v = new Solmu[i][j];
                this.verkko.asetaVerkko(v);
                assertEquals(v, this.verkko.annaVerkko());
            }
        }

    }

    public void testVerkkoLahto() {
        Solmu s = new Solmu(1, 1);
        this.verkko.asetaLahto(s);
        assertEquals(s, this.verkko.annaLahto());
    }

    public void testVerkkoSolmu() {
        Solmu[][] v = new Solmu[10][10];
        this.verkko.asetaVerkko(v);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                v[i][j] = new Solmu(i, j);
                assertEquals(v[i][j], this.verkko.annaSolmu(i, j));
            }
        }
        assertEquals(null, this.verkko.annaSolmu(-1, -1));
        assertEquals(null, this.verkko.annaSolmu(-1, 3));
        assertEquals(null, this.verkko.annaSolmu( 3, -1));
        assertEquals(null, this.verkko.annaSolmu(10, 10));
        assertEquals(null, this.verkko.annaSolmu(10, 9));
        assertEquals(null, this.verkko.annaSolmu(9, 10));
        assertEquals(null, this.verkko.annaSolmu(-1, 10));
        assertEquals(null, this.verkko.annaSolmu(10, -1));
    }
}
