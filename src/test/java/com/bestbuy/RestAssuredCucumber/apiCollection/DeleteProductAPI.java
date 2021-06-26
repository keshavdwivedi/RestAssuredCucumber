package com.bestbuy.RestAssuredCucumber.apiCollection;

import com.bestbuy.RestAssuredCucumber.testBase.BestBuy_Base;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class DeleteProductAPI extends BestBuy_Base {

    public static Response deleteAsPerID(int deletionID){
        response=given().delete(propertyConfig.getProperty("DeleteProduct")+deletionID);
        return response;
    }


}
