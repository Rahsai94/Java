public class Car {
    //properties (data)
    double speed = 0;
    int mpg;
    String colour;
    int litresOfFuel;

    //constructor
    Car(int milesPG, String c, int lof){
        mpg = milesPG;
        colour = c;
        litresOfFuel = lof;
    }

    //methods (interface)
    void beep(){
        System.out.println("BEEP! get outta the way!");
    }

    void accelerate(int v){
        speed += v;
    }

    int range(){
        int r = (int) ((mpg/4.54609)) * litresOfFuel;
        return r;
    }
}
