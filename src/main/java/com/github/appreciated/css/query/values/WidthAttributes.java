package com.github.appreciated.css.query.values;


import com.github.appreciated.css.query.MediaQueryUnit;

public interface WidthAttributes {

    class Width implements MediaQueryUnit {
        private String width;

        public Width(String width) {
            this.width = width;
        }

        @Override
        public String getValue() {
            return width;
        }

        @Override
        public boolean hasPrefix() {
            return true;
        }

        @Override
        public String getPrefixValue() {
            return "width: ";
        }
    }

    class MinWidth extends Width {
        public MinWidth(String width) {
            super(width);
        }

        @Override
        public String getPrefixValue() {
            return "min-" + super.getPrefixValue();
        }
    }

    class MaxWidth extends Width {
        public MaxWidth(String width) {
            super(width);
        }

        @Override
        public String getPrefixValue() {
            return "max-" + super.getPrefixValue();
        }
    }
}