package com.tousinho.client.configuration;

import com.pi4j.io.gpio.Pin;

public class PumpConfiguration {
    private final Pin pumpPin;
    private final int waterTimeInSecond;

    public PumpConfiguration(Pin pumpPin, int waterTimeInSecond) {
        this.pumpPin = pumpPin;
        this.waterTimeInSecond = waterTimeInSecond;
    }

    public Pin getPumpPin() {
        return pumpPin;
    }

    public int getWaterTimeInSecond() {
        return waterTimeInSecond;
    }
}
