package com.tousinho.client.controller;

public class MockHumidityController implements HumidityController {
    private static MockHumidityController humidityController;

    public static MockHumidityController getInstance() {
        if (humidityController == null) {
            humidityController = new MockHumidityController();
        }
        return humidityController;
    }

    @Override
    public int getHumidityValue() {
        return 0;
    }
}
