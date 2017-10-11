import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by User on 10.10.2017.
 */
public class AddProductToBasket extends TestBase {

    @Test
    public void addToCart () {
        wait = new WebDriverWait(driver,30);
        driver.get("http://localhost/litecart/en/");
        WebElement a ;
        List<WebElement> list = driver.findElements(By.xpath("//div[@id='box-most-popular']//ul/li"));
        for (int i = 0; i < 3 ; i++) {
            list = driver.findElements(By.xpath("//div[@id='box-most-popular']//ul/li"));
            list.get(i).click();
            driver.findElement(By.xpath("//button[@name='add_cart_product']")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='cart-wrapper']//span[@class='quantity']")));
            String s = driver.findElement(By.xpath("//div[@id='cart-wrapper']//span[@class='quantity']")).getAttribute("textContent");
            Assert.assertTrue("Счетчик не обновлен",Integer.parseInt(s)== i+1);



        }


    }

}
