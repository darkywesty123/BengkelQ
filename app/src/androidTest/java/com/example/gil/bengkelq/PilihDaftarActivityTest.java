package com.example.gil.bengkelq;

import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;

@RunWith(AndroidJUnit4.class)
public class PilihDaftarActivityTest {


    public IntentsTestRule<PilihDaftarActivity> testintent = new IntentsTestRule<>(PilihDaftarActivity.class, true, false);

    private void pauseTestFor(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDaftarPengguna()throws Exception {
        testintent.launchActivity(null);
        onView(withId(R.id.BtnPengguna)).perform(click());
        pauseTestFor(500);
        intended(hasComponent(DafpenggunaActivity.class.getName()));
        Intents.release();
    }

    @Test
    public void testDaftarPemilik()throws Exception{
        testintent.launchActivity(null);
        onView(withId(R.id.BtnBengkel)).perform(click());
        pauseTestFor(500);
        intended(hasComponent(DafbengkelActivity.class.getName()));
        Intents.release();
    }
}