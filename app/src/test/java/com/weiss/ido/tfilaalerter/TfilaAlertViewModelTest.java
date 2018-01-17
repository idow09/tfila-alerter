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
        viewModel.init(LocalTime.of(9, 7), mockTfilaTimeProvider());
        assertEquals(83, viewModel.minutesLeft());
    }

    @Test
    public void calculatesTimesToTheSoonerBetweenShakharitAndMinha() throws Exception {
        TfilaAlertViewModel viewModel = new TfilaAlertViewModel();
        viewModel.init(LocalTime.of(10, 59), mockTfilaTimeProvider());
        assertEquals(121, viewModel.minutesLeft());
    }

    @Test
    public void calculatesTimesToTheSoonerBetweenMinhaAndMaariv() throws Exception {
        TfilaAlertViewModel viewModel = new TfilaAlertViewModel();
        viewModel.init(LocalTime.of(14, 27), mockTfilaTimeProvider());
        assertEquals(14 * 60 + 33, viewModel.minutesLeft());
    }

    @Test
    public void correctsNegativeResults() throws Exception {
        TfilaAlertViewModel viewModel = new TfilaAlertViewModel();
        viewModel.init(LocalTime.of(23, 42), mockTfilaTimeProvider());
        assertEquals(318, viewModel.minutesLeft());
    }

    private TfilaTimeProvider mockTfilaTimeProvider() {
        return new TfilaTimeProvider() {
            @Override
            public LocalTime getEndOfShakharit() {
                return LocalTime.of(10, 30);
            }

            @Override
            public LocalTime getEndOfMinha() {
                return LocalTime.of(13, 0);
            }

            @Override
            public LocalTime getEndOfMaariv() {
                return LocalTime.of(5, 0);
            }
        };
    }
}