package FourthLibrary;

public abstract class FlyingAnimals extends Animal {
    private boolean isFlying;

    public FlyingAnimals(String nameAnimal) {
        super(nameAnimal);
        this.isFlying = false;
    }

    @Override
    public void move(double yTarget) {
        if (yTarget < 0) {
            this.y = 1;
        }
        this.y = yTarget;
    }

    public boolean startFly(double yMouse) {
        if (yMouse > 0) {
            this.isFlying = true;
        }
        return isFlying;
    }

    @Override
    public boolean isMoving() {
        return isFlying;
    }

    // осуществление движения (по линейной траектории)
    public abstract void move(float time);
}
