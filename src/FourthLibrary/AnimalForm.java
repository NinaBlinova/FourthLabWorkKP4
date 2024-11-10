package FourthLibrary;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class AnimalForm {
    public JPanel contentPane;
    public JPanel animalAction;
    private JButton falconButton;
    private JButton hareButton;
    private JButton dolphinButton;
    private Point point;
    private Falcon falcon;
    private ArrayList<Falcon> falcons;
    private double x, y;



    public AnimalForm() {
        // Инициализация Spring
        animalAction.setLayout(new BorderLayout()); // Установите нужный LayoutManager
        animalAction.setPreferredSize(new Dimension(600, 600));
        createUIComponents();


    }

    private void createUIComponents() {
        GraphicPanel graphicPanel = new GraphicPanel();
        graphicPanel.setPreferredSize(new Dimension(600, 600));
        graphicPanel.setWorldCoords(-100, 100, -100, 100);
        animalAction.add(graphicPanel, BorderLayout.CENTER);
    }
}