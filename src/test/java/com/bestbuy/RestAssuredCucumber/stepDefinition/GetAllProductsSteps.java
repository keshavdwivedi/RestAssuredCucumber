package com.bestbuy.RestAssuredCucumber.stepDefinition;

import com.bestbuy.RestAssuredCucumber.apiCollection.GetOrderAPI;
import com.bestbuy.RestAssuredCucumber.testBase.BestBuy_Base;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class GetAllProductsSteps {

    @Before
    public void setUp(){
        BestBuy_Base.init();
    }

    @Given("I want to get details of {int} products")
    public void i_want_to_get_details_of_products(int limit) {
        GetOrderAPI.makeAPIPath(limit);
    }

    @When("I get the products details of {int} products using Get all product API endpoint")
    public void i_get_the_products_details_of_products_using_get_all_product_api_endpoint(int productLimit) {
       BestBuy_Base.response=GetOrderAPI.GetAllProduct(productLimit);
    }

    @Then("I validate status code as {int}")
    public void i_validate_status_code_as(int statusCode) {
        Assert.assertEquals(BestBuy_Base.response.getStatusCode(),statusCode);
    }

    @Then("I validate product count as {int}")
    public void i_validate_product_count_as(int productTotal) {
        Assert.assertEquals(BestBuy_Base.response.jsonPath().get("total").toString(),String.valueOf(productTotal));
    }
}
