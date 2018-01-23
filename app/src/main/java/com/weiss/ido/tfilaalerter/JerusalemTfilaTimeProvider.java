package com.weiss.ido.tfilaalerter;

import java.time.LocalTime;

class JerusalemTfilaTimeProvider implements TfilaTimeProvider {

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
}
