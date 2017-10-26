import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestAddNewProduct extends TestBase {


    @Test
    public void testAddNewProduct() {
        /*Получаю дату для полей  */
        Date day = new Date();
        DateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String startDate = DateFormat.format(day);
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 10);
        Date tenDaysLater = calendar.getTime();
        String endDate = DateFormat.format(tenDaysLater);

        int num = (int)(Math.random()*1000);
        app.loginAdmin();
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");

         /*Заполняю первый таб */
        driver.findElement(By.xpath("//ul[@id='box-apps-menu']/li[2]")).click();
        driver.findElement(By.xpath("//ul[@id='box-apps-menu']/li[@class='selected']//li[@id='doc-catalog']")).click();
        driver.findElement(By.xpath("//div[@style='float: right;']/a[2]")).click();
        driver.findElement(By.xpath("//div[@id='tab-general']//label/input[@value='1']")).click();
        driver.findElement(By.xpath("//input[@name='name[en]']")).sendKeys("TestProduct" + num);
        driver.findElement(By.xpath("//input[@name='code']")).sendKeys("123" + num);
        driver.findElement(By.xpath("//div[@class='input-wrapper']//tr[2]//input[@name='categories[]']")).click();
        WebElement list= driver.findElement(By.xpath("//div[@id='tab-general']//select[@name='default_category_id']"));
        Select sel = new Select(list);
        sel.selectByValue("1");
        driver.findElement(By.xpath("//div[@class='input-wrapper']//input[@value='1-1']")).click();
        driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys("2");
        WebElement list2= driver.findElement(By.xpath("//select[@name='sold_out_status_id']"));
        Select sel2 = new Select(list2);
        sel2.selectByValue("2");
        File file = new File("src/Pictures/25192-759.jpg");
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(file.getAbsolutePath());
        driver.findElement(By.xpath("//input[@name='date_valid_from']")).sendKeys(startDate);
        driver.findElement(By.xpath("//input[@name='date_valid_to']")).sendKeys(endDate);

         /*Заполняю таб Inforamtion */
         driver.findElement(By.xpath("//div[@class='tabs']/ul/li[2]")).click();
         list= driver.findElement(By.xpath("//select[@name='manufacturer_id']"));
         sel = new Select(list);
         sel.selectByValue("1");
        driver.findElement(By.xpath("//input[@name='keywords']")).sendKeys("Test");
        driver.findElement(By.xpath("//input[@name='short_description[en]']")).sendKeys("TestTest");
        driver.findElement(By.xpath("//div[@class='trumbowyg-editor']")).sendKeys("Тестовые описание");
        driver.findElement(By.xpath("//input[@name='head_title[en]']")).sendKeys("TestTest");
        driver.findElement(By.xpath("//input[@name='meta_description[en]']")).sendKeys("TestTest");

         /*Заполняю таб Prices*/
        driver.findElement(By.xpath("//div[@class='tabs']/ul/li[4]")).click();
        driver.findElement(By.xpath("//input[@name='purchase_price']")).sendKeys("100");
        list2 = driver.findElement(By.xpath("//select[@name='purchase_price_currency_code']"));
        sel2 = new Select(list2);
        sel2.selectByValue("USD");
        driver.findElement(By.xpath("//input[@name='prices[USD]']")).sendKeys("200");
        driver.findElement(By.xpath("//input[@name='prices[EUR]']")).sendKeys("200");
        driver.findElement(By.xpath("//button[@name='save']")).click();

         /*Проверка наличия товара*/
        try{
            driver.findElement(By.xpath("//*[text()='TestProduct" + num + "']"));
        }catch (Exception e){
            System.out.println("Элемент не найден");
        }



















    }
}
