package com.github.appreciated.css.query.values;

import com.github.appreciated.css.inteface.CssUnit;

public class Orientation implements CssUnit {

    private OrientationType orientationType;

    public Orientation(OrientationType orientationType) {
        this.orientationType = orientationType;
    }

    @Override
    public String getValue() {
        return orientationType.getCssValue();
    }

    @Override
    public boolean hasPrefix() {
        return true;
    }

    @Override
    public String getPrefixValue() {
        return "orientation: ";
    }

    enum OrientationType {
        PORTRAIT("portrait"), LANDSCAPE("landscape");

        private String cssValue;

        OrientationType(String cssValue) {
            this.cssValue = cssValue;
        }

        public String getCssValue() {
            return cssValue;
        }
    }
}
