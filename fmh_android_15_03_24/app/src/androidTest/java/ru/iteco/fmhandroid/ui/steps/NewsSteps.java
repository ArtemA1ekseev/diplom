package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitDisplayed;

import androidx.test.espresso.Espresso;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.NewsPage;

public class NewsSteps {

    NewsPage newsPage = new NewsPage();

    public void clickButtonNews() {
        Allure.step("Нажать на кнопку 'Новости'");
        newsPage.newsButton.perform(click());
    }

    // ДОБАВЛЕНО: Методы, которые вызываются в NewsControlPanelTest
    public void waitForAllNewsBlockLoad(int timeout) {
        Allure.step("Ожидание загрузки блока всех новостей");
        Espresso.onView(isRoot()).perform(waitDisplayed(newsPage.getNewsContainerId(), timeout));
    }

    public void clickEditNewsButton() {
        Allure.step("Нажать на кнопку редактирования новостей");
        newsPage.editButton.perform(click());
    }

    public void verifyNewsPageIsDisplayed() {
        Allure.step("Проверить отображение страницы новостей");
        newsPage.newsTitle.check(matches(isDisplayed()));
    }

    public void clickFilterButton() {
        Allure.step("Нажать на кнопку фильтра");
        newsPage.filterButton.perform(click());
    }

    public void clickSortButton() {
        Allure.step("Нажать на кнопку сортировки");
        newsPage.sortButton.perform(click());
    }
}
