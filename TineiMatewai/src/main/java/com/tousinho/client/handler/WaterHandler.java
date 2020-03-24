package com.tousinho.client.handler;

import com.tousinho.client.controller.HumidityController;
import com.tousinho.client.controller.PumpController;



public class WaterHandler implements Runnable {
    private HumidityController humidityController;
    private PumpController pumpController;

    public WaterHandler(HumidityController humidityController, PumpController pumpController) {
        this.humidityController = humidityController;
        this.pumpController = pumpController;

    }

    @Override
    public synchronized void run() {
        if (humidityController.isTimeToWater()) {
            pumpController.putWater();
        }
    }
}
