package com.github.appreciated.css.query.values;

import org.junit.Assert;
import org.junit.Test;

public class WidthAttributesTest {
    @Test
    public void testWidth() {
        Assert.assertEquals("width: 100px", new WidthAttributes.Width("100px").getCssValue());
    }

    @Test
    public void testMinWidth() {
        Assert.assertEquals("min-width: 100px", new WidthAttributes.MinWidth("100px").getCssValue());
    }

    @Test
    public void testMaxWidth() {
        Assert.assertEquals("max-width: 100px", new WidthAttributes.MaxWidth("100px").getCssValue());
    }
}