package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitDisplayed;
import static ru.iteco.fmhandroid.ui.data.DataHelper.withIndex;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.getEmptyDescription;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.getEmptyTitle;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.getFutureDate;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.getInvalidDate;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.getInvalidTime;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.getLongDescription;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.getLongTitle;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.getPastDate;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.getSpecialCharactersDescription;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.getSpecialCharactersTitle;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.getValidNewsCategory;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.getValidNewsDate;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.getValidNewsDescription;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.getValidNewsTime;
import static ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage.getValidNewsTitle;

import androidx.test.espresso.contrib.RecyclerViewActions;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.data.TestConstants;
import ru.iteco.fmhandroid.ui.data.MyViewAction; // ИСПРАВЛЕНО: добавлен импорт
import ru.iteco.fmhandroid.ui.elements.NewsControlPanelPage;

/**
 * Класс Steps для работы с панелью управления новостями
 * Содержит все методы для взаимодействия с UI элементами
 */
public class NewsControlPanelSteps {

    NewsControlPanelPage newsControlPanelPage = new NewsControlPanelPage();

    public void loadNewsControlPanelPage() {
        Allure.step("Загрузка страницы управления новостями");
        onView(isRoot()).perform(waitDisplayed(newsControlPanelPage.getAddNewsButtonId(), 5000));
    }

    public void waitForNewsControlPanelTitle(int timeout) {
        Allure.step("Ожидание заголовка панели управления новостями");
        onView(isRoot()).perform(waitDisplayed(newsControlPanelPage.newsControlPanelTitleId, timeout));
    }

    public void waitForAddNewsButton(int timeout) {
        Allure.step("Ожидание кнопки добавления новости");
        onView(isRoot()).perform(waitDisplayed(newsControlPanelPage.getAddNewsButtonId(), timeout));
    }

    public void waitForNewsRecyclerView(int timeout) {
        Allure.step("Ожидание списка новостей");
        onView(isRoot()).perform(waitDisplayed(newsControlPanelPage.getNewsRecyclerViewId(), timeout));
    }

    public void clickAddNewsButton() {
        Allure.step("Нажать на кнопку добавления новости");
        newsControlPanelPage.addNewsButton.perform(click());
    }

    public void clickEditButton() {
        Allure.step("Нажать на кнопку редактирования новости");
        newsControlPanelPage.editButton.perform(click());
    }

    public void clickDeleteButton() {
        Allure.step("Нажать на кнопку удаления новости");
        newsControlPanelPage.deleteButton.perform(click());
    }

    public void clickSortButton() {
        Allure.step("Нажать на кнопку сортировки новостей");
        newsControlPanelPage.sortButton.perform(click());
    }

    public void clickFilterButton() {
        Allure.step("Нажать на кнопку фильтрации новостей");
        newsControlPanelPage.filterButton.perform(click());
    }

    public void clickSaveButton() {
        Allure.step("Нажать на кнопку сохранения");
        newsControlPanelPage.saveButton.perform(click());
    }

    public void clickCancelButton() {
        Allure.step("Нажать на кнопку отмены");
        newsControlPanelPage.cancelButton.perform(click());
    }

    public void clickConfirmDeleteButton() {
        Allure.step("Подтвердить удаление новости");
        newsControlPanelPage.confirmDeleteButton.perform(click());
    }

    public void fillTitleField(String title) {
        Allure.step("Заполнить поле заголовка: " + title);
        newsControlPanelPage.titleField.perform(replaceText(title));
    }

    public void fillDescriptionField(String description) {
        Allure.step("Заполнить поле описания: " + description);
        newsControlPanelPage.descriptionField.perform(replaceText(description));
    }

    public void selectCategory(String category) {
        Allure.step("Выбрать категорию: " + category);
        newsControlPanelPage.categoryDropdown.perform(click());
        onView(withText(category)).perform(click());
    }

    public void fillDateField(String date) {
        Allure.step("Заполнить поле даты: " + date);
        newsControlPanelPage.dateField.perform(replaceText(date));
    }

    public void fillTimeField(String time) {
        Allure.step("Заполнить поле времени: " + time);
        newsControlPanelPage.timeField.perform(replaceText(time));
    }

    public void toggleActiveSwitch() {
        Allure.step("Переключить статус активности новости");
        newsControlPanelPage.switcherActive.perform(click());
    }

    public void clickOnNewsItem(int position) {
        Allure.step("Нажать на новость в позиции: " + position);
        onView(withId(newsControlPanelPage.getNewsRecyclerViewId()))
                .perform(actionOnItemAtPosition(position, click()));
    }

    public void clickEditButtonOnNewsItem(int position) {
        Allure.step("Нажать на кнопку редактирования новости в позиции: " + position);
        onView(withId(newsControlPanelPage.getNewsRecyclerViewId()))
                .perform(actionOnItemAtPosition(position,
                        MyViewAction.clickChildViewWithId(newsControlPanelPage.getEditButtonId())));
    }

    public void clickDeleteButtonOnNewsItem(int position) {
        Allure.step("Нажать на кнопку удаления новости в позиции: " + position);
        onView(withId(newsControlPanelPage.getNewsRecyclerViewId()))
                .perform(actionOnItemAtPosition(position,
                        MyViewAction.clickChildViewWithId(newsControlPanelPage.getDeleteButtonId())));
    }

    public void checkNewsTitle(int index, String expectedTitle) {
        Allure.step("Проверить заголовок новости в позиции " + index + ": " + expectedTitle);
        onView(withIndex(withId(newsControlPanelPage.getNewsItemTitleId()), index))
                .check(matches(withText(expectedTitle)));
    }

    public void checkNewsDescription(int index, String expectedDescription) {
        Allure.step("Проверить описание новости в позиции " + index + ": " + expectedDescription);
        onView(withIndex(withId(newsControlPanelPage.getNewsItemDescriptionId()), index))
                .check(matches(withText(expectedDescription)));
    }

    public void checkNewsDate(int index, String expectedDate) {
        Allure.step("Проверить дату новости в позиции " + index + ": " + expectedDate);
        onView(withIndex(withId(newsControlPanelPage.getNewsItemDateId()), index))
                .check(matches(withText(expectedDate)));
    }

    public void checkPoolConstructionNews() {
        Allure.step("Проверить новость о строительстве бассейна");
        checkNewsDescription(0, TestConstants.NewsTexts.DESCRIPTION_POOL_CONSTRUCTION);
    }

    public void checkSalaryAdvanceNews() {
        Allure.step("Проверить новость о перечислении аванса");
        checkNewsDescription(1, TestConstants.NewsTexts.DESCRIPTION_SALARY_ADVANCE);
    }

    public void checkDonationsNews() {
        Allure.step("Проверить новость о пожертвованиях");
        checkNewsDescription(2, TestConstants.NewsTexts.DESCRIPTION_DONATIONS);
    }

    public void checkVisitNews() {
        Allure.step("Проверить новость о посещении");
        checkNewsDescription(3, TestConstants.NewsTexts.DESCRIPTION_VISIT);
    }

    public void checkAnniversaryNews() {
        Allure.step("Проверить новость о юбилее");
        checkNewsDescription(4, TestConstants.NewsTexts.DESCRIPTION_ANNIVERSARY);
    }

    public void verifyNewsControlPanelIsDisplayed() {
        Allure.step("Проверить отображение панели управления новостями");
        newsControlPanelPage.newsControlPanelTitle.check(matches(isDisplayed()));
    }

    public void verifyAddNewsButtonIsDisplayed() {
        Allure.step("Проверить отображение кнопки добавления новости");
        newsControlPanelPage.addNewsButton.check(matches(isDisplayed()));
    }

    public void verifySortButtonIsDisplayed() {
        Allure.step("Проверить отображение кнопки сортировки");
        newsControlPanelPage.sortButton.check(matches(isDisplayed()));
    }

    public void verifyFilterButtonIsDisplayed() {
        Allure.step("Проверить отображение кнопки фильтрации");
        newsControlPanelPage.filterButton.check(matches(isDisplayed()));
    }

    public void verifyNewsListIsDisplayed() {
        Allure.step("Проверить отображение списка новостей");
        newsControlPanelPage.newsRecyclerView.check(matches(isDisplayed()));
    }

    public void createValidNews() {
        Allure.step("Создать валидную новость с тестовыми данными");
        clickAddNewsButton();
        fillTitleField(getValidNewsTitle());
        fillDescriptionField(getValidNewsDescription());
        selectCategory(getValidNewsCategory());
        fillDateField(getValidNewsDate());
        fillTimeField(getValidNewsTime());
        clickSaveButton();
    }

    public void createNewsWithEmptyTitle() {
        Allure.step("Попытаться создать новость с пустым заголовком");
        clickAddNewsButton();
        fillTitleField(getEmptyTitle());
        fillDescriptionField(getValidNewsDescription());
        selectCategory(getValidNewsCategory());
        fillDateField(getValidNewsDate());
        fillTimeField(getValidNewsTime());
        clickSaveButton();
    }

    public void createNewsWithEmptyDescription() {
        Allure.step("Попытаться создать новость с пустым описанием");
        clickAddNewsButton();
        fillTitleField(getValidNewsTitle());
        fillDescriptionField(getEmptyDescription());
        selectCategory(getValidNewsCategory());
        fillDateField(getValidNewsDate());
        fillTimeField(getValidNewsTime());
        clickSaveButton();
    }

    public void createNewsWithLongTitle() {
        Allure.step("Попытаться создать новость со слишком длинным заголовком");
        clickAddNewsButton();
        fillTitleField(getLongTitle());
        fillDescriptionField(getValidNewsDescription());
        selectCategory(getValidNewsCategory());
        fillDateField(getValidNewsDate());
        fillTimeField(getValidNewsTime());
        clickSaveButton();
    }

    public void createNewsWithLongDescription() {
        Allure.step("Попытаться создать новость со слишком длинным описанием");
        clickAddNewsButton();
        fillTitleField(getValidNewsTitle());
        fillDescriptionField(getLongDescription());
        selectCategory(getValidNewsCategory());
        fillDateField(getValidNewsDate());
        fillTimeField(getValidNewsTime());
        clickSaveButton();
    }

    public void createNewsWithSpecialCharacters() {
        Allure.step("Попытаться создать новость со спецсимволами");
        clickAddNewsButton();
        fillTitleField(getSpecialCharactersTitle());
        fillDescriptionField(getSpecialCharactersDescription());
        selectCategory(getValidNewsCategory());
        fillDateField(getValidNewsDate());
        fillTimeField(getValidNewsTime());
        clickSaveButton();
    }

    public void createNewsWithFutureDate() {
        Allure.step("Создать новость с будущей датой");
        clickAddNewsButton();
        fillTitleField(getValidNewsTitle());
        fillDescriptionField(getValidNewsDescription());
        selectCategory(getValidNewsCategory());
        fillDateField(getFutureDate());
        fillTimeField(getValidNewsTime());
        clickSaveButton();
    }

    public void createNewsWithPastDate() {
        Allure.step("Создать новость с прошедшей датой");
        clickAddNewsButton();
        fillTitleField(getValidNewsTitle());
        fillDescriptionField(getValidNewsDescription());
        selectCategory(getValidNewsCategory());
        fillDateField(getPastDate());
        fillTimeField(getValidNewsTime());
        clickSaveButton();
    }

    public void createNewsWithInvalidDate() {
        Allure.step("Попытаться создать новость с некорректной датой");
        clickAddNewsButton();
        fillTitleField(getValidNewsTitle());
        fillDescriptionField(getValidNewsDescription());
        selectCategory(getValidNewsCategory());
        fillDateField(getInvalidDate());
        fillTimeField(getValidNewsTime());
        clickSaveButton();
    }

    public void createNewsWithInvalidTime() {
        Allure.step("Попытаться создать новость с некорректным временем");
        clickAddNewsButton();
        fillTitleField(getValidNewsTitle());
        fillDescriptionField(getValidNewsDescription());
        selectCategory(getValidNewsCategory());
        fillDateField(getValidNewsDate());
        fillTimeField(getInvalidTime());
        clickSaveButton();
    }

    public void sortNewsByDate() {
        Allure.step("Отсортировать новости по дате");
        clickSortButton();
        waitForNewsRecyclerView(2000);
    }

    public void filterActiveNews() {
        Allure.step("Отфильтровать активные новости");
        clickFilterButton();
        onView(withText(TestConstants.NewsTexts.NOT_ACTIVE_SWITCHER)).perform(click());
        waitForNewsRecyclerView(2000);
    }

    public void filterInactiveNews() {
        Allure.step("Отфильтровать неактивные новости");
        clickFilterButton();
        onView(withText(TestConstants.NewsTexts.NOT_ACTIVE)).perform(click());
        waitForNewsRecyclerView(2000);
    }

    public int getAddNewsButtonId() {
        return newsControlPanelPage.getAddNewsButtonId();
    }

    public int getNewsRecyclerViewId() {
        return newsControlPanelPage.getNewsRecyclerViewId();
    }

    public int getSaveButtonId() {
        return newsControlPanelPage.getSaveButtonId();
    }

    public void scrollToNewsItem(int position) {
        Allure.step("Прокрутить к новости в позиции: " + position);
        onView(withId(newsControlPanelPage.getNewsRecyclerViewId()))
                .perform(RecyclerViewActions.scrollToPosition(position));
    }

    public void scrollToAndClickNewsItem(int position) {
        Allure.step("Прокрутить к новости и нажать на неё в позиции: " + position);
        scrollToNewsItem(position);
        clickOnNewsItem(position);
    }
}
