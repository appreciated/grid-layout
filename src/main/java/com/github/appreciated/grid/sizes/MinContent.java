package com.github.appreciated.grid.sizes;

import com.github.appreciated.grid.interfaces.AutoRowAndColUnit;
import com.github.appreciated.grid.interfaces.MinMaxUnit;
import com.github.appreciated.grid.interfaces.TemplateRowsAndColsUnit;

public class MinContent implements AutoRowAndColUnit, TemplateRowsAndColsUnit, MinMaxUnit {
    @Override
    public String getValue() {
        return "min-content";
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
