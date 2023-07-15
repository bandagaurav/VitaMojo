package step_definations;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pojo.*;

import java.util.HashMap;

public class VitaMojoAPITest extends BaseTest {
    Profile profile;
    SignupDTO signupDTO;
    LoginDTO loginDTO;


    RequestParams requestParams;
private String firstName="Gaurav";
    private String Password="Saibaba786";
    private String storeUUID="ced48917-54c2-40ad-a646-5315f5dcb28f";
    private String locale="en-GB";

    private String subscription="marketing";


    private String email="";
    private String fullemailaddress;
    private HashMap headers;
    ObjectMapper objectMapper;


    @BeforeClass
    public void serviceSetup(){
        profile=new Profile();
        signupDTO=new SignupDTO();
        requestParams=new RequestParams();
        headers=new HashMap();
        objectMapper=new ObjectMapper();
        loginDTO=new LoginDTO();

    }

@Test(description = "User wants to sign up")
public void signUpRequest() throws JsonProcessingException {
    String email = "selenium.srtester";
    String random = RandomStringUtils.random(2, true, false);
    fullemailaddress = email + random + "@gmail.com";
        profile.setFirstName(firstName);

        String[] subscriptions=new String[]{subscription};
        signupDTO.setSubscriptions(subscriptions);
        signupDTO.setEmail(fullemailaddress);
        signupDTO.setPassword(Password);
    signupDTO.setStoreUUID(storeUUID);

    signupDTO.setLocale(locale);

    signupDTO.setProfile(profile);

    requestParams.setBody(objectMapper.writeValueAsString(signupDTO));
headers.put("tenant",Constants.TENANT);
requestParams.setHeaders(headers);
requestParams.setEndPointURL(Constants.SIGNUPURL);

    Response res=sendRequest(requestParams);

    Assert.assertEquals(res.statusCode(), HttpStatus.SC_CREATED);



}


    @Test(description = "User wants to login",dependsOnMethods = {"signUpRequest"})
    public void loginRequest() throws JsonProcessingException {
        loginDTO.setEmail(fullemailaddress);
        loginDTO.setPassword(Password);
        requestParams.setBody(objectMapper.writeValueAsString(loginDTO));
        headers.put("tenant",Constants.TENANT);
        requestParams.setHeaders(headers);
        requestParams.setEndPointURL(Constants.LOGINURL);

        Response res=sendRequest(requestParams);

        Assert.assertEquals(res.statusCode(), HttpStatus.SC_CREATED);



    }

}
