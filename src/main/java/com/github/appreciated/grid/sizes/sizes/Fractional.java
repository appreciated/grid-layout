package com.github.appreciated.grid.sizes.sizes;

public class Fractional implements CssGridUnit {
    private int fraction;

    public Fractional(int fraction) {
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
