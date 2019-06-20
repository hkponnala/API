package Runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
// The path of features file
features = "C:/Users/hkpon/workspace/FreeCrmBDDFramework/src/main/java/Features"
// The path of Step Definition file
, glue= {"StepDefinition"}
// Generates different types of reporting
, format = {"pretty","html:test-output","json:json-output/cucumber.json","junit:xml-output/cucumber.xml"}
//displays the console output in a readable format
, monochrome = true
// Verifies if there are any missing steps in the Step Definition file
, strict = true
// Which test case to execute
, tags = {"@API"}
//verifies the mapping between features file and Step Definition file
, dryRun = false
)

public class TestRunner {

}
