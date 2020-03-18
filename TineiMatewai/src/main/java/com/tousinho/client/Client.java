package com.tousinho.client;

import com.pi4j.io.gpio.*;

public class Client {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("<--Pi4J--> GPIO Control Example ... started.");
        final GpioController gpio = GpioFactory.getInstance();
        final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", PinState.HIGH);
        pin.setShutdownOptions(true, PinState.LOW);
        System.out.println("--> GPIO state should be: ON");
        Thread.sleep(5000);
        pin.low();
        System.out.println("--> GPIO state should be: OFF");
        Thread.sleep(5000);
        pin.toggle();
        System.out.println("--> GPIO state should be: ON");
        Thread.sleep(5000);
        pin.toggle();
        System.out.println("--> GPIO state should be: OFF");
        Thread.sleep(5000);
        System.out.println("--> GPIO state should be: ON for only 1 second");
        pin.pulse(1000, true); // set second argument to 'true' use a blocking call
        gpio.shutdown();
        System.out.println("Exiting ControlGpioExample");
    }
}
