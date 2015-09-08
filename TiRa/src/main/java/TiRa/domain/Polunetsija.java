
package tira.domain;

import tira.algoritmi.Astar;
import tira.verkko.Verkko;

/**
 *
 * @author Riku
 */
public class Polunetsija {
    
    char[][] maasto;
    
    
    
    public char[][] etsiPolku(char[][] maasto){
        Astar astar = new Astar();
        Verkko verkko = astar.luoVerkko(maasto);
        astar.etsiLyhin(verkko);
        
        
        
        return null;
    }
}
