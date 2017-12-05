package com.weiss.ido.tfilaalerter;

import android.arch.lifecycle.MutableLiveData;
import android.location.Location;

import java.time.LocalTime;

class TfilaTimeRepository {
    private TfilaTimeCalculator tfilaTimeCalculator;

    public TfilaTimeRepository(TfilaTimeCalculator calculator) {
        tfilaTimeCalculator = calculator;
    }

    public MutableLiveData<LocalTime> getNextTfilaTime() {
        MutableLiveData<LocalTime> liveData = new MutableLiveData<>();
        liveData.postValue(tfilaTimeCalculator.getNextTfilaTime(LocalTime.now(), new Location("")));
        return liveData;
    }
}
