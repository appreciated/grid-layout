package com.github.appreciated.css.grid.sizes;

import com.github.appreciated.css.grid.interfaces.MinMaxUnit;
import com.github.appreciated.css.grid.interfaces.TemplateRowsAndColsUnit;

/**
 * A wrapper which is supposed to contain a <a href="https://developer.mozilla.org/en-US/docs/Web/CSS/length">length</a> or a <a href="https://developer.mozilla.org/en-US/docs/Web/CSS/percentage">percentage</a>
 */
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
