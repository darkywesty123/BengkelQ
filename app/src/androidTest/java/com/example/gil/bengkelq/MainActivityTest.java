package com.example.gil.bengkelq;

import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.google.firebase.auth.FirebaseAuth;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by root on 10/15/17.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    private int wait = 500;
    private int waitLong = 5000;

    @Rule
    public ActivityTestRule<MainActivity> logintestrule = new ActivityTestRule<>(MainActivity.class, true, false);

    private void pauseTestFor(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Before
    public void setUp() throws Exception {
        Intents.init();
        FirebaseAuth.getInstance().signOut();
    }


    @Test
    public void loginUser() throws Exception {
        FirebaseAuth.getInstance().signOut();
        logintestrule.launchActivity(null);
        onView(withId(R.id.txtEmail)).perform(typeText("user1@gmail.com"), closeSoftKeyboard());
        onView(withId(R.id.txtPassword)).perform(typeText("user1111"), closeSoftKeyboard());
        onView(withId(R.id.BtnLogin)).perform(click());
        pauseTestFor(wait);
        intended(hasComponent(HomeActivity.class.getName()));
    }

    @Test
    public void loginPemilik() throws Exception {
        FirebaseAuth.getInstance().signOut();
        logintestrule.launchActivity(null);
        onView(withId(R.id.txtEmail)).perform(typeText("pemilik1@gmail.com"), closeSoftKeyboard());
        onView(withId(R.id.txtPassword)).perform(typeText("pemilik1"), closeSoftKeyboard());
        onView(withId(R.id.BtnLogin)).perform(click());
        pauseTestFor(wait);
        intended(hasComponent(HomebklActivity.class.getName()));
    }

    @Test
    public void loginWrongUser() throws Exception {
        FirebaseAuth.getInstance().signOut();
        logintestrule.launchActivity(null);
        onView(withId(R.id.txtEmail)).perform(typeText("usersalah@gmail.com"), closeSoftKeyboard());
        onView(withId(R.id.txtPassword)).perform(typeText("user1111"), closeSoftKeyboard());
        onView(withId(R.id.BtnLogin)).perform(click());
        pauseTestFor(wait);
    }

    @After
    public void tearDown() throws Exception {
        Intents.release();
    }
}