package com.tousinho.client.scheduler;

import it.sauronsoftware.cron4j.Scheduler;

public class RunnableScheduler {
    public void schedule(String cronExpression, Runnable runnable) {
        Scheduler s = new Scheduler();
        s.schedule(cronExpression, runnable);
        s.start();
    }
}
