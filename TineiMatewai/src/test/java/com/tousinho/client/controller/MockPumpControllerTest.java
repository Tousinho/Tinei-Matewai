package com.tousinho.client.controller;

import com.pi4j.io.gpio.PinState;
import org.junit.Assert;
import org.junit.Test;

public class MockPumpControllerTest {
    @Test
    public void shouldGetInstance() {
        PumpController instance = MockPumpController.getInstance();
        Assert.assertNotNull(instance);
    }

    @Test
    public void shouldSomeInstance() {
        PumpController instance = MockPumpController.getInstance();
        PumpController instance2 = MockPumpController.getInstance();
        Assert.assertEquals(instance, instance2);
    }

    @Test
    public void shouldLowByDefault() {
        PumpController instance = MockPumpController.getInstance();
        PinState pinState = instance.getPinState();
        Assert.assertEquals(pinState, PinState.LOW);
    }

    @Test
    public void shouldHighIfSetHigh() {
        PumpController instance = MockPumpController.getInstance();
        instance.setPinStatusHigh();
        PinState pinState = instance.getPinState();
        Assert.assertEquals(pinState, PinState.HIGH);
    }

    @Test
    public void shouldLowIfSetLow() {
        PumpController instance = MockPumpController.getInstance();
        instance.setPinStatusLow();
        PinState pinState = instance.getPinState();
        Assert.assertEquals(pinState, PinState.LOW);
    }
}