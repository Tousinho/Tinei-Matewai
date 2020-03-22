package com.tousinho.client.controller;

import org.junit.Assert;
import org.junit.Test;

public class MockHumidityControllerTest {
    @Test
    public void shouldGetInstance() {
        MockHumidityController instance = MockHumidityController.getInstance();
        Assert.assertNotNull(instance);
    }

    @Test
    public void shouldSomeInstance() {
        MockHumidityController instance = MockHumidityController.getInstance();
        MockHumidityController instance2 = MockHumidityController.getInstance();
        Assert.assertEquals(instance, instance2);
    }

    @Test
    public void shouldReturnAIntValueGreaterThan0() {
        MockHumidityController instance = MockHumidityController.getInstance();
        int humidityValue = instance.getHumidityValue();
        Assert.assertTrue(humidityValue >= 0 );
    }

    @Test
    public void shouldReturnAIntValueLessThan100() {
        MockHumidityController instance = MockHumidityController.getInstance();
        int humidityValue = instance.getHumidityValue();
        Assert.assertTrue(humidityValue <= 100 );
    }
}