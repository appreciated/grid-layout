package com.github.appreciated.grid.sizes;

import com.github.appreciated.grid.sizes.sizes.CssGridSize;

public class Area implements CssGridSize {

    private String area;

    public Area(String area) {
        this.area = area;
    }

    @Override
    public String getValue() {
        return String.valueOf(area);
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
