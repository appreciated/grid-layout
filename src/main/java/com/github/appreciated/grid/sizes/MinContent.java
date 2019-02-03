package com.github.appreciated.grid.sizes;

import com.github.appreciated.grid.interfaces.CssGridAutoUnit;
import com.github.appreciated.grid.interfaces.CssGridMinMaxUnit;
import com.github.appreciated.grid.interfaces.CssGridTemplateUnit;

public class MinContent implements CssGridAutoUnit, CssGridTemplateUnit, CssGridMinMaxUnit {
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
