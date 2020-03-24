package com.tousinho.client.controller;

import com.pi4j.io.gpio.RaspiPin;
import com.tousinho.client.configuration.HumidityConfiguration;
import org.junit.Assert;
import org.junit.Test;

public class MockHumidityControllerTest {

    HumidityConfiguration humidityConfiguration = new HumidityConfiguration(RaspiPin.GPIO_00, 0);

    @Test
    public void shouldGetInstance() {
        HumidityController instance = new MockHumidityController(humidityConfiguration);
        Assert.assertNotNull(instance);
    }

    @Test
    public void shouldReturnAIntValueGreaterThan0() {
        HumidityController instance = new MockHumidityController(humidityConfiguration);
        int humidityValue = instance.getHumidityValue();
        Assert.assertTrue(humidityValue >= 0);
    }

    @Test
    public void shouldReturnAIntValueLessThan100() {
        HumidityController instance = new MockHumidityController(humidityConfiguration);
        int humidityValue = instance.getHumidityValue();
        Assert.assertTrue(humidityValue <= 100);
    }

    @Test
    public void ShouldReturnFalseIfValueIsGreaterThreshold() {
        HumidityController instance = new MockHumidityController(new HumidityConfiguration(RaspiPin.GPIO_00, 0));
        boolean timeToWater = instance.isTimeToWater();
        Assert.assertFalse(timeToWater);
    }

    @Test
    public void ShouldReturnTrueIfValueIsLessThreshold() {
        HumidityController instance = new MockHumidityController(new HumidityConfiguration(RaspiPin.GPIO_00, 100));
        boolean timeToWater = instance.isTimeToWater();
        Assert.assertTrue(timeToWater);
    }
}