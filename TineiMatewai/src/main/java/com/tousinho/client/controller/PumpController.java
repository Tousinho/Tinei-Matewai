package com.tousinho.client.controller;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.GpioFactory;

public class PumpController {

    private static PumpController pumpController;
    private final GpioPinDigitalOutput pin;

    public static PumpController getInstance() {
        if (pumpController == null) {
            pumpController = new PumpController();
        }
        return pumpController;
    }

    private PumpController() {
        final Pin gpioPin = RaspiPin.GPIO_01;
        final GpioController gpio = GpioFactory.getInstance();
        pin = gpio.provisionDigitalOutputPin(gpioPin, "Pump", PinState.LOW);
    }

    public PinState getPinState() {
        return pin.getState();
    }

    public void setPinStatusHigh(){
        setStatus(PinState.HIGH);
    }

    public void setPinStatusLow(){
        setStatus(PinState.LOW);
    }

    private void setStatus(PinState pinState) {
        pin.setState(pinState);
    }
}
