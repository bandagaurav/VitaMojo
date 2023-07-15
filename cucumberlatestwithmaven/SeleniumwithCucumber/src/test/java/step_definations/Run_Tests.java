package step_definations;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import com.github.mkolisnyk.cucumber.runner.RetryAcceptance;

import cucumber.api.CucumberOptions;

/*@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/resources/feature",
format = { "pretty", "html:target/cucumber", "json:target_json/cucumber.json", "junit:taget_junit/cucumber.xml" },
tags = {}
)*/

@ExtendedCucumberOptions(
        jsonReport = "target/81/cucumber.json",
        jsonUsageReport = "target/81/cucumber-usage.json",
        usageReport = true,
        detailedReport = true,
        detailedAggregatedReport = true,
        overviewReport = true,
        overviewChartsReport = true,
        pdfPageSize = "A4 Landscape",
        toPDF = false,
        outputFolder = "target/81",
        retryCount = 0)
@RunWith(ExtendedCucumber.class)
/*@ExtendedCucumberOptions(jsonReport = "target/cucumber.json",
        jsonUsageReport = "target/cucumber-usage.json",
        usageReport = true,
        outputFolder = "target")*/
@CucumberOptions(features = { "src/test/resources/feature" },
        tags = {},plugin = {
        		"usage:target/81/cucumber-usage.json","html:target/81", "json:target/cucumber-reports/CucumberTestReport.json","json:target/81/cucumber.json",
                "pretty:target/81/cucumber-pretty.txt",
                 "junit:target/81/cucumber-results.xml" })


public class Run_Tests{
	public static int retries = 0;
    public Run_Tests() {
    }
    @RetryAcceptance
    public static boolean retryCheck(Throwable e) {
        return true;
    }
}

