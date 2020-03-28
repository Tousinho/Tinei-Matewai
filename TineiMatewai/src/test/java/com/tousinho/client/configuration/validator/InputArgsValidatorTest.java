package com.tousinho.client.configuration.validator;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class InputArgsValidatorTest {

    private String[] valid_args = new String[]{"MyName", "1", "2", "4"};

    @Test
    public void shouldReturnFalseIfArgsAreZero() {
        String[] args = new String[]{};
        boolean result = new InputArgsValidator().validate(args);
        assertFalse(result);
    }

    @Test
    public void shouldReturnFalseIfArgsAreOne() {
        String[] args = new String[]{"One"};
        boolean result = new InputArgsValidator().validate(args);
        assertFalse(result);
    }

    @Test
    public void shouldReturnFalseIfArgsAreTwo() {
        String[] args = new String[]{"One", "Two"};
        boolean result = new InputArgsValidator().validate(args);
        assertFalse(result);
    }

    @Test
    public void shouldReturnFalseIfArgsAreThree() {
        String[] args = new String[]{"One", "Two", "Three"};
        boolean result = new InputArgsValidator().validate(args);
        assertFalse(result);
    }

    @Test
    public void shouldReturnTrueIfArgsAre4() {
        boolean result = new InputArgsValidator().validate(valid_args);
        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueIfArgsAre5() {
        boolean result = new InputArgsValidator().validate(new String[]{"MyName", "1", "2", "4", "5"});
        assertFalse(result);
    }

    @Test
    public void shouldReturnIfArg2IsNotNumber() {
        String[] args = new String[]{"MyName", "NotANumber", "2", "4"};
        boolean result = new InputArgsValidator().validate(args);
        assertFalse(result);
    }

    @Test
    public void shouldReturnIfArg2IsLessThanZero() {
        String[] args = new String[]{"MyName", "-1", "2", "4"};
        boolean result = new InputArgsValidator().validate(args);
        assertFalse(result);
    }

    @Test
    public void shouldReturnIfArc2IsGraterThan31() {
        String[] args = new String[]{"MyName", "32", "2",  "4"};
        boolean result = new InputArgsValidator().validate(args);
        assertFalse(result);
    }

    @Test
    public void shouldReturnTrueIfArc2IsCorrect() {
        String[] args = new String[]{"MyName", "4", "2", "4"};
        boolean result = new InputArgsValidator().validate(args);
        assertTrue(result);
    }

    @Test
    public void shouldReturnIfArg3IsNotNumber() {
        String[] args = new String[]{"MyName", "2", "NotANumber", "4"};
        boolean result = new InputArgsValidator().validate(args);
        assertFalse(result);
    }

    @Test
    public void shouldReturnIfArg3IsLessThanZero() {
        String[] args = new String[]{"MyName", "2", "-1", "4"};
        boolean result = new InputArgsValidator().validate(args);
        assertFalse(result);
    }

    @Test
    public void shouldReturnIfArc3IsGraterThan31() {
        String[] args = new String[]{"MyName", "2", "32", "4"};
        boolean result = new InputArgsValidator().validate(args);
        assertFalse(result);
    }

    @Test
    public void shouldReturnTrueIfArc3IsCorrect() {
        String[] args = new String[]{"MyName", "4", "2", "4"};
        boolean result = new InputArgsValidator().validate(args);
        assertTrue(result);
    }

    @Test
    public void shouldReturnFalseIfArg2And3AreEqual() {
        String[] args = new String[]{"MyName", "4", "4", "4"};
        boolean result = new InputArgsValidator().validate(args);
        assertFalse(result);
    }

    @Test
    public void shouldReturnFalseIfArg4isNotANumber() {
        String[] args = new String[]{"MyName", "4", "2", "NotANumber"};
        boolean result = new InputArgsValidator().validate(args);
        assertFalse(result);
    }
}