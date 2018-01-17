package com.weiss.ido.tfilaalerter;

import android.arch.core.executor.testing.InstantTaskExecutorRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import java.time.LocalTime;
import java.util.concurrent.CountDownLatch;

import static java.time.temporal.ChronoUnit.MINUTES;
import static org.junit.Assert.assertEquals;

public class TfilaAlertViewModelTest {

    public static final LocalTime CURRENT_TIME = LocalTime.of(9, 0);
    public static final LocalTime PRAY_TIME = LocalTime.of(10, 30);

    @Rule
    public TestRule rule = new InstantTaskExecutorRule();

    private long expectedMinutes;

    @Before
    public void setUp() throws Exception {
        expectedMinutes = CURRENT_TIME.until(PRAY_TIME, MINUTES);
    }


    @Test
    public void publishesCorrectMinutesOnSomeFixedTime() throws Exception {
        TfilaAlertViewModel viewModel = new TfilaAlertViewModel();
        viewModel.init(CURRENT_TIME);
        CountDownLatch latch = new CountDownLatch(1);
        viewModel.minutesLeft().observeForever(
                minutes -> {
                    assertEquals((Long) expectedMinutes, minutes);
                    latch.countDown();
                });
        latch.await();
    }
}