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
    public abstract void move(float time);


    public double getY() {
        return y;
    }

    public abstract boolean isMoving(double yMouse);
}
