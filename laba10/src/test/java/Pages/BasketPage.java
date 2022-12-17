package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import java.util.List;

public class BasketPage {

    private static Logger log = LogManager.getRootLogger();
    private static WebDriver driver;
    @FindBy(xpath = "//span[@class='good-info__good-name']")
    List<WebElement> nameProduct;
    @FindBy(xpath = "//div[@class='list-item__count count']")
    List<WebElement> product;
    @FindBy(xpath = "//button[@class='btn__del j-basket-item-del']")
    List<WebElement> buttonDelete;
    String targetNameOfProduct ="Платье женское праздничное нарядное офис";

    public BasketPage(WebDriver driver) {
        BasketPage.driver = driver;
        PageFactory.initElements(new DefaultElementLocatorFactory(driver), this);
    }

    public static String checkProgress(By locator) throws InterruptedException {
        Thread.sleep(5000);
        log.info("check result");
        return driver.findElements(locator).get(0).getText();
    }

    public int CheckWhatIsProduct() throws InterruptedException {
        Thread.sleep(5000);
        log.info("find product in list");
        for(int i=0;i<nameProduct.size();i++)
        {
            boolean productEquals = targetNameOfProduct.equals(nameProduct.get(i).getText());
            if (productEquals)
                return i;
        }
       return 0;
    }

    public BasketPage deleteElement(int numberOfProduct)
    {
        Actions action = new Actions(driver);
        action.moveToElement(product.get(numberOfProduct));
        action.perform();
        buttonDelete.get(numberOfProduct).click();
        log.info("delete product");
        return this;
    }

}
