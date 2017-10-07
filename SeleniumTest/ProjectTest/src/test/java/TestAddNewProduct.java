import org.junit.Test;

public class TestAddNewProduct extends TestBase {


    @Test
    public void testAddNewProduct() {
        loginAdmin();
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        


    }
}
