package com.tousinho.client.controller;

import com.tousinho.client.controller.values.HumidityValue;

public class MockHumidityController implements HumidityController {

    @Override
    public HumidityValue getHumidityValue() {
        return HumidityValue.NEED_WATER;
    }

    @Override
    public boolean isTimeToWater() {
        return getHumidityValue().equals(HumidityValue.NEED_WATER);
    }
}
