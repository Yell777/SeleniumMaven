import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;

import java.util.List;

/**
 * Created by User on 20.10.2017.
 */
public class testLog extends TestBase {
    @Test
    public void testLogBrowser (){
        loginAdmin();
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog");
        driver.findElement(By.xpath("//a[text()='Rubber Ducks'] ")).click();
        List <WebElement> list  = driver.findElements(By.cssSelector("table.dataTable tr td:nth-child(3) a[href*='product']"));
        for (int i = 0; i <list.size() ; i++) {
           list = driver.findElements(By.cssSelector("table.dataTable tr td:nth-child(3) a[href*='product']"));
                list.get(i).click();
                List<LogEntry> listLog = driver.manage().logs().get("browser").getAll();
                if (listLog.size() > 0) {
                    for (int j = 0; j < listLog.size(); j++) {
                        System.out.println(listLog.get(i));
                    }
                } else {
                    System.out.println("Логов нет " + (i + 1)  + " - номер страницы продукта");
                }

            driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");

        }


    }

}
