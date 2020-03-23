package com.tousinho.client.configuration;

import com.pi4j.io.gpio.Pin;

public class HumidityConfiguration {
    private final Pin humiditySensorPin;
    private final int humidityLowThreshold;

    public HumidityConfiguration(Pin humiditySensorPin, int humidityLowThreshold) {
        this.humiditySensorPin = humiditySensorPin;
        this.humidityLowThreshold = humidityLowThreshold;
    }

    public Pin getHumiditySensorPin() {
        return humiditySensorPin;
    }

    public int getHumidityLowThreshold() {
        return humidityLowThreshold;
    }
}
