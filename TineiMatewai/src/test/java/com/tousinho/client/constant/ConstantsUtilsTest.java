package com.tousinho.client.constant;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConstantsUtilsTest {

    @Test
    public void shouldGreaterThanZero() {
        int humidityLowThreshold = ConstantsUtils.HUMIDITY_LOW_THRESHOLD;
        assertTrue(humidityLowThreshold >= 0);
    }

    @Test
    public void shouldLessThanHundred() {
        int humidityLowThreshold = ConstantsUtils.HUMIDITY_LOW_THRESHOLD;
        assertTrue(humidityLowThreshold <= 100);
    }
}