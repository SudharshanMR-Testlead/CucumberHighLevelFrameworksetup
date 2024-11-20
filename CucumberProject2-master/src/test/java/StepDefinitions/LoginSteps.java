package StepDefinitions;

import com.Pages.LoginPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import qa.factory.DriverFactory;

public class LoginSteps {
   private String title;

    private LoginPage login= new LoginPage(DriverFactory.getDriver());

    @Given("user is on login page")
    public void user_is_on_login_page() {

DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }

    @When("user gets the title of the page")
    public void user_gets_the_title_of_the_page() {
       title= login.getLoginPageTitle();
        System.out.println("Login page title is:"+title);
    }

    @Then("page title should be {string}")
    public void page_title_should_be(String expectedTitleName) {

        Assert.assertTrue(title.contains(expectedTitleName));
    }

    @Then("forgot your password link should be displayed")
    public void forgot_your_password_link_should_be_displayed() {
Assert.assertTrue(login.isForgotpwdLinkExist());
    }

    @When("user enters username {string}")
    public void user_enters_username(String username) {
        login.enterUserName(username);

    }

    @When("user enters password {string}")
    public void user_enters_password(String password) {
        login.enterpassword(password);

    }

    @When("user clicks on Login button")
    public void user_clicks_on_login_button() {
        login.clickOnLogin();

    }
}
