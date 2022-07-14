package ru.yandex.praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.constants.Constants;
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

    //Тест для проверки ответа на вопрос
    @Test
    public void checkingQACouple() {
        driver.get(MAIN_PAGE_URL);
        String answerFromMainPage = new MainPage()
                .clickCookieOnMainPage()
                .clickOnQuestionOnMainPage(String.valueOf(numberQA))
                .getAnswerFromMainPage(String.valueOf(numberQA));
        Assert.assertEquals("Что-то пошло не так! Ответы НЕ совпадают",
                Constants.ANSWER_LIST[numberQA], answerFromMainPage);
        System.out.println("Ожидаемый и фактический ответы на " + numberQA+ "воспрос совпадают");
    }
}
