package vtigerFinalScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;
import genericlibraries.IconstantPath;

public class CreateOrganizationTest extends BaseClass{
	@Test
	public void createOrgTest()
	{   SoftAssert soft=new SoftAssert();
		home.clickOrganizations();
		soft.assertTrue(driver.getTitle().contains("Organizations"));
		org.clickPlusButton();
		soft.assertTrue(createOrg.getPageHeader().equals("Creating New Organization"));
		Map<String, String> map=excel.readFromExcel("organization", "Create Organization");
		String orgName=map.get("Organization Name")+jutil.generateRandomNum(100);
		createOrg.setOrgName(orgName);
		createOrg.clickSaveButton();
		soft.assertTrue(newOrgInfo.getPageHeader().contains(orgName));
		if(newOrgInfo.getPageHeader().equals(orgName))
           excel.writeToExcel("organization", "Create Organization", "pass", IconstantPath.Excel_Path);
		else
			excel.writeToExcel("organization", "Create Organization", "fail", IconstantPath.Excel_Path);
		soft.assertAll();
	}

}
