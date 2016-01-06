package com.features;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		//dryRun = false,
		strict = true,
		//features = "src/test/java/com/features/TC_4.feature",
		features = "src/test/java/com/features",
		glue = {"com.stepDefinitions"},
		//tags = {"@iOS"},
		tags = {"@Android"},
		monochrome = true,
		format = {
				"pretty",
				"html:src/test/java/com/testresult/cucumber-report",
				"junit:src/test/java/com/testresult/cucumber-report/cucumber.xml",
				"json:src/test/java/com/testresult/cucumber-report/cucumber.json"
		}
		)
/**
 * @ScriptName    : TestRunner
 * @Description   : This class contains   
 * @Author        : Automation Tester (SQS)
 * @Creation Date : 17 Jun 2015   @Modified Date:                       
 */
public class TestRunner
{ 

}