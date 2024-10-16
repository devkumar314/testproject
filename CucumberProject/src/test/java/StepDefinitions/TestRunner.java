package StepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features", glue= {"StepDefinitions"},
tags="@Smoke and @regression",
monochrome=true,
stepNotifications = true,
dryRun=true,
plugin = {"pretty","html:target/HTMLReports.html",
"json:target/JSONReports/reports.json",
"junit:target/JUnitReports/reports.xml",
"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"  // This is for Allure reporting
})
public class TestRunner{
	
}

//tags="@SmokeTest And/or @regression",