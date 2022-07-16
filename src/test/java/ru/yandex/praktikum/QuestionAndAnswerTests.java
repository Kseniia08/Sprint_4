package ru.yandex.praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.constants.Constants;
import ru.yandex.praktikum.pageobjects.MainPage;

import static ru.yandex.praktikum.constants.Constants.MAIN_PAGE_URL;

@RunWith(Parameterized.class)
public class QuestionAndAnswerTests extends BaseSeleniumUITest {
    private final int numberQA;

    public QuestionAndAnswerTests(int numberQA) {
        this.numberQA = numberQA;
    }

    @Parameterized.Parameters
    public static Object getNumberQA() {
        return new Object[][] {
                {0},
                {1},
                {2},
                {3},
                {4},
                {5},
                {6},
                {7},
        };
    }

    //Выношу по замечанию
    @Before
    public void openMainPage() {
        new MainPage()
                .openMainPage()
                .clickCookieOnMainPage();
    }

    //Тест для проверки ответа на вопрос
    @Test
    public void checkingQACouple() {
        String answerFromMainPage = new MainPage()
                .clickOnQuestionOnMainPage(String.valueOf(numberQA))
                .getAnswerFromMainPage(String.valueOf(numberQA));
        Assert.assertEquals("Что-то пошло не так! Ответы НЕ совпадают",
                Constants.ANSWER_LIST[numberQA], answerFromMainPage);
        System.out.println("Ожидаемый и фактический ответы на " + numberQA+ "воспрос совпадают");
        driver.manage().deleteAllCookies();
    }
}
