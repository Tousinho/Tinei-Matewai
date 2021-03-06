package com.tousinho.client;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.tousinho.client.configuration.InstanceConfigurationBuilder;
import com.tousinho.client.configuration.validator.InputArgsValidator;
import com.tousinho.client.scheduler.RunnableScheduler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotNull;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class WaterSchedulerTest {

    public static final String MY_NAME = "MyName";
    public static final String WATER_IN_SECONDS = "10";

    @Mock
    private InputArgsValidator inputArgsValidator;

    @Mock
    private InstanceConfigurationBuilder instanceConfigurationBuilder;

    @Mock
    private RunnableScheduler runnableScheduler;

    @Mock
    private GpioController gpioController;

    @Mock
    private GpioFactory gpioFactory;

    @Test
    public void shouldInstance() {
        WaterScheduler waterHandler = new WaterScheduler(inputArgsValidator, instanceConfigurationBuilder, runnableScheduler, gpioController);
        assertNotNull(waterHandler);
    }

    @Test
    public void shouldExecuteInOrder() {
        String[] args = {"Name", "1", "2", "3"};

        Mockito.when(inputArgsValidator.validate(args)).thenReturn(true);
        Mockito.when(instanceConfigurationBuilder.build(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(new InstanceConfigurationBuilder().build(MY_NAME, "1", "2", WATER_IN_SECONDS));


        WaterScheduler waterHandler = new WaterScheduler(inputArgsValidator, instanceConfigurationBuilder, runnableScheduler, gpioController);
        waterHandler.run(args);
        assertNotNull(waterHandler);
        InOrder orderVerifier = Mockito.inOrder(inputArgsValidator, instanceConfigurationBuilder, runnableScheduler);
        orderVerifier.verify(inputArgsValidator).validate(args);
        orderVerifier.verify(instanceConfigurationBuilder).build(Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString());
        orderVerifier.verify(runnableScheduler).schedule(Mockito.anyString(), Mockito.any());
    }

    @Test
    public void shouldReturnIfNoValidInput() {
        String[] args = {};

        Mockito.when(inputArgsValidator.validate(args)).thenReturn(false);

        WaterScheduler waterHandler = new WaterScheduler(inputArgsValidator, instanceConfigurationBuilder, runnableScheduler, gpioController);
        waterHandler.run(args);

        Mockito.verify(inputArgsValidator).validate(args);
        Mockito.verifyNoInteractions(instanceConfigurationBuilder);
        Mockito.verifyNoInteractions(runnableScheduler);
    }

//    @Test
//    public void shouldReturnIfArgsIsNotCorrect() {
//        Mockito.when(GpioFactory.getInstance()).thenReturn(null);
//        String[] args = {};
//        WaterScheduler.main(args);
//        assertNotNull(args);
//    }
}