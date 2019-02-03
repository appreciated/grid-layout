package com.github.appreciated.grid.sizes;

import com.github.appreciated.grid.interfaces.CssGridAreaUnit;
import com.github.appreciated.grid.interfaces.CssGridRowOrColUnit;
import com.github.appreciated.grid.interfaces.CssUnit;

public class Span implements CssGridAreaUnit, CssGridRowOrColUnit {

    private Integer span;

    public Span(int span) {
        this.span = span;
    }

    public Span(CssUnit... units) {

    }

    @Override
    public String getValue() {
        return String.valueOf(span);
    }

    @Override
    public boolean hasSuffix() {
        return false;
    }

    @Override
    public String getSuffixValue() {
        return null;
    }

    @Override
    public boolean hasPrefix() {
        return true;
    }

    @Override
    public String getPrefixValue() {
        return "span ";
    }
}
