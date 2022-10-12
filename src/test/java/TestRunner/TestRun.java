package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		
		features=".//Features/Login.feature",
		plugin= {"pretty",
		"html:target/index.html"},
		glue="stepDefinations",
		dryRun=false,
		monochrome=true
		
		
		)
public class TestRun {

}
