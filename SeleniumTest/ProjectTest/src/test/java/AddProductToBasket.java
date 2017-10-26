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
        app.addToBasket();
        app.deleteAtBasket();
    }

}
