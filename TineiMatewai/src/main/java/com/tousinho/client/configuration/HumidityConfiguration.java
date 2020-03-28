package com.tousinho.client.configuration;

import com.pi4j.io.gpio.Pin;

public class HumidityConfiguration {
    private final Pin humiditySensorPin;

    public HumidityConfiguration(Pin humiditySensorPin) {
        this.humiditySensorPin = humiditySensorPin;
    }

    public Pin getHumiditySensorPin() {
        return humiditySensorPin;
    }

}
