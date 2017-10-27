package TestBasket;

import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
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
 * Created by User on 27.10.2017.
 */
public class Application {

    private WebDriver driver;
    private WebDriverWait wait;
    private MainPageProduct mainPageProduct;
    private PageProduct pageProduct;
    private BasketPage basketPage;

    public Application() {
        driver = new ChromeDriver();
        mainPageProduct = new MainPageProduct(driver);
        pageProduct = new PageProduct(driver);
        basketPage = new BasketPage(driver);
        wait = new WebDriverWait(driver, 10);
    }

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
        } finally {
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        }
    }

    boolean areElementsNotPresent(WebDriver driver, By locator) {
        try {
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            return driver.findElements(locator).size() > 0;
        } finally {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }


    }

    public ExpectedCondition<String> thereIsWindowOtherThan(final Set<String> oldWindow) {
        return new ExpectedCondition<String>() {
            @Nullable
            public String apply(@Nullable WebDriver webDriver) {
                Set<String> handles = driver.getWindowHandles();
                handles.removeAll(oldWindow);
                return handles.size() > 0 ? handles.iterator().next() : null;
            }
        };
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
        mainPageProduct.open();
        mainPageProduct.goToBasket();
        List<WebElement> listPro = basketPage.getListOfBasketProduct();
        int num = listPro.size();
        for (int i = 0; i < num; i++) {
            basketPage.deleteProductOfBasket();
            wait.until(ExpectedConditions.stalenessOf(listPro.get(i)));
            if (basketPage.isProductDelte()){
                System.out.println("Все товары удалены");
            }
        }
    }

   

    public void addToBasket() {
        mainPageProduct.open();
        for (int i = 1; i <= 3; i++) {
            List<WebElement> list = mainPageProduct.getListOfProduct();
            list.get(i).click();
            if (pageProduct.isPromotionalProduct()) {
                pageProduct.selectSize();
            }
            pageProduct.addProductToBasket();
            WebElement a = pageProduct.waitBasketCounter(i);
            String s = pageProduct.getTextContentCounter();
            Assert.assertTrue("Счетчик не обновлен", Integer.parseInt(s) == i);
            mainPageProduct.open();
        }
    }



}
