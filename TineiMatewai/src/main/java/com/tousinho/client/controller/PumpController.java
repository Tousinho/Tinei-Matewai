package com.tousinho.client.controller;

import com.pi4j.io.gpio.PinState;

public interface PumpController {
    PinState getPinState();
    void setPinStatusHigh();
    void setPinStatusLow();
}
