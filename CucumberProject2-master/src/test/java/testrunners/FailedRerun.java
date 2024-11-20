package testrunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features={"@target/failedRerun.txt"},
        glue={"StepDefinitions","AppHooks"},
        monochrome=true,
        plugin={"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "timeline:test-output-thread/","rerun:target/failedRerun.txt"
})

public class FailedRerun {
//use rurun plugin and set the path in target or any folder and then create another runner file to execute
    //failed tc's also don't forget to change Feature file path to failed testcase path

}
