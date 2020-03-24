package com.tousinho.client.controller;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.tousinho.client.configuration.PumpConfiguration;

public class RaspberryPumpController implements PumpController {
    private final GpioPinDigitalOutput pin;
    private final PumpConfiguration pumpConfiguration;


    public RaspberryPumpController(Pin gpioPin,
                                   GpioController gpio,
                                   PumpConfiguration pumpConfiguration) {
        this.pumpConfiguration = pumpConfiguration;
        pin = gpio.provisionDigitalOutputPin(gpioPin, "Pump", PinState.LOW);
    }

    private void setPinStatusHigh() {
        setStatus(PinState.HIGH);
    }

    private void setPinStatusLow() {
        setStatus(PinState.LOW);
    }

    @Override
    public void putWater() {
        setPinStatusHigh();
        sleeping(pumpConfiguration.getWaterTimeInSecond());
        setPinStatusLow();
    }

    private void setStatus(PinState pinState) {
        pin.setState(pinState);
    }

    private void sleeping(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException ignored) {}
    }
}
