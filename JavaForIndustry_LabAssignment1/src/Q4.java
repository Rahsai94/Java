import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) throws IOException{
        //write your answer here

        String choice = "0";

        Scanner scanner = new Scanner(System.in);

            do{

                //Display Menu
                System.out.println("-----------------------------\nWELCOME TO BANK OF ENG\n----------------------------");
                System.out.println("1. Current accounts.\n2. Credit cards\n3. Loans\n4. savings accounts \nh. Quit");
                System.out.println("Enter your Choice: ");

                //Accept the input
                choice = scanner.next();

                //Check the choice
                switch (choice){
                    case "1":
                        System.out.println("You selected Current accounts Service.");
                        break;
                    case "2":
                        System.out.println("You selected Credit cards Service.");
                        break;
                    case "3":
                        System.out.println("You selected Loans Service.");
                        break;
                    case "4":
                        System.out.println("You selected savings accounts Service.");
                        break;
                    case "h":
                        break;
                    default:
                        choice = "0";
                        System.out.println("You selected the wrong option");
                        break;
                }

            }while (choice.equals("0"));

    }
}
