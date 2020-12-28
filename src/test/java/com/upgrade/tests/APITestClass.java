package com.upgrade.tests;

import com.upgrade.utulities.APITestBase;
import static io.restassured.RestAssured.*;
import com.upgrade.utulities.ConfigReader;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.Assert;
import java.util.HashMap;
import java.util.Map;

public class APITestClass extends APITestBase {

    @Test
    public void post01(){

        // Creating body before POST.
        Map<String,String> reqBody = new HashMap<>();
        reqBody.put("username",ConfigReader.getProperty("email"));
        reqBody.put("password",ConfigReader.getProperty("password"));

        // POST response.
        Response response = given().
                            spec(spec01).
                            headers(ConfigReader.getProperty("header1"),ConfigReader.getProperty("coding-challenge"),
                                    ConfigReader.getProperty("header2"),ConfigReader.getProperty("uuId"),
                                    ConfigReader.getProperty("header3"),ConfigReader.getProperty("application/json")).
                            body(reqBody).
                            when().
                            post();
        // Status code check
        response.then().assertThat().statusCode(200);

        // Positive test case assertion
        String expectedProductType = ConfigReader.getProperty("productType");
        JsonPath json =  response.jsonPath();
        String actualProductType = json.getList("loanApplications.findAll{String.valueOf(it.productType)}.productType").toString();
        actualProductType = actualProductType.replace("[" , "").replace("]" , "");
        Assert.assertEquals(actualProductType,expectedProductType);

    }

    @Test
    public void invalidCredentials() {
        // Creating body with invalid credentials, before POST.
        Map<String,String> reqBody = new HashMap<>();
        reqBody.put("username",ConfigReader.getProperty("invalidEmail"));
        reqBody.put("password",ConfigReader.getProperty("invalidPassword"));

        // POST response.
        Response response = given().
                spec(spec01).
                headers(ConfigReader.getProperty("header1"),ConfigReader.getProperty("coding-challenge"),
                        ConfigReader.getProperty("header2"),ConfigReader.getProperty("uuId"),
                        ConfigReader.getProperty("header3"),ConfigReader.getProperty("application/json")).
                body(reqBody).
                when().
                post();

        //Negative test case assertion.
        response.then().assertThat().statusCode(401);
    }
}
