package com.github.appreciated.grid.entities;

import com.github.appreciated.grid.interfaces.CssGridTemplateUnit;
import com.github.appreciated.grid.interfaces.CssUnit;

import java.util.Arrays;

public abstract class AbstractTemplate implements CssUnit {
    private final CssGridTemplateUnit[] units;

    public AbstractTemplate(CssGridTemplateUnit... unit) {
        this.units = unit;
    }

    @Override
    public String getCssValue() {
        return Arrays.stream(units).map(CssUnit::getCssValue).reduce((unit, unit2) -> unit + " " + unit2).orElse("");
    }

    @Override
    public String getValue() {
        return null;
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
