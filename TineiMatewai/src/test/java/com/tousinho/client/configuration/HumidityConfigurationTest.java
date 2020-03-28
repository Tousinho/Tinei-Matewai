package com.tousinho.client.configuration;

import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.RaspiPin;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

public class HumidityConfigurationTest {
    public static final Pin GPIO_00 = RaspiPin.GPIO_00;


    @Test
    public void shouldCreatePumpConfiguration() {
        HumidityConfiguration pumpConfiguration = new HumidityConfiguration(GPIO_00);
        assertNotNull(pumpConfiguration);
    }

    @Test
    public void shouldReturnPinValue() {
        HumidityConfiguration pumpConfiguration = new HumidityConfiguration(GPIO_00);
        assertEquals(pumpConfiguration.getHumiditySensorPin(), GPIO_00);
    }

}