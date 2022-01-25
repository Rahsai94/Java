import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Password {

    // DEFINE THE STATIC VARIABLE FOR STATIC METHOD
    private static final String CHAR_LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPERCASE = CHAR_LOWERCASE.toUpperCase();

    //ALL UPPER CASE AND LOWERCASE CHARACTERS
    private static final String ALL_CHAR = CHAR_LOWERCASE + CHAR_UPPERCASE;

    //DIGITS
    private static final String DIGIT = "0123456789";

    private static final String OTHER_PUNCTUATION = "!@#&()–[{}]:;',?/*";
    private static final String OTHER_SYMBOL = "~$^+=<>";

    //ALL SPECIAL CHARACTERS
    private static final String OTHER_SPECIAL = OTHER_PUNCTUATION + OTHER_SYMBOL;


    private static SecureRandom random = new SecureRandom();

    public static String generate(int len, int symbols, int digits){

        StringBuilder password = new StringBuilder(len);

        int char_len = len - (symbols+digits);

        //ADD THE SYMBOLS IN THE PASSWORD
        String symbolPassword = generateRandomPass(OTHER_SPECIAL, symbols);
        password.append(symbolPassword);


        //ADD THE DIGITS IN THE PASSWORD
        String digitPassword = generateRandomPass(DIGIT, digits);
        password.append(digitPassword);

        //ADD THE DIGITS IN THE PASSWORD
        String charPassword = generateRandomPass(ALL_CHAR, char_len);
        password.append(charPassword);



        return shufflePassword(password.toString());
    }


    private static  String generateRandomPass(String input_set, int length){
        StringBuilder password = new StringBuilder(length);

        for (int i = 0; i < length; i++){
            int index = random.nextInt(input_set.length());
            password.append(input_set.charAt(index));
        }
        return password.toString();
    }


    private static String shufflePassword(String password){
        List<String> shuffledPassword = Arrays.asList(password.split(""));
        Collections.shuffle(shuffledPassword);

        return shuffledPassword.stream().collect(Collectors.joining());
    }



    public static String validate(String password){

        String password_Validate = "";
        int num_Digits = 0;
        int num_Symbols = 0;
        int num_Characters  = 0;

        boolean lowerChar = false;
        boolean upperChar = false;

        //Check Every Character in loop
        for(int i = 0; i < password.length(); i++){

            if(Character.isDigit(password.charAt(i))){
                    num_Digits++;
            }else if(Character.isLetter(password.charAt(i))){

                if(Character.isLowerCase(password.charAt(i))){
                    lowerChar = true;
                }else {
                    upperChar = true;
                }
                num_Characters++;
            }else {
                num_Symbols++;
            }
        }

        if(password.length() >= 16 && num_Symbols > 4 && num_Digits > 4 && (lowerChar&&upperChar)){
            password_Validate = "Excellent";
        }else if(password.length() > 12 && num_Symbols > 3 && num_Digits > 3 && (lowerChar&&upperChar) ){
            password_Validate = "Good";
        }else if(password.length() > 8 && num_Symbols > 1 && num_Digits > 2 ){
            password_Validate = "ok";
        }else{
            password_Validate = "poor";
        }
        return password_Validate;
    }
}







   