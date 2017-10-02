import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestContrList extends TestBase {

    @Test
    public void testCountryList () {
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        loginAdmin();
        WebElement list = driver.findElement(By.className("dataTable"));
        List<WebElement> coulist = list.findElements(By.xpath("//tr[@class='row']"));
        ArrayList<String> listCou = new ArrayList<String>();
        for (int i = 0; i < coulist.size() ; i++) {
            listCou.add(coulist.get(i).findElement(By.tagName("a")).getAttribute("textContent"));
        }
        Collections.sort(listCou);
        for (int i = 0; i < coulist.size() ; i++) {
            String s = coulist.get(i).findElement(By.tagName("a")).getAttribute("textContent");
            String num = coulist.get(i).findElement(By.xpath("//td[6]")).getText();
            System.out.println(num);


            }


        }








}
