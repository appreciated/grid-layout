package com.github.appreciated.css.query.values;

import com.github.appreciated.css.inteface.CssUnit;

public interface MonochromeAttributes {
    class Monochrome implements CssUnit {
        private int monochrome;

        public Monochrome(int monochrome) {
            this.monochrome = monochrome;
        }

        @Override
        public String getValue() {
            return String.valueOf(monochrome);
        }

        @Override
        public boolean hasPrefix() {
            return true;
        }

        @Override
        public String getPrefixValue() {
            return "monochrome: ";
        }
    }

    class MinMonochrome extends com.github.appreciated.css.query.values.MonochromeAttributes.Monochrome {
        public MinMonochrome(int monochrome) {
            super(monochrome);
        }

        @Override
        public String getPrefixValue() {
            return "min-" + super.getPrefixValue();
        }
    }

    class MaxMonochrome extends com.github.appreciated.css.query.values.MonochromeAttributes.Monochrome {
        public MaxMonochrome(int monochrome) {
            super(monochrome);
        }

        @Override
        public String getPrefixValue() {
            return "max-" + super.getPrefixValue();
        }
    }
}

