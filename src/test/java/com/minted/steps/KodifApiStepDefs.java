package com.minted.steps;

import com.minted.utility.ConfigurationReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class KodifApiStepDefs {

    Response response;

    @When("user loging in with correct credential")
    public void user_loging_in_with_correct_credential() {
        Map<String, Object> kodifUser = new LinkedHashMap<>();
        kodifUser.put("email", "usenkanov@gmail.com");
        kodifUser.put("password", "massword");


        System.out.println(kodifUser);

        response = given().contentType(ContentType.JSON).body(kodifUser).
                when().post(ConfigurationReader.getProperty("baseURI") + "/login").prettyPeek();



    }
    @Then("success code should be {int} and url should be valid")
    public void success_code_should_be_and_url_should_be_valid(Integer int1) {
        String token = response.
                path("payload.accessToken");
        System.out.println("********************\n\n\n token = " + token + "\n\n\n *************************");

        response.then().statusCode(int1);

    }


}
