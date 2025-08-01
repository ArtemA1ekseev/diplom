package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.TestConstants;

public class AuthorizationPage {

    public ViewInteraction getAuthorizationElementsButton;
    public ViewInteraction getAuthorizationElementsLoginField;
    public ViewInteraction getAuthorizationElementsPasswordField;
    public ViewInteraction getAuthorizationElementsButtonExit;
    public ViewInteraction getAuthorizationElementsButtonLogOut;
    public ViewInteraction getAuthorizationElementsTextAuthorization;

    public int loginField;
    public int loginLayout;
    public int enterButton;
    public int authorizationImageButton;

    // ИСПРАВЛЕНО: данные теперь используют константы
    public static String rightLogin;
    public static String rightPassword;
    public static String unregisteredLogin;
    public static String loginWithSpecialCharacters;
    public static String oneLetterLogin;
    public static String differentRegexLogin;
    public static String unregisteredPassword;
    public static String passwordWithSpecialCharacters;
    public static String oneLetterPassword;
    public static String differentRegexPassword;

    public AuthorizationPage() {
        getAuthorizationElementsButton = onView(withId(R.id.enter_button));
        getAuthorizationElementsLoginField = onView(allOf(withHint("Login"), withParent(withParent(withId(R.id.login_text_input_layout)))));
        getAuthorizationElementsPasswordField = onView(allOf(withHint("Password"), withParent(withParent(withId(R.id.password_text_input_layout)))));
        getAuthorizationElementsButtonExit = onView(withId(R.id.authorization_image_button));
        getAuthorizationElementsButtonLogOut = onView(allOf(withId(android.R.id.title), withText(TestConstants.CommonTexts.LOG_OUT)));
        getAuthorizationElementsTextAuthorization = onView(allOf(withText(TestConstants.CommonTexts.AUTHORIZATION), withParent(withParent(withId(R.id.nav_host_fragment)))));

        loginField = R.id.login_text_input_layout;
        loginLayout = R.id.login_text_input_layout;
        enterButton = R.id.enter_button;
        authorizationImageButton = R.id.authorization_image_button;

        // ИСПРАВЛЕНО: теперь данные используют константы из TestConstants
        rightLogin = TestConstants.LoginData.RIGHT_LOGIN;
        rightPassword = TestConstants.LoginData.RIGHT_PASSWORD;
        unregisteredLogin = TestConstants.LoginData.UNREGISTERED_LOGIN;
        loginWithSpecialCharacters = TestConstants.LoginData.LOGIN_WITH_SPECIAL_CHARACTERS;
        oneLetterLogin = TestConstants.LoginData.ONE_LETTER_LOGIN;
        differentRegexLogin = TestConstants.LoginData.DIFFERENT_REGEX_LOGIN;
        unregisteredPassword = TestConstants.LoginData.UNREGISTERED_PASSWORD;
        passwordWithSpecialCharacters = TestConstants.LoginData.PASSWORD_WITH_SPECIAL_CHARACTERS;
        oneLetterPassword = TestConstants.LoginData.ONE_LETTER_PASSWORD;
        differentRegexPassword = TestConstants.LoginData.DIFFERENT_REGEX_PASSWORD;
    }
}
