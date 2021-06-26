package com.bestbuy.RestAssuredCucumber.stepDefinition;

import com.bestbuy.RestAssuredCucumber.apiCollection.CreateProductAPI;
import com.bestbuy.RestAssuredCucumber.apiCollection.DeleteProductAPI;
import com.bestbuy.RestAssuredCucumber.testBase.BestBuy_Base;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class DeleteproductSteps {

    int productID=0;

    @Before
    public void setUp() {
        BestBuy_Base.init();
    }

    @Given("I have the id of the product to be deleted")
    public void i_have_the_id_of_the_product_to_be_deleted() {
        productID=CreateProductAPI.getProductVal();
    }

    @When("I post delete request to delete request API endpoint")
    public void i_post_delete_request_to_delete_request_api_endpoint() {
        BestBuy_Base.response=DeleteProductAPI.deleteAsPerID(productID);
        BestBuy_Base.response.prettyPrint();
    }

    @Then("I validate response code as {int}")
    public void i_validate_response_code_as(int responseCode) {
        Assert.assertEquals(BestBuy_Base.response.getStatusCode(),responseCode);
    }

}
