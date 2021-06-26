package com.bestbuy.RestAssuredCucumber.stepDefinition;

import com.bestbuy.RestAssuredCucumber.apiCollection.CreateProductAPI;
import com.bestbuy.RestAssuredCucumber.testBase.BestBuy_Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import java.util.List;
import java.util.Map;

public class CreateNewProductSteps {

    @Before
    public void setUp() {
        BestBuy_Base.init();
    }

    @Given("I create product by using create new product API")
    public void i_create_product_by_using_create_new_product_api() {
        CreateProductAPI.makeCreateProductRequest();
    }

    @When("I provide valid data for product creation")
    public void i_provide_valid_data_for_product_creation(DataTable dataTable) {

        List<Map<String, String>> productList = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> f : productList) {
            BestBuy_Base.response=CreateProductAPI.CreateProduct(f.get("name"), f.get("type"), Integer.parseInt(f.get("price")), Integer.parseInt(f.get("shipping")), f.get("upc"), f.get("description"), f.get("manufacturer"), f.get("model"), f.get("url"), f.get("image"));
            BestBuy_Base.response.prettyPrint();
        }

    }

    @When("I store id of the product")
    public void i_store_id_of_the_product() {
       String productID=BestBuy_Base.response.jsonPath().get("id").toString();
       CreateProductAPI.setProductVal(productID);
    }

    @Then("I validate status code {int}")
    public void i_validate_status_code(int statusCode) {

        Assert.assertEquals(BestBuy_Base.response.getStatusCode(),statusCode);

    }
}
