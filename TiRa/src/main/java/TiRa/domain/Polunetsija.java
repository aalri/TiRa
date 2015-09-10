
package tira.domain;

import tira.algoritmi.Astar;
import tira.verkko.Solmu;
import tira.verkko.Verkko;
import tira.verkko.Verkkotoiminnot;

/**
 * Luokka kirjaa lyhimmän polun maastoon.
 * 
 * @author Riku
 * 
 */
public class Polunetsija {
    
    
/**
 * Metodi laittaa Astar luokan etsimään lyhimmän polun lähdöstä maaliin syntaksia vastaavasta merkeistä tehdystä maastosta.
 * Tämän jälkeen kirjaa polun maastoon ja palauttaa sen.
 *
 * @param   maasto merkeistä tehty taulukko, mikä kuvastaa maaston muotoja.
 * 
 * @return maasto, mihin on kirjattu lyhin polku.
 */
    
    public char[][] etsiPolku(char[][] maasto){
        Astar astar = new Astar();
        Verkko verkko = Verkkotoiminnot.luoVerkko(maasto);
        Solmu solmu = astar.etsiLyhin(verkko);      
        while (solmu != verkko.annaLahto()){
            maasto[solmu.annaX()][solmu.annaY()] = 'O';
            solmu = solmu.annaReitti();            
        }       
        return maasto;
    }
    
/**
 * Metodi muuntaa maasto taulukon merkkijonoksi ja palauttaa sen.
 *
 * @param   maasto merkeistä tehty taulukko, mikä kuvastaa maaston muotoja.
 * 
 * @return merkkijono joka vastaa maastoa.
 */
    
    
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
