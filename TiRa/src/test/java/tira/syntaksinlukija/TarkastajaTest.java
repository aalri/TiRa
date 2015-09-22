package tira.syntaksinlukija;

import junit.framework.TestCase;

/**
 *
 * @author Riku
 */
public class TarkastajaTest extends TestCase {

    Tarkastaja t = new Tarkastaja();
    
    public void testEiNeliollinen() {
        String teksti = "L.\n"
                      + "...\n"
                      + "A#X\n";
        assertEquals(false, this.t.Tarkista(teksti));
        assertEquals(true, this.t.annaVirhe().equals("Merkkijonon pituuden pitää olla sama kuin rivien määrän, jolloin sivut ovat yhtä pitkiä.\nKorvaa tyhjät '#' merkillä!"));
        
    }
    
    public void testEiNeliollinen2() {
        String teksti = "L..\n"
                      + "...\n"
                      + "...\n"
                      + "A#X\n";
        assertEquals(false, this.t.Tarkista(teksti));
        assertEquals(true, this.t.annaVirhe().equals("Merkkijonon pituuden pitää olla sama kuin rivien määrän, jolloin sivut ovat yhtä pitkiä.\nKorvaa tyhjät '#' merkillä!"));
        
    }

    public void testMaalinPuuttuminen() {
        String teksti = "L..\n"
                + "...\n"
                + "A##\n";
        assertEquals(false, this.t.Tarkista(teksti));
        assertEquals(true, this.t.annaVirhe().equals("Merkeistä pitää löytyä tasan yksi maali ('X')!"));
        
    }
    
    public void testLahdonPuuttuminen() {
        String teksti = "X..\n"
                + "...\n"
                + "A##\n";
        assertEquals(false, this.t.Tarkista(teksti));
        assertEquals(true, this.t.annaVirhe().equals("Merkeistä pitää löytyä tasan yksi lähtö ('L')!"));
    }
    
    public void testLiikaaLahtoja() {
        String teksti = "X..\n"
                + "LL.\n"
                + "A##\n";
        assertEquals(false, this.t.Tarkista(teksti));
        assertEquals(true, this.t.annaVirhe().equals("Merkeistä pitää löytyä tasan yksi lähtö ('L')!"));
    }
    
    public void testLiikaaMaaleja() {
        String teksti = "L..\n"
                + ".XX\n"
                + "A##\n";
        assertEquals(false, this.t.Tarkista(teksti));
        assertEquals(true, this.t.annaVirhe().equals("Merkeistä pitää löytyä tasan yksi maali ('X')!"));
        
    }
    
    public void testHyvaksyttava() {
        String teksti = "X..\n"
                + "...\n"
                + "A#L\n";
        assertEquals(true, this.t.Tarkista(teksti));
    }
}
