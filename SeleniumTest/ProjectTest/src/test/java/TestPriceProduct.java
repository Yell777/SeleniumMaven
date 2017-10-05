import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by User on 04.10.2017.
 */
public class TestPriceProduct extends TestBase {
//    @Test
//    public void testNameSticker () {
//        driver.get("http://localhost/litecart/en/");
//        WebElement duck = driver.findElement(By.xpath("//div[@id='box-campaigns']//li[@class='product column shadow hover-light']"));
//        String name = duck.findElement(By.xpath(".//div[@class='name']")).getText() ;
//        System.out.println(name);
//        duck.click();
//        String name2 = driver.findElement(By.xpath(".//div[@id='box-product']//h1[@class='title']")).getText();
//        System.out.println(name2);
//        Assert.assertTrue("Названия не равны" , name.equals(name2));
//    }

//    @Test
//    public void testPriceSticker () {
//        driver.get("http://localhost/litecart/en/");
//        WebElement duck = driver.findElement(By.xpath("//div[@id='box-campaigns']//li[@class='product column shadow hover-light']"));
//        String priceOld = duck.findElement(By.xpath(".//s[@class='regular-price']")).getText();
//        String priceNew = duck.findElement(By.xpath(".//strong[@class='campaign-price']")).getText();
//        duck.click();
//        String priceOld2 = driver.findElement(By.xpath(".//div[@id='box-product']//s[@class='regular-price']")).getText();
//        String priceNew2 = driver.findElement(By.xpath(".//div[@id='box-product']//strong[@class='campaign-price']")).getText();
//        Assert.assertTrue("Старые цены , не равны" , priceOld.equals(priceOld2));
//        Assert.assertTrue("Новые цены , не равны" , priceNew.equals(priceNew2));
//
//    }
    @Test
    public void testColorSticker () {
        driver.get("http://localhost/litecart/en/");
        WebElement duck = driver.findElement(By.xpath("//div[@id='box-campaigns']//li[@class='product column shadow hover-light']"));
        

    }

}

