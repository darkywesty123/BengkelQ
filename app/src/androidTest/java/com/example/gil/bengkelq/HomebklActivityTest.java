package com.example.gil.bengkelq;

import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Created by root on 10/17/17.
 */
@RunWith(AndroidJUnit4.class)
public class HomebklActivityTest
{
    @Rule
    public ActivityTestRule<HomebklActivity> mActivityRule = new ActivityTestRule<>(HomebklActivity.class);

    @Test
    public void testKeluar(){
        onView(withId(R.id.keluar)).perform(click());
    }

    /*@Test
    public void testHelp(){
        onView(withId(R.id.help)).perform(click());
    }*/

    @Test
    public void pressBack() {
        onView(isRoot()).perform(ViewActions.pressBack());
    }

}