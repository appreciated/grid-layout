package com.github.appreciated.grid.sizes;

import com.github.appreciated.grid.interfaces.CssGridSize;

public class MaxContent implements CssGridSize {
    @Override
    public String getValue() {
        return "max-content";
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
