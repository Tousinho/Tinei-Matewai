package com.tousinho.client.controller;

import com.pi4j.io.gpio.*;
import com.tousinho.client.configuration.HumidityConfiguration;
import com.tousinho.client.controller.raspberry.RaspberryHumidityController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RaspberryHumidityControllerTest {
    @Mock
    private Pin pin;

    @Mock
    private GpioController gpioController;

    @Mock
    private GpioPinDigitalInput resultPin;

    @Test
    public void shouldInstance() {
        HumidityConfiguration humidityConfiguration = new HumidityConfiguration(pin);
        RaspberryHumidityController raspberryHumidityController = new RaspberryHumidityController(gpioController, humidityConfiguration);
        Assert.assertNotNull(raspberryHumidityController);
    }

    @Test
    public void shouldReturnNeedWaterIfPinIsLow() {
        Mockito.doReturn(resultPin).when(gpioController).provisionDigitalInputPin(Mockito.eq(pin), Mockito.anyString());
        Mockito.doReturn(false).when(resultPin).isHigh();

        HumidityConfiguration humidityConfiguration = new HumidityConfiguration(pin);
        RaspberryHumidityController raspberryHumidityController = new RaspberryHumidityController(gpioController, humidityConfiguration);

        boolean timeToWater = raspberryHumidityController.isTimeToWater();
        Assert.assertTrue(timeToWater);
    }

    @Test
    public void shouldReturnNoNeedWaterIfPinIsHigh() {
        Mockito.doReturn(resultPin).when(gpioController).provisionDigitalInputPin(Mockito.eq(pin), Mockito.anyString());
        Mockito.doReturn(true).when(resultPin).isHigh();

        HumidityConfiguration humidityConfiguration = new HumidityConfiguration(pin);
        RaspberryHumidityController raspberryHumidityController = new RaspberryHumidityController(gpioController, humidityConfiguration);

        boolean timeToWater = raspberryHumidityController.isTimeToWater();
        Assert.assertFalse(timeToWater);
    }
}