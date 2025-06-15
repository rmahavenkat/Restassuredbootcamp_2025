package api_Runner;


import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

		plugin = { "pretty", "html:target/apireports.html","json:target/cucumber-reports/Cucumber.json" }, // reporting purpose
		dryRun = false, monochrome = true, // console output color
	//	 tags = "", // tags from feature file
		features = { "src/test/resources/api_featurefiles" }, // location of feature files
		glue = { "api_stepDefinition" }) // location of step definition files


public class TestRunner extends AbstractTestNGCucumberTests {

	@Override
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
