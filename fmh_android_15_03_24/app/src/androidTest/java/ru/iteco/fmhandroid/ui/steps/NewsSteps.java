// app/src/androidTest/java/ru/iteco/fmhandroid/ui/steps/NewsSteps.java
package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.NewsPage;
import ru.iteco.fmhandroid.ui.data.DataHelper;

public class NewsSteps {

    private final NewsPage newsPage = new NewsPage();

    /**
     * Нажать на пункт "Новости" в главном меню
     */
    public void clickButtonNews() {
        Allure.step("Нажать на пункт 'Новости' в главном меню");
        newsPage.mainMenuNewsItem.perform(click());
    }

    /**
     * Проверить, что заголовок "Новости" отображается на экране
     */
    public void checkNewsTitle() {
        Allure.step("Проверить отображение заголовка 'Новости'");
        newsPage.newsTitle.check(matches(isDisplayed()));
    }

    /**
     * Нажать на кнопку "Все новости"
     */
    public void clickAllNewsButton() {
        Allure.step("Нажать на кнопку 'Все новости'");
        newsPage.allNewsButton.perform(click());
    }

    /**
     * Ожидание загрузки списка новостей
     * @param timeout миллисекунды ожидания
     */
    public void waitForNewsList(int timeout) {
        Allure.step("Ожидание загрузки списка новостей");
        DataHelper.waitDisplayed(newsPage.getNewsListContainerId(), timeout);
    }

    /**
     * Нажать на первую кнопку "Развернуть" в списке новостей
     */
    public void clickExpandFirstNews() {
        Allure.step("Нажать на кнопку 'Развернуть' первой новости");
        newsPage.expandNewsButtons.get(0).perform(click());
    }

    /**
     * Проверить описание первой новости
     * @param expectedText ожидаемый текст описания
     */
    public void checkFirstNewsDescription(String expectedText) {
        Allure.step("Проверить описание первой новости");
        newsPage.newsItemDescriptions.get(0)
                .check(matches(withText(expectedText)))
                .check(matches(isDisplayed()));
    }
}
