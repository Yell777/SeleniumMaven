import org.apache.xpath.SourceTree;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

/**
 * Created by User on 13.10.2017.
 */
public class testLinksWindow extends TestBase {


    @Test
    public void testNewwindows () {

        wait = new WebDriverWait(driver, 30);
        String originalWindow = driver.getWindowHandle();
        Set<String> exWindow = driver.getWindowHandles() ;
        String newWindow ;
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        loginAdmin();
        driver.findElement(By.xpath("//ul[@id='box-apps-menu']/li[3]")).click();
        driver.findElement(By.xpath("//a[@class='button']")).click();
        List<WebElement> list = driver.findElements(By.xpath("//i[@class='fa fa-external-link']"));
        for (int i = 0; i < list.size() ; i++) {
            list.get(i).click();
            newWindow = wait.until(thereIsWindowOtherThan(exWindow));
            driver.switchTo().window(newWindow);
            //это доп проверка , хоть она и не нужна =))
            if (isElementPresent(By.xpath("//h1"))){
                System.out.println("Страница открылась в новом окне");
            }
            driver.close();
            driver.switchTo().window(originalWindow);
        }
        driver.quit();


    }

}
