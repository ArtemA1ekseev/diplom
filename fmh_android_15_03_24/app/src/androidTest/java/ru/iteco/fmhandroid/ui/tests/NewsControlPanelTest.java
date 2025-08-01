package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitDisplayed;

import android.view.View;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.TestConstants;
import ru.iteco.fmhandroid.ui.steps.AuthorizationSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.NewsControlPanelSteps;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
@Epic("Тест-кейсы для проведения функционального тестирования вкладки \"Управление новостями\" мобильного приложения \"Мобильный хоспис\".")
public class NewsControlPanelTest {

    AuthorizationSteps authorizationSteps = new AuthorizationSteps();
    MainSteps mainSteps = new MainSteps();
    NewsSteps newsSteps = new NewsSteps();
    NewsControlPanelSteps newsControlPanelSteps = new NewsControlPanelSteps();

    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    private View decorView;

    @Before
    public void setUp() {
        try {
            authorizationSteps.loadAuthorizationPage();
        } catch (Exception e) {
            authorizationSteps.clickButtonExit();
            authorizationSteps.clickButtonLogOut();
            authorizationSteps.loadAuthorizationPage();
        }
        activityScenarioRule.getScenario().onActivity(activity -> decorView = activity.getWindow().getDecorView());

        // Авторизация для доступа к панели управления
        authorizationSteps.waitForLoginLayout(5000);
        authorizationSteps.fillLoginField(AuthorizationSteps.getLogin());
        authorizationSteps.fillPasswordField(AuthorizationSteps.getPassword());
        authorizationSteps.clickButtonSignIn();
        authorizationSteps.waitForAuthorizationImageButton(3000);

        // Переход к управлению новостями
        mainSteps.clickAllNews();
        newsSteps.waitForAllNewsBlockLoad(5000);
        newsSteps.clickEditNewsButton();
        newsControlPanelSteps.waitForAddNewsButton(5000);
    }

    @After
    public void tearDown() {
        try {
            authorizationSteps.clickButtonExit();
            authorizationSteps.clickButtonLogOut();
        } catch (Exception ignored) {
        }
    }

    // TC - 37 - Создание новости с валидными данными (Позитивный)
    @Test
    @Story("TC - 37")
    @Description("Создание новости с валидными данными в панели управления новостями (Позитивный).")
    public void createValidNews() {
        newsControlPanelSteps.verifyNewsControlPanelIsDisplayed();
        newsControlPanelSteps.verifyAddNewsButtonIsDisplayed();
        newsControlPanelSteps.createValidNews();
        newsControlPanelSteps.waitForNewsRecyclerView(3000);
        newsControlPanelSteps.verifyNewsListIsDisplayed();
    }

    // TC - 38 - Попытка создания новости с пустым заголовком (Негативный)
    @Test
    @Story("TC - 38")
    @Description("Попытка создания новости с пустым заголовком в панели управления новостями (Негативный).")
    public void createNewsWithEmptyTitle() {
        newsControlPanelSteps.verifyNewsControlPanelIsDisplayed();
        newsControlPanelSteps.createNewsWithEmptyTitle();
        onView(withText(TestConstants.NewsMessages.FILL_EMPTY_FIELDS))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }

    // TC - 39 - Попытка создания новости с пустым описанием (Негативный)
    @Test
    @Story("TC - 39")
    @Description("Попытка создания новости с пустым описанием в панели управления новостями (Негативный).")
    public void createNewsWithEmptyDescription() {
        newsControlPanelSteps.verifyNewsControlPanelIsDisplayed();
        newsControlPanelSteps.createNewsWithEmptyDescription();
        onView(withText(TestConstants.NewsMessages.FILL_EMPTY_FIELDS))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }

    // TC - 40 - Создание новости с будущей датой (Позитивный)
    @Test
    @Story("TC - 40")
    @Description("Создание новости с будущей датой публикации в панели управления новостями (Позитивный).")
    public void createNewsWithFutureDate() {
        newsControlPanelSteps.verifyNewsControlPanelIsDisplayed();
        newsControlPanelSteps.createNewsWithFutureDate();
        newsControlPanelSteps.waitForNewsRecyclerView(3000);
        newsControlPanelSteps.verifyNewsListIsDisplayed();
    }

    // TC - 41 - Попытка создания новости со слишком длинным заголовком (Негативный)
    @Test
    @Story("TC - 41")
    @Description("Попытка создания новости со слишком длинным заголовком в панели управления новостями (Негативный).")
    public void createNewsWithLongTitle() {
        newsControlPanelSteps.verifyNewsControlPanelIsDisplayed();
        newsControlPanelSteps.createNewsWithLongTitle();
        onView(withText(TestConstants.NewsMessages.SAVING_FAILED))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }

    // TC - 42 - Попытка создания новости со слишком длинным описанием (Негативный)
    @Test
    @Story("TC - 42")
    @Description("Попытка создания новости со слишком длинным описанием в панели управления новостями (Негативный).")
    public void createNewsWithLongDescription() {
        newsControlPanelSteps.verifyNewsControlPanelIsDisplayed();
        newsControlPanelSteps.createNewsWithLongDescription();
        onView(withText(TestConstants.NewsMessages.SAVING_FAILED))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }

    // TC - 43 - Создание новости со спецсимволами (Позитивный/Негативный - зависит от требований)
    @Test
    @Story("TC - 43")
    @Description("Создание новости со специальными символами в заголовке и описании.")
    public void createNewsWithSpecialCharacters() {
        newsControlPanelSteps.verifyNewsControlPanelIsDisplayed();
        newsControlPanelSteps.createNewsWithSpecialCharacters();
        // Здесь может быть либо успех, либо ошибка - зависит от бизнес-требований
        // Если это должно быть разрешено:
        // newsControlPanelSteps.waitForNewsRecyclerView(3000);
        // Если это должно вызывать ошибку:
        // onView(withText(TestConstants.NewsMessages.SAVING_FAILED))...
    }

    // TC - 44 - Попытка создания новости с некорректной датой (Негативный)
    @Test
    @Story("TC - 44")
    @Description("Попытка создания новости с некорректной датой в панели управления новостями (Негативный).")
    public void createNewsWithInvalidDate() {
        newsControlPanelSteps.verifyNewsControlPanelIsDisplayed();
        newsControlPanelSteps.createNewsWithInvalidDate();
        onView(withText(TestConstants.NewsMessages.SAVING_FAILED))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }

    // TC - 45 - Попытка создания новости с некорректным временем (Негативный)
    @Test
    @Story("TC - 45")
    @Description("Попытка создания новости с некорректным временем в панели управления новостями (Негативный).")
    public void createNewsWithInvalidTime() {
        newsControlPanelSteps.verifyNewsControlPanelIsDisplayed();
        newsControlPanelSteps.createNewsWithInvalidTime();
        onView(withText(TestConstants.NewsMessages.SAVING_FAILED))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }

    // TC - 46 - Редактирование существующей новости (Позитивный)
    @Test
    @Story("TC - 46")
    @Description("Редактирование существующей новости в панели управления новостями (Позитивный).")
    public void editExistingNews() {
        newsControlPanelSteps.verifyNewsControlPanelIsDisplayed();
        newsControlPanelSteps.waitForNewsRecyclerView(3000);
        newsControlPanelSteps.clickEditButtonOnNewsItem(0);
        onView(isRoot()).perform(waitDisplayed(newsControlPanelSteps.getSaveButtonId(), 3000));
        // ИСПРАВЛЕНО: используем константы вместо магических строк
        newsControlPanelSteps.fillTitleField(TestConstants.TestTitles.EDITED_TITLE);
        newsControlPanelSteps.fillDescriptionField(TestConstants.TestTitles.EDITED_DESCRIPTION);
        newsControlPanelSteps.clickSaveButton();
        newsControlPanelSteps.waitForNewsRecyclerView(3000);
    }

    // TC - 47 - Удаление новости (Позитивный)
    @Test
    @Story("TC - 47")
    @Description("Удаление новости в панели управления новостями (Позитивный).")
    public void deleteNews() {
        newsControlPanelSteps.verifyNewsControlPanelIsDisplayed();
        newsControlPanelSteps.waitForNewsRecyclerView(3000);
        newsControlPanelSteps.clickDeleteButtonOnNewsItem(0);
        newsControlPanelSteps.clickConfirmDeleteButton();
        newsControlPanelSteps.waitForNewsRecyclerView(3000);
    }

    // TC - 48 - Сортировка новостей по дате (Позитивный)
    @Test
    @Story("TC - 48")
    @Description("Сортировка новостей по дате в панели управления новостями (Позитивный).")
    public void sortNewsByDate() {
        newsControlPanelSteps.verifyNewsControlPanelIsDisplayed();
        newsControlPanelSteps.verifySortButtonIsDisplayed();
        newsControlPanelSteps.sortNewsByDate();
        // Проверяем, что новости отсортированы по дате
        newsControlPanelSteps.checkNewsDate(0, TestConstants.TestDates.SORT_DATE);
    }

    // TC - 49 - Фильтрация активных новостей (Позитивный)
    @Test
    @Story("TC - 49")
    @Description("Фильтрация активных новостей в панели управления новостями (Позитивный).")
    public void filterActiveNews() {
        newsControlPanelSteps.verifyNewsControlPanelIsDisplayed();
        newsControlPanelSteps.verifyFilterButtonIsDisplayed();
        newsControlPanelSteps.filterActiveNews();
        newsControlPanelSteps.verifyNewsListIsDisplayed();
    }

    // TC - 50 - Фильтрация неактивных новостей (Позитивный)
    @Test
    @Story("TC - 50")
    @Description("Фильтрация неактивных новостей в панели управления новостями (Позитивный).")
    public void filterInactiveNews() {
        newsControlPanelSteps.verifyNewsControlPanelIsDisplayed();
        newsControlPanelSteps.verifyFilterButtonIsDisplayed();
        newsControlPanelSteps.filterInactiveNews();
        newsControlPanelSteps.verifyNewsListIsDisplayed();
    }

    // TC - 51 - Проверка отображения новостей в списке с использованием констант
    @Test
    @Story("TC - 51")
    @Description("Проверка корректного отображения новостей в списке управления новостями.")
    public void checkNewsDisplayInList() {
        newsControlPanelSteps.verifyNewsControlPanelIsDisplayed();
        newsControlPanelSteps.waitForNewsRecyclerView(5000);

        // Используем константы вместо магических строк
        newsControlPanelSteps.checkPoolConstructionNews();
        newsControlPanelSteps.checkSalaryAdvanceNews();
        newsControlPanelSteps.checkDonationsNews();
        newsControlPanelSteps.checkVisitNews();
        newsControlPanelSteps.checkAnniversaryNews();
    }

    // TC - 52 - Отмена создания новости (Позитивный)
    @Test
    @Story("TC - 52")
    @Description("Отмена создания новости в панели управления новостями (Позитивный).")
    public void cancelNewsCreation() {
        newsControlPanelSteps.verifyNewsControlPanelIsDisplayed();
        newsControlPanelSteps.clickAddNewsButton();
        onView(isRoot()).perform(waitDisplayed(newsControlPanelSteps.getSaveButtonId(), 3000));
        // ИСПРАВЛЕНО: используем константы вместо магических строк
        newsControlPanelSteps.fillTitleField(TestConstants.TestTitles.TEST_TITLE);
        newsControlPanelSteps.fillDescriptionField(TestConstants.TestTitles.TEST_DESCRIPTION);
        newsControlPanelSteps.clickCancelButton();
        newsControlPanelSteps.waitForAddNewsButton(3000);
        newsControlPanelSteps.verifyAddNewsButtonIsDisplayed();
    }

    // TC - 53 - Переключение статуса активности новости (Позитивный)
    @Test
    @Story("TC - 53")
    @Description("Переключение статуса активности новости в панели управления новостями (Позитивный).")
    public void toggleNewsActiveStatus() {
        newsControlPanelSteps.verifyNewsControlPanelIsDisplayed();
        newsControlPanelSteps.clickAddNewsButton();
        onView(isRoot()).perform(waitDisplayed(newsControlPanelSteps.getSaveButtonId(), 3000));
        // ИСПРАВЛЕНО: используем константы вместо магических строк
        newsControlPanelSteps.fillTitleField(TestConstants.TestTitles.TEST_NEWS_TITLE);
        newsControlPanelSteps.fillDescriptionField(TestConstants.TestTitles.TEST_NEWS_DESCRIPTION);
        newsControlPanelSteps.selectCategory(TestConstants.Categories.ANNOUNCEMENT);
        newsControlPanelSteps.fillDateField(TestConstants.TestDates.TEST_DATE);
        newsControlPanelSteps.fillTimeField(TestConstants.TestDates.TEST_TIME);
        newsControlPanelSteps.toggleActiveSwitch(); // Переключаем статус
        newsControlPanelSteps.clickSaveButton();
        newsControlPanelSteps.waitForNewsRecyclerView(3000);
    }

    // TC - 54 - Создание новости с прошедшей датой (Позитивный)
    @Test
    @Story("TC - 54")
    @Description("Создание новости с прошедшей датой публикации в панели управления новостями (Позитивный).")
    public void createNewsWithPastDate() {
        newsControlPanelSteps.verifyNewsControlPanelIsDisplayed();
        newsControlPanelSteps.createNewsWithPastDate();
        newsControlPanelSteps.waitForNewsRecyclerView(3000);
        newsControlPanelSteps.verifyNewsListIsDisplayed();
    }
}
