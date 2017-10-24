package com.example.gil.bengkelq;

/*
import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
*/
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

/*
import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
/*

 */
/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
}

@RunWith(AndroidJUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExampleLoginTest {
    private int wait = 500;
    private int waitLong = 5000;
    private String emailLogin = "user@example.com";
    private String passwordLogin = "example";
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @Rule
    //public ActivityTestRule<ExampleLoginTest> ExampleLoginTestRule = new ActivityTestRule<ExampleLoginTest>(ExampleLoginTest.class, true, false);

    @Before
    public void setUp() throws Exception {

        //Intents.init();
        mAuth.signOut();
        AuthCredential credential = EmailAuthProvider.getCredential(emailLogin, passwordLogin);
        mAuth.signInWithCredential(credential);
    }

    private void pauseTestFor(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*
    @Test
    public void signOut() throws Exception {
        ExampleLoginTestRule.launchActivity(null);
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText(R.string.action_logout)).perform(click());
        pauseTestFor(wait);
        intended(hasComponent(LoginActivity.class.getName()));
    }
    */

    @After
    public void tearDown() throws Exception {
        //Intents.release();
    }
}

