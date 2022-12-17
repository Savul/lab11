package Tests;

import Pages.BasketPage;
import Pages.HomePage;
import org.openqa.selenium.By;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class Testing extends CommonConditions {
    String resultTestFindProductInBasket = "Корзина";
    String resultTestDeleteProductInBasket = "В корзине пока пусто";
    By targetTestFindProductInBasket = By.xpath("//h1[@class='basket-section__header active']");
    By targetTestDeleteProductBasket = By.xpath("//h1[@class='section-header']");

    @Test
    public void AddProductToBasket() throws InterruptedException {
        new HomePage(webDriver)
                .openPage()
                .clickSearchLine()
                .writeTextInSearchLine("красное платье")
                .clickSubmitSearch()
                .moveToProduct()
                .addProductToBasket()
                .changeSizeProduct()
                .clickBasketButton();
        new BasketPage(webDriver);
        AssertJUnit.assertEquals(BasketPage.checkProgress(this.targetTestFindProductInBasket), this.resultTestFindProductInBasket);
    }
    @Test
    public void DeleteProductFromBasket() throws InterruptedException {
        new HomePage(webDriver)
                .openPage()
                .clickSearchLine()
                .writeTextInSearchLine("красное платье")
                .clickSubmitSearch()
                .moveToProduct()
                .addProductToBasket()
                .changeSizeProduct()
                .clickBasketButton();
        int numberOfProduct = new BasketPage(webDriver)
                .CheckWhatIsProduct();
        new BasketPage(webDriver)
                .deleteElement(numberOfProduct);
        AssertJUnit.assertEquals(BasketPage.checkProgress(this.targetTestDeleteProductBasket), this.resultTestDeleteProductInBasket);
    }


    @Test
    public void FindSportCustom() throws InterruptedException {
        new HomePage(webDriver)
                .openPage()
                .clickSearchLine()
                .writeTextInSearchLine("спортивный костюм")
                .clickSubmitSearch()
                .setOptionsMark()
                .setOptionsSex();
        int count = new HomePage(webDriver).countOfProduct();
        AssertJUnit.assertTrue(count>0);
    }

    @Test
    public void FindHealthyEating() throws InterruptedException {
        new HomePage(webDriver)
                .openPage()
                .clickBurgerMenu()
                .clickFoodItemMenu()
                .changeMenuItem()
                .changeItemSort()
                .TimeOfDelivery();
        int count = new HomePage(webDriver).countOfProduct();
        AssertJUnit.assertTrue(count>0);
    }

}
