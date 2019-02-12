package com.github.appreciated.css.query.values;

import org.junit.Assert;
import org.junit.Test;

public class DevicePixelRatioTest {
    @Test
    public void testDevicePixelRatio() {
        Assert.assertEquals("device-pixel-ratio: 100px", new DevicePixelRatio("100px").getCssValue());
    }
}