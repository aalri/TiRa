
package tira.verkko;

/**
 * Luokka esittää tietorakennetta verkko.
 * @author Riku
 */
public class Verkko {
    Solmu[][] verkko;
    Solmu lahto;
    Solmu maali;
    
    public Verkko(){  
    }
    public void asetaVerkko(Solmu[][] verkko){
        this.verkko = verkko;
    }
    public Solmu[][] annaVerkko(){
        return this.verkko;
    }
    public void asetaLahto(Solmu solmu){
        solmu.etaisyys = 0;
        this.lahto = solmu;
    }
    public Solmu annaLahto(){
        return this.lahto;
    }
    public void asetaMaali(Solmu solmu){
        this.maali = solmu;
    }
    public Solmu annaMaali(){
        return this.maali;
    }
    
    public Solmu annaSolmu(int x, int y){
        if (-1 < x && x < this.verkko.length && -1 < y && y < this.verkko[0].length){    
            return this.verkko[x][y]; 
        }
        return null;
    }
}
