import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.Nullable;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class TestBase {

//    public static ThreadLocal<Aplication> tlApp = new ThreadLocal<>();
    public Aplication app;

    @Before
    public void start() {
//        if (tlApp.get() != null) {
//            app = tlApp.get();
//            return;
//        }

        app = new Aplication();
//        tlApp.set(app);

//        Runtime.getRuntime().addShutdownHook(
//                new Thread(() -> { app.quit(); app = null; }));
    }
}