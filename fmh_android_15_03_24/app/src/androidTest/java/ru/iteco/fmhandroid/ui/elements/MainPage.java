package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.TestConstants;

public class MainPage {

    // ViewInteraction элементы
    public ViewInteraction allNewsButton;
    public ViewInteraction mainMenuButton;
    public ViewInteraction newsTitle;
    public ViewInteraction expandNewsButton;

    // ID элементы для Steps
    public int allNewsButtonId;
    public int mainMenuButtonId;
    public int newsTitleId;
    public int expandNewsButtonId;
    public int containerListNewsId;

    public MainPage() {
        // Инициализация ViewInteraction элементов
        allNewsButton = onView(withText(TestConstants.NewsTexts.ALL_NEWS));
        mainMenuButton = onView(withId(R.id.main_menu_image_button));
        newsTitle = onView(withText(TestConstants.NewsTexts.NEWS_TITLE));
        expandNewsButton = onView(withId(R.id.expand_material_button));

        // Инициализация ID элементов
        allNewsButtonId = R.id.all_news_text_view;
        mainMenuButtonId = R.id.main_menu_image_button;
        newsTitleId = R.id.container_list_news_include_on_fragment_main;
        expandNewsButtonId = R.id.expand_material_button;
        containerListNewsId = R.id.container_list_news_include_on_fragment_main;
    }

    // Методы для получения ID
    public int getAllNewsButtonId() {
        return allNewsButtonId;
    }

    public int getMainMenuButtonId() {
        return mainMenuButtonId;
    }

    public int getContainerListNewsId() {
        return containerListNewsId;
    }
}
