package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitDisplayed;

import androidx.test.espresso.Espresso;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.MainPage;

public class MainSteps {

    MainPage mainPage = new MainPage();

    public void clickAllNews() {
        Allure.step("Нажать на кнопку 'Все новости'");
        mainPage.allNewsButton.perform(click());
    }

    public void clickMainMenuButton() {
        Allure.step("Нажать на кнопку главного меню");
        mainPage.mainMenuButton.perform(click());
    }

    public void showTitleNewsOnMain() {
        Allure.step("Отобразился заголовок новостей на главной странице");
        mainPage.newsTitle.check(matches(isDisplayed()));
    }

    public void clickExpandNewsButton() {
        Allure.step("Нажать на кнопку разворачивания новостей");
        mainPage.expandNewsButton.perform(click());
    }

    public void waitForContainerListNews(int timeout) {
        Allure.step("Ожидание контейнера списка новостей");
        Espresso.onView(isRoot()).perform(waitDisplayed(mainPage.getContainerListNewsId(), timeout));
    }

    public void waitForAllNewsButton(int timeout) {
        Allure.step("Ожидание кнопки 'Все новости'");
        Espresso.onView(isRoot()).perform(waitDisplayed(mainPage.getAllNewsButtonId(), timeout));
    }

    // ДОБАВЛЕНО: Методы, которые вызываются в тестах
    public void showButtonAllNews() {
        Allure.step("Показать кнопку 'Все новости'");
        mainPage.allNewsButton.check(matches(isDisplayed()));
    }

    public void clickButtonAllNews() {
        Allure.step("Нажать на кнопку 'Все новости'");
        clickAllNews();
    }

    // ДОБАВЛЕНО: Недостающий метод clickButtonMain
    public void clickButtonMain() {
        Allure.step("Возврат на главную страницу");
        // системная навигация Back
        Espresso.pressBack();
    }

    // Методы для получения ID элементов
    public int getAllNewsButtonId() {
        return mainPage.getAllNewsButtonId();
    }

    public int getMainMenuButtonId() {
        return mainPage.getMainMenuButtonId();
    }

    // ДОБАВЛЕНО: Дополнительные методы для совместимости
    public int getMainMenuButton() {
        return getMainMenuButtonId();
    }

    public int getButtonToExpandNews() {
        return mainPage.getExpandNewsButtonId();
    }
}
