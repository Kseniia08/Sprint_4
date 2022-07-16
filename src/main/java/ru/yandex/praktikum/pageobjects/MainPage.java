package ru.yandex.praktikum.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.praktikum.BaseSeleniumPage;

import static ru.yandex.praktikum.constants.Constants.MAIN_PAGE_URL;

public class MainPage extends BaseSeleniumPage {
    //Предупреждение о куки
    private final By cookieButtonOnMainPage = By.id("rcc-confirm-button");

    //Кнопка "Заказать" наверху страницы
    private final By firstOrderButton = By.xpath("//button[@class='Button_Button__ra12g']");

    //Кнопка "Заказать" внизу страницы
    private final By secondOrderButton = By.xpath("//button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']");

    //Метод окрытия главной страницы сайта
    public MainPage openMainPage() {
        driver.get(MAIN_PAGE_URL);
        return this;
    }
    //Принятие куки
    public MainPage clickCookieOnMainPage() {
        if(driver.findElement(cookieButtonOnMainPage).isEnabled()){
            driver.findElement(cookieButtonOnMainPage).click();
            return this;
        }
        return this;
    }
    WebDriverWait wait = new WebDriverWait(driver, 60);

    //Тык на первую кнопку Заказать
    public OrderPage clickOnFirstOrderButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstOrderButton));
        driver.findElement(firstOrderButton).click();
        return  new OrderPage();
    }

    /*скролл до кнопки заказа внизу страницы, чтобы избежать на этом шаге "тест падает с ошибкой
org.openqa.selenium.NoSuchElementException: Unable to locate element: //button[@Class='Button_Button__ra12g Button_UltraBig__UU3Lp']"*/
    public void scrollUntilBottomOrderButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//div[text()='Как это работает']")));
    };

    //Тык на вторую кнопку Заказать
    public  OrderPage  clickOnSecondOrderButton() {
        scrollUntilBottomOrderButton();
        driver.findElement(secondOrderButton).click();
        return  new OrderPage();
    }

    //Вводим базовые локаторы для вопроса и ответа
    public static String idQuestionButtonLocator = "accordion__heading-%s";
    public static String idAnswerLocator = "accordion__panel-%s";

    //Базовый метод вопроса на главной странице
    public static By questionOnMainPage (String numberQA) {
        return By.id(String.format(idQuestionButtonLocator, numberQA));
    }

    //Базовый метод для ответа на главной странице
    public static By answerOnMainPage (String numberQA) {
        return By.id(String.format(idAnswerLocator, numberQA));
    }

    //Метод клика на вопрос
    public MainPage clickOnQuestionOnMainPage (String numberQA) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//div[text()='Вопросы о важном']")));
        driver.findElement(questionOnMainPage(numberQA)).click();
        return this;
    }
    //Метод получения текста с главной страницы
    public String getAnswerFromMainPage(String numberQA) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(".//div[text()='Вопросы о важном']")));
        return driver.findElement(answerOnMainPage(numberQA)).getText();
    }
}
