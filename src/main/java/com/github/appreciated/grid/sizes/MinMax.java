package com.github.appreciated.grid.sizes;

import com.github.appreciated.grid.interfaces.CssGridFunction;
import com.github.appreciated.grid.interfaces.CssGridSize;

import java.util.Arrays;

public class MinMax implements CssGridFunction {

    private CssGridSize[] sizes;

    public MinMax(CssGridSize... sizes) {
        this.sizes = sizes;
    }

    @Override
    public String getValue() {
        return Arrays.stream(sizes).map(CssGridSize::getCssValue).reduce((unit, unit2) -> unit + "," + unit2).orElse("");
    }

    @Override
    public boolean hasSuffix() {
        return true;
    }

    @Override
    public String getSuffixValue() {
        return ")";
    }

    @Override
    public boolean hasPrefix() {
        return true;
    }

    @Override
    public String getPrefixValue() {
        return "minmax(";
    }
}
