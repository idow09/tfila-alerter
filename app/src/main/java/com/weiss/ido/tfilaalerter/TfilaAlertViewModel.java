package com.weiss.ido.tfilaalerter;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import java.time.LocalTime;

class TfilaAlertViewModel extends ViewModel {

    private TfilaTimeRepository tfilaTimeRepository;

    public LiveData<LocalTime> getNextTfilaTime() {
        return tfilaTimeRepository.getNextTfilaTime();
    }

    public void init(TfilaTimeRepository repository) {
        tfilaTimeRepository = repository;
    }
}
