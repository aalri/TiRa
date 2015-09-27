
package tira.algoritmi;

import junit.framework.TestCase;
import tira.tietorakenteet.Minimikeko;
import tira.verkko.Solmu;

/**
 *
 * @author Riku
 */
public class AstarTest extends TestCase {
    Astar a = new Astar();
    Minimikeko k = new Minimikeko();
    
    public void testTarkistaOnkoNopeampiTasaArvoisina(){
        Solmu sa = new Solmu(1,1);
        Solmu sb = new Solmu(1,2);
        
        sa.asetaEtaisyys(5);
        sb.asetaEtaisyys(5);
        k.syota(sa);
        k.syota(sb);
        
        
        this.a.tarkistaOnkoNopeampi(sa, sb, k);
        assertEquals(null, sb.annaReitti());
    }    
    
    public void testAnnaNimi(){
        assertEquals("Astar", a.annaNimi());
    } 
    
}
