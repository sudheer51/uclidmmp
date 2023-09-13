package org.mmp.patientmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditProfilePage {

	WebDriver driver;
	public EditProfilePage(WebDriver driver)
	{
		this.driver= driver;
	}
	public String readPatientFName()
	{
		String fName = driver.findElement(By.id("fname")).getAttribute("value");
		return fName;
	}
}
