package com.example.gil.bengkelq;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Created by root on 10/17/17.
 */
@RunWith(AndroidJUnit4.class)
public class DafbengkelActivityTest {


    @Rule
    public ActivityTestRule<DafbengkelActivity> daftartestrule = new ActivityTestRule<>(DafbengkelActivity.class, true, false);
    public IntentsTestRule<DafbengkelActivity> daftarintent = new IntentsTestRule<>(DafbengkelActivity.class, true, false);

    private void pauseTestFor(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void cekNama() {
        daftartestrule.launchActivity(null);
        onView(withId(R.id.editTextNamaPemilik)).perform(typeText(""),closeSoftKeyboard());
        onView(withId(R.id.BtnLanjut1)).perform(click());
        pauseTestFor(500);
    }
    @Test
    public void cekNamaEmail() {
        daftartestrule.launchActivity(null);
        onView(withId(R.id.editTextNamaPemilik)).perform(typeText("wqweqwe"),closeSoftKeyboard());
        onView(withId(R.id.editTextEmailBengkel)).perform(typeText(""),closeSoftKeyboard());
        onView(withId(R.id.BtnLanjut1)).perform(click());
        pauseTestFor(500);
    }
    @Test
    public void cekNamaEmailPass() {
        daftartestrule.launchActivity(null);
        onView(withId(R.id.editTextNamaPemilik)).perform(typeText("wqeqwewq"),closeSoftKeyboard());
        onView(withId(R.id.editTextEmailBengkel)).perform(typeText("123123123@afa.vd"),closeSoftKeyboard());
        onView(withId(R.id.editTextPasswordBengkel)).perform(typeText(""),closeSoftKeyboard());
        onView(withId(R.id.BtnLanjut1)).perform(click());
        pauseTestFor(500);
    }
    @Test
    public void cekNamaEmailPassPhone() {
        daftartestrule.launchActivity(null);
        onView(withId(R.id.editTextNamaPemilik)).perform(typeText("qweqwewqe"),closeSoftKeyboard());
        onView(withId(R.id.editTextEmailBengkel)).perform(typeText("qweqwe@dsad.sad"),closeSoftKeyboard());
        onView(withId(R.id.editTextPasswordBengkel)).perform(typeText("123123123"),closeSoftKeyboard());
        onView(withId(R.id.editTextPhoneBengkel)).perform(typeText(""),closeSoftKeyboard());
        onView(withId(R.id.BtnLanjut1)).perform(click());
        pauseTestFor(500);
    }

    public void testDaftar1(){
        onView(withId(R.id.editTextNamaPemilik)).perform(typeText("Pemilik Bengkel 1"));
        onView(withId(R.id.editTextEmailBengkel)).perform(typeText("bengkelbengkel@gmail.com"));
        onView(withId(R.id.editTextPasswordBengkel)).perform(typeText("pemilik1"));
        onView(withId(R.id.editTextPhoneBengkel)).perform(typeText("081234234234"));
        onView(withId(R.id.BtnLanjut1)).perform(click());
        pauseTestFor(500);
    }

}