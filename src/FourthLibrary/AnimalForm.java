package FourthLibrary;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AnimalForm {
    public JPanel contentPane;
    public JPanel animalAction;
    private JButton falconButton;
    private JButton hareButton;
    private JButton dolphinButton;
    private JButton startButton;
    private Data data;


    public AnimalForm() {
        // Инициализация Spring
        animalAction.setLayout(new BorderLayout()); // Установите нужный LayoutManager
        animalAction.setPreferredSize(new Dimension(600, 600));
        data = new Data();

        falconButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = "Falcon";
                double x = Math.random() * 10;
                double y = Math.random() * 500;
                addAnimal(name, x, y);
                //System.out.println(data);
            }
        });

        hareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = "Hare";
                double x = Math.random() * 10;
                double y = Math.random() * 500;
                addAnimal(name, x, y);
            }
        });

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createUIComponents();
                //System.out.println(data);
            }
        });
    }

    private void createUIComponents() {
        GraphicPanel graphicPanel = new GraphicPanel(data);
        graphicPanel.setPreferredSize(new Dimension(600, 600));
        graphicPanel.setWorldCoords(-10, 10, -300, 300);
        animalAction.add(graphicPanel, BorderLayout.CENTER);
        animalAction.revalidate();
        animalAction.repaint();
    }

    private void addAnimal(String name, double x, double y) {
        if (name == "Falcon") {
            Falcon newFalcon = new Falcon(name, 0, 0);
            data.addAnimal(newFalcon);
        } else if (name == "Hare") {
            Hare newHare = new Hare(name, 0, 0);
            data.addAnimal(newHare);
        }

    }
}