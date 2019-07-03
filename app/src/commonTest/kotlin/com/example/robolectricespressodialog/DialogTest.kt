package com.example.robolectricespressodialog


import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DialogTest {
    @Test
    fun testDialog() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.my_button)).perform(click())
        onView(withText(R.string.dialog_title)).check(matches(isDisplayed()))
        onView(withText(android.R.string.ok)).perform(click())
        onView(withId(R.id.my_button)).check(matches(isDisplayed()))
    }
}
