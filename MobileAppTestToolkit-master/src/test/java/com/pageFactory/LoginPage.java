package com.pageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindAll;
import io.appium.java_client.pagefactory.iOSFindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * @ScriptName    : TestRunner
 * @Description   : This class contains   
 * @Author        : Automation Tester (SQS)
 * @Creation Date : 17 Jun 2015   @Modified Date:                       
 */
public class LoginPage 
{
	// Local variables
	private AppiumDriver driver;


	// IOS
	@iOSFindAll({
		@iOSFindBy(name = "login"), //by this locator element is found
	}) 
	public WebElement username; // element that is found by any of declared locators

	@iOSFindAll({
		@iOSFindBy(name = "password"),
	})
	public WebElement password;


	public By getLogin(){
		By mySearchCriteria = null;
		if (System.getProperty("platform").equals("android")){
			mySearchCriteria = By.name("login");
		}
		else if (System.getProperty("platform").equals("ios")){
			mySearchCriteria = By.name("login");
		}
		return mySearchCriteria;
	}
	
	public By getPassword(){
		By mySearchCriteria = null;
		if (System.getProperty("platform").equals("android")){
			mySearchCriteria = By.name("password");
		}
		else if (System.getProperty("platform").equals("ios")){
			mySearchCriteria = By.name("password");
		}
		return mySearchCriteria;
	}
	
	public By getSubmit(){
		By mySearchCriteria = null;
		if (System.getProperty("platform").equals("android")){
			mySearchCriteria = By.xpath("//button[@class='btn btn-primary']");
		}
		else if (System.getProperty("platform").equals("ios")){
			mySearchCriteria = By.xpath("//button[@class='btn btn-primary']");
		}
		return mySearchCriteria;
	}


	
	// constructor for class
	public LoginPage(AppiumDriver wdriver)
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
/*
	// Wrapper methods
	public boolean clickNotNowLink()
	{
		try
		{
			notNowLink.click();
			return true;
		} 
		catch (Exception exception) 
		{
			exception.printStackTrace();
			return false;
		}
	}

	public boolean verifyNewsLinkAvailable(String newsLink)
	{
		return driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'" + newsLink + "')]")).isDisplayed();
	}

	public boolean clickNewsHeding(String newsLink)
	{
		try
		{
			driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'" + newsLink + "')]")).click();
			return true;
		} 
		catch (Exception exception) 
		{
			exception.printStackTrace();
			return false;
		}
	}

	public boolean clickLocalNewslink()
	{
		try
		{
			localNewslink.click();
			return true;
		} 
		catch (Exception exception) 
		{
			exception.printStackTrace();
			return false;
		}
	}


	public boolean clickOnWeatherIcon()
	{
		try
		{
			weather.click();
			return true;
		} 
		catch (Exception exception) 
		{
			exception.printStackTrace();
			return false;
		}
	}

	public void clickOnWeatherSearchButton()
	{
		try
		{
			weatherSearchButton.click();
		} 
		catch (Exception exception) 
		{
			exception.printStackTrace();
		}
	}

	public void setWeatherSearch(String location)
	{
		try
		{
			weatherSearchBox.sendKeys(location);
		} 
		catch (Exception exception) 
		{
			exception.printStackTrace();
		}
	}

	public boolean verifyWeatherLocationSelects(String location)
	{
		MobileElement weLocation = weatherLocation;
		try
		{
			if(weLocation.getText().contains(location))
				weLocation.click();
		} 
		catch (Exception exception) 
		{
			exception.printStackTrace();
		}

		if(weatherLocationLabel.getText().contains("Richmond"))
			return true;
		else
			return false;
	}

	public void clickBackButton()
	{
		try
		{
			backButton.click();
		} 
		catch (Exception exception) 
		{
			exception.printStackTrace();
		}
	}
	
	// IOS
	public boolean verifyLightBoxAvailable()
	{
		return lightBox.isDisplayed();
	}
	
	public boolean verifyLightBoxHeading(String text)
	{
		return lightBoxHeading.getText().equals(text);
	}
	
	public boolean verifyBreakingNewsAlerts()
	{
		return breaking_News_Alerts.isDisplayed();
	}

	public boolean verifyNotNowText(String exceptedText)
	{
		return not_now.getText().equals(exceptedText);
	}
	
	public boolean verifyGetAlerts(String text)
	{
		return get_alerts.getText().equals(text);
	}
	 
	public boolean verifyRecentStoriesGreyedOut()
	{
		return greyed_out_stories.isEnabled();
	}

	public boolean displayTopStories()
	{
		return top_stories.isEnabled();
	}
*/
}


