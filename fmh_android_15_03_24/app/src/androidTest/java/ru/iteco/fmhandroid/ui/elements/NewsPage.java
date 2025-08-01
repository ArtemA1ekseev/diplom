package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.ui.data.TestConstants;

/**
 * Page Object для списка новостей
 */
public class NewsPage {

    public final ViewInteraction newsTabButton;

    public NewsPage() {
        // Используем текст из констант для надёжности
        newsTabButton = onView(allOf(
                withId(android.R.id.title),
                withText(TestConstants.CommonTexts.NEWS)
        ));
    }

    // Геттер ID, если потребуется в шагах
    public int getNewsTabButtonId() {
        return android.R.id.title;
    }
}
