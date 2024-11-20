package AppHooks;

import com.qa.util.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.Assume;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import qa.factory.DriverFactory;

import java.util.Properties;

public class ApplicationHooks {

    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;
    Properties prop;

    @Before(value="@Skip",order=0)
    public void skip_Scenario(Scenario scenario){
        System.out.println("Skipped scenario is:"+scenario.getName());
        Assume.assumeTrue(false);
    }
    @Before(order=1)
    public void getProperty(){

        configReader = new ConfigReader();
        prop=configReader.init_prop();

    }
    @Before(order=2)
    public void launchBrowser()
    {
      String browserName= prop.getProperty("browser");
      driverFactory = new DriverFactory();
        driver=driverFactory.init_driver(browserName);
    }

    @After(order=0)
    public void quitBrowser(){
        driver.quit();

    }

    @After(order=1)
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            //take Screenshot:
           String screenshotName= scenario.getName().replaceAll(" ","_");
          byte[] sourcePath=  ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
          scenario.attach(sourcePath,"image/png",screenshotName);
        }
    }

}
