package optionsRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;




  @RunWith(Cucumber.class)
  
  @CucumberOptions(features="src/test/java/features/UserAuthentication.feature",glue ="stepDefinitions"
  ,monochrome=true, tags ="@SmokeTest or @OffersPage", plugin=
  {"html:target/cucumber.html", "json:target/cucumber.json",
  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
  "rerun:target/failed_scenarios.txt"}) public class TestRunner {
  
  
  
  }
 