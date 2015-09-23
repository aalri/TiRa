package tira.domain;

import junit.framework.TestCase;
import tira.verkko.Solmu;

/**
 *
 * @author Riku
 */
public class PolunetsijaTest extends TestCase {

    Polunetsija p = new Polunetsija();

    public void testEtsiPolku1() {
        char[][] maasto = {{'L', '#', 'X'},
        {'.', '#', '.'},
        {'.', '.', '.'}};

        maasto = p.etsiPolku(maasto);

        String haluttu = "L#X\n"
                + "O#O\n"
                + "OOO\n";

        assertEquals(haluttu, p.tulostaMaasto(maasto));

    }

    public void testEtsiPolku2() {
        char[][] maasto = {{'T', 'A', '8'},
        {'~', '#', '9'},
        {'X', '#', 'L'}};

        maasto = p.etsiPolku(maasto);

        String haluttu = "OOO\n"
                + "O#O\n"
                + "X#L\n";

        assertEquals(haluttu, p.tulostaMaasto(maasto));

    }

    public void testEtsiPolku3() {
        char[][] maasto = {{'T', 'A', 'L'},
        {'~', '#', '#'},
        {'.', '.', 'X'}};

        maasto = p.etsiPolku(maasto);

        String haluttu = "OOL\n"
                + "O##\n"
                + "OOX\n";

        assertEquals(haluttu, p.tulostaMaasto(maasto));

    }

    public void testEtsiPolku4() {
        char[][] maasto = {{'X', 'A', 'T'},
        {'#', '#', '.'},
        {'L', '.', '.'}};

        maasto = p.etsiPolku(maasto);

        String haluttu = "XOO\n"
                + "##O\n"
                + "LOO\n";

        assertEquals(haluttu, p.tulostaMaasto(maasto));

    }

    public void testEtsiPolku5() {
        char[][] maasto = {{'.', '.', '.', '.', '.', '.', '.', '.', '.', '2', '.', 'X'},
        {'.', '.', '.', '.', '.', '.', '.', '.', '.', 'A', '.', 'A'},
        {'.', '.', '.', '.', '.', '.', '.', '.', '.', 'A', '.', '.'},
        {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', 'A', '.'},
        {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', 'A', '.'},
        {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', 'A', '.'},
        {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', 'A', '.'},
        {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', 'A', '.'},
        {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', 'A', '.'},
        {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', 'A', '.'},
        {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', 'A', '.'},
        {'L', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},};

        maasto = p.etsiPolku(maasto);

        String haluttu = "......OOOOOX\n"
                + "......O..A.A\n"
                + ".....OO..A..\n"
                + ".....O....A.\n"
                + ".....O....A.\n"
                + ".....O....A.\n"
                + ".....O....A.\n"
                + ".....O....A.\n"
                + "OOOOOO....A.\n"
                + "O.........A.\n"
                + "O.........A.\n"
                + "L...........\n";

        assertEquals(haluttu, p.tulostaMaasto(maasto));

    }

    public void testEtsiPolkuTyhja() {
        char[][] maasto = {{}};

        maasto = p.etsiPolku(maasto);

        assertEquals("\n", p.tulostaMaasto(maasto));

    }
    
    public void testEtaisyysarvot() {
        
        Solmu a = new Solmu(0, 0);
        Solmu b = new Solmu(0, 1);
        Solmu c = new Solmu(1, 0);
        Solmu d = new Solmu(1, 1);
        
        a.asetaEtaisyys(2);
        d.asetaEtaisyys(4);
     
        Solmu[][] solmuverkko = {{a, b},
                                 {c, d}};
      

        assertEquals("2, #, \n"
                   + "#, 4, \n", p.tulostaEtaisyydet(solmuverkko));

    }

}
