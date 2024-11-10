package FourthLibrary;

import javax.swing.*;
import java.awt.*;

// класс для отрисовки точки

public class Point extends JPanel {
    private double x;
    private double y;
    private double worldXMin;
    private double worldXMax;
    private double worldYMin;
    private double worldYMax;

    public Point(double worldXMin, double worldXMax, double worldYMin, double worldYMax) {
        this.x = 0;
        this.y = 0;
        this.worldXMin = worldXMin;
        this.worldXMax = worldXMax;
        this.worldYMin = worldYMin;
        this.worldYMax = worldYMax;
    }

    // Метод для преобразования экранных координат в мировые по оси X
    private double screenXtoWorldX(double sx) {
        return sx / this.getWidth() * (this.worldXMax - this.worldXMin) + this.worldXMin;
    }

    // Метод для преобразования экранных координат в мировые по оси Y
    private double screenYtoWorldY(double sy) {
        return (1 - sy / this.getHeight()) * (this.worldYMax - this.worldYMin) + this.worldYMin;
    }

    // Метод для обновления координат точки
    public void updatePoint(double screenX, double screenY) {
        this.x = screenXtoWorldX(screenX);
        this.y = screenYtoWorldY(screenY);
        this.repaint(); // Перерисовываем панель после обновления координат
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED); // Цвет точки
        // Размер точки
        int pointSize = 10;
        // Преобразуем мировые координаты в экранные для рисования
        int screenX = (int) ((this.x - worldXMin) / (worldXMax - worldXMin) * this.getWidth());
        int screenY = (int) ((1 - (this.y - worldYMin) / (worldYMax - worldYMin)) * this.getHeight());
        g.fillOval(screenX - 5, screenY - 5, pointSize, pointSize); // Рисуем точку
    }
}
