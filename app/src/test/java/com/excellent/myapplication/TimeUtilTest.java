package com.excellent.myapplication;

import static org.junit.Assert.assertEquals;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/***
 *Create By WangBinBin  On 2019/5.26
 **/
@RunWith(AndroidJUnit4.class)
public class TimeUtilTest {

    long timeStamp = 1653546402364L;
    String rightFormatTime = "2022-05-26 14:26:42";

    @Test
    public void getTimeStr() {
        System.out.println("TimeUtil.getTimeStr单元测试开始");
        Date longDate = new Date();
        longDate.setTime(timeStamp);

        assertEquals(rightFormatTime, TimeUtil.getTimeStr(timeStamp, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(longDate)));
        System.out.println("TimeUtil.getTimeStr单元测试结束");
    }

    @Test
    public void compareDate() {
        System.out.println("TimeUtil.compareDate单元测试开始");
        //比较错误
        assertEquals(-1, TimeUtil.compareDate("", "", "", "yyyy-MM-dd"));
        //当前时间在两个时间中间
        assertEquals(0, TimeUtil.compareDate("2019-12-01", "2021-10-02", "2020-05-06", "yyyy-MM-dd"));
        //当前时间还没有到开始时间
        assertEquals(1, TimeUtil.compareDate("2020-05-06", "2021-10-02", "2019-12-01", "yyyy-MM-dd"));
        //当前时间大于结束时间
        assertEquals(2, TimeUtil.compareDate("2019-12-01", "2020-05-06", "2021-10-02", "yyyy-MM-dd"));
        System.out.println("TimeUtil.compareDate单元测试结束");
    }

    @Test
    public void compareDateDifference() {
        System.out.println("TimeUtil.compareDateDifference单元测试开始");
        assertEquals("", TimeUtil.compareDateDifference("2019-12-01", "2019-12-03", "yyyy-MM-dd"));
        System.out.println("TimeUtil.compareDateDifference单元测试结束");
    }

}