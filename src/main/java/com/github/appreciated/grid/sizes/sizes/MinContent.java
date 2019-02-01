package com.github.appreciated.grid.sizes.sizes;

public class MinContent implements CssGridSize {
    @Override
    public String getValue() {
        return "min-content";
    }

    @Override
    public boolean hasSuffix() {
        return false;
    }

    @Override
    public String getSuffixValue() {
        return null;
    }
}
