package com.example.gil.bengkelq;

import android.os.Bundle;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by root on 10/15/17.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity>  mActivityRule = new ActivityTestRule<>(MainActivity.class);

    /*@Test
    public void testRegister(){
        MainActivity mainActivity = new MainActivity();
        S
        onView(withId(R.id.editTextEmail)).perform(typeText("user1@gmail.com"));
        onView(withId(R.id.editTextPassword)).perform(typeText("user1111"));
        onView(withId(R.id.BtnLogin)).perform(click());
    }*/
}