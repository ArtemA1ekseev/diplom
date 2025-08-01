package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.TestConstants;

/**
 * Класс Page Object для страницы управления новостями
 * Содержит все UI элементы и их ID для использования в Steps
 */
public class NewsControlPanelPage {

    public ViewInteraction newsControlPanelTitle;
    public ViewInteraction addNewsButton;
    public ViewInteraction editButton;
    public ViewInteraction deleteButton;
    public ViewInteraction sortButton;
    public ViewInteraction filterButton;
    public ViewInteraction newsItemTitle;
    public ViewInteraction newsItemDescription;
    public ViewInteraction newsItemDate;
    public ViewInteraction newsItemCategory;
    public ViewInteraction saveButton;
    public ViewInteraction cancelButton;
    public ViewInteraction titleField;
    public ViewInteraction descriptionField;
    public ViewInteraction categoryDropdown;
    public ViewInteraction dateField;
    public ViewInteraction timeField;
    public ViewInteraction switcherActive;
    public ViewInteraction confirmDeleteButton;
    public ViewInteraction newsRecyclerView;
    public ViewInteraction emptyNewsListText;

    public int newsControlPanelTitleId;
    public int addNewsButtonId;
    public int editButtonId;
    public int deleteButtonId;
    public int sortButtonId;
    public int filterButtonId;
    public int newsItemTitleId;
    public int newsItemDescriptionId;
    public int newsItemDateId;
    public int newsItemCategoryId;
    public int saveButtonId;
    public int cancelButtonId;
    public int titleFieldId;
    public int descriptionFieldId;
    public int categoryDropdownId;
    public int dateFieldId;
    public int timeFieldId;
    public int switcherActiveId;
    public int confirmDeleteButtonId;
    public int newsRecyclerViewId;
    public int emptyNewsListTextId;

    // ИСПРАВЛЕНО: данные теперь используют константы
    public static String validNewsTitle;
    public static String validNewsDescription;
    public static String validNewsCategory;
    public static String validNewsDate;
    public static String validNewsTime;
    public static String invalidNewsTitle;
    public static String invalidNewsDescription;
    public static String emptyTitle;
    public static String emptyDescription;
    public static String longTitle;
    public static String longDescription;
    public static String specialCharactersTitle;
    public static String specialCharactersDescription;
    public static String futureDate;
    public static String pastDate;
    public static String invalidDate;
    public static String invalidTime;

    public NewsControlPanelPage() {
        newsControlPanelTitle = onView(allOf(withText(TestConstants.NewsTexts.NEWS_TITLE),
                withParent(withParent(withId(R.id.nav_host_fragment)))));

        addNewsButton = onView(allOf(withId(R.id.add_news_image_view),
                withContentDescription("Add news button")));

        editButton = onView(allOf(withId(R.id.edit_news_item_image_view),
                withContentDescription("Edit news")));

        deleteButton = onView(allOf(withId(R.id.delete_news_item_image_view),
                withContentDescription("Delete news")));

        sortButton = onView(allOf(withId(R.id.sort_news_material_button),
                withContentDescription("Sort news button")));

        filterButton = onView(allOf(withId(R.id.filter_news_material_button),
                withContentDescription("Filter news")));

        newsItemTitle = onView(withId(R.id.news_item_title_text_view));
        newsItemDescription = onView(withId(R.id.news_item_description_text_view));
        newsItemDate = onView(withId(R.id.news_item_date_text_view));
        newsItemCategory = onView(withId(R.id.news_item_category_text_auto_complete_text_view));

        saveButton = onView(allOf(withId(R.id.save_button), withText(TestConstants.CommonTexts.SAVE)));
        cancelButton = onView(withId(R.id.cancel_button));

        titleField = onView(withId(R.id.news_item_title_text_input_edit_text));
        descriptionField = onView(withId(R.id.news_item_description_text_input_edit_text));
        categoryDropdown = onView(withId(R.id.news_item_category_text_auto_complete_text_view));
        dateField = onView(withId(R.id.news_item_publish_date_text_input_edit_text));
        timeField = onView(withId(R.id.news_item_publish_time_text_input_edit_text));
        switcherActive = onView(withId(R.id.switcher));

        // ИСПРАВЛЕНО: используем константу вместо магической строки "OK"
        confirmDeleteButton = onView(allOf(withId(android.R.id.button1), withText(TestConstants.CommonTexts.OK)));

        newsRecyclerView = onView(withId(R.id.news_list_recycler_view));
        emptyNewsListText = onView(withId(R.id.empty_news_list_text_view));

        newsControlPanelTitleId = R.id.container_list_news_include_on_fragment_main;
        addNewsButtonId = R.id.add_news_image_view;
        editButtonId = R.id.edit_news_item_image_view;
        deleteButtonId = R.id.delete_news_item_image_view;
        sortButtonId = R.id.sort_news_material_button;
        filterButtonId = R.id.filter_news_material_button;
        newsItemTitleId = R.id.news_item_title_text_view;
        newsItemDescriptionId = R.id.news_item_description_text_view;
        newsItemDateId = R.id.news_item_date_text_view;
        newsItemCategoryId = R.id.news_item_category_text_auto_complete_text_view;
        saveButtonId = R.id.save_button;
        cancelButtonId = R.id.cancel_button;
        titleFieldId = R.id.news_item_title_text_input_edit_text;
        descriptionFieldId = R.id.news_item_description_text_input_edit_text;
        categoryDropdownId = R.id.news_item_category_text_auto_complete_text_view;
        dateFieldId = R.id.news_item_publish_date_text_input_edit_text;
        timeFieldId = R.id.news_item_publish_time_text_input_edit_text;
        switcherActiveId = R.id.switcher;
        confirmDeleteButtonId = android.R.id.button1;
        newsRecyclerViewId = R.id.news_list_recycler_view;
        emptyNewsListTextId = R.id.empty_news_list_text_view;

        // ИСПРАВЛЕНО: теперь данные используют константы из TestConstants
        validNewsTitle = TestConstants.NewsData.VALID_NEWS_TITLE;
        validNewsDescription = TestConstants.NewsData.VALID_NEWS_DESCRIPTION;
        validNewsCategory = TestConstants.NewsData.VALID_NEWS_CATEGORY;
        validNewsDate = TestConstants.NewsData.VALID_NEWS_DATE;
        validNewsTime = TestConstants.NewsData.VALID_NEWS_TIME;

        invalidNewsTitle = TestConstants.NewsData.EMPTY_TITLE;
        invalidNewsDescription = TestConstants.NewsData.EMPTY_DESCRIPTION;
        emptyTitle = TestConstants.NewsData.EMPTY_TITLE;
        emptyDescription = TestConstants.NewsData.EMPTY_DESCRIPTION;

        longTitle = TestConstants.NewsData.LONG_TITLE;
        longDescription = TestConstants.NewsData.LONG_DESCRIPTION;

        specialCharactersTitle = TestConstants.NewsData.SPECIAL_CHARACTERS_TITLE;
        specialCharactersDescription = TestConstants.NewsData.SPECIAL_CHARACTERS_DESCRIPTION;

        futureDate = TestConstants.TestDates.FUTURE_DATE;
        pastDate = TestConstants.NewsData.PAST_DATE;
        invalidDate = TestConstants.NewsData.INVALID_DATE;
        invalidTime = TestConstants.NewsData.INVALID_TIME;
    }

    // Методы доступа остаются те же...
    public int getNewsItemTitleId() {
        return newsItemTitleId;
    }

    public int getNewsItemDescriptionId() {
        return newsItemDescriptionId;
    }

    public int getNewsItemDateId() {
        return newsItemDateId;
    }

    public int getAddNewsButtonId() {
        return addNewsButtonId;
    }

    public int getEditButtonId() {
        return editButtonId;
    }

    public int getDeleteButtonId() {
        return deleteButtonId;
    }

    public int getSaveButtonId() {
        return saveButtonId;
    }

    public int getNewsRecyclerViewId() {
        return newsRecyclerViewId;
    }

    public static String getValidNewsTitle() {
        return validNewsTitle;
    }

    public static String getValidNewsDescription() {
        return validNewsDescription;
    }

    public static String getValidNewsCategory() {
        return validNewsCategory;
    }

    public static String getValidNewsDate() {
        return validNewsDate;
    }

    public static String getValidNewsTime() {
        return validNewsTime;
    }

    public static String getEmptyTitle() {
        return emptyTitle;
    }

    public static String getEmptyDescription() {
        return emptyDescription;
    }

    public static String getLongTitle() {
        return longTitle;
    }

    public static String getLongDescription() {
        return longDescription;
    }

    public static String getSpecialCharactersTitle() {
        return specialCharactersTitle;
    }

    public static String getSpecialCharactersDescription() {
        return specialCharactersDescription;
    }

    public static String getFutureDate() {
        return futureDate;
    }

    public static String getPastDate() {
        return pastDate;
    }

    public static String getInvalidDate() {
        return invalidDate;
    }

    public static String getInvalidTime() {
        return invalidTime;
    }
}
