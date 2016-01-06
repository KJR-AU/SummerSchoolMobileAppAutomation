package com.pageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;

/**
 *Copyright (c) 2015-2016, ABC-Australian Broadcasting Corporation.  All rights reserved.
 *@Description - Contains Mobile Elements and wrapper methods.
 *@Author - Shantanu S Deshpande(SQS)
 *CreatedOn:- 23-06-2015 		@ ModifyDate 
 **/

public class TopStoriesPage 
{
	// Local variables
	private AppiumDriver driver;

	// Mobile elements 
	@AndroidFindAll({
		@AndroidFindBy(xpath = ".//android.widget.ListView/android.widget.RelativeLayout"),
	}) 
	public List<MobileElement> heading;

	@AndroidFindAll({
		@AndroidFindBy(name = "Goulburn's Big Merino in 'blue balls' campaign for men's health"), 
	}) 
	public MobileElement articleHeading;

	@AndroidFindAll({
		@AndroidFindBy(name = "10:24ISTWED 10 SEP 2014"), 
	}) 
	public MobileElement dateTime;

	@AndroidFindAll({
		@AndroidFindBy(name = "Share Article Button. Double Tap to share article"), 
	}) 
	public MobileElement shareArticleButton;

	@AndroidFindAll({
		@AndroidFindBy(name = "Increase Font Size Button. Double Tap to increase font size"), 
	}) 
	public MobileElement increaseFontSizeButton;

	@AndroidFindAll({
		@AndroidFindBy(name = "Decrease Font Size Button. Double Tap to decrease font size"), 
	}) 
	public MobileElement decreaseFontSizeButton;

	@AndroidFindAll({
		@AndroidFindBy(xpath = ".//android.view.View[contains(@content-desc,'Two men arrested after raid on Islamic centre')]"),
	})
	public MobileElement  weFirstNews;

	@AndroidFindAll({
		@AndroidFindBy(xpath = ".//android.view.View[contains(@content-desc,'Gillard fronts trade union royal commission')]"),
	})
	public MobileElement  weNextArticle;

	@AndroidFindAll({
		@AndroidFindBy(xpath = ".//android.view.View[contains(@content-desc,'External Link: Gillard royal commission live blog Link')]"),
	})
	public MobileElement  weWebLink;

	@AndroidFindAll({
		@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.android.chrome:id/url_bar\")"),
	})
	public MobileElement  weURL;

	@AndroidFindAll({
		@AndroidFindBy(xpath = ".//android.view.View[contains(@content-desc,'Rare fish species found in outback bore drain')]"),
	})
	public MobileElement  weElevanthArticle;

	@AndroidFindAll({
		@AndroidFindBy(xpath = ".//android.view.View[contains(@content-desc,'Video:')]"),
	})
	public MobileElement  weVideoLink;

	@AndroidFindAll({
		@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android.AbcApplication:id/mppWrapper\")"), //by this locator element is found
	})
	public MobileElement  watchProgram;

	@AndroidFindAll({
		@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/time_current\")"), //by this locator element is found
	})
	public MobileElement  videoCurrentTime;

	@AndroidFindAll({
		@AndroidFindBy(xpath = ".//android.view.View[contains(@content-desc,'Government confirms attack threat rises to')]"), //by this locator element is found
	})
	public MobileElement  weTwelfthArticle;

	@AndroidFindAll({
		@AndroidFindBy(xpath = "//android.view.View[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.support.v4.view.ViewPager[1]/android.widget.LinearLayout[1]/android.view.View[1]/android.view.View[25]"), //by this locator element is found
	})
	public MobileElement  weAudioLink;

	@AndroidFindAll({
		@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android.AbcApplication:id/mppWrapper\")"), //by this locator element is found
	})
	public MobileElement  listenProgram;

	@AndroidFindAll({
		@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android.AbcApplication:id/mppTimerDisplay\")"), //by this locator element is found
	})
	public MobileElement  audioCurrentTime;

	@AndroidFindAll({
		@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android.AbcApplication:id/mppIcon\")"), //by this locator element is found
	})
	public MobileElement  audioPauseButton;

	// constructor for class
	public TopStoriesPage(AppiumDriver wdriver)
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

	// Wrapper methods
	public boolean tapOnArticle(String sArticleNo)
	{
		try
		{
			//Get all the article
			List<MobileElement> previousNewsHeadings = heading;
			//Tap on any article for details -> Tapping on First Article
			if(sArticleNo.equalsIgnoreCase("First"))
			{
				previousNewsHeadings.get(0).click();
			}
			else
			{
				previousNewsHeadings.get(previousNewsHeadings.size()-1).click();
			}
			//Wait
			Thread.sleep(3000);
			return true;
		} 
		catch (Exception exception) 
		{
			exception.printStackTrace();
			return false;
		}
	}

	public boolean clickOnBiggerA()
	{
		try
		{
			increaseFontSizeButton.click();
			return true;
		} 
		catch (Exception exception) 
		{
			exception.printStackTrace();
			return false;
		}
	}

	public boolean verifyArticleTextIncreased()
	{
		try
		{


			increaseFontSizeButton.click();
			return true;
		} 
		catch (Exception exception) 
		{
			exception.printStackTrace();
			return false;
		}
	}

	public boolean clickOnSmallerA()
	{
		try
		{
			decreaseFontSizeButton.click();
			return true;
		} 
		catch (Exception exception) 
		{
			exception.printStackTrace();
			return false;
		}
	}

	public boolean clickOnWeblink()
	{
		try
		{
			weWebLink.click();
			return true;
		} 
		catch (Exception exception) 
		{
			exception.printStackTrace();
			return false;
		}
	}

	public boolean navigatedToBrowser()
	{
		try
		{
			if(weURL.isDisplayed())
			{
				String sURLText = weURL.getText();
				System.out.println("sURL:" + weURL.getText());
				if(sURLText.contains("livenews.abc.net.au"))
				{
					return true;
				}
				return false;
			}
			else
			{
				return false;
			}

		}
		catch (Exception exception) 
		{
			exception.printStackTrace();
			return false;
		}

	}

	public boolean navigateBack()
	{
		try
		{
			driver.navigate().back();
			return true;
		} 
		catch (Exception exception) 
		{
			exception.printStackTrace();
			return false;
		}
	}

	public boolean clickOnVideolink()
	{
		try
		{
			weVideoLink.click();
			Thread.sleep(2000);
			watchProgram.click();
			Thread.sleep(3000);
			return true;
		} 
		catch (Exception exception) 
		{
			exception.printStackTrace();
			return false;
		}
	}

	public boolean verifyVideo()
	{
		try
		{
			Dimension size = driver.manage().window().getSize(); 
			int startx = size.width / 2;
			int starty = size.height / 2;
			driver.tap(1, startx, starty, 1000);
			Thread.sleep(500);			
			if(videoCurrentTime.isDisplayed())
			{
				int time = Integer.parseInt(videoCurrentTime.getText().split(":")[1]);
				if(time>0)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			else
			{
				return false;
			}
		}
		catch (Exception exception) 
		{
			exception.printStackTrace();
			return false;
		}
	}

	public boolean clickOnAudiolink()
	{
		try
		{
			driver.findElement(By.xpath("//android.view.View[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.support.v4.view.ViewPager[1]/android.widget.LinearLayout[1]/android.view.View[1]/android.view.View[25]")).click();
			Thread.sleep(2000);
			listenProgram.click();
			Thread.sleep(2000);
			return true;
		} 
		catch (Exception exception) 
		{
			exception.printStackTrace();
			return false;
		}
	}

	public boolean verifyAudio()
	{
		try
		{
			if(audioCurrentTime.isDisplayed())
			{
				int time = Integer.parseInt(audioCurrentTime.getText().split(":")[1]);
				if(time>0)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			else
			{
				return false;
			}
		}
		catch (Exception exception) 
		{
			exception.printStackTrace();
			return false;
		}
	}

}