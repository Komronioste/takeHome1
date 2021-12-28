package takeHomeProject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import takeHomeProject.testbase.BaseClass;

public class WebOfDevicesPageElements extends BaseClass {

	@FindBy(xpath = "//*[@id='w3c_overview']/div[2]/div[1]/h2/a")
	public WebElement multiModalAccessButton;

	public WebOfDevicesPageElements() {
		PageFactory.initElements(driver, this);
	}

}
