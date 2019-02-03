package com.github.appreciated.grid.sizes;

import com.github.appreciated.grid.interfaces.CssGridAreaUnit;
import com.github.appreciated.grid.interfaces.CssGridAutoUnit;
import com.github.appreciated.grid.interfaces.CssGridMinMaxUnit;
import com.github.appreciated.grid.interfaces.CssGridTemplateUnit;

public class Auto implements CssGridAreaUnit, CssGridAutoUnit, CssGridTemplateUnit, CssGridMinMaxUnit {
    @Override
    public String getValue() {
        return "auto";
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
