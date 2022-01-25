public class Main {
    public static void main(String[] args) {
        Car lightning = new Car(40, "red", 54);

        Car herbie = new Car(25, "white", 54);
        System.out.println(lightning.speed);
        lightning.accelerate(10);
        System.out.println(herbie.speed);

        lightning.beep();
        lightning.litresOfFuel = 80;
        System.out.println("Lightning's range is " + lightning.range());

        System.out.println("Herbie's range is " + herbie.range());

    }
}
