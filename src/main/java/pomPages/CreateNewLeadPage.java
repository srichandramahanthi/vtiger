package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewLeadPage {
	//Declaration
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement pageHeader;
	
	@FindBy(name="lastname")
	private WebElement lastNameTF;
	
	@FindBy(name="company")
	private WebElement companyTF;
	
	@FindBy(xpath="//input[normalize-space(@value)='Save']")
	private WebElement saveButton;
	
	//Initialization
	public CreateNewLeadPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public String getPageHeader()
	{
		return pageHeader.getText();
	}
	public void setlastName(String lastName)
	{
		lastNameTF.sendKeys(lastName);
	}
	public void setCompanyName(String companyName)
	{
		companyTF.sendKeys(companyName);
	}
	public void clickSaveButton()
	{
		saveButton.click();
	}

}
