package com.tousinho.client;

import com.tousinho.client.configuration.InstanceConfiguration;
import com.tousinho.client.configuration.InstanceConfigurationBuilder;
import com.tousinho.client.configuration.validator.InputArgsValidator;
import com.tousinho.client.controller.MockHumidityController;
import com.tousinho.client.controller.MockPumpController;
import com.tousinho.client.handler.WaterHandler;
import com.tousinho.client.scheduler.RunnableScheduler;
import it.sauronsoftware.cron4j.Scheduler;

public class WaterScheduler {

    private final RunnableScheduler runnableScheduler;
    private final InputArgsValidator inputArgsValidator;
    private final InstanceConfigurationBuilder instanceConfigurationBuilder;

    public static void main(String[] args) {
        new WaterScheduler(new InputArgsValidator(), new InstanceConfigurationBuilder(), new RunnableScheduler(new Scheduler())).run(args);
    }

    public WaterScheduler(InputArgsValidator inputArgsValidator, InstanceConfigurationBuilder instanceConfigurationBuilder, RunnableScheduler runnableScheduler) {
        this.inputArgsValidator = inputArgsValidator;
        this.instanceConfigurationBuilder = instanceConfigurationBuilder;
        this.runnableScheduler = runnableScheduler;
    }

    public void run(String[] args) {
        boolean isValidArgument = validateInputArgs(args, inputArgsValidator);
        if (!isValidArgument){
            return;
        }
        InstanceConfiguration instanceConfiguration = getInstanceConfiguration(args, instanceConfigurationBuilder);
        startAllScheduling(instanceConfiguration, runnableScheduler);
    }


    private static void startAllScheduling(InstanceConfiguration instanceConfiguration, RunnableScheduler runnableScheduler) {
        scheduleWaterHandler(instanceConfiguration, runnableScheduler);
    }

    private static InstanceConfiguration getInstanceConfiguration(String[] args, InstanceConfigurationBuilder instanceConfigurationBuilder) {
        return instanceConfigurationBuilder.build(args[0], args[1], args[2], args[3], args[4]);
    }

    private static boolean validateInputArgs(String[] args, InputArgsValidator inputArgsValidator) {
        boolean validate = inputArgsValidator.validate(args);
        if (!validate) {
            System.out.println("Inputs not valid!");
        }
        return validate;
    }

    private static void scheduleWaterHandler(InstanceConfiguration instanceConfiguration, RunnableScheduler runnableScheduler) {
        runnableScheduler.schedule("*/10 0-6 * * *", new WaterHandler(new MockHumidityController(instanceConfiguration.getHumidityConfiguration()), new MockPumpController(instanceConfiguration.getPumpConfiguration())));
    }
}
