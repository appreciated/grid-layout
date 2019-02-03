package com.github.appreciated.grid.sizes;

import com.github.appreciated.grid.exception.NegativeValueException;
import com.github.appreciated.grid.interfaces.CssGridSize;

/**
 *
 */
public class Flex implements CssGridSize {

    private double fraction;

    public Flex(double fraction) {
        if (fraction < 0) {
            throw new NegativeValueException(fraction);
        }
        this.fraction = fraction;
    }

    @Override
    public String getValue() {
        return String.valueOf(fraction);
    }

    @Override
    public boolean hasSuffix() {
        return true;
    }

    @Override
    public String getSuffixValue() {
        return "fr";
    }
}
