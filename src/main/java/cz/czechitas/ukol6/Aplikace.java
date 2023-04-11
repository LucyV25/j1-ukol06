package cz.czechitas.ukol6;


import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Aplikace extends JFrame {
    private JLabel husyLabel;
    private JLabel kraliciLabel;
    private JSpinner kraliciField;
    private JLabel pocetNohouLabel;
    private JLabel pocetHlavLabel;
    private JTextField pocetHlavField;
    private JTextField pocetNohouField;
    private JSpinner husyField;
    private JButton vypocitatButton;

    public static void main(String[] args) {
        FlatLightLaf.setup();
        new Aplikace().start();
    }

    public Aplikace() throws HeadlessException {
        super("Farmářka 1.0");
        this.init();
    }

    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Aplikace.class.getResource("czechitas-icon.png")).getImage());
        setLayout(new MigLayout("wrap 2", "[right]rel[50:120:150,grow,fill]"));
        setMinimumSize(new Dimension(250, 200));


        //TODO implementovat formulář podle zadání
        husyField = new JSpinner();
        husyLabel = new JLabel("Husy");
        husyLabel.setDisplayedMnemonic('H');
        husyLabel.setLabelFor(husyField);
        add(husyLabel);
        add(husyField);

        kraliciField = new JSpinner();
        kraliciLabel = new JLabel("Králíci");
        kraliciLabel.setDisplayedMnemonic('K');
        kraliciLabel.setLabelFor(kraliciField);
        add(kraliciLabel);
        add(kraliciField);

        add(createButtonBar(), "span");

        pocetHlavField = new JTextField();
        pocetHlavLabel = new JLabel("Počet hlav");
        pocetHlavLabel.setDisplayedMnemonic('P');
        pocetHlavLabel.setLabelFor(pocetHlavField);
        pocetHlavField.setEnabled(false);
        pocetHlavField.setHorizontalAlignment(JTextField.TRAILING);
        add(pocetHlavLabel);
        add(pocetHlavField);

        pocetNohouField = new JTextField();
        pocetNohouLabel = new JLabel("Počet nohou");
        pocetNohouLabel.setDisplayedMnemonic('P');
        pocetNohouLabel.setLabelFor(pocetNohouField);
        pocetNohouField.setEnabled(false);
        pocetNohouField.setHorizontalAlignment(JTextField.TRAILING);
        add(pocetNohouLabel);
        add(pocetNohouField);

        pack();
        vypocitatButton.addActionListener(this::handleVypocitat);
    }

    private JPanel createButtonBar() {
        vypocitatButton = new JButton("Vypočítat");
        vypocitatButton.setMnemonic('V');


        JPanel buttonBar = new JPanel(new MigLayout(null, "[right, grow]"));
        buttonBar.add(vypocitatButton);

        return buttonBar;
    }
    private void handleVypocitat(ActionEvent actionEvent) {
        int kralici = (Integer) kraliciField.getValue();
        int husy = (Integer) husyField.getValue();
        System.out.println("Pocet kraliku"+kralici);
        int pocetHlavCislo = kralici+husy;
        String pocetHlav = Integer.toString(pocetHlavCislo);
        pocetHlavField.setText(pocetHlav);

        int pocetNohouCislo = (kralici*4)+(husy*2);
        String pocetNohou = Integer.toString(pocetNohouCislo);
        pocetNohouField.setText(pocetNohou);


    }
}
