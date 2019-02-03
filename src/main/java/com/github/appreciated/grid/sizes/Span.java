package com.github.appreciated.grid.sizes;

import com.github.appreciated.grid.exception.NegativeOrZeroValueException;
import com.github.appreciated.grid.interfaces.AreaUnit;
import com.github.appreciated.grid.interfaces.RowOrColUnit;

import java.util.Objects;

public class Span implements RowOrColUnit, AreaUnit {

    private Area area;
    private Integer span;

    public Span(int span) {
        if (span < 1) {
            throw new NegativeOrZeroValueException(span);
        }
        this.span = span;
    }

    public Span(Area area) {
        Objects.requireNonNull(area);
        this.area = area;
    }

    public Span(int span, Area area) {
        Objects.requireNonNull(area);
        if (span < 1) {
            throw new NegativeOrZeroValueException(span);
        }
        this.span = span;
        this.area = area;
    }

    @Override
    public String getValue() {
        if (span != null && area != null) {
            return span + " " + area.getCssValue();
        } else if (span != null) {
            return String.valueOf(span);
        } else {
            return area.getCssValue();
        }
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
