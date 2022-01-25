public class Q3Main {
    public static void main(String[] args) {

        String password = Password.generate(18,5,6);

        System.out.println("Password : "+password);

        /*

            PASSWORD GENERATION FOR DIFFERENT LENGTH

            | Characters | Symbols | Digits | Expected Validation |
            | ---------- | ------- |------- |--------------------  |
                 6         2        1                 poor
                14         4        5                 Good
                 9         2        3                   ok
                 9         2        2                 poor
                18         5        6            Excellent

        */

        System.out.format("%14s%10s%9s%22s", "| Characters |", " Symbols |", " Digits |", " Expected Validation |\n");
        System.out.format("%14s%10s%9s%22s", "| ---------- |", " ------- |", "------- |", "--------------------  |\n");
        System.out.format("%10s%10s%9s%22s", "6", "2", "1", Password.validate(Password.generate(6,2,1))+"\n");
        System.out.format("%10s%10s%9s%22s", "14", " 4", "5", Password.validate(Password.generate(14,4,5))+"\n");
        System.out.format("%10s%10s%9s%22s", "9", " 2", "3", Password.validate(Password.generate(9,2,3))+"\n");
        System.out.format("%10s%10s%9s%22s", "9", "2", "2", Password.validate(Password.generate(9,2,2))+"\n");
        System.out.format("%10s%10s%9s%22s", "18", "5", "6", Password.validate(Password.generate(18,5,6))+"\n");



    }
}
