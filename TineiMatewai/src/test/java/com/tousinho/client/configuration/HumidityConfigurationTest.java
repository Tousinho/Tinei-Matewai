package com.tousinho.client.configuration;

import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.RaspiPin;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

public class HumidityConfigurationTest {
    public static final Pin GPIO_00 = RaspiPin.GPIO_00;
    public static final int THRESHOLD = 42;

    @Test
    public void shouldCreatePumpConfiguration() {
        HumidityConfiguration pumpConfiguration = new HumidityConfiguration(GPIO_00, THRESHOLD);
        assertNotNull(pumpConfiguration);
    }

    @Test
    public void shouldReturnPinValue() {
        HumidityConfiguration pumpConfiguration = new HumidityConfiguration(GPIO_00, THRESHOLD);
        assertEquals(pumpConfiguration.getHumiditySensorPin(), GPIO_00);
    }

    @Test
    public void shouldReturnWaterTimeInSecond() {
        HumidityConfiguration pumpConfiguration = new HumidityConfiguration(GPIO_00, THRESHOLD);
        assertEquals(pumpConfiguration.getHumidityLowThreshold(), THRESHOLD);
    }

}