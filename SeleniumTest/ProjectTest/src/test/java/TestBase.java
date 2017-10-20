import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.Nullable;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver driver;
    public WebDriverWait wait;

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    boolean areElementsPresent(WebDriver driver, By locator) {
        try {
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
            return driver.findElements(locator).size() > 0;
        }finally {
            driver.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
        }
    }

    boolean areElementsNotPresent(WebDriver driver, By locator) {
        try {
            driver.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
           return driver.findElements(locator).size() > 0;
        }finally {
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        }


    }

    public ExpectedCondition<String>thereIsWindowOtherThan(final Set<String> oldWindow){
        return new ExpectedCondition<String>() {
            @Nullable
            public String apply(@Nullable WebDriver webDriver) {
                Set<String> handles = driver.getWindowHandles();
                handles.removeAll(oldWindow);
                return handles.size()> 0 ? handles.iterator().next():null;
            }
        };
    }

    @Before
    public void start() {
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("unexpectedAlertBehaviour", "dismiss");
        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println(((HasCapabilities) driver).getCapabilities());
//         DesiredCapabilities cap = new DesiredCapabilities();
//         cap.setCapability(FirefoxDriver.MARIONETTE,true);
//      driver = new FirefoxDriver(new FirefoxBinary(new File("C:\\Program Files\\Nightly\\firefox.exe")),new FirefoxProfile(),cap);
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("start-maximized");
//          driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 10);
    }

    @After
    public void stop() {
        driver.quit();
        wait = null;

    }

    public void loginAdmin() {
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }


}