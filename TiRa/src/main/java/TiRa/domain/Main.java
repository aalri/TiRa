
package tira.domain;

import tira.tietorakenteet.Minimikeko;
import tira.verkko.Solmu;

/**
 *
 * @author Riku
 */
public class Main {

    public static void main(String[] args) {
        
        Minimikeko k = new Minimikeko();
        Solmu a = new Solmu(1,1);        
        Solmu b = new Solmu(1,1);
        Solmu c = new Solmu(1,1);        
        Solmu d = new Solmu(1,1);      
        Solmu e = new Solmu(1,1);
        Solmu f = new Solmu(1,1);
        Solmu g = new Solmu(1,1);
        Solmu h = new Solmu(1,1);
        
        a.asetaEtaisyys(9);
        b.asetaEtaisyys(6);
        c.asetaEtaisyys(1);
        d.asetaEtaisyys(4);
        e.asetaEtaisyys(5);
        f.asetaEtaisyys(200);
        g.asetaEtaisyys(1);
        h.asetaEtaisyys(4);
        k.syota(a);
        System.out.println(k.tulostaKeko());
        k.syota(b);
        System.out.println(k.tulostaKeko());
        k.syota(c);
        System.out.println(k.tulostaKeko());
        k.syota(d);
        System.out.println(k.tulostaKeko());
        k.syota(e);
        System.out.println(k.tulostaKeko());
        k.syota(f);
        System.out.println(k.tulostaKeko());
        k.syota(g);
        System.out.println(k.tulostaKeko());
        k.syota(h);
        System.out.println(k.tulostaKeko());
        System.out.println(k.poistaJaAnnaPienin());
        System.out.println(k.poistaJaAnnaPienin());
        System.out.println(k.poistaJaAnnaPienin());
        System.out.println(k.poistaJaAnnaPienin());
        System.out.println(k.poistaJaAnnaPienin());
        System.out.println(k.poistaJaAnnaPienin());
        System.out.println(k.poistaJaAnnaPienin());
        System.out.println(k.poistaJaAnnaPienin());
        System.out.println(k.poistaJaAnnaPienin());
            
    }
    
}
