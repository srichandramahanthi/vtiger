package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DuplicatingLeadPage {
	//Declaration
	@FindBy(xpath="//span[@class='1vtHeaderText']")
	private WebElement pageHeader;
	@FindBy(name="lastname")
	private WebElement lastNameTF;
	@FindBy(xpath="//input[normalize-space(@value)='Save']")
	private WebElement saveButton;
	//Initialization
	public DuplicatingLeadPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public String getHeader()
	{
		return pageHeader.getText();
	}
	public void setLastName(String lastName)
	{
		lastNameTF.clear();
		lastNameTF.sendKeys(lastName);	
	}
	public void clickSaveButton()
	{
		saveButton.click();
	}
	public String getPageHeader() {
		// TODO Auto-generated method stub
		return pageHeader.getText();
	}
	
}
