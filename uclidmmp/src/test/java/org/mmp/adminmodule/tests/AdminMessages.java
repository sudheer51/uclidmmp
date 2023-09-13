package org.mmp.adminmodule.tests;

import org.mmp.adminmodule.pages.AdminMessagesPage;
import org.mmp.lib.AppLibrary;
import org.mmp.lib.BaseClass;
import org.mmp.lib.MMPLibrary;
import org.mmp.patientmodule.pages.EditProfilePage;
import org.mmp.patientmodule.pages.MessagesPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AdminMessages extends BaseClass {

	 
	@Test(description="Validate the Send Messages func from Patient module in the Admin module")
	public void TC004_validate_sendMessages_via_adminModule()
	{
		MMPLibrary mmpLib = new MMPLibrary(driver);
		mmpLib.launchBrowser(prop.getProperty("patientURL"));	 
		mmpLib.login(prop.getProperty("patientUserName"),prop.getProperty("patientPassword"));
		mmpLib.navigateToAModule("Profile");
		EditProfilePage profilePage = new EditProfilePage(driver);
		String expectedpatientName= profilePage.readPatientFName();
		mmpLib.navigateToAModule("Messages");
		MessagesPage messagePage = new MessagesPage(driver);
		String expectedReason="Monthly Visit";
		String expectedSubject="Having cold and headache";
		String expectedDate= AppLibrary.getfutureDate(0,"dd-MM-YYYY");
		String actualMsg = messagePage.sendMessages(expectedReason,expectedSubject);
		System.out.println("success Msg::: "+ actualMsg);
		mmpLib.launchBrowser(prop.getProperty("adminURL"));	 
		mmpLib.login(prop.getProperty("adminUserName"),prop.getProperty("adminPassword"));
		mmpLib.navigateToAModule("Messages");
		AdminMessagesPage messagesPage = new AdminMessagesPage(driver);
		String outputMsg = messagesPage.readMessages();
		//String outputMsg = patientName+"$"+reason+"$"+date+"$"+subject;
		String actualpatientName= outputMsg.split("//$")[0];
		String actualReason=outputMsg.split("//$")[1];
		String actualDate= outputMsg.split("//$")[2];
		String actualSubject=outputMsg.split("//$")[3];
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actualpatientName, expectedpatientName);
		sa.assertEquals(actualReason, expectedReason);
		sa.assertEquals(actualDate, expectedDate);
		sa.assertEquals(actualSubject, expectedSubject);
		sa.assertAll();
			

	}
	 
	
}
