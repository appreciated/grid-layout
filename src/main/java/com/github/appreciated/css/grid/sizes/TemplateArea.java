package com.github.appreciated.css.grid.sizes;

import com.github.appreciated.css.grid.interfaces.RowOrColUnit;
import com.github.appreciated.css.grid.interfaces.TemplateAreaUnit;

/**
 *
 */
public class TemplateArea implements TemplateAreaUnit, RowOrColUnit {

    private String area;

    public TemplateArea(String area) {
        this.area = area;
    }

    @Override
    public String getValue() {
        return String.valueOf(area);
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
