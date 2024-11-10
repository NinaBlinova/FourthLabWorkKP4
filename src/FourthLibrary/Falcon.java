package FourthLibrary;

import java.awt.*;

public class Falcon extends FlyingAnimals {
    private double speed;

    // начальные координаты
    private double startX = 0;
    private double startY = 0;
    // конечные координаты
    private double finalX;
    private double finalY;
    // текущие координаты
    private double currentX;
    private double currentY;
    // таймер движения
    private double timeValue = 0.;


    public Falcon(String nameAnimal, double x, double y) {
        super(nameAnimal);
        this.speed = 10 + Math.random() * 10; // Генерация скорости от 10 до 20 м/с
        this.startX = x; // Начальные координаты по умолчанию
        this.startY = y; // Начальные координаты по умолчанию
        this.finalX = x; // Конечные координаты по умолчанию
        this.finalY = y; // Конечные координаты по умолчанию
        this.currentX = x; // Установка текущих координат на начальные
        this.currentY = y; // Инвертируем Y для мировой системы координат
    }


    // считывание скорости движения объекта
    public double getSpeed() {
        return speed;
    }

    @Override
    public void move(float time) {
        // увеличение счетчика времени
        this.timeValue += time;

        // расчет максимального расстояния движения
        double distance = Math.sqrt(Math.pow(this.finalX - this.startX, 2) +
                Math.pow(calculateY(this.finalX) - this.startY, 2));

        // расчет максимального времени движения
        double tmax = distance / this.speed;

        // если движение закончилось
        if (this.timeValue >= tmax) {
            this.currentX = this.finalX;
            this.currentY = calculateY(this.finalX); // вычисляем Y для конечной точки
            this.startX = this.finalX;
            this.startY = this.currentY; // обновляем начальные координаты
            this.timeValue = 0;
            return;
        }

        // расчет текущих координат по времени
        double progress = this.timeValue / tmax;
        this.currentX = this.startX + progress * (this.finalX - this.startX);
        this.currentY = calculateY(this.currentX); // вычисляем Y по текущему X
    }

    public double getX() {
        return currentX;
    }

    @Override
    public double getY() {
        return currentY;
    }


    private double calculateY(double x) {
        return ((2 * x - 0.5) * (2 * x - 0.5) - 0.25) / 2;
    }


    public void setFinalXY(double x, double y) {
        this.finalX = x;
        this.finalY = y;
        this.startX = this.currentX;
        this.startY = this.currentY;
        this.timeValue = 0;
    }

    // прорисовка объекта по указанным координатам x, y
    public void drawAt(Graphics g, int x, int y) {
        g.fillOval(x - 5, y - 5, 10, 10);
    }

    // прорисовка объекта
    public void draw(Graphics g) {
        this.drawAt(g, (int) this.currentX, (int) this.currentY);
    }

    public boolean isAtFinalPosition(double x, double y) {
        // Проверяем, близки ли текущие координаты к конечным
        return Math.abs(x - finalX) < 0.1 && Math.abs(y - finalY) < 0.1; // Используем небольшой порог для проверки
    }

}

