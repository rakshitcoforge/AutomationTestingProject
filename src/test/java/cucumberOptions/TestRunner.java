package cucumberOptions;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src//test//resources//features"},glue= {"stepDefinations","hooks"},tags="@login",
plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
dryRun=false)
public class TestRunner extends AbstractTestNGCucumberTests {

}
