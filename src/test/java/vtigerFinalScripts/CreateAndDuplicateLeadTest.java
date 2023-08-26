package vtigerFinalScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;
import genericlibraries.IconstantPath;

public class CreateAndDuplicateLeadTest extends BaseClass {
	@Test
	public void createAndDuplicateLeadTest()
	{
		SoftAssert soft=new SoftAssert();
		home.clickLeads();;
		soft.assertTrue(driver.getTitle().contains("Leads"));
		lead.clickPlusButton();
		soft.assertEquals(createLead.getPageHeader(), "Creating New Lead");
		Map<String,String> map=excel.readFromExcel("Leads", "Create Duplicate Lead");
		String lastName=map.get("Last Name")+jutil.generateRandomNum(100);
		lastName=map.get("Last Name")+jutil.generateRandomNum(100);
		createLead.setlastName(lastName);
		createLead.setCompanyName(map.get("companyName"));
		createLead.clickSaveButton();
		soft.assertTrue(newLeadInfo.getPageHeader().contains(lastName));
		newLeadInfo.clickDuplicateButton();
		soft.assertTrue(duplicatingLead.getPageHeader().contains("Duplicating"));
		String newLastName=map.get("New Last Name")+jutil.generateRandomNum(100);
		duplicatingLead.setLastName(newLastName);
		duplicatingLead.clickSaveButton();
		if(newContactInfo.getPageHeader().contains(lastName))
			excel.writeToExcel("Leads", "Create Duplicate Lead", "pass", IconstantPath.Excel_Path);
		else
			excel.writeToExcel("Leads", "Create Duplicate Lead", "fail", IconstantPath.Excel_Path);
		soft.assertAll();
	}
	}


