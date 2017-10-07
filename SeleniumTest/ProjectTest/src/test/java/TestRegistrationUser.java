import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TestRegistrationUser extends TestBase {

    @Test
    public void testRegistration () {
        int num = (int)(Math.random()*1000);
        String email = "Test" + num+ "@mail.ru";
        String phone = "+71234567" + num;
        driver.get("http://localhost/litecart/en/");

        /*Ввожу данные для регистрации*/
        driver.findElement(By.xpath("//form[@name='login_form']//td/a")).click();
        driver.findElement(By.xpath("//input[@name='tax_id']")).sendKeys("123" + num);
        driver.findElement(By.xpath("//input[@name='company']")).sendKeys("Company" + num);
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("TestName" + num);
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("TestLastName" + num);
        driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("TestAddress" + num);
        driver.findElement(By.xpath("//input[@name='address2']")).sendKeys("Address" + num);
        driver.findElement(By.xpath("//input[@name='postcode']")).sendKeys("12" + num);
        driver.findElement(By.xpath("//input[@name='city']")).sendKeys("TestCity" + num);
       WebElement list1= driver.findElement(By.xpath("//form[@name='customer_form']//td/select[@name='country_code']"));
       WebElement list2= driver.findElement(By.xpath("//form[@name='customer_form']//select[@name='zone_code']"));
        Select sel = new Select(list1);
        Select sel2 = new Select(list2);
        sel.selectByValue("US");
        sel2.selectByValue("AK");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(phone);
        String check = driver.findElement(By.xpath("//input[@type='checkbox']")).getAttribute("checked");
        if (check.equals("null")) {
            driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        }
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Qwerty" + num);
        driver.findElement(By.xpath("//input[@name='confirmed_password']")).sendKeys("Qwerty" + num);
        driver.findElement(By.xpath("//button[@name='create_account']")).click();
        driver.findElement(By.xpath("//div[@id='box-account']//li[4]/a")).click();

        /*Захожу под новым логином*/
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Qwerty" + num);
        driver.findElement(By.xpath("//input[@name='remember_me']")).click();
        driver.findElement(By.xpath("//button[@name='login']")).click();
        driver.findElement(By.xpath("//div[@id='box-account']//li[4]/a")).click();









    }


}
