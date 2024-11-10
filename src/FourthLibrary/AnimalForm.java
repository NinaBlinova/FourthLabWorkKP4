package FourthLibrary;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class AnimalForm {
    public JPanel contentPane;
    public JPanel animalAction;
    private JButton falconButton;
    private JButton hareButton;
    private JButton dolphinButton;
    private Data data;


    public AnimalForm() {
        // Инициализация Spring
        animalAction.setLayout(new BorderLayout()); // Установите нужный LayoutManager
        animalAction.setPreferredSize(new Dimension(600, 600));
        data = new Data();

        falconButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double x = Math.random() * 20; // Генерация X в диапазоне [0; 20)
                double y = Math.random() * 600; // Генерация Y в диапазоне [0; 600)
                addFalcon(x, y); // Добавляем сокола с положительными координатами
                createUIComponents();
                System.out.println(data);
            }
        });


    }

    private void createUIComponents() {
        GraphicPanel graphicPanel = new GraphicPanel(data);
        graphicPanel.setPreferredSize(new Dimension(600, 600));
        graphicPanel.setWorldCoords(-10, 10, -300, 300);
        animalAction.add(graphicPanel, BorderLayout.CENTER);
    }

    private void addFalcon(double x, double y) {
        Falcon newFalcon = new Falcon("Falcon", 0, 0);
        newFalcon.setFinalXY(x, y); // Устанавливаем конечные координаты
        data.addAnimal(newFalcon);
        //System.out.println("Falcon added at coordinates: (" + x + ", " + y + ")");
    }
}