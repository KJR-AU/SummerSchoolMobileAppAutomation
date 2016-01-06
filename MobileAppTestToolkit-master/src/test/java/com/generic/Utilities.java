package com.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;

/**
 * @ScriptName    : Utilities
 * @Description   : This class contains   
 * @Author        : Automation Tester (SQS)
 * @Creation Date : 17 Jun 2015   @Modified Date:                       
 */
public class Utilities 
{
	private StepBase objStepBase = new StepBase();

	/**
	 * Method: takeScreenshot
	 * Description: 
	 * @param timeInMilliseconds
	 * @author Automation Tester (SQS) Creation Date:  27 April 2015 Modified Date:
	 */
	public void takeScreenshot()
	{
		try {
			File scrFile = ((TakesScreenshot)objStepBase.getDriver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "/src/test/java/com/testresult/ScreenShots/screenshot_"+ getRequiredDate(0, "yyyy_MM_dd_hh:mm:ss", null) +".png"));
		}
		catch (Exception ex){
			new RuntimeException(ex);
		}
	}

	
	/**
	 * Method: waitFor
	 * Description: Waits for the specified amount of [timeInMilliseconds].
	 * @param timeInMilliseconds
	 * @author Automation Tester (SQS) Creation Date:  27 April 2015 Modified Date:
	 */
	public void waitFor(final Long timeInMilliseconds)
	{
		try 
		{
			Thread.sleep(timeInMilliseconds);
		}
		catch (Exception e) 
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * Method: getRequiredDate
	 * Description: This method will give require date
	 * @param incrfementDateByDays Number by which user want increase date 
	 * @param sExpectedDateFormat - User expected date format
	 * 		eg. 9 april 2014 --- dd/MM/yyyy -> 09/04/2015, dd-MM-yyyy -> 09-04-2015
	 * @param timeZoneId - Time Zone
	 * @author Automation Tester (SQS) Creation Date:  27 April 2015  Modified Date:
	 */
	public String getRequiredDate (int incrementDays, String expectedDateFormat, String timeZoneId)
	{
		try 
		{
			DateFormat dateFormat;
			Calendar calendar = Calendar.getInstance();
			dateFormat = new SimpleDateFormat(expectedDateFormat);
			if(timeZoneId != null && ! timeZoneId.equals(""))
				dateFormat.setTimeZone(TimeZone.getTimeZone(timeZoneId));
			calendar.add(Calendar.DAY_OF_MONTH, incrementDays);
			Date tomorrow = calendar.getTime();
			String formattedDate = dateFormat.format(tomorrow);
			return formattedDate;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Method: swipeRight
	 * Description: 
	 * @param timeInMilliseconds
	 * @author Automation Tester (SQS) Creation Date:  27 April 2015 Modified Date:
	 */
	public void swipeRight()
	{
		try
		{
			Dimension size = objStepBase.getDriver().manage().window().getSize(); 
			int starty = size.height / 2;
			int startx = (int) (size.width * 0.9);
			int endx = (int) (size.width * 0.1);
			objStepBase.getDriver().swipe(startx, starty, endx, starty, 1000);
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	}

	/**
	 * Method: swipeLeft
	 * Description: 
	 * @param timeInMilliseconds
	 * @author Automation Tester (SQS) Creation Date:  27 April 2015 Modified Date:
	 */
	public void swipeLeft()
	{
		try
		{
			Dimension size = objStepBase.getDriver().manage().window().getSize(); 
			int starty = size.height / 2;
			int startx = (int) (size.width * 0.1);
			int endx = (int) (size.width * 0.9);
			objStepBase.getDriver().swipe(startx, starty, endx, starty, 1000);
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	}

	/**
	 * Method: scrollDown
	 * Description: 
	 * @param timeInMilliseconds
	 * @author Automation Tester (SQS) Creation Date:  27 April 2015 Modified Date:
	 */
	public void scrollDown()
	{
		try
		{
			Dimension size = objStepBase.getDriver().manage().window().getSize(); 
			int starty = (int) (size.height * 0.8);
			int endy = (int) (size.height * 0.2);
			int startx = size.width / 2;
			objStepBase.getDriver().swipe(startx, starty, startx, endy, 1000);
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	}

	/**
	 * Method: scrollUp
	 * Description: 
	 * @param timeInMilliseconds
	 * @author Automation Tester (SQS) Creation Date:  27 April 2015 Modified Date:
	 */
	public void scrollUp()
	{
		try
		{
			Dimension size = objStepBase.getDriver().manage().window().getSize(); 
			int starty = (int) (size.height * 0.2);
			int endy = (int) (size.height * 0.8);
			int startx = size.width / 2;
			objStepBase.getDriver().swipe(startx, starty, startx, endy, 1000);
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	}

	/**
	 * Method: scrollUp
	 * Description: 
	 * @param timeInMilliseconds
	 * @author Automation Tester (SQS) Creation Date:  27 April 2015 Modified Date:
	 */
	public void copyFileUsingStream(File source, File dest) throws IOException
	{
		InputStream is = null;
		OutputStream os = null;
		try 
		{
			is = new FileInputStream(source);
			os = new FileOutputStream(dest);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
		}
		catch(Exception exception)
		{
			exception.printStackTrace();

		} 
		finally 
		{
			is.close();
			os.close();
		}
	}
}
