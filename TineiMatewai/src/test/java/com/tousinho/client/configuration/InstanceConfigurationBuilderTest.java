package com.tousinho.client.configuration;

import com.pi4j.io.gpio.RaspiPin;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

public class InstanceConfigurationBuilderTest {

    public static final String MY_NAME = "MyName";
    public static final String HUMIDITY_THRESHOLD = "42";
    public static final String WATER_IN_SECONDS = "10";

    @Test
    public void shouldInstance() {
        InstanceConfiguration result = new InstanceConfigurationBuilder().build(MY_NAME, "1", "2", WATER_IN_SECONDS);
        assertNotNull(result);
    }

    @Test
    public void shouldHumidityConfigurationNotNull() {
        InstanceConfiguration result = new InstanceConfigurationBuilder().build(MY_NAME, "1", "2", WATER_IN_SECONDS);
        assertNotNull(result.getHumidityConfiguration());
    }

    @Test
    public void shouldPumpConfigurationNotNull() {
        InstanceConfiguration result = new InstanceConfigurationBuilder().build(MY_NAME, "1", "2", WATER_IN_SECONDS);
        assertNotNull(result.getPumpConfiguration());
    }

    @Test
    public void shouldReturnName() {
        InstanceConfiguration result = new InstanceConfigurationBuilder().build(MY_NAME, "1", "2", WATER_IN_SECONDS);
        assertEquals(MY_NAME, result.getSensorName());
    }

    @Test
    public void shouldReturnPumpGpio() {
        InstanceConfiguration result = new InstanceConfigurationBuilder().build(MY_NAME, "1", "2", WATER_IN_SECONDS);
        assertEquals(RaspiPin.GPIO_01, result.getPumpConfiguration().getPumpPin());
    }

    @Test
    public void shouldReturnPumpWaterInSeconds() {
        InstanceConfiguration result = new InstanceConfigurationBuilder().build(MY_NAME, "1", "2", WATER_IN_SECONDS);
        assertEquals(Integer.parseInt(WATER_IN_SECONDS), result.getPumpConfiguration().getWaterTimeInSecond());
    }


    @Test
    public void shouldReturnHumidityGpio() {
        InstanceConfiguration result = new InstanceConfigurationBuilder().build(MY_NAME, "1", "2", WATER_IN_SECONDS);
        assertEquals(RaspiPin.GPIO_02, result.getHumidityConfiguration().getHumiditySensorPin());
    }

}