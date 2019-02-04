package com.github.appreciated.css.grid.sizes;

import com.github.appreciated.css.grid.exception.NegativeOrZeroValueException;
import com.github.appreciated.css.grid.interfaces.RowOrColUnit;
import com.github.appreciated.css.grid.interfaces.TemplateAreaUnit;

import java.util.Objects;

public class Span implements RowOrColUnit, TemplateAreaUnit {

    private TemplateArea area;
    private Integer span;

    public Span(int span) {
        if (span < 1) {
            throw new NegativeOrZeroValueException(span);
        }
        this.span = span;
    }

    public Span(TemplateArea area) {
        Objects.requireNonNull(area);
        this.area = area;
    }

    public Span(int span, TemplateArea area) {
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
