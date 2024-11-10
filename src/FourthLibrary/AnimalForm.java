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
    private Queue<Falcon> falconQueue; // Очередь для соколов


    public AnimalForm() {
        // Инициализация Spring
        animalAction.setLayout(new BorderLayout()); // Установите нужный LayoutManager
        animalAction.setPreferredSize(new Dimension(600, 600));
        createUIComponents();
        falconQueue = new LinkedList<>();

        falconButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFalcon(Math.random() * 20 - 10, Math.random() * 600 - 300); // Добавляем сокола с случайными координатами
            }
        });
    }

    private void createUIComponents() {
        GraphicPanel graphicPanel = new GraphicPanel();
        graphicPanel.setPreferredSize(new Dimension(600, 600));
        graphicPanel.setWorldCoords(-10, 10, -300, 300);
        animalAction.add(graphicPanel, BorderLayout.CENTER);
    }

    private void addFalcon(double x, double y) {
        Falcon newFalcon = new Falcon("Falcon", 0, 0);
        newFalcon.setFinalXY(x, y); // Устанавливаем конечные координаты
        falconQueue.add(newFalcon); // Добавляем сокола в очередь
    }

    public Falcon getNextFalcon() {
        return falconQueue.poll(); // Получаем и удаляем следующий сокол из очереди
    }
}