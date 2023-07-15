package pages;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//input[@id='email']")
    private WebElement emailaddress;

    @FindBy(how = How.XPATH, using = "//input[@id='password']")
    private WebElement password;

    @FindBy(how = How.XPATH, using = "//button[text()='Login']")
    private WebElement loginbutton;

    @FindBy(how = How.XPATH, using = "//*[contains(@class,'css-xooaem')]")
    private WebElement displayedName;

    public void userentersEmail() {

        emailaddress.sendKeys(SignupPage.fullemailaddress);

    }

    public void userentersPassword() {

        password.sendKeys(SignupPage.fullpassword);
    }

    public void userclicksLogin() {

        loginbutton.click();
    }

    public void userValidatesLogin() {

        Assert.assertEquals(SignupPage.fullname,displayedName.getText());
    }
}


