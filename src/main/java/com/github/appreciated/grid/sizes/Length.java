package com.github.appreciated.grid.sizes;

import com.github.appreciated.grid.interfaces.MinMaxUnit;
import com.github.appreciated.grid.interfaces.TemplateRowsAndColsUnit;

public class Length implements TemplateRowsAndColsUnit, MinMaxUnit {

    private String size;

    public Length(String size) {
        this.size = size;
    }

    public Length(int size) {
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
