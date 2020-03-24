package com.tousinho.client.scheduler;

import it.sauronsoftware.cron4j.Scheduler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;


@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class RunnableSchedulerTest {
    @Mock
    private Scheduler scheduler;

    @Mock
    private Runnable runnable;

    @InjectMocks
    private RunnableScheduler runnableScheduler;

    @Test
    public void shouldCall() {
        String cronExpression = "* * * * *";
        runnableScheduler.schedule(cronExpression, runnable);

        Mockito.verify(scheduler, times(1)).schedule(cronExpression, runnable);
        Mockito.verify(scheduler, times(1)).start();
    }
}