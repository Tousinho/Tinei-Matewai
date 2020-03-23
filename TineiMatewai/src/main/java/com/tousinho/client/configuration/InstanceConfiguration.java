package com.tousinho.client.configuration;

public class InstanceConfiguration {
    private final String sensorName;
    private final HumidityConfiguration humidityConfiguration;
    private final PumpConfiguration pumpConfiguration;

    public InstanceConfiguration(String sensorName, HumidityConfiguration humidityConfiguration, PumpConfiguration pumpConfiguration) {
        this.sensorName = sensorName;
        this.humidityConfiguration = humidityConfiguration;
        this.pumpConfiguration = pumpConfiguration;
    }

    public String getSensorName() {
        return sensorName;
    }

    public HumidityConfiguration getHumidityConfiguration() {
        return humidityConfiguration;
    }

    public PumpConfiguration getPumpConfiguration() {
        return pumpConfiguration;
    }
}
