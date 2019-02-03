package com.github.appreciated.grid.sizes;

import com.github.appreciated.grid.interfaces.AreaUnit;
import com.github.appreciated.grid.interfaces.RowOrColUnit;

import java.util.Objects;

public class Span implements RowOrColUnit, AreaUnit {

    private Area area;
    private Integer span;

    public Span(int span) {
        this.span = span;
    }

    public Span(Area area) {
        Objects.requireNonNull(area);
        this.area = area;
    }

    @Override
    public String getValue() {
        return span != null ? String.valueOf(span) : area.getCssValue();
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
