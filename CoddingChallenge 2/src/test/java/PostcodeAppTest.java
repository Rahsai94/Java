import model.NearestPostCode;
import model.PostCodeInfo;
import model.PostCodeResult;
import model.PostCodeValidateStatus;
import org.junit.Test;

import static org.junit.Assert.*;


public class PostcodeAppTest {

    @Test public void checkPostcodeDetailsNotNull(){
        PostCode postCode = new PostCode("SE145XE");
        PostCodeResult postCodeInfo = postCode.postcodeResult();
        assertNotNull(postCodeInfo);
    }

    @Test public void checkPostcodeDetails(){
        String country = "England";
        String region = "London";
        PostCode postCode = new PostCode("SE145XE");
        PostCodeInfo postCodeInfo = postCode.postcodeResult().getResult();
        assertEquals(country, postCodeInfo.getCountry());
        assertEquals(region, postCodeInfo.getRegion());
    }

    @Test public void checkPostcodeNearestNotNull(){
        PostCode postCode = new PostCode("SE145XE");
        NearestPostCode nearestPostCode = postCode.checkNearestPostcodes();
        assertNotNull(nearestPostCode);
    }

    @Test public void checkRandomPostcodeNotNull(){
        PostCode postCode = new PostCode();
        PostCodeInfo postCodeInfo = postCode.randomPostCode().getResult();
        assertNotNull(postCodeInfo);
    }

    @Test public void checkCorrectPostCode(){
        PostCode postCode = new PostCode("SE145XE");
        PostCodeValidateStatus postCodeValidateStatus = postCode.validatePostCode();
        assertTrue(postCodeValidateStatus.isResult());
        assertEquals(200, postCodeValidateStatus.getStatus());
    }

    @Test public void checkInCorrectPostCode(){
        PostCode postCode = new PostCode("SE245XE");
        PostCodeValidateStatus postCodeValidateStatus = postCode.validatePostCode();
        assertFalse(postCodeValidateStatus.isResult());
        assertEquals(200, postCodeValidateStatus.getStatus());
    }

}