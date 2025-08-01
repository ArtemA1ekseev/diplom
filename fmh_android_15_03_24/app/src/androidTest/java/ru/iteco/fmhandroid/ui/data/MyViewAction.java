package ru.iteco.fmhandroid.ui.data;

import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;

import android.view.View;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.matcher.ViewMatchers;

import org.hamcrest.Matcher;

/**
 * Класс для создания кастомных действий ViewAction
 */
public class MyViewAction {

    /**
     * Создает ViewAction для клика по дочернему элементу с определенным ID
     * @param id ID дочернего элемента для клика
     * @return ViewAction для выполнения клика
     */
    public static ViewAction clickChildViewWithId(final int id) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return null;
            }

            @Override
            public String getDescription() {
                return "Click on a child view with specified id.";
            }

            @Override
            public void perform(UiController uiController, View view) {
                View v = view.findViewById(id);
                if (v != null) {
                    v.performClick();
                }
            }
        };
    }

    /**
     * ViewAction для получения текста из TextView
     * @param stringHolder массив для хранения полученного текста
     * @return ViewAction для получения текста
     */
    public static ViewAction getText(final String[] stringHolder) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isAssignableFrom(android.widget.TextView.class);
            }

            @Override
            public String getDescription() {
                return "getting text from a TextView";
            }

            @Override
            public void perform(UiController uiController, View view) {
                android.widget.TextView tv = (android.widget.TextView) view;
                stringHolder[0] = tv.getText().toString();
            }
        };
    }

    /**
     * ViewAction для длительного нажатия на элемент
     * @return ViewAction для длительного нажатия
     */
    public static ViewAction longClick() {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return ViewMatchers.isEnabled();
            }

            @Override
            public String getDescription() {
                return "long click";
            }

            @Override
            public void perform(UiController uiController, View view) {
                view.performLongClick();
            }
        };
    }
}
