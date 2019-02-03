package com.github.appreciated.grid.sizes;

import com.github.appreciated.grid.interfaces.CssGridSize;

public class Size implements CssGridSize {

    private String size;

    public Size(String size) {
        this.size = size;
    }

    public Size(int size) {
        this.size = String.valueOf(size);
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
