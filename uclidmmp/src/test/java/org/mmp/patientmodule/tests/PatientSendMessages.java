package org.mmp.patientmodule.tests;

import org.mmp.lib.BaseClass;
import org.mmp.lib.MMPLibrary;
import org.mmp.patientmodule.pages.MessagesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PatientSendMessages extends BaseClass {

	 
	@Test(description="Validate the Send Messages func from Patient module")
	public void TC004_validate_sendMessages()
	{
		MMPLibrary mmpLib = new MMPLibrary(driver);
		mmpLib.launchBrowser(prop.getProperty("patientURL"));	 
		mmpLib.login(prop.getProperty("patientUserName"),prop.getProperty("patientPassword"));
	 
		mmpLib.navigateToAModule("Messages");
		MessagesPage messagePage = new MessagesPage(driver);
		String reason="Monthly Visit";
		String subject="Having cold and headache";
		String expectedMsg="Messages Successfully sent.";
		String actualMsg = messagePage.sendMessages(reason,subject);
		Assert.assertEquals(actualMsg, expectedMsg);
		
	}
	 
	
}
