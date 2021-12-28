package takeHomeProject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import takeHomeProject.testbase.BaseClass;

public class WebDesignPageElements extends BaseClass {

	@FindBy(xpath = "//*[@id='w3c_overview']/div[1]/div[1]/h2/a")
	public WebElement htmlCssButton;

	public WebDesignPageElements() {
		PageFactory.initElements(driver, this);
	}

}
