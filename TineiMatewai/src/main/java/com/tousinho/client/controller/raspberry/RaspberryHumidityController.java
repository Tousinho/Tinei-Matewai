package com.tousinho.client.controller.raspberry;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.tousinho.client.configuration.HumidityConfiguration;
import com.tousinho.client.controller.HumidityController;
import com.tousinho.client.controller.values.HumidityValue;

public class RaspberryHumidityController implements HumidityController {

    private final GpioPinDigitalInput humiditySensor;

    public RaspberryHumidityController(GpioController gpio, HumidityConfiguration humidityConfiguration) {
        humiditySensor = gpio.provisionDigitalInputPin(humidityConfiguration.getHumiditySensorPin(), "HumiditySensor");
    }

    @Override
    public HumidityValue getHumidityValue() {
        return humiditySensor.isHigh() ? HumidityValue.WATER_OK : HumidityValue.NEED_WATER;
    }

    @Override
    public boolean isTimeToWater() {
        return getHumidityValue().equals(HumidityValue.NEED_WATER);
    }
}
