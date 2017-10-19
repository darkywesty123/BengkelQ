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
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

/**
 * Created by root on 10/17/17.
 */
@RunWith(AndroidJUnit4.class)
public class DafbengkelActivityTest {


    @Rule
    public ActivityTestRule<DafbengkelActivity> daftartestrule = new ActivityTestRule<>(DafbengkelActivity.class, true, false);

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
    public void cekNama() {
        daftartestrule.launchActivity(null);
        onView(withId(R.id.editTextNamaPemilik)).perform(typeText(""),closeSoftKeyboard());
        onView(withId(R.id.BtnLanjut1)).perform(click());
        pauseTestFor(500);
        //onView(withText("Identitas pemilik belum lengkap")).inRoot(withDecorView(not(is(daftartestrule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
    }
    @Test
    public void cekNamaEmail() {
        daftartestrule.launchActivity(null);
        onView(withId(R.id.editTextNamaPemilik)).perform(typeText("wqweqwe"),closeSoftKeyboard());
        onView(withId(R.id.editTextEmailBengkel)).perform(typeText(""),closeSoftKeyboard());
        //onView(withId(R.id.BtnLanjut1)).perform(click());
        pauseTestFor(500);
        //onView(withText("Identitas pemilik belum lengkap")).inRoot(withDecorView(not(is(daftartestrule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
    }
    @Test
    public void cekNamaEmailPass() {
        daftartestrule.launchActivity(null);
        onView(withId(R.id.editTextNamaPemilik)).perform(typeText("wqeqwewq"),closeSoftKeyboard());
        onView(withId(R.id.editTextEmailBengkel)).perform(typeText("123123123@afa.vd"),closeSoftKeyboard());
        onView(withId(R.id.editTextPasswordBengkel)).perform(typeText(""),closeSoftKeyboard());
        //onView(withId(R.id.BtnLanjut1)).perform(click());
        pauseTestFor(500);

        //onView(withText("Identitas pemilik belum lengkap")).inRoot(withDecorView(not(is(daftartestrule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
    }
    @Test
    public void cekNamaEmailPassPhone() {
        daftartestrule.launchActivity(null);
        onView(withId(R.id.editTextNamaPemilik)).perform(typeText("qweqwewqe"),closeSoftKeyboard());
        onView(withId(R.id.editTextEmailBengkel)).perform(typeText("qweqwe@dsad.sad"),closeSoftKeyboard());
        onView(withId(R.id.editTextPasswordBengkel)).perform(typeText("123123123"),closeSoftKeyboard());
        onView(withId(R.id.editTextPhoneBengkel)).perform(typeText(""),closeSoftKeyboard());
        //onView(withId(R.id.BtnLanjut1)).perform(click());
        pauseTestFor(500);
        //onView(withText("Identitas pemilik belum lengkap")).inRoot(withDecorView(not(is(daftartestrule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
    }

    @Test
    public void testDaftar1(){
        daftartestrule.launchActivity(null);
        onView(withId(R.id.editTextNamaPemilik)).perform(typeText("Pemilik Bengkel 1"),closeSoftKeyboard());
        onView(withId(R.id.editTextEmailBengkel)).perform(typeText("bengkelbengkel2@gmail.com"),closeSoftKeyboard());
        onView(withId(R.id.editTextPasswordBengkel)).perform(typeText("pemilik1"),closeSoftKeyboard());
        onView(withId(R.id.editTextPhoneBengkel)).perform(typeText("081234234234"),closeSoftKeyboard());
        onView(withId(R.id.BtnLanjut1)).perform(click());
        pauseTestFor(2000);
        onView(withId(R.id.editTextNamaBengkel)).perform(typeText("Pemilik"),closeSoftKeyboard(),closeSoftKeyboard());
        onView(withId(R.id.editTextAlamatBengkel)).perform(typeText("Almata bengkel"),closeSoftKeyboard(),closeSoftKeyboard());
        onView(withId(R.id.editTextDescBengkel)).perform(typeText("desc bengkel"),closeSoftKeyboard(),closeSoftKeyboard());
        onView(withId(R.id.BtnSubmitB)).perform(click());
        pauseTestFor(2000);
    }

}