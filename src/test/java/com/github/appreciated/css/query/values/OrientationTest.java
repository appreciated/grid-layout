package com.github.appreciated.css.query.values;

import org.junit.Assert;
import org.junit.Test;

public class OrientationTest {
    @Test
    public void testOrientation() {
        Assert.assertEquals("orientation: landscape", new Orientation(Orientation.OrientationType.LANDSCAPE).getCssValue());
        Assert.assertEquals("orientation: portrait", new Orientation(Orientation.OrientationType.PORTRAIT).getCssValue());
    }
}