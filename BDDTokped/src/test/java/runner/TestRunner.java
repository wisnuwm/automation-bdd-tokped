package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
	
	@RunWith(Cucumber.class)
	@CucumberOptions(features="src/test/resources/Features/BDD_Search_Tokped.feature",
	glue= {"StepDefinition"},
	plugin ={"json:target/cucumber.json"})

	public class TestRunner {
}
