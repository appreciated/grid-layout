package com.github.appreciated.css.query.values;

import com.github.appreciated.css.inteface.CssUnit;

public interface ColorAttributes {
    class Color implements CssUnit {
        private int color;

        public Color(int color) {
            this.color = color;
        }

        @Override
        public String getValue() {
            return String.valueOf(color);
        }

        @Override
        public boolean hasPrefix() {
            return true;
        }

        @Override
        public String getPrefixValue() {
            return "color: ";
        }
    }

    class MinColor extends com.github.appreciated.css.query.values.ColorAttributes.Color {
        public MinColor(int color) {
            super(color);
        }

        @Override
        public String getPrefixValue() {
            return "min-" + super.getPrefixValue();
        }
    }

    class MaxColor extends com.github.appreciated.css.query.values.ColorAttributes.Color {
        public MaxColor(int color) {
            super(color);
        }

        @Override
        public String getPrefixValue() {
            return "max-" + super.getPrefixValue();
        }
    }
}
