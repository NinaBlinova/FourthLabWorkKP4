package FourthLibrary;

public class Falcon extends FlyingAnimals {
    private double speed;

    // начальные координаты
    private double startX = 0.;
    private double startY = 0.;
    // конечные координаты
    private double finalX = 0.;
    private double finalY = 0.;
    // текущие координаты
    private double currentX = 0.;
    private double currentY = 0.;
    // таймер движения
    private double timeValue = 0.;

    public Falcon(String nameAnimal) {
        super(nameAnimal);
        this.speed = 10 + Math.random() * 10; // Генерация скорости от 10 до 20 м/с
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

}
