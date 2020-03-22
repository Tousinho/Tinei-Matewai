package com.tousinho.client.controller;

import com.pi4j.io.gpio.PinState;

public class MockPumpController implements PumpController {

    private static MockPumpController pumpController;
    private PinState pin;

    public static MockPumpController getInstance() {
        if (pumpController == null) {
            pumpController = new MockPumpController();
        }
        return pumpController;
    }

    private MockPumpController() {
        pin = PinState.LOW;
    }

    @Override
    public PinState getPinState() {
        return pin;
    }

    @Override
    public void setPinStatusHigh() {
        setStatus(PinState.HIGH);
    }

    @Override
    public void setPinStatusLow() {
        setStatus(PinState.LOW);
    }

    private void setStatus(PinState pinState) {
        pin = pinState;
    }
}
