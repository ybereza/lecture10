package com.my.examples.lecture4;

import android.app.Activity;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.TextView;

import junit.framework.Assert;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ServiceActivityTest {
    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(ServiceActivity.class, true, false);

    @Test
    public void initialState() throws Throwable {
        final Activity activity = mActivityRule.launchActivity(new Intent(InstrumentationRegistry.getTargetContext(), ServiceActivity.class));
        InstrumentationRegistry.getInstrumentation().waitForIdleSync();
        mActivityRule.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                TextView textView = (TextView)activity.findViewById(R.id.textView);
                Assert.assertEquals(textView.getText(), "");
            }
        });
    }
}
