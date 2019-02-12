package com.github.appreciated.css.query.values;

import org.junit.Assert;
import org.junit.Test;

public class HeightAttributesTest {
    @Test
    public void testHeight() {
        Assert.assertEquals("height: 100px", new HeightAttributes.Height("100px").getCssValue());
    }

    @Test
    public void testMinHeight() {
        Assert.assertEquals("min-height: 100px", new HeightAttributes.MinHeight("100px").getCssValue());
    }

    @Test
    public void testMaxHeight() {
        Assert.assertEquals("max-height: 100px", new HeightAttributes.MaxHeight("100px").getCssValue());
    }
}