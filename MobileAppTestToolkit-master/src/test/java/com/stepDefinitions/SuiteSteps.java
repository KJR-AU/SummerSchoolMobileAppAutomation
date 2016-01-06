package com.stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.generic.StepBase;
import com.generic.Utilities;
import com.pageFactory.LoginPage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
/**
 * @ScriptName    : TestRunner
 * @Description   : This class contains   
 * @Author        : Automation Tester (SQS)
 * @Creation Date : 17 Jun 2015   @Modified Date:                       
 */
public class SuiteSteps 
{
	// Local variables
	private StepBase objStepBase =  new StepBase();
	private Utilities objUtilities = new Utilities();
	private LoginPage objLoginPage = new LoginPage(objStepBase.getDriver());
	private AppiumDriver  driver = objStepBase.getDriver();

	@When ("^Open app$")
	public void Open_app() throws IOException
	{
		//driver.get("https://google.com.au");
		driver.get("http://odoo.kjross.com.au");
		WebDriverWait nwait = new WebDriverWait(objStepBase.getDriver(), 90);
		nwait.until(ExpectedConditions.presenceOfElementLocated(objLoginPage.getLogin()));
		/*try {
			driver.wait(10000);;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		driver.findElement(objLoginPage.getLogin()).sendKeys("admin");
		driver.findElement(objLoginPage.getPassword()).sendKeys("odoo");
		objStepBase.embedScreenshot();
		
		driver.findElement(objLoginPage.getSubmit()).click();
		/*
		try {
			driver.wait(10000);;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		objStepBase.embedScreenshot();
		
		//objHomePage.not_now.click();
		
		
		objStepBase.embedScreenshot();
		/*
		if(System.getProperty("platform").equals("android"))
			objStepView.AndroidOpenApp();
		else if(System.getProperty("platform").equals("ios"))
			objStepView.IosOpenApp();
		*/
	}
/*
	@Then ("^Application should open with (.*) menu on top$")
	public void Application_should_open_with_menu_on_top(String newsHeading) 
	{
		if(System.getProperty("platform").equals("android"))
			objStepView.AndroidVerifyMenuOnTop(newsHeading);
		else if(System.getProperty("platform").equals("ios"))
			objStepView.IosVerifyMenuOnTop(newsHeading);
	}

	@When ("^Tap on category (.*) from category menu$")
	public void Tap_on_category_from_category_menu(String categoryMenu) 
	{
		objStepView.SelectCategory(categoryMenu);
	}

	@Then ("^A list of (.*) top stories should be displayed$")
	public void list_of_top_stories_should_be_displayed(int topStoriesCount) 
	{
		objStepView.verifyNoOfTopStories(topStoriesCount);
	}

	@When ("^Note down headings for some of the news articles$")
	public void Note_down_headings_for_some_of_the_news_articles()  
	{
		objStepView.noteNewsHeading();
	}

	@Then ("^Articles should be noted correctly$")
	public void Articles_should_be_noted_correctly() 
	{
		objStepView.verfiArticleNoted();
	}

	@When ("^Tap on weather icon, second from top right$")
	public void tap_On_Weather_Icon()  
	{
		objStepView.tapOnWeatherIcon();
	}

	@Then ("^Weather light box should be displayed with your current location, weather forecast for today and tomorrow$")
	public void verify_Weather_Location_Forecast_()  
	{
		objStepView.verifyWeatherForcast();
	}

	@When ("^Tap on the search icon on top right$")
	public void Tap_on_the_search_icon_on_top_right()  
	{
		objStepView.tapOnSearchIconOfWeather();
	}

	@Then ("^Edit box should be enabled for changing the location$")
	public void Edit_box_should_be_enabled()  
	{
		objStepView.verifyEditBoxEnable();
	}

	@When ("^Select the location from some other (.*) state$")
	public void select_Location(String location)  
	{
		objStepView.selectLocation(location);
	}

	@Then ("^Proper location should be selected and weather light box should be displayed with new (.*) location and updated weather$")
	public void Proper_location_should_be_selected(String location)  
	{
		objStepView.verifyLocation(location);
	}

	@When ("^Tap back button$")
	public void click_Back_Button()  
	{
		objStepView.clickBack();
	}

	@Then ("^User should navigate back to local news section$")
	public void User_should_navigate_back()  
	{
		objStepView.nevagateBackToLocal();
	}

	@When ("^validate the news articles with the earlier noted ones$")
	public void validate_News_Article()  
	{
		objStepView.validateNewsArticle();
	}

	@Then ("^The articles should have some discrepancy$")
	public void The_articles_should_have_some_discrepancy()  
	{
		objStepView.verifyArticlesDiscrepancy();
	}

	// iOS
	@Then ("^validate the heading (.*) of the lightBox$")
	public void validate_heading_of_the_lightBox(String strHeading)
	{
		objStepView.validateHeading(strHeading);
	}

	@Then ("^validate (.*) text in the lightBox$")
	public void validate_new_feature_text(String alertsText)
	{
		objStepView.validateFeatureText(alertsText);
	}

	@Then ("^validate button text for (.*) in the lightBox$")
	public void validate_not_now_text(String text)
	{
		objStepView.validateNowtext(text);
	}

	@Then ("^validate (.*) button text in lightBox$")
	public void validate_get_alerts_text(String strAlertsText)
	{
		objStepView.validateAlertsText(strAlertsText);
	}
 
	@Then ("^click on (.*) button$")
	public void click_not_now(String not_now)
	{
		objStepView.clickNotNow();
	}
	
	@Then ("^click on context menu$")
	public void click_on_context_menu()
	{
		objStepView.clickOnContextMenu();
	}
	
	@Then ("^validate all the top stories are greyed out$")
	public void validate_all_the_top_stories_are_greyed_out()
	{
		objStepView.validateTopStoriesGreyedOut();
	}

	@Then ("^tap on (.*) category from context menu$")
	public void tap_on_category_from_context_menu(String category)
	{
		objStepView.tapContextMenu();
	}
	
	@Then ("^click on RADIO ON DEMAND category from context menu$")
	public void tap_on_radio_on_demand_from_context_menu()
	{
		objStepView.clickDemand();
	}

	@Then ("^(.*) business articles should be displayed$")
	public void validate_seventeen_business_articles(String number)
	{
		objStepView.validateBusinessArticles(number);
		
	}
	
	@Then ("^total (.*) articles should be present on the page$")
	public void total_twentyone_articles_should_be_present_on_the_page(String number)
	{
		objStepView.varifyArticlesCount(number);
	}
	
	@Then ("^verify that last element is (.*)$")
	public void verify_business_in_90_seconds(String lastElement)
	{
		objStepView.verifyBusiness(lastElement);
	}
	
	@Then ("^tap on business in 90 seconds link$")
	public void tap_on_business_in_90_seconds_link()
	{
		objStepView.tapOnBusinessIn90SecondsLink();
	}
	
	@Then ("^light box should be displayed with details of video link$")
	public void light_box_should_be_displayed_for_video_link()
	{
		objStepView.verifyVideoLink();
	}
	
	@Then ("^tap on Watch Now button$")
	public void tap_on_Watch_Now_button()
	{
		objStepView.clickWatchProgram();
	}
	
	@Then ("^wait for (.*) seconds and take screenshot and tap on done$")
	public void take_screenshot_and_press_done(String wait) throws NumberFormatException, InterruptedException, IOException
	{
		objStepView.pressDone(wait);
	}
	
	@Then ("^Radio On Demand Tab Should be opened$")
	public void Radio_On_Demand_Tab_Should_be_opened()
	{
		objStepView.verifyOnDemandTabOpened();
	}

	@Then ("^Validate the number and names of the Radio streams under Radio on Demand$")
	public void Validate_the_number_and_names_of_the_Radio_streams_under_Radio_on_Demand()
	{
		objStepView.validateRadioOnDemand();
	}
	
	@Then ("^search the radio stream (.*) and open it$")
	public void search_the_radio_stream_the_music_show_and_open_it(String stream)
	{
		objStepView.searchRadioStreamAndOpen(stream);
	}
	
	@Then ("^lightbox should be opened with details about radio stream$")
	public void lightbox_should_be_opened_with_details_about_radio_stream()
	{
		objStepView.verifyRadioStream();
	}
	
	// Android
	@When ("^Tap on any article for details$")
	public void tapOnArticle()
	{
		objStepView.clickOnArticle();
	}
	
	@Then ("^Article details should be displayed with heading, date time and three buttons$")
	public void verify_Article_Details()
	{
		objStepView.verifyArticleDetails();
	}
	
	@When ("^Click on second button labeled as bigger A$")
	public void click_On_BiggerA()
	{
		objStepView.clickOnBiggerA();
	}
	
	@Then ("^Whole of the text including the heading on top should be increased in size$")
	public void verify_Article_Text()
	{
		objStepView.verifyArticleText();
	}
	
	@When ("^Click the second button again$")
	public void Click_Second_Button_A()
	{
		objStepView.ClickSecondButtonA();
	}
	
	@Then ("^The size should increase again$")
	public void verify_Article_Text_Again()
	{
		objStepView.verifyArticleTextAgain();
	}
	
	@When ("^Click on third button labeled as Smaller A$")
	public void click_Smaller_A()
	{
		objStepView.clickSmallerA();
	}
	
	@Then ("^Whole of the text including the heading on top should be decreased in size$")
	public void verify_Article_Decreased_Text()
	{
		objStepView.verifyArticleDecreasedText();
	}
	
	@When ("^Tap on article for details$")
	public void tap_On_Article_For_Details() throws InterruptedException
	{
		objStepView.tapOnArticleForDetails();
	}
	
	@Then ("^The article details should be displayed with heading$")
	public void verify_Article_Heading()
	{
		objStepView.verifyArticleHeading();
	}
	
	@When ("^Swipe from left to right till Weblink$")
	public void swipe_Till_Weblink() throws InterruptedException
	{
		objStepView.swipeTillWeblink();
	}
	
	@Then ("^Next article should be displayed$")
	public void verify_Next_Article()
	{
		objStepView.verifyNextArticle();
	}
	
	@When ("^Tap on Weblink$")
	public void tap_On_Weblink() throws InterruptedException
	{
		objStepView.tapOnWeblink();
	}
	
	@Then("^User should be navigated to the browser on that$")
	public void verify_Navigated_To_Browser() throws InterruptedException
	{
		objStepView.verifyNavigatedToBrowser();
	}
	
	@When ("^Navigate back to app$")
	public void navigate_Back()
	{
		objStepView.navigateBack();
	}
	
	@Then ("^User should be able to navigate back to app and the same article should be displayed on top$")
	public void verify_Article() throws InterruptedException
	{
		objStepView.verifyArticle();
	}
	
	@When ("^Swipe from left to right till Videolink$")
	public void swipe_Till_Video_Link() throws InterruptedException
	{
		objStepView.swipeTillVideolink();
	}
	
	@Then ("^Next article should be Present$")
	public void verify_Next_Article_Present()
	{
		objStepView.verifyNextArticlePresent();
	}
	
	@When ("^Tap on video link$")
	public void tap_On_Video_Link() throws InterruptedException
	{
		objStepView.tapOnVideolink();
	}
	
	@Then ("^User should be able to play the video properly from the video lightbox$")
	public void verify_Video()
	{
		objStepView.verifyVideo();
	}
	
	@Then ("^User should be able to navigate back to app and the same article should be Present$")
	public void verify_Article_Present() throws InterruptedException
	{
		objStepView.verifyArticlePresent();
	}
	
	@When ("^Swipe from left to right till Audiolink$")
	public void swipe_Till_Audio_Link() throws InterruptedException
	{
		objStepView.swipeTillAudiolink();
	}
	
	@Then ("^Next article should displayed$")
	public void verify_Next_Article_Should_Displayed()
	{
		objStepView.verifyNextArticleShouldDisplayed();
	}
	
	@When ("^Tap on audio link$")
	public void tap_On_Audio_Link() throws InterruptedException
	{
		objStepView.tapOnAudiolink();
	}
	
	@Then ("^User should be able to play the audio properly from the audio lightbox$")
	public void verify_Audio() throws InterruptedException
	{
		objStepView.verifyAudio();
	}
	
	@Then ("^User should be able to navigate back to app and the same article should displayed on top$")
	public void verify_Article_Should_Present() throws InterruptedException
	{
		objStepView.verifyArticleShouldPresent();
	}
	
	// IOS
	@Then ("click on play button and radio stream should be played")
	public void radio_stream_playing() throws InterruptedException
	{
		objStepView.radioStreamPlaying();
	}
	
	@Then ("^close the radio stream$")
	public void close_radio_stream() throws InterruptedException
	{
		objStepView.closeRadioStream();
	}
	
	@Then ("^top stories should be displayed$")
	public void display_top_stories()
	{
		objStepView.displayTopStories();
	}
*/
}
