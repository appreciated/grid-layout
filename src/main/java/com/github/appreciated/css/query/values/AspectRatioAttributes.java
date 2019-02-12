package com.github.appreciated.css.query.values;

import com.github.appreciated.css.query.MediaQueryUnit;

public interface AspectRatioAttributes {
    class AspectRatio implements MediaQueryUnit {
        private final int width;
        private final int height;

        public AspectRatio(int width, int height) {

            this.width = width;
            this.height = height;
        }

        @Override
        public String getValue() {
            return width + "/" + height;
        }

        @Override
        public boolean hasPrefix() {
            return true;
        }

        @Override
        public String getPrefixValue() {
            return "aspect-ratio: ";
        }
    }

    class MinAspectRatio extends AspectRatioAttributes.AspectRatio {
        public MinAspectRatio(int width, int height) {
            super(width, height);
        }

        @Override
        public String getPrefixValue() {
            return "min-" + super.getPrefixValue();
        }
    }

    class MaxAspectRatio extends AspectRatioAttributes.AspectRatio {
        public MaxAspectRatio(int width, int height) {
            super(width, height);
        }

        @Override
        public String getPrefixValue() {
            return "max-" + super.getPrefixValue();
        }
    }
}
