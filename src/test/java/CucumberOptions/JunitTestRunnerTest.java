package CucumberOptions;



import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



//html reports, xml reports, json reports, junit reports, extent report

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features", glue="stepDefinition",
 monochrome=true,tags="@OfferPage or @PlaceOrder",
 plugin= {"html:target/cucumber.html", "json:target/cucumber.json",
		 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class JunitTestRunnerTest{

	
	}

