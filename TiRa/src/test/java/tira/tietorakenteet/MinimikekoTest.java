
package tira.tietorakenteet;

import junit.framework.TestCase;
import tira.verkko.Solmu;
import tira.verkko.Verkko;
import tira.verkko.Verkkotoiminnot;

/**
 *
 * @author Riku
 */
public class MinimikekoTest extends TestCase{
    
    Minimikeko keko = new Minimikeko();
    
    public void testMinimikeko(){
        int a = 7;
        int b = 3;
        int c = 20;
        int d = 2;
        int e = 4;
        
        Solmu sa = new Solmu(1,1);
        sa.asetaEtaisyys(a);
        Solmu sb = new Solmu(1,1);
        sb.asetaEtaisyys(b);
        Solmu sc = new Solmu(1,1);
        sc.asetaEtaisyys(c);
        Solmu sd = new Solmu(1,1);
        sd.asetaEtaisyys(d);
        Solmu se = new Solmu(1,1);
        se.asetaEtaisyys(e);
        
        this.keko.syota(sa);
        this.keko.syota(sb);
        this.keko.syota(sc);
        this.keko.syota(sd);
        this.keko.syota(se);
        
        assertEquals(1,sd.annaPaikkaKeossa());
        assertEquals(2,sb.annaPaikkaKeossa());
        assertEquals(5,se.annaPaikkaKeossa());
        assertEquals(4,sa.annaPaikkaKeossa());
        assertEquals(3,sc.annaPaikkaKeossa());
        
        assertEquals("Keko: 2, 3, 20, 7, 4, " ,this.keko.tulostaKeko());
        assertEquals("Paikat: 12345" ,this.keko.tulostaPaikat());
        
        assertEquals(sd,this.keko.annaPienin());
        assertEquals(d,this.keko.annaPienin().annaEtaisyys());
        
        assertEquals(sd,this.keko.poistaJaAnnaPienin());
        
        assertEquals(1,sb.annaPaikkaKeossa());
        assertEquals(2,se.annaPaikkaKeossa());
        assertEquals(4,sa.annaPaikkaKeossa());
        assertEquals(3,sc.annaPaikkaKeossa());
        
        assertEquals(sb,this.keko.poistaJaAnnaPienin());
        
        assertEquals(1,se.annaPaikkaKeossa());
        assertEquals(2,sa.annaPaikkaKeossa());
        assertEquals(3,sc.annaPaikkaKeossa());
        
        assertEquals(se,this.keko.poistaJaAnnaPienin());
        
        assertEquals(1,sa.annaPaikkaKeossa());
        assertEquals(2,sc.annaPaikkaKeossa());
        
        assertEquals(sa,this.keko.poistaJaAnnaPienin());
        
        assertEquals(1,sc.annaPaikkaKeossa());
        
        assertEquals(sc,this.keko.poistaJaAnnaPienin());
        
        assertEquals(null,this.keko.annaPienin());
        assertEquals(null,this.keko.poistaJaAnnaPienin());        
    }
    
    public void testOikea(){
        for (int i = 0; i < 10; i++) {
            assertEquals(i*2+1,this.keko.oikea(i));
        }        
        
    }
    
    public void testKeotaOikea(){
        Solmu sa = new Solmu(1,1);
        Solmu sb = new Solmu(1,1);
        Solmu sc = new Solmu(1,1);
        
        sa.asetaEtaisyys(1);
        sb.asetaEtaisyys(2);
        sc.asetaEtaisyys(3);
        
        this.keko.syota(sa);
        this.keko.syota(sb);
        this.keko.syota(sc);
        
        sa.asetaEtaisyys(7);
        sb.asetaEtaisyys(3);
        sc.asetaEtaisyys(2);  
        
        this.keko.keota(1);
        
        assertEquals(sb,this.keko.keko[2]);
        assertEquals(sa,this.keko.keko[3]);
        assertEquals(sc,this.keko.keko[1]);
    }
    
    public void testKeotaVasenSama(){
        Solmu sa = new Solmu(1,1);
        Solmu sb = new Solmu(1,1);
        Solmu sc = new Solmu(1,1);
        
        sa.asetaEtaisyys(1);
        sb.asetaEtaisyys(2);
        sc.asetaEtaisyys(3);
        
        this.keko.syota(sa);
        this.keko.syota(sb);
        this.keko.syota(sc);
        
        sa.asetaEtaisyys(7);
        sb.asetaEtaisyys(7);
        sc.asetaEtaisyys(2);  
        
        this.keko.keota(1);
        
        assertEquals(sb,this.keko.keko[2]);
        assertEquals(sa,this.keko.keko[3]);
        assertEquals(sc,this.keko.keko[1]);
    }
    
    public void testKeotaMolemmatSama(){
        Solmu sa = new Solmu(1,1);
        Solmu sb = new Solmu(1,1);
        Solmu sc = new Solmu(1,1);
        
        sa.asetaEtaisyys(1);
        sb.asetaEtaisyys(2);
        sc.asetaEtaisyys(3);
        
        this.keko.syota(sa);
        this.keko.syota(sb);
        this.keko.syota(sc);
        
        sa.asetaEtaisyys(7);
        sb.asetaEtaisyys(7);
        sc.asetaEtaisyys(7);  
        
        this.keko.keota(1);
        
        assertEquals(sb,this.keko.keko[2]);
        assertEquals(sa,this.keko.keko[1]);
        assertEquals(sc,this.keko.keko[3]);
    }
    
    public void testKeotaEiMuutosta(){
        Solmu sa = new Solmu(1,1);
        Solmu sb = new Solmu(1,1);
        Solmu sc = new Solmu(1,1);
        
        sa.asetaEtaisyys(1);
        sb.asetaEtaisyys(2);
        sc.asetaEtaisyys(3);
        
        this.keko.syota(sa);
        this.keko.syota(sb);
        this.keko.syota(sc);        
        
        this.keko.keota(1);
        
        assertEquals(sb,this.keko.keko[2]);
        assertEquals(sa,this.keko.keko[1]);
        assertEquals(sc,this.keko.keko[3]);
    }
    
    
    public void testKeotaVasen(){
        Solmu sa = new Solmu(1,1);
        Solmu sb = new Solmu(1,1);
        Solmu sc = new Solmu(1,1);
        Solmu sd = new Solmu(1,1);
        Solmu se = new Solmu(1,1);
        
        sa.asetaEtaisyys(1);
        sb.asetaEtaisyys(2);
        sc.asetaEtaisyys(3);
        
        this.keko.syota(sa);
        this.keko.syota(sb);
        this.keko.syota(sc);
        
        sa.asetaEtaisyys(7);
        sb.asetaEtaisyys(2);
        sc.asetaEtaisyys(3);  
        
        this.keko.keota(1);
        
        assertEquals(sb,this.keko.keko[1]);
        assertEquals(sa,this.keko.keko[2]);
        assertEquals(sc,this.keko.keko[3]);
        
        sa.asetaEtaisyys(7);
        sb.asetaEtaisyys(2);
        sc.asetaEtaisyys(1);    
        
        this.keko.keota(1);
        
        assertEquals(sb,this.keko.keko[3]);
        assertEquals(sa,this.keko.keko[2]);
        assertEquals(sc,this.keko.keko[1]);       
        
        this.keko.keota(1);
        
        sd.asetaEtaisyys(5);
        se.asetaEtaisyys(6);
        
        this.keko.syota(sd);
        this.keko.syota(se);
        
        sc.asetaEtaisyys(20);
        
        this.keko.keota(1);
        
        assertEquals(sa,this.keko.keko[4]);
        assertEquals(sb,this.keko.keko[1]);
        assertEquals(sc,this.keko.keko[3]);
        assertEquals(sd,this.keko.keko[2]);
        assertEquals(se,this.keko.keko[5]);
    }
    
    
    public void testVahennaSolmunEtaisyyttaKeossaSamallaJaSuuremmallaArvolla(){
        Solmu sa = new Solmu(1,1);
        Solmu sb = new Solmu(1,1);
        
        sa.asetaEtaisyys(4);
        sb.asetaVaativuus(2);
        sb.asetaEtaisyys(6);
        
        this.keko.syota(sa);
        this.keko.syota(sb);       
        
        this.keko.vahennaSolmunEtaisyyttaKeossa(sb, 4);
        assertEquals(6, sb.annaEtaisyys());
        assertEquals(sb,this.keko.keko[2]);
        assertEquals(sa,this.keko.keko[1]);
        
        this.keko.vahennaSolmunEtaisyyttaKeossa(sb, 5);
        assertEquals(6, sb.annaEtaisyys());
        assertEquals(sb,this.keko.keko[2]);
        assertEquals(sa,this.keko.keko[1]);
    }
    
    public void testVahennaSolmunEtaisyyttaKeossaVasen(){
        Solmu sa = new Solmu(1,1);
        Solmu sb = new Solmu(1,1);
        Solmu sc = new Solmu(1,1);
        
        sa.asetaEtaisyys(4);
        sb.asetaEtaisyys(6);
        sc.asetaEtaisyys(7);
        
        this.keko.syota(sa);
        this.keko.syota(sb);
        this.keko.syota(sc);        
        
        this.keko.vahennaSolmunEtaisyyttaKeossa(sb, 3);
        assertEquals(3, sb.annaEtaisyys());
        assertEquals(sb,this.keko.keko[1]);
        assertEquals(sa,this.keko.keko[2]);
        assertEquals(sc,this.keko.keko[3]);
    }
    
    public void testVahennaSolmunEtaisyyttaKeossaOikea(){
        Solmu sa = new Solmu(1,1);
        Solmu sb = new Solmu(1,1);
        Solmu sc = new Solmu(1,1);
        
        sa.asetaEtaisyys(4);
        sb.asetaEtaisyys(6);
        sc.asetaEtaisyys(7);
        
        this.keko.syota(sa);
        this.keko.syota(sb);
        this.keko.syota(sc);        
        
        this.keko.vahennaSolmunEtaisyyttaKeossa(sc, 3);
        
        assertEquals(sb,this.keko.keko[2]);
        assertEquals(sa,this.keko.keko[3]);
        assertEquals(sc,this.keko.keko[1]);
    }
    
        
}
