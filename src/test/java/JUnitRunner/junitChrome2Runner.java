package JUnitRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Feature/feature2.feature",
		glue = {"stepDefinations" },
		plugin = {"json:target/jsonReports/2cucumber.json"}
		//tags = {"@WomenSection"}
		)

public class junitChrome2Runner {

}
