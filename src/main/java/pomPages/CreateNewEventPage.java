package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericlibraries.JavaUtility;
import genericlibraries.WebDriverUtility;

public class CreateNewEventPage {
	//Declaration
	private String commonPath="//div[@class='calender' and contains(@style,'block')]"+"/descendant::td[%s]";
	@FindBy(xpath="//b[text()='Create To Do']")
	private WebElement pageHeader;
	@FindBy(name="subject")
	private WebElement subjectTF;
	@FindBy(id="iscal_trigger_date_start")
	private WebElement startDateCalenderImage;
	@FindBy(id="jscal_trigger_due_date")
	private WebElement dueDateCalenderImage;
	@FindBy(xpath="//input[@value=' Save']")
	private WebElement saveButton;
	//Initialization
	public CreateNewEventPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public String getPageHeader()
	{
		return pageHeader.getText();
	}
	public void setSubject(String subject)
	{
		subjectTF.sendKeys(subject);
	}
	public void clickOnstartDate()
	{
		startDateCalenderImage.click();	
	}
	public void chooseRequiredDate(WebDriverUtility web,String reqDataOfYear,JavaUtility jutil)
	{
		String[] s=reqDataOfYear.split("-");
		int reqYear=Integer.parseInt(s[0]);
		int reqMonth=Integer.parseInt(s[1]);
		String reqData =s[2];
		String actMonthYear=web.convertStringToDynamicXpath(commonPath, "@class='title'").getText();
		String[] str=actMonthYear.split(", ");
		int actYear=Integer.parseInt(str[1]);
		while(actYear<reqYear)
		{
			web.convertStringToDynamicXpath(commonPath, "text()='>>'").click();
			actMonthYear=web.convertStringToDynamicXpath(commonPath, "@class='title'").getText();
			str=actMonthYear.split(", ");
			actYear=Integer.parseInt(str[1]);
		}
		int actMonth=jutil.convertMonthToInt(str[0]);
		while(actMonth<reqMonth)
		{
			web.convertStringToDynamicXpath(reqData, "text()='>'").click();
			actMonthYear=web.convertStringToDynamicXpath(commonPath, "@class='title'").getText();
			str=actMonthYear.split(", ");
			actMonth=jutil.convertMonthToInt(str[0]);
		}
		while(actMonth<reqMonth)
		{
			web.convertStringToDynamicXpath(reqData, "text()='<'").click();
			actMonthYear=web.convertStringToDynamicXpath(commonPath, "@class='title'").getText();
			str=actMonthYear.split(", ");
			actMonth=jutil.convertMonthToInt(str[0]);
		}
		web.convertStringToDynamicXpath(reqData, "text()='"+reqData+"'").click();
	}
	public void clickOnDueData()
	{
		dueDateCalenderImage.click();
	}
	public void clickSaveButton() 
	{
		saveButton.click();
	}

}
