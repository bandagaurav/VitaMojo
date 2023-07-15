package step_definations;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LoginPage;
import pages.SignupPage;

public class stepDefination{
public static WebDriver driver;

    SignupPage signupPage;

    LoginPage loginPage;

    public stepDefination()
{ 
driver = Hooks.driver;

    signupPage = new SignupPage(driver);
    loginPage = new LoginPage(driver);

} 

@Given("^User is on Home Page$")
public void user_is_on_Home_Page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
driver.get("http://www.gmail.com");
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.manage().window().maximize();
}

    @Given("^User clicks on Login Button$")
    public void user_clicks_on_Login_Button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        signupPage.clickonLoginButton();
    }

    @Given("^User clicks on create account tab$")
    public void user_clicks_on_create_account_tab() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        signupPage.navigateTo_createAccountTab();
    }

    @When("^User enters Name$")
    public void user_enters_Name() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        signupPage.userentersName();
    }

    @When("^User enters email address$")
    public void user_enters_email_address() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        signupPage.userentersEmailAddress();
    }

    @When("^User enters password$")
    public void user_enters_password() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        signupPage.userentersPasswrod();
    }

    @When("^User clicks on future discounts checkbox$")
    public void user_clicks_on_future_discounts_checkbox() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        signupPage.userclicksonDiscountscheckbox();
    }

    @Then("^User clicks on create account button$")
    public void user_clicks_on_create_account_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        signupPage.userclicksonCreateButton();
    }

    @Then("^Message displayed Signup Successfully$")
    public void message_displayed_Signup_Successfully() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        signupPage.userValidatesSignup();
    }
    @When("^User enters login email address$")
    public void user_enters_login_email_address() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        loginPage.userentersEmail();
    }

    @When("^User enters login password$")
    public void user_enters_login_password() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        loginPage.userentersPassword();

    }

    @When("^User Clicks on login button$")
    public void user_Clicks_on_login_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        loginPage.userclicksLogin();

    }

    @Then("^Message displayed Login Successfully$")
    public void message_displayed_Login_Successfully() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        loginPage.userValidatesLogin();

    }

}


