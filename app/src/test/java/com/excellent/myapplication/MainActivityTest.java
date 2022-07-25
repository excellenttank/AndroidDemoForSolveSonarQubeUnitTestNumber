package com.excellent.myapplication;

import static org.junit.Assert.assertEquals;

import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Shadows;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowLog;

/***
 *Create By WangBinBin  On 2019/7.22
 **/
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    private MainActivity mainActivity;
    private TextView btn_to_next_activity;

    @Before
    public void setUp() {
        //输出日志
        ShadowLog.stream = System.out;
        mainActivity = activityRule.getActivity();
        btn_to_next_activity = mainActivity.findViewById(R.id.btn_to_next_activity);
    }

    @Test
    public void testOnClick() {
        btn_to_next_activity.performClick();
        // 获取对应的Shadow类
        ShadowActivity shadowActivity = Shadows.shadowOf(mainActivity);
        // 借助Shadow类获取启动下一Activity的Intent
        Intent nextIntent = shadowActivity.getNextStartedActivity();
        // 校验Intent的正确性
        assertEquals(nextIntent.getComponent().getClassName(), NextActivity.class.getName());

    }
}