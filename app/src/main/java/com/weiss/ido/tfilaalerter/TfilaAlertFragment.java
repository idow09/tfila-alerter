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

    private TextView minutesLeftTextView;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tfila_alert_layout, container, false);
        minutesLeftTextView = view.findViewById(R.id.text_view_minutes_left);
        TfilaAlertViewModel viewModel = ViewModelProviders.of(this).get(TfilaAlertViewModel.class);
        viewModel.init(LocalTime.now());
        viewModel.minutesLeft().observe(this, minutesLeft -> minutesLeftTextView.setText(format(minutesLeft)));
        return view;
    }

    private String format(long minutesLeft) {
        return String.format("%d:%d", minutesLeft / 60, minutesLeft % 60);
    }
}