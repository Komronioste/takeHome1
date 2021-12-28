package takeHomeProject.steps;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import takeHomeProject.utils.CommonMethods;

public class ProjectSteps extends CommonMethods {

	@Given("Go to standards")
	public void go_to_standards() {
		click(home.standardsTabButton);
	}

	@When("click on web of devices tab")
	public void click_on_web_of_devices_tab() {
		click(standards.webOfDevices);
	}

	@When("click on multimodal access tab")
	public void click_on_multimodal_access_tab() {
		click(webOfDevices.multiModalAccessButton);
	}

	@Then("validate multimodal access header is present")
	public void validate_multimodal_access_header_is_present() {
		Assert.assertEquals(true, multiModal.multiModalTitle.isDisplayed());
	}

	@When("click on web design button")
	public void click_on_web_design_button() {
		click(standards.webOfDesign);
	}

	@When("click on htmlcss tab")
	public void click_on_htmlcss_tab() {
		click(webDesign.htmlCssButton);
	}

	@Then("I validate htmlcss header is present")
	public void i_validate_htmlcss_header_is_present() {

		Assert.assertEquals(true, htmlcss.HtmlCssTitle.isDisplayed());
	}

}
