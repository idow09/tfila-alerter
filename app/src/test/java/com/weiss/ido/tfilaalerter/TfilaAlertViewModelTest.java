package com.weiss.ido.tfilaalerter;

import android.arch.core.executor.testing.InstantTaskExecutorRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

public class TfilaAlertViewModelTest {

    public static final LocalTime CURRENT_TIME = LocalTime.of(9, 0);

    @Rule
    public TestRule rule = new InstantTaskExecutorRule();

    @Test
    public void publishesCorrectMinutesOnSomeFixedTime() throws Exception {
        TfilaAlertViewModel viewModel = new TfilaAlertViewModel();
        viewModel.init(CURRENT_TIME);
        assertEquals(90, viewModel.minutesLeft());
    }
}