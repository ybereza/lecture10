/**
 * Copyrigh Mail.ru Games (c) 2015
 * Created by y.bereza.
 */
package com.my.examples.lecture4;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class ServiceActivityTestWithEspresso {
	@Rule
	public ActivityTestRule mActivityRule = new ActivityTestRule<>(ServiceActivity.class);

	@Test
	public void testServiceConnection() throws InterruptedException {
		onView(withId(R.id.connect)).perform(click());
		Thread.sleep(TimeUnit.SECONDS.toMillis(2));
		onView(withId(R.id.textView)).check(matches(withText("Hello from Service!")));
	}
}
