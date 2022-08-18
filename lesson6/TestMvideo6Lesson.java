package org.gb.less.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestMvideo6Lesson {

    private final static String MVIDEO_BASE_URL = "https://mvideo.ru";

    WebDriver driver;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        driver = new ChromeDriver(chromeOptions);
        driver.get(MVIDEO_BASE_URL);
    }

    @Test
    void cartTest() throws InterruptedException {
        new MainMenuBlock(driver).selectOneItemNout()
                .productCard()
                .shoppingCartPage("Ноутбук HUAWEI MateBook E DRC-W56 16+512GB Grey");
    }
    @AfterEach
    void killBrowser() {
        driver.quit();
    }

    }
