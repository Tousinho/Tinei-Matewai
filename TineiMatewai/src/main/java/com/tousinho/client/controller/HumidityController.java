package com.tousinho.client.controller;

public class HumidityController {
    private static HumidityController humidityController;

    public static HumidityController getInstance() {
        if (humidityController == null) {
            humidityController = new HumidityController();
        }
        return humidityController;
    }

    public int getHumidityValue() {
        return 0;
    }
}
