import org.apache.xpath.SourceTree;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class TestContrList extends TestBase {

    @Test
    public void testCountryList() {
        loginAdmin();
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        List<WebElement> coulist = driver.findElements(By.xpath(".//table[@class='dataTable']//tr[@class='row']"));
        ArrayList<String> listCouSort = new ArrayList<String>();
        ArrayList<String> listCouOrg = new ArrayList<String>();
        for (int i = 0; i < coulist.size(); i++) {
            listCouSort.add(coulist.get(i).findElement(By.tagName("a")).getAttribute("textContent"));
        }
        listCouOrg.addAll(listCouSort);
        Collections.sort(listCouSort);
        Assert.assertTrue("Список не в алфавитном порядке" , listCouSort.equals(listCouOrg) );
        listCouSort.clear();
        listCouOrg.clear();
        for (int i = 0; i < coulist.size(); i++) {
            coulist = driver.findElements(By.xpath(".//table[@class='dataTable']//tr[@class='row']"));
            String num = coulist.get(i).findElement(By.xpath("./td[6]")).getAttribute("textContent");
            if (!num.equals("0")) {
                coulist.get(i).findElement(By.xpath(".//a")).click();
                List<WebElement> sublist = driver.findElements(By.xpath("//table[@id='table-zones']//tr//input[contains(@name,'][name]')]"));
                for (int j = 0; j < sublist.size(); j++) {
                    listCouSort.add(sublist.get(j).getAttribute("value"));
                }
                listCouOrg.addAll(listCouSort);
                Collections.sort(listCouSort);
                Assert.assertTrue("Список не в алфавитном порядке" , listCouSort.equals(listCouOrg) );
                driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
                listCouSort.clear();
                listCouOrg.clear();

            }
        }
    }


    @Test
    public void testCountryListZone() {
        loginAdmin();
        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        List<WebElement> countryZone = driver.findElements(By.xpath("//table[@class='dataTable']//tr[@class='row']//a[@title='Edit']"));
        ArrayList<String> listCouSort = new ArrayList<String>();
        ArrayList<String> listCouOrg = new ArrayList<String>();
        for (int i = 0; i < countryZone.size() ; i++) {
            countryZone = driver.findElements(By.xpath("//table[@class='dataTable']//tr[@class='row']//a[@title='Edit']"));
            countryZone.get(i).click();
            List<WebElement> sublist = driver.findElements(By.xpath("//table[@id='table-zones']//tr//select[contains(@name,'][zone_code]')]"));
            for (int j = 0; j < sublist.size(); j++) {
                listCouSort.add(sublist.get(j).findElement(By.xpath(".//option[@selected='selected']")).getAttribute("textContent"));
            }
            listCouOrg.addAll(listCouSort);
            Collections.sort(listCouSort);
            Assert.assertTrue("Список не в алфавитном порядке" , listCouSort.equals(listCouOrg) );
            listCouSort.clear();
            listCouOrg.clear();
            driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        }


    }


}
