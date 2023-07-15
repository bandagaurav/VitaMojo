package pojo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BaseTest {



    public static Response sendRequest(RequestParams requestParams) {
        Response res = null;
        try {




            res= RestAssured.given().urlEncodingEnabled(false)
                    .headers(requestParams.getHeaders()).body(requestParams.getBody())
                    .contentType(ContentType.JSON).post(requestParams.getEndPointURL());


            System.out.println("Response Body"+res.getBody().asString());
            System.out.println("Response Code"+res.getStatusCode());

            return res;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return res;
    }}
