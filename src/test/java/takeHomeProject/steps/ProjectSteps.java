package takeHomeProject.steps;

import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import takeHomeProject.utils.CommonMethods;

public class ProjectSteps extends CommonMethods {

	List<WebElement> allLinks;

	@Given("Go to standards")
	public void go_to_standards() {
		home.standardsTabButton.click();
	}

	@When("click on web of devices tab")
	public void click_on_web_of_devices_tab() {
		standards.webOfDevices.click();
	}

	@When("click on multimodal access tab")
	public void click_on_multimodal_access_tab() {
		webOfDevices.multiModalAccessButton.click();
	}

	@Then("validate multimodal access header is present")
	public void validate_multimodal_access_header_is_present() throws InterruptedException {

		Thread.sleep(2000);

		checkAllLinks(driver.getCurrentUrl()); // to check status code of current URL

		System.out.println();

		checkConsole(); // prints errors from console

		Assert.assertEquals(true, multiModal.multiModalTitle.isDisplayed());

	}

	@When("click on web design button")
	public void click_on_web_design_button() {
		standards.webOfDesign.click();
	}

	@When("click on htmlcss tab")
	public void click_on_htmlcss_tab() {
		webDesign.htmlCssButton.click();
	}

	@Then("I validate htmlcss header is present")
	public void i_validate_htmlcss_header_is_present() throws InterruptedException {

		Thread.sleep(2000);

		checkAllLinks(driver.getCurrentUrl()); // to check status code of current URL

		System.out.println();

		checkConsole(); // this custom method prints if there are errors in console. can put it in
						// soft/hard assert instead

		Assert.assertEquals(true, htmlcss.HtmlCssTitle.isDisplayed());

	}

	@When("collect all links")
	public void collect_all_links() {
		allLinks = driver.findElements(By.tagName("a"));

	}

	@Then("check all links")
	public void check_all_links() throws InterruptedException {

		System.out.println(allLinks.size());
		System.out.println(allLinks.get(1));

		String url = "";

		Iterator<WebElement> iterator = allLinks.iterator();
		while (iterator.hasNext()) {

			url = iterator.next().getAttribute("href");

			checkAllLinks(url); // this custom method is in CommonMethods. we can apply soft or hard asserts on
								// returned code instead of just printing everything to console
		}

	}

	@When("go to badpage")
	public void go_to_badpage() throws InterruptedException {
		driver.navigate().to("https://www.w3.org/standards/badpage");
		Thread.sleep(1000);

	}

	@Then("validate status code is {int}")
	public void validate_status_code_is(Integer int1) {
		checkAllLinks(driver.getCurrentUrl());
	}
}
