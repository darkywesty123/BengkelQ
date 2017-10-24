package com.example.gil.bengkelq;

import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.core.deps.guava.base.CharMatcher.is;
import static android.support.test.espresso.core.deps.guava.base.Predicates.not;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by root on 10/17/17.
 */
@RunWith(AndroidJUnit4.class)
public class Dafbengkel2ActivityTest {

    @Rule
    public ActivityTestRule<Dafbengkel2Activity> daftartestrule = new ActivityTestRule<>(Dafbengkel2Activity.class, true, false);

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

    @After
    public void tearDown() throws Exception {
        Intents.release();
    }

    @Test
    public void cekNamaBengkel() {
        daftartestrule.launchActivity(null);
        onView(withId(R.id.txtNamaBengkel)).perform(typeText(""),closeSoftKeyboard());
        //onView(withId(R.id.BtnSubmitB)).perform(click());
        pauseTestFor(500);
        //onView(withText("Identitas bengkel belum lengkap")).inRoot(new ToastMatcher()).check(matches(isDisplayed()));

    }


    @Test
    public void cekAlamatBengkel() {
        daftartestrule.launchActivity(null);
        onView(withId(R.id.txtNamaBengkel)).perform(typeText("Users"),closeSoftKeyboard());
        onView(withId(R.id.txtAlamatBengkel)).perform(typeText(""),closeSoftKeyboard());
        //onView(withId(R.id.BtnSubmitB)).perform(click());
        pauseTestFor(500);
    }

    @Test
    public void cekDescBengkel() {
        daftartestrule.launchActivity(null);
        onView(withId(R.id.txtNamaBengkel)).perform(typeText("Users"),closeSoftKeyboard());
        onView(withId(R.id.txtAlamatBengkel)).perform(typeText("users@gmail.com"),closeSoftKeyboard());
        onView(withId(R.id.txtDescBengkel)).perform(typeText(""),closeSoftKeyboard());
        //onView(withId(R.id.BtnSubmitB)).perform(click());
        pauseTestFor(500);
        //onView(withText("Identitas bengkel belum lengkap")).inRoot(withDecorView(not(is(daftartestrule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));

    }

    /*@Test
    public void cekNamaPassworddaftar() {
        daftartestrule.launchActivity(null);
        onView(withId(R.id.editTextNamaBengkel)).perform(typeText("Users"),closeSoftKeyboard());
        onView(withId(R.id.editTextAlamatBengkel)).perform(typeText("asdasdasdas"),closeSoftKeyboard());
        onView(withId(R.id.editTextDescBengkel)).perform(typeText("12345678"),closeSoftKeyboard());
        //onView(withId(R.id.BtnSubmitB)).perform(click());
        pauseTestFor(500);
        onView(withText("Identitas bengkel belum lengkap")).inRoot(withDecorView(not(is(daftartestrule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));

    }*/
}