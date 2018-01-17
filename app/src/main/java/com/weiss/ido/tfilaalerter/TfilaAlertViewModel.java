package com.weiss.ido.tfilaalerter;

import android.arch.lifecycle.ViewModel;

import java.time.LocalTime;

import static java.time.temporal.ChronoUnit.MINUTES;

class TfilaAlertViewModel extends ViewModel {

    public static final LocalTime PRAY_TIME = LocalTime.of(10, 30);
    private LocalTime time;

    public TfilaAlertViewModel() {
    }

    public long minutesLeft() {
        return time.until(PRAY_TIME, MINUTES);
    }

    public void init(LocalTime time) {
        this.time = time;
    }
}
