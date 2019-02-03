package com.github.appreciated.css.grid.sizes;

import com.github.appreciated.css.grid.interfaces.AutoRowAndColUnit;
import com.github.appreciated.css.grid.interfaces.MinMaxUnit;
import com.github.appreciated.css.grid.interfaces.TemplateRowsAndColsUnit;

public class MinMax implements AutoRowAndColUnit, TemplateRowsAndColsUnit {

    private final MinMaxUnit min;
    private final MinMaxUnit max;

    public MinMax(MinMaxUnit min, MinMaxUnit max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public String getValue() {
        return min.getCssValue() + "," + max.getCssValue();
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
