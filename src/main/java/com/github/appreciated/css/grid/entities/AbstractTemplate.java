package com.github.appreciated.css.grid.entities;

import com.github.appreciated.css.grid.interfaces.CssUnit;
import com.github.appreciated.css.grid.interfaces.TemplateRowsAndColsUnit;

import java.util.Arrays;

public abstract class AbstractTemplate implements CssUnit {
    private final TemplateRowsAndColsUnit[] units;

    public AbstractTemplate(TemplateRowsAndColsUnit... unit) {
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
