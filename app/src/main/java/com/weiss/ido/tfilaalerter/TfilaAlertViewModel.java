package com.weiss.ido.tfilaalerter;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.time.LocalTime;

import static java.time.temporal.ChronoUnit.MINUTES;

class TfilaAlertViewModel extends ViewModel {

    public static final LocalTime PRAY_TIME = LocalTime.of(10, 30);
    private LocalTime time;

    public TfilaAlertViewModel() {

    }

    public LiveData<Long> minutesLeft() {
        MutableLiveData<Long> data = new MutableLiveData<>();
        data.setValue(time.until(PRAY_TIME, MINUTES));
        return data;
    }

    public void init(LocalTime time) {
        this.time = time;
    }
}
