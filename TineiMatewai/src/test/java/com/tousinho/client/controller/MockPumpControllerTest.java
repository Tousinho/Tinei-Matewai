package com.tousinho.client.controller;

import com.pi4j.io.gpio.RaspiPin;
import com.tousinho.client.configuration.PumpConfiguration;
import org.junit.Assert;
import org.junit.Test;

public class MockPumpControllerTest {
    PumpConfiguration pumpConfiguration = new PumpConfiguration(RaspiPin.GPIO_01, 1);
    @Test
    public void shouldGetInstance() {
        PumpController instance = new MockPumpController(pumpConfiguration);
        Assert.assertNotNull(instance);
    }


    @Test
    public void shouldPutWater() {
        PumpController instance = new MockPumpController(pumpConfiguration);
        instance.putWater();

    }


}