package com.pageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindAll;
import io.appium.java_client.pagefactory.iOSFindBy;

public class RadioOnDemandPage 
{
	// Local variables
	private AppiumDriver driver;
	public List<String> radio_Streams = new ArrayList<String>();
	
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
	
	@iOSFindAll({
		@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAImage[2]"),
	})
	public WebElement lightBox_For_Video;
	
	@iOSFindAll({
		@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAElement[3]"),
	})
	public WebElement radio_stream_pause_button;
	
	@iOSFindAll({
		@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[2]"),
	})
	public WebElement radio_stream_play_duration;
	
	@iOSFindAll({
		@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAElement[2]"),
	})
	public WebElement play_video_button;
	
	@iOSFindAll({
		@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAElement[1]"),
	})
	public WebElement radio_stream_close_button;

	// constructor for class
	public RadioOnDemandPage(AppiumDriver wdriver)
	{
		try
		{
			this.driver = wdriver;
			PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
			radio_Streams.add("2014 with Kingsmill");
			radio_Streams.add("360 documentaries");
			radio_Streams.add("AM");
			radio_Streams.add("All In The Mind");
			radio_Streams.add("Asia Pacific");
			radio_Streams.add("Australian Music Unit");
			radio_Streams.add("AWAYE!");
			radio_Streams.add("Baby Talk");
			radio_Streams.add("Background Briefing");
			radio_Streams.add("Big Ideas");
		} 
		catch (Exception exception) 
		{
			exception.printStackTrace();
		}
	}
	
	public boolean valiateRadioOnDemandTab()
	{
		try 
		{
			if(radio_on_demand_tab.isEnabled())
				return true;
		} 
		catch (Exception e)
		{
			return false;
		}
		return false;
	}
	
	public boolean checkAllRadioLinks()
	{
		for(int i=1; i<= 10; i++)
		{
			String temp = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell["+i+"]//UIAStaticText[1]")).getText();
			if(radio_Streams.get(i-1).equals(temp.substring(0,temp.indexOf(","))))
				return true;
		}
		return false;
	}
	public void searchAndClickRadioStream(String stream)
	{
		radio_stream_search_box.clear();
		radio_stream_search_box.sendKeys(stream);
		searched_radio_stream.click();
	}
	
	public boolean validateLightBoxForRadioStream()
	{
		try 
		{
			if(lightBox_For_Video.isEnabled())
				return true;
		}
		catch (Exception e) 
		{
			return false;
		}
		return false;
	}

	public boolean validateOnDemandForRadioStream()
	{
		try 
		{
			if(on_demand_text_for_radio_stream.isEnabled())
				return true;
		}
		catch (Exception e) 
		{
			return false;
		}
		return false;
	}

	public boolean validateDayTimeForRadioStream()
	{
		try 
		{
			if(day_time_for_radio_stream.isEnabled())
				return true;
		}
		catch (Exception e) 
		{
			return false;
		}
		return false;
	}

	public boolean validateDurationForRadioStream()
	{
		try 
		{
			if(duration_for_radio_stream.isEnabled())
				return true;
		}
		catch (Exception e) 
		{
			return false;
		}
		return false;
	}

	public boolean radio_link_playing() throws InterruptedException
	{
		Thread.sleep(5000);
		radio_stream_pause_button.click();
		try
		{
			if(Integer.parseInt(radio_stream_play_duration.getText().split(":")[1]) > 0)
				return true;
		}
		catch (Exception e)
		{
			return false;
		}
		return false;
	}

}
