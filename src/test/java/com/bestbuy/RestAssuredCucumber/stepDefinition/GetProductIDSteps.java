package com.bestbuy.RestAssuredCucumber.stepDefinition;

import com.bestbuy.RestAssuredCucumber.apiCollection.CreateProductAPI;
import com.bestbuy.RestAssuredCucumber.apiCollection.GetProductAsPerId;
import com.bestbuy.RestAssuredCucumber.testBase.BestBuy_Base;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class GetProductIDSteps {

    int productID=0;

    @Before
    public void setUp(){
        BestBuy_Base.init();
    }

    @Given("I have the id of the product whose details are to be fetched")
    public void i_have_the_id_of_the_product_whose_details_are_to_be_fetched() {
        productID=CreateProductAPI.getProductVal();
    }

    @When("I get the product details as per given id")
    public void i_get_the_product_details_as_per_given_id() {
        BestBuy_Base.response=GetProductAsPerId.getProductAsPerID(productID);
        BestBuy_Base.response.prettyPrint();
    }

    @Then("I get details of product along with status code as {int}")
    public void i_get_details_of_product_along_with_status_code_as(int statusCode) {
        Assert.assertEquals(BestBuy_Base.response.getStatusCode(),statusCode);
    }
}
