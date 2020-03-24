package com.tousinho.client.controller;

import com.pi4j.io.gpio.*;
import com.tousinho.client.configuration.PumpConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RaspberryPumpControllerTest {
    @Mock
    Pin pin;

    @Mock
    GpioController gpioController;

    @Mock
    GpioPinDigitalOutput resultPin;

    @InjectMocks
    private RaspberryPumpController runnableScheduler;

    PumpConfiguration pumpConfiguration = new PumpConfiguration(RaspiPin.GPIO_01, 1);

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
        raspberryPumpController.putWater();

        InOrder orderVerifier = Mockito.inOrder(resultPin);
        orderVerifier.verify(resultPin).setState(PinState.HIGH);
        orderVerifier.verify(resultPin).setState(PinState.LOW);
    }
}