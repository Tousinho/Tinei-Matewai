package com.tousinho.client.scheduler;

import com.tousinho.client.controller.MockHumidityController;
import com.tousinho.client.controller.MockPumpController;
import com.tousinho.client.handler.WaterHandler;
import it.sauronsoftware.cron4j.Scheduler;

public class RunnableScheduler {
    public void schedule(String cronExpression, Runnable runnable) {
        Scheduler s = new Scheduler();
        s.schedule(cronExpression, runnable);
        s.start();
    }
}
