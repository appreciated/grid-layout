package com.github.appreciated.grid.sizes;

import com.github.appreciated.grid.interfaces.CssGridUnit;

public class FitContent implements CssGridUnit {
    public static String FUNCTION_NAME = "fit-content";
    private Size size;

    public FitContent(Size size) {
        this.size = size;
    }

    @Override
    public String getValue() {
        return size.getCssValue();
    }

    @Override
    public boolean hasSuffix() {
        return true;
    }

    @Override
    public String getSuffixValue() {
        return ")";
    }

    @Override
    public boolean hasPrefix() {
        return true;
    }

    @Override
    public String getPrefixValue() {
        return FUNCTION_NAME + "(";
    }

}
