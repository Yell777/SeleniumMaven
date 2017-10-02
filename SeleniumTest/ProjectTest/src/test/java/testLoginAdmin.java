import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class testLoginAdmin extends TestBase {

    @Test
    public void testLogin ()  {
        driver.get("http://localhost/litecart/admin/");
        loginAdmin();
//        driver.findElement(By.cssSelector("li:nth-child(3)")).click();
//        driver.findElement(By.xpath("//div[@class='header']/a[@title='Home']")).click();
//        driver.findElement(By.xpath("//table[@class='dataTable']//i[@class='fa fa-file-text-o']")).click();

    }
    @Test
    public void testLoginMenuList ()  {
        driver.get("http://localhost/litecart/admin/");
        loginAdmin();
        List<WebElement> menulist = driver.findElements(By.xpath("//li[@id='app-']/a"));
        for (int i = 1; i <= menulist.size() ; i++) {
            driver.findElement(By.xpath("//ul[@id='box-apps-menu']/li" + "[" + i + "]")).click();
            if (isElementPresent(By.xpath("//ul[@class='docs']//a"))) {
                List<WebElement> subMenulist = driver.findElements(By.xpath("//ul[@class='docs']//a"));
                for (int j = 1; j <= subMenulist.size(); j++) {
                    driver.findElement(By.xpath("//ul[@class='docs']/li" + "[" + j + "]")).click();
                    Assert.assertTrue(isElementPresent(By.cssSelector("h1")));
                }
            }
            Assert.assertTrue(isElementPresent(By.cssSelector("h1")));

        }

    }


}