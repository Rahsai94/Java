import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.NearestPostCode;
import model.PostCodeResult;
import model.PostCodeValidateStatus;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.IOException;

public class PostCode {
    //Class members
    private String postcode;
    private CloseableHttpClient httpClient;
    private Gson gson;

    //Final Member
    private static final String postCodeUrl = "https://api.postcodes.io/postcodes/";

    //Parameter Constructor with accept postcode string
    public PostCode(String postcode){
        this.postcode = postcode;
        this.httpClient = HttpClients.createDefault();
        this.gson = new GsonBuilder().create();
    }

    public PostCode() {
        this.httpClient = HttpClients.createDefault();
        this.gson = new GsonBuilder().create();
    }

    public PostCodeValidateStatus validatePostCode(){
        String postcodeUrl = String.format(postCodeUrl+"%s/validate", this.postcode);
        return gson.fromJson(processUrl(postcodeUrl), PostCodeValidateStatus.class);
    }

    //Process the API request of url
    private String processUrl(String url){
        String responseStr = "";
        HttpGet httpGet = new HttpGet(url);
        try{
            CloseableHttpResponse closeableHttpResponse = this.httpClient.execute(httpGet);
            try{
                HttpEntity entity = closeableHttpResponse.getEntity();
                responseStr = EntityUtils.toString(entity);
            }
            finally {
                closeableHttpResponse.close();
            }

        }catch (IOException ignored){
            System.out.println("Connection Failed");
        }
        return responseStr;
    }

    public PostCodeResult postcodeResult(){
        String postcodeUrl = String.format(postCodeUrl+"%s", this.postcode);
        return gson.fromJson(processUrl(postcodeUrl), PostCodeResult.class);
    }
    // Show nearest PostCode
    public NearestPostCode checkNearestPostcodes(){
        String url = String.format(postCodeUrl + "%s/nearest", postcode);
        return gson.fromJson(processUrl(url), NearestPostCode.class);
    }

    //Show Random PostCode
    public PostCodeResult randomPostCode(){
        return gson.fromJson(processUrl("https://api.postcodes.io/random/postcodes"), PostCodeResult.class);
    }

}
