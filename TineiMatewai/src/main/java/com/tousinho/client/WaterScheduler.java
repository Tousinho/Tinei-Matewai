package com.tousinho.client;

import com.tousinho.client.controller.MockHumidityController;
import com.tousinho.client.controller.MockPumpController;
import com.tousinho.client.handler.WaterHandler;
import com.tousinho.client.scheduler.RunnableScheduler;

public class WaterScheduler {

    public static void main(String[] args) {
        scheduleWaterHandler();
    }

    private static void scheduleWaterHandler() {
        new RunnableScheduler().schedule("*/10 0-6 * * *", new WaterHandler(MockHumidityController.getInstance(), MockPumpController.getInstance()));
    }
}
