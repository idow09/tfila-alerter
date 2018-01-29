package com.weiss.ido.tfilaalerter;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

import static org.junit.Assert.assertEquals;

public class JerusalemTfilaTimeProviderTest {

    private LocalDate someFixedDate;
    private LocalDate someOtherFixedDate;

    @Before
    public void setUp() throws Exception {
        someFixedDate = LocalDate.of(2017, Month.DECEMBER, 11);
        someOtherFixedDate = LocalDate.of(2018, Month.FEBRUARY, 26);
    }

    @Test
    public void getEndOfShakharitSomeDay() throws Exception {
        JerusalemTfilaTimeProvider provider = new JerusalemTfilaTimeProvider(someFixedDate);
        assertEquals(LocalTime.of(9, 26), provider.getEndOfShakharit());
    }

    @Test
    public void getEndOfShakharitSomeOtherDay() throws Exception {
        JerusalemTfilaTimeProvider provider = new JerusalemTfilaTimeProvider(someOtherFixedDate);
        assertEquals(LocalTime.of(9, 34), provider.getEndOfShakharit());
    }

    @Test
    public void getEndOfMinha() throws Exception {
        JerusalemTfilaTimeProvider provider = new JerusalemTfilaTimeProvider(someFixedDate);
        assertEquals(LocalTime.of(16, 40), provider.getEndOfMinha());
    }

    @Test
    public void getEndOfMaariv() throws Exception {
        JerusalemTfilaTimeProvider provider = new JerusalemTfilaTimeProvider(someFixedDate);
        assertEquals(LocalTime.of(23, 32), provider.getEndOfMaariv());
    }

}