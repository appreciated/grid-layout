package com.github.appreciated.css.query.values;

import org.junit.Assert;
import org.junit.Test;

public class DeviceHeightAttributesTest {
    @Test
    public void testDeviceHeight() {
        Assert.assertEquals("device-height: 100px", new DeviceHeightAttributes.DeviceHeight("100px").getCssValue());
    }

    @Test
    public void testMinDeviceHeight() {
        Assert.assertEquals("min-device-height: 100px", new DeviceHeightAttributes.MinDeviceHeight("100px").getCssValue());
    }

    @Test
    public void testMaxDeviceHeight() {
        Assert.assertEquals("max-device-height: 100px", new DeviceHeightAttributes.MaxDeviceHeight("100px").getCssValue());
    }
}