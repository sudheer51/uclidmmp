package org.mmp.patientmodule.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MessagesPage {
	WebDriver driver;
	public MessagesPage(WebDriver driver)
	{
		this.driver= driver;
	}
	public String sendMessages(String reason,String subject)
	{
		driver.findElement(By.id("subject")).sendKeys(reason);
		driver.findElement(By.id("message")).sendKeys(subject);
		driver.findElement(By.cssSelector("input[value='Send']")).click();
		Alert alrt = driver.switchTo().alert();
		String successMsg = alrt.getText();
		alrt.accept();
		return successMsg;
		 
	}

}
