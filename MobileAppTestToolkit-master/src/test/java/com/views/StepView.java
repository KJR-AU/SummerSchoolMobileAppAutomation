package com.views;
//final

import io.appium.java_client.MobileElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.generic.StepBase;
import com.generic.Utilities;
import com.pageFactory.BusineesNewsPage;
import com.pageFactory.LoginPage;
import com.pageFactory.LocalNewsPage;
import com.pageFactory.RadioOnDemandPage;
import com.pageFactory.TopStoriesPage;
import com.pageFactory.WeatherDetailsPage;
/**
 * @ScriptName    : TestRunner
 * @Description   : This class contains   
 * @Author        : Automation Tester (SQS)
 * @Creation Date : 17 Jun 2015   @Modified Date:                       
 */
public class StepView 
{
	// Local variables
	private StepBase objStepBase =  new StepBase();
	private LoginPage objHomePage = new LoginPage(objStepBase.getDriver());
	private LocalNewsPage objLocalNewsPage = new LocalNewsPage(objStepBase.getDriver());
	private WeatherDetailsPage objWeatherDetailsPage = new WeatherDetailsPage(objStepBase.getDriver());
	private BusineesNewsPage objBusineesNewsPage = new BusineesNewsPage(objStepBase.getDriver());
	//private TopStoriesPage objTopStoriesPage = new TopStoriesPage(objStepBase.getDriver());
	private RadioOnDemandPage objRadioOnDemandPage = new RadioOnDemandPage(objStepBase.getDriver());
	
	
	private Utilities objUtilities = new Utilities();
	private ArrayList<String> newsHeadings = new ArrayList<String>();
	private ArrayList<String> latestNewsHeadings = new ArrayList<String>();
	int iOldHeight, iNewHeight, iNewHeight1, iNewHeight2;
/*
	public void AndroidOpenApp()
	{
		objUtilities.waitFor(40000L);
		//WebDriverWait nwait = new WebDriverWait(objStepBase.getDriver(), 90);
		//nwait.until(ExpectedConditions.presenceOfElementLocated(objHomePage.getNotNow()));
		objUtilities.takeScreenshot();
		objHomePage.clickNotNowLink();
	}

	public void IosOpenApp()
	{
//		objUtilities.waitFor(15000L);
//		objHomePage.notNowLinkiOS.isDisplayed();
		WebDriverWait nwait = new WebDriverWait(objStepBase.getDriver(), 90);
		nwait.until(ExpectedConditions.presenceOfElementLocated(objHomePage.getNotNow()));
		objUtilities.takeScreenshot();
		objHomePage.not_now.isDisplayed();
	}

	public void AndroidVerifyMenuOnTop(String menu)
	{
		Assert.assertTrue("Application should open with " + menu + " menu on top",  objHomePage.verifyNewsLinkAvailable(menu));
	}

	public void IosVerifyMenuOnTop(String menu)
	{
		Assert.assertTrue("Application opened successfully with LightBox ",  objHomePage.verifyLightBoxAvailable());
	}

	public void SelectCategory(String category)
	{
		objHomePage.clickNewsHeding(category);
	}
	
	public void verifyNoOfTopStories(int newsCount)
	{
		ArrayList<String> newsHeadings = new ArrayList<String>();
		String lastNewsHeading = "";
		boolean blnNewsHeadingLast = false;
		try 
		{
			Thread.sleep(3000);
			objLocalNewsPage.waitUntilLoaded();
			objStepBase.embedScreenshot();
			do
			{
				List<MobileElement> previousNewsHeadings = objLocalNewsPage.heading;
				for(int intRowNum = 0; intRowNum < previousNewsHeadings.size() ; intRowNum++ )
				{
					MobileElement localNewsHeadings = (MobileElement)previousNewsHeadings.get(intRowNum).findElement(By.className("android.widget.TextView"));
					if(!newsHeadings.contains(localNewsHeadings.getText()))
						newsHeadings.add(localNewsHeadings.getText());

					if(intRowNum == (previousNewsHeadings.size()-1))
					{
						if(lastNewsHeading.equals(localNewsHeadings.getText()))
							blnNewsHeadingLast = true;
						lastNewsHeading = localNewsHeadings.getText();
					}
					System.out.println("Row: " + intRowNum + " Title:" + localNewsHeadings.getText());
				}
				if(!blnNewsHeadingLast)
				{
					int topY = previousNewsHeadings.get(0).getLocation().getY();
					int bottomY = previousNewsHeadings.get(previousNewsHeadings.size()-2).getLocation().getY();
					objStepBase.getDriver().swipe(0, bottomY, 0, topY, 2000);
				}
			}
			while(!blnNewsHeadingLast);
			System.out.println("Row: Final List");
			for (int current = 0; current < newsHeadings.size(); current++){
				System.out.println("Row: " + (current+1) + " Title:" + newsHeadings.get(current));
			}
		} 
		catch (Exception exception) 
		{
			exception.printStackTrace();
		}

		Assert.assertSame("A list of " + newsCount + " top stories should be displayed", newsCount, newsHeadings.size());
	}
	
	public void noteNewsHeading()
	{
		try
		{
			List<MobileElement> previousNewsHeadings = objLocalNewsPage.heading;
			for(int intRowNum = 0; intRowNum < previousNewsHeadings.size() ; intRowNum++ )
			{
				MobileElement localNewsHeadings = (MobileElement)previousNewsHeadings.get(intRowNum).findElement(By.className("android.widget.TextView"));
				newsHeadings.add(localNewsHeadings.getText());
			}
		} 
		catch (Exception exception) 
		{
			exception.printStackTrace();
		}
	}
	
	public void verfiArticleNoted()
	{
		boolean newsCount = false;
		if(newsHeadings.size() > 0)
			newsCount = true;
		Assert.assertTrue("Articles should be noted correctly",  newsCount);
	}
	
	public void tapOnWeatherIcon()
	{
		objWeatherDetailsPage.clickOnWeatherIcon();
	}
	
	public void verifyWeatherForcast()
	{
		boolean verify = false;
		if(objWeatherDetailsPage.weatherLocationLabel.isDisplayed() && objWeatherDetailsPage.weatherForecastToday.isDisplayed() && objWeatherDetailsPage.weatherForecastTomorrow.isDisplayed())
			verify = true;
		Assert.assertTrue("Tap on weather icon, second from top right",  verify);
	}
	
	public void tapOnSearchIconOfWeather()
	{
		objWeatherDetailsPage.clickOnWeatherSearchButton();
	}
	
	public void verifyEditBoxEnable()
	{
		Assert.assertTrue("Edit box should be enabled for changing the location",  objWeatherDetailsPage.editBox.isDisplayed());
	}
	
	public void selectLocation(String weatherLocation)
	{
		objWeatherDetailsPage.setWeatherSearch(weatherLocation);
	}
	
	public void verifyLocation(String weatherLocation)
	{
		Assert.assertTrue("Proper location should be selected and weather light box should be displayed with new " + weatherLocation + " location and updated weather",  objWeatherDetailsPage.verifyWeatherLocationSelects(weatherLocation));
	}
	
	public void clickBack()
	{
		Assert.assertTrue("Tap back button",  objWeatherDetailsPage.clickBackButton());
	}
	
	public void nevagateBackToLocal()
	{
		Assert.assertTrue("User should navigate back to local news section",  objLocalNewsPage.localNewslink.isDisplayed());
	}
	
	public void validateNewsArticle()
	{
		List<MobileElement> previousNewsHeadings = objLocalNewsPage.heading;
		for(int intRowNum = 0; intRowNum < previousNewsHeadings.size() ; intRowNum++ )
		{
			MobileElement localNewsHeadings = (MobileElement)previousNewsHeadings.get(intRowNum).findElement(By.className("android.widget.TextView"));
			latestNewsHeadings.add(localNewsHeadings.getText());
		}
	}
	
	public void verifyArticlesDiscrepancy()  
	{
		try
		{
			boolean blnVerifyNewsHeading = true;
			for(String str: latestNewsHeadings)
			{
				if(newsHeadings.contains(str))
					blnVerifyNewsHeading = false;
			}
			Assert.assertTrue("The articles should have some discrepancy",  blnVerifyNewsHeading);
		} 
		catch (Exception exception) 
		{
			exception.printStackTrace();
		}
	}
	
	public void validateHeading(String heading)
	{
		Assert.assertTrue("Validate '" + heading + " ' heading of the lightbox", objHomePage.verifyLightBoxHeading(heading));
	}
	
	public void validateFeatureText(String text)
	{
		Assert.assertTrue("Validate '" + text + "' text in the lightbox", objHomePage.verifyBreakingNewsAlerts());
	}
	
	public void validateNowtext(String text)
	{
		Assert.assertTrue("Validate '" + text + "' text in the lightbox", objHomePage.verifyNotNowText(text));
	}
	
	public void validateAlertsText(String alertsText)
	{
		Assert.assertTrue("Validate '" + alertsText + "' button text in lightBox" , objHomePage.verifyGetAlerts(alertsText));
	}
	
	public void clickNotNow()
	{
		
		WebDriverWait nwait = new WebDriverWait(objStepBase.getDriver(), 90);
		nwait.until(ExpectedConditions.presenceOfElementLocated(objHomePage.getNotNow()));
		objHomePage.not_now.click();
	}
	
	public void clickOnContextMenu()
	{
		objHomePage.context_menu.click();
	}
	
	public void validateTopStoriesGreyedOut()
	{
		Assert.assertTrue("All the top stories should be greyed out", objHomePage.verifyRecentStoriesGreyedOut());
	}
	
	public void tapContextMenu()
	{
		objHomePage.business_category.click();
	}
	
	public void clickDemand()
	{
		objHomePage.radio_on_demand.click();
	}
	
	public void validateBusinessArticles(String count)
	{
		Assert.assertTrue("Business tab opened", objBusineesNewsPage.business_tab_opened());
		Assert.assertTrue("Validate Seventeen business articles", objBusineesNewsPage.checkBusinessHeadings(count));
	}
	
	public void varifyArticlesCount(String count)
	{
		Assert.assertTrue("All 21 articles should be present", objBusineesNewsPage.checkAllArticlesPresent(count));
	}
	
	public void verifyBusiness(String lastElement)
	{
		Assert.assertTrue("Business in 90 Seconds should be last element", objBusineesNewsPage.verifyBusinessInNinetySecondsVideo());
	}
	
	public void tapOnBusinessIn90SecondsLink()
	{
		objBusineesNewsPage.business_in_ninety_seconds.click();
	}
	
	public void verifyVideoLink()
	{
		Assert.assertTrue("LightBox for video link should be displayed", objBusineesNewsPage.validateLightBoxForVideo());
		Assert.assertTrue("Video details should be displayed in lightbox", objBusineesNewsPage.checkVideoDetails());
	}
	
	public void clickWatchProgram()
	{
		objBusineesNewsPage.play_video_button.click();
	}
	
	public void pressDone(String waitFor) throws NumberFormatException, InterruptedException, IOException
	{
		objBusineesNewsPage.PlayVideoAndPressDone(waitFor);
	}
	
	public void verifyOnDemandTabOpened()
	{
		Assert.assertTrue("Radio On Demand tab should be opened", objRadioOnDemandPage.valiateRadioOnDemandTab());
	}
	
	public void validateRadioOnDemand()
	{
		Assert.assertTrue("All radio links should be present", objRadioOnDemandPage.checkAllRadioLinks());
	}
	
	public void searchRadioStreamAndOpen(String radioStream)
	{
		objRadioOnDemandPage.searchAndClickRadioStream(radioStream);
	}
	
	public void verifyRadioStream()
	{
		Assert.assertTrue("Lightbox for radio stream should be present", objRadioOnDemandPage.validateLightBoxForRadioStream());
		Assert.assertTrue("On Demand field for radio stream should be present", objRadioOnDemandPage.validateOnDemandForRadioStream());
		Assert.assertTrue("Day Time field for radio stream should be present", objRadioOnDemandPage.validateDayTimeForRadioStream());
		Assert.assertTrue("Day Time field for radio stream should be present", objRadioOnDemandPage.validateDurationForRadioStream());
	}
	
	public void clickOnArticle()
	{
		Assert.assertTrue("Tap on any article for details", objTopStoriesPage.tapOnArticle(""));
	}
	
	public void verifyArticleDetails()
	{
		 objUtilities.takeScreenshot();
		 
		 boolean bArticleDetails = false;
		 boolean bArticleHeading = objTopStoriesPage.articleHeading.isDisplayed();
		 //boolean bDateTime = objTopStoriesPage.dateTime.isDisplayed(); // check disabled due to changing timezone - will re-enable when substring search is implemented in pagefactory
		 boolean bDateTime = true;
		 boolean bShareArticleButton = objTopStoriesPage.shareArticleButton.isDisplayed();
		 boolean bIncreaseFontSizeButton = objTopStoriesPage.increaseFontSizeButton.isDisplayed();
		 boolean bDecreaseFontSizeButton = objTopStoriesPage.decreaseFontSizeButton.isDisplayed();
		if(bArticleHeading && bDateTime && bShareArticleButton && bIncreaseFontSizeButton && bDecreaseFontSizeButton)
		{
			bArticleDetails = true;
		}
		Assert.assertTrue("Article details should be displayed with heading, date time and three buttons",  bArticleDetails);
	}
	
	public void clickOnBiggerA()
	{
		iOldHeight = objTopStoriesPage.articleHeading.getSize().getHeight();
		Assert.assertTrue("Click on second button labeled as (bigger) A", objTopStoriesPage.clickOnBiggerA());
	}
	
	public void verifyArticleText()
	{
		iNewHeight = objTopStoriesPage.articleHeading.getSize().getHeight();
		boolean bSizeIncreased = false;
		if(iNewHeight > iOldHeight)
		{
			bSizeIncreased = true;
		}
		Assert.assertTrue("Whole of the text including the heading on top should be increased in size", bSizeIncreased);
	}
	
	public void ClickSecondButtonA()
	{
		Assert.assertTrue("Click the second button again", objTopStoriesPage.clickOnBiggerA());
	}
	
	public void verifyArticleTextAgain()
	{
		iNewHeight1 = objTopStoriesPage.articleHeading.getSize().getHeight();
		boolean bSizeIncreased = false;
		if(iNewHeight1 > iNewHeight)
		{
			bSizeIncreased = true;
		}
		Assert.assertTrue("The size should increase again", bSizeIncreased);
	}
	
	public void clickSmallerA()
	{
		Assert.assertTrue("Click on third button labeled as Smaller A", objTopStoriesPage.clickOnSmallerA());
	}
	
	public void verifyArticleDecreasedText()
	{
		iNewHeight2 = objTopStoriesPage.articleHeading.getSize().getHeight();
		boolean bSizeDecreased = false;
		if(iNewHeight1 > iNewHeight2)
		{
			bSizeDecreased = true;
		}
		Assert.assertTrue("The size should increase again", bSizeDecreased);
	}
	
	public void tapOnArticleForDetails() throws InterruptedException
	{
		objUtilities.scrollUp();
		Thread.sleep(1000);
		objUtilities.scrollUp();
		Thread.sleep(1000);
		objUtilities.scrollUp();
		Thread.sleep(1000);
		objUtilities.scrollUp();
		Thread.sleep(2000);
		Assert.assertTrue("Tap on any article for details", objTopStoriesPage.tapOnArticle("First"));
	}
	
	public void verifyArticleHeading()
	{
		Assert.assertTrue("The article details should be displayed with heading", objTopStoriesPage.weFirstNews.isDisplayed());
	}
	
	public void swipeTillWeblink() throws InterruptedException
	{
		//Wait
		Thread.sleep(2000);
		//Swipe from left to right
		objUtilities.swipeRight();
		Thread.sleep(2000);
	}
	
	public void verifyNextArticle()
	{
		Assert.assertTrue("Next article should be displayed", objTopStoriesPage.weNextArticle.isDisplayed());
	}
	
	public void tapOnWeblink() throws InterruptedException
	{
		//Search for the story with a weblink, if not swipe to next article
		objUtilities.scrollDown();
		Thread.sleep(1000);
		objUtilities.scrollDown();
		Thread.sleep(2000);
		
		Assert.assertTrue("Tap on Weblink", objTopStoriesPage.clickOnWeblink());
		
		//Wait
		Thread.sleep(6000);
	}
	
	public void verifyNavigatedToBrowser() throws InterruptedException
	{
		try {
			objStepBase.embedScreenshot();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		Assert.assertTrue("User should be navigated to the browser on that", objTopStoriesPage.navigatedToBrowser());
		Thread.sleep(2000);
	}
	
	public void navigateBack()
	{
		Assert.assertTrue("Navigate back to app", objTopStoriesPage.navigateBack());
	}
	
	
	public void verifyArticle() throws InterruptedException
	{
		objUtilities.scrollUp();
		Thread.sleep(1000);
		objUtilities.scrollUp();
		Thread.sleep(2000);
		Assert.assertTrue("User should be able to navigate back to app and the same article should be displayed on top", objTopStoriesPage.weNextArticle.isDisplayed());
	}
	
	public void swipeTillVideolink() throws InterruptedException
	{
		//Swipe from left to right
		objUtilities.swipeRight();
		Thread.sleep(1000);
		objUtilities.swipeRight();
		Thread.sleep(1000);
		objUtilities.swipeRight();
		Thread.sleep(1000);
		objUtilities.swipeRight();
		Thread.sleep(1000);
		objUtilities.swipeRight();
		Thread.sleep(1000);
		objUtilities.swipeRight();
		Thread.sleep(1000);
		objUtilities.swipeRight();
		Thread.sleep(1000);
		objUtilities.swipeRight();
		Thread.sleep(1000);
		objUtilities.swipeRight();
		Thread.sleep(5000);
	}
	
	public void verifyNextArticlePresent()
	{
		Assert.assertTrue("Next article should be displayed", objTopStoriesPage.weElevanthArticle.isDisplayed());
	}
	
	public void tapOnVideolink() throws InterruptedException
	{
		//Tap on video link
		objUtilities.scrollDown();
		Thread.sleep(1000);
		objUtilities.scrollDown();
		Thread.sleep(2000);
		
		Assert.assertTrue("Tap on video link", objTopStoriesPage.clickOnVideolink());
		
		//Wait
		Thread.sleep(6000);
	}
	
	public void verifyVideo()
	{
		Assert.assertTrue("User should be able to play the video properly from the video lightbox", objTopStoriesPage.verifyVideo());
	}
	
	public void verifyArticlePresent() throws InterruptedException
	{
		objUtilities.scrollUp();
		Thread.sleep(1000);
		objUtilities.scrollUp();
		Thread.sleep(2000);
		Assert.assertTrue("User should be able to navigate back to app and the same article should be displayed on top", objTopStoriesPage.weElevanthArticle.isDisplayed());
	}
	
	public void swipeTillAudiolink() throws InterruptedException
	{
		//Swipe from left to right
		objUtilities.swipeRight();
	}
	
	public void verifyNextArticleShouldDisplayed()
	{
		Assert.assertTrue("Next article should be displayed", objTopStoriesPage.weTwelfthArticle.isDisplayed());
	}
	
	public void tapOnAudiolink() throws InterruptedException
	{
		objUtilities.scrollDown();
		Thread.sleep(1000);
		objUtilities.scrollDown();
		Thread.sleep(1000);
		objUtilities.scrollDown();
		Thread.sleep(1000);
		objUtilities.scrollDown();
		Thread.sleep(3000);
		
		Assert.assertTrue("Tap on Audio link", objTopStoriesPage.clickOnAudiolink());
	}
	
	public void verifyAudio() throws InterruptedException
	{
		Thread.sleep(2000);
		Assert.assertTrue("User should be able to play the audio properly from the audio lightbox", objTopStoriesPage.verifyAudio());
		objTopStoriesPage.audioPauseButton.click();
		Thread.sleep(3000);
	}
	
	public void verifyArticleShouldPresent() throws InterruptedException
	{
		objUtilities.scrollUp();
		Thread.sleep(1000);
		objUtilities.scrollUp();
		Thread.sleep(1000);
		objUtilities.scrollUp();
		Thread.sleep(1000);
		objUtilities.scrollUp();
		Thread.sleep(2000);
		
		Assert.assertTrue("User should be able to navigate back to app and the same article should displayed on top", objTopStoriesPage.weTwelfthArticle.isDisplayed());
	}
	 
	// IOS
	public void clickRadioOnDemand()
	{
		objHomePage.radio_on_demand.click();
	}
	
	public void radioOnDemandTabShouldOpen()
	{
		Assert.assertTrue("Radio On Demand tab should be opened", objRadioOnDemandPage.valiateRadioOnDemandTab());
	}
	
	public void validateNumberAndNamesOfRadioStreams()
	{
		Assert.assertTrue("All radio links should be present", objRadioOnDemandPage.checkAllRadioLinks());
	}
	
	public void searchRadioStreamAndOpenIt(String stream)
	{
		objRadioOnDemandPage.searchAndClickRadioStream(stream);
	}
	
	public void RadioStreamDetailsInLightBox()
	{
		Assert.assertTrue("Lightbox for radio stream should be present", objRadioOnDemandPage.validateLightBoxForRadioStream());
		Assert.assertTrue("On Demand field for radio stream should be present", objRadioOnDemandPage.validateOnDemandForRadioStream());
		Assert.assertTrue("Day Time field for radio stream should be present", objRadioOnDemandPage.validateDayTimeForRadioStream());
		Assert.assertTrue("Day Time field for radio stream should be present", objRadioOnDemandPage.validateDurationForRadioStream());
	}
	
	public void radioStreamPlaying() throws InterruptedException
	{
		objRadioOnDemandPage.play_video_button.click();
	    Assert.assertTrue("Radio Stream should be played", objRadioOnDemandPage.radio_link_playing());
	}
	
	public void closeRadioStream() throws InterruptedException
	{
		objRadioOnDemandPage.radio_stream_close_button.click();
		Thread.sleep(5000);
	}
	
	public void displayTopStories()
	{
		Assert.assertTrue("Top stories should be displayed", objHomePage.displayTopStories());
	}
	*/


}
