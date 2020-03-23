package com.tousinho.client;

import com.tousinho.client.configuration.InstanceConfiguration;
import com.tousinho.client.configuration.InstanceConfigurationBuilder;
import com.tousinho.client.configuration.validator.InputArgsValidator;
import com.tousinho.client.controller.MockHumidityController;
import com.tousinho.client.controller.MockPumpController;
import com.tousinho.client.handler.WaterHandler;
import com.tousinho.client.scheduler.RunnableScheduler;

public class WaterScheduler {

    public static void main(String[] args) {
        validateInputArgs(args);
        InstanceConfiguration instanceConfiguration = getInstanceConfiguration(args);
        scheduleWaterHandler(instanceConfiguration);
    }

    private static InstanceConfiguration getInstanceConfiguration(String[] args) {
        return new InstanceConfigurationBuilder().build(args[0], args[1], args[2], args[3], args[4]);
    }

    private static void validateInputArgs(String[] args) {
        boolean validate = new InputArgsValidator().validate(args);
        if (!validate) {
            System.out.println("Inputs not valid!");
            System.exit(1);
        }
    }

    private static void scheduleWaterHandler(InstanceConfiguration instanceConfiguration) {
        new RunnableScheduler().schedule("*/10 0-6 * * *", new WaterHandler(MockHumidityController.getInstance(), MockPumpController.getInstance()));
    }
}
