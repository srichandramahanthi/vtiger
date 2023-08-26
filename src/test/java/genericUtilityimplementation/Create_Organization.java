package genericUtilityimplementation;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import genericlibraries.ExcelUtility;
import genericlibraries.IconstantPath;
import genericlibraries.JavaUtility;
import genericlibraries.PropertiesUtility;
import genericlibraries.WebDriverUtility;

public class Create_Organization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			PropertiesUtility property = new PropertiesUtility();
			ExcelUtility excel = new ExcelUtility();
			JavaUtility jutil = new JavaUtility();
			WebDriverUtility webUtil = new WebDriverUtility();
					
			property.propertiesInitialization(IconstantPath.PROPERTIES_PATH);
			excel.excelInitialization(IconstantPath.Excel_Path);
			
			
//	     	  WebDriver driver = new ChromeDriver();
//	        driver.manage().window().maximize();
//	        driver.get("http://localhost:8888/");
//	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        
			WebDriver driver = webUtil.launchBrowser(property.readFromProperties("browser"));
			webUtil.maximizeBrowser();
			webUtil.navigateToApp(property.readFromProperties("url"));
			webUtil.waitTillElementFound(Long.parseLong(property.readFromProperties("time")));
			
	        if(driver.getTitle().contains("vtiger"))
	        	System.out.println("Login Page Displayed");
	        else
	        	System.out.println("LoginPage Not Found");
	        
	        driver.findElement(By.name("user_name")).sendKeys(property.readFromProperties("username"));
	        driver.findElement(By.name("user_password")).sendKeys(property.readFromProperties("password"));
	        driver.findElement(By.id("submitButton")).submit();
	        
	        if(driver.getTitle().contains("Home"))
	        	System.out.println("Home Page is Displayed");
	        else
	        	System.out.println("Home Page Not Found");
	        
	        driver.findElement(By.xpath("//a[text()='Organizations' and contains(@href,'action=index')]")).click();
	        
	        if(driver.getTitle().contains("Organizations"))
	        	System.out.println("Organizations page is Displayed");
	        else
	        	System.out.println("Organizations page Not Found");
	        
	        driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	        
	        WebElement createOrg = driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
	        if(createOrg.getText().equals("Creating New Organization"))
	        	System.out.println("Creating New Organization page Displayed");
	        else
	        	System.out.println("Creating New Organization page Not Found");
	        
//	        Random random = new Random();
//	        int randomNum = random.nextInt(100);
	        
	        Map<String, String> map = excel.readFromExcel("OrganizationTestData", "Create Organization");
	        
	        String orgName = map.get("Organization Name")+jutil.generateRandomNum(100);
	        driver.findElement(By.name("accountname")).sendKeys(orgName);
	        driver.findElement(By.xpath("//input[normalize-space(@value)='Save']")).click();
	        
	        String newOrgInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	        
	        if(newOrgInfo.contains(orgName))
	        {
	        	System.out.println("Organization created successfully");
	            excel.writeToExcel("OrganizationTestData", "Create Organization", "Pass", IconstantPath.Excel_Path);
	        }
	        else
	        {
	        	System.out.println("Organization Not created");
	            excel.writeToExcel("OrganizationTestData", "Create Organization", "Fail", IconstantPath.Excel_Path);
	        }
	        
	        WebElement adminIcon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//	        Actions a = new Actions(driver);
//	        a.moveToElement(adminIcon).perform();
	        
	        webUtil.mouseHover(adminIcon);
	        
	        driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	        
//	        driver.quit();
	        webUtil.quitAllWindows();
	        excel.closeExcel();
		}

	}


