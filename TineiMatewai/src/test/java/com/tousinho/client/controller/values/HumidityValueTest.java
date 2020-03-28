package com.tousinho.client.controller.values;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class HumidityValueTest {
    @Test
    public void shouldEqualNeedWater() {
        assertEquals(HumidityValue.NEED_WATER, HumidityValue.NEED_WATER);
    }

    @Test
    public void shouldEqualWaterOk() {
        assertEquals(HumidityValue.WATER_OK, HumidityValue.WATER_OK);
    }

    @Test
    public void shouldNotEqual() {
        assertNotEquals(HumidityValue.WATER_OK, HumidityValue.NEED_WATER);
    }
}