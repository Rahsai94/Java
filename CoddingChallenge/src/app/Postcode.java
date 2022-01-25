package app;

import model.PostcodeValidateStatus;
import netscape.javascript.JSObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Postcode {

    private static final String postcodeUrl = "https://api.postcodes.io/postcodes/";
    private String postcode;


    public Postcode(String postcode){
        this.postcode = postcode;
    }

    public PostcodeValidateStatus validatePostcode(){
        String url = String.format(postcodeUrl + "%s/validate", this.postcode);
        executeUrl(url);
        PostcodeValidateStatus postcodeValidateStatus = new PostcodeValidateStatus();
        return postcodeValidateStatus;
    }

    private String executeUrl(String url) {

        try {

            URL httpUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) httpUrl.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responce = conn.getResponseCode();
            if(responce != 200){

            }else {
                String inline = "";
                Scanner scanner = new Scanner(httpUrl.openStream());

                //Write all the JSON data into a string using a scanner
                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }

                //Close the scanner
                scanner.close();

                //Using the JSON simple library parse the string into a json object


            }

        } catch (MalformedURLException exception) {
            System.out.println(exception.getMessage());
        } catch (IOException e) {
            System.out.println("There is the problem with connection");
        }

        return "";
    }
}
