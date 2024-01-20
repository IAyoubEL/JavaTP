package EX1; 

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class Telephone extends Frame implements ActionListener {

    private TextField champSaisie;
    private String chiffres = "";

    public Telephone(String titre) {
        super(titre);

        champSaisie = new TextField();
        Panel panneauClavier = creerClavier();

        setLayout(new BorderLayout());
        //GridBagConstraints constraints = new GridBagConstraints();

       
        
        champSaisie.setPreferredSize(new Dimension(250, 60));
        //constraints.gridx = 0;
        //constraints.gridy = 0;
        add(champSaisie,BorderLayout.NORTH);

        //constraints.gridy = 1;
        add(panneauClavier,BorderLayout.CENTER);

        addWindowListener(new FermerFenetre());
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    
private Panel creerClavier() {
        Panel panneau = new Panel(new GridLayout(4, 3));

        for (int i = 1; i <= 9; i++) {
            Button bouton = new Button(Integer.toString(i));
            bouton.setPreferredSize(new Dimension(80, 80));
            bouton.addActionListener(this);
            panneau.add(bouton);
        }

        Button boutonBis = new Button("Bis");
        boutonBis.setPreferredSize(new Dimension(80, 80));
        boutonBis.addActionListener(this);

        Button boutonZero = new Button("0");
        boutonZero.setPreferredSize(new Dimension(80, 80));
        boutonZero.addActionListener(this);

        Button boutonReset = new Button("reset");
        boutonReset.setPreferredSize(new Dimension(80, 80));
        boutonReset.addActionListener(this);

        panneau.add(boutonBis);
        panneau.add(boutonZero);
        panneau.add(boutonReset);

        return panneau;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String libelle = ((Button) e.getSource()).getLabel().toLowerCase();

        switch (libelle) {
            case "bis":
                if (!chiffres.isEmpty()) {
                    champSaisie.setText(chiffres);
                }
                break;
            case "reset":
                chiffres = champSaisie.getText();
                champSaisie.setText("");
                break;
            default:
                champSaisie.setText(champSaisie.getText() + libelle);
                break;
        }
    }


    class FermerFenetre extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Telephone("IPhone XX Pro Max");
    }
}