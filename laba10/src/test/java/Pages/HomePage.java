package Pages;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import java.util.List;

public class HomePage {
    private final WebDriver driver;
    private final  String url="https://www.wildberries.by";
    private final Logger log = LogManager.getRootLogger();
    @FindBy(xpath = "//span[@class='navbar-pc__icon navbar-pc__icon--basket']")
    WebElement basketButton;
    @FindBy(xpath = "//input[@class='search-catalog__input j-wba-header-item']")
    WebElement searchLine;
    @FindBy(xpath = "//div[@class='product-card__wrapper']")
    List<WebElement> product;
    @FindBy(xpath = "//div[@class='filter__title j-b-city-dropdown j-filter-title']")
    List<WebElement> options;
    @FindBy(xpath = "//a[@class='btn-main-sm j-add-to-basket']")
    List<WebElement> buttonAddToBasket;
    @FindBy(xpath = "//button[@class='search-catalog__btn search-catalog__btn--search']")
    WebElement buttonSubmitSearch;
    @FindBy(xpath = "//label[@class='j-quick-order-size-fake']")
    List<WebElement> changeSize;
    @FindBy(xpath = "//label[@class='j-list-item filter__item filter__item--checkbox']")
    List<WebElement> checkBoxes;
    @FindBy(xpath = "//div[@class='product-card j-card-item j-good-for-listing-event']")
    List<WebElement> countOfProducts;
    @FindBy(xpath = "//button[@class='nav-element__burger j-menu-burger-btn j-wba-header-item hide-mobile']")
    WebElement burgerButton;
    @FindBy(xpath = "//a[@class='menu-burger__main-list-link menu-burger__main-list-link--10296']")
    WebElement burgerMenuItem;
    @FindBy(xpath = "//a[@class='j-menu-item']")
    List<WebElement> itemMenu;
    @FindBy(xpath = "//a[@class='sort-item']")
    List<WebElement> itemSort;
    @FindBy(xpath = "//span[@class='item-radio-text']")
    List<WebElement> radioButtons;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new DefaultElementLocatorFactory(driver), this);
    }
    public HomePage clickBasketButton() {
        basketButton.click();
        log.info("click on basket");
        return this;
    }
    public HomePage clickSearchLine() {
        searchLine.click();
        log.info("click on searchLine");
        return this;
    }
    public HomePage writeTextInSearchLine(String info) throws InterruptedException {
        Thread.sleep(5000);
        searchLine.sendKeys(info);
        log.info("input data in searchLine");
        return this;
    }
    public  HomePage clickSubmitSearch(){
        buttonSubmitSearch.click();
        log.info("click submit in searchLine");
        return this;
    }
    public HomePage setOptionsMark() throws InterruptedException {
        Thread.sleep(5000);
        log.info("set mark options");
        checkBoxes.get(1).click();
        return this;
    }
    public  HomePage setOptionsSex() throws InterruptedException {
        Thread.sleep(5000);
        log.info("change sex options");
        checkBoxes.get(12).click();
        return this;
    }
    public  int countOfProduct() {
        log.info("count of product");
        return countOfProducts.size();
    }
    public HomePage moveToProduct() throws InterruptedException {
        Thread.sleep(5000);
        Actions action = new Actions(driver);
        action.moveToElement(product.get(0));
        action.perform();
        log.info("move mouse to element");
        return this;
    }
    public HomePage addProductToBasket() {
        buttonAddToBasket.get(0).click();
        log.info("add product to basket");
        return this;
    }
    public  HomePage changeSizeProduct() throws InterruptedException {
        Thread.sleep(2000);
        changeSize.get(2).click();
        log.info("change size product");
        return this;
    }
    public  HomePage openPage(){
        driver.get(url);
        log.info("open page");
        return this;
    }
    public HomePage clickBurgerMenu() throws InterruptedException {
        Thread.sleep(2000);
        log.info("click burger menu");
        burgerButton.click();
        return this;
    }
    public HomePage clickFoodItemMenu() throws InterruptedException {
        Thread.sleep(2000);
        log.info("click item in burger menu");
        burgerMenuItem.click();
        return this;
    }
    public HomePage changeMenuItem() throws InterruptedException {
        Thread.sleep(2000);
        log.info("change menu item");
        itemMenu.get(6).click();
        return this;
    }
    public HomePage changeItemSort() throws InterruptedException {
        Thread.sleep(2000);
        log.info("set options of sort");
        itemSort.get(3).click();
        return this;
    }
    public HomePage TimeOfDelivery() throws InterruptedException {
        Thread.sleep(2000);
        log.info("set delivery time");
        radioButtons.get(1).click();
        return this;
    }
}