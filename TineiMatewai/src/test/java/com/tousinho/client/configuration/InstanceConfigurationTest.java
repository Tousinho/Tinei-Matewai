package com.tousinho.client.configuration;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;


@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class InstanceConfigurationTest {
    public static final String SENSOR_NAME = "MyName";
    @Mock
    private HumidityConfiguration humidityConfiguration;

    @Mock
    private PumpConfiguration pumpConfiguration;

    @Test
    public void shouldInstance() {
        InstanceConfiguration result = new InstanceConfiguration(SENSOR_NAME, humidityConfiguration, pumpConfiguration);
        Assert.assertNotNull(result);
    }

    @Test
    public void shouldReturnName() {
        InstanceConfiguration result = new InstanceConfiguration(SENSOR_NAME, humidityConfiguration, pumpConfiguration);
        Assert.assertEquals(result.getSensorName(), SENSOR_NAME);
    }

    @Test
    public void shouldReturnHumidityConfiguration() {
        InstanceConfiguration result = new InstanceConfiguration(SENSOR_NAME, humidityConfiguration, pumpConfiguration);
        Assert.assertEquals(result.getHumidityConfiguration(), humidityConfiguration);
    }

    @Test
    public void shouldReturnPumpConfiguration() {
        InstanceConfiguration result = new InstanceConfiguration(SENSOR_NAME, humidityConfiguration, pumpConfiguration);
        Assert.assertEquals(result.getPumpConfiguration(), pumpConfiguration);
    }
}