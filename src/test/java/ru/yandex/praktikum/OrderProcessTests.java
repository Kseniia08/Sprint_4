package ru.yandex.praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.pageobjects.MainPage;
import ru.yandex.praktikum.pageobjects.OrderPage;

public class OrderProcessTests extends BaseSeleniumUITest{

    //Выношу по замечанию
    @Before
    public void openMainPage() {
        new MainPage()
                .openMainPage();
    }

    //Тест-прогон заказа через первую кнопку Заказать
    @Test
    public void scooterOrderTestFromFirstOrderButton() {
        OrderForm orderForm = new OrderForm ("Иван", "Дятлов", "Москва", "4", "89564278432", "21.07.2022", "сутки", "black", "Тестотвый комментарий для первого теста");
        MainPage objMainPage = new MainPage();
        objMainPage
                .clickCookieOnMainPage()
                .clickOnFirstOrderButton()
                .fillOrderForScooter(orderForm)
                .clickOnFinalOrderButton()
                .clickOnOrderStatusButton();
        boolean isFinalInformationAboutOrderPageDisplayed = OrderPage.isFinalInformationAboutOrderPageDisplayed();
        Assert.assertTrue (isFinalInformationAboutOrderPageDisplayed);
        System.out.println("Тест успешно пройден! Самокат заказан");
        driver.manage().deleteAllCookies();
    }

    //Тест-прогон заказа через первую кнопку Заказать
    @Test
    public void scooterOrderTestFromSecondOrderButton() {
        OrderForm orderForm = new OrderForm ("Вася", "Грозный", "Долгопрудный", "6", "86894278255", "17.07.2022", "двое суток", "grey", "Тестотвый комментарий для второго теста");
        MainPage objMainPage = new MainPage();
        objMainPage
                .clickCookieOnMainPage()
                .clickOnSecondOrderButton()
                .fillOrderForScooter(orderForm)
                .clickOnFinalOrderButton()
                .clickOnOrderStatusButton();
        boolean isFinalInformationAboutOrderPageDisplayed = OrderPage.isFinalInformationAboutOrderPageDisplayed();
        Assert.assertTrue (isFinalInformationAboutOrderPageDisplayed);
        System.out.println("Тест успешно пройден! Самокат заказан");
        driver.manage().deleteAllCookies();
    }
}