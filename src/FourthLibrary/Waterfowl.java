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
    public boolean isMoving(double x){
        this.isSwimming = true;
        return isSwimming;
    }

    public void setSwim(boolean f) {
        isSwimming = f;
    }



}
