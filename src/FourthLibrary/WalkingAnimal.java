package FourthLibrary;

//абстрактный класс ходящие живтоные

public abstract class WalkingAnimal extends Animal {
    private boolean isJumping;
    private double jumpHeight;

    public WalkingAnimal(String nameAnimal) {
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

    public void setJump(boolean f){
        isJumping = f;
    }


    @Override
    public boolean isMoving() {
        return isJumping;
    }

    public abstract void move(float time);
}
