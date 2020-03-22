package com.tousinho.client.controller;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.GpioFactory;

public class RaspberryPumpController implements PumpController {

    private static RaspberryPumpController pumpController;
    private final GpioPinDigitalOutput pin;

    public static RaspberryPumpController getInstance() {
        if (pumpController == null) {
            pumpController = new RaspberryPumpController();
        }
        return pumpController;
    }

    private RaspberryPumpController() {
        final Pin gpioPin = RaspiPin.GPIO_01;
        final GpioController gpio = GpioFactory.getInstance();
        pin = gpio.provisionDigitalOutputPin(gpioPin, "Pump", PinState.LOW);
    }

    @Override
    public PinState getPinState() {
        return pin.getState();
    }

    @Override
    public void setPinStatusHigh() {
        setStatus(PinState.HIGH);
    }

    @Override
    public void setPinStatusLow() {
        setStatus(PinState.LOW);
    }

    private void setStatus(PinState pinState) {
        pin.setState(pinState);
    }
}
