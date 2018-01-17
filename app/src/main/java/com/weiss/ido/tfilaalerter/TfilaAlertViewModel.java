package com.weiss.ido.tfilaalerter;

import android.arch.lifecycle.ViewModel;

import java.time.LocalTime;

import static java.time.temporal.ChronoUnit.MINUTES;

class TfilaAlertViewModel extends ViewModel {

    private static final long MINUTES_IN_DAY = 60 * 24;
    private LocalTime currentTime;
    private TfilaTimeProvider tfilaTimeProvider;

    public TfilaAlertViewModel() {
    }

    public long minutesLeft() {
        LocalTime shakharitTime = tfilaTimeProvider.getEndOfShakharit();
        long minutesBetween = currentTime.until(shakharitTime, MINUTES);
        long minutesLeft = minutesBetween < 0 ? (minutesBetween + MINUTES_IN_DAY) : minutesBetween;
        LocalTime minhaTime = tfilaTimeProvider.getEndOfMinha();
        long minutesBetweenMinha = currentTime.until(minhaTime, MINUTES);
        long minutesLeftMinha = minutesBetweenMinha < 0 ? (minutesBetweenMinha + MINUTES_IN_DAY) : minutesBetweenMinha;
        LocalTime maarivTime = tfilaTimeProvider.getEndOfMaariv();
        long minutesBetweenMaariv = currentTime.until(maarivTime, MINUTES);
        long minutesLeftMaariv = minutesBetweenMaariv < 0 ? (minutesBetweenMaariv + MINUTES_IN_DAY) : minutesBetweenMaariv;
        return Math.min(Math.min(minutesLeft, minutesLeftMinha), minutesLeftMaariv);
    }

    public void init(LocalTime currentTime, TfilaTimeProvider tfilaTimeProvider) {
        this.currentTime = currentTime;
        this.tfilaTimeProvider = tfilaTimeProvider;
    }
}
