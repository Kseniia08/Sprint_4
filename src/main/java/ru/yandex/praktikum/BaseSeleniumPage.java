package ru.yandex.praktikum;

import org.openqa.selenium.WebDriver;

abstract public class BaseSeleniumPage {
    protected static WebDriver driver;

    public  static void SetDriver(WebDriver webDriver) {
        driver = webDriver;
    }

}
