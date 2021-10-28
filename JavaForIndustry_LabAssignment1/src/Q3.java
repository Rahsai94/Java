import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) throws IOException {

        double salary = 60000;

        Tax tax = new Tax();

        //Calculate Salary of Given Number
        tax.setSalary(salary);
        System.out.printf("Total tax of given salary "+tax.getSalary()+" is: %.2f \n",tax.calculateTax());
        
        //write your code here to calculate the tax of the variable salary, make sure you try multiple values
        // to test your work

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        try{

            do{

                System.out.println("Enter the Salary: ");
                salary = scanner.nextDouble();
                if(salary >= 0){
                    tax.setSalary(salary);
                    System.out.printf("Total tax of given salary "+tax.getSalary()+" is: %.2f",tax.calculateTax());
                }else {
                    System.out.println("Invalid Salary");
                }

                System.out.println("\nIf Wanna calculate Tax for another salary press 1: ");
                choice = scanner.nextInt();

            }while(choice == 1);


        }catch (InputMismatchException e){
            System.out.println("Invalid Input");
        }


    }
}



/*
Enter the Salary:
60000
Total tax of given salary 60000.0 is: 8750.00
If Wanna calculate Tax for another salary press 1:
1
Enter the Salary:
22000
Total tax of given salary 22000.0 is: 350.00
If Wanna calculate Tax for another salary press 1:
1
Enter the Salary:
45500
Total tax of given salary 45500.0 is: 3850.00
If Wanna calculate Tax for another salary press 1:
1
Enter the Salary:
14500
Total tax of given salary 14500.0 is: 0.00
If Wanna calculate Tax for another salary press 1:
1
Enter the Salary:
48342.32
Total tax of given salary 48342.32 is: 4418.46
If Wanna calculate Tax for another salary press 1:
0

Process finished with exit code 0
 */