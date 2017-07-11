package com.gmail.perva4ina.cucumber.steps;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeClass;

@CucumberOptions(features = "src/test/resources/cucumber/features/iuaLogin.feature", format = { "pretty",
        "html:target/site/cucumber-pretty",
        "rerun:target/rerun.txt",
        "json:target/cucumber1.json" })

public class CucumberTestRunner extends AbstractTestNGCucumberTests {

}

