package org.gb.less.lesson6;



import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShoppingCartPage extends BasePage {

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }


    private final String cartXpath = "//a[@class='link' ]/mvid-icon[@type='cart']/..";
    private final String modelXpath = "//a[@class='cart-item__name ng-star-inserted' and contains(., 'Ноутбук')]";

    @FindBy(xpath = cartXpath)
    private WebElement cart;

    @FindBy(xpath = modelXpath)
    private WebElement model;

    public ShoppingCartPage shoppingCartPage(String expectedModel){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cartXpath)));
        cart.click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(modelXpath)));
        Assertions.assertEquals(expectedModel, model.getText());
        return this;
    }

}
