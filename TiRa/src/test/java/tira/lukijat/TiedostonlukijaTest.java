package tira.lukijat;

import junit.framework.TestCase;

/**
 *
 * @author Riku
 */
public class TiedostonlukijaTest extends TestCase {

    Tiedostonlukija t = new Tiedostonlukija();

    public void testTiedostonlukija() {
        String teksti = this.t.lueTiedosto("src/test/test.txt");
        assertEquals(true, teksti.contentEquals("X..\n"
                + "...\n"
                + "L..\n"));
    }
    
    public void testTiedostonlukija2() {
        String teksti = this.t.lueTiedosto("src/test/minuaeioleolemassa.txt");
        assertEquals(null, teksti);
    }
}
