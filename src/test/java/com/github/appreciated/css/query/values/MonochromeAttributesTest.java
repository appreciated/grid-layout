package com.github.appreciated.css.query.values;

import org.junit.Assert;
import org.junit.Test;

public class MonochromeAttributesTest {
    @Test
    public void testMonochrome() {
        Assert.assertEquals("monochrome: 100", new MonochromeAttributes.Monochrome(100).getCssValue());
    }

    @Test
    public void testMinMonochrome() {
        Assert.assertEquals("min-monochrome: 100", new MonochromeAttributes.MinMonochrome(100).getCssValue());
    }

    @Test
    public void testMaxMonochrome() {
        Assert.assertEquals("max-monochrome: 100", new MonochromeAttributes.MaxMonochrome(100).getCssValue());
    }
}