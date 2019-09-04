package com.izamtest.decathlon;

import com.izamtest.decathlon.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SportsPointsUnitTest {
    @Test
    void TestRun110m() {
        assertEquals(new Run100m("10.395").getPoints(), 1000);
        assertEquals(new Run100m("10.827").getPoints(), 900);
        assertEquals(new Run100m("11.278").getPoints(), 800);
        assertEquals(new Run100m("11.756").getPoints(), 700);
    }

    @Test
    void TestLongJump() {
        assertEquals(new LongJump("7.76").getPoints(), 1000);
        assertEquals(new LongJump("7.36").getPoints(), 900);
        assertEquals(new LongJump("6.51").getPoints(), 700);
    }

    @Test
    void TestShotPut() {
        assertEquals(new ShotPut("18.4").getPoints(), 1000);
        assertEquals(new ShotPut("16.79").getPoints(), 900);
        assertEquals(new ShotPut("15.16").getPoints(), 800);
        assertEquals(new ShotPut("13.53").getPoints(), 700);
    }

    @Test
    void TestHighJump() {
        assertEquals(new HighJump("2.20").getPoints(), 1000);
        assertEquals(new HighJump("1.99").getPoints(), 800);
    }

    @Test
    void TestRun400m() {
        assertEquals(new Run400m("46.17").getPoints(), 1000);
        assertEquals(new Run400m("48.19").getPoints(), 900);
        assertEquals(new Run400m("50.32").getPoints(), 800);
        assertEquals(new Run400m("52.58").getPoints(), 700);
    }

    @Test
    void TestRun110mHurdles() {
        assertEquals(new Run110mHurdles("13.80").getPoints(), 1000);
        assertEquals(new Run110mHurdles("14.59").getPoints(), 900);
        assertEquals(new Run110mHurdles("15.419").getPoints(), 800);
        assertEquals(new Run110mHurdles("16.29").getPoints(), 700);
    }

    @Test
    void TestDiscussThrow() {
        assertEquals(new DiscusThrow("56.17").getPoints(), 1000);
        assertEquals(new DiscusThrow("51.40").getPoints(), 900);
        assertEquals(new DiscusThrow("46.59").getPoints(), 800);
        assertEquals(new DiscusThrow("41.72").getPoints(), 700);
    }

    @Test
    void TestPoleVault() {
        assertEquals(new PoleVault("4.29").getPoints(), 700);
    }

    @Test
    void TestJavelin() {
        assertEquals(new JavelinThrow("77.19").getPoints(), 1000);
        assertEquals(new JavelinThrow("70.67").getPoints(), 900);
        assertEquals(new JavelinThrow("64.09").getPoints(), 800);
        assertEquals(new JavelinThrow("57.45").getPoints(), 700);
    }

    @Test
    void TestRun1500m() {
        assertEquals(new Run1500m("3.53.79").getPoints(), 1000);
        assertEquals(new Run1500m("4.07.42").getPoints(), 900);
        assertEquals(new Run1500m("4.21.77").getPoints(), 800);
        assertEquals(new Run1500m("4.36.96").getPoints(), 700);
    }
}
