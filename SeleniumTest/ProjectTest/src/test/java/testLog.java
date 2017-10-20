import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

/**
 * Created by User on 20.10.2017.
 */
public class testLog extends TestBase {
    @Test
    public void testLogBrowser (){

        loginAdmin();
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog");
        driver.findElement(By.xpath("//a[text()='Rubber Ducks'] ")).click();
        


    }

}
