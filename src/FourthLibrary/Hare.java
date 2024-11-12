package FourthLibrary;

import java.awt.*;

public class Hare extends WalkingAnimal {
    private double speed;
    private double amplituda;


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


    Hare(String nameAnimal, double x, double y) {
        super(nameAnimal);
        this.speed = 1 + Math.random() * 8; // Генерация скорости от 1 до 8 м/с
        this.amplituda = 1 + Math.random() * 2;
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

    public double getAmplituda() {
        return amplituda;
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
        if (this.currentY < 0) {
            this.startX = this.finalX;
            this.startY = this.finalY;
            if (finalY < 0){
                finalY = 0;
            }
            this.timeValue = 0;
            setJump(false);
            return;
        }

        // расчет текущих координат по времени
        double progress = this.timeValue / tmax;
        this.currentX = this.startX + progress * (this.finalX - this.startX);
        this.currentY = calculateY(this.currentX) * amplituda; // вычисляем Y по текущему X
    }

    private double calculateY(double x) {
        return 20 - 4 * (x - 0.5) * (x - 0.5);
    }


    public void setFinalXY(double x, double y) {
        this.finalX = x;
        this.finalY = y;
        this.startX = this.currentX;
        this.startY = this.currentY;
        this.timeValue = 0;
    }

    public double getX() {
        return currentX;
    }

    @Override
    public double getY() {
        return currentY;
    }


    // прорисовка объекта по указанным координатам x, y
    public void drawAt(Graphics g, int x, int y) {
        g.setColor(Color.GREEN);
        g.fillOval(x, y, 10, 10);
    }

    // прорисовка объекта
    public void draw(Graphics g) {
        this.drawAt(g, (int) this.currentX, (int) this.currentY);
    }

    public boolean isAtFinalPosition() {
        // Проверяем, близки ли текущие координаты к конечным
        return currentY < 0;
    }
}
