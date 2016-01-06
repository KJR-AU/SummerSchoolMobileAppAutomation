package com.pageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @ScriptName    : TestRunner
 * @Description   : This class contains   
 * @Author        : Automation Tester (SQS)
 * @Creation Date : 17 Jun 2015   @Modified Date:                       
 */
public class LocalNewsPage 
{
	AppiumDriver driver;
	
	@AndroidFindAll({
		@AndroidFindBy(xpath = ".//android.widget.ListView/android.widget.RelativeLayout"),
	}) 
	public List<MobileElement> heading;
	
	@AndroidFindAll({
		@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'LOCAL')]"), 
	})
	public MobileElement localNewslink;
 
	// constructor for class
	public LocalNewsPage(AppiumDriver wdriver)
	{
		try
		{
			this.driver = wdriver;
			PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
		} 
		catch (Exception exception) 
		{
			exception.printStackTrace();
		}
	}
	
	public boolean waitUntilLoaded()
	{
		WebElement mylocalNewslink = (new WebDriverWait(driver, 90))
				  .until(ExpectedConditions.presenceOfElementLocated(By.className("android.widget.TextView")));
		return mylocalNewslink.isDisplayed();
	}
}


