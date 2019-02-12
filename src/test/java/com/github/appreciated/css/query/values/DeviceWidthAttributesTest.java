package com.github.appreciated.css.query.values;

import org.junit.Assert;
import org.junit.Test;

public class DeviceWidthAttributesTest {
    @Test
    public void testDeviceWidth() {
        Assert.assertEquals("device-width: 100px", new DeviceWidthAttributes.DeviceWidth("100px").getCssValue());
    }

    @Test
    public void testMinDeviceWidth() {
        Assert.assertEquals("min-device-width: 100px", new DeviceWidthAttributes.MinDeviceWidth("100px").getCssValue());
    }

    @Test
    public void testMaxDeviceWidth() {
        Assert.assertEquals("max-device-width: 100px", new DeviceWidthAttributes.MaxDeviceWidth("100px").getCssValue());
    }
}