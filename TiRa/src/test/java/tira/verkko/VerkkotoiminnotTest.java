package tira.verkko;

import junit.framework.TestCase;

/**
 *
 * @author Riku
 */
public class VerkkotoiminnotTest extends TestCase {

    Verkkotoiminnot a = new Verkkotoiminnot();
    char[][] t = new char[1][1];
    Verkko v;

    public void testLuoVerkko() {

        this.t[0][0] = '.';
        this.v = Verkkotoiminnot.luoVerkko(t);
        assertEquals(1, v.annaSolmu(0, 0).annaVaativuus());

        this.t[0][0] = 'A';
        this.v = Verkkotoiminnot.luoVerkko(t);
        assertEquals(5, v.annaSolmu(0, 0).annaVaativuus());

        this.t[0][0] = 'T';
        this.v = Verkkotoiminnot.luoVerkko(t);
        assertEquals(3, v.annaSolmu(0, 0).annaVaativuus());

        this.t[0][0] = '~';
        this.v = Verkkotoiminnot.luoVerkko(t);
        assertEquals(4, v.annaSolmu(0, 0).annaVaativuus());

        this.t[0][0] = 'X';
        this.v = Verkkotoiminnot.luoVerkko(t);
        assertEquals(true, v.annaSolmu(0, 0).onMaali());
        assertEquals(1, v.annaSolmu(0, 0).annaVaativuus());

        this.t[0][0] = 'L';
        this.v = Verkkotoiminnot.luoVerkko(t);
        assertEquals(1, v.annaSolmu(0, 0).annaVaativuus());

        this.t[0][0] = '#';
        this.v = Verkkotoiminnot.luoVerkko(t);
        assertEquals(false, v.annaSolmu(0, 0).annaKuljettava());
        assertEquals(0, v.annaSolmu(0, 0).annaVaativuus());

        for (int i = 0; i < 10; i++) {
            this.t[0][0] = Character.forDigit(i, 10);
            this.v = Verkkotoiminnot.luoVerkko(t);
            assertEquals(i, v.annaSolmu(0, 0).annaVaativuus());
        }
    }

    public void testEtaisyydenAsettamistaMaalista() {
        char[][] t2 = {{'L', '.', '.'},
                       {'.', '.', 'X'},
                       {'.', '.', '.'}
                       };
        this.v = Verkkotoiminnot.luoVerkko(t2);
        Verkkotoiminnot.teeEtaisyydetMaalista(v);
        
        assertEquals(1, this.v.annaSolmu(2, 2).annaEtaisyysMaalista());
        assertEquals(2, this.v.annaSolmu(0, 1).annaEtaisyysMaalista());
        assertEquals(3, this.v.annaSolmu(0, 0).annaEtaisyysMaalista());        
    }
    
    public void testEiOleSolmuja(){
        this.t[0][0] = '.';
        this.v = Verkkotoiminnot.luoVerkko(t);
        
        assertEquals(null, this.v.annaSolmu(-1,0));
        assertEquals(null, this.v.annaSolmu( 0,-1));
        assertEquals(null, this.v.annaSolmu(-1,-1));
        assertEquals(null, this.v.annaSolmu( 1,0));
        assertEquals(null, this.v.annaSolmu( 0,1));
        assertEquals(null, this.v.annaSolmu( 1,1));
    }
}
