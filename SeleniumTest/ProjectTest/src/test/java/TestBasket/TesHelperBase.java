package TestBasket;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.Nullable;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by User on 27.10.2017.
 */
public class TesHelperBase {
    public Application app;


    @Before
    public void start() {
        app = new Application();

    }


}
