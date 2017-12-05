package com.weiss.ido.tfilaalerter;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import java.time.LocalTime;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TfilaAlertViewModelTest {

    @Rule
    public TestRule rule = new InstantTaskExecutorRule();

    private LocalTime stubTime;
    private TfilaAlertViewModel viewModel;
    private MutableLiveData<LocalTime> mockTfilaTimeLiveData;

    @Before
    public void setUp() throws Exception {
        stubTime = LocalTime.now();
        mockTfilaTimeLiveData = new MutableLiveData<>();
        TfilaTimeRepository repository = mock(TfilaTimeRepository.class);
        when(repository.getNextTfilaTime()).thenReturn(mockTfilaTimeLiveData);

        viewModel = new TfilaAlertViewModel();
        viewModel.init(repository);
    }

    @Test
    public void viewModelRetrievesTimeFromRepository() throws Exception {
        // Arrange
        mockTfilaTimeLiveData.postValue(stubTime);

        // Act
        LiveData<LocalTime> nextTfilaTime = viewModel.getNextTfilaTime();

        // Assert
        assertThat(nextTfilaTime.getValue(), is(stubTime));
    }

    @Test
    public void viewModelRetrievesTimeFromRepository_live() throws Exception {
        // Arrange

        // Act
        LiveData<LocalTime> nextTfilaTime = viewModel.getNextTfilaTime();
        mockTfilaTimeLiveData.postValue(stubTime);

        // Assert
        assertThat(nextTfilaTime.getValue(), is(stubTime));
    }
}