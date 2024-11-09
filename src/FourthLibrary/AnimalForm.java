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
    private Point point;
    private Falcon falcon;
    // движущийся объект

    // создание таймера
    private Timer timer = new Timer(40, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // расчет текущего положения объекта
            falcon.move((float) 0.04);
            // перерисовка элемента
            animalAction.repaint();
        }
    });

    public AnimalForm() {
        // Инициализация Spring
        animalAction.setLayout(new BorderLayout()); // Установите нужный LayoutManager

        // Инициализация graphPanel
        point = new Point();
        Spring.add(point, BorderLayout.CENTER); // Добавляем graphPanel в центр Spring
    }
}
