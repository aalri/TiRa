
package tira.verkko;

/**
 *
 * @author Riku
 */
public class Solmu {
    int x;
    int y;
    int etaisyys;
    Solmu reitti;
    
    public Solmu(int x, int y){
        this.x = x;
        this.y = y;
        this.etaisyys = Integer.MAX_VALUE;
    }
    
    public void asetaEtaisyys(int e){
        this.etaisyys = e;
    }
    public int annaEtaisyys(){
        return this.etaisyys;
    }
    public void asetaReitti(Solmu r){
        this.reitti = r;
    }
    
    public Solmu annaReitti(){
        return this.reitti;
    }
    
    
}
