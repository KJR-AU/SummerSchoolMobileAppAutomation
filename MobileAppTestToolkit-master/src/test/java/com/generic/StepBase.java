package com.generic;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Calendar;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;

/**
 * @ScriptName    : StepBase
 * @Description   : This class contains generic functionalities like setup/teardown test environment  
 * @Author        : Automation Tester (SQS)
 * @Creation Date : 17 Jun 2015   @Modified Date:                       
 */
public class StepBase 
{
	// Local Variables
	protected static AppiumDriver driver = null;
	protected static WebDriverWait webDriverWait;
	public static Scenario crScenario; 
	 
	/**
	 * @Method: setUp
	 * @Description:  
	 * @author Automation Tester (SQS) 
	 * @Creation Date:  17 Jun 2015  @Modified Date:
	 */
	public void setUp(Scenario cScenario)
	{
		crScenario = cScenario;
		try
		{
			// Load configuration file
			Properties objConfig = new Properties();
		 	if(System.getProperty("platform").equals("android"))
				objConfig.load(new FileInputStream(System.getProperty("user.dir") + "/src/test/java/com/androidConfig.properties"));
			else if(System.getProperty("platform").equals("ios"))
				objConfig.load(new FileInputStream(System.getProperty("user.dir") + "/src/test/java/com/iOSConfig.properties"));

			if(System.getProperty("env").equals("local"))
			{
				// Load APK/IPA properties file
				Properties objAppConfig = new Properties();
				objAppConfig.load(new FileInputStream(System.getProperty("user.dir") + "/src/test/java/com/mobileApps/" + objConfig.getProperty("test.app.name") + "_config.properties"));

				// Load specified mobile properties file
				Properties objMobileConfig = new Properties();
				objMobileConfig.load(new FileInputStream(System.getProperty("user.dir") + "/src/test/java/com/mobileConfig/" + System.getProperty("device") + ".properties"));

				if(System.getProperty("platform").equals("android"))
				{
					// Set the capabilities for AndroidDriver
					DesiredCapabilities capabilities = new DesiredCapabilities();
					capabilities.setCapability("deviceName", objMobileConfig.getProperty("device.name"));
					capabilities.setCapability("platformName", objMobileConfig.getProperty("device.platformName"));
					capabilities.setCapability("platformVersion", objMobileConfig.getProperty("device.platformVersion"));
					capabilities.setCapability("enablePerformanceLogging", true);
					capabilities.setCapability("appPackage", objAppConfig.getProperty("app.Package"));
					capabilities.setCapability("appActivity", objAppConfig.getProperty("app.Activity"));
					capabilities.setCapability("appWaitActivity", objAppConfig.getProperty("app.WaitActivity"));
					capabilities.setCapability("autoAcceptAlerts",true);
					File appdir = new File(System.getProperty("user.dir") + "/src/test/java/com/mobileApps");
					File app = new File(appdir, objConfig.getProperty("test.app.name") + ".apk");
					capabilities.setCapability("app", app.getAbsolutePath());
					driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
					webDriverWait = new WebDriverWait(driver, 90);
				}

				else if(System.getProperty("platform").equals("ios"))
				{
					// Set the capabilities for IOSDriver
					DesiredCapabilities capabilities = new DesiredCapabilities();
					capabilities.setCapability("deviceName", objMobileConfig.getProperty("device.name")); 
					capabilities.setCapability("platformName", objMobileConfig.getProperty("device.platformName"));
					capabilities.setCapability("platformVersion", objMobileConfig.getProperty("device.platformVersion"));
					capabilities.setCapability("udid", objMobileConfig.getProperty("device.udid"));
					capabilities.setCapability("bundleid", objAppConfig.getProperty("app.bundleid"));
					capabilities.setCapability("autoAcceptAlerts",true);
					capabilities.setCapability("newCommandTimeout",180);
					
					File appdir = new File(System.getProperty("user.dir") + "/src/test/java/com/mobileApps");
					File app = new File(appdir, objConfig.getProperty("test.app.name") + ".app");
					//capabilities.setCapability("app", app.getAbsolutePath()); //comment out if using a browser
					capabilities.setCapability(CapabilityType.BROWSER_NAME, "Safari"); //comment out if using an app
					driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
					webDriverWait = new WebDriverWait(driver, 90);
				}
			}

			else if(System.getProperty("env").equals("testdroid"))
			{
				if(System.getProperty("platform").equals("android"))
				{
					// Set the capabilities for AndroidDriver for testdroid
					DesiredCapabilities capabilities = new DesiredCapabilities();
					capabilities.setCapability("platformName", objConfig.getProperty("device.platformName"));
					capabilities.setCapability("testdroid_target", objConfig.getProperty("test.testdroid.target"));
					capabilities.setCapability("deviceName", System.getProperty("device"));
					capabilities.setCapability("testdroid_username", objConfig.getProperty("test.testdroid.username"));
					capabilities.setCapability("testdroid_password", objConfig.getProperty("test.testdroid.password"));
					capabilities.setCapability("testdroid_project", objConfig.getProperty("test.testdroid.project"));
					capabilities.setCapability("autoAcceptAlerts",true);
					String strTestRun = objConfig.getProperty("test.testdroid.testrun") ;
					DateTimeFormatter dateFormat = DateTimeFormat.forPattern("YYYYMMdd_HHmmss");
					String currentTimeStamp = dateFormat.print(new DateTime());
					strTestRun = strTestRun + "_" + currentTimeStamp;
					capabilities.setCapability("testdroid_testrun", strTestRun);
					capabilities.setCapability("testdroid_device",  System.getProperty("device"));
					capabilities.setCapability("testdroid_app", objConfig.getProperty("test.testdroid.app")); 
					driver = new AndroidDriver(new URL(objConfig.getProperty("test.testdroid.server")+"/wd/hub"), capabilities);
				}

				else if(System.getProperty("platform").equals("ios"))
				{
					// Set the capabilities for IOSDriver for testdroid
					DesiredCapabilities capabilities = new DesiredCapabilities();
					capabilities.setCapability("device", objConfig.getProperty("test.testdroid.platformName"));
					capabilities.setCapability("deviceName", objConfig.getProperty("test.testdroid.deviceName"));
					capabilities.setCapability("testdroid_username", objConfig.getProperty("test.testdroid.username"));
					capabilities.setCapability("testdroid_password", objConfig.getProperty("test.testdroid.password"));
					capabilities.setCapability("testdroid_project", objConfig.getProperty("test.testdroid.project"));
					capabilities.setCapability("autoAcceptAlerts",true);
					String strTestRun = objConfig.getProperty("test.testdroid.testrun") ;
					DateTimeFormatter dateFormat = DateTimeFormat.forPattern("YYYYMMdd_HHmmss");
					String currentTimeStamp = dateFormat.print(new DateTime());
					strTestRun = strTestRun + "_" + currentTimeStamp;
					capabilities.setCapability("testdroid_testrun", strTestRun);
					capabilities.setCapability("testdroid_device", System.getProperty("device"));
					capabilities.setCapability("testdroid_app", objConfig.getProperty("test.testdroid.app")); //to use existing app using "latest" as fileUUID
					capabilities.setCapability("testdroid_target", objConfig.getProperty("test.testdroid.target"));
					capabilities.setCapability("app", objConfig.getProperty("test.testdroid.bundleid"));
					driver = new IOSDriver(new URL(objConfig.getProperty("test.testdroid.server")+"/wd/hub"), capabilities);
				}
			}
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	}

	/**
	 * @Method: tearDown
	 * @Description:  
	 * @author Automation Tester (SQS) 
	 * @throws IOException 
	 * @Creation Date:  17 Jun 2015  @Modified Date:
	 */
	public void tearDown(Scenario scenario) throws IOException 
	{
		if (scenario.isFailed()) 
		{
			embedScreenshot();
		}

		driver.quit();
	}


	/**
	 * @Method: getDriver
	 * @Description:  
	 * @return :Appium Driver instance
	 * @author Automation Tester (SQS) 
	 * @Creation Date:  17 Jun 2015  @Modified Date:
	 */
	public AppiumDriver getDriver()
	{
		return driver;
	}
 
	/**
	 * Method: embedScreenshot
	 * Description: 
	 * @param 
	 * @author Automation Tester (SQS) Creation Date:  25 June 2015 Modified Date:
	 */
	public static void embedScreenshot() throws IOException
	{

			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//			Path pqr = scrFile.toPath();
//			byte[] abc = Files.readAllBytes(pqr);
			crScenario.embed(screenshot, "image/png"); //stick it in the report
//			scenario.embed(abc, "image/png");
//			File testScreenshot = new File(System.getProperty("user.dir") + "/src/test/java/com/testResults/Screenshots/Screenshot1.png");
//			FileUtils.copyFile(scrFile, testScreenshot);

	}

}
