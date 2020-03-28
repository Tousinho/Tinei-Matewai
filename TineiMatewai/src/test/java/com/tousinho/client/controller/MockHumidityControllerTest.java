package com.tousinho.client.controller;

import com.tousinho.client.controller.mock.MockHumidityController;
import org.junit.Assert;
import org.junit.Test;

public class MockHumidityControllerTest {

    @Test
    public void shouldGetInstance() {
        HumidityController instance = new MockHumidityController();
        Assert.assertNotNull(instance);
    }


    @Test
    public void shouldReturnTrueAlways() {
        HumidityController instance = new MockHumidityController();
        boolean timeToWater = instance.isTimeToWater();
        Assert.assertTrue(timeToWater);
    }
}