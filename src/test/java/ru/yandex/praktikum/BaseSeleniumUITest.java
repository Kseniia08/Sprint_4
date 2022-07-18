package ru.yandex.praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/*Создаю отдельный асбтрактный класс в котором создаю анатации Before и After*/

public abstract class BaseSeleniumUITest {
    protected static WebDriver driver;

    @BeforeClass
    public static void startUp() {
        //Подключаю и настраиваю хром драйвер
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        BaseSeleniumPage.setDriver(driver);
    }


    @AfterClass
    public static void teardown() {
        //Закрываю браузер
       driver.quit();
    }

}
