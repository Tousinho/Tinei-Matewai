package com.tousinho.client.handler;

import com.tousinho.client.controller.HumidityController;
import com.tousinho.client.controller.PumpController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class WaterHandlerTest {
    @Mock
    HumidityController humidityController;

    @Mock
    PumpController pumpController;

    @Test
    public void shouldInstance() {
        WaterHandler waterHandler = new WaterHandler(humidityController, pumpController);
        Assert.assertNotNull(waterHandler);
    }

    @Test
    public void shouldNothingIfThresholdIsGreat() {
        Mockito.when(humidityController.isTimeToWater()).thenReturn(false);
        WaterHandler waterHandler = new WaterHandler(humidityController, pumpController);
        waterHandler.run();

        Mockito.verifyNoInteractions(pumpController);
    }

    @Test
    public void shouldWaterIfThresholdIsLess() {
        Mockito.when(humidityController.isTimeToWater()).thenReturn(true);

        WaterHandler waterHandler = new WaterHandler(humidityController, pumpController);
        waterHandler.run();

        Mockito.verify(pumpController).putWater();
    }
}