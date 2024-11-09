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

    javax.swing.Timer timer = new javax.swing.Timer(100, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            animalAction.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent evt) {
                    point = new Point(0, 0);
                    if (falcon.startFly(evt.getX())) {
                        falcon.move(10f);
                        falcon.setFinalPosition(evt.getX(), evt.getY());
                        point.updatePoint((int) falcon.getX(), (int) falcon.getY());
                        System.out.println(falcon.getX());
                        System.out.println(falcon.getY());
                        animalAction.add(point, BorderLayout.CENTER);
                    }
                }
            });
        }
    });

    public AnimalForm() {
        // Инициализация Spring
        animalAction.setLayout(new BorderLayout()); // Установите нужный LayoutManager
        animalAction.setPreferredSize(new Dimension(600, 600));
        falcons = new ArrayList<>();


        falconButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                falcon = new Falcon("Falcon");
                falcon.setFinalPosition(200, 200);
                falcons.add(falcon);
                timer.start();
            }
        });


    }
}