package org.gb.less.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TestMvideo5Lesson {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    private final static String MVIDEO_BASE_URL = "https://mvideo.ru";

    @BeforeAll
    static void registerDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void newChromeDriver(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        driver = new ChromeDriver(chromeOptions);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(MVIDEO_BASE_URL);
    }
    @Test
    void likeChangeTest() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        webDriverWait.until(d -> d.findElements(
                By.xpath("//a[@class='ng-tns-c224-1']")).size() > 0);
        List<WebElement> katsList =
                driver.findElements(By.xpath("//a[@class='ng-tns-c224-1']"));
        katsList.stream().filter(f -> f.getText().contains("НОУТБУК")).findFirst().get().click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//a[contains(.,'Ноутбук HUAWEI MateBook E DRC-W56 16+512GB Grey')]")));
        driver.findElement
                (By.xpath("//a[contains(.,'Ноутбук HUAWEI MateBook E DRC-W56 16+512GB Grey')]")).click();
        //карточка товара
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//section[@class='main mv-grid ng-star-inserted']//mvideoru-cart-button/button")));
        driver.findElement
                (By.xpath("//section[@class='main mv-grid ng-star-inserted']//mvideoru-cart-button/button"))
                .click();
        //корзина
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//a[@class='link' ]/mvid-icon[@type='cart']/..")));
        driver.findElement(By.xpath("//a[@class='link' ]/mvid-icon[@type='cart']/..")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[@class='cart-item__name-container']//a[contains(., 'Ноутбук HUAWEI MateBook E DRC-W56 16+512GB Grey')]")));
        Assertions.assertEquals(driver.findElement
                (By.xpath("//div[@class='cart-item__name-container']//a[contains(., 'Ноутбук HUAWEI MateBook E DRC-W56 16+512GB Grey')]"))
                .isDisplayed(), true);
    }
    @AfterEach
    void quitBrowser(){
        driver.quit();
    }
}
