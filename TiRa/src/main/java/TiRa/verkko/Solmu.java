package tira.verkko;

/**
 * Luokka esittää verkon solmuja.
 * @author Riku
 */
public class Solmu {
    int x;
    int y;
    int etaisyys;
    int etaisyysmaalista;
    int vaativuus;
    int paikkakeossa;    
    boolean maali;
    boolean kuljettava;    
    Solmu reitti;
    
    public Solmu(int x, int y){
        this.x = x;
        this.y = y;
        this.kuljettava = true;
        this.etaisyys = Integer.MAX_VALUE;
        this.maali = false;
        this.paikkakeossa = -1;
        this.vaativuus = 0;
        this.etaisyysmaalista = 0;
        
    }                
    
    public void asetaEtaisyys(int e){
        this.etaisyys = e;
    }
    
    
    
    public int annaEtaisyys(){
        if (this.etaisyys == Integer.MAX_VALUE){
            return this.etaisyys;
        }
        return this.etaisyys + this.vaativuus + this.etaisyysmaalista;
    }
    
    public int annaTodellinenEtaisyys(){
        if (this.etaisyys == Integer.MAX_VALUE){
            return this.etaisyys;
        }
        return this.etaisyys + this.vaativuus;
    }
    
    public void asetaEtaisyysMaalista(int e){
        this.etaisyysmaalista = e;
    }
    public int annaEtaisyysMaalista(){
        return this.etaisyysmaalista;
    }    
    public void asetaVaativuus(int vaativuus){
        this.vaativuus = vaativuus;
    }
    public int annaVaativuus(){
        return this.vaativuus;
    }
    public void asetaReitti(Solmu r){
        this.reitti = r;
    }
    
    public Solmu annaReitti(){
        return this.reitti;
    }
    
    public void teeMaaliksi(){
        this.maali = true;
    }
    
    public int annaX(){
        return this.x;
    }
    
    public int annaY(){
        return this.y;
    }
    
    public void asetaPaikkaKeossa(int i){
        this.paikkakeossa = i;
    }
    
    public int annaPaikkaKeossa(){
        return this.paikkakeossa;
    }
    
    public boolean onMaali(){
        return this.maali;
    }
    
    public void asetaEiKuljettavaksi(){
        this.kuljettava = false;
    }
    
    public boolean annaKuljettava(){
        return this.kuljettava;
    }
    
}
