package FourthLibrary;

//абстрактный класс ходящие живтоные

public abstract class WalkingAnimal extends Animal {
    private boolean isJumping;
    private double jumpHeight;

    public WalkingAnimal(String nameAnimal, double jumpHeight) {
        super(nameAnimal);
        this.jumpHeight = jumpHeight;
        this.isJumping = false;
    }

    @Override
    public void move(double yTarget) {
        this.y = yTarget;
    }

    public boolean startWalk(double yMouse) {
        if (yMouse >= 0) {
            isJumping = true;
        }
        return isJumping;
    }

    public void endWalk() {
        if (isJumping) {
            this.y = 0;
            isJumping = false;
        }
    }


    @Override
    public boolean isMoving() {
        return isJumping;
    }
}
