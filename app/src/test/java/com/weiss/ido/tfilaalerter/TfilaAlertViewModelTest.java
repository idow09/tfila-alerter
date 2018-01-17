package com.weiss.ido.tfilaalerter;

import android.arch.core.executor.testing.InstantTaskExecutorRule;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

public class TfilaAlertViewModelTest {

    @Rule
    public TestRule rule = new InstantTaskExecutorRule();

    @Test
    public void calculatesMinutesLeftUntilPrayer() throws Exception {
        TfilaAlertViewModel viewModel = new TfilaAlertViewModel();
        viewModel.init(LocalTime.of(9, 7), LocalTime.of(10, 30));
        assertEquals(83, viewModel.minutesLeft());
    }

    @Test
    public void laterOnTheDayCalculatesRemainingTimeForTheDayAfter() throws Exception {
        TfilaAlertViewModel viewModel = new TfilaAlertViewModel();
        viewModel.init(LocalTime.of(23, 42), LocalTime.of(10, 30));
        assertEquals(648, viewModel.minutesLeft());
    }
}