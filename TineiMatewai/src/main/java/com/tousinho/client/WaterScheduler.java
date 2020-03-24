package com.tousinho.client;

import com.tousinho.client.configuration.InstanceConfiguration;
import com.tousinho.client.configuration.InstanceConfigurationBuilder;
import com.tousinho.client.configuration.validator.InputArgsValidator;
import com.tousinho.client.controller.MockHumidityController;
import com.tousinho.client.controller.MockPumpController;
import com.tousinho.client.handler.WaterHandler;
import com.tousinho.client.scheduler.RunnableScheduler;
import it.sauronsoftware.cron4j.Scheduler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class WaterScheduler {
    private static final Logger logger = LogManager.getLogger(WaterScheduler.class.getName());

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
        logger.info("Checking input parameter");
        boolean isValidArgument = validateInputArgs(args, inputArgsValidator);
        if (!isValidArgument) {
            logger.info("Input Parameters are not valid!");
            return;
        }
        logger.info("Getting configuration");
        InstanceConfiguration instanceConfiguration = getInstanceConfiguration(args, instanceConfigurationBuilder);
        logger.info("Starting scheduling configuration");
        startAllScheduling(instanceConfiguration, runnableScheduler);
    }


    private static void startAllScheduling(InstanceConfiguration instanceConfiguration, RunnableScheduler runnableScheduler) {
        scheduleWaterHandler(instanceConfiguration, runnableScheduler);
    }

    private static InstanceConfiguration getInstanceConfiguration(String[] args, InstanceConfigurationBuilder instanceConfigurationBuilder) {
        return instanceConfigurationBuilder.build(args[0], args[1], args[2], args[3], args[4]);
    }

    private static boolean validateInputArgs(String[] args, InputArgsValidator inputArgsValidator) {
        return inputArgsValidator.validate(args);
    }

    private static void scheduleWaterHandler(InstanceConfiguration instanceConfiguration, RunnableScheduler runnableScheduler) {
        runnableScheduler.schedule("*/10 0-6 * * *", new WaterHandler(new MockHumidityController(instanceConfiguration.getHumidityConfiguration()), new MockPumpController(instanceConfiguration.getPumpConfiguration())));
    }
}
