package com.example.gil.bengkelq;

import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class AwalActivityTest {


    public IntentsTestRule<AwalActivity> testintent = new IntentsTestRule<>(AwalActivity.class, true, false);

    private void pauseTestFor(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testMasuk()throws Exception{
        testintent.launchActivity(null);
        onView(withId(R.id.BtnLoginAwal)).perform(click());
        pauseTestFor(500);
        intended(hasComponent(MainActivity.class.getName()));
        Intents.release();
    }

    @Test
    public void testDaftar()throws Exception{
        testintent.launchActivity(null);
        onView(withId(R.id.BtnRegisterAwal)).perform(click());
        pauseTestFor(500);
        intended(hasComponent(PilihDaftarActivity.class.getName()));
        Intents.release();
    }
}
