package inheritance.pkg;

public class Bike extends MountainBike{
    int initialSpeed;
    int initialGear;

    public Bike(int initialSpeed, int initialGear, int height){
        super(initialSpeed,initialGear,height);
        this.initialGear=initialGear;
        this.initialSpeed=initialSpeed;
        this.height=height;
    }

    public void applyBrake(int decrement){
        initialSpeed-=decrement;
    }
    public int getHeight(){
        return height;
    }
}
