package com.weiss.ido.tfilaalerter;

import java.time.LocalTime;

interface TfilaTimeProvider {
    LocalTime getEndOfShakharit();

    LocalTime getEndOfMinha();

    LocalTime getEndOfMaariv();
}
