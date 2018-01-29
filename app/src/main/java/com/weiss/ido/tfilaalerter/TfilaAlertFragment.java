package com.weiss.ido.tfilaalerter;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.LocalTime;

public class TfilaAlertFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tfila_alert_layout, container, false);
        TextView minutesLeftTextView = view.findViewById(R.id.text_view_minutes_left);
        TfilaAlertViewModel viewModel = ViewModelProviders.of(this).get(TfilaAlertViewModel.class);
        TfilaTimeProvider tfilaTimeProvider = new JerusalemTfilaTimeProvider(LocalDate.now());
        viewModel.init(LocalTime.now(), tfilaTimeProvider);
        long minutesLeft = viewModel.minutesLeft();
        LocalTime timeLeft = LocalTime.of((int) minutesLeft / 60, (int) minutesLeft % 60);
        minutesLeftTextView.setText(timeLeft.toString());
        return view;
    }

}