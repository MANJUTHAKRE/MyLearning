package com.example.mylearning

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule<LoginActivity>(
        LoginActivity::class.java
    )

    private val username = "chike"
    private val password = "password"

    @Test
    fun clickLoginButton_opensLoginUi() {
        onView(withId(R.id.et_username)).perform(ViewActions.typeText(username))
        onView(withId(R.id.et_password)).perform(ViewActions.typeText(password))

        onView(withId(R.id.btn_submit)).perform(ViewActions.scrollTo(), ViewActions.click())

        Espresso.onView(withId(R.id.tv_login))
            .check(matches(withText("Success")))
    }
}