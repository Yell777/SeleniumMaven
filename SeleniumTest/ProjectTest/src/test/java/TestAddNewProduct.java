import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TestAddNewProduct extends TestBase {


    @Test
    public void testAddNewProduct() {
        int num = (int)(Math.random()*1000);
        loginAdmin();
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.xpath("//ul[@id='box-apps-menu']/li[2]")).click();
        driver.findElement(By.xpath("//ul[@id='box-apps-menu']/li[@class='selected']//li[@id='doc-catalog']")).click();
        driver.findElement(By.xpath("//div[@style='float: right;']/a[2]")).click();
        driver.findElement(By.xpath("//div[@id='tab-general']//label/input[@value='1']")).click();
        driver.findElement(By.xpath("//input[@name='name[en]']")).sendKeys("TestProduct" + num);
        driver.findElement(By.xpath("//input[@name='code']")).sendKeys("123" + num);
        driver.findElement(By.xpath("//div[@class='input-wrapper']//tr[2]//input[@name='categories[]']")).click();
        driver.findElement(By.xpath("//div[@class='input-wrapper']//input[@value='1-2']")).click();
        WebElement list= driver.findElement(By.xpath("//div[@id='tab-general']//select[@name='default_category_id']"));
        Select sel = new Select(list);
        sel.selectByValue("1");
        driver.findElement(By.xpath("//div[@class='input-wrapper']//input[@value='1-2']")).click();
        driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys("2.0");
        WebElement list2= driver.findElement(By.xpath("//select[@name='sold_out_status_id']"));
        Select sel2 = new Select(list2);
        sel.selectByValue("2");
         driver.findElement(By.xpath("//input[@type='file']")).sendKeys("");





    }
}
