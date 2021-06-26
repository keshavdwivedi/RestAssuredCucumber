package com.bestbuy.RestAssuredCucumber.testBase;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BestBuy_Base {

    public static Properties propertyConfig = new Properties();
    public static FileInputStream fis;
    public static Response response;
    public static RequestSpecification requestSpecification;

    public static void init() {

        try {
            fis = new FileInputStream("./src/test/resources/propertiesConfig/BestBuyConfig.properties");
            propertyConfig.load(fis);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        RestAssured.baseURI=propertyConfig.getProperty("BaseURI");
      }
    }
