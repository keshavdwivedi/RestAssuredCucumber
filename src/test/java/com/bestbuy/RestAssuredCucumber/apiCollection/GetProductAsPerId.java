package com.bestbuy.RestAssuredCucumber.apiCollection;

import com.bestbuy.RestAssuredCucumber.testBase.BestBuy_Base;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetProductAsPerId extends BestBuy_Base {

    public static Response getProductAsPerID(int productID){
        response=RestAssured.given().get(propertyConfig.getProperty("Getproductid")+productID);
        return response;
    }
}
