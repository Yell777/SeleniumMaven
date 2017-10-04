import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class testListDuckStick extends TestBase {

    @Test
public void testSticker () {
    driver.get("http://localhost/litecart/en/");
    List<WebElement> duckList = driver.findElements(By.cssSelector("a.link "));
    for (int i = 0; i < duckList.size() ; i++) {
        try {
            duckList.get(i).findElement(By.cssSelector("div[class^=sticker]"));
        }catch (Exception ex){
            System.out.println("Эелемент не найден ");
        }
//            Assert.assertTrue(isElementPresent(By.cssSelector("[class^=stick]")));

    }

}

}