/**
 * Copyrigh Mail.ru Games (c) 2015
 * Created by y.bereza.
 */
package com.my.examples.lecture4;

import android.support.test.rule.ActivityTestRule;
import android.support.v7.widget.RecyclerView;

import org.junit.Rule;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
//import static android.support.test.espresso.contrib.RecyclerViewActions;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.equalTo;

public class EspressoDataAdapterTest {
	@Rule
	public ActivityTestRule mActivityRule = new ActivityTestRule<>(MainActivity.class);

	@Test
	public void testItemExistsOnScreen() {
		//onView(withClassName(equalTo(RecyclerView.class.getSimpleName()))).perform(RecyclerViewActions.actionOnItemAtPosition(2, click()));
	}

	@Test
	public void testItemDoesnotExistsOnScreen() {

	}
}
