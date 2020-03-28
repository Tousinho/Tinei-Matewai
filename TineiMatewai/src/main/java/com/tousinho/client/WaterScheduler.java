package com.tousinho.client;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.tousinho.client.configuration.InstanceConfiguration;
import com.tousinho.client.configuration.InstanceConfigurationBuilder;
import com.tousinho.client.configuration.validator.InputArgsValidator;
import com.tousinho.client.controller.MetricsController;
import com.tousinho.client.controller.raspberry.RaspberryHumidityController;
import com.tousinho.client.controller.raspberry.RaspberryPumpController;
import com.tousinho.client.handler.WaterHandler;
import com.tousinho.client.scheduler.RunnableScheduler;
import it.sauronsoftware.cron4j.Scheduler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class WaterScheduler {
    private static final Logger logger = LogManager.getLogger(WaterScheduler.class.getName());

    private final RunnableScheduler runnableScheduler;
    private final GpioController gpioController;
    private final InputArgsValidator inputArgsValidator;
    private final InstanceConfigurationBuilder instanceConfigurationBuilder;

    public static void main(String[] args) {
        new WaterScheduler(new InputArgsValidator(), new InstanceConfigurationBuilder(), new RunnableScheduler(new Scheduler()), GpioFactory.getInstance()).run(args);
    }

    public WaterScheduler(InputArgsValidator inputArgsValidator, InstanceConfigurationBuilder instanceConfigurationBuilder, RunnableScheduler runnableScheduler, GpioController gpioController) {
        this.inputArgsValidator = inputArgsValidator;
        this.instanceConfigurationBuilder = instanceConfigurationBuilder;
        this.runnableScheduler = runnableScheduler;
        this.gpioController = gpioController;
    }

    public void run(String[] args) {
        logger.info("Checking input parameter");
        boolean isValidArgument = validateInputArgs(args, inputArgsValidator);
        if (!isValidArgument) {
            logger.info("Input Parameters are not valid!");
            logger.info("Input Parameters should be: <Sensor_Name> <Pump_GPIO_Num> <Humidity_Sensor_GPIO_Num> <Water_In_Seconds>");
            return;
        }
        logger.info("Getting configuration");
        InstanceConfiguration instanceConfiguration = getInstanceConfiguration(args, instanceConfigurationBuilder);
        logger.info("Starting scheduling configuration");
        startAllScheduling(instanceConfiguration, runnableScheduler, gpioController);
    }


    private static void startAllScheduling(InstanceConfiguration instanceConfiguration, RunnableScheduler runnableScheduler, GpioController gpioController) {
        scheduleWaterHandler(instanceConfiguration, runnableScheduler, gpioController);
    }

    private static InstanceConfiguration getInstanceConfiguration(String[] args, InstanceConfigurationBuilder instanceConfigurationBuilder) {
        return instanceConfigurationBuilder.build(args[0], args[1], args[2], args[3]);
    }

    private static boolean validateInputArgs(String[] args, InputArgsValidator inputArgsValidator) {
        return inputArgsValidator.validate(args);
    }

    private static void scheduleWaterHandler(InstanceConfiguration instanceConfiguration, RunnableScheduler runnableScheduler, GpioController gpioController) {
        runnableScheduler.schedule("* * * * *", new WaterHandler(new RaspberryHumidityController(gpioController, instanceConfiguration.getHumidityConfiguration()), new RaspberryPumpController(gpioController, instanceConfiguration.getPumpConfiguration()), new MetricsController(instanceConfiguration.getSensorName())));
    }
}
