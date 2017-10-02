import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by User on 02.10.2017.
 */
public class MyFirstTest {

    private WebDriver driver;
    private WebDriverWait wait;
    @Before
    public void start (){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,10);
    }
    @Test
    public void MyFristTest (){
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("webdriver", Keys.ENTER );

    }
    @After
    public void stop (){
        driver.quit();
        wait = null;

    }



}