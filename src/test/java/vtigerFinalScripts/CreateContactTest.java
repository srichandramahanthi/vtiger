package vtigerFinalScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;
import genericlibraries.IconstantPath;

public class CreateContactTest extends BaseClass{
	@Test
	public void createcontactTest()
	{
		SoftAssert soft=new SoftAssert();
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
