package FourthLibrary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Point;

public class GraphicPanel extends JPanel {
    private ArrayList<Falcon> falcons = new ArrayList<>();
    private int currentFalconIndex = 0; // Индекс текущего сокола
    private Data data;
    private boolean falconInitialized = false;


    // границы мировой системы координат
    private double worldXMin = -1;
    private double worldXMax = 1;
    private double worldYMin = -1;


    private double worldYMax = 1;


    // создание таймера
    private Timer timer = new Timer(40, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (currentFalconIndex < falcons.size()) {
                Falcon currentFalcon = falcons.get(currentFalconIndex);
                if (currentFalcon != null) {
                    // расчет текущего положения объекта
                    currentFalcon.move((float) 0.5);
                    if (currentFalcon.isAtFinalPosition()) {
                        currentFalconIndex++; // Переход к следующему соколу
                    }
                    repaint(); // Перерисовка элемента
                }
            }
        }
    });

    // Определение конструктора элемента
    public GraphicPanel(Data data) {
        this.data = data;

        while (!data.isEmptyData()) {
            Falcon falcon = data.getNextAnimal();
            if (falcon != null) {
                falcons.add(falcon);
            }
        }

        // Добавление обработчика нажатия кнопки мыши
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                if (currentFalconIndex < falcons.size()) {
                    Falcon currentFalcon = falcons.get(currentFalconIndex);
                    if (currentFalcon.startFly(screenYtoWorldY(evt.getY()))) {
                        double x = screenXtoWorldX(evt.getX());
                        double y = screenYtoWorldY(evt.getY());
                        // установка координат конечной точки движения объекта
                        currentFalcon.setFinalXY(x, y);
                        timer.start(); // Запуск таймера только при клике
                    }
                }
            }
        });
    }

    // переопределение метода прорисовки элемента
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < falcons.size(); i++) {
            Falcon falcon = falcons.get(i);
            int subjX = (int) worldXtoScreenX(falcon.getX());
            int subjY = (int) worldYtoScreenY(falcon.getY());
            falcon.drawAt(g, subjX, subjY); // Отрисовка каждого сокола
        }
        // Прорисовка текстовой строки с координатами текущего сокола
        if (currentFalconIndex < falcons.size()) {
            Falcon currentFalcon = falcons.get(currentFalconIndex);
            g.drawString("x: " + currentFalcon.getX() + " y: " + currentFalcon.getY(), 10, 20);
        }
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
