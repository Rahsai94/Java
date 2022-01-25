public class Polymorphism {

    public static void main(String[] args) {

        add();
        add(3, 6);
        add( "Rahul ", "Mohite");
        add(3 , "abc");
    }


    public static void add(String a, String b){

        String str = a.concat(b);

        System.out.println("Concatenation of Strings: " + str);
    }

    public static void add(int a, int b){

        System.out.println("Addition of numbers: "+ (a+b));
    }


    public static void add(){

        System.out.println("Nothing");

    }

    public static void add(int a, String b){
        System.out.println(a+b);
    }
}
