package com.github.appreciated.grid.sizes;

import com.github.appreciated.grid.interfaces.CssGridSize;

public class Auto implements CssGridSize {
    @Override
    public String getValue() {
        return "auto";
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
