package TestBasket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by User on 27.10.2017.
 */
public class PageProduct extends Page {
    public PageProduct(WebDriver driver) {
        super(driver);
    }
    public boolean isPromotionalProduct() {
        try {
            driver.findElement(By.xpath("//div[@class='buy_now']//td[@class='options']"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void selectSize() {
        driver.findElement(By.xpath("//div[@class='buy_now']//td[@class='options']")).click();
        driver.findElement(By.xpath("//div[@class='buy_now']//td[@class='options']//option[@value='Small']")).click();
    }

    public void addProductToBasket() {
        driver.findElement(By.xpath("//button[@name='add_cart_product']")).click();

    }
    public WebElement waitBasketCounter(int i) {
        WebElement a = driver.findElement(By.className("quantity"));
        wait.until(ExpectedConditions.attributeContains(a, "textContent", "" + i));
        return a;
    }
    public String getTextContentCounter() {
        return driver.findElement(By.xpath("//div[@id='cart-wrapper']//span[@class='quantity']")).getAttribute("textContent");
    }

}
