package app;

import java.util.Scanner;

public class PostCodeApp {

    private String postcode;
    //Constructor
    public PostCodeApp() {
        System.out.print("\nEnter PostCode : ");
        this.postcode = inputPostCode();
        processPostcodeQuery();
    }

    //Get postcode from result
    private String inputPostCode(){
        String postcode = "";
        Scanner scanner = new Scanner(System.in);
        postcode = scanner.nextLine().trim();
        return  postcode;
    }

    private void processPostcodeQuery(){
        Postcode postcode = new Postcode(this.postcode);
        postcode.validatePostcode();
    }





}
