import java.util.Random;

public class Password {


    public static  String generate(int len, int sym, int dig){

        char[] password = new char[20];

        Random rand = new Random();



        //Generate Symbols
        for(int i = 0; i < 20; i++){
            int ranInt = rand.nextInt((65374 - 65281) + 1) + 65281;
            password[i] = ((char)ranInt);
        }


//        //Generate Symbols
//        for(int i = 0; i < dig; i++){
//            int ranInt = rand.nextInt((9 - 0) + 1) + 0;
//            password += ""+((char)ranInt);
//        }

        System.out.println(new String(password));
        return "";
    }

}
