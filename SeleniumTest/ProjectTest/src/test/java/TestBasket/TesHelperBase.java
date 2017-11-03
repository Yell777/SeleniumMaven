package TestBasket;

import org.junit.Before;

/**
 * Created by User on 27.10.2017.
 */
public class TesHelperBase {
    public Application app;


    @Before
    public void start() {
        app = new Application();
    }


}
