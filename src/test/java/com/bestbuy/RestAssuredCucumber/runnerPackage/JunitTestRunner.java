package com.bestbuy.RestAssuredCucumber.runnerPackage;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/"}
        ,glue={"com.bestbuy.RestAssuredCucumber.stepDefinition"},
        plugin = {"pretty", "json:target/Report/JsonReport/report.json", "junit:target/Report/Junitreports/report.xml",
        "html:target/Report/HTMLReport"})

public class JunitTestRunner {
}
