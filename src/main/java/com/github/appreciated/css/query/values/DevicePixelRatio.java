package com.github.appreciated.css.query.values;

import com.github.appreciated.css.inteface.CssUnit;

public class DevicePixelRatio implements CssUnit {
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
