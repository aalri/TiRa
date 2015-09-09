package tira.domain;

import junit.framework.TestCase;

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

        String haluttu = "L#O\n"
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
                + "O#L\n";

        assertEquals(haluttu, p.tulostaMaasto(maasto));

    }

    public void testEtsiPolku3() {
        char[][] maasto = {{'T', 'A', 'L'},
        {'~', '#', '#'},
        {'.', '.', 'X'}};

        maasto = p.etsiPolku(maasto);

        String haluttu = "OOL\n"
                + "O##\n"
                + "OOO\n";

        assertEquals(haluttu, p.tulostaMaasto(maasto));

    }

    public void testEtsiPolku4() {
        char[][] maasto = {{'X', 'A', 'T'},
        {'#', '#', '.'},
        {'L', '.', '.'}};

        maasto = p.etsiPolku(maasto);

        String haluttu = "OOO\n"
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

        String haluttu = ".......OOOOO\n"
                + ".......O.A.A\n"
                + ".....OOO.A..\n"
                + "OOOOOO....A.\n"
                + "O.........A.\n"
                + "O.........A.\n"
                + "O.........A.\n"
                + "O.........A.\n"
                + "O.........A.\n"
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
}
