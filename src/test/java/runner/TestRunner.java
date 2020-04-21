package runner;



import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/LoginFunctionality.feature",
					glue= {"stepDefnitions"},
					dryRun=false,//mapping each and every step in feature file to step definition file
					monochrome=true,//readable output in console
					plugin= {"pretty","de.monochromata.cucumber.report.PrettyReports:reports/cucumber"},
				    tags= {"@Flipkart"}
					//tags = {"@functional or @adhoc"}
					//tags = {"@Shopping_page-datatable"}
					)

public class TestRunner {

}
