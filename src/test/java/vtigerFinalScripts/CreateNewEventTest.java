package vtigerFinalScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;
import genericlibraries.IconstantPath;

public class CreateNewEventTest extends BaseClass{
	@Test
	public void createEventTest()
	{
		SoftAssert soft=new SoftAssert();
		Map<String,String> map=excel.readFromExcel("New Event", "Create  New Event");
		home.selectFromQuickCreate(web, map.get("Quick Create"));
		soft.assertEquals(createEvent.getPageHeader(), "Create To Do");
		String subject=map.get("subject")+jutil.generateRandomNum(100);
		createEvent.setSubject(subject);
		createEvent.clickOnstartDate();
		createEvent.chooseRequiredDate(web, map.get("Start date"), jutil);
		createEvent.clickOnDueData();
		createEvent.chooseRequiredDate(web, map.get("Due Date"), jutil);
		createEvent.clickSaveButton();
		soft.assertTrue(newEventInfo.getPageHeader().contains(subject));
		if(newEventInfo.getPageHeader().contains(subject))
			excel.writeToExcel("New Event", "Create  New Event", "pass", IconstantPath.Excel_Path);
		else
			excel.writeToExcel("New Event", "Create  New Event", "fail", IconstantPath.Excel_Path);
		soft.assertAll();
	}

}


