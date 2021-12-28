package takeHomeProject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import takeHomeProject.testbase.BaseClass;

public class HtmlCssPageElements extends BaseClass {

	@FindBy(xpath = "//*[@id='w3c_main']/div[3]/h1")
	public WebElement HtmlCssTitle;

	public HtmlCssPageElements() {

		PageFactory.initElements(driver, this);
	}

}
