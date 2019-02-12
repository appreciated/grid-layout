package com.github.appreciated.css.query.values;

import com.github.appreciated.css.query.MediaQueryUnit;

public class DevicePixelRatio implements MediaQueryUnit {
    private String devicePixelRatio;

    public DevicePixelRatio(String devicePixelRatio) {
        this.devicePixelRatio = devicePixelRatio;
    }

    @Override
    public String getValue() {
        return devicePixelRatio;
    }

    @Override
    public boolean hasPrefix() {
        return true;
    }

    @Override
    public String getPrefixValue() {
        return "device-pixel-ratio: ";
    }
}
