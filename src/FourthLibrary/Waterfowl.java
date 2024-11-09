package FourthLibrary;

//абстрактный класс водоплавающие живтоные

public abstract class Waterfowl extends Animal {
    private boolean isSwimming;
    private double amplitude;
    private double depth;

    public Waterfowl(String nameAnimal, double amplitude, double depth) {
        super(nameAnimal);
        this.amplitude = amplitude;
        this.depth = depth;
        this.isSwimming = false;
    }

    @Override
    public void move(double yTarget) {
        this.y = yTarget;
    }

    public boolean startSwim(double yMouse){
        this.isSwimming = true;
        return isSwimming;
    }

    public void endSwim() {
        if (isSwimming) {
            this.y = -depth; // Останавливаемся на глубине
            isSwimming = false;
        }
    }

    @Override
    public boolean isMoving() {
        return isSwimming;
    }
}
