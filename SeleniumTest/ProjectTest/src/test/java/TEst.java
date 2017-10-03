public class TEst {
//    @Test
//    public void checkingSortingCountries() {
//        driver.navigate().to("http://localhost/litecart/admin/?app=countries&doc=countries");
//        WebElement username = driver.findElement(By.xpath(".//*[@name='username']"));
//        username.sendKeys("admin");
//        WebElement password = driver.findElement(By.xpath(".//*[@name='password']"));
//        password.sendKeys("admin", Keys.ENTER);
//
//        List<WebElement> product = driver.findElements(By.xpath(".//table[@class='dataTable']//tr[@class='row']"));
//        int l = product.size();
//
//        ArrayList<String> Name = new ArrayList<String>();
//        for(int i=0; i < l; i++) {
//            Name.add(product.get(i).findElement(By.xpath(".//td[5]/a")).getAttribute("textContent"));
//        }
//
//        ArrayList<String> NameSort = new ArrayList<String>();
//        NameSort.addAll(Name);
//        Collections.sort(NameSort);
//        assertTrue("Список не отсортирован!", Name.equals(NameSort));
//
//        for(int i=0; i < l; i++) {
//            product = driver.findElements(By.xpath(".//table[@class='dataTable']//tr[@class='row']"));
//            if(Integer.parseInt(product.get(i).findElement(By.xpath(".//td[6]")).getAttribute("textContent")) > 0){
//
//                product.get(i).findElement(By.xpath(".//td[5]/a")).click();
//
//                List<WebElement> zones = driver.findElements(By.xpath(".//table[@id='table-zones']//tr//input[contains(@name,'][name]')]"));
//                int n = zones.size();
//
//                ArrayList<String> NameZones = new ArrayList<String>();
//                for(int j=0; j < n; j++) {
//                    NameZones.add(zones.get(j).getAttribute("value"));
//                }
//
//                ArrayList<String> NameZonesSort = new ArrayList<String>();
//                NameZonesSort.addAll(NameZones);
//                Collections.sort(NameZonesSort);
//                assertTrue("Список не отсортирован!", NameZones.equals(NameZonesSort));
//
//                driver.navigate().to("http://localhost/litecart/admin/?app=countries&doc=countries");
//            }
//        }
//    }
//
//    @Test
//    public void checkingSortingGeoZones() {
//        driver.navigate().to("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
//        WebElement username = driver.findElement(By.xpath(".//*[@name='username']"));
//        username.sendKeys("admin");
//        WebElement password = driver.findElement(By.xpath(".//*[@name='password']"));
//        password.sendKeys("admin", Keys.ENTER);
//
//        List<WebElement> country = driver.findElements(By.xpath(".//table[@class='dataTable']//tr[@class='row']"));
//        int l = country.size();
//
//        for(int i=0; i < l; i++) {
//            country = driver.findElements(By.xpath(".//table[@class='dataTable']//tr[@class='row']"));
//            country.get(i).findElement(By.xpath(".//td[3]/a")).click();
//
//            List<WebElement> zones = driver.findElements(By.xpath(".//table[@id='table-zones']//tr//select[contains(@name,'][zone_code]')]"));
//            int n = zones.size();
//
//            ArrayList<String> NameZones = new ArrayList<String>();
//            for(int j=0; j < n; j++) {
//                NameZones.add(zones.get(j).findElement(By.xpath(".//option[@selected='selected']")).getAttribute("textContent"));
//            }
//
//            ArrayList<String> NameZonesSort = new ArrayList<String>();
//            NameZonesSort.addAll(NameZones);
//            Collections.sort(NameZonesSort);
//            assertTrue("Список не отсортирован!", NameZones.equals(NameZonesSort));
//
//            driver.navigate().to("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
//        }
//    }

}
