import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by User on 04.10.2017.
 */
public class TestPriceProduct extends TestBase {
    @Test
    public void testNameProduct () {
        driver.get("http://localhost/litecart/en/");
        WebElement duck = driver.findElement(By.xpath("//div[@id='box-campaigns']//li[@class='product column shadow hover-light']"));
        String name = duck.findElement(By.xpath(".//div[@class='name']")).getText() ;
        duck.click();
        String name2 = driver.findElement(By.xpath(".//div[@id='box-product']//h1[@class='title']")).getText();
        Assert.assertTrue("Названия товаров , не совпадают" , name.equals(name2));
    }

    @Test
    public void testPriceProduct () {
        driver.get("http://localhost/litecart/en/");
        WebElement duck = driver.findElement(By.xpath("//div[@id='box-campaigns']//li[@class='product column shadow hover-light']"));
        String priceOld = duck.findElement(By.xpath(".//s[@class='regular-price']")).getText();
        String priceNew = duck.findElement(By.xpath(".//strong[@class='campaign-price']")).getText();
        duck.click();
        String priceOld2 = driver.findElement(By.xpath(".//div[@id='box-product']//s[@class='regular-price']")).getText();
        String priceNew2 = driver.findElement(By.xpath(".//div[@id='box-product']//strong[@class='campaign-price']")).getText();
        Assert.assertTrue("Старые цены , не совпадают" , priceOld.equals(priceOld2));
        Assert.assertTrue("Скидочные цены , не свопадают" , priceNew.equals(priceNew2));

    }
    @Test
    public void testAtributeProductMainPage () {
        String line = "line-through";
        String fontweight = "bold";
        String fontweightFFIE = "900";
        driver.get("http://localhost/litecart/en/");
        WebElement duck = driver.findElement(By.xpath("//div[@id='box-campaigns']//li[@class='product column shadow hover-light']"));
        /*Проверка цены (зачеркнута ? )*/
        String linePriceOld = duck.findElement(By.xpath(".//s[@class='regular-price']")).getCssValue("text-decoration-line");
        if(linePriceOld.equals("")){
            linePriceOld = duck.findElement(By.xpath(".//s[@class='regular-price']")).getCssValue("text-decoration");
        }
        Assert.assertTrue("Цена , не зачеркнутая" , line.equals(linePriceOld));

        /*Проверка цвета старой цены  */
        String colorPriceOld = duck.findElement(By.xpath(".//s[@class='regular-price']")).getCssValue("color");
        if (colorPriceOld.length() == 18){
            String redColorOld = colorPriceOld.substring(4,7);
            String bluColorOld = colorPriceOld.substring(9,12);
            String greenColorOld = colorPriceOld.substring(14,17);
            Assert.assertTrue("Старая цена не серого цвета ", redColorOld.equals(bluColorOld)||bluColorOld.equals(greenColorOld));
        }
        if (colorPriceOld.length() == 22) {
            String redColorOld = colorPriceOld.substring(5, 8);
            String bluColorOld = colorPriceOld.substring(10, 13);
            String greenColorOld = colorPriceOld.substring(15, 18);
            Assert.assertTrue("Старая цена не серого цвета ", redColorOld.equals(bluColorOld) || bluColorOld.equals(greenColorOld));
        }
        /*Проверка акционной цены  */
        String priceNewFont = duck.findElement(By.xpath(".//strong[@class='campaign-price']")).getCssValue("font-weight");
        Assert.assertTrue("Цена , не жирная" , fontweight.equals(priceNewFont)|| fontweightFFIE.equals(priceNewFont));

          /*Проверка цвета акционной цены  */
        String colorPriceNew = duck.findElement(By.xpath(".//strong[@class='campaign-price']")).getCssValue("color");
        if (colorPriceNew.length() == 14){
            String redColorNew = colorPriceNew.substring(4,7);
            String bluColorNew = colorPriceNew.substring(9,10);
            String greenColorNew = colorPriceNew.substring(12,13);
            Assert.assertTrue("Старая цена не красного цвета ", redColorNew.equals("204")&&bluColorNew.equals("0")&& greenColorNew.equals("0"));
        }
        if(colorPriceNew.length() == 18) {
            String redColorNew = colorPriceNew.substring(5, 8);
            String bluColorNew = colorPriceNew.substring(10, 11);
            String greenColorNew = colorPriceNew.substring(13, 14);
            Assert.assertTrue("Старая цена не красного цвета ", redColorNew.equals("204") && bluColorNew.equals("0") && greenColorNew.equals("0"));
        }
          /*Проверка размера цен  */
         String sizePriceold = duck.findElement(By.xpath(".//s[@class='regular-price']")).getCssValue("font-size");
         sizePriceold = sizePriceold.substring(0,sizePriceold.length()-2);
         String sizePriceNew = duck.findElement(By.xpath(".//strong[@class='campaign-price']")).getCssValue("font-size");
         sizePriceNew = sizePriceNew.substring(0,sizePriceNew.length()-2);
         Assert.assertTrue("Акционная цена , не больше обычной",Double.parseDouble(sizePriceNew)>Double.parseDouble(sizePriceold));
    }
    @Test
    public void testAtributePageProduct () {
        String line = "line-through";
        String fontweight = "bold";
        String fontweightFFIE = "700";
        driver.get("http://localhost/litecart/en/rubber-ducks-c-1/subcategory-c-2/yellow-duck-p-1");
        WebElement duck = driver.findElement(By.xpath("//div[@class='information']//div[@class='price-wrapper']"));

        /*Проверка цены (зачеркнута ? )*/
        String linePriceOld = duck.findElement(By.xpath(".//s[@class='regular-price']")).getCssValue("text-decoration-line");
        if(linePriceOld.equals("")){
            linePriceOld = duck.findElement(By.xpath(".//s[@class='regular-price']")).getCssValue("text-decoration");
        }
        Assert.assertTrue("Цена , не зачеркнутая" , line.equals(linePriceOld));
         /*Проверка цвета старой цены  */
        String colorPriceOld = duck.findElement(By.xpath(".//s[@class='regular-price']")).getCssValue("color");
        if (colorPriceOld.length() == 18){
            String redColorOld = colorPriceOld.substring(4,7);
            String bluColorOld = colorPriceOld.substring(9,12);
            String greenColorOld = colorPriceOld.substring(14,17);
            Assert.assertTrue("Старая цена не серого цвета ", redColorOld.equals(bluColorOld)||bluColorOld.equals(greenColorOld));
        }
        if (colorPriceOld.length() == 22) {
            String redColorOld = colorPriceOld.substring(5, 8);
            String bluColorOld = colorPriceOld.substring(10, 13);
            String greenColorOld = colorPriceOld.substring(15, 18);
            Assert.assertTrue("Старая цена не серого цвета ", redColorOld.equals(bluColorOld) || bluColorOld.equals(greenColorOld));
        }
           /*Проверка акционной цены  */
            String priceNewFont = duck.findElement(By.xpath(".//strong[@class='campaign-price']")).getCssValue("font-weight");
            Assert.assertTrue("Цена , не жирная" , fontweight.equals(priceNewFont)|| fontweightFFIE.equals(priceNewFont));

           /*Проверка цвета акционной цены  */
        String colorPriceNew = duck.findElement(By.xpath(".//strong[@class='campaign-price']")).getCssValue("color");
        if (colorPriceNew.length() == 14){
            String redColorNew = colorPriceNew.substring(4,7);
            String bluColorNew = colorPriceNew.substring(9,10);
            String greenColorNew = colorPriceNew.substring(12,13);
            Assert.assertTrue("Старая цена не красного цвета ", redColorNew.equals("204")&&bluColorNew.equals("0")&& greenColorNew.equals("0"));
        }
        if(colorPriceNew.length() == 18) {
            String redColorNew = colorPriceNew.substring(5, 8);
            String bluColorNew = colorPriceNew.substring(10, 11);
            String greenColorNew = colorPriceNew.substring(13, 14);
            Assert.assertTrue("Старая цена не красного цвета ", redColorNew.equals("204") && bluColorNew.equals("0") && greenColorNew.equals("0"));
        }
           /*Проверка размера цен  */
        String sizePriceold = duck.findElement(By.xpath(".//s[@class='regular-price']")).getCssValue("font-size");
        sizePriceold = sizePriceold.substring(0,sizePriceold.length()-2);
        String sizePriceNew = duck.findElement(By.xpath(".//strong[@class='campaign-price']")).getCssValue("font-size");
        sizePriceNew = sizePriceNew.substring(0,sizePriceNew.length()-2);
        Assert.assertTrue("Акционная цена , не больше обычной",Double.parseDouble(sizePriceNew)>Double.parseDouble(sizePriceold));
    }


}

