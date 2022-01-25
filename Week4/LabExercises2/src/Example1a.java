/*print out a right angle triangle of asterisks, specify the number of rows using the int layers
Such that for 5 rows the programme will print the following. Use while loops in your solution.

*
**
***
****
*****

 */
public class Example1a {
    public static void main(String[] args) {
        int layers = 15;

        for(int i = 1; i <= 5; i++){
            for(int j = 0; j < i; j++ ){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
