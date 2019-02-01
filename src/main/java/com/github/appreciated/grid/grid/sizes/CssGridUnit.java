package com.github.appreciated.grid.grid.sizes;

public interface CssGridUnit {
    default String getCssGridValue() {
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
