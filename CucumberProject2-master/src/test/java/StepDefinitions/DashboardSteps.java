package StepDefinitions;

import com.Pages.DashboardPage;
import com.Pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import qa.factory.DriverFactory;

import java.util.List;
import java.util.Map;

public class DashboardSteps {
    private LoginPage login= new LoginPage(DriverFactory.getDriver());
    private DashboardPage dpage;

    @Given("User have already logged into application")
    public void user_have_already_logged_into_application(DataTable CredentialsTable) {
       List<Map<String,String>> credList= CredentialsTable.asMaps();
       String uname= credList.get(0).get("username");
       String pswd= credList.get(0).get("password");
        DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        dpage= login.doLogin(uname,pswd);
    }
    @Given("user is on Dashboard page")
    public void user_is_on_dashboard_page() {
      String Title=  dpage.getDashboardPagetitile();
        System.out.println("Page title is:"+Title);


    }

    @Then("user gets leftpanel section")
    public void user_gets_leftpanel_section(DataTable ExpLeftPanelList) {

       List<String> expectedLeftPanelList= ExpLeftPanelList.asList();
        System.out.println("Expected accounts section list:"+expectedLeftPanelList);
        List<String> ActualLeftPanelList=dpage.getleftPanelList();
        System.out.println("Actual accounts section list:"+ActualLeftPanelList);
        Assert.assertTrue(expectedLeftPanelList.containsAll(ActualLeftPanelList));

    }

    @Then("Dashboard left panel section count must be {int}")
    public void dashboard_left_panel_section_count_must_be(Integer ExpectedCount) {
        Assert.assertTrue(dpage.getLeftPanelCount()==ExpectedCount);

    }
}
