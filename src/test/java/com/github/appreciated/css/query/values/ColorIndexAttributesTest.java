package com.github.appreciated.css.query.values;

import org.junit.Assert;
import org.junit.Test;

public class ColorIndexAttributesTest {
    @Test
    public void testColorIndex() {
        Assert.assertEquals("color-index: 1", new ColorIndexAttributes.ColorIndex(1).getCssValue());
        Assert.assertEquals("color-index: 2", new ColorIndexAttributes.ColorIndex(2).getCssValue());
    }
}