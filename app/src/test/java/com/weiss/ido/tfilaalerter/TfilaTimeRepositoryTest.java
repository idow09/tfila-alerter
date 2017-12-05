package com.weiss.ido.tfilaalerter;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.lifecycle.LiveData;
import android.location.Location;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import java.time.LocalTime;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TfilaTimeRepositoryTest {

    @Rule
    public TestRule rule = new InstantTaskExecutorRule();
    private LocalTime stubTime;
    private TfilaTimeRepository repository;

    @Before
    public void setUp() throws Exception {
        stubTime = LocalTime.NOON;
        TfilaTimeCalculator calculator = mock(TfilaTimeCalculator.class);
        when(calculator.getNextTfilaTime(any(LocalTime.class), any(Location.class))).thenReturn(stubTime);
        repository = new TfilaTimeRepository(calculator);
    }

    @Test
    public void tfilaTimeRepositoryTestReturnsLiveData() throws Exception {
        // Arrange

        // Act
        LiveData<LocalTime> tfilaTime = repository.getNextTfilaTime();

        // Assert
        assertThat(tfilaTime.getValue(), is(stubTime));
    }
}