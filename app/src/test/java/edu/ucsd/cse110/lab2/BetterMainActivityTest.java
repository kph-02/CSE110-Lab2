package edu.ucsd.cse110.lab2;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.junit.Assert.assertEquals;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;



import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.matcher.ViewMatchers;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;


import android.widget.TextView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;


@Config(
        instrumentedPackages = {
                // required to access final members on androidx.loader.content.ModernAsyncTask
                "androidx.loader.content"
        })

@RunWith(RobolectricTestRunner.class)
public class BetterMainActivityTest {
        @Test
        public void test_one_plus_one_equals_two() {
                try(ActivityScenario<MainActivity> scenario = ActivityScenario.launch(MainActivity.class)) {
                        scenario.moveToState(Lifecycle.State.CREATED);
                        scenario.moveToState(Lifecycle.State.STARTED);
                        scenario.onActivity(activity -> {
                                activity.findViewById(R.id.btn_one).performClick();
                                activity.findViewById(R.id.btn_plus).performClick();
                                activity.findViewById(R.id.btn_one).performClick();
                                activity.findViewById(R.id.btn_equals).performClick();
                                TextView resultView = (TextView) activity.findViewById(R.id.display);
                                assertEquals("2",resultView.getText());
                        });
                }
        }
}
