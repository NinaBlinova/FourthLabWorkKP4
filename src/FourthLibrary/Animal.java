package FourthLibrary;

//абстрактный класс живтоное

public abstract class Animal {
    protected String nameAnimal;
    protected double y;

    public Animal(String nameAnimal) {
        this.nameAnimal = nameAnimal;
        this.y = 0;
    }

    // Абстрактный метод для передвижения
    public abstract void move(double yTarget);

    // Метод для проверки, находится ли животное в движении
    public abstract boolean isMoving();

    // Метод для получения названия животного
    public String getName() {
        return nameAnimal;
    }

    public double getY() {
        return y;
    }
}
