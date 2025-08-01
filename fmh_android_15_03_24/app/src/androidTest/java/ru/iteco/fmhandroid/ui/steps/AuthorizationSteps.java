// AuthorizationSteps.java
package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.elements.AuthorizationPage;

public class AuthorizationSteps {

    private final AuthorizationPage authorizationPage = new AuthorizationPage();

    public void loadAuthorizationPage() {
        Allure.step("Загрузка страницы авторизации");
        onView(isRoot())
                .perform(waitDisplayed(authorizationPage.enterButtonId, 5000));
    }

    public void clickButtonSignIn() {
        Allure.step("Нажать на кнопку Войти");
        authorizationPage.enterButtonInteraction.perform(click());
    }

    public void clickButtonExit() {
        Allure.step("Нажать на кнопку Выход");
        authorizationPage.exitButtonInteraction.perform(click());
    }

    public void clickButtonLogOut() {
        Allure.step("Нажать на кнопку для выхода из приложения");
        authorizationPage.logOutButtonInteraction.perform(click());
    }

    public void textAuthorization() {
        Allure.step("Отобразилась страница Авторизации");
        authorizationPage.authorizationTextInteraction.check(matches(isDisplayed()));
    }

    public void fillLoginField(String text) {
        Allure.step("Поле Логин — ввод данных: " + text);
        authorizationPage.loginFieldInteraction.perform(replaceText(text));
    }

    public void fillPasswordField(String text) {
        Allure.step("Поле Пароль — ввод данных: " + text);
        authorizationPage.passwordFieldInteraction.perform(replaceText(text));
    }

    public int getAuthorizationImageButtonId() {
        return authorizationPage.authorizationImageButtonId;
    }

    public int getLoginLayoutId() {
        return authorizationPage.loginLayout;
    }

    public int getEnterButtonId() {
        return authorizationPage.enterButtonId;
    }

    public static String getLogin() {
        return AuthorizationPage.rightLogin;
    }

    public static String getPassword() {
        return AuthorizationPage.rightPassword;
    }

    public static String getUnregisteredLogin() {
        return AuthorizationPage.unregisteredLogin;
    }

    public static String getLoginWithSpecialCharacters() {
        return AuthorizationPage.loginWithSpecialCharacters;
    }

    public static String getOneLetterLogin() {
        return AuthorizationPage.oneLetterLogin;
    }

    public static String getDifferentRegexLogin() {
        return AuthorizationPage.differentRegexLogin;
    }

    public static String getUnregisteredPassword() {
        return AuthorizationPage.unregisteredPassword;
    }

    public static String getPasswordWithSpecialCharacters() {
        return AuthorizationPage.passwordWithSpecialCharacters;
    }

    public static String getOneLetterPassword() {
        return AuthorizationPage.oneLetterPassword;
    }

    public static String getDifferentRegexPassword() {
        return AuthorizationPage.differentRegexPassword;
    }
}
