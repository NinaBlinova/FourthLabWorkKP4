package FourthLibrary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GraphicPanel extends JPanel {
    private ArrayList<Falcon> falcons = new ArrayList<>();
    private ArrayList<Hare> hares = new ArrayList<>();
    private ArrayList<Dolphin> dolphins = new ArrayList<>();
    final int[] currentFalconIndex = {0};
    final int[] currentHareIndex = {0};
    private int currentDolphinIndex = 0;
    String name;
    private Data data;


    // границы мировой системы координат
    private double worldXMin = -1;
    private double worldXMax = 1;
    private double worldYMin = -1;
    private double worldYMax = 1;


    // создание таймера
    private Timer timer = new Timer(40, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (name.equals("Falcon")) {
                if (currentFalconIndex[0] < falcons.size()) {
                    Falcon currentFalcon = falcons.get(currentFalconIndex[0]);
                    if (currentFalcon != null) {
                        currentFalcon.move((float) 0.5);
                        repaint();
                        if (currentFalcon.isAtFinalPosition()) {
                            timer.stop();
                            currentFalconIndex[0]++;

                        }
                    }
                }
            } else if (name.equals("Hare")) {
                if (currentHareIndex[0] < hares.size()) {
                    Hare currentHare = hares.get(currentHareIndex[0]);
                    if (currentHare != null) {
                        currentHare.move((float) 0.6);
                        repaint();
                        if (currentHare.isAtFinalPosition()) {
                            timer.stop();
                            currentHareIndex[0]++;
                        }
                    }
                }
            } else {
                if (currentDolphinIndex < dolphins.size()) {
                    Dolphin currentDolphin = dolphins.get(currentDolphinIndex);
                    if (currentDolphin != null) {
                        currentDolphin.move((float) 0.03);
                        repaint();
                        if (currentDolphin.isAtFinalPosition()) {
                            timer.stop();
                            currentDolphinIndex++;
                        }
                    }
                }
            }
        }

    });

    // Определение конструктора элемента
    public GraphicPanel(Data data) {
        this.data = data;
        Falcon falcon = null;
        Dolphin dolphin = null;
        Hare hare = null;

        ArrayList<String> type = new ArrayList<>();
        type.add("Falcon");
        type.add("Hare");
        type.add("Dolphin");
        final int[] currentIndexType = {0};

        while (!data.isEmptyData()) {
            Animal animal = data.getNextAnimal();
            //name = animal.nameAnimal;
            //System.out.println(name);
            if (animal.nameAnimal == "Falcon") {
                falcon = (Falcon) animal;
            } else if (animal.nameAnimal == "Hare") {
                hare = (Hare) animal;
            } else if (animal.nameAnimal == "Dolphin") {
                dolphin = (Dolphin) animal;
            }
            if (falcon != null) {
                falcons.add(falcon);
            }
            if (hare != null) {
                hares.add(hare);
            }
            if (dolphin != null) {
                dolphins.add(dolphin);
            }
        }

        // Добавление обработчика нажатия кнопки мыши
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                if (name == "Falcon") {
                    if (currentFalconIndex[0] < falcons.size()) {
                        Falcon currentFalcon = falcons.get(currentFalconIndex[0]);
                        if (currentFalcon.startFly(screenYtoWorldY(evt.getY()))) {
                            double x = screenXtoWorldX(evt.getX());
                            double y = screenYtoWorldY(evt.getY());
                            // установка координат конечной точки движения объекта
                            currentFalcon.setFinalXY(x, y);
                            timer.start(); // Запуск таймера только при клике
                        }
                    }

                } else if (name == "Hare") {
                    if (currentHareIndex[0] < hares.size()) {
                        Hare currentHare = hares.get(currentHareIndex[0]);
                        if (currentHare.startWalk(screenYtoWorldY(evt.getY()))) {
                            currentHare.setFinalXY(screenXtoWorldX(evt.getX()), screenYtoWorldY(evt.getY()));
                            timer.start(); // Запуск таймера только при клике
                        }
                    }
                } else if (name == "Dolphin") {
                    if (currentDolphinIndex < dolphins.size()) {
                        Dolphin currentDolphin = dolphins.get(currentDolphinIndex);
                        if (currentDolphin.startSwim()) {
                            currentDolphin.setFinalXY(screenXtoWorldX(evt.getX()), screenYtoWorldY(evt.getY()));
                            timer.start(); // Запуск таймера только при клике
                        }
                    }
                }


            }
        });


        // Добавление кнопки для смены объекта
        JButton switchButton = new JButton("Switch to Next Animal");
        switchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!type.isEmpty() && type.size() > currentIndexType[0]) {
                    ;
                    name = type.get(currentIndexType[0]);
                    System.out.println("Current animal: " + name);
                    currentIndexType[0]++;
                }
            }
        });
        this.add(switchButton, BorderLayout.SOUTH); // Размещение кнопки на панели
    }

    // переопределение метода прорисовки элемента
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(0, 304, 600, 304);
        g.drawLine(300, 0, 300, 600);

        for (int i = 0; i < falcons.size(); i++) {
            Falcon falcon = falcons.get(i);
            int subjX = (int) worldXtoScreenX(falcon.getX());
            int subjY = (int) worldYtoScreenY(falcon.getY());
            falcon.drawAt(g, subjX, subjY); // Отрисовка каждого сокола
        }

        // Отрисовка всех зайцев
        for (int i = 0; i < hares.size(); i++) {
            Hare hare = hares.get(i);
            int subjX = (int) worldXtoScreenX(hare.getX());
            int subjY = (int) worldYtoScreenY(hare.getY());
            hare.drawAt(g, subjX, subjY); // Отрисовка каждого зайца
        }

        // Отрисовка всех дельфинов
        for (int i = 0; i < dolphins.size(); i++) {
            Dolphin dolphin = dolphins.get(i);
            int subjX = (int) worldXtoScreenX(dolphin.getX());
            int subjY = (int) worldYtoScreenY(dolphin.getY());
            dolphin.drawAt(g, subjX, subjY); // Отрисовка каждого дельфина
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
        return (double) sx / this.getWidth() * (this.worldXMax - this.worldXMin) + this.worldXMin;
    }

    private double screenYtoWorldY(int sy) {
        return (1 - (double) sy / this.getHeight()) * (this.worldYMax - this.worldYMin) + this.worldYMin;
    }
}
