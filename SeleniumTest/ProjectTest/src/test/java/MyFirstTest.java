import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by User on 02.10.2017.
 */
public class MyFirstTest {

    private WebDriver driver;
    private WebDriverWait wait;
    @Before
    public void start () throws MalformedURLException {
        DesiredCapabilities capability = DesiredCapabilities.firefox();
        capability.setBrowserName("internet explorer");
        capability.setAcceptInsecureCerts(false);
        driver = new RemoteWebDriver(new URL("http://192.168.5.22:4444/wd/hub"),capability);
        wait = new WebDriverWait(driver,10);
    }
    @Test
    public void MyFristTest (){
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("webdriver", Keys.ENTER );

    }
    @After
    public void stop (){
        driver.quit();
        wait = null;

    }



}