package TestBasket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by User on 27.10.2017.
 */
public class BasketPage extends Page{
    public BasketPage(WebDriver driver) {
        super(driver);
    }
    public List<WebElement> getListOfBasketProduct() {
        return driver.findElements(By.xpath("//table[@class='dataTable rounded-corners']//td[@class='item']"));
    }
    public void deleteProductOfBasket() {
        driver.findElement(By.xpath("//button[@name='remove_cart_item']")).click();
    }
    public boolean isProductDelte() {
        try {
            driver.findElement(By.xpath("//div[@id='checkout-cart-wrapper']//em"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
