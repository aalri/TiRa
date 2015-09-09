package tira.verkko;

import junit.framework.TestCase;

/**
 *
 * @author Riku
 */
public class SolmuTest extends TestCase {

    private Solmu solmu;

    public void testSolmuEtaisyys() {
        this.solmu = new Solmu(1, 1);
        for (int i = 0; i < 10; i++) {
            this.solmu.asetaEtaisyys(i);
            assertEquals(i, this.solmu.etaisyys);
            assertEquals(i, this.solmu.annaEtaisyys());

        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                this.solmu.asetaVaativuus(j);
                this.solmu.asetaEtaisyys(i);
                assertEquals(j, this.solmu.vaativuus);
                assertEquals(i + j, this.solmu.etaisyys);
                assertEquals(i + j, this.solmu.annaEtaisyys());
            }
        }
    }

    public void testSolmuVaativuus() {
        this.solmu = new Solmu(1, 1);
        for (int i = 0; i < 10; i++) {
            this.solmu.asetaVaativuus(i);
            assertEquals(i, this.solmu.vaativuus);
            assertEquals(i, this.solmu.annaVaativuus());

        }
    }

    public void testSolmuReitti() {
        this.solmu = new Solmu(1, 1);
        Solmu uusisolmu = new Solmu(0, 1);
        this.solmu.asetaReitti(uusisolmu);
        assertEquals(uusisolmu, this.solmu.annaReitti());
    }

    public void testSolmuXY() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                this.solmu = new Solmu(i, j);
                assertEquals(i, this.solmu.annaX());
                assertEquals(j, this.solmu.annaY());
            }
        }
    }

    public void testSolmuMaali() {
        this.solmu = new Solmu(1, 1);
        assertEquals(false, this.solmu.onMaali());
        this.solmu.teeMaaliksi();
        assertEquals(true, this.solmu.onMaali());
    }

    public void testPaikkaKeossa() {
        this.solmu = new Solmu(1, 1);
        for (int i = 0; i < 10; i++) {
            this.solmu.asetaPaikkaKeossa(i);
            assertEquals(i, this.solmu.paikkakeossa);
            assertEquals(i, this.solmu.annaPaikkaKeossa());

        }
    }
}
