package com.bestbuy.RestAssuredCucumber.apiCollection;

import com.bestbuy.RestAssuredCucumber.testBase.BestBuy_Base;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class GetOrderAPI extends BestBuy_Base {

    public static String makeAPIPath(int limit){
        String GetAPIPath=propertyConfig.getProperty("GetAllProductsPath")+"?$limit="+limit;
        return GetAPIPath;
    }

    public static Response GetAllProduct(int productLimit){
       response =given().contentType(ContentType.JSON).get(makeAPIPath(productLimit));
       return response;
    }

}
