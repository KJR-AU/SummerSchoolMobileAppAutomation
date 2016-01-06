package com.pageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindAll;
import io.appium.java_client.pagefactory.iOSFindBy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.generic.StepBase;
import com.generic.Utilities;
import com.stepDefinitions.Hooks;

import cucumber.api.Scenario;

public class BusineesNewsPage 
{
	// Local variables
	private AppiumDriver driver;
	private Utilities objUtilities;
	private StepBase objStepBase;
	private Hooks hooks;
	public List<String> radio_Streams = new ArrayList<String>();
	
	@iOSFindAll({
		@iOSFindBy(name = "BUSINESS"),
	})
	public WebElement business_tab;
	
	@iOSFindAll({
		@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell"),
	})
	public List<WebElement> allHeadings;
	
	@iOSFindAll({
		@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[21]"),
	})
	public WebElement business_in_ninety_seconds;
	
	@iOSFindAll({
		@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAImage[2]"),
	})
	public WebElement lightBox_For_Video;
	
	@iOSFindAll({
		@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[8]"),
	})
	public WebElement video_title_in_lightbox;
	
	@iOSFindAll({
		@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[10]"),
	})
	public WebElement video_size_in_lightbox;
	
	@iOSFindAll({
		@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAElement[2]"),
	})
	public WebElement play_video_button;
	
	@iOSFindAll({
		@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[11]"),
	})
	public WebElement video_duration_in_lightbox;
	
	@iOSFindAll({
		@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[1]"),
	})
	public WebElement done_button;
	
	@iOSFindAll({
		@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIAStaticText[1]"),
	})
	public WebElement radio_on_demand_tab;
	
	@iOSFindAll({
		@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIASearchBar[1]"),
	})
	public WebElement radio_stream_search_box;
	
	@iOSFindAll({
		@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]"),
	})
	public WebElement searched_radio_stream;
	
	@iOSFindAll({
		@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[4]"),
	})
	public WebElement on_demand_text_for_radio_stream;

	@iOSFindAll({
		@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[9]"),
	})
	public WebElement day_time_for_radio_stream;

	@iOSFindAll({
		@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[11]"),
	})
	public WebElement duration_for_radio_stream;

	// constructor for class
	public BusineesNewsPage(AppiumDriver wdriver)
	{
		try
		{
			this.driver = wdriver;
			objUtilities = new Utilities();
			PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
		} 
		catch (Exception exception) 
		{
			exception.printStackTrace();
		}
	}

	public boolean business_tab_opened()
	{
		return business_tab.isEnabled();
	}
	
	public boolean checkBusinessHeadings(String number)
	{
		try 
		{
			for (int i = 1; i <= Integer.parseInt(number); i++)
			{
				if(allHeadings.get(i).isEnabled())
					return true;
			}
		}
		catch (Exception e)
		{
			return false;
		}
		return false;
	}
	
	public boolean checkAllArticlesPresent(String number)
	{
		try 
		{
			for (int i = 1; i <= Integer.parseInt(number); i++)
			{
				if(allHeadings.get(i).isEnabled())
					return true;
			}
		}
		catch (Exception e)
		{
			return false;
		}
		return false;
	}
	
	public boolean verifyBusinessInNinetySecondsVideo()
	{
		String elementText = business_in_ninety_seconds.getText();
		return elementText.substring(0, elementText.indexOf(",")).equals("Business in 90 Seconds");
	}
	
	public boolean validateLightBoxForVideo()
	{
		try 
		{
			lightBox_For_Video.isEnabled();
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}
	
	public boolean checkVideoDetails()
	{
		try 
		{
			if(video_title_in_lightbox.isEnabled() && video_size_in_lightbox.isEnabled() && video_duration_in_lightbox.isEnabled())
				return true;
		} 
		catch (Exception e) 
		{
			return false;
		}
		return false;
	}
	
	public void PlayVideoAndPressDone(String wait) throws NumberFormatException, InterruptedException, IOException
	{
		
		Thread.sleep(Integer.parseInt(wait));
		StepBase.embedScreenshot();
		driver.tap(1, 7, 17, 1000);
		done_button.click();
	}
}
