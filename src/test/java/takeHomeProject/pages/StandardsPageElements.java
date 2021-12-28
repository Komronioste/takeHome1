package takeHomeProject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import takeHomeProject.testbase.BaseClass;

public class StandardsPageElements extends BaseClass {

	@FindBy(xpath = "//*[@id='w3c_content_body']/div/div[1]/ul[1]/li[2]/h2/a")
	public WebElement webOfDevices;

	@FindBy(xpath = "//*[@id='w3c_content_body']/div/div[1]/ul[1]/li[1]/h2/a")
	public WebElement webOfDesign;

	@FindBy(xpath = "//*[@id='w3c_main']/div[2]/ul/li[1]/a")
	public WebElement standardsMenuButton;
	
	@FindBy (xpath = "//*[@id='w3c_main']/div[3]/h1")
	public WebElement standardsHeader;

	public StandardsPageElements() {
		PageFactory.initElements(driver, this);
	}

}
