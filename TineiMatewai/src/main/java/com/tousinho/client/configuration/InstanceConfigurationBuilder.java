package com.tousinho.client.configuration;

import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.RaspiPin;


public class InstanceConfigurationBuilder {

    public InstanceConfiguration build(String name, String pumpGPIO, String humidityGPIO, String waterInSeconds) {
        return new InstanceConfiguration(
                name,
                new HumidityConfiguration(getRaspiPin(humidityGPIO)),
                new PumpConfiguration(getRaspiPin(pumpGPIO), getInt(waterInSeconds))
        );
    }

    private int getInt(String value) {
        return Integer.parseInt(value);
    }

    private Pin getRaspiPin(String GPIOValue) {
        return RaspiPin.getPinByAddress(getInt(GPIOValue));
    }
}
