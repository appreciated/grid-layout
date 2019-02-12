package com.github.appreciated.css.query.values;

import com.github.appreciated.css.inteface.CssUnit;

public interface DeviceAspectRatioAttributes {
    class DeviceAspectRatio implements CssUnit {

        private final int width;
        private final int height;

        public DeviceAspectRatio(int width, int height) {
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
            return "device-aspect-ratio: ";
        }
    }

    class MinDeviceAspectRatio extends com.github.appreciated.css.query.values.DeviceAspectRatioAttributes.DeviceAspectRatio {
        public MinDeviceAspectRatio(int width, int height) {
            super(width, height);
        }

        @Override
        public String getPrefixValue() {
            return "min-" + super.getPrefixValue();
        }
    }

    class MaxDeviceAspectRatio extends com.github.appreciated.css.query.values.DeviceAspectRatioAttributes.DeviceAspectRatio {
        public MaxDeviceAspectRatio(int width, int height) {
            super(width, height);
        }

        @Override
        public String getPrefixValue() {
            return "max-" + super.getPrefixValue();
        }
    }
}
