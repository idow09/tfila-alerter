package com.weiss.ido.tfilaalerter;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.time.LocalTime;

public class TfilaAlertFragment extends Fragment {

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tfila_alert_layout, container, false);
        TextView minutesLeftTextView = view.findViewById(R.id.text_view_minutes_left);
        TfilaAlertViewModel viewModel = ViewModelProviders.of(this).get(TfilaAlertViewModel.class);
        TfilaTimeProvider tfilaTimeProvider = new TfilaTimeProvider() {
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
        viewModel.init(LocalTime.now(), tfilaTimeProvider);
        long minutesLeft = viewModel.minutesLeft();
        LocalTime timeLeft = LocalTime.of((int) minutesLeft / 60, (int) minutesLeft % 60);
        minutesLeftTextView.setText(timeLeft.toString());
        return view;
    }

}