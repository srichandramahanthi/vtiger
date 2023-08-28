package vtigerFinalScripts;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;
import genericlibraries.IconstantPath;

public class DeleteLeadTest extends BaseClass{
	@Test
	public void deleteLeadTest()
	{
		SoftAssert soft=new SoftAssert();
		home.clickLeads();
		lead.traverseToRequiredLead(web, "Lead4");
		lead.clickDelete();
		web.handleAlert("ok");
		List<WebElement> leadsNameList=lead.getLeadNamesList();
		boolean status=false;
		for(WebElement leads:leadsNameList)
		{
			if(!(leads.getText().equals("Lead4")))
				status=true;
		}
		soft.assertTrue(status);
		if(status)
		
			excel.writeToExcel("Leads", "Delete Existing Lead", "pass", IconstantPath.Excel_Path);
		
		else
			excel.writeToExcel("Leads", "Delete Existing Lead", "fail", IconstantPath.Excel_Path);
		soft.assertTrue(status);
		soft.assertAll();
		
	}

}


