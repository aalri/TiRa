package tira.syntaksinlukija;

import junit.framework.TestCase;
import tira.algoritmi.Algoritmi;
import tira.algoritmi.Astar;

/**
 *
 * @author Riku
 */
public class TarkastajaTest extends TestCase {

    Tarkastaja t = new Tarkastaja();
    Algoritmi a = new Astar();
    
    public void testEiNeliollinen() {
        String teksti = "L.\n"
                      + "...\n"
                      + "A#X\n";
        assertEquals(false, this.t.Tarkista(teksti, a));
        assertEquals(true, this.t.annaVirhe().equals("Merkkijonon pituuden pitää olla sama kuin rivien määrän, jolloin sivut ovat yhtä pitkiä."));
        
    }
    
    public void testEiNeliollinen2() {
        String teksti = "L..\n"
                      + "...\n"
                      + "...\n"
                      + "A#X\n";
        assertEquals(false, this.t.Tarkista(teksti, a));
        assertEquals(true, this.t.annaVirhe().equals("Merkkijonon pituuden pitää olla sama kuin rivien määrän, jolloin sivut ovat yhtä pitkiä."));
        
    }

    public void testMaalinPuuttuminen() {
        String teksti = "L..\n"
                + "...\n"
                + "A##\n";
        assertEquals(false, this.t.Tarkista(teksti, a));
        assertEquals(true, this.t.annaVirhe().equals("Merkeistä pitää löytyä tasan yksi maali ('X')!"));
        
    }
    
    public void testLahdonPuuttuminen() {
        String teksti = "X..\n"
                + "...\n"
                + "A##\n";
        assertEquals(false, this.t.Tarkista(teksti, a));
        assertEquals(true, this.t.annaVirhe().equals("Merkeistä pitää löytyä tasan yksi lähtö ('L')!"));
    }
    
    public void testLiikaaLahtoja() {
        String teksti = "X..\n"
                + "LL.\n"
                + "A##\n";
        assertEquals(false, this.t.Tarkista(teksti, a));
        assertEquals(true, this.t.annaVirhe().equals("Merkeistä pitää löytyä tasan yksi lähtö ('L')!"));
    }
    
    public void testLiikaaMaaleja() {
        String teksti = "L..\n"
                + ".XX\n"
                + "A##\n";
        assertEquals(false, this.t.Tarkista(teksti, a));
        assertEquals(true, this.t.annaVirhe().equals("Merkeistä pitää löytyä tasan yksi maali ('X')!"));
        
    }
    
    public void testNegatiivinenMaasto() {
        String teksti = "L-.\n"
                + "..X\n"
                + "A##\n";
        assertEquals(false, this.t.Tarkista(teksti, a));
        assertEquals(true, this.t.annaVirhe().equals("Astar algoritmia ei voida käyttää maastossa missä on negatiivisia vaativuuksia!"));
        
    }
    
    public void testVaariaMerkkeja() {
        String teksti = "L-O\n"
                + "..X\n"
                + "A##\n";
        assertEquals(false, this.t.Tarkista(teksti, a));
        assertEquals(true, this.t.annaVirhe().equals("Merkeistä löytyi sinne kuulumattomia merkkejä! Korvaa tyhjät '#' merkillä!"));
        
    }
    
    public void testHyvaksyttava() {
        String teksti = "X..\n"
                + "...\n"
                + "A#L\n";
        assertEquals(true, this.t.Tarkista(teksti, a));
    }
}
