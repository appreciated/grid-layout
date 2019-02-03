package com.github.appreciated.grid.sizes;

import com.github.appreciated.grid.interfaces.CssGridAutoUnit;
import com.github.appreciated.grid.interfaces.CssGridMinMaxUnit;
import com.github.appreciated.grid.interfaces.CssGridTemplateUnit;

public class MinMax implements CssGridAutoUnit, CssGridTemplateUnit {

    private final CssGridMinMaxUnit min;
    private final CssGridMinMaxUnit max;

    public MinMax(CssGridMinMaxUnit min, CssGridMinMaxUnit max) {
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
