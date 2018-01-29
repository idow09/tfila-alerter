package com.weiss.ido.tfilaalerter;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;

import net.sourceforge.zmanim.ComplexZmanimCalendar;
import net.sourceforge.zmanim.util.GeoLocation;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.TimeZone;

class JerusalemTfilaTimeProvider implements TfilaTimeProvider {

    private final ComplexZmanimCalendar calendar;

    public JerusalemTfilaTimeProvider(LocalDate date) {
        GeoLocation location = getJerusalemGeoLocation();
        this.calendar = new ComplexZmanimCalendar(location);
        this.calendar.getCalendar().set(date.getYear(), date.getMonthValue() - 1, date.getDayOfMonth());
    }

    @Override
    public LocalTime getEndOfShakharit() {
        return toLocalTime(calendar.getSofZmanTfilaMGA());
    }

    @Override
    public LocalTime getEndOfMinha() {
//        return LocalTime.of(13, 0);
        return null;
    }

    @Override
    public LocalTime getEndOfMaariv() {
//        return LocalTime.of(5, 0);
        return null;
    }

    @NonNull
    private GeoLocation getJerusalemGeoLocation() {
        TimeZone zone = TimeZone.getTimeZone("GMT+2:00");
        return new GeoLocation("Jerusalem", 31.783, 35.219, 715, zone);
    }

    @SuppressLint("SimpleDateFormat") // Used only for converting purposes, not for display
    private LocalTime toLocalTime(Date date) {
        return LocalTime.parse(new SimpleDateFormat("HH:mm").format(date));
    }

}
