package com.stepDefinitions;
import java.io.IOException;

import com.generic.StepBase;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * @ScriptName    : Hooks
 * @Description   : This class contains   
 * @Author        : Automation Tester (SQS)
 * @Creation Date : 17 Jun 2015   @Modified Date:                       
 */
public class Hooks 
{
	public Scenario currentScenario;
	StepBase objStepBase = new StepBase();
	@Before
	public void applyHook(Scenario scenario)
	{
		currentScenario = scenario;
		objStepBase.setUp(scenario);
	}

	@After
	public void tearDown(Scenario scenario) throws IOException 
	{
		objStepBase.tearDown(scenario);
	}
	
	
}
