package com.bank.account.restassured;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.post;

import io.restassured.RestAssured;

public class TransferControllerRestAssuredTest {
    
    @Before
    public void setBaseURI() {
        RestAssured.baseURI = "http://localhost:8080";
        get("/transfer").then().statusCode(200);
    }

    @Test
    public void testTransferMoneySuccess() {
        post("/transfer/123456/654321/200").then().statusCode(200);
        float balanceFrom = get("/account/123456").then().assertThat().statusCode(200).extract().path("balance");
        float balanceTo = get("/account/654321").then().assertThat().statusCode(200).extract().path("balance");
        assertEquals(4800.0, balanceFrom, 0);
        assertEquals(5200.0, balanceTo, 0);
    }

    @Test
    public void testTransferMoneyFailure() {
        post("/transfer/123456/654321/-20").then().statusCode(400);
    }
}
