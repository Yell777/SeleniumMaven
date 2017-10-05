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
//    public void testNameProduct () {
//        driver.get("http://localhost/litecart/en/");
//        WebElement duck = driver.findElement(By.xpath("//div[@id='box-campaigns']//li[@class='product column shadow hover-light']"));
//        String name = duck.findElement(By.xpath(".//div[@class='name']")).getText() ;
//        System.out.println(name);
//        duck.click();
//        String name2 = driver.findElement(By.xpath(".//div[@id='box-product']//h1[@class='title']")).getText();
//        System.out.println(name2);
//        Assert.assertTrue("Названия товаров , не совпадают" , name.equals(name2));
//    }

//    @Test
//    public void testPriceProduct () {
//        driver.get("http://localhost/litecart/en/");
//        WebElement duck = driver.findElement(By.xpath("//div[@id='box-campaigns']//li[@class='product column shadow hover-light']"));
//        String priceOld = duck.findElement(By.xpath(".//s[@class='regular-price']")).getText();
//        String priceNew = duck.findElement(By.xpath(".//strong[@class='campaign-price']")).getText();
//        duck.click();
//        String priceOld2 = driver.findElement(By.xpath(".//div[@id='box-product']//s[@class='regular-price']")).getText();
//        String priceNew2 = driver.findElement(By.xpath(".//div[@id='box-product']//strong[@class='campaign-price']")).getText();
//        Assert.assertTrue("Старые цены , не совпадают" , priceOld.equals(priceOld2));
//        Assert.assertTrue("Скидочные цены , не свопадают" , priceNew.equals(priceNew2));
//
//    }
    @Test
    public void testAtributeProduct () {
        String line = "line-through";
        String fontweight = "bold";
        driver.get("http://localhost/litecart/en/");
        WebElement duck = driver.findElement(By.xpath("//div[@id='box-campaigns']//li[@class='product column shadow hover-light']"));
        /*Проверка цены (зачеркнута ? )*/
        String linePriceOld = duck.findElement(By.xpath(".//s[@class='regular-price']")).getCssValue("text-decoration-line");
        System.out.println(linePriceOld);
        Assert.assertTrue("Цена , не зачеркнутая" , line.equals(linePriceOld));

        /*Проверка цвета старой цены  */
        String colorPriceOld = duck.findElement(By.xpath(".//s[@class='regular-price']")).getCssValue("color");
        System.out.println(colorPriceOld);
        if (colorPriceOld.length() == 18){
            String redColorOld = colorPriceOld.substring(4,7);
            String bluColorOld = colorPriceOld.substring(9,12);
            String greenColorOld = colorPriceOld.substring(14,17);
            Assert.assertTrue("Старая цена не серого цвета ", redColorOld.equals(bluColorOld)||bluColorOld.equals(greenColorOld));
        }
        String redColorOld = colorPriceOld.substring(5,8);
        String bluColorOld = colorPriceOld.substring(10,13);
        String greenColorOld = colorPriceOld.substring(15,18);
        Assert.assertTrue("Старая цена не серого цвета ", redColorOld.equals(bluColorOld)||bluColorOld.equals(greenColorOld));

        /*Проверка акционной цены  */
        String priceNewFont = duck.findElement(By.xpath(".//strong[@class='campaign-price']")).getCssValue("font-weight");
        Assert.assertTrue("Цена , не жирная" , fontweight.equals(priceNewFont));

          /*Проверка цвета акционной цены  */
        String colorPriceNew = duck.findElement(By.xpath(".//strong[@class='campaign-price']")).getCssValue("color");
        System.out.println(colorPriceNew);
//        if (colorPriceOld.length() == 18){
//            String redColorNew = colorPriceOld.substring(4,7);
//            String bluColorNew = colorPriceOld.substring(9,12);
//            String greenColorNew = colorPriceOld.substring(14,17);
//            Assert.assertTrue("Старая цена не серого цвета ", redColorOld.equals(bluColorOld)||bluColorOld.equals(greenColorOld));
//        }
//        String redColorNew = colorPriceOld.substring(5,8);
//        String bluColorNew = colorPriceOld.substring(10,13);
//        String greenColorNew = colorPriceOld.substring(15,18);
//        Assert.assertTrue("Старая цена не серого цвета ", redColorOld.equals(bluColorOld)||bluColorOld.equals(greenColorOld));









    }

}

