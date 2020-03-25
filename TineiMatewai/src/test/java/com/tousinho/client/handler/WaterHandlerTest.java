package com.tousinho.client.handler;

import com.tousinho.client.controller.HumidityController;
import com.tousinho.client.controller.MetricsController;
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
    private HumidityController humidityController;

    @Mock
    private PumpController pumpController;

    @Mock
    private MetricsController metricsController;

    @Test
    public void shouldInstance() {
        WaterHandler waterHandler = new WaterHandler(humidityController, pumpController, metricsController);
        Assert.assertNotNull(waterHandler);
    }

    @Test
    public void shouldDoNothingIfThresholdIsHigher() {
        Mockito.when(humidityController.isTimeToWater()).thenReturn(false);
        WaterHandler waterHandler = new WaterHandler(humidityController, pumpController, metricsController);
        waterHandler.run();

        Mockito.verifyNoInteractions(pumpController);
    }

    @Test
    public void shouldPutWaterIfThresholdIsLower() {
        Mockito.when(humidityController.isTimeToWater()).thenReturn(true);

        WaterHandler waterHandler = new WaterHandler(humidityController, pumpController, metricsController);
        waterHandler.run();

        Mockito.verify(pumpController).putWater();
    }

    @Test
    public void shouldSaveEventIfThresholdIsLower() {
        Mockito.when(humidityController.isTimeToWater()).thenReturn(true);

        WaterHandler waterHandler = new WaterHandler(humidityController, pumpController, metricsController);
        waterHandler.run();

        Mockito.verify(metricsController).savePutWaterEvent();
    }
}