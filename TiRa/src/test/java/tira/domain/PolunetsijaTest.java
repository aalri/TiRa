package tira.domain;

import junit.framework.TestCase;
import tira.algoritmi.Algoritmi;
import tira.algoritmi.Astar;
import tira.algoritmi.Bellmanford;
import tira.verkko.Solmu;

/**
 *
 * @author Riku
 */
public class PolunetsijaTest extends TestCase {

    Polunetsija p = new Polunetsija();
    Algoritmi a = new Astar();
    Algoritmi b = new Bellmanford();

    public void testEtsiPolku1() {
        p.asetaAlgoritmi(a);
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
        p.asetaAlgoritmi(a);
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
        p.asetaAlgoritmi(a);
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
        p.asetaAlgoritmi(a);
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
        p.asetaAlgoritmi(a);
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
    
    public void testEtsiPolkuVirhe() {
        p.asetaAlgoritmi(a);
        char[][] maasto = {{'X', 'A', 'T'},
        {'#', '#', '.'},
        {'L', '#', '.'}};

        maasto = p.etsiPolku(maasto);



        assertEquals(null, maasto);
        assertEquals("Reittiä ei löydetty!", a.virhe());

    }
    
    public void testEtsiPolkuVirheB1() {
        p.asetaAlgoritmi(b);
        char[][] maasto = {{'X', 'A', 'T'},
        {'#', '#', '.'},
        {'L', '#', '.'}};

        maasto = p.etsiPolku(maasto);



        assertEquals(null, maasto);
        assertEquals("Reittiä ei löydetty!", b.virhe());

    }
    
    public void testEtsiPolkuVirheB2() {
        p.asetaAlgoritmi(b);
        char[][] maasto = {{'X', 'A', 'T'},
        {'#', '#', '.'},
        {'L', '-', '-'}};

        maasto = p.etsiPolku(maasto);
        


        assertEquals(null, maasto);
        assertEquals("Maastosta löytyi negatiivinen sykli.", b.virhe());

    }

    public void testEtsiPolkuTyhja() {
        p.asetaAlgoritmi(a);
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

    public void testEtsiPolku1B() {
        p.asetaAlgoritmi(b);
        char[][] maasto = {{'L', '#', 'X'},
        {'.', '#', '.'},
        {'.', '.', '.'}};

        maasto = p.etsiPolku(maasto);

        String haluttu = "L#X\n"
                + "O#O\n"
                + "OOO\n";

        assertEquals(haluttu, p.tulostaMaasto(maasto));

    }

    public void testEtsiPolku2B() {
        p.asetaAlgoritmi(b);
        char[][] maasto = {{'T', 'A', '8'},
        {'~', '#', '9'},
        {'X', '#', 'L'}};

        maasto = p.etsiPolku(maasto);

        String haluttu = "OOO\n"
                + "O#O\n"
                + "X#L\n";

        assertEquals(haluttu, p.tulostaMaasto(maasto));

    }

    public void testEtsiPolku3B() {
        p.asetaAlgoritmi(b);
        char[][] maasto = {{'T', 'A', 'L'},
        {'~', '#', '#'},
        {'.', '.', 'X'}};

        maasto = p.etsiPolku(maasto);

        String haluttu = "OOL\n"
                + "O##\n"
                + "OOX\n";

        assertEquals(haluttu, p.tulostaMaasto(maasto));

    }

    public void testEtsiPolku4B() {
        p.asetaAlgoritmi(b);
        char[][] maasto = {{'X', 'A', 'T'},
        {'#', '#', '.'},
        {'L', '.', '.'}};

        maasto = p.etsiPolku(maasto);

        String haluttu = "XOO\n"
                + "##O\n"
                + "LOO\n";

        assertEquals(haluttu, p.tulostaMaasto(maasto));

    }

    public void testEtsiPolku5B() {
        p.asetaAlgoritmi(b);
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

        String haluttu = "........OOOX\n"
                + "........OA.A\n"
                + "........OA..\n"
                + "........O.A.\n"
                + "........O.A.\n"
                + "........O.A.\n"
                + "........O.A.\n"
                + "........O.A.\n"
                + "........O.A.\n"
                + "........O.A.\n"
                + "........O.A.\n"
                + "LOOOOOOOO...\n";

        assertEquals(haluttu, p.tulostaMaasto(maasto));

    }

    public void testEtsiPolkuTyhjaB() {
        p.asetaAlgoritmi(b);
        char[][] maasto = {{}};

        maasto = p.etsiPolku(maasto);

        assertEquals("\n", p.tulostaMaasto(maasto));

    }

}
