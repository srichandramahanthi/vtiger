package genericlibraries;
//contains all details done
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pomPages.ContactsPage;
import pomPages.CreateNewContactPage;
import pomPages.CreateNewEventPage;
import pomPages.CreateNewLeadPage;
import pomPages.CreateNewOrganizationPage;
import pomPages.DuplicatingLeadPage;
import pomPages.HomePage;
import pomPages.LeadsPage;
import pomPages.LoginPage;
import pomPages.NewContactInfoPage;
import pomPages.NewEventInfoPage;
import pomPages.NewLeadInfoPage;
import pomPages.NewOrgInfoPage;
import pomPages.OrganizationPage;

public class BaseClass {
	protected PropertiesUtility property;
	protected ExcelUtility excel;
	protected JavaUtility jutil;
	protected WebDriverUtility web;
	protected WebDriver driver;
	protected LoginPage login;
	protected HomePage home;
	protected OrganizationPage org;
	protected ContactsPage contacts;
	protected LeadsPage lead;
	protected CreateNewOrganizationPage createOrg;
	protected CreateNewContactPage createContact;
	protected CreateNewEventPage createEvent;
	protected CreateNewLeadPage createLead;
	protected NewOrgInfoPage newOrgInfo;
	protected NewContactInfoPage newContactInfo;
	protected NewLeadInfoPage newLeadInfo;
	protected NewEventInfoPage newEventInfo;
	protected DuplicatingLeadPage duplicatingLead; 
	
	public static JavaUtility sjutil;
	public static WebDriver sdriver;
	
	//@BeforeSuite;
	//@BeforeTest;
	@BeforeClass
	public void classSetup()
	{
		property = new PropertiesUtility();
		excel = new ExcelUtility();
		jutil = new JavaUtility();
		web = new WebDriverUtility();
		property.propertiesInitialization(IconstantPath.PROPERTIES_PATH);
		driver = web.launchBrowser(property.readFromProperties("browser"));
		web.maximizeBrowser();
		web.waitTillElementFound(Long.parseLong(property.readFromProperties("time")));
		sdriver = driver;
		sjutil = jutil;
	}
	@BeforeMethod
	public void methodSetup()
	{
		excel.excelInitialization(IconstantPath.Excel_Path);
		login = new LoginPage(driver);
		home = new HomePage(driver);
		org = new OrganizationPage(driver);
		contacts = new ContactsPage(driver);
		lead = new LeadsPage(driver);
		createOrg = new CreateNewOrganizationPage(driver);
		createContact = new CreateNewContactPage(driver);
		createEvent = new CreateNewEventPage(driver);
		createLead = new CreateNewLeadPage(driver);
		newOrgInfo = new NewOrgInfoPage(driver);
		newContactInfo = new NewContactInfoPage(driver);
		newLeadInfo = new NewLeadInfoPage(driver);
		newEventInfo = new NewEventInfoPage(driver);
		duplicatingLead = new DuplicatingLeadPage(driver);
		
		web.navigateToApp(property.readFromProperties("url"));
		Assert.assertTrue(driver.getTitle().contains("vtiger"));
	    login.loginToApp(property.readFromProperties("username"), property.readFromProperties("password"));
		Assert.assertTrue(driver.getTitle().contains("Home"));
	}
	@AfterMethod
	public void methodTearDown() {
		home.signOutOfVtiger(web);
		excel.closeExcel();
	}
	
	@AfterClass
	public void classTearDown()
	{
		web.quitAllWindows();
	}
	//@AfterTest
//	@AfterSuite

}
