import org.apache.xpath.SourceTree;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by User on 10.10.2017.
 */
public class AddProductToBasket extends TestBase  {

    @Test
    public void testBasket () {
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
       @Test
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

}
