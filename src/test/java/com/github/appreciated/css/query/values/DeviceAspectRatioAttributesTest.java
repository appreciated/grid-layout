package com.github.appreciated.css.query.values;

import org.junit.Assert;
import org.junit.Test;

public class DeviceAspectRatioAttributesTest {
    @Test
    public void testDeviceAspectRatio() {
        Assert.assertEquals("device-aspect-ratio: 16/9", new DeviceAspectRatioAttributes.DeviceAspectRatio(16, 9).getCssValue());
    }

    @Test
    public void testMinDeviceAspectRatio() {
        Assert.assertEquals("min-device-aspect-ratio: 16/9", new DeviceAspectRatioAttributes.MinDeviceAspectRatio(16, 9).getCssValue());
    }

    @Test
    public void testMaxDeviceAspectRatio() {
        Assert.assertEquals("max-device-aspect-ratio: 16/9", new DeviceAspectRatioAttributes.MaxDeviceAspectRatio(16, 9).getCssValue());
    }
}