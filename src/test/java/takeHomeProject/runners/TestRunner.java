package takeHomeProject.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		// we can specify which feature/features to run
		features = "src/test/resources/features/",
		// we can specify where the code for the above feature is located
		glue = "takeHomeProject.steps",

		dryRun = false,

		tags = "@regression",

		monochrome = true,

		plugin = {

				"pretty",

				"json:target/cucumber.json"

		}

)

public class TestRunner {

}
