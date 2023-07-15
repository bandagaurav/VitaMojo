package step_definations;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Hooks
{
public static WebDriver driver;
@Before(order=0)
/**
* Delete all cookies at the start of each scenario to avoid
* shared state between tests
*/
public void openBrowser() throws MalformedURLException {

WebDriverManager.chromedriver().setup();
DesiredCapabilities capabilities = DesiredCapabilities.chrome();
capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);

ChromeOptions chromeOptions = new ChromeOptions();
chromeOptions.addArguments("--disable-gpu");
//WebDriverManager.chromedriver().forceDownload().setup(); //webDriver = new ChromeDriver(chromeOptions);
    WebDriverManager.chromedriver().setup();
driver = new ChromeDriver(chromeOptions); driver.manage().window().maximize();
driver.manage().deleteAllCookies();
    driver.get("https://fego.vmos-demo.com");
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().window().maximize();
driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
driver.manage().timeouts().setScriptTimeout(40, TimeUnit.SECONDS);


}
@After(order=0)
public void quit() throws Exception{
driver.findElement(By.xpath("//*[contains(@class,'css-xooaem')]")).click();
driver.findElement(By.xpath("//button[text()='Sign Out']")).click();
driver.quit();

}



@After(order=1)

public void embedScreenshot(Scenario scenario) {

if(scenario.isFailed()) {
try {
scenario.write("Current Page URL is Failed" + driver.getCurrentUrl());

byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
scenario.embed(screenshot, "image/png");
}
catch (WebDriverException somePlatformsDontSupportScreenshots) {
System.err.println(somePlatformsDontSupportScreenshots.getMessage());
}
}else{
try {
scenario.write("Current Page URL is Passed" + driver.getCurrentUrl());

byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
scenario.embed(screenshot, "image/png");
}
catch (WebDriverException somePlatformsDontSupportScreenshots) {
System.err.println(somePlatformsDontSupportScreenshots.getMessage());
}



}



}

}

