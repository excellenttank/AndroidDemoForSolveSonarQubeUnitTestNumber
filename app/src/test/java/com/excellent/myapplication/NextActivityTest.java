package com.excellent.myapplication;

import static org.junit.Assert.assertEquals;

import junit.framework.TestCase;

/***
 *Create By WangBinBin  On 2019/7.25
 **/
public class NextActivityTest extends TestCase {

    public void testAdd() {
        assertEquals(6, NextActivity.add(3, 3));
    }
}