package com.weiss.ido.tfilaalerter;

import android.arch.core.executor.testing.InstantTaskExecutorRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

public class TfilaAlertViewModelTest {

    @Rule
    public TestRule rule = new InstantTaskExecutorRule();

    @Test
    public void calculatesMinutesLeftUntilTfila() throws Exception {
        TfilaAlertViewModel viewModel = new TfilaAlertViewModel();
        viewModel.init(LocalTime.of(9, 7), new MockTfilaTimeProvider());
        assertEquals(83, viewModel.minutesLeft());
    }

    @Test
    public void calculatesTimesToTheSoonerBetweenShakharitAndMinha() throws Exception {
        TfilaAlertViewModel viewModel = new TfilaAlertViewModel();
        viewModel.init(LocalTime.of(10, 59), new MockTfilaTimeProvider());
        assertEquals(121, viewModel.minutesLeft());
    }

    @Test
    public void calculatesTimesToTheSoonerBetweenMinhaAndMaariv() throws Exception {
        TfilaAlertViewModel viewModel = new TfilaAlertViewModel();
        viewModel.init(LocalTime.of(14, 27), new MockTfilaTimeProvider());
        assertEquals(14 * 60 + 33, viewModel.minutesLeft());
    }

    @Test
    public void correctsNegativeResults() throws Exception {
        TfilaAlertViewModel viewModel = new TfilaAlertViewModel();
        viewModel.init(LocalTime.of(23, 42), new MockTfilaTimeProvider());
        assertEquals(318, viewModel.minutesLeft());
    }

}