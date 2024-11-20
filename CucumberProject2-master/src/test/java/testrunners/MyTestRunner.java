package testrunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/test/resources/AppFeatures"},
        //tags="not @Skip",
        glue={"StepDefinitions","AppHooks"},plugin={"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "timeline:test-output-thread/","rerun:target/failedRerun.txt"
       })
public class MyTestRunner {


//In junit parallel exec(mvn failsafe plugin) we can only feature wise, to run scenario wise parallel execution we have to use testng
//To run using testng we have to place SD and runner class under same src/test/java package and feature file under
//src/test/resource folder and in test runner we have to mention annotations(@overrider,@DataProvider(parallel=true))
//extent AbstractTestngCucumberTests
//Reports:
      // Extent report,Spark pdf Report,spark extent html report,index.html(testng report)
}
