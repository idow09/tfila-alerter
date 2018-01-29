package com.weiss.ido.tfilaalerter;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

import static org.junit.Assert.assertEquals;

public class JerusalemTfilaTimeProviderTest {

    private JerusalemTfilaTimeProvider provider;
    private LocalTime END_OF_SHAKHARIT;
    private LocalTime END_OF_MINHA;
    private LocalTime END_OF_MAARIV;

    @Before
    public void setUp() throws Exception {
        END_OF_SHAKHARIT = LocalTime.of(9, 26);
        END_OF_MINHA = LocalTime.of(16, 40);
        END_OF_MAARIV = LocalTime.of(23, 32);

        LocalDate date = LocalDate.of(2017, Month.DECEMBER, 11);
        provider = new JerusalemTfilaTimeProvider(date);
    }

    @Test
    public void getEndOfShakharit() throws Exception {
        assertEquals(END_OF_SHAKHARIT, provider.getEndOfShakharit());
    }

    @Test
    public void getEndOfMinha() throws Exception {
        assertEquals(END_OF_MINHA, provider.getEndOfMinha());
    }

    @Test
    public void getEndOfMaariv() throws Exception {
        assertEquals(END_OF_MAARIV, provider.getEndOfMaariv());
    }

}