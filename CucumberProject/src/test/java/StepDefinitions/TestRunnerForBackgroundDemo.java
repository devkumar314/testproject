package StepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/BackgroundDemo/BackgroundDemo.feature", glue= {"StepsForBackgroundDemo"},
monochrome=true,
stepNotifications = true,
plugin = {"pretty","html:target/HTMLReports.html",
"json:target/JSONReports/reports.json",
"junit:target/JUnitReports/reports.xml"
})
public class TestRunnerForBackgroundDemo{
	
}

//tags="@SmokeTest And/or @regression",