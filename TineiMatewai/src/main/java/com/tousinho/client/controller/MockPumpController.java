package com.tousinho.client.controller;

import com.pi4j.io.gpio.PinState;
import com.tousinho.client.configuration.PumpConfiguration;

public class MockPumpController implements PumpController {
    private final PumpConfiguration pumpConfiguration;
    private PinState pin;

    public MockPumpController(PumpConfiguration pumpConfiguration) {
        this.pumpConfiguration = pumpConfiguration;
        pin = PinState.LOW;
    }

    private void setPinStatusHigh() {
        setStatus(PinState.HIGH);
    }

    private void setPinStatusLow() {
        setStatus(PinState.LOW);
    }

    @Override
    public void putWater() {
        setPinStatusHigh();
        sleeping(pumpConfiguration.getWaterTimeInSecond());
        setPinStatusLow();
    }

    private void setStatus(PinState pinState) {
        pin = pinState;
    }

    private void sleeping(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException ignored) { }
    }
}
