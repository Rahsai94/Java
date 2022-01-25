/*change your answer from part a to print out an acute triangle of asterisks, specify the number of layers using an int
Such that for 5 layers the programme will print the following. Use while loops in your solution.

    *
   * *
  * * *
 * * * *
* * * * *

 */
public class Example1b {
    public static void main(String[] args) {
        int layers = 15;

//        for(int i = 1; i <= layers; i++){
//            for(int j = 1 ; j < layers - (i -1); j++){
//                System.out.print(" ");
//            }
//            for(int k = 1; k <= i; k++){
//                System.out.print("*");
//
//                for(int l = 1; l < k; l += k){
//                    System.out.print("*");
//                }
//            }
//            System.out.println("");
//        }



        for (int i = 0; i <= layers ; i++){
            for (int j = 1; j <= layers - i; j++){
                System.out.print(" ");
            }
            for (int k = 1; k <= i - 1; k++){
                System.out.print("*");
                System.out.print(" ");
            }
            System.out.println();
        }


        int num = 1;

        while(num <= layers){


            num++;
        }


    }
}
