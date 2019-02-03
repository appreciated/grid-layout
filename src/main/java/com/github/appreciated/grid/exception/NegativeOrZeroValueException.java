package com.github.appreciated.grid.exception;

import java.util.Arrays;

public class NegativeOrZeroValueException extends RuntimeException {
    public NegativeOrZeroValueException(int... value) {
        super("One the passed values \"" + Arrays.stream(value).mapToObj(operand -> String.valueOf(operand)).reduce((left, right) -> left + ", " + right).orElse("") + "\" is negative or zero. This Constructor requires the parameter to be positive");
    }

    public NegativeOrZeroValueException(double... value) {
        super("One the passed values \"" + Arrays.stream(value).mapToObj(operand -> String.valueOf(operand)).reduce((left, right) -> left + ", " + right).orElse("") + "\" is negative or zero. This Constructor requires the parameter to be positive");
    }
}
