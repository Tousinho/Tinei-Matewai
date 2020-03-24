package com.tousinho.client.handler;

import com.tousinho.client.controller.HumidityController;
import com.tousinho.client.controller.PumpController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WaterHandler implements Runnable {

    private static final Logger logger = LogManager.getLogger(WaterHandler.class.getName());

    private HumidityController humidityController;
    private PumpController pumpController;

    public WaterHandler(HumidityController humidityController, PumpController pumpController) {
        this.humidityController = humidityController;
        this.pumpController = pumpController;

    }

    @Override
    public synchronized void run() {
        logger.info("Checking if it is time to water");
        if (humidityController.isTimeToWater()) {
            logger.info("it's time to water!");
            pumpController.putWater();
        }
    }
}
