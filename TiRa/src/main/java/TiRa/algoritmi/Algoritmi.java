
package tira.algoritmi;

import tira.verkko.Solmu;
import tira.verkko.Verkko;

/**
 *
 * @author Riku
 */
public interface Algoritmi {
    public Solmu etsiLyhin(Verkko verkko);
    public String virhe();
    public String annaNimi();
}
