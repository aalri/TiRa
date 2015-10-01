package tira.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Riku
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    
/**
 * Luokka muodostaa käyttöliittymän
 *
 * @author Riku
 *
 */

    public Kayttoliittyma() {
    }

    @Override
    public void run() {
        frame = new JFrame("TiRa - Harjoitustyö");
        frame.setPreferredSize(new Dimension(544, 612));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.setBackground(Color.LIGHT_GRAY);
        container.setLayout(new GroupLayout(container));
        JTextField tiedostosyotealue = new JTextField("tiedoston nimi tähän (esim. maasto.txt)");
        JButton luoReittiNappi = new JButton("Luo reitti.");
        JTextArea reittimaasto = new JTextArea();        
        
        String[] algoritmit = {"Astar", "Bellmann-Ford"};

        JComboBox algoritmilista = new JComboBox(algoritmit);
        algoritmilista.setToolTipText("Valitse käytettävä algoritmi.");
        algoritmilista.setSelectedIndex(0);
        
        JTextArea valitsealgoritmi = new JTextArea("Valitse algoritmi:");
        valitsealgoritmi.setBackground(Color.LIGHT_GRAY);
        valitsealgoritmi.setEditable(false);
        
        LuoReitti luoreitti = new LuoReitti(tiedostosyotealue, reittimaasto, algoritmilista, container, frame);
        luoReittiNappi.addActionListener(luoreitti);
        

        container.add(luoReittiNappi);
        container.add(tiedostosyotealue);
        container.add(algoritmilista);
        container.add(reittimaasto);
        container.add(valitsealgoritmi);

        algoritmilista.setBounds(50, 40, 400, 25);
        tiedostosyotealue.setBounds(50, 70, 400, 25);
        luoReittiNappi.setBounds(50, 100, 400, 50);
        valitsealgoritmi.setBounds(50, 20, 400, 25);

    }

    public JFrame getFrame() {
        return frame;
    }
}
