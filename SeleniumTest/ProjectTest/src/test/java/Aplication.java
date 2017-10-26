import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by User on 26.10.2017.
 */
public class Aplication  {

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
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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

    public ExpectedCondition<String> thereIsWindowOtherThan(final Set<String> oldWindow){
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

        //--расширенный лог баузера хром
//        DesiredCapabilities cap = DesiredCapabilities.chrome();
//        LoggingPreferences logPrefs = new LoggingPreferences();
//        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
//        cap.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        ///
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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

    public void deleteAtBasket() {
        driver.get("http://localhost/litecart/en/");
        driver.findElement(By.xpath("//div[@id='cart']/a[@class='link']")).click();
        List<WebElement> listPro = driver.findElements(By.xpath("//table[@class='dataTable rounded-corners']//td[@class='item']"));
        int num = listPro.size();
        for (int i = 0; i < num; i++) {
            driver.findElement(By.xpath("//button[@name='remove_cart_item']")).click();
            wait.until(ExpectedConditions.stalenessOf(listPro.get(i)));
            if (isElementPresent(By.xpath("//div[@id='checkout-cart-wrapper']//em"))){
              System.out.println("Все товары удалены");
                 }
         }
    }

    public void addToBasket() {
        for (int i = 1; i <= 3; i++) {
            List<WebElement> list = driver.findElements(By.xpath("//div[@id='box-most-popular']//ul/li"));
            list.get(i).click();
            if (isElementPresent(By.xpath("//div[@class='buy_now']//td[@class='options']"))) {
                driver.findElement(By.xpath("//div[@class='buy_now']//td[@class='options']")).click();
                driver.findElement(By.xpath("//div[@class='buy_now']//td[@class='options']//option[@value='Small']")).click();
            }
            driver.findElement(By.xpath("//button[@name='add_cart_product']")).click();
            WebElement a = driver.findElement(By.className("quantity"));
            wait.until(ExpectedConditions.attributeContains(a, "textContent", "" + i));
            String s = driver.findElement(By.xpath("//div[@id='cart-wrapper']//span[@class='quantity']")).getAttribute("textContent");
            Assert.assertTrue("Счетчик не обновлен", Integer.parseInt(s) == i);
            driver.get("http://localhost/litecart/en/");
        }
    }
}
