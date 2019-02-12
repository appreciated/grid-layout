package com.github.appreciated.css.query.values;

import com.github.appreciated.css.inteface.CssUnit;

public interface HeightAttributes {
    class Height implements CssUnit {
        private String height;

        public Height(String width) {
            this.height = width;
        }

        @Override
        public String getValue() {
            return height;
        }

        @Override
        public boolean hasPrefix() {
            return true;
        }

        @Override
        public String getPrefixValue() {
            return "height: ";
        }
    }

    class MinHeight extends Height {
        public MinHeight(String height) {
            super(height);
        }

        @Override
        public String getPrefixValue() {
            return "min-" + super.getPrefixValue();
        }
    }

    class MaxHeight extends Height {
        public MaxHeight(String height) {
            super(height);
        }

        @Override
        public String getPrefixValue() {
            return "max-" + super.getPrefixValue();
        }
    }
}

