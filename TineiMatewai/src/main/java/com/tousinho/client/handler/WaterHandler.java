package com.tousinho.client.handler;

import com.tousinho.client.controller.HumidityController;
import com.tousinho.client.controller.PumpController;

import static com.tousinho.client.constant.ConstantsUtils.HUMIDITY_LOW_THRESHOLD;
import static com.tousinho.client.constant.ConstantsUtils.WATER_SECONDS;

public class WaterHandler implements Runnable {
    private HumidityController humidityController;
    private PumpController pumpController;

    public WaterHandler(HumidityController humidityController, PumpController pumpController) {
        this.humidityController = humidityController;
        this.pumpController = pumpController;
    }

    @Override
    public synchronized void run() {
        if (humidityController.getHumidityValue() < HUMIDITY_LOW_THRESHOLD) {
            pumpController.setPinStatusHigh();
            try {
                Thread.sleep(WATER_SECONDS * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            pumpController.setPinStatusLow();
        }
    }
}
