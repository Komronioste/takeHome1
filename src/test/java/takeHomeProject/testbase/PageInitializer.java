package takeHomeProject.testbase;

import takeHomeProject.pages.HomePageElements;
import takeHomeProject.pages.HtmlCssPageElements;
import takeHomeProject.pages.MultimodalAccessPageElements;
import takeHomeProject.pages.StandardsPageElements;
import takeHomeProject.pages.WebDesignPageElements;
import takeHomeProject.pages.WebOfDevicesPageElements;

public class PageInitializer extends BaseClass{
	
	public static HomePageElements home;
	public static StandardsPageElements standards;
	public static WebDesignPageElements webDesign;
	public static WebOfDevicesPageElements webOfDevices;
	public static MultimodalAccessPageElements multiModal;
	public static HtmlCssPageElements htmlcss;
	
	
	public static void initialize()
	{
		home = new HomePageElements();
		standards = new StandardsPageElements();
		webDesign = new WebDesignPageElements();
		webOfDevices = new WebOfDevicesPageElements();
		multiModal = new MultimodalAccessPageElements();
		htmlcss = new HtmlCssPageElements();
		
	}

}
