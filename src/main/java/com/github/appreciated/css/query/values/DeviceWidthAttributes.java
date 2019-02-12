package com.github.appreciated.css.query.values;

import com.github.appreciated.css.query.MediaQueryUnit;

public interface DeviceWidthAttributes {
    class DeviceWidth implements MediaQueryUnit {
        private String deviceWidth;

        public DeviceWidth(String deviceWidth) {
            this.deviceWidth = deviceWidth;
        }

        @Override
        public String getValue() {
            return deviceWidth;
        }

        @Override
        public boolean hasPrefix() {
            return true;
        }

        @Override
        public String getPrefixValue() {
            return "device-width: ";
        }
    }

    class MinDeviceWidth extends DeviceWidthAttributes.DeviceWidth {
        public MinDeviceWidth(String deviceWidth) {
            super(deviceWidth);
        }

        @Override
        public String getPrefixValue() {
            return "min-" + super.getPrefixValue();
        }
    }

    class MaxDeviceWidth extends DeviceWidthAttributes.DeviceWidth {
        public MaxDeviceWidth(String deviceWidth) {
            super(deviceWidth);
        }

        @Override
        public String getPrefixValue() {
            return "max-" + super.getPrefixValue();
        }
    }
}
