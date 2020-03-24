package com.tousinho.client.controller;

import com.tousinho.client.configuration.PumpConfiguration;

public class MockPumpController implements PumpController {
    private final PumpConfiguration pumpConfiguration;

    public MockPumpController(PumpConfiguration pumpConfiguration) {
        this.pumpConfiguration = pumpConfiguration;
    }



    @Override
    public void putWater() {
        sleeping(pumpConfiguration.getWaterTimeInSecond());
    }


    private void sleeping(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException ignored) { }
    }
}
