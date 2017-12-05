package com.weiss.ido.tfilaalerter;

import android.location.Location;

import org.junit.Test;

import java.time.LocalTime;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TfilaTimeCalculatorTest {
    @Test
    public void morningPrayerEndTimePredictedWell() throws Exception {
        Location jerusalem = new Location("");
        LocalTime morning = LocalTime.of(8, 0);
        LocalTime time = new TfilaTimeCalculator().getNextTfilaTime(morning, jerusalem);
        LocalTime lastTimeOfMorningPrayerInJerusalem = LocalTime.of(10, 52);
        assertThat("Should be the last possible morning prayer time in jerusalem.", time, is(lastTimeOfMorningPrayerInJerusalem));
    }
}