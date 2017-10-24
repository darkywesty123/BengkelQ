package com.example.gil.bengkelq;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.Toast;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Created by root on 10/17/17.
 */
@RunWith(AndroidJUnit4.class)
public class DafpenggunaActivityTest {

    @Rule
    public ActivityTestRule<DafpenggunaActivity> daftartestrule = new ActivityTestRule<>(DafpenggunaActivity.class, true, false);

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
        onView(withId(R.id.txtNamaPengguna)).perform(typeText(""),closeSoftKeyboard());
        onView(withId(R.id.BtnDaftarPengguna)).perform(click());
        pauseTestFor(500);
    }

    @Test
    public void cekEmaildaftar() {
        daftartestrule.launchActivity(null);
        onView(withId(R.id.txtNamaPengguna)).perform(typeText("Users"),closeSoftKeyboard());
        onView(withId(R.id.txtEmailPengguna)).perform(typeText(""),closeSoftKeyboard());
        onView(withId(R.id.BtnDaftarPengguna)).perform(click());
        pauseTestFor(500);
}

    @Test
    public void cekPassworddaftar() {
        daftartestrule.launchActivity(null);
        onView(withId(R.id.txtNamaPengguna)).perform(typeText("Users"),closeSoftKeyboard());
        onView(withId(R.id.txtEmailPengguna)).perform(typeText("users@gmail.com"),closeSoftKeyboard());
        onView(withId(R.id.txtPasswordPengguna)).perform(typeText(""),closeSoftKeyboard());
        onView(withId(R.id.BtnDaftarPengguna)).perform(click());
        pauseTestFor(500);
    }

    @Test
    public void cekNamaPassworddaftar() {
        daftartestrule.launchActivity(null);
        onView(withId(R.id.txtNamaPengguna)).perform(typeText("Users"),closeSoftKeyboard());
        onView(withId(R.id.txtEmailPengguna)).perform(typeText(""),closeSoftKeyboard());
        onView(withId(R.id.txtPasswordPengguna)).perform(typeText("12345678"),closeSoftKeyboard());
        onView(withId(R.id.BtnDaftarPengguna)).perform(click());
        pauseTestFor(500);
    }
}