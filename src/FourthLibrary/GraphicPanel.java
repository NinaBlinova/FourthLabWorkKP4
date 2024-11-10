package FourthLibrary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GraphicPanel extends JPanel {
    private Falcon currentFalcon;

    // границы мировой системы координат
    private double worldXMin = -1;
    private double worldXMax = 1;
    private double worldYMin = -1;
    private double worldYMax = 1;

    /// создание таймера
    private Timer timer = new Timer(40, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (currentFalcon != null) {
                // расчет текущего положения объекта
                currentFalcon.move((float) 0.5);
                repaint(); // Перерисовка элемента
            }
        }
    });

    // Определение конструктора элемента
    public GraphicPanel() {
        // создание экземпляра класса движущегося объекта
        currentFalcon = new Falcon("Falcon", 0, 0);
        // Добавление обработчика нажатия кнопки мыши
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                if (currentFalcon.startFly(screenYtoWorldY(evt.getY()))) {
                    double x = screenXtoWorldX(evt.getX());
                    double y = screenYtoWorldY(evt.getY());
                    // установка координат конечной точки движения объекта
                    currentFalcon.setFinalXY(x, y);
                }

            }
        });

        // запуск таймера
        timer.start();
    }

    // переопределение метода прорисовки элемента
    @Override
    public void paintComponent(Graphics g) {
        // вызов метода суперкласса
        super.paintComponent(g);
        // вычисление экранных координат объекта
        int subjX = (int) worldXtoScreenX((int) currentFalcon.getX());
        int subjY = (int) worldYtoScreenY((int) currentFalcon.getY());
        // прорисовка объекта
        currentFalcon.drawAt(g, subjX, subjY);
        // прорисовка текстовой строки с координатам объекта
        g.drawString("x: " + currentFalcon.getX() + " y: " + currentFalcon.getY(), 10, 20);
        //System.out.println("Current Falcon coordinates: " + subject.getX() + ", " + subject.getY()); // Для отладки
    }


    // установка границ мировой системы координат
    public void setWorldCoords(double xmin, double xmax, double ymin, double ymax) {
        this.worldXMax = xmax;
        this.worldXMin = xmin;
        this.worldYMax = ymax;
        this.worldYMin = ymin;
    }

    // процедуры преобразования мировых координат в экранные
    private double worldXtoScreenX(double wx) {
        return Math.round(this.getWidth() * (wx - this.worldXMin) / (this.worldXMax - this.worldXMin));
    }

    private double worldYtoScreenY(double wy) {
        return Math.round(this.getHeight() * (1 - (wy - this.worldYMin) / (this.worldYMax -
                this.worldYMin)));
    }

    // процедуры преобразования экранных координат в мировые
    private double screenXtoWorldX(int sx) {
        return (float) sx / this.getWidth() * (this.worldXMax - this.worldXMin) + this.worldXMin;
    }

    private double screenYtoWorldY(int sy) {
        return (1 - (float) sy / this.getHeight()) * (this.worldYMax - this.worldYMin) + this.worldYMin;
    }


}
