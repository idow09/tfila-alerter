package com.weiss.ido.tfilaalerter;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

public class JerusalemTfilaTimeProviderTest {

    private JerusalemTfilaTimeProvider provider;

    @Before
    public void setUp() throws Exception {
        provider = new JerusalemTfilaTimeProvider();
    }

    @Test
    public void getEndOfShakharit() throws Exception {
        assertEquals(LocalTime.of(10, 30), provider.getEndOfShakharit());
    }

    @Test
    public void getEndOfMinha() throws Exception {
        assertEquals(LocalTime.of(13, 0), provider.getEndOfMinha());
    }

    @Test
    public void getEndOfMaariv() throws Exception {
        assertEquals(LocalTime.of(5, 0), provider.getEndOfMaariv());
    }

}