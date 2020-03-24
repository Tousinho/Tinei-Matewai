package com.tousinho.client.controller;

import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.PinState;
import com.tousinho.client.configuration.PumpConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RaspberryPumpControllerTest {
    @Mock
    private Pin pin;

    @Mock
    private GpioController gpioController;

    @Mock
    private GpioPinDigitalOutput resultPin;

    private PumpConfiguration pumpConfiguration = new PumpConfiguration(RaspiPin.GPIO_01, 1);

    @Test
    public void shouldInstance() {
        RaspberryPumpController raspberryPumpController = new RaspberryPumpController(pin, gpioController, pumpConfiguration);
        Assert.assertNotNull(raspberryPumpController);
    }

    @Test
    public void shouldInstancePin() {
        RaspberryPumpController raspberryPumpController = new RaspberryPumpController(pin, gpioController, pumpConfiguration);

        Assert.assertNotNull(raspberryPumpController);
    }

    @Test
    public void shouldPutWater() {
        Mockito.doReturn(resultPin).when(gpioController).provisionDigitalOutputPin(Mockito.eq(pin), Mockito.anyString(), Mockito.eq(PinState.LOW));

        RaspberryPumpController raspberryPumpController = new RaspberryPumpController(pin, gpioController, pumpConfiguration);
        Assert.assertNotNull(raspberryPumpController);
        raspberryPumpController.putWater();
        InOrder orderVerifier = Mockito.inOrder(resultPin);
        orderVerifier.verify(resultPin).setState(PinState.HIGH);
        orderVerifier.verify(resultPin).setState(PinState.LOW);
    }
}