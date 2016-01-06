package com.pageFactory;
 
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

/**
 * @ScriptName    : TestRunner
 * @Description   : This class contains   
 * @Author        : Automation Tester (SQS)
 * @Creation Date : 17 Jun 2015   @Modified Date:                       
 */
public class WeatherDetailsPage 
{
	// Local variables
	private AppiumDriver driver;

	@AndroidFindAll({
		@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android.AbcApplication:id/omWeather\")"),
	})  
	public MobileElement weather;

	@AndroidFindAll({
		@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android.AbcApplication:id/weatherLocationLabel\")"),
	}) 
	public MobileElement  weatherLocationLabel;

	@AndroidFindAll({
		@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android.AbcApplication:id/weather_label_today\")"),
	}) 
	public MobileElement  weatherForecastToday;

	@AndroidFindAll({
		@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android.AbcApplication:id/weather_label_tomorrow\")"),
	}) 
	public MobileElement  weatherForecastTomorrow;

	@AndroidFindAll({
		@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android.AbcApplication:id/weatherSearch\")"),
	}) 
	public MobileElement  weatherSearchButton;

	@AndroidFindAll({
		@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/search_src_text\")"),
	}) 
	public MobileElement  editBox;

	@AndroidFindAll({
		@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/search_src_text\")"),
	}) 
	public MobileElement  weatherSearchBox;

	@AndroidFindAll({
		@AndroidFindBy(xpath = ".//android.widget.ListView/android.widget.LinearLayout/android.widget.TextView[2]"),
	}) 
	public MobileElement weatherLocation;

	@AndroidFindAll({
		@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/up\")"),
	})
	public MobileElement  backButton; 

	// constructor for class
	public WeatherDetailsPage(AppiumDriver wdriver)
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

	public boolean clickOnWeatherSearchButton()
	{
		try
		{
			weatherSearchButton.click();
			return true;
		} 
		catch (Exception exception) 
		{
			exception.printStackTrace();
			return false;
		}
	}

	public boolean setWeatherSearch(String location)
	{
		try
		{
			weatherSearchBox.sendKeys(location);
			return true;
		} 
		catch (Exception exception) 
		{
			exception.printStackTrace();
			return false;
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

	public boolean clickBackButton()
	{
		try
		{
			backButton.click();
			return true;
		} 
		catch (Exception exception) 
		{
			exception.printStackTrace();
			return false;
		}
	}

}


