package com.example.gil.bengkelq;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class AwalActivityTest {
    @Rule
    public ActivityTestRule<AwalActivity> mActivityRule = new ActivityTestRule<>(AwalActivity.class);

    @Test
    public void testBtnMasuk(){
        onView(withId(R.id.BtnLoginAwal)).perform(click());
    }
    public void testBtnDaftar(){
        onView(withId(R.id.BtnRegisterAwal)).perform(click());
    }
}

