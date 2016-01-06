package com.generic;

import java.io.File;
import java.io.FileFilter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.ReportBuilder;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

/**
 * @ScriptName    : GenerateCustomeReport
 * @Description   : This class generate test execution reports using net.masterthought 
 * @Author        : Automation Tester (SQS)
 * @Creation Date : 17 Jun 2015   @Modified Date:                       
 */
public class TestGenerateCustomReport
{
	// Local variables
	private String reportPath;
	private String jsonFilePath;
	private String xmlFilePath;
	private String buildNumber;
	private String buildProjectName;
	private String pluginURLPath;
	private Boolean skippedFails;
	private Boolean undefinedFails;
	private Boolean flashCharts;
	private Boolean runWithJenkins;
	private Boolean artificatsEnabled;
	private String artifactsConfig;
	private boolean highCharts;
	private DateTimeFormatter dateFormat;
	private String repoPath;
	private Utilities objUtilities = new Utilities(); 
	
	@Test
	public void generateCustomeReport()
	{
		try
		{
			
			reportPath = "src/test/java/com/testresult/cucumber-html-reports";
			jsonFilePath = "src/test/java/com/testresult/cucumber-report/cucumber.json";
			xmlFilePath = "src/test/java/com/testresult/cucumber-report/cucumber.xml";
			repoPath = "src/test/java/com/testresult/cucumber-report/";
			
			dateFormat = DateTimeFormat.forPattern("yyyy-MM-dd_HHmmss");
			String currentTimeStamp = dateFormat.print(new DateTime());
			File reportPickupDirectory = new File(reportPath);
			File reportOutputDirectory = new File(reportPath + "_"	+ currentTimeStamp);

			List<String> jsonReportFiles = new ArrayList<String>();
			jsonReportFiles.add(jsonFilePath);

			buildNumber = "1";
			buildProjectName = "ABC Mobile Automation";
			pluginURLPath = "";
			skippedFails = true;
			undefinedFails = true;
			flashCharts = true;
			runWithJenkins = false;
			artificatsEnabled = false;
			artifactsConfig = "";
			highCharts = true;

			ReportBuilder reportBuilder = new ReportBuilder(jsonReportFiles,
					reportPickupDirectory, pluginURLPath, buildNumber,
					buildProjectName, skippedFails, undefinedFails, flashCharts,
					runWithJenkins, artificatsEnabled, artifactsConfig, highCharts);
			reportBuilder.generateReports();

			if (reportOutputDirectory.mkdir())
				FileUtils.copyDirectory(reportPickupDirectory,
						reportOutputDirectory);
			
			File json = new File(reportOutputDirectory + "/cucumber.json");
			File xml = new File(reportOutputDirectory + "/cucumber.xml");
			
			objUtilities.copyFileUsingStream(new File(jsonFilePath), json);
			objUtilities.copyFileUsingStream(new File(xmlFilePath), xml);

			/*if (System.getProperty("env")=="testdroid")
			{
				File dir = new File(repoPath);
				FileFilter fileFilter = new WildcardFileFilter("*.png");
				File[] files = dir.listFiles(fileFilter);
				for (File source : files) {
					File dest = new File(reportOutputDirectory + "/" + source.getName());
					objUtilities.copyFileUsingStream(source, dest);
				}
			}*/
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
	}
}
