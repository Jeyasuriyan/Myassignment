package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"},
        glue = "stepsdefinitions", plugin = {"json:target/cucumber.json"},
        tags = "@regression",
        monochrome = true)
public class Testrunner {
//    "@withoutheader or @withheaderbyindex or @withheaderbyfor or @classobjects or @scenariooutline"
}
