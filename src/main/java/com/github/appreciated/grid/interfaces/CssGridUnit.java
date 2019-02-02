package com.github.appreciated.grid.interfaces;

public interface CssGridUnit extends HasCssValue {
    default String getCssValue() {
        return (hasPrefix() ? getPrefixValue() : "") + getValue() + (hasSuffix() ? getSuffixValue() : "");
    }

    default boolean hasPrefix() {
        return false;
    }

    default String getPrefixValue() {
        return null;
    }

    String getValue();

    boolean hasSuffix();

    String getSuffixValue();
}
