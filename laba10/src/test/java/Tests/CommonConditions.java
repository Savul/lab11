package Tests;

import Driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import util.TestListener;


@Listeners({TestListener.class})
public class CommonConditions {

    protected WebDriver webDriver;

    @BeforeMethod()
    public void setUp()
    {
        webDriver = DriverSingleton.getDriver();
    }

    @AfterMethod()
    public  void stopBrowser()
    {
        DriverSingleton.closeDriver();
    }

}
