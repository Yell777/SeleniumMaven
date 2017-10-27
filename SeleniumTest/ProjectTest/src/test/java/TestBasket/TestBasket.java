package TestBasket;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * Created by User on 27.10.2017.
 */
public class TestBasket extends TesHelperBase {
    @Test
    public void TestBasket() {
        app.addToBasket();
        app.deleteAtBasket();
    }





}
