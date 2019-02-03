package com.github.appreciated.grid.sizes;

import com.github.appreciated.grid.interfaces.CssGridAreaUnit;
import com.github.appreciated.grid.interfaces.CssGridMinMaxUnit;
import com.github.appreciated.grid.interfaces.CssGridTemplateUnit;

public class Length implements CssGridAreaUnit, CssGridTemplateUnit, CssGridMinMaxUnit {

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
