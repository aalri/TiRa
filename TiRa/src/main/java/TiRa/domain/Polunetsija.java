
package tira.domain;

import tira.algoritmi.Astar;
import tira.verkko.Solmu;
import tira.verkko.Verkko;

/**
 *
 * @author Riku
 */
public class Polunetsija {
    
    
    
    
    public char[][] etsiPolku(char[][] maasto){
        Astar astar = new Astar();
        Verkko verkko = astar.luoVerkko(maasto);
        Solmu solmu = astar.etsiLyhin(verkko);      
        while (solmu != verkko.annaLahto()){
            maasto[solmu.annaX()][solmu.annaY()] = 'O';
            solmu = solmu.annaReitti();            
        }       
        return maasto;
    }
    
    public String tulostaMaasto(char[][] maasto){
        String tulos = "";
        for (int i = 0; i < maasto.length; i++) {
            for (int j = 0; j < maasto[0].length; j++) {
                tulos = tulos + maasto[i][j];
            }
            tulos = tulos + "\n";
        }
        return tulos;
    }
    
}
