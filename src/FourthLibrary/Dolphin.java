package FourthLibrary;

import java.awt.*;

public class Dolphin extends Waterfowl {
    private double speed;
    private double amplituda;
    private double depth;

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

    public Dolphin(String nameAnimal, double x, double y) {
        super(nameAnimal, generateRandomAmplitude(), generateRandomDepth());
        this.speed = 12 + Math.random() * 6; // Скорость от 12 до 18
        this.startX = x; // Начальные координаты по умолчанию
        this.startY = y; // Начальные координаты по умолчанию
        this.finalX = x; // Конечные координаты по умолчанию
        this.finalY = y; // Конечные координаты по умолчанию
        this.currentX = x; // Установка текущих координат на начальные
        this.currentY = y; // Инвертируем Y для мировой системы координат
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

        if (this.timeValue >= tmax) {
            this.currentX = this.finalX;
            this.currentY = calculateY(this.finalX); // вычисляем Y для конечной точки
            this.startX = this.finalX;
            this.startY = this.currentY; // обновляем начальные координаты
            this.timeValue = 0;
            setSwim(false);
            return;
        }

        // расчет текущих координат по времени
        double progress = this.timeValue / tmax;
        this.currentX = this.startX + progress * (this.finalX - this.startX);
        this.currentY = calculateY(this.currentX) * amplituda; // вычисляем Y по текущему X
    }


    private double calculateY(double x) {
        return Math.sin(2 * Math.PI * x * x);
    }

    private static double generateRandomAmplitude() {
        return 2 + Math.random() * 8; // Амплитуда от 2 до 10
    }

    private static double generateRandomDepth() {
        return Math.random() * 20; // Глубина от 0 до 20
    }

    public void setFinalXY() {
        this.finalX = depth;
        this.finalY = calculateY(finalX);
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
        g.fillOval(x, y, 10, 10);
    }

    // прорисовка объекта
    public void draw(Graphics g) {
        this.drawAt(g, (int) this.currentX, (int) this.currentY);
    }

    public boolean isAtFinalPosition() {
        return currentX == finalX;
    }
}
