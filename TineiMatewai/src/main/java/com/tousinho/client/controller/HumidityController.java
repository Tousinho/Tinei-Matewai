package com.tousinho.client.controller;

import com.tousinho.client.controller.values.HumidityValue;

public interface HumidityController {
    HumidityValue getHumidityValue();
    boolean isTimeToWater();
}
