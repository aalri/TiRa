
package tira.algoritmi;

import tira.verkko.Solmu;

/**
 *
 * @author Riku
 */
public class Astar {
    public char[][] etsiLyhin(char[][] maasto){
        
        return null;
    }
    
    public int[][] luoReittikartta(int[][] maasto){
        int[][] reittikartta = new int[maasto.length][maasto[0].length];
        for (int i = 0; i < maasto.length; i++) {
            for (int j = 0; j < maasto[i].length; j++) {
            reittikartta[i][j] = Integer.MAX_VALUE;
            }
        }
        return reittikartta;
    }
    
    public void tarkistaOnkoNopeampi(Solmu y, Solmu x){
        if (y.annaEtaisyys() > x.annaEtaisyys()){
            y.asetaEtaisyys(x.annaEtaisyys());
            y.asetaReitti(x);
        }
    }
}
