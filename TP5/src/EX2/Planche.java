package EX2;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Map;

public class Planche {
    private static final java.util.List<String> SHAPES = List.of("Rectangle", "Ellipse", "Ligne");
    private static final Map<String, Color> COLORS = Map.of("Noir", Color.BLACK, "Bleu", Color.BLUE, "Vert", Color.GREEN, "Rouge", Color.RED, "Jaune", Color.YELLOW, "Orange", Color.ORANGE);
    private Dessin dessin;

    public Planche() {
        Frame frame = new Frame("Planche");
        
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Fichier");
        MenuItem menuItem1 = new MenuItem("Fin");
        menuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(menuItem1);
        menuBar.add(menu);
        frame.setMenuBar(menuBar);
        
        
        Panel panel = new Panel();

        Choice shapes = new Choice();
        for(String shape : SHAPES) {
        	shapes.add(shape);
        }
        shapes.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                dessin.setShape(shapes.getSelectedItem());
            }
        });
        panel.add(shapes);

        CheckboxGroup colors = new CheckboxGroup();
        Panel colorPanel = new Panel(new GridLayout(COLORS.size()/4 +1, 4));
        for (Map.Entry<String,Color> entry : COLORS.entrySet()) 
        {
        	Checkbox checkbox = new Checkbox(entry.getKey());
            checkbox.setCheckboxGroup(colors);
            checkbox.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    dessin.setColor(COLORS.get(colors.getSelectedCheckbox().getLabel()));
                }
            });
            if (entry.getKey().equals("Noir")) checkbox.setState(true);
            colorPanel.add(checkbox);
        }

        panel.add(colorPanel);

        Checkbox fill = new Checkbox("Remplissage");
        fill.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                dessin.setFill(fill.getState());
            }
        });
        panel.add(fill);
        
        frame.add(BorderLayout.SOUTH, panel);
        
        
        this.dessin = new Dessin();
        frame.add(BorderLayout.CENTER, this.dessin);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.setSize(500, 500);
        frame.setLocation(500, 150);
        frame.setVisible(true);
    }



    public static void main(String[] args) {
        new Planche();
    }
}
