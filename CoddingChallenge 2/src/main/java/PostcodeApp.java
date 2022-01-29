import model.PostCodeInfo;
import model.PostCodeResult;
import model.PostCodeValidateStatus;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PostcodeApp {

    //Create Constructor and Read Input from the User
    public PostcodeApp(){
        acceptPostcode();
    }

    // Accept PostCode from User
    private void acceptPostcode(){
        try{
            int choice = 0;
            //Create scanner class for accepting input
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nWelcome to the Postcode Finder \n1: Postcode search \n2: Random PostCode \n3: Quit\nEnter your Choice: ");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    scanner = new Scanner(System.in);
                    System.out.print("Enter The PostCode: ");
                    String postcode = scanner.nextLine().trim();
                    postcode = postcode.replaceAll("\\s+", "");
                    processPostCode(postcode);
                    acceptPostcode();
                    break;
                case 2:
                    PostCode postCode = new PostCode();
                    PostCodeResult postCodeResult = postCode.randomPostCode();
                    System.out.println("\n****Random PostCode*** \nPostCode: "+postCodeResult.getResult().getPostcode()+"\nContry: "+postCodeResult.getResult().getCountry());
                    System.out.println("Region: "+postCodeResult.getResult().getRegion()+"\n");
                    acceptPostcode();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("\nYou Enter Wrong Choice");
                    acceptPostcode();
                    break;
            }

        }catch(InputMismatchException handle){
            System.out.println("\n* Please Enter the Proper Input");
            acceptPostcode();
        }

    }

    //Process the PostCode
    private void processPostCode(String postcode){
        //Create PostCode object
        PostCode postCode = new PostCode(postcode);
        PostCodeValidateStatus postCodeValidateStatus = postCode.validatePostCode();
        if(postCodeValidateStatus.isResult()){
            PostCodeResult postCodeResult = postCode.postcodeResult();
            System.out.println("*** Result ***");
            System.out.println("PostCode: "+postCodeResult.getResult().getPostcode());
            System.out.println("Country: "+postCodeResult.getResult().getCountry());
            System.out.println("Region: "+postCodeResult.getResult().getRegion());
            System.out.println("\n***** Nearest PostCodes ******");
            PostCodeInfo[] nearestPostcodes = postCode.checkNearestPostcodes().getResult();
            for(PostCodeInfo p: nearestPostcodes){
                System.out.println("PostCode: "+p.getPostcode());
                System.out.println("Country: "+p.getCountry());
                System.out.println("Region: "+p.getRegion());
            }
        }else {
            System.out.println("The Given PostCode is Wrong");
        }
    }

}
