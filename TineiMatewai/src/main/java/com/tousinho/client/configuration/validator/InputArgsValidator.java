package com.tousinho.client.configuration.validator;

public class InputArgsValidator {
    public boolean validate(String[] args) {
        if (args.length != 5) {
            return false;
        }

        if (isNotAGpioValid(args[1])) return false;
        if (isNotAGpioValid(args[2])) return false;
        if ((args[1]).equals(args[2])) return false;
        if (isNotANumber(args[3])) return false;
        return !isNotANumber(args[4]);
    }

    private boolean isNotAGpioValid(String value) {
        int intValue;
        try {
            intValue = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return true;
        }
        return intValue < 0 || intValue > 31;
    }

    private boolean isNotANumber(String value) {
        try {
            Integer.valueOf(value);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }
}
