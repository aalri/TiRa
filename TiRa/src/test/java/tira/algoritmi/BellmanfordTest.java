
package tira.algoritmi;

import junit.framework.TestCase;
import tira.verkko.Solmu;
import tira.verkko.Verkko;
import tira.verkko.Verkkotoiminnot;

/**
 *
 * @author Riku
 */
public class BellmanfordTest extends TestCase {
    Bellmanford b = new Bellmanford();
    
    public void testTarkistaOnkoNopeampiTasaArvoisina(){
        Solmu sa = new Solmu(1,1);
        Solmu sb = new Solmu(1,2);
        
        sa.asetaEtaisyys(5);
        sb.asetaEtaisyys(5);
        
        
        
        this.b.tarkistaOnkoNopeampi(sa, sb);
        assertEquals(null, sb.annaReitti());
    }    
    
    public void testNegatiivinenSykli(){
        char[][] maasto = {{'X', 'A', 'T'},
        {'#', '#', '.'},
        {'L', '-', '-'}};
        Verkko verkko = Verkkotoiminnot.luoVerkko(maasto);
        
        b.etsiLyhin(verkko);
        
        assertEquals(true, this.b.negatiivinenSykli(verkko));
        
        char[][] maasto2 = {{'X', 'A', 'T'},
        {'#', '#', '.'},
        {'L', '#', '-'}};
        
        verkko = Verkkotoiminnot.luoVerkko(maasto2);
        
        b.etsiLyhin(verkko);
        
        assertEquals(true, this.b.negatiivinenSykli(verkko));
        
        char[][] maasto3 = {{'X', '.', '.'},
        {'#', '#', '.'},
        {'L', '.', '.'}};
        
        verkko = Verkkotoiminnot.luoVerkko(maasto3);
        
        b.etsiLyhin(verkko);
        
        assertEquals(false, this.b.negatiivinenSykli(verkko));
        
        char[][] maasto4 = {{'X', '#', '#', '#'},
        {'.', '.', '.', '.'},
        {'#', '#', '#', '.'},
        {'L', '.', '.', '.'}};
        
        verkko = Verkkotoiminnot.luoVerkko(maasto4);
        
        b.etsiLyhin(verkko);
        
        assertEquals(false, this.b.negatiivinenSykli(verkko));
    }    
    
    public void testAnnaNimi(){
        assertEquals("BellmanFord", b.annaNimi());
    } 
}
