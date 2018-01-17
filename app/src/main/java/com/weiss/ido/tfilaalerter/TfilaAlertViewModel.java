package com.weiss.ido.tfilaalerter;

import android.arch.lifecycle.ViewModel;

import java.time.LocalTime;

import static java.time.temporal.ChronoUnit.MINUTES;

class TfilaAlertViewModel extends ViewModel {

    private static final long MINUTES_IN_DAY = 60 * 24;
    private LocalTime currentTime;
    private LocalTime tfilaTime;

    public TfilaAlertViewModel() {
    }

    public long minutesLeft() {
        long minutesBetween = currentTime.until(tfilaTime, MINUTES);
        return minutesBetween < 0 ? (minutesBetween + MINUTES_IN_DAY) : minutesBetween;
    }

    public void init(LocalTime currentTime, LocalTime tfilaTime) {
        this.currentTime = currentTime;
        this.tfilaTime = tfilaTime;
    }
}
