package FourthLibrary;

public abstract class FlyingAnimals extends Animal {
    private boolean isFlying;

    public FlyingAnimals(String nameAnimal) {
        super(nameAnimal);
        this.isFlying = false;
    }

    public boolean getFly() {
        return isFlying;
    }

    public void setFly(boolean f) {
        isFlying = f;
    }

    @Override
    public boolean isMoving(double yMouse) {
        if (yMouse > 0) {
            this.isFlying = true;
        } else {
            this.isFlying = false;
        }
        return isFlying;
    }

}
