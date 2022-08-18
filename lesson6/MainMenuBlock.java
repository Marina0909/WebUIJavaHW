package org.gb.less.lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MainMenuBlock extends BasePage{

    public MainMenuBlock(WebDriver driver) {
            super(driver);
    }
    private final String menuXpath = "//a[@class='ng-tns-c224-1']";

    @FindBy(xpath = menuXpath)
    private List <WebElement> katsList;

    public ProductCardPage selectOneItemNout() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(menuXpath)));
        katsList.stream().filter(f -> f.getText().contains("НОУТБУК")).findFirst().get().click();
        return new ProductCardPage(driver);
    }

}
