package takeHomeProject.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import takeHomeProject.testbase.BaseClass;
import takeHomeProject.utils.CommonMethods;

public class Hooks extends BaseClass {

	@Before
	public void start() {
		setUp();
	}

	@After
	public void end(Scenario scenario) {

		byte[] picture;

		if (scenario.isFailed()) {
			// save it in failed
			picture = CommonMethods.takeScreenshot("/failed/" + scenario.getName());
		} else {
			// save it in passed
			picture = CommonMethods.takeScreenshot("/passed/" + scenario.getName());
		}

		scenario.attach(picture, "image/png", scenario.getName());

		tearDown();
	}

}
