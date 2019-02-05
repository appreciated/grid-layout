package com.github.appreciated.css.grid.sizes;

import com.github.appreciated.css.grid.interfaces.RowOrColUnit;
import com.github.appreciated.css.grid.interfaces.TemplateAreaUnit;

/**
 * The implementation of <a href="https://developer.mozilla.org/de/docs/Web/CSS/custom-ident">custom-ident</a>
 */
public class CustomIdent implements TemplateAreaUnit, RowOrColUnit {

    private Integer length;
    private String identifier;
    private CustomIdentSuffix suffix;


    public CustomIdent(String identifier) {
        this(null, identifier, CustomIdentSuffix.NONE);
    }

    public CustomIdent(Integer length, String identifier, CustomIdentSuffix suffix) {
        this.length = length;
        this.identifier = identifier;
        this.suffix = suffix;
    }

    public CustomIdent(String identifier, CustomIdentSuffix suffix) {
        this(null, identifier, suffix);
    }

    public CustomIdent(Integer length, String identifier) {
        this(length, identifier, CustomIdentSuffix.NONE);
    }

    @Override
    public String getValue() {
        return length == null ? identifier : length + " " + identifier;
    }

    @Override
    public boolean hasSuffix() {
        return suffix != CustomIdentSuffix.NONE;
    }

    @Override
    public String getSuffixValue() {
        return suffix.getSuffix();
    }

    enum CustomIdentSuffix {
        NONE(""), START("-start"), END("-end");

        private String suffix;

        CustomIdentSuffix(String suffix) {
            this.suffix = suffix;
        }

        public String getSuffix() {
            return suffix;
        }
    }

}
