package com.tousinho.client.scheduler;

import it.sauronsoftware.cron4j.Scheduler;

public class RunnableScheduler {
    private final Scheduler scheduler;

    public RunnableScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public void schedule(String cronExpression, Runnable runnable) {
        scheduler.schedule(cronExpression, runnable);
        scheduler.start();
    }
}
