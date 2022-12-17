package Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class DriverSingleton {
    private static WebDriver webDriver;
    private DriverSingleton() {}
    public static WebDriver getDriver()
    {
        if(null==webDriver)
        {
            switch (System.getProperty("browser"))
            {
                case "firefox":
                {
                    WebDriverManager.firefoxdriver().setup();
                    webDriver = new FirefoxDriver();
                }
                default:{
                    WebDriverManager.chromedriver().setup();
                    webDriver = new ChromeDriver();
                }
            }
            webDriver.manage().window().maximize();
        }
        return webDriver;
    }

    public static  void closeDriver()
    {
        webDriver.quit();
        webDriver=null;
    }

}
