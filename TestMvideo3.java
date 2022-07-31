package org.gb.less.Lesson3;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestMvideo3 {
     public static void main(String[] args) throws InterruptedException {
          //Сценарий: посмотреть и поместить в корзину самую популярную модель смарт-часов Самсунг
          // не получилось выбрать первую в списке модель, только по части наименования(

          WebDriverManager.chromedriver().setup();
          ChromeOptions chromeOptions = new ChromeOptions();
          chromeOptions.addArguments("--disable-notifications");
          WebDriver driver = new ChromeDriver(chromeOptions);
          driver.get("https://mvideo.ru");
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
          driver.findElement(By.xpath("//input[@class='input__field']")).sendKeys("смарт-часы samsung");
          WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
          webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='ng-star-inserted']/li[1]/a")));
          driver.findElement(By.xpath("//ul[@class='ng-star-inserted']/li[1]/a")).click();
          webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'черный (SM-R880N)')]")));
          driver.findElement(By.xpath("//a[contains(text(), 'черный (SM-R880N)')]")).click();
          driver.findElement(By.xpath("//button[@title='Добавить в корзину']")).click();
          webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Перейти в корзину')]/..")));
          driver.findElement(By.xpath("//div[contains(text(),'Перейти в корзину')]/..")).click();

          Thread.sleep(5000);
          driver.quit();
     }
}
