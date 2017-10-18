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
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by root on 10/15/17.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    private int wait = 500;
    private int waitLong = 5000;
    private String formKurang = "Silahkan mengisi form dengan lengkap";
    private String registrasiGagal = "Email sudah terdaftar";

    @Rule
    public ActivityTestRule<MainActivity> logintestrule = new ActivityTestRule<>(MainActivity.class, true, false);
    private IntentsTestRule<MainActivity> testpindah = new IntentsTestRule<>(MainActivity.class, true, false);


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
    public void zloginWithData() throws Exception {
        FirebaseAuth.getInstance().signOut();
        logintestrule.launchActivity(null);
        onView(withId(R.id.editTextEmail)).perform(typeText("user1@gmail.com"), closeSoftKeyboard());
        onView(withId(R.id.editTextPassword)).perform(typeText("user1111"), closeSoftKeyboard());
        onView(withId(R.id.BtnLogin)).perform(click());
        pauseTestFor(waitLong);
        intended(hasComponent(HomeActivity.class.getName()));
    }

    @Test
    public void zloginWithData2() throws Exception {
        FirebaseAuth.getInstance().signOut();
        logintestrule.launchActivity(null);
        onView(withId(R.id.editTextEmail)).perform(typeText("pemilik1@gmail.com"), closeSoftKeyboard());
        onView(withId(R.id.editTextPassword)).perform(typeText("pemilik1"), closeSoftKeyboard());
        onView(withId(R.id.BtnLogin)).perform(click());
        pauseTestFor(waitLong);
        intended(hasComponent(HomebklActivity.class.getName()));
    }
    /*@Test
    public void cekLoginSukses() {
        logintestrule.launchActivity(null);
        onView(withId(R.id.editTextEmail)).perform(typeText("user1@gmail.com"),closeSoftKeyboard());
        onView(withId(R.id.editTextPassword)).perform(typeText("user1111"),closeSoftKeyboard());
        onView(withId(R.id.BtnLogin)).perform(click());
        pauseTestFor(waitLong);
        Intents.release();
    }
    @Test
    public void cekLoginSuksesPemilik() {
        logintestrule.launchActivity(null);
        onView(withId(R.id.editTextEmail)).perform(typeText("pemilik1@gmail.com"),closeSoftKeyboard());
        onView(withId(R.id.editTextPassword)).perform(typeText("pemilik1"),closeSoftKeyboard());
        onView(withId(R.id.BtnLogin)).perform(click());
        pauseTestFor(waitLong);
        Intents.release();
    }*/

    @After
    public void tearDown() throws Exception {
        Intents.release();
    }
}