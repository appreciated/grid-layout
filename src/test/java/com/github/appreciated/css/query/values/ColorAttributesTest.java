package com.github.appreciated.css.query.values;

import org.junit.Assert;
import org.junit.Test;

public class ColorAttributesTest {
    @Test
    public void testColor() {
        Assert.assertEquals("color: 1", new ColorAttributes.Color(1).getCssValue());
    }

    @Test
    public void testMinColor() {
        Assert.assertEquals("min-color: 1", new ColorAttributes.MinColor(1).getCssValue());
    }

    @Test
    public void testMaxColor() {
        Assert.assertEquals("max-color: 1", new ColorAttributes.MaxColor(1).getCssValue());
    }
}