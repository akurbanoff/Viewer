package ru.akurbanoff.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.annotation.RestrictTo
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior.getTag
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.akurbanoff.core.SingleFragmentActivity
import ru.akurbanoff.home.ui.HomeFragment
import kotlin.coroutines.CoroutineContext
import kotlin.reflect.KClass


@RunWith(AndroidJUnit4::class)
@LargeTest
internal class HomeFragmentTest {
    lateinit var APPLICATION_MAIN: CoroutineContext
    lateinit var APPLICATION_BG: CoroutineContext
    @get:Rule
    var activityRule = ActivityScenarioRule(SingleFragmentActivity::class.java)

    fun onRequestFragment() = HomeFragment.newInstance()

    fun setContentFragment(){
        activityRule.scenario.onActivity { activity ->
            activity.supportFragmentManager.attach(R.layout.fragment_home, onRequestFragment())
        }
    }

    private fun FragmentManager.attach(@IdRes placeHolder: Int, fragment: Fragment) {
        val tag = getTag(fragment::class)
        beginTransaction()
            .replace(placeHolder, fragment, tag)
            .commitAllowingStateLoss()
    }

    private fun getTag(type: KClass<*>): String = type.java.name

    @Before
    fun setup(){
        APPLICATION_MAIN = Dispatchers.Main + CoroutineExceptionHandler { _, error -> throw error }
        APPLICATION_BG = Dispatchers.Unconfined + CoroutineExceptionHandler { _, error -> throw error }
        setContentFragment()
    }

    @Test
    fun testTopBarTitleIsShown(){
        onView(withId(R.id.home_title)).check(matches(isDisplayed()))
    }
}