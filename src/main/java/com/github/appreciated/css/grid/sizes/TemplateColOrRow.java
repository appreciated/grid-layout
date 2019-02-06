package com.github.appreciated.css.grid.sizes;

import com.github.appreciated.css.grid.interfaces.TemplateRowsAndColsUnit;

import java.util.Objects;

public class TemplateColOrRow implements TemplateRowsAndColsUnit {

    private TemplateRowsAndColsUnit flex;
    private String colOrRowName;

    public TemplateColOrRow(String colOrRowName) {
        this(colOrRowName, null);
    }

    public TemplateColOrRow(String colOrRowName, TemplateRowsAndColsUnit flex) {
        Objects.requireNonNull(colOrRowName);
        this.colOrRowName = colOrRowName;
        this.flex = flex;
    }

    @Override
    public String getValue() {
        return "[" + colOrRowName + "]" + (flex != null ? " " + flex.getCssValue() : "");
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
