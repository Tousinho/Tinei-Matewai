package com.tousinho.client.configuration;

import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.RaspiPin;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PumpConfigurationTest {

    public static final Pin GPIO_00 = RaspiPin.GPIO_00;
    public static final int WATER_TIME_IN_SECOND = 42;

    @Test
    public void shouldCreatePumpConfiguration() {
        PumpConfiguration pumpConfiguration = new PumpConfiguration(GPIO_00, WATER_TIME_IN_SECOND);
        assertNotNull(pumpConfiguration);
    }

    @Test
    public void shouldReturnPinValue() {
        PumpConfiguration pumpConfiguration = new PumpConfiguration(GPIO_00, WATER_TIME_IN_SECOND);
        assertEquals(pumpConfiguration.getPumpPin(), GPIO_00);
    }

    @Test
    public void shouldReturnWaterTimeInSecond() {
        PumpConfiguration pumpConfiguration = new PumpConfiguration(GPIO_00, WATER_TIME_IN_SECOND);
        assertEquals(pumpConfiguration.getWaterTimeInSecond(), WATER_TIME_IN_SECOND);
    }
}