package com.github.appreciated.grid.sizes;

import com.github.appreciated.grid.interfaces.CssGridSize;
import com.github.appreciated.grid.interfaces.CssGridUnit;

public class Span implements CssGridSize {

    private Integer span;

    public Span(int span) {
        this.span = span;
    }

    public Span(CssGridUnit... units) {

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
