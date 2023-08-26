package vtigerFinalScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;
import genericlibraries.IconstantPath;

public class CreateLeadTest extends BaseClass{
	public static String lastName;
	@Test
	public void createLeadTest()
	{
		SoftAssert soft=new SoftAssert();
		home.clickLeads();
		soft.assertTrue(driver.getTitle().contains("Leads"));
		lead.clickPlusButton();
		soft.assertEquals(createLead.getPageHeader(),"Creating New Lead");
		Map<String ,String> map=excel.readFromExcel("Leads", "Create Leads");
		lastName=map.get("Last Name")+jutil.generateRandomNum(100);
		createLead.setlastName(lastName);
		createLead.setCompanyName(map.get("Company"));
		createLead.clickSaveButton();
		soft.assertTrue(newLeadInfo.getPageHeader().contains(lastName));
		if(newLeadInfo.getPageHeader().contains(lastName))
			excel.writeToExcel("Leads", "Create Leads", "pass", IconstantPath.Excel_Path);
		else
			excel.writeToExcel("Leads", "Create Leads", "fail", IconstantPath.Excel_Path);
		soft.assertAll();
	}

}
