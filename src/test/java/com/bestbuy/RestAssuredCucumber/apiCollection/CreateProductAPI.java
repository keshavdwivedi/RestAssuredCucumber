package com.bestbuy.RestAssuredCucumber.apiCollection;

import com.bestbuy.RestAssuredCucumber.pojos.Product;
import com.bestbuy.RestAssuredCucumber.testBase.BestBuy_Base;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProductAPI extends BestBuy_Base {

   private static String productVal;

   public static int getProductVal() {
      return Integer.parseInt(productVal);
   }

   public static void setProductVal(String productVal) {
      CreateProductAPI.productVal= productVal;
   }

   public static RequestSpecification makeCreateProductRequest(){
      BestBuy_Base.requestSpecification=RestAssured.given();
      requestSpecification.contentType(ContentType.JSON);
      return BestBuy_Base.requestSpecification;
   }

   public static Response CreateProduct(String name, String type, int price, int shipping, String upc, String description, String manufacturer, String model, String url, String image){
      Product product=new Product(name,type,price,shipping,upc,description,manufacturer,model,url,image);
      product.setName(name);
      product.setType(type);
      product.setPrice(price);
      product.setShipping(shipping);
      product.setUpc(upc);
      product.setDescription(description);
      product.setManufacturer(manufacturer);
      product.setModel(model);
      product.setUrl(url);
      product.setImage(image);

      BestBuy_Base.response=makeCreateProductRequest()
              .body(product)
              .post(propertyConfig.getProperty("CreateProduct"));
      return BestBuy_Base.response;
   }

}
