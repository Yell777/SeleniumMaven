package TestBasket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by User on 27.10.2017.
 */
public class MainPageProduct extends Page {

    public MainPageProduct(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getListOfProduct() {
        return driver.findElements(By.xpath("//div[@id='box-most-popular']//ul/li"));
    }

    public void open() {
        driver.get("http://localhost/litecart/en/");
    }
    public void goToBasket() {
        driver.findElement(By.xpath("//div[@id='cart']/a[@class='link']")).click();
    }
}
