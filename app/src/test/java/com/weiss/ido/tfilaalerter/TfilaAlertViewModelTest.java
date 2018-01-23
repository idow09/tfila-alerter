package com.weiss.ido.tfilaalerter;

import android.arch.core.executor.testing.InstantTaskExecutorRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

public class TfilaAlertViewModelTest {

    @Rule
    public TestRule rule = new InstantTaskExecutorRule();

    private MockTfilaTimeProvider provider;
    private TfilaAlertViewModel viewModel;

    @Before
    public void setUp() throws Exception {
        provider = new MockTfilaTimeProvider();
        viewModel = new TfilaAlertViewModel();
    }

    @Test
    public void calculatesMinutesLeftUntilTfila() throws Exception {
        viewModel.init(LocalTime.of(9, 7), provider);
        assertEquals(83, viewModel.minutesLeft());
    }

    @Test
    public void calculatesTimesToTheSoonerBetweenShakharitAndMinha() throws Exception {
        viewModel.init(LocalTime.of(10, 59), provider);
        assertEquals(121, viewModel.minutesLeft());
    }

    @Test
    public void calculatesTimesToTheSoonerBetweenMinhaAndMaariv() throws Exception {
        viewModel.init(LocalTime.of(14, 27), provider);
        assertEquals(14 * 60 + 33, viewModel.minutesLeft());
    }

    @Test
    public void correctsNegativeResults() throws Exception {
        viewModel.init(LocalTime.of(23, 42), provider);
        assertEquals(318, viewModel.minutesLeft());
    }
}