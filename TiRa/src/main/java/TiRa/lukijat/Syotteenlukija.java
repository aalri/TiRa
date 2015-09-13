
package tira.lukijat;

import java.util.Scanner;

/**
 *
 * @author Riku
 */
public class Syotteenlukija {
    
    Scanner lukija;    
    
    public char[][] muutaMaastoksi(String teksti){    
        lukija = new Scanner(teksti);     
        String rivi = lukija.nextLine();
        char[][] maasto = new char[rivi.length()][rivi.length()];
        int i = 0;
        int j = 0;        
        while(lukija.hasNextLine()){
            if (i != 0){
               rivi = lukija.nextLine(); 
            }            
            while(!rivi.isEmpty()){
                maasto[i][j] = rivi.charAt(0);
                rivi = rivi.substring(1);
                j++;
            }
            j = 0;
            i++;            
        }
        return maasto;
    }
    
    public boolean annetaanTiedosto(){        
        System.out.println("Annat tiedoston? (y/n): ");
        this.lukija = new Scanner(System.in);
        if (this.lukija.nextLine().equals("y")){
            return true;
        }
        return false;
    }
    
    public String annaTiedostonPaikka(){
        System.out.println("Anna paikka (*.txt): ");
        this.lukija = new Scanner(System.in);
        String paikka = this.lukija.nextLine();
        while (!paikka.endsWith(".txt")){
            System.out.println("Ei Kelpaa!");
            System.out.println("Anna paikka (*.txt): ");
            paikka = this.lukija.nextLine();
        }
        
        return paikka;
    }
    
}
