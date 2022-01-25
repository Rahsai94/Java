public class Q2 {
    public static void main(String[] args) {



        //part 1: display even numbers between 0 and 1000

        System.out.println("Even Numbers between 0 to 1000");
        int num = 0;
        while(num <= 1000){

            if(num % 2 == 0){
                System.out.print(" "+num);
            }
            num++;
        }


        //part 2: display odd numbers between 0 and 1000

        System.out.println("\n\nOdd Numbers between 0 to 1000");
        for(num = 0; num <= 1000; num++){

            if(num % 2 != 0){
                System.out.print(" "+num);
            }

        }


        //part 3: display all the multiples of 4 between 0 and 1000

        System.out.println("\n\nMultiples of 4 Numbers between 0 to 1000");
        for(int i = 0; i <= 1000; i++){

            if(i % 4 == 0){
                System.out.print(" "+i);
            }

        }

        //part 4: display all the numbers between 1 and 1000 replacing multiples of 3 with Java
        //multiples of 5 with Script and multiples of 3 and 5 with JavaScript


        System.out.println("\n\nDisplay all the numbers between 1 and 1000 replacing multiples of 3 with Java\nmultiples of 5 with Script and multiples of 3 and 5 with JavaScript\n");


        for(int i = 1; i <= 1000; i++){

            //Check number is divided by 3 as well as Divided by 5
            if(i % 3 == 0 && i % 5 == 0){
                System.out.println("JavaScript");
            }else if(i % 3 == 0 ){   // Check Number is Divide by 3 or Not
                System.out.println("Java");
            }else if (i % 5 == 0){   // Check Number is Divide by 5 or Not
                System.out.println("Script");
            }else {
                System.out.println(i);  // Print the numbers which not divided by 3 or 5
            }

        }

    }
}
