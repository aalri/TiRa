
package tira.algoritmi;

import junit.framework.TestCase;
import tira.tietorakenteet.Minimikeko;
import tira.verkko.Solmu;
import tira.verkko.Verkko;
import tira.verkko.Verkkotoiminnot;

/**
 *
 * @author Riku
 */
public class AstarTest extends TestCase {
    Astar a = new Astar();
    Verkko v;
    Minimikeko k = new Minimikeko();
    char[][] t = {{'L','.'},{'.','X'}};
    
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
}
