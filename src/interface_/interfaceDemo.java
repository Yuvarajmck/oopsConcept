package interface_;

public class interfaceDemo {
    public static void main(String[] args) {
        Bike harley = new Bike(10,1, 50);
        harley.speedUp(1);
        System.out.println(harley.getSpeed());
    }
}
