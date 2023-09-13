package org.mmp.adminmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminMessagesPage {

	WebDriver driver;
	public AdminMessagesPage(WebDriver driver)
	{
		this.driver= driver;
	}
	public String readMessages()
	{
		String patientName = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[2]/td[1]")).getText();
		String reason = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[2]/td[2]")).getText();
		String date = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[2]/td[3]")).getText();
		String subject =driver.findElement(By.xpath("//table[@class='table']/tbody/tr[3]")).getText();
		String outputMsg = patientName+"$"+reason+"$"+date+"$"+subject;
		return outputMsg;
	}
}
