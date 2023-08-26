package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	//declaration
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement plusButton;
	//Initialization
	public OrganizationPage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}
	//Utilization
	public void clickPlusButton()
	{
		plusButton.click();
	}
	

}
