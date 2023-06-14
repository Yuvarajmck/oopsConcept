package interface_;

 class Bike implements MountainBike {
    int initialSpeed;
    int initialGear;

    public Bike(int initialSpeed, int initialGear, int height){

        this.initialGear=initialGear;
        this.initialSpeed=initialSpeed;

    }

    public void applyBrake(int decrement){
        initialSpeed-=decrement;
    }
    @Override
    public void speedUp(int increment){
        initialSpeed+=increment;
    }

     public int getSpeed() {
        return initialSpeed;
     }
 }
