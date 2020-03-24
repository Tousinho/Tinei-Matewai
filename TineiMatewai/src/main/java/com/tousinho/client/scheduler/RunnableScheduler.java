package com.tousinho.client.scheduler;

import it.sauronsoftware.cron4j.Scheduler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RunnableScheduler {
    private static final Logger logger = LogManager.getLogger(RunnableScheduler.class.getName());

    private final Scheduler scheduler;

    public RunnableScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public void schedule(String cronExpression, Runnable runnable) {
        logger.info("Starting scheduling " + cronExpression + " of " + runnable.getClass().getName());
        scheduler.schedule(cronExpression, runnable);
        scheduler.start();
    }
}
