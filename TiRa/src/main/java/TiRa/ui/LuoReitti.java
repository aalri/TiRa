package tira.ui;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import tira.algoritmi.Algoritmi;
import tira.domain.Polunetsija;
import tira.lukijat.Syotteenlukija;
import tira.lukijat.Tiedostonlukija;
import tira.syntaksinlukija.Tarkastaja;

/**
 * Luokka muodostaa luo reitti painikkeen toiminnallisuuden
 *
 * @author Riku
 *
 */
public class LuoReitti implements ActionListener {

    private JTextField syoteAlue;
    private JFrame frame;
    private JTextArea ilmoitus;
    private Container container;
    private JTextArea reittimaasto;
    private JComboBox algoritmilista;

    public LuoReitti(JTextField syoteAlue, JTextArea reittimaasto, JComboBox algoritmilista, Container container, JFrame frame) {

        this.syoteAlue = syoteAlue;
        this.container = container;
        this.frame = frame;
        this.ilmoitus = new JTextArea();
        this.reittimaasto = reittimaasto;
        this.algoritmilista = algoritmilista;
    }

    /**
     * 
     * Luo Polunetsijan sekä Tarkastajan, ja antaa niille käyttöliittymään asetetut arvot. 
     *  Arvot muokataan sopiviksi tiedostonlukijan ja syotteenlukijan avulla.
     *  Tämän jälkeen palauttaa Polunetsijan/Tarkastajan tuloksen käyttöliittymään.
     *
     */
    @Override
    public void actionPerformed(ActionEvent ae) {

        Tiedostonlukija tiedostonlukija = new Tiedostonlukija();
        Syotteenlukija syotteenlukija = new Syotteenlukija();

        String syote = this.syoteAlue.getText();

        syote = tiedostonlukija.lueTiedosto(syote);

        Algoritmi algoritmi = syotteenlukija.annaUIAlgoritmi(this.algoritmilista.getSelectedIndex());

        Tarkastaja tarkastaja = new Tarkastaja();

        this.container.remove(this.ilmoitus);

        if (tarkastaja.Tarkista(syote, algoritmi)) {

            Polunetsija polunetsija = new Polunetsija();
            polunetsija.asetaAlgoritmi(algoritmi);

            char[][] maasto = syotteenlukija.muutaMaastoksi(syote);

            maasto = polunetsija.etsiPolku(maasto);

            if (maasto != null) {
                this.container.remove(this.reittimaasto);
                this.reittimaasto = new JTextArea(polunetsija.tulostaMaasto(maasto));
                this.reittimaasto.setFont(new Font("monospaced", Font.PLAIN, 18));

                this.container.add(this.reittimaasto);

                this.reittimaasto.setBounds(50, 200, 12 * maasto.length, maasto[0].length * 26);
                this.reittimaasto.setEditable(false);

                ilmoita("Algoritmiin kului aikaa: " + polunetsija.annaKulunutAika() + "ms.");
                if (maasto.length < 12) {
                    this.frame.setBounds(this.frame.getX(), this.frame.getY(), 544, 612);
                } else {
                    this.frame.setBounds(this.frame.getX(), this.frame.getY(), 400 + 12 * maasto.length, 300 + 26 * maasto[0].length);
                }
                this.frame.repaint();

            } else {
                ilmoita(algoritmi.virhe());
            }

            this.frame.repaint();
        } else {
            ilmoita(tarkastaja.annaVirhe());
        }
    }
    
    /**
     * 
     * Luo ilmoitus ikkunan tekstillä käyttöliittymän sisältöön.
     * 
     * @param ilmoitus ilmoitettava teksti.
     */

    public void ilmoita(String ilmoitus) {
        this.ilmoitus = new JTextArea(ilmoitus);
        this.container.add(this.ilmoitus);
        this.ilmoitus.setBounds(50, 160, 400, 30);
        this.ilmoitus.setEditable(false);
        this.frame.repaint();
    }
}
