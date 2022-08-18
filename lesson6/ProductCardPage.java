package org.gb.less.lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductCardPage extends BasePage {

    public ProductCardPage(WebDriver driver) {
        super(driver);
    }

    private final String productXpath = "//a[contains(.,'Ноутбук HUAWEI MateBook E DRC-W56 16+512GB Grey')]";
    private final String cartXpath = "//section[@class='main mv-grid ng-star-inserted']//mvideoru-cart-button/button";


    @FindBy(xpath = productXpath)
    private WebElement product;

    @FindBy(xpath = cartXpath)
    private WebElement cart;

    public ShoppingCartPage productCard() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(productXpath)));
        product.click();
        //карточка товара
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cartXpath)));
        cart.click();
        return new ShoppingCartPage(driver);
    }


}
