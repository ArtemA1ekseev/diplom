package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static ru.iteco.fmhandroid.ui.data.DataHelper.withIndex;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

/**
 * Page Object для страницы тематических цитат
 */
public class ThematicQuotePage {

    public final ViewInteraction missionButton;
    public final ViewInteraction missionTitle;
    public final ViewInteraction expandMissionButton;
    public final int missionImageButtonId;

    public ThematicQuotePage() {
        missionButton = onView(withId(R.id.our_mission_image_button));
        missionTitle = onView(withId(R.id.our_mission_title_text_view));
        expandMissionButton = onView(withIndex(
                withId(R.id.our_mission_item_open_card_image_button), 0
        ));
        missionImageButtonId = R.id.our_mission_image_button;
    }
}
