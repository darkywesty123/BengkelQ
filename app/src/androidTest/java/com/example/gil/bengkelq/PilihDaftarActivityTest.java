package com.example.gil.bengkelq;

import static android.support.test.espresso.matcher.ViewMatchers.withId;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;

@RunWith(AndroidJUnit4.class)
public class PilihDaftarActivityTest {
    @Rule
    public ActivityTestRule<PilihDaftarActivity> mActivityRule = new ActivityTestRule<>(PilihDaftarActivity.class);

    @Test
    public void testBtnUser(){
        onView(withId(R.id.BtnPengguna)).perform(click());
    }

    @Test
    public void testBtnPemilik(){
        onView(withId(R.id.BtnBengkel)).perform(click());
    }
}