package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.TestConstants;

/**
 * Главная страница приложения
 */
public class MainPage {

    // ViewInteraction элементы
    public final ViewInteraction allNewsButtonInteraction;
    public final ViewInteraction mainMenuButtonInteraction;
    public final ViewInteraction newsTitleInteraction;
    public final ViewInteraction expandNewsButtonInteraction;

    // ID элементов для Steps
    public final int allNewsButtonId;
    public final int mainMenuButtonId;
    public final int newsTitleId;
    public final int expandNewsButtonId;
    public final int containerListNewsId;

    public MainPage() {
        // Инициализация ViewInteraction элементов
        allNewsButtonInteraction = onView(withId(R.id.all_news_text_view));
        mainMenuButtonInteraction = onView(withId(R.id.main_menu_image_button));
        newsTitleInteraction = onView(withText(TestConstants.NewsTexts.NEWS_TITLE));
        expandNewsButtonInteraction = onView(withId(R.id.expand_material_button));

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

    public int getNewsTitleId() {
        return newsTitleId;
    }

    public int getExpandNewsButtonId() {
        return expandNewsButtonId;
    }

    public int getContainerListNewsId() {
        return containerListNewsId;
    }
}
