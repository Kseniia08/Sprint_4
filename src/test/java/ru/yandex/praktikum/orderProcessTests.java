package ru.yandex.praktikum;

import org.junit.Assert;
import org.junit.Test;

public class orderProcessTests extends BaseSeleniumUITest{

    //Тест-прогон заказа через первую кнопку Заказать
    @Test
    public void ScooterOrderTestFromFirstOrderButton() {
        OrderForm orderForm = new OrderForm ("Иван", "Дятлов", "Москва", "4", "89564278432", "21.07.2022", "сутки", "black", "Тестотвый комментарий для первого теста");
        MainPage objMainPage = new MainPage();
        objMainPage
                .openMainPage()
                .clickCookieOnMainPage()
                .clickOnFirstOrderButton()
                .fillOrderForScooter(orderForm)
                .clickOnFinalOrderButton()
                .clickOnOrderStatusButton();
        boolean isFinalInformationAboutOrderPageDisplayed = OrderPage.isFinalInformationAboutOrderPageDisplayed();
        Assert.assertTrue (isFinalInformationAboutOrderPageDisplayed);
        System.out.println("Тест успешно пройден! Самокат заказан");
    }

    //Тест-прогон заказа через первую кнопку Заказать
    @Test
    public void ScooterOrderTestFromSecondOrderButton() {
        OrderForm orderForm = new OrderForm ("Вася", "Грозный", "Долгопрудный", "6", "86894278255", "17.07.2022", "двое суток", "grey", "Тестотвый комментарий для второго теста");
        MainPage objMainPage = new MainPage();
        objMainPage
                .openMainPage()
                .clickCookieOnMainPage()
                .clickOnSecondOrderButton()
                .fillOrderForScooter(orderForm)
                .clickOnFinalOrderButton()
                .clickOnOrderStatusButton();
        boolean isFinalInformationAboutOrderPageDisplayed = OrderPage.isFinalInformationAboutOrderPageDisplayed();
        Assert.assertTrue (isFinalInformationAboutOrderPageDisplayed);
        System.out.println("Тест успешно пройден! Самокат заказан");
    }
}