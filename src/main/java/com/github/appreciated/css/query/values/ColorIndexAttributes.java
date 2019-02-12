package com.github.appreciated.css.query.values;

import com.github.appreciated.css.inteface.CssUnit;

public interface ColorIndexAttributes {
    class ColorIndex implements CssUnit {
        private int colorIndex;

        public ColorIndex(int colorIndex) {
            this.colorIndex = colorIndex;
        }

        @Override
        public String getValue() {
            return String.valueOf(colorIndex);
        }

        @Override
        public boolean hasPrefix() {
            return true;
        }

        @Override
        public String getPrefixValue() {
            return "color-index: ";
        }
    }
}
