package takeHomeProject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import takeHomeProject.testbase.BaseClass;

public class HomePageElements extends BaseClass{
	
	
	@FindBy (xpath = "//*[@id='w3c_mast']/h1")
	public WebElement homeLogo;
	
	@FindBy (xpath = "//*[@id='w3c_nav']/form/ul/li[1]")
	public WebElement standardsTabButton;
	

	public HomePageElements() {
		PageFactory.initElements(driver, this);
	}
}
 