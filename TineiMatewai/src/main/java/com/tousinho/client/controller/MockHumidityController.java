package com.tousinho.client.controller;

import com.tousinho.client.configuration.HumidityConfiguration;

public class MockHumidityController implements HumidityController {

    private final HumidityConfiguration humidityConfiguration;

    public MockHumidityController(HumidityConfiguration humidityConfiguration) {
        this.humidityConfiguration = humidityConfiguration;
    }

    @Override
    public int getHumidityValue() {
        return 50;
    }

    @Override
    public boolean isTimeToWater() {
        return getHumidityValue() < humidityConfiguration.getHumidityLowThreshold();
    }
}
