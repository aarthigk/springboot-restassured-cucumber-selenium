package com.example.demo.api;



import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PetstoreApi {
    private static final String BASE_URL = "https://petstore.swagger.io/v2/pet/";

    public Response getPetsByStatus(String endpoint, String status) {
        return RestAssured.given()
                .param("status", status)
                .when()
                .get(BASE_URL + endpoint);
    }
}
