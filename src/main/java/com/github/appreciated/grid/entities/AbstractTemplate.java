package com.github.appreciated.grid.entities;

import com.github.appreciated.grid.interfaces.CssGridUnit;
import com.github.appreciated.grid.interfaces.HasCssValue;

import java.util.Arrays;

public abstract class AbstractTemplate implements HasCssValue {
    private final CssGridUnit[] units;

    public AbstractTemplate(CssGridUnit... unit) {
        this.units = unit;
    }

    @Override
    public String getCssValue() {
        return Arrays.stream(units).map(CssGridUnit::getCssValue).reduce((unit, unit2) -> unit + " " + unit2).orElse("");
    }
}
