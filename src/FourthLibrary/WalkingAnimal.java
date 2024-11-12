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

    public boolean isMoving(double yMouse) {
        if (yMouse >= 0) {
            isJumping = true;
        }
        return isJumping;
    }


    public void setJump(boolean f){
        isJumping = f;
    }

}
