package cz.czechitas.ukol6;


import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Aplikace extends JFrame {

    int Husy;
    int Králíci;


    private JLabel HusyLabel;
    private JLabel KrálíciLabel;
    private JLabel Počet_hlavLabel;
    private JLabel Počet_nohouLabel;
    private JTextField HusyField;
    private JTextField KrálíciField;
    private JTextField Počet_hlavField;
    private JTextField Počet_nohouField;

    private JButton VypočítatButton;


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
        HusyField = new JTextField();
        HusyLabel = new JLabel("Husy");
        HusyLabel.setDisplayedMnemonic('H');
        HusyLabel.setLabelFor(HusyField);
        add(HusyLabel);
        add(HusyField);

        KrálíciField = new JTextField();
        KrálíciLabel = new JLabel("Králíci");
        KrálíciLabel.setDisplayedMnemonic('K');
        KrálíciLabel.setLabelFor(KrálíciField);
        add(KrálíciLabel);
        add(KrálíciField);

        add(createButtonBar(), "span");

        Počet_hlavField = new JTextField();
        Počet_hlavField.setEnabled(false);
        Počet_hlavLabel = new JLabel("Počet hlav");
        Počet_hlavLabel.setLabelFor(Počet_hlavField);
        add(Počet_hlavLabel);
        add(Počet_hlavField);

        Počet_nohouField = new JTextField();
        Počet_nohouField.setEnabled(false);
        Počet_nohouLabel = new JLabel("Počet nohou");
        Počet_nohouLabel.setLabelFor(Počet_nohouField);
        add(Počet_nohouLabel);
        add(Počet_nohouField);

        pack();

        VypočítatButton.addActionListener(this::handleVypočítat);
    }

    private JPanel createButtonBar() {
        VypočítatButton = new JButton("Vypočítat");
        VypočítatButton.setMnemonic('V');

        JPanel buttonBar = new JPanel(new MigLayout(null, "[right, grow]"));
        buttonBar.add(VypočítatButton);
        return buttonBar;
    }

    private void handleVypočítat(ActionEvent actionEvent) {
        String husyFieldText = HusyField.getText();
        Husy = Integer.valueOf(husyFieldText);
        String králíciFieldText = KrálíciField.getText();
        Králíci = Integer.valueOf(králíciFieldText);
        int pocetHlav = Husy + Králíci;
        int pocetNoh = (Husy * 2) + (Králíci * 4);
        Počet_hlavField.setText(Integer.toString(pocetHlav));
        Počet_nohouField.setText(Integer.toString(pocetNoh));
    }
}
