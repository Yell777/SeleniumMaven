import org.apache.xpath.SourceTree;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestContrList extends TestBase {

    @Test
    public void testCountryList() {
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        loginAdmin();
        WebElement list = driver.findElement(By.className("dataTable"));
        List<WebElement> coulist = list.findElements(By.xpath("//tr[@class='row']"));
        ArrayList<String> listCouSort = new ArrayList<String>();
        for (int i = 0; i < coulist.size(); i++) {
            listCouSort.add(coulist.get(i).findElement(By.tagName("a")).getAttribute("textContent"));
        }
        Collections.sort(listCouSort);

//        for (int i = 0; i < coulist.size(); i++) {
//            String s = coulist.get(i).findElement(By.tagName("a")).getAttribute("textContent");
//            try {
//                listCouSort.get(i).equals(s);
//            } catch (Exception ex) {
//                System.out.println("Cписок не в алфавитном порядке");
//                break;
//            }
//        }
        listCouSort.clear();
        for (int i = 0; i < coulist.size(); i++) {
            String num = coulist.get(i).findElement(By.xpath("./td[6]")).getAttribute("textContent");
            if (!num.equals("0")){
                coulist.get(i).findElement(By.xpath("./a")).click();
                List<WebElement> sublist = driver.findElements(By.xpath("//table[@id='table-zones']//tr"));
                for (int j = 0; j < coulist.size(); j++) {
                    listCouSort.add(coulist.get(j).findElement(By.xpath("./td[3]")).getAttribute("textContent"));
                }
            }
        }

    }
}
