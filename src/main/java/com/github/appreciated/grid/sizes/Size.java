package com.github.appreciated.grid.sizes;

public class Size implements CssGridSize {

    private String size;

    public Size(String size) {
        this.size = size;
    }

    @Override
    public String getValue() {
        return size;
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
