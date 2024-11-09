package FourthLibrary;

import javax.swing.*;
import java.awt.*;

public class Point extends JPanel {
    private double x;
    private double y;
    private final int pointSize = 10; // Размер точки
    private Falcon falcon;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;

    }

    // Метод для обновления координат точки
    public void updatePoint(int x, int y) {
        this.x = x;
        this.y = y;
        this.repaint(); // Перерисовываем панель после обновления координат
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED); // Цвет точки
        g.fillOval((int) x - pointSize / 2, (int) y - pointSize / 2, pointSize, pointSize); // Рисуем точку
    }
}
