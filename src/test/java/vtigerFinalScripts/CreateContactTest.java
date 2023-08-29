package vtigerFinalScripts;

import java.util.Map;
//contains of create contact
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;
import genericlibraries.IconstantPath;
//updated version
public class CreateContactTest extends BaseClass{
	@Test
	public void createcontactTest()
	//this is create contact
	//create the contact for git hub
	{
		SoftAssert soft=new SoftAssert();
		//update contact
		home.clickContacts();
		soft.assertTrue(driver.getTitle().contains("Contacts"));
		contacts.clickPlusButton();
		soft.assertEquals(createContact.getPageHeader(), "Creating New contact");
		Map<String,String> map=excel.readFromExcel("Contact", "Create  Contact");
		String lastName=map.get("Last Name")+jutil.generateRandomNum(100);
		createContact.setLastName(lastName);
		createContact.clickSaveButtom();
		soft.assertTrue(newContactInfo.getPageHeader().contains(lastName));
		if(newContactInfo.getPageHeader().contains(lastName))
			excel.writeToExcel("Contact", "Create  Contact", "pass", IconstantPath.Excel_Path);
		else
			excel.writeToExcel("Contact", "Create  Contact", "fail", IconstantPath.Excel_Path);
		soft.assertAll();
		
	}

}
