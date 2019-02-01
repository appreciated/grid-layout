package com.github.appreciated.grid.sizes;

public class Auto implements CssGridUnit {
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
