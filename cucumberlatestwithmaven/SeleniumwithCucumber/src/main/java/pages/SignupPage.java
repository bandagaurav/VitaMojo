package pages;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
    public static String fullname;
    public static String fullpassword;
    public static String fullemailaddress;

    @FindBy(how = How.XPATH, using = "//a[text()='Login']")
    private WebElement loginbutton;

    @FindBy(how = How.XPATH, using = "//li[descendant::text()='Create Account']")
    private WebElement createAccountTab;

    @FindBy(how = How.XPATH, using = "//input[@id='firstName']")
    private WebElement name;
    @FindBy(how = How.XPATH, using = "//input[@id='password']")
    private WebElement password;
    @FindBy(how = How.XPATH, using = "//input[@id='email']")
    private WebElement emailaddress;

    @FindBy(how = How.XPATH, using = "(//*[contains(text(), 'I want to receive')]/ancestor-or-self::*/DIV[contains(@class, 'css-q1j3qv') and contains(@class, 'e379e0i4')])[1]")
    private WebElement futureDiscountscheckbox;

    @FindBy(how = How.XPATH, using = "//button[descendant::text()='Create Account']")
    private WebElement createAccountButton;
    @FindBy(how = How.XPATH, using = "//*[contains(@class,'css-xooaem')]")
    private WebElement nameDisplayed;

    WebDriver driver;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickonLoginButton() {
        loginbutton.click();
    }

    public void userentersName() {
        String random = RandomStringUtils.random(2, true, false);
        String firstname = "gaurav";
        fullname = firstname + random;
        name.sendKeys(fullname);


    }

    public void navigateTo_createAccountTab() {
        createAccountTab.click();
    }

    public void userentersEmailAddress() {
        String email = "selenium.srtester";
        String random = RandomStringUtils.random(2, true, false);
        fullemailaddress = email + random + "@gmail.com";
        emailaddress.sendKeys(fullemailaddress);

    }


    public void userentersPasswrod() {
        fullpassword = "Saibaba786!";
        password.sendKeys(fullpassword);

    }


    public void userclicksonDiscountscheckbox() {
        futureDiscountscheckbox.click();
    }

    public void userclicksonCreateButton() {
        createAccountButton.click();

    }

    public void userValidatesSignup() {

        Assert.assertEquals(fullname,nameDisplayed.getText());
    }


}